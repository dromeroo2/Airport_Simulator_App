package parte1;

import java.util.Random;

import static java.lang.Math.*;

public class Avion extends Thread {
    
    private String identificador;
    private Aeropuerto LEMD;
    private Aeropuerto LEBL;    
    private Aeropuerto aeropuerto;
    private Aerovia LEMDtoLEBL;
    private Aerovia LEBLtoLEMD;
    private Aerovia aerovia;
    
    //private String ubicacion;
    private short pasajeros=0;
    private short capacidad=0;
    private short aterrizajes=0; // Para los 15 intentos de coger a los máximos pasajeros    
    private short embarques=0; // Para los 3 intentos de coger al máximo número de pasajeros
    private String ubicacion;
    private String nombreAeropuerto;
    private boolean despegue; // Para controlar si el avión es SALIDA o LLEGADA
    private short numPuertaEmbarque=-1;
    private short numPista=0;    
    final private short MAXIMA_CAPACIDAD=300;
    final private short MINIMA_CAPACIDAD=100;
    final private short VUELOS_PARA_REVISION=15;
    final private short MAX_ESPERAS_EMBARQUE=3;
    final private short TIEMPO_MAXIMO_ESPERA_PUERTA_LIBRE=3;
    final private short TIEMPO_MAXIMO_EMBARQUE_PASAJEROS=3;
    final private short TIEMPO_MAXIMO_ESPERA_PASAJEROS=5;
    final private short TIEMPO_MAXIMO_DESEMBARQUE_PASAJEROS=5;
    
        
    //public Avion(int numero, Aeropuerto aeropuerto){
    public Avion(int numero, Aeropuerto LEMD, Aeropuerto LEBL, Aerovia LEMDtoLEBL, Aerovia LEBLtoLEMD ){
        identificador = generarID(numero);
        this.LEMD=LEMD;
        this.LEBL=LEBL;
        this.LEMDtoLEBL=LEMDtoLEBL;
        this.LEBLtoLEMD=LEBLtoLEMD;
        if (numero%2==0) {
            this.aeropuerto=LEMD;
            //this.aerovia=LEMDtoLEBL;
            nombreAeropuerto="LEMD";
        } else {
            this.aeropuerto=LEBL;
            //this.aerovia=LEBLtoLEMD;
            nombreAeropuerto="LEBL";
        }
        this.numPista=-1;
        
        despegue=true;
        //Creamos la capacidad en pasajeros:
        Random random = new Random();
        capacidad = (short) ((short) random.nextInt((MAXIMA_CAPACIDAD - MINIMA_CAPACIDAD) + 1) + MINIMA_CAPACIDAD);
        
        this.aeropuerto.escribirLog("Se ha creado el Avión " + this.identificador + " con capacidad para " + capacidad + " pasajeros.");
    }    
    
    private String generarID(int numero) {                
        Random random = new Random();
        char[] caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(caracteres[random.nextInt(caracteres.length)]);
        sb.append(caracteres[random.nextInt(caracteres.length)]);
        sb.append("-");
        sb.append(String.format("%04d", numero));
        return sb.toString();
    }
    
    public String getID(){
        return identificador; 
    }
    
    public boolean esDespegue() {
        return despegue;
    }
    
    public short getPasajeros() {
        return pasajeros;
    }
    
    public short getAterrizajes() {
        return aterrizajes;
    }
    
    public short getPista() {
        return numPista;
    }
    
    public void meterEnHangar() {
        aeropuerto.hangar.guardar(this);
        ubicacion="Hangar";
    }
    
    public void sacarDeHangar() {
        aeropuerto.hangar.sacar(this);
        ubicacion="Plataforma";        
    }
    
    public void aparcarEnPlataforma() {
        
        aeropuerto.plataforma.añadir(this);
        ubicacion="Plataforma";
        //Simula la espera a que esté la puerta libre, que hemos puesto entre 3 y 1 segundos
        aeropuerto.plataforma.aparcado(this);        
    }
    
