package parte1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Taller {
    
    private ListaAviones lista;
    private Interfaz interfaz;
    private Log log;
    private String codigoOACI;
    AtomicInteger numAvionesRevisando = new AtomicInteger(0);
    Semaphore numAviones;
    private final short CAPACIDAD_TALLER=20;
    private final short NUM_ATERRIZAJES_REVISION_COMPLETA=15;
    private final short TIEMPO_ATRAVESAR_PUERTA=1;    
    private final short TIEMPO_MAXIMO_REVISIÓN_RÁPIDA=5;
    private final short TIEMPO_MAXIMO_REVISIÓN_COMPLETA=10;
    private final short TIEMPO_MINIMO_REVISIÓN_COMPLETA=5;
    
    
    public Taller(Interfaz interfaz, Log log, String codigoOACI) {
        this.lista = new ListaAviones(log);                
        this.interfaz = interfaz;
        this.log = log;
        this.codigoOACI = codigoOACI; // Para saber en qué aeropuerto está el taller
        numAviones = new Semaphore(CAPACIDAD_TALLER, true); //semáforo justo que gestiona el aforo y el orden de entrada/salida
        log.escribirLog("Se ha creado el Taller de " + codigoOACI);
    }
        
    private boolean esRevisionRapida(Avion avion) {
        return (avion.getAterrizajes() < NUM_ATERRIZAJES_REVISION_COMPLETA);
    }
    
    public void solicitarTaller(Avion avion) {        
        try {            
            log.escribirLog("El avión " + avion.getID() + " pide acceso al Taller de " + codigoOACI + " para una revisión " + (esRevisionRapida(avion)?"rápida.":"completa."));
            //Solicito permiso al semáforo, si no hubiera el hilo se queda esperando:
            numAviones.acquire();
            //actualizarInterfazPuerta(avion.getID());
        } catch (InterruptedException ie) {
            log.escribirLog("ERROR: El avión " + avion.getID() + " tuvo problemas para solicitar la puerta del taller de " + codigoOACI);
        }         
    }
    
    //hacemos el método synchronized porque nos piden exclusión mutua para la puerta
    public synchronized void atravesarPuertaTaller (Avion avion) {
        // Por la puerta solo puede pasar un avión, sea de entrada o salida. Tarda 1 segundo:  
         actualizarInterfazPuerta(avion.getID());
        try {
            //Simula el tiempo que se tarda en atravesar la puerta:
            Thread.sleep(TIEMPO_ATRAVESAR_PUERTA*1000);
        } catch(InterruptedException e){
            log.escribirLog("ERROR: El avión " + avion.getID() + " tuvo problemas al pasar por la puerta del taller de " + codigoOACI);
        } finally {
            actualizarInterfazPuerta("");
        }
    }
    
    public void añadir (Avion avion) {
        interfaz.comprobarPausa();
        lista.meterAvion(avion);
        log.escribirLog("El avión " + avion.getID() + " está en el Taller de " + codigoOACI + " pasando una revisión " + (esRevisionRapida(avion)?"rápida.":"completa."));
        //actualizarInterfazTaller((short)lista.cuantosAviones());
        actualizarInterfazTaller((short)numAviones.availablePermits());
    }    
    
    public void revisar (Avion avion) {
        interfaz.comprobarPausa();                
        //Pasa la revisión rápida o completa:
        try {
            añadir(avion);
            if (esRevisionRapida(avion)) {
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_REVISIÓN_RÁPIDA*1000)-1000+1)+1000));
            } else {
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_REVISIÓN_COMPLETA*1000)-(TIEMPO_MINIMO_REVISIÓN_COMPLETA*1000)+1)+(TIEMPO_MINIMO_REVISIÓN_COMPLETA*1000)));
            }
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está en revisión.");
        } finally {
            numAviones.release();
            sacar(avion, avion.esDespegue());            
        }        
    }
    
    public void sacar (Avion avion, boolean despegue) {
        interfaz.comprobarPausa();
        lista.sacarAvion(avion);                
        //actualizarInterfazTaller((short)lista.cuantosAviones());
        actualizarInterfazTaller((short)numAviones.availablePermits());
        log.escribirLog("El avión " + avion.getID() + " abandona el taller " + codigoOACI + ".");
    }
    
    public short getNumAviones () {
        return lista.cuantosAviones();
    }
                
    public void actualizarInterfazTaller(short plazasLibres) {        
        interfaz.comprobarPausa();        
        interfaz.setTextoTaller(lista.getListadoAterrizajes(), codigoOACI, plazasLibres);        
    }
    
    public void actualizarInterfazPuerta(String id_avion) {        
        interfaz.comprobarPausa();        
        interfaz.setTextoPuerta(id_avion, codigoOACI);        
    }
    
}
