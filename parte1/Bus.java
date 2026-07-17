package parte1;

import java.util.Random;

public class Bus extends Thread {
    private String identificador;
    private Aeropuerto aeropuerto;
    //private String ubicacion;
    private short pasajeros=0;
    private String ubicacion="ciudad";
    private final short MAXIMO_PASAJEROS=50;
    private final short TIEMPO_MAXIMO_RECOGIDA=5;
    private final short TIEMPO_MINIMO_RECOGIDA=2;
    private final short TIEMPO_MAXIMO_TRAYECTO=10;
    private final short TIEMPO_MINIMO_TRAYECTO=5;    
    
    public Bus(int identificador, Aeropuerto aeropuerto){
        this.identificador="B-"+(String.format("%04d", identificador)); 
        this.aeropuerto=aeropuerto;
        this.aeropuerto.escribirLog("Se ha creado el bus "+this.identificador);
    }

    public void recogerPasajeros() {        
        this.aeropuerto.interfaz.comprobarPausa();
        
        try{
            //Simula la espera de entre 2 y 5 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_RECOGIDA*1000)-(TIEMPO_MINIMO_RECOGIDA*1000)+1)+(TIEMPO_MINIMO_RECOGIDA*1000)));
            //contamos a los pasajeros que se han subido (aleatorio entre 0 y 50),
            //  vigilando de que no se pueda coger más gente de la que tenga el aerouerto:
            pasajeros=0;
            if (ubicacion.equals("aeropuerto")) {
                //Resto pasajeros al aeropuerto si al menos una vez ya hubo desembarque de pasajeros:
                if (aeropuerto.getHayAterrizajes()) {
                    //Nunca recogemos más pasajeros que aforo tenga el aeropuerto:
                    pasajeros=(short)Math.floor(Math.random()*((Math.min(MAXIMO_PASAJEROS, aeropuerto.pasajeros.get()))));
                    aeropuerto.pasajeros.addAndGet(-pasajeros);
                    this.aeropuerto.interfaz.setTextoAforoAeropuerto(this.aeropuerto);
                }
            } else {
                pasajeros=(short)Math.floor(Math.random()*50+1);
            }
        }
        catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El autobús " + identificador + " tuvo problemas en la recogida de pasajeros en " + (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCiudad()));
        }
        finally{
            //System.out.println("El autobús " + identificador + " ha recogido a " + pasajeros + " pasajeros.");
            aeropuerto.escribirLog("El autobús " + identificador + " ha recogido a " + pasajeros + " pasajeros en " +
                                    (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCodigoOACI()) +
                                    (ubicacion=="aeropuerto"?(". Aforo: " + aeropuerto.pasajeros.get()):""));
        }
    }    
    
    public void transitar() {
        this.aeropuerto.interfaz.comprobarPausa();
        if (ubicacion=="ciudad") {
                aeropuerto.paradaCiudad.salir(this);                
            } else {
                aeropuerto.paradaAeropuerto.salir(this);
            }
        try{
            //Simula el tránsito ciudad-aeropuerto o viceversa, que es entre 5 y 10 segundos
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_TRAYECTO*1000)-(TIEMPO_MINIMO_TRAYECTO*1000)+1)+(TIEMPO_MINIMO_TRAYECTO*1000)));
            //contamos a los pasajeros que se han subido (aleatorio entre 0 y 50):
            ubicacion=(ubicacion=="ciudad"?"aeropuerto":"ciudad");
        }
        catch(InterruptedException e){
            aeropuerto.escribirLog("ERROR: El autobús " + identificador + " tuvo problemas en el tránsito a " + (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCodigoOACI()));
        }
        finally{
            this.aeropuerto.interfaz.comprobarPausa();
            //System.out.println("El autobús " + identificador + " ha llegado a la parada de " + (ubicacion=="ciudad"?aeropuerto.ciudad:aeropuerto.codigoOACI));
            aeropuerto.escribirLog("El autobús " + identificador + " ha llegado a la parada de " + (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCodigoOACI()));
            if (ubicacion=="ciudad") {                
                aeropuerto.paradaCiudad.entrar(this);
            } else {
                aeropuerto.paradaAeropuerto.entrar(this);
            }
        }
    }
    
    // Sumamos a los pasajeros al sistema:
    public void dejarPasajeros() {
        this.aeropuerto.interfaz.comprobarPausa();
        if (ubicacion.equals("aeropuerto")) {            
            aeropuerto.pasajeros.addAndGet(pasajeros);
            this.aeropuerto.interfaz.setTextoAforoAeropuerto(this.aeropuerto);
        }
        aeropuerto.escribirLog("El autobús " + identificador + " ha dejado " + pasajeros + " en " +
                                (ubicacion=="ciudad"?aeropuerto.getCiudad():aeropuerto.getCodigoOACI()) +
                                (ubicacion=="aeropuerto"?(". Aforo: " + aeropuerto.pasajeros):"."));
    }
    
    
    public String getID(){
        return identificador; 
    }
    
    @Override
    public void run(){
        while (true) {
            recogerPasajeros();
            transitar();
            dejarPasajeros();
            /*recogerPasajeros();
            transitar();
            dejarPasajeros();*/
        }
    }
}
