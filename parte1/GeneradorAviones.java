package parte1;

public class GeneradorAviones extends Thread {
    private Aeropuerto LEMD;
    private Aeropuerto LEBL;
    private Aerovia LEMDtoLEBL;
    private Aerovia LEBLtoLEMD;

    private short numAviones;
    
    public GeneradorAviones(Aeropuerto LEMD, 
                            Aeropuerto LEBL, 
                            Aerovia LEMDtoLEBL, 
                            Aerovia LEBLtoLEMD, 
                            short numAviones){
        this.LEMD=LEMD;
        this.LEBL=LEBL;
        this.LEMDtoLEBL=LEMDtoLEBL;
        this.LEBLtoLEMD=LEBLtoLEMD;
        this.numAviones=numAviones;        
    }  
        
    @Override
    public void run(){
        for(short j=1; j<=numAviones; j++){
            //Avion avion=new Avion(j, j%2==0?LEMD:LEBL);
            Avion avion=new Avion(j, LEMD, LEBL, LEMDtoLEBL, LEBLtoLEMD);
            avion.start();
            
            try{
                //Esperamos aleatoriamente entre 1 y 3 segundos:
                Thread.sleep((int)Math.floor(Math.random()*(3000-1000+1)+1000));
            }
            catch(InterruptedException ie){
                if (j%2==0) {
                    LEMD.escribirLog("Error al crear un avión de LEMD");
                } else {
                    LEBL.escribirLog("Error al crear un avión de LEBL");
                }
            }
            LEMD.interfaz.comprobarPausa();
            LEBL.interfaz.comprobarPausa();
        }
        
        while (true) {
            
        }
        
    }
    
    public Aerovia getAerovia(String sentido) {
        
        return (sentido=="LEMD"?LEBLtoLEMD:LEMDtoLEBL);
        
    }
}
