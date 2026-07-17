package parte1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Embarque {
    private Interfaz interfaz;
    private Log log;
    private short id;
    private String nombre;
    private String codigoOACI;
    private String tipo; //"embarque", "desembarque", "ambos"    
    AtomicBoolean ocupado = new AtomicBoolean(false); //para controlar el estado de la puerta de embarque
    private String id_avion; //Es el id del avión que ocupa la puerta
    
    public Embarque (Interfaz interfaz, Log log, short id, String codigoOACI, String tipo) {
        this.interfaz = interfaz;
        this.log = log;
        this.id=id;
        this.codigoOACI=codigoOACI;
        this.tipo=tipo;
        if (id==0) {
            this.nombre="D"+(id+1);
        } else if (id==1) {
            this.nombre="A"+(id+1);            
        } else this.nombre="DA"+(id+1);
        log.escribirLog("Se ha creado la puerta de embarque " + id + " para " + tipo + " en " + codigoOACI);        
    }    

    public String getNombre(){
        return nombre;
    }
    
    public String getIdAvion(){
        return id_avion;
    }
    
    public void setIdAvion(String id_avion){
        this.id_avion=id_avion;
    }
    
    public void actualizarInterfaz(boolean despegue, short c, short p) {
        interfaz.comprobarPausa(); 
        interfaz.setTextoPuertaEmbarque(id, codigoOACI, id_avion, despegue, c, p);
        //getListado();
    }
    
    
    
}
