package pecl;

/**
 *
 * @author ggonzalez 22/marzo/2024
 */


import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import parte1.*;
import parte2.socketsTCP.ServidorSocketTCP;

public class PECL {

    public static void main(String[] args) throws UnsupportedEncodingException, RemoteException{
        //Lo primero, cargamos el log
        Log log = new Log();
        log.escribirLog("EMPEZAMOS\n\n");

        //Después cargamos la interfaz 
        Interfaz interfaz = new Interfaz(new Pausa(), log);
        interfaz.setVisible(true);
                
        // Creamos los 2 aeropuertos con sus códigos OACI y las 2 aerovías que dicen en el enunciado:
        Aeropuerto LEMD = new Aeropuerto(interfaz, log, "LEMD");
        Aeropuerto LEBL = new Aeropuerto(interfaz, log, "LEBL");

        // Creamos las 2 aerovías:
        Aerovia LEMDtoLEBL= new Aerovia(interfaz, log, "LEBL");
        Aerovia LEBLtoLEMD= new Aerovia(interfaz, log, "LEMD");
        
        /*
        Ciudad madrid = new Ciudad(interfaz, log);
        Ciudad barcelona = new Ciudad(interfaz, log);
        */
                
        //Iniciamos servidor de tipo Sockets TCP:
        ServidorSocketTCP servidor = new ServidorSocketTCP(log, LEMD, LEBL, LEMDtoLEBL, LEBLtoLEMD);
        servidor.start();
        
        
        /*try {
            // Crear el registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Crear una instancia del Aeropuerto
            InterfazAeropuerto aeropuertoInt = LEMD;

            // Registrar la instancia en el registro RMI
            registry.rebind("Aeropuerto", aeropuertoInt);

            System.out.println("Servidor listo...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }*/
        
        
        //Creamos los autobuses y los aviones
        GeneradorAviones generadorAviones = new GeneradorAviones(LEMD, LEBL, LEMDtoLEBL, LEBLtoLEMD, (short) 200);
        GeneradorBuses generadorBuses = new GeneradorBuses(LEMD, LEBL, (short) 400);
        generadorAviones.start();
        generadorBuses.start();
        
    }
}


