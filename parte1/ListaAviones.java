package parte1;

import java.util.ArrayList;

public class ListaAviones {
    private ArrayList<Avion> aviones; 
    private Log log; 
    
    public ListaAviones(Log log){
        this.aviones=new ArrayList<Avion>(); 
        this.log=log; 
    }
    
    public synchronized void meterAvion(Avion avion){
        aviones.add(avion); 
    }
    
    public synchronized void sacarAvion(Avion avion){
        if(aviones.contains(avion)){
            aviones.remove(avion); 
        }
        else{
            log.escribirLog("Error al sacar el avión "+avion.getID()+" de la lista");
        }
    }
    
    public synchronized String getListado(boolean mostrarPasajeros){
        String listado=""; 
        for(short i=0; i<aviones.size(); i++){
            if(i==0){
                listado+=(aviones.get(i).getID()+(mostrarPasajeros?("("+aviones.get(i).getPasajeros()+")"):"")); 
            }
            else{
                listado+=(", "+aviones.get(i).getID()+(mostrarPasajeros?("("+aviones.get(i).getPasajeros()+")"):"")); 
            }
        }
        return listado; 
    }
    
    public synchronized String getListadoAterrizajes() {
        String listado=""; 
        for(short i=0; i<aviones.size(); i++){
            if(i==0){
                listado+=(aviones.get(i).getID()+("("+aviones.get(i).getAterrizajes()+")")); 
            }
            else{
                listado+=(", "+aviones.get(i).getID()+("("+aviones.get(i).getAterrizajes()+")"));  
            }
        }
        return listado; 
    }
    
    public synchronized short cuantosAviones(){
        return (short) aviones.size(); 
    }
    
    public synchronized Avion getAvion(short i){
        return aviones.get(i); 
    }
    
    public synchronized boolean pertenece(Avion avion){
        return aviones.contains(avion); 
    }
}
