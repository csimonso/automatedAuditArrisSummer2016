/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatedaudit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author csimonson
 */
public class A8_ExpandedSatelliteUI extends javax.swing.JFrame {

    private A7_SATELLITE satData;
    DefaultTableModel vctModel;
    DefaultTableModel transModel;
    DefaultTableCellRenderer render;
    private String transponderVctNumber;
    private int satNumber;
    private final String[] tableHeader = {"CH Name", "SAT", "Source", 
        "CH Type", "Carrier", "Transport"};
    private final String[] transTableHeader = {"Name", "Frequency", "Polarization", 
        "Transport Type", "Modulation", "VCT"};
    
    /**
     * Creates new form A9_ExpandedSatelliteUI
     */
    public A8_ExpandedSatelliteUI(A7_SATELLITE data) {
        initComponents();
        satData = data;
        transModel = new DefaultTableModel(0, 0);
        transModel.setColumnIdentifiers(transTableHeader);
        vctModel = new DefaultTableModel(0, 0);
        vctModel.setColumnIdentifiers(tableHeader);
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        transponderTable.setModel(transModel);
        vctTable.setModel(vctModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outterDataPanel = new javax.swing.JPanel();
        satelliteLabel = new javax.swing.JLabel();
        hemisphereLabel = new javax.swing.JLabel();
        hemisphereLabelInput = new javax.swing.JLabel();
        polarizationLabel = new javax.swing.JLabel();
        polarizationLabelInput = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transponderTable = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vctTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        satelliteLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        satelliteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        satelliteLabel.setText("Satellite");

        hemisphereLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hemisphereLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hemisphereLabel.setText("Hemisphere:");
        hemisphereLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        hemisphereLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hemisphereLabelInput.setText("Hemi");

        polarizationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        polarizationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        polarizationLabel.setText("Polarization:");
        polarizationLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        polarizationLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        polarizationLabelInput.setText("Polar");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        transponderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Frequency", "Polarization", "Transport Type", "Modulation", "VCT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transponderTable);

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        vctTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "VCT Name", "SAT", "Source", "CH Type", "Carrier", "Transport"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vctTable);

