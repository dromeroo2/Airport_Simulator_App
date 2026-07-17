package parte1;

import java.util.LinkedList;
import java.util.Queue;

public class Plataforma {
    
    private Queue<Avion> colaAvionesDespegue;  // Los despegues los encolamos.
    private ListaAviones listaAvionesAterrizaje; // Los aterrizajes se meten en listas.
    private Interfaz interfaz;
    private Log log;
    private String codigoOACI;
    private final short TIEMPO_MAXIMO_PARKING_DESPEGUE=2;
    private final short TIEMPO_MAXIMO_PARKING_ATERRIZAJE=5;
    
    public Plataforma(Interfaz interfaz, Log log, String codigoOACI) {
        this.colaAvionesDespegue = new LinkedList<>();
        this.listaAvionesAterrizaje = new ListaAviones(log);
        this.interfaz = interfaz;
        this.log = log;
        this.codigoOACI = codigoOACI;
        log.escribirLog("Se ha creado la Plataforma (parking) para " + codigoOACI);
    }

    public void añadir(Avion avion) {
        interfaz.comprobarPausa();
        if (avion.esDespegue()) {
            colaAvionesDespegue.offer(avion);
        } else {
            listaAvionesAterrizaje.meterAvion(avion);
        }
        log.escribirLog("Avión " + avion.getID() + " agregado a la plataforma " + codigoOACI + " en la " + (avion.esDespegue()?"cola":"lista") + ".");
        interfaz.comprobarPausa();        
        actualizarInterfaz(avion.esDespegue());
    }

    public Avion sacarCola() {
        interfaz.comprobarPausa();        
        Avion avion = colaAvionesDespegue.poll();
        if (avion != null) {
            //log.escribirLog("El avión " + avion.getID() + " aparcado en la plataforma " + codigoOACI + ".");
        } else {
            log.escribirLog("No hay aviones en la plataforma " + codigoOACI + ".");
        }
        actualizarInterfaz(true);
        return avion;
    }
    
    public void sacarLista(Avion avion) {
        interfaz.comprobarPausa();
        listaAvionesAterrizaje.sacarAvion(avion);
        actualizarInterfaz(false);
    }
    
    public void aparcado (Avion avion) {
        interfaz.comprobarPausa();
        log.escribirLog("El avión " + avion.getID() + " está aparcado en la plataforma " + codigoOACI + " en modo " + (avion.esDespegue()?"despegue":"aterrizaje") + ".");
        try {
            if (avion.esDespegue()) {
                // Tiempo de parking: entre 2 y 1 segs:
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_PARKING_DESPEGUE*1000)-1000+1)+1000));
            } else { // Tiempo de parking: entre 5 y 1 segs:
                Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_PARKING_ATERRIZAJE*1000)-1000+1)+1000));
            }
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está aparcado en plataforma " + codigoOACI + ".");
        }        
    }
    
    
    public synchronized Avion getPrimero() {
        interfaz.comprobarPausa();                
        return colaAvionesDespegue.peek();
    }
            
    public synchronized String getListado(boolean despegue) {
        interfaz.comprobarPausa();
        StringBuilder sb = new StringBuilder();
        //Si actualizo el listado de despegues, devuelvo la cola separando por ->
        if (despegue) {
            for (Avion avion : colaAvionesDespegue) {
                if (codigoOACI=="LEMD") {
                    sb.insert(0, " -> ").insert(0, avion.getID());
                } else {
                    sb.append(avion.getID()).append(" <- ");
                }            
            }
            if (!colaAvionesDespegue.isEmpty()) {
                // Eliminamos la primera o última flecha
                if (codigoOACI=="LEMD") {
                    sb.delete(sb.lastIndexOf("->") - 1, sb.lastIndexOf("->") + 4);
                } else {
                    sb.delete(sb.length() - 4, sb.length());
                } 
            }
        } else { //Si no, devuelvo la lista 
            sb.append(listaAvionesAterrizaje.getListado(false));
        }
        return sb.toString();
    }
    
    public short getNumAvionesLista(){
        return listaAvionesAterrizaje.cuantosAviones();
    }

    public short getNumAvionesCola(){
        return (short)colaAvionesDespegue.size();
    }
    
    public void actualizarInterfaz(boolean despegue) {
        interfaz.comprobarPausa();
        interfaz.setTextoPlataforma(getListado(despegue), codigoOACI, despegue);        
    }
    
    
    
}
