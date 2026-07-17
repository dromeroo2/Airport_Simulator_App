package parte2.socketsTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import parte1.Log;
import parte1.Aeropuerto;
import parte1.Aerovia;


public class RespuestaServidor implements Runnable{
    private Log log;
    private Aeropuerto LEMD;
    private Aeropuerto LEBL;
    private Aerovia LEMDtoLEBL;
    private Aerovia LEBLtoLEMD;
    private Socket conexion; 
    private DataInputStream entrada; 
    private DataOutputStream salida; 
    
    public RespuestaServidor(Log log, Aeropuerto LEMD, Aeropuerto LEBL, Aerovia LEMDtoLEBL, Aerovia LEBLtoLEMD, Socket conexion){
    //public RespuestaServidor(Log log, Aeropuerto LEMD, Aeropuerto LEBL, Socket conexion){
        this.log=log;
        this.LEMD=LEMD;
        this.LEBL=LEBL;
        this.LEMDtoLEBL=LEMDtoLEBL;
        this.LEBLtoLEMD=LEBLtoLEMD;
        this.conexion=conexion; 
        try{
            this.entrada=new DataInputStream(conexion.getInputStream()); 
            this.salida=new DataOutputStream(conexion.getOutputStream());
        }
        catch(IOException ioe){
            log.escribirLog("Error al iniciar respuesta desde el servidor");
        }
    }
    
    @Override
    public void run(){
        String peticion=""; 
        try{
            peticion=entrada.readUTF(); //Leo la petición del cliente
            log.escribirLog("He leído la petición " + peticion);
        } 
        catch(IOException ioe){
            log.escribirLog("Error al leer petición desde el servidor");
        }
        
        int respuestaNum = -1;
        String respuestaTexto="";
        boolean respuestaBoolean=false;
        
        // Miro qué petición de me ha llegado. Puede ser de 3 tipos: Int, texto (listado de vuelos) o Booleano (abrir/cerrar pista) 
        if (peticion.length()>2) {
            String[] partes = peticion.split(";");
            //log.escribirLog("Partes[2]= " + partes[2]);
            if (partes[0].equals("LEMD")){
                respuestaBoolean=LEMD.accionPista(Short.parseShort(partes[1]), Short.parseShort(partes[2]));
            } else {
                respuestaBoolean=LEBL.accionPista(Short.parseShort(partes[1]), Short.parseShort(partes[2]));
            }
        } else {
            switch(Integer.parseInt(peticion)){
                case 0:
                    respuestaNum=LEMD.getPasajeros();
                    break;
                case 1:
                    respuestaNum=LEBL.getPasajeros();
                    break;
                case 2:
                    respuestaNum=LEMD.hangar.getNumAviones();
                    break;
                case 3:
                    respuestaNum=LEBL.hangar.getNumAviones();
                    break;
                case 4:
                    respuestaNum=LEMD.taller.getNumAviones();
                    break;
                case 5:
                    respuestaNum=LEBL.taller.getNumAviones();
                    break;
                case 6:
                    respuestaNum=LEMD.plataforma.getNumAvionesCola();
                    break;
                case 7:
                    respuestaNum=LEMD.plataforma.getNumAvionesLista();
                    break;
                case 8:
                    respuestaNum=LEBL.plataforma.getNumAvionesCola();
                    break;
                case 9:
                    respuestaNum=LEBL.plataforma.getNumAvionesLista();
                    break;
                case 10:
                    respuestaNum=LEMD.rodaje.getNumAviones(true);
                    break;
                case 11:
                    respuestaNum=LEMD.rodaje.getNumAviones(false);
                    break;
                case 12:
                    respuestaNum=LEBL.rodaje.getNumAviones(true);
                    break;
                case 13:
                    respuestaNum=LEBL.rodaje.getNumAviones(false);
                    break;
                case 20:
                    respuestaTexto=LEMDtoLEBL.getListadoAviones();
                    break;
                case 21:
                    respuestaTexto=LEBLtoLEMD.getListadoAviones();
                    break;
            }
        }
        
        try{
            if (peticion.length()>2) {
                salida.writeBoolean(respuestaBoolean);
            }else if (respuestaTexto=="") {
                salida.writeInt(respuestaNum);
            } else {
                salida.writeUTF(respuestaTexto);
            }
            
        }
        catch(IOException ioe){
            log.escribirLog("Error al enviar respuesta desde el servidor");
        }
    }
}