        javax.swing.GroupLayout outterDataPanelLayout = new javax.swing.GroupLayout(outterDataPanel);
        outterDataPanel.setLayout(outterDataPanelLayout);
        outterDataPanelLayout.setHorizontalGroup(
            outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outterDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outterDataPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(outterDataPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(outterDataPanelLayout.createSequentialGroup()
                        .addGroup(outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(satelliteLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, outterDataPanelLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(hemisphereLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hemisphereLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(polarizationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(polarizationLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outterDataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        outterDataPanelLayout.setVerticalGroup(
            outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outterDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(satelliteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hemisphereLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hemisphereLabelInput)
                    .addComponent(polarizationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(polarizationLabelInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(outterDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outterDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(outterDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        setSize(new java.awt.Dimension(724, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     */
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A8_ExpandedSatelliteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A8_ExpandedSatelliteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A8_ExpandedSatelliteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A8_ExpandedSatelliteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A8_ExpandedSatelliteUI(satData).setVisible(false);
            }
        });
    }
    
    public void displaySetup(int deviceNumber){
        ArrayList satList = satData.getSatList();
        Map satMap = satData.getDataMap();
        satNumber = deviceNumber;
        for(int i = 0; i < satList.size(); i++){
            int listNumber = Integer.parseInt((String)satList.get(i));
            if(listNumber == deviceNumber){
                satelliteLabel.setText((String) satMap.get("Satellite" + 
                        listNumber + "FullName"));
                nameLabel.setText("Name: " + satMap.get("Satellite" + 
                        listNumber + "Name"));
                hemisphereLabelInput.setText((String) satMap.get("Satellite" + 
                        listNumber + "Hemisphere"));
                polarizationLabelInput.setText((String) satMap.get("Satellite" + 
                        listNumber + "Polarization"));
                setTransponderTableRows();
                setVctTableRows();
            }
        }
    }
    
    
    
    public void showDisplay(){
        this.setVisible(true);
    }
    
    private void setVctTableRows(){
        /* Gets the VCT Map */
        Map vctMap = satData.getVctMap();
        
        ArrayList vctList = satData.getVctList();
        
        for(int j = 0; j < vctList.size(); j++){
            String vctNumber = (String) vctList.get(j);
            System.out.println(vctNumber);
            String nameKey = vctNumber + "Name";
            String satKey = vctNumber + "Satellite";
            String sourceKey = vctNumber + "Source";
            String channelTypeKey = vctNumber + "ChannelType";
            String carrierKey = vctNumber + "Carrier";
            String transportKey = vctNumber + ".Transport";

            if(vctMap.containsKey(nameKey)){
                /* Adds a new row to the table */
                vctModel.addRow(new Object[] {"NO DATA", "NO DATA", "NO DATA", 
                    "NO DATA", "NO DATA", "NO DATA"});
                
                vctModel.setValueAt(vctMap.get(nameKey), j, 0);
                vctTable.getColumnModel().getColumn(0).setMinWidth(90);
                vctTable.getColumnModel().getColumn(0).setMaxWidth(100);
                vctTable.getColumnModel().getColumn(0)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(0).setResizable(true);
                
                if(vctMap.containsKey(satKey)){
                    vctModel.setValueAt(vctMap.get(satKey), j, 1);
                }
                vctTable.getColumnModel().getColumn(1).setMinWidth(60);
                vctTable.getColumnModel().getColumn(1).setMaxWidth(70);
                vctTable.getColumnModel().getColumn(1)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(1).setResizable(true);
                
                if(vctMap.containsKey(sourceKey)){
                    vctModel.setValueAt(vctMap.get(sourceKey), j, 2);
                }
                vctTable.getColumnModel().getColumn(2).setMinWidth(180);
                vctTable.getColumnModel().getColumn(2).setMaxWidth(200);
                vctTable.getColumnModel().getColumn(2)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(2).setResizable(true);
                
                if(vctMap.containsKey(channelTypeKey)){
                    vctModel.setValueAt(vctMap.get(channelTypeKey), j, 3);
                }
                vctTable.getColumnModel().getColumn(3).setMinWidth(80);
                vctTable.getColumnModel().getColumn(3).setMaxWidth(100);
                vctTable.getColumnModel().getColumn(3)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(3).setResizable(true);
                
                if(vctMap.containsKey(carrierKey)){
                    vctModel.setValueAt(vctMap.get(carrierKey), j, 4);
                }
                vctTable.getColumnModel().getColumn(4).setMinWidth(80);
                vctTable.getColumnModel().getColumn(4).setMaxWidth(100);
                vctTable.getColumnModel().getColumn(4)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(4).setResizable(true);
                
                if(vctMap.containsKey(transportKey)){
                    vctModel.setValueAt(vctMap.get(transportKey), j, 5);
                }
                vctTable.getColumnModel().getColumn(5).setMinWidth(80);
                vctTable.getColumnModel().getColumn(5).setMaxWidth(100);
                vctTable.getColumnModel().getColumn(5)
                        .setCellRenderer(render);
                vctTable.getColumnModel().getColumn(5).setResizable(true);
            } 
        }
    }
    
    private void setTransponderTableRows(){
        /* Gets the VCT Map */
        Map transMap = satData.getTransMap();
        ArrayList transList = satData.getTransponderList();
        
        int row = 0;
        
        for(int j = 0; j < transList.size(); j++){
            String transNumber = (String) transList.get(j);
            
            String nameKey = "Satellite" + satNumber + "Transponder" + transNumber + "Name";
            String freqKey = "Satellite" + satNumber + "Transponder" + transNumber + "Frequency";
            String polarKey = "Satellite" + satNumber + "Transponder" + transNumber + "Polarization";
            String transportTypeKey = "Satellite" + satNumber + "Transponder" + transNumber + "TransportType";
            String modulationKey = "Satellite" + satNumber + "Transponder" + transNumber + "Modulation";
            String vctKey = "Satellite" + satNumber + "Transponder" + transNumber + "VCT";
            
            if(transMap.containsKey(nameKey)){
                /* Adds a new row to the table */
                transModel.addRow(new Object[] {"NO DATA", "NO DATA", "NO DATA", 
                    "NO DATA", "NO DATA", "NO DATA"});
                
                transModel.setValueAt(transMap.get(nameKey), row, 0);
                transponderTable.getColumnModel().getColumn(0).setMinWidth(80);
                transponderTable.getColumnModel().getColumn(0).setMaxWidth(80);
                transponderTable.getColumnModel().getColumn(0)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(0).setResizable(true);
                
                if(transMap.containsKey(freqKey)){
                    transModel.setValueAt(transMap.get(freqKey), row, 1);
                }
                transponderTable.getColumnModel().getColumn(1).setMinWidth(120);
                transponderTable.getColumnModel().getColumn(1).setMaxWidth(140);
                transponderTable.getColumnModel().getColumn(1)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(1).setResizable(true);
                
                if(transMap.containsKey(polarKey)){
                    transModel.setValueAt(transMap.get(polarKey), row, 2);
                }
                transponderTable.getColumnModel().getColumn(2).setMinWidth(100);
                transponderTable.getColumnModel().getColumn(2).setMaxWidth(120);
                transponderTable.getColumnModel().getColumn(2)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(2).setResizable(true);
                
                if(transMap.containsKey(transportTypeKey)){
                    transModel.setValueAt(transMap.get(transportTypeKey), row, 3);
                }
                transponderTable.getColumnModel().getColumn(3).setMinWidth(80);
                transponderTable.getColumnModel().getColumn(3).setMaxWidth(100);
                transponderTable.getColumnModel().getColumn(3)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(3).setResizable(true);
                
                if(transMap.containsKey(modulationKey)){
                    transModel.setValueAt(transMap.get(modulationKey), row, 4);
                }
                transponderTable.getColumnModel().getColumn(4).setMinWidth(150);
                transponderTable.getColumnModel().getColumn(4).setMaxWidth(170);
                transponderTable.getColumnModel().getColumn(4)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(4).setResizable(true);
                
                if(transMap.containsKey(vctKey)){
                    transModel.setValueAt(transMap.get(vctKey), row, 5);
                    
                }
                transponderTable.getColumnModel().getColumn(5).setMinWidth(80);
                transponderTable.getColumnModel().getColumn(5).setMaxWidth(80);
                transponderTable.getColumnModel().getColumn(5)
                        .setCellRenderer(render);
                transponderTable.getColumnModel().getColumn(5).setResizable(true);
                
                row++;
            }
        }
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hemisphereLabel;
    private javax.swing.JLabel hemisphereLabelInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel outterDataPanel;
    private javax.swing.JLabel polarizationLabel;
    private javax.swing.JLabel polarizationLabelInput;
    private javax.swing.JLabel satelliteLabel;
    private javax.swing.JTable transponderTable;
    private javax.swing.JTable vctTable;
    // End of variables declaration//GEN-END:variables
}
