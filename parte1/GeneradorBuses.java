package parte1;

/**
 *
 * @author ggonzalez 23/mayo/2024
 */

public class GeneradorBuses extends Thread{
    private Aeropuerto LEMD;
    private Aeropuerto LEBL;

    private short numBuses;
    
    
    public GeneradorBuses(Aeropuerto LEMD, Aeropuerto LEBL, short numBuses){
        this.LEMD=LEMD;
        this.LEBL=LEBL;
        this.numBuses=numBuses;
    }
    
    
    @Override
    public void run(){
        for (short i=1; i<=numBuses; i++){
            Bus bus=new Bus(i, i%2==0?LEMD:LEBL); 
            bus.start();             
            try {
                //Esperamos aleatoriamente entre 0,5 y 1 segundo:
                Thread.sleep((int)Math.floor(Math.random()*(1000-500+1)+500)); 
            }
            catch(InterruptedException ie){
                if (i%2==0) {
                    LEMD.escribirLog("Error al crear un autobús de Madrid");
                } else {
                    LEBL.escribirLog("Error al crear un autobús de Barcelona");
                }
            }
            LEMD.interfaz.comprobarPausa();
            LEBL.interfaz.comprobarPausa();
        }
    }
}
