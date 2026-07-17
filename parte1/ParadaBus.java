package parte1;

public class ParadaBus {
    private ListaAutobuses buses; 
    private Interfaz interfaz; 
    private Log log;
    private String ubicacion;
    
    public ParadaBus(Interfaz interfaz, Log log, String ubicacion){
        this.buses=new ListaAutobuses(log);        
        this.interfaz=interfaz; 
        this.log=log;
        this.ubicacion=ubicacion;
    }

    public void entrar (Bus bus) {
        interfaz.comprobarPausa();
        log.escribirLog("El bus " + bus.getID() + " llega a " + ubicacion);
        buses.meterBus(bus);
        actualizarInterfaz();
        interfaz.comprobarPausa();
    }
       
    
    public void salir (Bus bus){        
        interfaz.comprobarPausa();
        log.escribirLog("El bus " + bus.getID() + " sale de " + ubicacion);
        buses.sacarBus(bus);
        actualizarInterfaz();
        interfaz.comprobarPausa();
    }
    
    public void actualizarInterfaz(){
        interfaz.setTextoParada(""+buses.cuantosBuses(), ubicacion);
        /*switch (ubicacion) {
            case "Madrid":
                        interfaz.setTextoHangar(""+buses.cuantosBuses(), ubicacion);
                        break;
            case "Barcelona":
                        interfaz.setTextoHangar(""+buses.cuantosBuses(), ubicacion);
                        break;
        }*/
                
    }
}
