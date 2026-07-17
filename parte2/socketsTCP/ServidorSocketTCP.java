
package parte2.socketsTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import parte1.Log;
import parte1.Aeropuerto;
import parte1.Aerovia;
/**
 *
 * @author ggonzalez 22/04/2024
 */

public class ServidorSocketTCP extends Thread {
    private Log log;
    private ExecutorService pool; 
    private ServerSocket socket;
    private Aeropuerto LEMD;
    private Aeropuerto LEBL;
    private Aerovia LEMDtoLEBL;
    private Aerovia LEBLtoLEMD;    
      
    public ServidorSocketTCP (Log log, Aeropuerto LEMD, Aeropuerto LEBL, Aerovia LEMDtoLEBL, Aerovia LEBLtoLEMD){    
        this.log=log;
        this.pool=Executors.newFixedThreadPool(10);
        this.LEMD=LEMD;      
        this.LEBL=LEBL;
        this.LEMDtoLEBL=LEMDtoLEBL;
        this.LEBLtoLEMD=LEBLtoLEMD;
        try{
            this.socket=new ServerSocket(5000); 
        }
        catch(IOException ioe){
            log.escribirLog("Error al iniciar servidor");
        }
    }
    
    @Override
    public void run(){
        log.escribirLog("Servidor conectado!");
        while(true){
            try{ 
                Socket conexion=socket.accept();
                RespuestaServidor respuesta=new RespuestaServidor(log, LEMD, LEBL, LEMDtoLEBL, LEBLtoLEMD, conexion);                
                pool.execute(respuesta);
            } 
            catch(IOException ioe){
                log.escribirLog("Error del servidor al atender peticiones");
            }
        }
    }
    
}
