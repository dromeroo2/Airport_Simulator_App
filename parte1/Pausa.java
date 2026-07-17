package parte1;

/**
 *
 * @author ggonzalez 23/04/2024
 */


import java.util.concurrent.locks.*;

public class Pausa {
    private Lock cerrojo; 
    private Condition pausa;
    private boolean pulsado; 
    
    public Pausa(){
        this.cerrojo=new ReentrantLock(); 
        this.pausa=cerrojo.newCondition(); 
        this.pulsado=false; 
    }
    
    public void pausar(){
        try{
            cerrojo.lock(); 
            pulsado=true; 
        }
        finally{
            cerrojo.unlock();
        }        
    }
    
    public void continuar(){
        try{
            cerrojo.lock(); 
            pulsado=false; 
            pausa.signalAll();
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    /*Vamos a ejecutar los hilos antes de los "momentos clave", algo parecido a la actualización
    de la interfaz. Cuando el hilo entre en este método cogerá el cerrojo y si el booleano pulsado
    está en estado true se va a la cola del condition. Otro hilo lo sacará de esta cuando se
    vuelva a pulsar el botón:*/
    public void pasar(){
        try{
            cerrojo.lock();
            while(pulsado){
                pausa.await();
            }
        }
        catch(InterruptedException ie){
            System.out.println("Error mientras se espera a retomar la pausa.");
        }
        finally{
            cerrojo.unlock(); 
        }
    }
}
