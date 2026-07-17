
package parte2.socketsTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.UIManager;
import parte1.Log;
//import parte1.InterfazAeropuerto;

public class ClienteSocketTCP extends javax.swing.JFrame {
    
    private Log log;
    private Socket socket; 
    private DataInputStream entrada; 
    private DataOutputStream salida;    

    //InterfazAeropuerto LEMD;
    
    public ClienteSocketTCP(Log log) {
        this.log=log;
        /*Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        LEMD = (InterfazAeropuerto) registry.lookup("Aeropuerto");*/
        initComponents();
        
        //Look de Windows 10/11
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        }
        catch(Exception e){
            java.util.logging.Logger.getLogger(ClienteSocketTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        //Centrar JFrame
        this.setLocationRelativeTo(null);
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEstadisticas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNumPasajerosLEMD = new javax.swing.JLabel();
        btnConsultarNumPasajerosLEMD = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblNumAvionesHangarLEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesHangarLEMD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblNumAvionesTallerLEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesTallerLEMD = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblNumAvionesPlataformaColaLEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesPlataformaColaLEMD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblNumAvionesPlataformaListaLEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesPlataformaListaLEMD = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblNumAvionesRodajeD_LEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesRodajeD_LEMD = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblNumAvionesRodajeA_LEMD = new javax.swing.JLabel();
        btnConsultarNumAvionesRodajeA_LEMD = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        chkPista1_LEMD = new javax.swing.JCheckBox();
        chkPista2_LEMD = new javax.swing.JCheckBox();
        chkPista3_LEMD = new javax.swing.JCheckBox();
        chkPista4_LEMD = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNumPasajerosLEBL = new javax.swing.JLabel();
        btnConsultarNumPasajerosLEBL = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblNumAvionesHangarLEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesHangarLEBL = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblNumAvionesTallerLEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesTallerLEBL = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblNumAvionesPlataformaColaLEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesPlataformaColaLEBL = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblNumAvionesPlataformaListaLEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesPlataformaListaLEBL = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblNumAvionesRodajeD_LEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesRodajeD_LEBL = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblNumAvionesRodajeA_LEBL = new javax.swing.JLabel();
        btnConsultarNumAvionesRodajeA_LEBL = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        chkPista1_LEBL = new javax.swing.JCheckBox();
        chkPista2_LEBL = new javax.swing.JCheckBox();
        chkPista3_LEBL = new javax.swing.JCheckBox();
        chkPista4_LEBL = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnConsultarVuelosToLEBL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaVuelosToLEBL = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnConsultarVuelosToLEMD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaVuelosToLEMD = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PECL Programación Avanzada 2024 - Estadísticas");
        setBackground(java.awt.Color.gray);
        setMinimumSize(new java.awt.Dimension(823, 491));
        setPreferredSize(new java.awt.Dimension(830, 660));
        setResizable(false);
        getContentPane().setLayout(null);

        labelEstadisticas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelEstadisticas.setText("ESTADÍSTICAS");
        getContentPane().add(labelEstadisticas);
        labelEstadisticas.setBounds(320, 0, 190, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LEMD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Número de pasajeros:");
        jPanel1.add(jLabel2);

        lblNumPasajerosLEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumPasajerosLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumPasajerosLEMD.setText("   ");
        jPanel1.add(lblNumPasajerosLEMD);

        btnConsultarNumPasajerosLEMD.setText("Consultar");
        btnConsultarNumPasajerosLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumPasajerosLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumPasajerosLEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumPasajerosLEMD);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Número de aviones en Hangar:");
        jPanel1.add(jLabel4);

        lblNumAvionesHangarLEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesHangarLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesHangarLEMD.setText("   ");
        jPanel1.add(lblNumAvionesHangarLEMD);

        btnConsultarNumAvionesHangarLEMD.setText("Consultar");
        btnConsultarNumAvionesHangarLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesHangarLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesHangarLEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesHangarLEMD);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Número de aviones en Taller:");
        jPanel1.add(jLabel6);

        lblNumAvionesTallerLEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesTallerLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesTallerLEMD.setText("   ");
        jPanel1.add(lblNumAvionesTallerLEMD);

        btnConsultarNumAvionesTallerLEMD.setText("Consultar");
        btnConsultarNumAvionesTallerLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesTallerLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesTallerLEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesTallerLEMD);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Número de aviones en plataforma D:");
        jPanel1.add(jLabel8);

        lblNumAvionesPlataformaColaLEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesPlataformaColaLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesPlataformaColaLEMD.setText("   ");
        jPanel1.add(lblNumAvionesPlataformaColaLEMD);

        btnConsultarNumAvionesPlataformaColaLEMD.setText("Consultar");
        btnConsultarNumAvionesPlataformaColaLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesPlataformaColaLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesPlataformaColaLEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesPlataformaColaLEMD);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Número de aviones en plataforma A:");
        jPanel1.add(jLabel9);

        lblNumAvionesPlataformaListaLEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesPlataformaListaLEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesPlataformaListaLEMD.setText("   ");
        jPanel1.add(lblNumAvionesPlataformaListaLEMD);

        btnConsultarNumAvionesPlataformaListaLEMD.setText("Consultar");
        btnConsultarNumAvionesPlataformaListaLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesPlataformaListaLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesPlataformaListaLEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesPlataformaListaLEMD);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Número de aviones en rodaje D:");
        jPanel1.add(jLabel12);

        lblNumAvionesRodajeD_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesRodajeD_LEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesRodajeD_LEMD.setText("   ");
        jPanel1.add(lblNumAvionesRodajeD_LEMD);

        btnConsultarNumAvionesRodajeD_LEMD.setText("Consultar");
        btnConsultarNumAvionesRodajeD_LEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesRodajeD_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesRodajeD_LEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesRodajeD_LEMD);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Número de aviones en rodaje A:");
        jPanel1.add(jLabel13);

        lblNumAvionesRodajeA_LEMD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesRodajeA_LEMD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesRodajeA_LEMD.setText("   ");
        jPanel1.add(lblNumAvionesRodajeA_LEMD);

        btnConsultarNumAvionesRodajeA_LEMD.setText("Consultar");
        btnConsultarNumAvionesRodajeA_LEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesRodajeA_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesRodajeA_LEMDActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarNumAvionesRodajeA_LEMD);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setMinimumSize(new java.awt.Dimension(480, 80));
        jPanel5.setPreferredSize(new java.awt.Dimension(280, 80));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        chkPista1_LEMD.setSelected(true);
        chkPista1_LEMD.setText("Pista 1");
        chkPista1_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista1_LEMDActionPerformed(evt);
            }
        });
        jPanel5.add(chkPista1_LEMD);

        chkPista2_LEMD.setSelected(true);
        chkPista2_LEMD.setText("Pista 2");
        chkPista2_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista2_LEMDActionPerformed(evt);
            }
        });
        jPanel5.add(chkPista2_LEMD);

        chkPista3_LEMD.setSelected(true);
        chkPista3_LEMD.setText("Pista 3");
        chkPista3_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista3_LEMDActionPerformed(evt);
            }
        });
        jPanel5.add(chkPista3_LEMD);

        chkPista4_LEMD.setSelected(true);
        chkPista4_LEMD.setText("Pista 4");
        chkPista4_LEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista4_LEMDActionPerformed(evt);
            }
        });
        jPanel5.add(chkPista4_LEMD);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 40, 350, 320);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LEBL", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Número de pasajeros LEBL:");
        jPanel2.add(jLabel3);

        lblNumPasajerosLEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumPasajerosLEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumPasajerosLEBL.setText("   ");
        jPanel2.add(lblNumPasajerosLEBL);

        btnConsultarNumPasajerosLEBL.setText("Consultar");
        btnConsultarNumPasajerosLEBL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnConsultarNumPasajerosLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnConsultarNumPasajerosLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumPasajerosLEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumPasajerosLEBL);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Número de aviones en Hangar:");
        jPanel2.add(jLabel5);

        lblNumAvionesHangarLEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesHangarLEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesHangarLEBL.setText("   ");
        jPanel2.add(lblNumAvionesHangarLEBL);

        btnConsultarNumAvionesHangarLEBL.setText("Consultar");
        btnConsultarNumAvionesHangarLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesHangarLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesHangarLEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesHangarLEBL);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Número de aviones en Taller:");
        jPanel2.add(jLabel7);

        lblNumAvionesTallerLEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesTallerLEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesTallerLEBL.setText("   ");
        jPanel2.add(lblNumAvionesTallerLEBL);

        btnConsultarNumAvionesTallerLEBL.setText("Consultar");
        btnConsultarNumAvionesTallerLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesTallerLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesTallerLEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesTallerLEBL);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Número de aviones en plataforma D:");
        jPanel2.add(jLabel10);

        lblNumAvionesPlataformaColaLEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesPlataformaColaLEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesPlataformaColaLEBL.setText("   ");
        jPanel2.add(lblNumAvionesPlataformaColaLEBL);

        btnConsultarNumAvionesPlataformaColaLEBL.setText("Consultar");
        btnConsultarNumAvionesPlataformaColaLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesPlataformaColaLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesPlataformaColaLEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesPlataformaColaLEBL);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Número de aviones en plataforma A:");
        jPanel2.add(jLabel11);

        lblNumAvionesPlataformaListaLEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesPlataformaListaLEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesPlataformaListaLEBL.setText("   ");
        jPanel2.add(lblNumAvionesPlataformaListaLEBL);

        btnConsultarNumAvionesPlataformaListaLEBL.setText("Consultar");
        btnConsultarNumAvionesPlataformaListaLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesPlataformaListaLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesPlataformaListaLEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesPlataformaListaLEBL);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Número de aviones en rodaje D:");
        jPanel2.add(jLabel14);

        lblNumAvionesRodajeD_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesRodajeD_LEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesRodajeD_LEBL.setText("   ");
        jPanel2.add(lblNumAvionesRodajeD_LEBL);

        btnConsultarNumAvionesRodajeD_LEBL.setText("Consultar");
        btnConsultarNumAvionesRodajeD_LEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesRodajeD_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesRodajeD_LEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesRodajeD_LEBL);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Número de aviones en rodaje A:");
        jPanel2.add(jLabel15);

        lblNumAvionesRodajeA_LEBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumAvionesRodajeA_LEBL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumAvionesRodajeA_LEBL.setText("   ");
        jPanel2.add(lblNumAvionesRodajeA_LEBL);

        btnConsultarNumAvionesRodajeA_LEBL.setText("Consultar");
        btnConsultarNumAvionesRodajeA_LEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarNumAvionesRodajeA_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNumAvionesRodajeA_LEBLActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarNumAvionesRodajeA_LEBL);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel6.setMinimumSize(new java.awt.Dimension(480, 80));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 80));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        chkPista1_LEBL.setSelected(true);
        chkPista1_LEBL.setText("Pista 1");
        chkPista1_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista1_LEBLActionPerformed(evt);
            }
        });
        jPanel6.add(chkPista1_LEBL);

        chkPista2_LEBL.setSelected(true);
        chkPista2_LEBL.setText("Pista 2");
        chkPista2_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista2_LEBLActionPerformed(evt);
            }
        });
        jPanel6.add(chkPista2_LEBL);

        chkPista3_LEBL.setSelected(true);
        chkPista3_LEBL.setText("Pista 3");
        chkPista3_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista3_LEBLActionPerformed(evt);
            }
        });
        jPanel6.add(chkPista3_LEBL);

        chkPista4_LEBL.setSelected(true);
        chkPista4_LEBL.setText("Pista 4");
        chkPista4_LEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPista4_LEBLActionPerformed(evt);
            }
        });
        jPanel6.add(chkPista4_LEBL);

        jPanel2.add(jPanel6);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(450, 40, 340, 320);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aerovía LEMD --> LEBL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnConsultarVuelosToLEBL.setText("Consultar");
        btnConsultarVuelosToLEBL.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarVuelosToLEBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVuelosToLEBLActionPerformed(evt);
            }
        });

        txtaVuelosToLEBL.setEditable(false);
        txtaVuelosToLEBL.setColumns(110);
        txtaVuelosToLEBL.setLineWrap(true);
        txtaVuelosToLEBL.setRows(4);
        txtaVuelosToLEBL.setBorder(null);
        jScrollPane1.setViewportView(txtaVuelosToLEBL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnConsultarVuelosToLEBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnConsultarVuelosToLEBL)
                .addGap(28, 39, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 380, 770, 110);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aerovía LEMD <-- LEBL  ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnConsultarVuelosToLEMD.setText("Consultar");
        btnConsultarVuelosToLEMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarVuelosToLEMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVuelosToLEMDActionPerformed(evt);
            }
        });

        txtaVuelosToLEMD.setEditable(false);
        txtaVuelosToLEMD.setColumns(40);
        txtaVuelosToLEMD.setLineWrap(true);
        txtaVuelosToLEMD.setRows(4);
        txtaVuelosToLEMD.setBorder(null);
        jScrollPane2.setViewportView(txtaVuelosToLEMD);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarVuelosToLEMD)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnConsultarVuelosToLEMD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 500, 770, 110);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Sockets TCP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(700, 10, 90, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarNumPasajerosLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumPasajerosLEMDActionPerformed
        lblNumPasajerosLEMD.setText(String.valueOf(consultar(0)));        
    }//GEN-LAST:event_btnConsultarNumPasajerosLEMDActionPerformed

    private void btnConsultarNumPasajerosLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumPasajerosLEBLActionPerformed
        lblNumPasajerosLEBL.setText(String.valueOf(consultar(1)));
    }//GEN-LAST:event_btnConsultarNumPasajerosLEBLActionPerformed

    private void btnConsultarNumAvionesHangarLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesHangarLEMDActionPerformed
        lblNumAvionesHangarLEMD.setText(String.valueOf(consultar(2)));
    }//GEN-LAST:event_btnConsultarNumAvionesHangarLEMDActionPerformed

    private void btnConsultarNumAvionesHangarLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesHangarLEBLActionPerformed
        lblNumAvionesHangarLEBL.setText(String.valueOf(consultar(3)));
    }//GEN-LAST:event_btnConsultarNumAvionesHangarLEBLActionPerformed

    private void btnConsultarVuelosToLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVuelosToLEBLActionPerformed
        txtaVuelosToLEBL.setText(consultarVuelos(20));
    }//GEN-LAST:event_btnConsultarVuelosToLEBLActionPerformed

    private void btnConsultarVuelosToLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVuelosToLEMDActionPerformed
        txtaVuelosToLEMD.setText(consultarVuelos(21));
    }//GEN-LAST:event_btnConsultarVuelosToLEMDActionPerformed

    private void btnConsultarNumAvionesTallerLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesTallerLEMDActionPerformed
        lblNumAvionesTallerLEMD.setText(String.valueOf(consultar(4)));
    }//GEN-LAST:event_btnConsultarNumAvionesTallerLEMDActionPerformed

    private void btnConsultarNumAvionesTallerLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesTallerLEBLActionPerformed
        lblNumAvionesTallerLEBL.setText(String.valueOf(consultar(5)));
    }//GEN-LAST:event_btnConsultarNumAvionesTallerLEBLActionPerformed

    private void btnConsultarNumAvionesPlataformaColaLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesPlataformaColaLEMDActionPerformed
        lblNumAvionesPlataformaColaLEMD.setText(String.valueOf(consultar(6)));
    }//GEN-LAST:event_btnConsultarNumAvionesPlataformaColaLEMDActionPerformed

    private void btnConsultarNumAvionesPlataformaListaLEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesPlataformaListaLEMDActionPerformed
        lblNumAvionesPlataformaListaLEMD.setText(String.valueOf(consultar(7)));
    }//GEN-LAST:event_btnConsultarNumAvionesPlataformaListaLEMDActionPerformed

    private void btnConsultarNumAvionesPlataformaColaLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesPlataformaColaLEBLActionPerformed
        lblNumAvionesPlataformaColaLEBL.setText(String.valueOf(consultar(8)));
    }//GEN-LAST:event_btnConsultarNumAvionesPlataformaColaLEBLActionPerformed

    private void btnConsultarNumAvionesPlataformaListaLEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesPlataformaListaLEBLActionPerformed
        lblNumAvionesPlataformaListaLEBL.setText(String.valueOf(consultar(9)));
    }//GEN-LAST:event_btnConsultarNumAvionesPlataformaListaLEBLActionPerformed

    private void btnConsultarNumAvionesRodajeD_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesRodajeD_LEMDActionPerformed
        lblNumAvionesRodajeD_LEMD.setText(String.valueOf(consultar(10)));
    }//GEN-LAST:event_btnConsultarNumAvionesRodajeD_LEMDActionPerformed

    private void btnConsultarNumAvionesRodajeA_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesRodajeA_LEMDActionPerformed
        lblNumAvionesRodajeA_LEMD.setText(String.valueOf(consultar(11)));
    }//GEN-LAST:event_btnConsultarNumAvionesRodajeA_LEMDActionPerformed

    private void btnConsultarNumAvionesRodajeD_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesRodajeD_LEBLActionPerformed
        lblNumAvionesRodajeD_LEBL.setText(String.valueOf(consultar(12)));
    }//GEN-LAST:event_btnConsultarNumAvionesRodajeD_LEBLActionPerformed

    private void btnConsultarNumAvionesRodajeA_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNumAvionesRodajeA_LEBLActionPerformed
        lblNumAvionesRodajeA_LEBL.setText(String.valueOf(consultar(13)));
    }//GEN-LAST:event_btnConsultarNumAvionesRodajeA_LEBLActionPerformed

    private void chkPista1_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista1_LEMDActionPerformed
        accionPista("LEMD", 0, chkPista1_LEMD.isSelected());
    }//GEN-LAST:event_chkPista1_LEMDActionPerformed

    private void chkPista2_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista2_LEMDActionPerformed
        accionPista("LEMD", 1, chkPista2_LEMD.isSelected());
    }//GEN-LAST:event_chkPista2_LEMDActionPerformed

    private void chkPista3_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista3_LEMDActionPerformed
        accionPista("LEMD", 2, chkPista3_LEMD.isSelected());
    }//GEN-LAST:event_chkPista3_LEMDActionPerformed

    private void chkPista4_LEMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista4_LEMDActionPerformed
        accionPista("LEMD", 3, chkPista4_LEMD.isSelected());
    }//GEN-LAST:event_chkPista4_LEMDActionPerformed

    private void chkPista1_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista1_LEBLActionPerformed
        accionPista("LEBL", 0, chkPista1_LEBL.isSelected());
    }//GEN-LAST:event_chkPista1_LEBLActionPerformed

    private void chkPista2_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista2_LEBLActionPerformed
        accionPista("LEBL", 1, chkPista2_LEBL.isSelected());
    }//GEN-LAST:event_chkPista2_LEBLActionPerformed

    private void chkPista3_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista3_LEBLActionPerformed
        accionPista("LEBL", 2, chkPista3_LEBL.isSelected());
    }//GEN-LAST:event_chkPista3_LEBLActionPerformed

    private void chkPista4_LEBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPista4_LEBLActionPerformed
        accionPista("LEBL", 3, chkPista4_LEBL.isSelected());
    }//GEN-LAST:event_chkPista4_LEBLActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarNumAvionesHangarLEBL;
    private javax.swing.JButton btnConsultarNumAvionesHangarLEMD;
    private javax.swing.JButton btnConsultarNumAvionesPlataformaColaLEBL;
    private javax.swing.JButton btnConsultarNumAvionesPlataformaColaLEMD;
    private javax.swing.JButton btnConsultarNumAvionesPlataformaListaLEBL;
    private javax.swing.JButton btnConsultarNumAvionesPlataformaListaLEMD;
    private javax.swing.JButton btnConsultarNumAvionesRodajeA_LEBL;
    private javax.swing.JButton btnConsultarNumAvionesRodajeA_LEMD;
    private javax.swing.JButton btnConsultarNumAvionesRodajeD_LEBL;
    private javax.swing.JButton btnConsultarNumAvionesRodajeD_LEMD;
    private javax.swing.JButton btnConsultarNumAvionesTallerLEBL;
    private javax.swing.JButton btnConsultarNumAvionesTallerLEMD;
    private javax.swing.JButton btnConsultarNumPasajerosLEBL;
    private javax.swing.JButton btnConsultarNumPasajerosLEMD;
    private javax.swing.JButton btnConsultarVuelosToLEBL;
    private javax.swing.JButton btnConsultarVuelosToLEMD;
    private javax.swing.JCheckBox chkPista1_LEBL;
    private javax.swing.JCheckBox chkPista1_LEMD;
    private javax.swing.JCheckBox chkPista2_LEBL;
    private javax.swing.JCheckBox chkPista2_LEMD;
    private javax.swing.JCheckBox chkPista3_LEBL;
    private javax.swing.JCheckBox chkPista3_LEMD;
    private javax.swing.JCheckBox chkPista4_LEBL;
    private javax.swing.JCheckBox chkPista4_LEMD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEstadisticas;
    private javax.swing.JLabel lblNumAvionesHangarLEBL;
    private javax.swing.JLabel lblNumAvionesHangarLEMD;
    private javax.swing.JLabel lblNumAvionesPlataformaColaLEBL;
    private javax.swing.JLabel lblNumAvionesPlataformaColaLEMD;
    private javax.swing.JLabel lblNumAvionesPlataformaListaLEBL;
    private javax.swing.JLabel lblNumAvionesPlataformaListaLEMD;
    private javax.swing.JLabel lblNumAvionesRodajeA_LEBL;
    private javax.swing.JLabel lblNumAvionesRodajeA_LEMD;
    private javax.swing.JLabel lblNumAvionesRodajeD_LEBL;
    private javax.swing.JLabel lblNumAvionesRodajeD_LEMD;
    private javax.swing.JLabel lblNumAvionesTallerLEBL;
    private javax.swing.JLabel lblNumAvionesTallerLEMD;
    private javax.swing.JLabel lblNumPasajerosLEBL;
    private javax.swing.JLabel lblNumPasajerosLEMD;
    private javax.swing.JTextArea txtaVuelosToLEBL;
    private javax.swing.JTextArea txtaVuelosToLEMD;
    // End of variables declaration//GEN-END:variables

    public int consultar(int dato) {
        int consulta=0; 
        try{
            socket = new Socket("localhost", 5000); 
            entrada = new DataInputStream(socket.getInputStream()); 
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF(String.valueOf(dato));            
            consulta=entrada.readInt();
            cerrarConexion(); 
        }
        catch(IOException ioe){
            log.escribirLog("Error al enviar petición");
        }
        return consulta; 
        
    }
    
    public String consultarVuelos(int dato) {
        String consulta=""; 
        try{
            socket = new Socket("localhost", 5000); 
            entrada = new DataInputStream(socket.getInputStream()); 
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF(String.valueOf(dato));            
            consulta=entrada.readUTF();
            log.escribirLog("Resultado de la consulta de los vuelos: " + consulta);
            cerrarConexion(); 
        }
        catch(IOException ioe){
            log.escribirLog("Error al enviar petición de consulta de vuelos");
        }
        return consulta; 
        
    }
    
    public boolean accionPista(String aeropuerto, int pista, boolean abrir) {
        log.escribirLog("Recibo: " + aeropuerto + ", " + (pista+1) + ", " +(abrir?"abrir":"cerrar") + ".");
        boolean resultado=false; 
        try{
            socket = new Socket("localhost", 5000); 
            entrada = new DataInputStream(socket.getInputStream()); 
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF(aeropuerto + ";" + String.valueOf(pista) + ";" + (abrir?1:0));            
            resultado=entrada.readBoolean();
            if (resultado) {
                log.escribirLog("Se ha " + (abrir?"abierto":"cerrado") + " la pista " + (pista+1) + " de " + aeropuerto + " exitosamente.");
            } else {
                log.escribirLog("ERROR al intentar " + (abrir?"abrir":"cerrar") + " la pista " + (pista+1) + " de " + aeropuerto);
            }cerrarConexion(); 
        }
        catch(IOException ioe){
            log.escribirLog("Error al enviar petición");
        }
        return resultado; 
        
    }
    
    public void cerrarConexion(){
        try{
            entrada.close(); 
            salida.close(); 
            socket.close(); 
        }
        catch(IOException ioe){
            log.escribirLog("Error al cerrar conexión");
        }
    }        
}
