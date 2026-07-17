package parte1;

import java.util.LinkedList;
import java.util.Queue;

public class Aerovia {
    
    private ListaAviones lista;        
    private Interfaz interfaz;
    private Log log;
    private String destino;
    private final short TIEMPO_MAXIMO_VUELO=30;
    private final short TIEMPO_MINIMO_VUELO=15;
    private final short TIEMPO_MAXIMO_ORBITA=5;

    public Aerovia(Interfaz interfaz, Log log, String destino) {
        this.destino = destino; // para saber de qué aeropuerto es el destino
        this.lista = new ListaAviones(log);
        this.interfaz = interfaz;
        this.log = log; 
        log.escribirLog("Se ha creado la aerovía sentido " + destino);
    }

    public void añadir (Avion avion, String destino) {
        interfaz.comprobarPausa();        
        lista.meterAvion(avion);        
        log.escribirLog("El avión " + avion.getID() + " está en la aerovía destino " + destino + ".");
        actualizarInterfaz(destino);
    }    

    public void sacar(Avion avion, String destino) {
        interfaz.comprobarPausa();
        lista.sacarAvion(avion);                
        actualizarInterfaz(destino); 
        log.escribirLog("El avión " + avion.getID() + " abandona la aerovía destino " + destino + " y se dispone a aterrizar en la pista " + (avion.getPista()+1));                
    }
    
    public void volar (Avion avion, String destino) {
        interfaz.comprobarPausa();
        actualizarInterfaz(destino);
        log.escribirLog("El avión " + avion.getID() + " está volando hacia " + destino + ".");
        try {
            //Tiempo de vuelo:
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_VUELO*1000)-(TIEMPO_MINIMO_VUELO*1000)+1)+(TIEMPO_MINIMO_VUELO*1000)));
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está en vuelo hacia " + destino + ".");
        }        
    }
    
    public void orbitar (Avion avion, String destino) { 
        interfaz.comprobarPausa();
        log.escribirLog("El avión " + avion.getID() + " está orbitando para aterrizar en " + destino + ".");
        try {
            //Tiempo de órbita: entre 5 y 1 segs:
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_ORBITA*1000)-1000+1)+1000));
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está orbitando hacia " + destino + ".");
        }
    }

    public String getListadoAviones () {
        return lista.getListado(true);
    }
    
    /*
    public boolean pertenece (Avion avion) {
        interfaz.comprobarPausa();                
        //return (avion.despegue?listaDespegues.pertenece(avion):listaAterrizajes.pertenece(avion));
    }*/
    
    public void actualizarInterfaz(String destino) {        
        interfaz.comprobarPausa();        
        interfaz.setTextoAerovía(lista.getListado(true), destino);        
    }
    
}
