package parte1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pista {
    private Interfaz interfaz;
    private Log log;
    private short id;    
    private String codigoOACI;
    //private boolean despegue; //Una pista solo será despegues o aterrizajes
    
    AtomicBoolean abierta = new AtomicBoolean(true); //para controlar el estado de la pista(abierta/cerrada)
    AtomicBoolean libre = new AtomicBoolean(true); //para controlar el estado de ocupación de la pista(abierta/cerrada)
    private String id_avion; //Es el id del avión que ocupa la pista
    private final short TIEMPO_MAXIMO_ATERRIZAJE=5;
    private final short TIEMPO_MAXIMO_DESPEGUE=5;
    private final short TIEMPO_MAXIMO_CHECKLIST=3;
        
    //public Pista (Interfaz interfaz, Log log, short id, String codigoOACI, Boolean despegue) {
    public Pista (Interfaz interfaz, Log log, short id, String codigoOACI) {
        this.interfaz = interfaz;
        this.log = log;
        this.id = id;
        this.codigoOACI = codigoOACI;
        //this.despegue = despegue;                
        this.id_avion = "";
        //log.escribirLog("Se ha creado la pista " + id + " en modo " + (despegue?"despegue":"aterrizaje") + " en "+ codigoOACI);
        log.escribirLog("Se ha creado la pista " + id + " en "+ codigoOACI);        
    }    
        
    public String getIdAvion(){
        return id_avion;
    }
    
    public void setIdAvion(String id_avion){
        this.id_avion=id_avion;
    }
    
    public short getID() {
        return id;
    }
    
    
    /*public boolean esDespegue() {
        return despegue;
    }*/
    
    public void entrarEnPista (Avion avion) {
        interfaz.comprobarPausa(); 
        try {
            actualizarInterfaz(avion.getID()+"("+avion.getPasajeros()+")", avion.esDespegue());
            if (avion.esDespegue()) {                
                log.escribirLog("El avión " + avion.getID() + " está en cabecera de pista " + (id+1) + " haciendo el checklist para despegar en " + codigoOACI + ".");
                //Simula el tiempo de checklist (1 y 3 segs):
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_CHECKLIST*1000)-1000+1)+1000));
            } else {                
                log.escribirLog("El avión " + avion.getID() + " está a punto de tocar pista " + (id+1) + " para el aterrizaje en " + codigoOACI + ".");
            }            
        } catch(InterruptedException e){
            
        } finally {
            //actualizarInterfaz();
        }
    }
    
    public void despegar (Avion avion) {
        interfaz.comprobarPausa();
        
        try{
            log.escribirLog("El avión " + avion.getID() + " está despegando por la pista " + (id+1) + " de " + codigoOACI + ".");
            //Simula la espera para volver a solicitar 1 de las 4 pistas (1 y 0,5 segs):
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_DESPEGUE*1000)-1000+1)+1000));            
            setIdAvion("");
            
            //this.semaforo.release();
        } catch(InterruptedException e){
            //aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en la espera pista de " + aeropuerto.codigoOACI);
        } finally {            
            //setIdAvion("");
            
            actualizarInterfaz("", avion.esDespegue());            
        }
        
    }
    
    public void aterrizar (Avion avion) {
        interfaz.comprobarPausa();
        actualizarInterfaz(avion.getID()+"("+avion.getPasajeros()+")", avion.esDespegue());
        try{
            log.escribirLog("El avión " + avion.getID() + " ha tocado pista " + (id+1) + " de " + codigoOACI + ".");
            //Simula la espera para volver a solicitar 1 de las 4 pistas (1 y 0,5 segs):
            setIdAvion(avion.getID());
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_ATERRIZAJE*1000)-1000+1)+1000));            
        } catch(InterruptedException e){
            //aeropuerto.escribirLog("ERROR: El avión " + identificador + " tuvo problemas en la espera pista de " + aeropuerto.codigoOACI);
        } finally {
            setIdAvion("");
            libre.compareAndSet(false,true);
            actualizarInterfaz("", avion.esDespegue());
        }        
    }
    
    public void actualizarInterfaz(String texto, boolean despegue) {
        interfaz.comprobarPausa(); 
        interfaz.setTextoPista(texto, codigoOACI, id, despegue);        
    }
    
}