    public synchronized boolean getPuertaEmbarque() {
        aeropuerto.interfaz.comprobarPausa();        
        if ((aeropuerto.plataforma.getPrimero()!=null && aeropuerto.plataforma.getPrimero().equals(this)) || aeropuerto.rodaje.pertenece(this)) {
            //si soy el siguiente de la cola(despegues) o estoy en la lista de rodaje de aterrizaje, 
            //  entonces miro qué puerta está libre para ocuparla:
            
            for (short i=0; i<aeropuerto.getNumPuertas(); i++) {
                //Saltamos la puerta que no sirva para el fin del avión: despegue o aterrizaje:

                if ((despegue && i!=1) || (!despegue && i!=0)) {
                    aeropuerto.escribirLog("El avión " + identificador + " de " + aeropuerto.getCodigoOACI() + " pregunta por la puerta " + aeropuerto.arrayEmbarques[i].getNombre() + ".") ;
                    if (!aeropuerto.arrayEmbarques[i].ocupado.get()) {                            
                        // saco el avión de la Plataforma o del rodaje:
                        aeropuerto.escribirLog("El avión " + identificador + " de " + aeropuerto.getCodigoOACI() + " ocupa la puerta " + aeropuerto.arrayEmbarques[i].getNombre() + ".") ;
                        if (despegue) { 
                            aeropuerto.plataforma.sacarCola();
                            aeropuerto.plataforma.actualizarInterfaz(despegue);
                        } else {
                            aeropuerto.rodaje.sacar(this, despegue);
                            aeropuerto.rodaje.actualizarInterfaz(despegue, pasajeros);                                
                        }
                        // ocupo la puerta:
                        aeropuerto.arrayEmbarques[i].ocupado.compareAndSet(false, true);
                        aeropuerto.arrayEmbarques[i].setIdAvion(identificador);
                        //Actualizo las variables del avión respecto a la puerta de embarque:
                        numPuertaEmbarque=i;
                        ubicacion = "Puerta";
                        //aeropuerto.arrayEmbarques[i].actualizarInterfaz(capacidad, pasajeros);
                        //Según sea depegue o no, actualizamos los pasajeros                            
                        if (despegue) {
                            embarcarPasajeros();
                        } else {                                
                            desembarcarPasajeros();                                
                        }                            
                    }
                }
                if (ubicacion.equals("Puerta")) {
                    break;
                }
            }            
        } 
        return (ubicacion.equals("Puerta"));
    }
    
