 /*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Class to create a display for the Service data of a TMX.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A9_ServiceDisplay extends javax.swing.JDialog {

    DefaultTableModel model;
    DefaultTableCellRenderer render;
    private A7_TMX tData;
    Frame p;
    private final String[] tableHeader = {"NUM", "Name", "Type", "PMT PID", 
        "Bitrate", "TRGT PCR PID"}; 
    
    /**
     * Creates new form A9_ServiceDisplay
     * @param parent The parent display
     */
    public A9_ServiceDisplay(java.awt.Frame parent) {
        super(parent);
        p = parent;
        initComponents();
        serviceTable.setRowSelectionAllowed(true);
        model = new DefaultTableModel(0, 0);
        model.setColumnIdentifiers(tableHeader);
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        serviceTable.setModel(model);
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
        serviceTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();
        writeButton = new javax.swing.JButton();
        componentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        serviceTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No Data", "No Data", "No Data", "No Data", "No Data", "No Data"}
            },
            new String [] {
                "Service Number", "Name", "Type", "PMT PID", "Bit Rate", "Target PCR PID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(serviceTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
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

        componentButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        componentButton.setText(" Components");
        componentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentButtonActionPerformed(evt);
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
                        .addComponent(componentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(componentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(697, 306));
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
     * Action Event Method to write table data to an Excel File.
     * @param evt The action event
     */
    private void writeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeButtonActionPerformed
        /* Initialize the class object to write data to file */
        WriteTablesToFile write = new WriteTablesToFile(model);
        /* Tries to write the table data to file */
        try {
            write.writeTable("ServiceTable");
            JOptionPane.showMessageDialog(this, 
                    "Table Written To File Successfully");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error Writing To File");
        } 
    }//GEN-LAST:event_writeButtonActionPerformed

    /**
     * Action Event Method to display the services component data.
     * @param evt The action event
     */
    private void componentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componentButtonActionPerformed
        /* Gets the selected row number */
        int rowNumber = serviceTable.getSelectedRow();
        if(rowNumber >= 0){
            /* Gets the service number of selected row */
            String serviceNumber = (String) model.getValueAt(rowNumber, 0);
            /* Initializes a new component display object */
            A9_ComponentDisplay componentDisplay = new A9_ComponentDisplay(p);
            /* Sets the component display table rows */
            componentDisplay.setTableRows(serviceNumber, tData.getComponentMap(), 
                    tData.getComponentNumber());
            componentDisplay.pack();
            /* Runs the component display */
            componentDisplay.runComponentDisplay(); 
        } 
    }//GEN-LAST:event_componentButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A9_ServiceDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A9_ServiceDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A9_ServiceDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A9_ServiceDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            A9_ServiceDisplay dialog = new A9_ServiceDisplay(
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
    public void runServiceDisplay(){
        this.setVisible(true);
    }
    /**
     * Method to set the data in each row of the table.
     * @param data The TMX Data
     */
    public void setTableRows(A7_TMX data){
        
        tData = data;
        int count = tData.getServiceGroupNumber();
        Map dataMap = tData.getServiceMap();
        ArrayList sNumber = tData.getServiceNumber();
        
        /* Loops through adding new coloumns and filling with empty data */
        for(int i = 0; i < count; i++){      
            model.addRow(new Object[] {"No Data", "No Data", "No Data", 
                "No Data", "No Data", "No Data"});
        }
        /* Loops through each Service number to get the service data */
        for(int j = 0; j < sNumber.size(); j++){
            /* Sets the current service number */
            String serviceNumber = sNumber.get(j).toString();
            /* Creates keys for the service data to lookup in the map */
            String nameKey = "Service" + serviceNumber + "Name";
            String typeKey = "Service" + serviceNumber + "Type";
            String pmtPidKey = "Service" + serviceNumber + "PmtPID";
            String bitRateKey = "Service" + serviceNumber + "BitRate";
            String targetPcrKey = "Service" + serviceNumber + "TargetPcrPid";
            
            /* Inserts the service data to table */
            if(dataMap.containsKey(nameKey)){
                /* Inserts the service number into table */
                model.setValueAt(serviceNumber, j, 0);
                serviceTable.getColumnModel().getColumn(0).setMinWidth(40);
                serviceTable.getColumnModel().getColumn(0).setMaxWidth(50);
                serviceTable.getColumnModel().getColumn(0)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(0).setResizable(true);
                
                /* Adds the service name to the table */
                model.setValueAt(dataMap.get(nameKey), j, 1); 
                serviceTable.getColumnModel().getColumn(1).setMinWidth(100);
                serviceTable.getColumnModel().getColumn(1).setMaxWidth(150);
                serviceTable.getColumnModel().getColumn(1)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(1).setResizable(true);
                
                /* Inserts the type of component to the table */
                if(dataMap.containsKey(typeKey)){
                    model.setValueAt(dataMap.get(nameKey), j, 2); 
                }
                serviceTable.getColumnModel().getColumn(2).setMinWidth(100);
                serviceTable.getColumnModel().getColumn(2).setMaxWidth(150);
                serviceTable.getColumnModel().getColumn(2)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(2).setResizable(true);
                
                /* Inserts the components PMT PID to the table */
                if(dataMap.containsKey(pmtPidKey)){
                    /* Sets the PMT PID to a String */
                    String pmtPid = (String) dataMap.get(pmtPidKey);
                    /* Checks if its a hexadecimal value */
                    if(pmtPid.contains("0x")){
                        /* Splits the String */
                        String[] pmtPidArr = pmtPid.split("x");
                        /* Inserts the hex value and decimal value to table */
                        model.setValueAt(dataMap.get(pmtPidKey) + "(" +
                                Integer.valueOf(pmtPidArr[1], 16) + ")", j, 3);
                    }else model.setValueAt(dataMap.get(pmtPidKey), j, 3);
                }
                serviceTable.getColumnModel().getColumn(3).setMinWidth(80);
                serviceTable.getColumnModel().getColumn(3).setMaxWidth(100);
                serviceTable.getColumnModel().getColumn(3)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(3).setResizable(true);
                
                /* Inserts the components Bit Rate to the table */
                if(dataMap.containsKey(bitRateKey)){
                    model.setValueAt(dataMap.get(bitRateKey), j, 4); 
                }
                serviceTable.getColumnModel().getColumn(4).setMinWidth(80);
                serviceTable.getColumnModel().getColumn(4).setMaxWidth(100);
                serviceTable.getColumnModel().getColumn(4)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(4).setResizable(true);
                
                /* Inserts the components Target PCR PID to the table */
                if(dataMap.containsKey(targetPcrKey)){
                    /* Sets the Target PCR PID to a String */
                    String targetPcrPid = (String) dataMap.get(pmtPidKey);
                    /* Checks if its a hexadecimal value */
                    if(targetPcrPid.contains("0x")){
                        /* Splits the String */
                        String[] targetPcrPidArr = targetPcrPid.split("x");
                        /* Inserts the hex value and decimal value to table */
                        model.setValueAt(dataMap.get(targetPcrKey) + "(" +
                            Integer.valueOf(targetPcrPidArr[1], 16) + ")", 
                                j, 5);
                    }
                    else model.setValueAt(dataMap.get(targetPcrKey), j, 5);
                }
                serviceTable.getColumnModel().getColumn(5).setMinWidth(100);
                serviceTable.getColumnModel().getColumn(5).setMaxWidth(120);
                serviceTable.getColumnModel().getColumn(5)
                        .setCellRenderer(render);
                serviceTable.getColumnModel().getColumn(5).setResizable(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton componentButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable serviceTable;
    private javax.swing.JButton writeButton;
    // End of variables declaration//GEN-END:variables
}
