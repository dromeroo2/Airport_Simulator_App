package parte1;

public class Hangar {
    private ListaAviones aviones; 
    private Interfaz interfaz; 
    private Log log;
    private String codigoOACI;
    private final short TIEMPO_MAXIMO_REPOSTAR=30;
    private final short TIEMPO_MINIMO_REPOSTAR=15;
    private final short TIEMPO_MAXIMO_HANGAR=4;
    private final short TIEMPO_MINIMO_HANGAR=2;
    
    public Hangar(Interfaz interfaz, Log log, String codigoOACI){
        this.aviones=new ListaAviones(log);        
        this.interfaz=interfaz; 
        this.log=log;
        this.codigoOACI=codigoOACI;
    }

    public void guardar (Avion avion) {
        interfaz.comprobarPausa();
        aviones.meterAvion(avion);
        log.escribirLog("El avión " + avion.getID() + " está guardado en el Hangar " + codigoOACI);
        actualizarInterfaz();
        interfaz.comprobarPausa();
        try {
            //Descansa entre 4 y 2 segs:
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_HANGAR*1000)-(TIEMPO_MINIMO_HANGAR*1000)+1)+(TIEMPO_MINIMO_HANGAR*1000)));
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está guardado en el Hangar " + codigoOACI);
        }
        
    }
    
    public void repostar (Avion avion) {         
        interfaz.comprobarPausa();
        try {
            //Descansa entre 30 y 15 segs:
            Thread.sleep((int)Math.floor(Math.random()*((TIEMPO_MAXIMO_REPOSTAR*1000)-(TIEMPO_MINIMO_REPOSTAR*1000)+1)+(TIEMPO_MINIMO_REPOSTAR*1000)));
        }
        catch(InterruptedException ie) {
            log.escribirLog("Error mientras el avión " + avion.getID() + " está respostando combustible en el Hangar de " + codigoOACI + ".");
        }
        finally {
            log.escribirLog("El avión " + avion.getID() + " está repostando en el Hangar de " + codigoOACI);
        }
    }    
    
    public void sacar (Avion avion){        
        interfaz.comprobarPausa();
        aviones.sacarAvion(avion); 
        actualizarInterfaz(); 
        log.escribirLog("El avión " + avion.getID() + " sale del hangar " + codigoOACI + " hacia plataforma.");
    }
    
    public short getNumAviones () {
        return aviones.cuantosAviones();
    }
    
    public void actualizarInterfaz(){
        interfaz.setTextoHangar(aviones.getListado(false), codigoOACI);        
    }
}
