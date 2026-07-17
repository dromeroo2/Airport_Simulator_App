package parte1;

import java.util.LinkedList;
import java.util.Queue;

public class Rodaje {
    private ListaAviones listaDespegues;
    private ListaAviones listaAterrizajes;        
    private Interfaz interfaz;
    private Log log;
    private String codigoOACI;
    private final short TIEMPO_MAXIMO_RODAJE=5;
    private final short TIEMPO_MINIMO_RODAJE_ATERRIZAJE=3;
    final private short TIEMPO_MAXIMO_ESPERA_SOLICITUD_PISTA=1;
    final private float TIEMPO_MINIMO_ESPERA_SOLICITUD_PISTA=0.5f;

    public Rodaje(Interfaz interfaz, Log log, String codigoOACI) {
        this.listaDespegues = new ListaAviones(log);
        this.listaAterrizajes = new ListaAviones(log);        
        this.interfaz = interfaz;
        this.log = log;
        this.codigoOACI = codigoOACI; // para saber de qué aeropuerto es el rodaje
        log.escribirLog("Se ha creado el rodaje en " + codigoOACI);
    }

    public void añadir (Avion avion, boolean despegue) {
        interfaz.comprobarPausa();        
        if (despegue) {
            listaDespegues.meterAvion(avion);
        } else {
            listaAterrizajes.meterAvion(avion);
        }
        log.escribirLog("El avión " + avion.getID() + " ha sido agregado al rodaje de " + (despegue?"despegue":"aterrizaje") + " en " + codigoOACI + ".");
        actualizarInterfaz(despegue, avion.getPasajeros());        
        
    }    

    public synchronized void sacar(Avion avion, boolean despegue) {
        interfaz.comprobarPausa();
        if (despegue) {
            listaDespegues.sacarAvion(avion);
        } else {
            listaAterrizajes.sacarAvion(avion);
        }        
        actualizarInterfaz(despegue, avion.getPasajeros()); 
        //log.escribirLog("El avión " + avion.getID() + " abandona el rodaje " + codigoOACI + " y espera " + (lista=="despegues"?"pista.":"puerta de embarque."));
        log.escribirLog("El avión " + avion.getID() + " abandona el rodaje " + codigoOACI + " y ocupa la " + (despegue?("pista "+ (avion.getPista()+1)):"puerta de embarque "+ (avion.getPuertaEmbarque())));
    }
    
    public void rodar (Avion avion) {
        interfaz.comprobarPausa();
        log.escribirLog("El avión " + avion.getID() + " está rodando para " + (avion.esDespegue()?"despegar":"desembarcar") +" en " + codigoOACI + ".");
        try {
            if (avion.esDespegue()){
            //Tiempo de rodaje haciendo el checking: entre 5 y 1 segs:
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_RODAJE*1000)-1000+1)+1000));
            } else {
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_RODAJE*1000)-(TIEMPO_MINIMO_RODAJE_ATERRIZAJE*1000)+1)+(TIEMPO_MINIMO_RODAJE_ATERRIZAJE*1000)));                
            }
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está en el rodaje de " + codigoOACI + ".");
        }        
    }
    
    public void esperarPista (Avion avion) {
        try{
            //Simula la espera de ista para volver a solicitar 1 de las 4 pistas (1 y 0,5 segs):
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_ESPERA_SOLICITUD_PISTA*1000)-(TIEMPO_MINIMO_ESPERA_SOLICITUD_PISTA*1000)+1)+(TIEMPO_MINIMO_ESPERA_SOLICITUD_PISTA*1000)));         
        } catch(InterruptedException e){
            log.escribirLog("ERROR: El avión " + avion.getID() + " tuvo problemas en la espera pista de " + codigoOACI);
        }
    }
    
    public boolean pertenece (Avion avion) {
        interfaz.comprobarPausa();                
        return (avion.esDespegue()?listaDespegues.pertenece(avion):listaAterrizajes.pertenece(avion));
    }
    
    public short getNumAviones (boolean despegue) {
        return (despegue?listaDespegues.cuantosAviones():listaAterrizajes.cuantosAviones());
    }
    
    public void actualizarInterfaz(boolean despegue, short pasajeros) {        
        interfaz.comprobarPausa();
        if (despegue){
            interfaz.setTextoRodaje(listaDespegues.getListado(false), codigoOACI, despegue, pasajeros, listaDespegues.cuantosAviones());
        } else {
            interfaz.setTextoRodaje(listaAterrizajes.getListado(false), codigoOACI, despegue, pasajeros, (short)0);
        }
    }
    
}
