
package parte1;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Aeropuerto {
    
    private String codigoOACI;
    private String ciudad;
    AtomicInteger pasajeros = new AtomicInteger(0); //Almacenamos el aforo en cada momento mediante un AtomicInteger
    AtomicBoolean hayAterrizajes = new AtomicBoolean(false); //Almacenamos el número de aterrizajes efectuaforo en cada momento mediante un AtomicInteger
    private final short NUM_PUERTAS = 6;
    private final short NUM_PISTAS = 4;
    
    //Creo el aeropuerto con todas sus clases:
    public Interfaz interfaz; 
    public Log log;
    public ParadaBus paradaCiudad;
    public ParadaBus paradaAeropuerto;
    public Hangar hangar;
    public Taller taller;
    public Plataforma plataforma;    
    public Embarque[] arrayEmbarques = new Embarque[NUM_PUERTAS]; 
    public Rodaje rodaje;
    public Pista[] arrayPistas = new Pista[NUM_PISTAS];    
        
    public Aeropuerto (Interfaz interfaz, Log log, String codigoOACI) throws RemoteException {         
        this.interfaz = interfaz; 
        this.log = log;
        this.codigoOACI = codigoOACI;
        if (codigoOACI.equals("LEMD")) {
            ciudad = "Madrid";
        } else {
            ciudad = "Barcelona";
        }
        
        log.escribirLog("Construyendo el aeropuerto "+codigoOACI+":");
        
        //Creamos la PARADA de autobús del aeropuerto:
        paradaCiudad = new ParadaBus(interfaz, log, ciudad);
        paradaAeropuerto = new ParadaBus(interfaz, log, codigoOACI);        
        
        //Creamos el HANGAR:
        hangar = new Hangar(interfaz, log, codigoOACI);
        
        //Creamos el TALLER:
        taller = new Taller(interfaz, log, codigoOACI);
        
        //Creamos la PLATAFORMA:
        plataforma = new Plataforma(interfaz, log, codigoOACI);

        //Inicializamos las PUERTAS DE EMBARQUE, creando el número de forma aleatoria:
        for (short i = 0; i < arrayEmbarques.length; i++) {
            arrayEmbarques[i] = new Embarque (  interfaz, 
                                                log, 
                                                i, 
                                                codigoOACI, 
                                                (i==0?
                                                    "embarque":
                                                    (i==1?
                                                        "desembarque":
                                                        "ambos"
                                                    )
                                                ));
        }
        
        //Creamos el área de rodaje:        
        rodaje = new Rodaje(interfaz, log, codigoOACI);
        
        //Inicializamos las PISTAS:
        for (short i = 0; i < arrayPistas.length; i++) {
            /*arrayPistas[i] = new Pista( interfaz, 
                                        log, 
                                        i, 
                                        codigoOACI,
                                        (i%2==0?true:false));
            String texto = "Pista " + Short.toString((short) (i+1)) + " ("+(arrayPistas[i].esDespegue()?"D":"A")+"): ";*/
            arrayPistas[i] = new Pista( interfaz, 
                                        log, 
                                        i, 
                                        codigoOACI);
            String texto = "Pista " + Short.toString((short) (i+1)) + ": ";
            interfaz.setLabelPistas(i,texto);
        }
        
        log.escribirLog("Aeropuerto "+codigoOACI + " construido.\n");
    }
    
    public boolean getHayAterrizajes(){
        return hayAterrizajes.get();
    }
    
    public void setHayAterrizajes(){
        hayAterrizajes.set(true); 
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public String getCodigoOACI() {
        return codigoOACI;
    }
    
    public short getNumPuertas() {
        return NUM_PUERTAS;
    }
    
    public short getNumPistas() {
        return NUM_PISTAS;
    }
    
    public int getPasajeros() {
        return pasajeros.get();
    }
    
    public boolean accionPista(short pista, short abrirNum) {
        boolean abrir=(abrirNum==1?true:false);
        //cambio el valor de la pista
        log.escribirLog("estoy en Aeropuerto "+this.codigoOACI+" y recibo " + (pista+1) + " y " + (abrir?"abrir":"cerrar"));
        boolean exito=this.arrayPistas[pista].abierta.compareAndSet(!abrir, abrir);
        //pinto la etiqueta de la pista de color rojo o verde, según está abiertao cerrada
        if (exito) {            
            interfaz.setColorPista(this.codigoOACI, pista, abrir);            
        } else {
            log.escribirLog("ERROR al intentar cambiar la acción de la pista " + (pista+1) + " y " + (abrir?"abrir":"cerrar"));
        }
        return exito;
    }
    
    public void comprobarPausa(){
        interfaz.comprobarPausa(); 
    }
    
    public void escribirLog(String texto){
        log.escribirLog(texto);
    }
    
}
