package parte1;

import java.awt.event.*;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import parte2.socketsTCP.ClienteSocketTCP;

public class Interfaz extends javax.swing.JFrame {
    
    private Pausa pausa; 
    private Log log;
    private String colorDespegues="#00008B";
    private String colorArribadas="#DAA520";
    
    private Timer timer;
    private long startTime;

    public Interfaz(Pausa pausa, Log log) {
        this.pausa=pausa; 
        this.log=log; 
        initComponents();
        
        //Look de Windows 10/11
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        }
        catch(Exception e){
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        //Centrar JFrame
        this.setLocationRelativeTo(null);
        
        //Ponemos los colores de los label según sean Despegues o Arribadas:
        lblPlataformaColaLEMD.setForeground(Color.decode(colorDespegues));
        lblPlataformaColaLEBL.setForeground(Color.decode(colorDespegues));
        lblPlataformaListaLEMD.setForeground(Color.decode(colorArribadas));
        lblPlataformaListaLEBL.setForeground(Color.decode(colorArribadas));

        lblPuertaEmbarque_0_LEMD.setForeground(Color.decode(colorDespegues));
        lblPuertaEmbarque_0_LEBL.setForeground(Color.decode(colorDespegues));
        lblPuertaEmbarque_1_LEMD.setForeground(Color.decode(colorArribadas));
        lblPuertaEmbarque_1_LEBL.setForeground(Color.decode(colorArribadas));
        
        lblRodajeD_LEMD.setForeground(Color.decode(colorDespegues));
        lblRodajeD_LEBL.setForeground(Color.decode(colorDespegues));
        lblRodajeA_LEMD.setForeground(Color.decode(colorArribadas));
        lblRodajeA_LEBL.setForeground(Color.decode(colorArribadas));
        
        /*lblPista1_LEMD.setForeground(Color.decode(colorDespegues));
        lblPista2_LEMD.setForeground(Color.decode(colorArribadas));        
        lblPista3_LEMD.setForeground(Color.decode(colorDespegues));
        lblPista4_LEMD.setForeground(Color.decode(colorArribadas));
        
        lblPista1_LEBL.setForeground(Color.decode(colorDespegues));
        lblPista2_LEBL.setForeground(Color.decode(colorArribadas));
        lblPista3_LEBL.setForeground(Color.decode(colorDespegues));
        lblPista4_LEBL.setForeground(Color.decode(colorArribadas));*/
        
        lblLeyendaDespegues.setForeground(Color.decode(colorDespegues));
        lblLeyendaArribadas.setForeground(Color.decode(colorArribadas));        
                
        //Iniciamos el cronómetro:
        startTime = System.currentTimeMillis();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;

                String tiempoFormateado = formatoCronometro(elapsedTime);
                lblCronometro.setText("Tiempo transcurrido: " + tiempoFormateado);
            }
        });
        timer.start();        
    }
    
    private String formatoCronometro(long tiempoMillis) {
        long segundos = tiempoMillis / 1000;
        long horas = segundos / 3600;
        segundos %= 3600;
        long minutos = segundos / 60;
        segundos %= 60;

        DecimalFormat formato = new DecimalFormat("00");
        return formato.format(horas) + ":" + formato.format(minutos) + ":" + formato.format(segundos);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JToggleButton();
        btnConsultarEstadisticas = new javax.swing.JToggleButton();
        panelAerovíaLEBLtoLEMD = new javax.swing.JPanel();
        lblVuelosLEBLtoLEMD = new javax.swing.JLabel();
        panelLEBL = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPlataformaColaLEBL = new javax.swing.JLabel();
        lblHangarLEBL = new javax.swing.JLabel();
        lblAforoLEBL = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblParadaLEBL = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblRodajeD_LEBL = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblRodajeA_LEBL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblEtiP1LEBL = new javax.swing.JLabel();
        lblPista1_LEBL = new javax.swing.JLabel();
        lblEtiP2LEBL = new javax.swing.JLabel();
        lblPista2_LEBL = new javax.swing.JLabel();
        lblEtiP3LEBL = new javax.swing.JLabel();
        lblPista3_LEBL = new javax.swing.JLabel();
        lblEtiP4LEBL = new javax.swing.JLabel();
        lblPista4_LEBL = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblPuertaEmbarque_2_LEBL = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblPuertaEmbarque_5_LEBL = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblPuertaEmbarque_1_LEBL = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblPuertaEmbarque_4_LEBL = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblPuertaEmbarque_0_LEBL = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblPuertaEmbarque_3_LEBL = new javax.swing.JLabel();
        lblPlataformaListaLEBL = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblTallerEtiquetaLEBL = new javax.swing.JLabel();
        lblTallerLEBL = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblPuertaTallerLEBL = new javax.swing.JLabel();
        panelBarcelona = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblParadaBarcelona = new javax.swing.JLabel();
        panelAerovíaLEMDtoLEBL = new javax.swing.JPanel();
        lblVuelosLEMDtoLEBL = new javax.swing.JLabel();
        panelLEMD = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPlataformaColaLEMD = new javax.swing.JLabel();
        lblHangarLEMD = new javax.swing.JLabel();
        lblAforoLEMD = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblParadaLEMD = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblRodajeD_LEMD = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblRodajeA_LEMD = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPista4_LEMD = new javax.swing.JLabel();
        lblEtiP4LEMD = new javax.swing.JLabel();
        lblPista2_LEMD = new javax.swing.JLabel();
        lblEtiP2LEMD = new javax.swing.JLabel();
        lblPista1_LEMD = new javax.swing.JLabel();
        lblEtiP1LEMD = new javax.swing.JLabel();
        lblEtiP3LEMD = new javax.swing.JLabel();
        lblPista3_LEMD = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblPuertaEmbarque_2_LEMD = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblPuertaEmbarque_5_LEMD = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblPuertaEmbarque_1_LEMD = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblPuertaEmbarque_4_LEMD = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPuertaEmbarque_0_LEMD = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblPuertaEmbarque_3_LEMD = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblPlataformaListaLEMD = new javax.swing.JLabel();
        lblTallerEtiquetaLEMD = new javax.swing.JLabel();
        lblTallerLEMD = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblPuertaTallerLEMD = new javax.swing.JLabel();
        panelMadrid = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblParadaMadrid = new javax.swing.JLabel();
        lblLeyendaArribadas = new javax.swing.JLabel();
        lblLeyendaDespegues = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblCronometro = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnPausarContinuar = new javax.swing.JToggleButton();
        jLabel41 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PECL Programación Avanzada 2024 - Aeropuertos");
        setMinimumSize(new java.awt.Dimension(1280, 810));
        setResizable(false);
        getContentPane().setLayout(null);

        btnSalir.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(380, 40, 150, 30);

        btnConsultarEstadisticas.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnConsultarEstadisticas.setText("Estadísticas");
        btnConsultarEstadisticas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultarEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarEstadisticasActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarEstadisticas);
        btnConsultarEstadisticas.setBounds(760, 40, 190, 30);

        panelAerovíaLEBLtoLEMD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aerovía LEMD <-- LEBL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelAerovíaLEBLtoLEMD.setName("panel_aerovia_LEMD_LEBL"); // NOI18N

        lblVuelosLEBLtoLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVuelosLEBLtoLEMD.setText(" ");

        javax.swing.GroupLayout panelAerovíaLEBLtoLEMDLayout = new javax.swing.GroupLayout(panelAerovíaLEBLtoLEMD);
        panelAerovíaLEBLtoLEMD.setLayout(panelAerovíaLEBLtoLEMDLayout);
        panelAerovíaLEBLtoLEMDLayout.setHorizontalGroup(
            panelAerovíaLEBLtoLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAerovíaLEBLtoLEMDLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblVuelosLEBLtoLEMD, javax.swing.GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAerovíaLEBLtoLEMDLayout.setVerticalGroup(
            panelAerovíaLEBLtoLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAerovíaLEBLtoLEMDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVuelosLEBLtoLEMD)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(panelAerovíaLEBLtoLEMD);
        panelAerovíaLEBLtoLEMD.setBounds(20, 690, 1240, 70);

        panelLEBL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aeropuerto LEBL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelLEBL.setName("panel_2"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setText("Nº de pasajeros en el aeropuerto:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Hangar:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel8.setText("Plataforma (cola D):");

        lblPlataformaColaLEBL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlataformaColaLEBL.setText(" ");

        lblHangarLEBL.setText(" ");

        lblAforoLEBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAforoLEBL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAforoLEBL.setText("0");

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel10.setText("Autobuses en la parada:");

        lblParadaLEBL.setText("0");

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel25.setText("Rodaje despegues:");

        lblRodajeD_LEBL.setText(" ");

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel26.setText("Rodaje aterrizajes:");

        lblRodajeA_LEBL.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEtiP1LEBL.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP1LEBL.setForeground(new java.awt.Color(0, 153, 51));
        lblEtiP1LEBL.setText("PISTA 1:");

        lblPista1_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista1_LEBL.setText(" ");

        lblEtiP2LEBL.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP2LEBL.setForeground(new java.awt.Color(0, 153, 51));
        lblEtiP2LEBL.setText("PISTA 2:");

        lblPista2_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista2_LEBL.setText(" ");

        lblEtiP3LEBL.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP3LEBL.setForeground(new java.awt.Color(0, 153, 51));
        lblEtiP3LEBL.setText("PISTA 3:");

        lblPista3_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista3_LEBL.setText(" ");

        lblEtiP4LEBL.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP4LEBL.setForeground(new java.awt.Color(0, 153, 51));
        lblEtiP4LEBL.setText("PISTA 4:");

        lblPista4_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista4_LEBL.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEtiP1LEBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista1_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEtiP3LEBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista3_LEBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEtiP2LEBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista2_LEBL, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEtiP4LEBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista4_LEBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEtiP1LEBL)
                        .addComponent(lblPista1_LEBL))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEtiP2LEBL)
                        .addComponent(lblPista2_LEBL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEtiP3LEBL)
                        .addComponent(lblPista3_LEBL))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEtiP4LEBL)
                        .addComponent(lblPista4_LEBL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel19.setText("Puerta DA3:");

        lblPuertaEmbarque_2_LEBL.setText(" ");

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel22.setText("Puerta DA6:");

        lblPuertaEmbarque_5_LEBL.setText(" ");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel18.setText("Puerta A2:");

        lblPuertaEmbarque_1_LEBL.setText(" ");

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel21.setText("Puerta DA5:");

        lblPuertaEmbarque_4_LEBL.setText(" ");

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel17.setText("Puerta D1:");

        lblPuertaEmbarque_0_LEBL.setText(" ");

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel20.setText("Puerta DA4:");

        lblPuertaEmbarque_3_LEBL.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuertaEmbarque_2_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuertaEmbarque_1_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPuertaEmbarque_5_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuertaEmbarque_4_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuertaEmbarque_0_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuertaEmbarque_3_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(lblPuertaEmbarque_3_LEBL))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lblPuertaEmbarque_0_LEBL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblPuertaEmbarque_1_LEBL)
                    .addComponent(jLabel21)
                    .addComponent(lblPuertaEmbarque_4_LEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(lblPuertaEmbarque_2_LEBL)
                        .addComponent(jLabel22))
                    .addComponent(lblPuertaEmbarque_5_LEBL))
                .addContainerGap())
        );

        lblPlataformaListaLEBL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlataformaListaLEBL.setText(" ");

        jLabel37.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel37.setText("Plataforma (lista A):");

        lblTallerEtiquetaLEBL.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTallerEtiquetaLEBL.setText("Taller (20):");

        lblTallerLEBL.setText(" ");

        jLabel39.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel39.setText("Puerta taller:");

        lblPuertaTallerLEBL.setText(" ");

        javax.swing.GroupLayout panelLEBLLayout = new javax.swing.GroupLayout(panelLEBL);
        panelLEBL.setLayout(panelLEBLLayout);
        panelLEBLLayout.setHorizontalGroup(
            panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLEBLLayout.createSequentialGroup()
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLEBLLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRodajeA_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLEBLLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRodajeD_LEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLEBLLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHangarLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlataformaColaLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLEBLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblParadaLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(lblAforoLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLEBLLayout.createSequentialGroup()
                                .addComponent(lblTallerEtiquetaLEBL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTallerLEBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLEBLLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlataformaListaLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLEBLLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuertaTallerLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelLEBLLayout.setVerticalGroup(
            panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLEBLLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblParadaLEBL)
                    .addComponent(jLabel2)
                    .addComponent(lblAforoLEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblHangarLEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lblPuertaTallerLEBL))
                .addGap(9, 9, 9)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTallerEtiquetaLEBL)
                    .addComponent(lblTallerLEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlataformaColaLEBL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblPlataformaListaLEBL))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblRodajeD_LEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblRodajeA_LEBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(panelLEBL);
        panelLEBL.setBounds(640, 140, 620, 440);

        panelBarcelona.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciudad de Barcelona", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelBarcelona.setName("panel_2"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Autobuses en la parada:");

        lblParadaBarcelona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParadaBarcelona.setText("0");

        javax.swing.GroupLayout panelBarcelonaLayout = new javax.swing.GroupLayout(panelBarcelona);
        panelBarcelona.setLayout(panelBarcelonaLayout);
        panelBarcelonaLayout.setHorizontalGroup(
            panelBarcelonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarcelonaLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblParadaBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBarcelonaLayout.setVerticalGroup(
            panelBarcelonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarcelonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarcelonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblParadaBarcelona))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(panelBarcelona);
        panelBarcelona.setBounds(640, 70, 620, 70);

        panelAerovíaLEMDtoLEBL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aerovía LEMD --> LEBL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelAerovíaLEMDtoLEBL.setName("panel_aerovia_LEMD_LEBL"); // NOI18N

        lblVuelosLEMDtoLEBL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVuelosLEMDtoLEBL.setText(" ");

        javax.swing.GroupLayout panelAerovíaLEMDtoLEBLLayout = new javax.swing.GroupLayout(panelAerovíaLEMDtoLEBL);
        panelAerovíaLEMDtoLEBL.setLayout(panelAerovíaLEMDtoLEBLLayout);
        panelAerovíaLEMDtoLEBLLayout.setHorizontalGroup(
            panelAerovíaLEMDtoLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAerovíaLEMDtoLEBLLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblVuelosLEMDtoLEBL, javax.swing.GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAerovíaLEMDtoLEBLLayout.setVerticalGroup(
            panelAerovíaLEMDtoLEBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAerovíaLEMDtoLEBLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVuelosLEMDtoLEBL)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(panelAerovíaLEMDtoLEBL);
        panelAerovíaLEMDtoLEBL.setBounds(20, 610, 1240, 70);

        panelLEMD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aeropuerto LEMD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelLEMD.setName("panel_2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Nº de pasajeros en el aeropuerto:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Hangar:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setText("Plataforma (cola D):");

        lblPlataformaColaLEMD.setForeground(java.awt.Color.blue);
        lblPlataformaColaLEMD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlataformaColaLEMD.setText(" ");

        lblHangarLEMD.setText(" ");

        lblAforoLEMD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAforoLEMD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAforoLEMD.setText("0");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel9.setText("Autobuses en la parada:");

        lblParadaLEMD.setText("0");

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel23.setText("Rodaje despegues:");

        lblRodajeD_LEMD.setForeground(java.awt.Color.blue);
        lblRodajeD_LEMD.setText(" ");

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel24.setText("Rodaje aterrizajes:");

        lblRodajeA_LEMD.setText(" ");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPista4_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista4_LEMD.setText(" ");

        lblEtiP4LEMD.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP4LEMD.setForeground(new java.awt.Color(0, 153, 0));
        lblEtiP4LEMD.setText("PISTA 4:");

        lblPista2_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista2_LEMD.setForeground(java.awt.Color.blue);
        lblPista2_LEMD.setText(" ");

        lblEtiP2LEMD.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP2LEMD.setForeground(new java.awt.Color(0, 153, 0));
        lblEtiP2LEMD.setText("PISTA 2:");

        lblPista1_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista1_LEMD.setForeground(java.awt.Color.blue);
        lblPista1_LEMD.setText(" ");

        lblEtiP1LEMD.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP1LEMD.setForeground(new java.awt.Color(0, 153, 0));
        lblEtiP1LEMD.setText("PISTA 1:");

        lblEtiP3LEMD.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lblEtiP3LEMD.setForeground(new java.awt.Color(0, 153, 0));
        lblEtiP3LEMD.setText("PISTA 3:");

        lblPista3_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPista3_LEMD.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEtiP1LEMD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista1_LEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEtiP3LEMD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPista3_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEtiP2LEMD, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEtiP4LEMD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPista2_LEMD, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(lblPista4_LEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiP1LEMD)
                    .addComponent(lblPista1_LEMD)
                    .addComponent(lblEtiP2LEMD)
                    .addComponent(lblPista2_LEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiP3LEMD)
                    .addComponent(lblPista3_LEMD)
                    .addComponent(lblEtiP4LEMD)
                    .addComponent(lblPista4_LEMD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel13.setText("Puerta DA3:");

        lblPuertaEmbarque_2_LEMD.setText(" ");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel16.setText("Puerta DA6:");

        lblPuertaEmbarque_5_LEMD.setText(" ");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel12.setText("Puerta A2:");

        lblPuertaEmbarque_1_LEMD.setText(" ");

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel15.setText("Puerta DA5:");

        lblPuertaEmbarque_4_LEMD.setText(" ");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel11.setText("Puerta D1:");

        lblPuertaEmbarque_0_LEMD.setText(" ");

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel14.setText("Puerta DA4:");

        lblPuertaEmbarque_3_LEMD.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPuertaEmbarque_0_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPuertaEmbarque_2_LEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPuertaEmbarque_1_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuertaEmbarque_3_LEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPuertaEmbarque_5_LEMD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPuertaEmbarque_4_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblPuertaEmbarque_0_LEMD)
                    .addComponent(jLabel14)
                    .addComponent(lblPuertaEmbarque_3_LEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblPuertaEmbarque_1_LEMD)
                    .addComponent(jLabel15)
                    .addComponent(lblPuertaEmbarque_4_LEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblPuertaEmbarque_2_LEMD)
                    .addComponent(jLabel16)
                    .addComponent(lblPuertaEmbarque_5_LEMD))
                .addContainerGap())
        );

        jLabel32.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel32.setText("Plataforma (lista A):");

        lblPlataformaListaLEMD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlataformaListaLEMD.setText(" ");

        lblTallerEtiquetaLEMD.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTallerEtiquetaLEMD.setText("Taller (20):");

        lblTallerLEMD.setText(" ");

        jLabel54.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel54.setText("Puerta taller:");

        lblPuertaTallerLEMD.setText(" ");

        javax.swing.GroupLayout panelLEMDLayout = new javax.swing.GroupLayout(panelLEMD);
        panelLEMD.setLayout(panelLEMDLayout);
        panelLEMDLayout.setHorizontalGroup(
            panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLEMDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLEMDLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblParadaLEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAforoLEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLEMDLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRodajeD_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLEMDLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRodajeA_LEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLEMDLayout.createSequentialGroup()
                        .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPlataformaColaLEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPlataformaListaLEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLEMDLayout.createSequentialGroup()
                            .addComponent(jLabel54)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPuertaTallerLEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLEMDLayout.createSequentialGroup()
                            .addComponent(lblTallerEtiquetaLEMD)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTallerLEMD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLEMDLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblHangarLEMD, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLEMDLayout.setVerticalGroup(
            panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLEMDLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblParadaLEMD)
                    .addComponent(jLabel3)
                    .addComponent(lblAforoLEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblHangarLEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(lblPuertaTallerLEMD))
                .addGap(7, 7, 7)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTallerEtiquetaLEMD)
                    .addComponent(lblTallerLEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblPlataformaColaLEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblPlataformaListaLEMD))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRodajeD_LEMD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLEMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblRodajeA_LEMD))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(panelLEMD);
        panelLEMD.setBounds(20, 140, 620, 440);

        panelMadrid.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ciudad de Madrid", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelMadrid.setName("panel_2"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Autobuses en la parada:");

        lblParadaMadrid.setText("0");

        javax.swing.GroupLayout panelMadridLayout = new javax.swing.GroupLayout(panelMadrid);
        panelMadrid.setLayout(panelMadridLayout);
        panelMadridLayout.setHorizontalGroup(
            panelMadridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMadridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblParadaMadrid, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMadridLayout.setVerticalGroup(
            panelMadridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMadridLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMadridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblParadaMadrid))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(panelMadrid);
        panelMadrid.setBounds(20, 70, 620, 70);

        lblLeyendaArribadas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLeyendaArribadas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLeyendaArribadas.setText("Arribadas");
        getContentPane().add(lblLeyendaArribadas);
        lblLeyendaArribadas.setBounds(1160, 30, 90, 20);

        lblLeyendaDespegues.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLeyendaDespegues.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLeyendaDespegues.setText("Despegues");
        getContentPane().add(lblLeyendaDespegues);
        lblLeyendaDespegues.setBounds(1160, 10, 90, 20);

        jLabel33.setText("Guillermo González Martínez");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(20, 40, 240, 16);

        lblCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCronometro.setText(" ");
        getContentPane().add(lblCronometro);
        lblCronometro.setBounds(530, 10, 230, 16);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Leyenda:");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(1060, 10, 100, 20);

        btnPausarContinuar.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnPausarContinuar.setText("Pausar/Continuar");
        btnPausarContinuar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPausarContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPausarContinuar);
        btnPausarContinuar.setBounds(550, 40, 190, 30);

        jLabel41.setText("David Romero Oñoro");
        getContentPane().add(jLabel41);
        jLabel41.setBounds(20, 20, 230, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        log.cerrarLog();
        System.exit(0); 
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEstadisticasActionPerformed
        ClienteSocketTCP interfazEstadisticasSocketTCP = new ClienteSocketTCP(log);        
        interfazEstadisticasSocketTCP.setVisible(true);
    }//GEN-LAST:event_btnConsultarEstadisticasActionPerformed

    private void btnPausarContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarContinuarActionPerformed
        if(btnConsultarEstadisticas.isSelected()){
            pausa.pausar();
        }
        else{
            pausa.continuar();
        }
    }//GEN-LAST:event_btnPausarContinuarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConsultarEstadisticas;
    private javax.swing.JToggleButton btnPausarContinuar;
    private javax.swing.JToggleButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAforoLEBL;
    private javax.swing.JLabel lblAforoLEMD;
    private javax.swing.JLabel lblCronometro;
    private javax.swing.JLabel lblEtiP1LEBL;
    private javax.swing.JLabel lblEtiP1LEMD;
    private javax.swing.JLabel lblEtiP2LEBL;
    private javax.swing.JLabel lblEtiP2LEMD;
    private javax.swing.JLabel lblEtiP3LEBL;
    private javax.swing.JLabel lblEtiP3LEMD;
    private javax.swing.JLabel lblEtiP4LEBL;
    private javax.swing.JLabel lblEtiP4LEMD;
    private javax.swing.JLabel lblHangarLEBL;
    private javax.swing.JLabel lblHangarLEMD;
    private javax.swing.JLabel lblLeyendaArribadas;
    private javax.swing.JLabel lblLeyendaDespegues;
    private javax.swing.JLabel lblParadaBarcelona;
    private javax.swing.JLabel lblParadaLEBL;
    private javax.swing.JLabel lblParadaLEMD;
    private javax.swing.JLabel lblParadaMadrid;
    private javax.swing.JLabel lblPista1_LEBL;
    private javax.swing.JLabel lblPista1_LEMD;
    private javax.swing.JLabel lblPista2_LEBL;
    private javax.swing.JLabel lblPista2_LEMD;
    private javax.swing.JLabel lblPista3_LEBL;
    private javax.swing.JLabel lblPista3_LEMD;
    private javax.swing.JLabel lblPista4_LEBL;
    private javax.swing.JLabel lblPista4_LEMD;
    private javax.swing.JLabel lblPlataformaColaLEBL;
    private javax.swing.JLabel lblPlataformaColaLEMD;
    private javax.swing.JLabel lblPlataformaListaLEBL;
    private javax.swing.JLabel lblPlataformaListaLEMD;
    private javax.swing.JLabel lblPuertaEmbarque_0_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_0_LEMD;
    private javax.swing.JLabel lblPuertaEmbarque_1_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_1_LEMD;
    private javax.swing.JLabel lblPuertaEmbarque_2_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_2_LEMD;
    private javax.swing.JLabel lblPuertaEmbarque_3_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_3_LEMD;
    private javax.swing.JLabel lblPuertaEmbarque_4_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_4_LEMD;
    private javax.swing.JLabel lblPuertaEmbarque_5_LEBL;
    private javax.swing.JLabel lblPuertaEmbarque_5_LEMD;
    private javax.swing.JLabel lblPuertaTallerLEBL;
    private javax.swing.JLabel lblPuertaTallerLEMD;
    private javax.swing.JLabel lblRodajeA_LEBL;
    private javax.swing.JLabel lblRodajeA_LEMD;
    private javax.swing.JLabel lblRodajeD_LEBL;
    private javax.swing.JLabel lblRodajeD_LEMD;
    private javax.swing.JLabel lblTallerEtiquetaLEBL;
    private javax.swing.JLabel lblTallerEtiquetaLEMD;
    private javax.swing.JLabel lblTallerLEBL;
    private javax.swing.JLabel lblTallerLEMD;
    private javax.swing.JLabel lblVuelosLEBLtoLEMD;
    private javax.swing.JLabel lblVuelosLEMDtoLEBL;
    private javax.swing.JPanel panelAerovíaLEBLtoLEMD;
    private javax.swing.JPanel panelAerovíaLEMDtoLEBL;
    private javax.swing.JPanel panelBarcelona;
    private javax.swing.JPanel panelLEBL;
    private javax.swing.JPanel panelLEMD;
    private javax.swing.JPanel panelMadrid;
    // End of variables declaration//GEN-END:variables
    
    public synchronized void setTextoParada (String t, String ubicacion){
        switch (ubicacion) {
            case "Madrid":  lblParadaMadrid.setText(t);
                            break;
            case "Barcelona":  lblParadaBarcelona.setText(t);
                            break;
            case "LEMD":    lblParadaLEMD.setText(t);
                            break;
            case "LEBL":    lblParadaLEBL.setText(t);
                            break;
        }        
    }
    
    public synchronized void setTextoAforoAeropuerto (Aeropuerto aeropuerto){
        if (aeropuerto.getCiudad().equals("Madrid")) {
            lblAforoLEMD.setText(""+aeropuerto.pasajeros.get());
        } else {
            lblAforoLEBL.setText(""+aeropuerto.pasajeros.get());
        }
    }
        
    public synchronized void setTextoHangar(String t, String codigoOACI) {
        if (codigoOACI=="LEMD") {
            lblHangarLEMD.setText(t);
        } else {//if (codigoOACI=="LEBL") {
            lblHangarLEBL.setText(t);
        }            
    }
    
    public synchronized void setTextoPlataforma (String t, String codigoOACI, boolean despegue) {
        if (despegue) {
            if (codigoOACI=="LEMD") {
                lblPlataformaColaLEMD.setText(t);                
            } else {
                lblPlataformaColaLEBL.setText(t);                
            }
        } else {
            if (codigoOACI=="LEMD") {
                lblPlataformaListaLEMD.setText(t);
            } else {//if (codigoOACI=="LEBL") {
                lblPlataformaListaLEBL.setText(t);
            }
            
        }
    }
        
    public synchronized void setTextoPuertaEmbarque (short numPuerta, String codigoOACI, String identificador, boolean despegue, short c, short p) {
        
        
        if (identificador!="") {
            identificador+= (identificador!=""?("(c = " + c + ", p = " + p + ")"):"");
        }
        if (codigoOACI=="LEMD") {
            if (numPuerta == 0){                
                lblPuertaEmbarque_0_LEMD.setText(identificador);
            }
            if (numPuerta == 1){
                lblPuertaEmbarque_1_LEMD.setForeground(Color.decode(colorArribadas));
                lblPuertaEmbarque_1_LEMD.setText(identificador);
            }
            if (numPuerta == 2){
                lblPuertaEmbarque_2_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_2_LEMD.setText(identificador);
            }
            if (numPuerta == 3){
                lblPuertaEmbarque_3_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_3_LEMD.setText(identificador);
            }
            if (numPuerta == 4){
                lblPuertaEmbarque_4_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_4_LEMD.setText(identificador);
            }
            if (numPuerta == 5){
                lblPuertaEmbarque_5_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_5_LEMD.setText(identificador);
            }            
        }
        if (codigoOACI=="LEBL") {
            if (numPuerta == 0){
                lblPuertaEmbarque_0_LEBL.setForeground(Color.decode(colorDespegues));
                lblPuertaEmbarque_0_LEBL.setText(identificador);
            }
            if (numPuerta == 1){
                lblPuertaEmbarque_1_LEBL.setForeground(Color.decode(colorArribadas));
                lblPuertaEmbarque_1_LEBL.setText(identificador);
            }
            if (numPuerta == 2){
                lblPuertaEmbarque_2_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_2_LEBL.setText(identificador);
            }
            if (numPuerta == 3){
                lblPuertaEmbarque_3_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_3_LEBL.setText(identificador);
            }
            if (numPuerta == 4){
                lblPuertaEmbarque_4_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_4_LEBL.setText(identificador);
            }
            if (numPuerta == 5){
                lblPuertaEmbarque_5_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPuertaEmbarque_5_LEBL.setText(identificador);
            }            
        }        
    }
        
    public synchronized void setTextoRodaje (String t, String codigoOACI, boolean despegue, short pasajeros, short numAviones) {
        //le añado los pasajeros que lleva el último avión metido, pero solo si si hay aviones en la lista:        
        String texto=t;
        if (codigoOACI=="LEMD") {
            if (despegue) {
                lblRodajeD_LEMD.setText(texto); 
                jLabel23.setText("Rodaje Despegues ("+numAviones+"):");
            } else {
                lblRodajeA_LEMD.setText(texto);                
            }
        } else {
            if (despegue) {
                lblRodajeD_LEBL.setText(texto);
                jLabel25.setText("Rodaje Despegues ("+numAviones+"):");
            } else {
                lblRodajeA_LEBL.setText(texto);
            }            
        }            
    }
    
    public synchronized void setTextoPista (String id_avion, String codigoOACI, short id_pista, boolean despegue) {
        if (codigoOACI=="LEMD") {
            if (id_pista==0) {
                lblPista1_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista1_LEMD.setText(id_avion);
            } else if (id_pista==1) {
                lblPista2_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista2_LEMD.setText(id_avion);
            } else if (id_pista==2) {
                lblPista3_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista3_LEMD.setText(id_avion);
            } else if (id_pista==3) {
                lblPista4_LEMD.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista4_LEMD.setText(id_avion);
            }  
        } else {
            if (id_pista==0) {
                lblPista1_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista1_LEBL.setText(id_avion);
            } else if (id_pista==1) {
                lblPista2_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista2_LEBL.setText(id_avion);
            } else if (id_pista==2) {
                lblPista3_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista3_LEBL.setText(id_avion);
            } else if (id_pista==3) {
                lblPista4_LEBL.setForeground(despegue?Color.decode(colorDespegues):Color.decode(colorArribadas));
                lblPista4_LEBL.setText(id_avion);
            }
        }            
    }
    
    public void setLabelPistas(short numPista, String texto){
        switch (numPista) {
            case 0:                
                lblEtiP1LEMD.setText(texto); //LEMD
                lblEtiP1LEBL.setText(texto); //LEBL
                break;
            case 1:                
                lblEtiP2LEMD.setText(texto);
                lblEtiP2LEBL.setText(texto);
                break;
            case 2:                
                lblEtiP3LEMD.setText(texto);
                lblEtiP3LEBL.setText(texto);
                break;
            case 3:                
                lblEtiP4LEMD.setText(texto);
                lblEtiP4LEBL.setText(texto);
        }        
    }
    
    
    public synchronized void setTextoAerovía (String texto, String destino) {
        //le añado los pasajeros que lleva el último avión metido, pero solo si si hay aviones en la lista:
        // String texto= (t+(t!=""?(" ("+pasajeros+")"):""));                
        if (destino=="LEMD") {
            lblVuelosLEBLtoLEMD.setText(texto); 
        } else {
            lblVuelosLEMDtoLEBL.setText(texto);
        }                    
    }
    
    public synchronized void setTextoTaller (String texto, String codigoOACI, short plazasLibres) {
        //le añado los pasajeros que lleva el último avión metido, pero solo si si hay aviones en la lista:
        String textoEtiqueta = "Taller ("+plazasLibres+")";
        
        if (codigoOACI=="LEMD") {
            lblTallerEtiquetaLEMD.setText("Taller ("+plazasLibres +"):");
            lblTallerLEMD.setText( texto);
        } else {
            lblTallerEtiquetaLEBL.setText("Taller ("+plazasLibres +"):");
            lblTallerLEBL.setText( texto);
        }                    
    }
    
    public synchronized void setTextoPuerta (String id_avion, String codigoOACI) {
        if (codigoOACI=="LEMD") {
            lblPuertaTallerLEMD.setText(id_avion); 
        } else {
            lblPuertaTallerLEBL.setText(id_avion);
        }
    }
    
    public synchronized void setColorPista (String codigoOACI, short pista, boolean abrir) {
        log.escribirLog("estoy en setColorPista con " + codigoOACI + ", " + pista + ", " + (abrir?"true":"false"));
        if (codigoOACI=="LEMD"){
            switch (pista) {
                case 0:
                    lblEtiP1LEMD.setForeground(abrir?Color.green:Color.red);
                    lblEtiP1LEMD.setText("Pista "+((short)pista+1)+":");
                    break;
                case 1:
                    lblEtiP2LEMD.setForeground(abrir?Color.green:Color.red);
                    lblEtiP2LEMD.setText("Pista "+((short)pista+1)+":");
                    break;
                case 2:
                    lblEtiP3LEMD.setForeground(abrir?Color.green:Color.red);
                    lblEtiP3LEMD.setText("Pista "+((short)pista+1)+":");
                    break;
                case 3:
                    lblEtiP4LEMD.setForeground(abrir?Color.green:Color.red);
                    lblEtiP4LEMD.setText("Pista "+((short)pista+1)+":");
                    break;
            }
        } else {
            switch (pista) {
                case 0:
                    lblEtiP1LEBL.setForeground(abrir?Color.green:Color.red);
                    lblEtiP1LEBL.setText("Pista "+((short)pista+1)+":");
                    break;
                case 1:
                    lblEtiP2LEBL.setForeground(abrir?Color.green:Color.red);
                    lblEtiP2LEBL.setText("Pista "+((short)pista+1)+":");
                    break;
                case 2:
                    lblEtiP3LEBL.setForeground(abrir?Color.green:Color.red);
                    lblEtiP3LEBL.setText("Pista "+((short)pista+1)+":");
                    break;
                case 3:
                    lblEtiP4LEBL.setForeground(abrir?Color.green:Color.red);
                    lblEtiP4LEBL.setText("Pista "+((short)pista+1)+":");
                    break;
            }
        }
    }
      
    public void comprobarPausa(){
        pausa.pasar();
    }

}
