package parte1;

import java.util.ArrayList;

public class ListaAutobuses {
    private ArrayList<Bus> buses; 
    private Log log; 
    
    public ListaAutobuses(Log log){
        this.buses=new ArrayList<Bus>(); 
        this.log=log; 
    }
    
    public synchronized void meterBus(Bus bus){
        buses.add(bus); 
    }
    
    public synchronized void sacarBus(Bus bus){
        if(buses.contains(bus)){
            buses.remove(bus); 
        }
        else{
            //log.escribirLog("Error al sacar el bus "+bus.getID()+" de la lista");
        }
    }
    
    public synchronized String getListado(){
        String lista=""; 
        for(short i=0; i<buses.size(); i++){
            if(i==0){
                lista+=buses.get(i).getID(); 
            }
            else{
                lista+=", "+buses.get(i).getID(); 
            }
        }
        return lista; 
    }
    
    public synchronized short cuantosBuses(){
        return (short) buses.size(); 
    }
    
    public synchronized Bus getBus(short i){
        return buses.get(i); 
    }
    
    public synchronized boolean pertenece(Bus bus){
        return buses.contains(bus); 
    }
}
