package parte1;

/**
 *
 * @author ggonzalez 23/marzo/2024
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log {
    private FileWriter log; 
    private Lock cerrojo; 
    
    public Log() throws UnsupportedEncodingException{
        //System.setOut(new PrintStream(System.out, true, "UTF-8"));
        try{
            this.log=new FileWriter("comportamiento_sistema.log", true);
            this.cerrojo=new ReentrantLock();
        }
        catch(IOException ioe){
            System.out.println("Error al abrir el log del sistema");
        }
    }
    
    public void escribirLog(String contenido){
        LocalDateTime fechaHora=LocalDateTime.now(); 
        System.out.println(contenido);
        try{
            cerrojo.lock();
            log.write("["+fechaHora.truncatedTo(ChronoUnit.MILLIS)+"]  " + contenido + "\n");
        }
        catch(IOException ioe){
            System.out.println("Error al escribir en el log");
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void cerrarLog(){
        try {
            log.close();
        } 
        catch(IOException ex){
            System.out.println("Error al cerrar el log");
        }
    }
}