    public void esperarPuertaLibre() {
        aeropuerto.interfaz.comprobarPausa();
        try{
            //Simula la espera a que esté la puerta libre, que hemos puesto entre 3 y 1 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_ESPERA_PUERTA_LIBRE*1000)-1000+1)+1000));
        }
        catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en la espera de la puerta a " + (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCodigoOACI()));
        }        
    }
    
    public boolean avionLleno() {
        aeropuerto.interfaz.comprobarPausa();        
        return (pasajeros == capacidad);
    }
    
    public void embarcarPasajeros() {
        aeropuerto.interfaz.comprobarPausa();
        try{
            embarques++; 
            if (aeropuerto.pasajeros.get() >= (capacidad-pasajeros)){
                // caso base, restamos a aeropuerto los pasajeros que se montan en el avión
                aeropuerto.pasajeros.addAndGet(-(capacidad-pasajeros));
                pasajeros = capacidad; // Llenamos el avión.                
                aeropuerto.escribirLog("El avión " + identificador + " de " + aeropuerto.getCodigoOACI() + " se ha llenado y abandona la puerta de embarque.") ;
            } else { // caso el avión no se ha llenado, sumo los pasajeros que hay en el aeropuerto a los que ya tenga embarcado
                pasajeros += (short)aeropuerto.pasajeros.get();
                aeropuerto.pasajeros.set(0);                               
                aeropuerto.escribirLog("El avión " + identificador + " de " + aeropuerto.getCodigoOACI() + " lleva " + pasajeros + " pasajeros pero no se ha llenado en su "+embarques+"º intento.") ;
            }
            aeropuerto.arrayEmbarques[numPuertaEmbarque].actualizarInterfaz(despegue, capacidad, pasajeros);
            aeropuerto.interfaz.setTextoAforoAeropuerto(this.aeropuerto);
            //Simula el tiempo del embarque de los pasajeros, que es entre 3 y 1 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_EMBARQUE_PASAJEROS*1000)-1000+1)+1000));         
        } catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en la espera de los pasajeros en " + aeropuerto.getCodigoOACI());
        } finally {                   
            //aeropuerto.arrayEmbarques[numPuertaEmbarque].actualizarInterfaz(capacidad, pasajeros);
            
        }
    }
    
    public void desembarcarPasajeros() {
        aeropuerto.interfaz.comprobarPausa();
        
        aeropuerto.arrayEmbarques[numPuertaEmbarque].actualizarInterfaz(despegue, capacidad, pasajeros);
        aeropuerto.pasajeros.addAndGet(pasajeros);
        aeropuerto.escribirLog("El avión " + identificador + " de " + aeropuerto.getCodigoOACI() + " ha desembarcado a " + pasajeros + " pasajeros.") ;
        pasajeros = 0;
        aeropuerto.setHayAterrizajes(); //Tengo poner que el aeropuerto ya tuvo aterrizajes para que los autobuses empiecen a llevarse gente del aeropuerto a la ciudad        
        aeropuerto.interfaz.setTextoAforoAeropuerto(this.aeropuerto);
        try{            
            //Simula el tiempo del desembarque de los pasajeros, que es entre 5 y 1 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_DESEMBARQUE_PASAJEROS*1000)-1000+1)+1000));         
        } catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en el desembarque de los pasajeros en " + aeropuerto.getCodigoOACI());
        } finally {
            
        }
    }
    
    public void esperarPasajeros() {
        aeropuerto.interfaz.comprobarPausa();
        try{
            //Simula la espera a que haya pasajeros suficientes en el aeropuerto, que es entre 5 y 1 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_ESPERA_PASAJEROS*1000)-1000+1)+1000));         
        } catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en la espera de los pasajeros en " + aeropuerto.getCodigoOACI());
        } finally {
            embarcarPasajeros();            
        }
    }
    
    public void liberarPuertaEmbarque() {
        aeropuerto.interfaz.comprobarPausa();
        short numPuerta=-1;
        for (short i=0; i<aeropuerto.getNumPuertas(); i++) {
            if (aeropuerto.arrayEmbarques[i].getIdAvion()==identificador) {
                aeropuerto.arrayEmbarques[i].ocupado.compareAndSet(true, false);
                aeropuerto.escribirLog("El avión " + getID() + " ha liberado la puerta de embarque " + aeropuerto.arrayEmbarques[i].getNombre() + " de " + aeropuerto.getCodigoOACI() + ".");
                aeropuerto.arrayEmbarques[i].setIdAvion("");
                //Actualizo laa variable del avión respecto a la puerta de embarque:
                aeropuerto.arrayEmbarques[numPuertaEmbarque].actualizarInterfaz(despegue, capacidad, pasajeros);
                numPuertaEmbarque=-1;                
                aeropuerto.arrayEmbarques[i].actualizarInterfaz(despegue, capacidad, pasajeros);
                break;
            }
        }        
    }    
    
    public void entrarEnRodaje() {        
        aeropuerto.rodaje.añadir(this, despegue);
        ubicacion="Rodaje";
    }
        
    public void rodar() {        
        aeropuerto.rodaje.rodar(this);        
    }
        
    public void solicitarPista() {
        aeropuerto.interfaz.comprobarPausa();        
        while ((despegue && ubicacion.equals("Rodaje")) || (!despegue && ubicacion.equals("Vuelo"))) {
            // Intentamos usar una pista disponible              
            //for (Pista pista : aeropuerto.arrayPistas) {
            for (short i=0; i<aeropuerto.arrayPistas.length; i++) {
                //Solo opto a la pista si tiene la misma configuración (D/A) que el avión, y si está abierta:
                //if (aeropuerto.arrayPistas[i].esDespegue()==despegue && aeropuerto.arrayPistas[i].abierta.get()) {
                if (aeropuerto.arrayPistas[i].abierta.get()) {
                    aeropuerto.escribirLog("El avión " + getID() + (despegue?" ":" volando ") + "pregunta por la pista " + (aeropuerto.arrayPistas[i].getID()+1) + " de " + aeropuerto.getCodigoOACI() + ".");
                    if (aeropuerto.arrayPistas[i].libre.get()) {
                        aeropuerto.arrayPistas[i].libre.compareAndSet(true,false);
                        
                        //Pongo en la pista qué avión lo ha adquirido
                        aeropuerto.arrayPistas[i].setIdAvion(getID());
                        //Pongo en el avión en qué pista está_
                        numPista = i;
                        ubicacion = "Pista";
                        aeropuerto.escribirLog("El avión " + getID() + " ha conseguido la pista " + (numPista+1) + " para " + (despegue?"despegue":"aterrizaje") + " en " + aeropuerto.getCodigoOACI() + ".");
                        break; // Salimos del bucle cuando hayamos usado una pista
                    }
                } 
                
            }
            if (ubicacion=="Rodaje" || ubicacion=="Vuelo"){
                aeropuerto.escribirLog("El avión " + getID() + " no ha conseguido pista libre para " + (despegue?"despegue":"aterrizaje") + " en " + aeropuerto.getCodigoOACI() + ".");                
                if (ubicacion=="Rodaje"){
                    aeropuerto.rodaje.esperarPista(this);                    
                } else if (ubicacion=="Vuelo") {
                    aerovia.orbitar(this,nombreAeropuerto);
                } 
            } 
        }        
        if (despegue){
            aeropuerto.rodaje.sacar(this, despegue);
        } else {
            aerovia.sacar(this, nombreAeropuerto);
        }
    }
    
    public void esperarPista() {
          aeropuerto.rodaje.esperarPista(this);
    }    
    
    public void entrarEnPista() {
        aeropuerto.interfaz.comprobarPausa();
        aeropuerto.arrayPistas[numPista].entrarEnPista(this);        
    }
    
    public void despegar() {
        aeropuerto.interfaz.comprobarPausa();
        aeropuerto.arrayPistas[numPista].despegar(this);
        aeropuerto.arrayPistas[numPista].libre.compareAndSet(false, true);
        numPista=-1;                
    }
        
    public void volar() {
        aeropuerto.interfaz.comprobarPausa();
        aeropuerto=null;
        ubicacion="Vuelo";
        //Desasigno el aeropuerto al avión, en estos momentos está en el limbo.
        if (nombreAeropuerto=="LEMD"){
            aerovia=LEMDtoLEBL;
            aerovia.añadir(this, "LEBL");
            aerovia.volar(this, "LEBL");
            aeropuerto=LEBL;
            nombreAeropuerto="LEBL";            
        } else {
            aerovia=LEBLtoLEMD;
            aerovia.añadir(this, "LEMD");
            aerovia.volar(this, "LEMD");
            aeropuerto=LEMD;
            nombreAeropuerto="LEMD";
        }
        despegue=!despegue;
    }
        
    public void orbitar() {
        aerovia.orbitar(this, nombreAeropuerto);
    }
        
    public void aterrizar() {
        aeropuerto.interfaz.comprobarPausa();
        aeropuerto.arrayPistas[numPista].aterrizar(this);
        numPista=-1;
        aterrizajes++;        
    }
    
    private void revisar() {
        aeropuerto.taller.solicitarTaller(this);
        aeropuerto.plataforma.sacarLista(this);
        aeropuerto.taller.atravesarPuertaTaller(this);
        aeropuerto.taller.revisar(this);
        aeropuerto.taller.atravesarPuertaTaller(this);        
    }    
    
    private boolean tieneQueRepostar() {
        Random repostar = new Random();
        return repostar.nextBoolean();
    }
    
    public void repostar(){        
        meterEnHangar();        
        aeropuerto.hangar.repostar(this);
        sacarDeHangar();
    }
        
    @Override
    public void run(){
        
        meterEnHangar();
        sacarDeHangar();
        aparcarEnPlataforma();
        
        //Se repite INFINITAMENTE:
        while (true) {            
            
            while (!getPuertaEmbarque()) {
                esperarPuertaLibre();
            }
                        
            while (!avionLleno() && embarques<MAX_ESPERAS_EMBARQUE) {
                esperarPasajeros();
            }
                        
            liberarPuertaEmbarque();            
            
            entrarEnRodaje();            
            rodar(); // checklist de 1-5 segs
            solicitarPista();
            while (getPista()<0) {
                esperarPista(); // 1-5 segs
            }

            entrarEnPista(); //checklist 1-3 segs
            
            despegar(); // 1-5 segs
            volar(); /// 15-30 segs 
            solicitarPista();
            while (getPista()<0) {
                orbitar(); // 1-5 segs
                solicitarPista();
            }
            
            aterrizar(); // 1-5 segs            
            entrarEnRodaje();
            
            rodar(); // 3-5 segs            
            
            while (!getPuertaEmbarque()) {
                esperarPuertaLibre();
            }
            
            liberarPuertaEmbarque();
            
            aparcarEnPlataforma();
                        
            revisar(); //puerta + Taller + puerta
            
            if (tieneQueRepostar()){                
                repostar(); //En el Hangar                                               
            } 
            
            despegue=true;
            
            aparcarEnPlataforma();
            
        }  //Fin while      
    }
}
