 /*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Class to create a display for the Component data of a TMX.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A9_ComponentDisplay extends javax.swing.JDialog {
    
    private final String[] tableHeader = {"NUM", "Name", "Type", 
        "OUT PID", "DESCR", "TC Mode", "TC Bias", 
        "Audio Type", "AC3PassThru", "DVS Audio", "SRC STRM"}; 
    DefaultTableModel componentModel;
    DefaultTableCellRenderer render;
    
    /**
     * Creates new form A9_ComponentDisplay
     * @param parent The parent display
     */
    public A9_ComponentDisplay(java.awt.Frame parent) {
        super(parent);
        initComponents();
        componentModel = new DefaultTableModel(0, 0);
        componentModel.setColumnIdentifiers(tableHeader);
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        componentTable.setModel(componentModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        componentTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();
        writeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Component Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        componentTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        componentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No Data", "No Data", "No Data", "No Data", "No Data", "No Data", "No Data", "No Data", "No Data", "No Data", "No Data"}
            },
            new String [] {
                "Component Number", "Name", "Type", "Output PID", "Description", "Transcode Mode", "Transcode Bias", "Audio Type", "Ac3DescPassThru", "DVS Audio", "Source Stream Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        componentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(componentTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        writeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        writeButton.setText("Write");
        writeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1072, 276));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Event Method to close the current display.
     * @param evt The action event
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * Action Event Method to write the table data to an Excel File.
     * @param evt The action event
     */
    private void writeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeButtonActionPerformed
        /* Initializes class object to write the data to file */
        WriteTablesToFile write = new WriteTablesToFile(componentModel);
        /* Tries to write data to the file */
        try {
            write.writeTable("ComponentTable");
            JOptionPane.showMessageDialog(this, 
                    "Table Written To File Successfully");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error Writing To File");
        }
    }//GEN-LAST:event_writeButtonActionPerformed

    /**
     * Method to run the display
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A9_ComponentDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            A9_ComponentDisplay dialog = new A9_ComponentDisplay(
                    new javax.swing.JFrame());
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(false);
        });
    }
    /**
     * Method to make display visible
     */
    public void runComponentDisplay(){
        this.setVisible(true);
    }
    /**
     * Method to set the data in each row of the table.
     * @param serviceNumber The specific service number
     * @param components The Map with all the components
     * @param idNumbers List of all the component ID's
     */
    public void setTableRows(String serviceNumber, Map components,
            ArrayList idNumbers){
        
        int componentCount = 0;//Keeps track of the total number of components
        
        /* Loops through each Component number to get the component data */
        for(int j = 0; j < idNumbers.size(); j++){  
            /* Sets the current service number */
            String id = idNumbers.get(j).toString();
            
            /* Creates keys to get data from the Map */
            String nameKey = serviceNumber + "Component" + id + "Name";
            String typeKey = serviceNumber + "Component" + id + "ComponentType";
            String outPidKey = serviceNumber + "Component" + id + "OutputPID";
            String descKey = serviceNumber + "Component" + id + "Description";
            String transcodeKey = serviceNumber + "Component" + id + 
                    "TranscodeMode";
            String transcodeBiasKey = serviceNumber + "Component" + id + 
                    "TranscodeBias";
            String audioTypeKey = serviceNumber + "Component" + id + 
                    "AudioType";
            String passThruKey = serviceNumber + "Component" + id + 
                    "Ac3DescPassThru";
            String dvsAudioKey = serviceNumber + "Component" + id + "DVSAudio";
            String srcStreamKey = serviceNumber + "Component" + id + 
                    "SourceStreamType";

            /* Checks if the Keys are in the Hash Map */
            if(components.containsKey(nameKey)){
                /* Adds new row if another component for the service is found */
                componentModel.addRow(new Object[] {"NO DATA", "NO DATA", 
                    "NO DATA", "NO DATA", "NO DATA", "NO DATA", "NO DATA", 
                    "NO DATA", "NO DATA", "NO DATA", "NO DATA"});
                
                componentCount++;//increment the number of components
                /* Sets the value for the component ID on the table*/
                componentModel.setValueAt(id, componentCount-1, 0);
                componentTable.getColumnModel().getColumn(0).setMinWidth(50);
                componentTable.getColumnModel().getColumn(0).setMaxWidth(60);
                componentTable.getColumnModel().getColumn(0)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(0).setResizable(true);
                
                /* Sets the component Name for the current component */
                componentModel.setValueAt(components.get(nameKey), 
                        componentCount-1, 1); 
                componentTable.getColumnModel().getColumn(1).setMinWidth(80);
                componentTable.getColumnModel().getColumn(1).setMaxWidth(100);
                componentTable.getColumnModel().getColumn(1)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(1).setResizable(true);
                
                /* Inserts the component type to the table */
                if(components.containsKey(typeKey)){
                    componentModel.setValueAt(components.get(typeKey), 
                        componentCount-1, 2); 
                }
                componentTable.getColumnModel().getColumn(2).setMinWidth(80);
                componentTable.getColumnModel().getColumn(2).setMaxWidth(100);
                componentTable.getColumnModel().getColumn(2)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(2).setResizable(true);
            
                /* Inserts the components Output PID to the table */
                if(components.containsKey(outPidKey)){
                    /* Sets the Output PID to a String */
                    String outPid = (String) components.get(outPidKey);
                    /* Checks if its a hexadecimal value */
                    if(outPid.contains("0x")){
                        /* Splits the String */
                        String[] outPidArr = outPid.split("x");
                        /* Inserts the hex value and decimal value to table */
                        componentModel.setValueAt(components.get(outPidKey) + 
                                "(" + Integer.valueOf(outPidArr[1], 16) + ")", 
                            componentCount-1, 3);
                    }
                }
                componentTable.getColumnModel().getColumn(3).setMinWidth(80);
                componentTable.getColumnModel().getColumn(3).setMaxWidth(100);
                componentTable.getColumnModel().getColumn(3)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(3).setResizable(true);
                
                /* Inserts the components Description to the table */
                if(components.containsKey(descKey)){
                    componentModel.setValueAt(components.get(descKey), 
                        componentCount-1, 4); 
                }
                componentTable.getColumnModel().getColumn(4).setMinWidth(80);
                componentTable.getColumnModel().getColumn(4).setMaxWidth(120);
                componentTable.getColumnModel().getColumn(4)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(4).setResizable(true);
                
                /* Inserts the components Transcode Mode into the table */
                if(components.containsKey(transcodeKey)){
                    componentModel.setValueAt(components.get(transcodeKey), 
                        componentCount-1, 5); 
                }
                componentTable.getColumnModel().getColumn(5).setMinWidth(100);
                componentTable.getColumnModel().getColumn(5).setMaxWidth(140);
                componentTable.getColumnModel().getColumn(5)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(5).setResizable(true);
                
                /* Inserts the components Transcode Bias to the table */
                if(components.containsKey(transcodeBiasKey)){
                    componentModel.setValueAt(components.get(transcodeBiasKey), 
                        componentCount-1, 6); 
                }
                componentTable.getColumnModel().getColumn(6).setMinWidth(50);
                componentTable.getColumnModel().getColumn(6).setMaxWidth(60);
                componentTable.getColumnModel().getColumn(6)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(6).setResizable(true);
                
                /* Inserts the components Audio Type in to the table */
                if(components.containsKey(audioTypeKey)){
                    componentModel.setValueAt(components.get(audioTypeKey), 
                        componentCount-1, 7);
                }
                componentTable.getColumnModel().getColumn(7).setMinWidth(60);
                componentTable.getColumnModel().getColumn(7).setMaxWidth(70);
                componentTable.getColumnModel().getColumn(7)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(7).setResizable(true);
                
                /* Inserts the components Pass Thru in to the table */
                if(components.containsKey(passThruKey)){
                    componentModel.setValueAt(components.get(passThruKey), 
                        componentCount-1, 8);
                }
                componentTable.getColumnModel().getColumn(8).setMinWidth(80);
                componentTable.getColumnModel().getColumn(8).setMaxWidth(100);
                componentTable.getColumnModel().getColumn(8)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(8).setResizable(true);
                
                /* Inserts the components DVS Audio in to the table */
                if(components.containsKey(dvsAudioKey)){
                    componentModel.setValueAt(components.get(dvsAudioKey), 
                        componentCount-1, 9);
                }
                componentTable.getColumnModel().getColumn(9).setMinWidth(60);
                componentTable.getColumnModel().getColumn(9).setMaxWidth(80);
                componentTable.getColumnModel().getColumn(9)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(9).setResizable(true);
                
                /* Inserts the components Source Stream in to the table */
                if(components.containsKey(srcStreamKey)){
                    componentModel.setValueAt(components.get(srcStreamKey), 
                        componentCount-1, 10);
                } 
                componentTable.getColumnModel().getColumn(10).setMinWidth(60);
                componentTable.getColumnModel().getColumn(10).setMaxWidth(80);
                componentTable.getColumnModel().getColumn(10)
                        .setCellRenderer(render);
                componentTable.getColumnModel().getColumn(10)
                        .setResizable(true);
            }
        }  
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTable componentTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton writeButton;
    // End of variables declaration//GEN-END:variables
}
