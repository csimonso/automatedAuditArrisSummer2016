/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * This class is used to create the initial data display GUI.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A6_InitialDataDisplayGUI extends javax.swing.JFrame {

    private LinkedList semList;
    private LinkedList tmxList;
    private LinkedList encList;
    String fileLocation;
    String selection;
    
    /**
     * Creates new form DataDisplay
     * @param location The file location
     */
    public A6_InitialDataDisplayGUI(String location) {
        /* Initializes components */
        initComponents();
        /* Sets teh file location */
        fileLocation = location;
        
        /* Sets the layouts of each panel */
        displayPanelTMX.setLayout(new BoxLayout(displayPanelTMX, Y_AXIS));
        displayPanelSEM.setLayout(new BoxLayout(displayPanelSEM, Y_AXIS));
        displayPanelENC.setLayout(new GridLayout(0, 2, 5, 5));
        displayPanelMUX.setLayout(new BoxLayout(displayPanelMUX, Y_AXIS));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        displayPanelTMX = new javax.swing.JPanel();
        displayPanelENC = new javax.swing.JPanel();
        displayPanelSEM = new javax.swing.JPanel();
        displayPanelMUX = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        displayPanelTMX.setBorder(javax.swing.BorderFactory.createTitledBorder("TMX Data"));
        displayPanelTMX.setLayout(new javax.swing.BoxLayout(displayPanelTMX, javax.swing.BoxLayout.LINE_AXIS));

        displayPanelENC.setBorder(javax.swing.BorderFactory.createTitledBorder("Encoder Data"));
        displayPanelENC.setLayout(new javax.swing.BoxLayout(displayPanelENC, javax.swing.BoxLayout.LINE_AXIS));

        displayPanelSEM.setBorder(javax.swing.BorderFactory.createTitledBorder("SEM Data"));
        displayPanelSEM.setLayout(new javax.swing.BoxLayout(displayPanelSEM, javax.swing.BoxLayout.LINE_AXIS));

        displayPanelMUX.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MUX Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        displayPanelMUX.setLayout(new javax.swing.BoxLayout(displayPanelMUX, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayPanelENC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayPanelSEM, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(displayPanelTMX, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(131, 131, 131))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayPanelMUX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayPanelMUX, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanelSEM, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(displayPanelTMX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayPanelENC, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 320, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(571, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method to run the GUI.
     */
    public void runProgram() {
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
            java.util.logging.Logger.getLogger(A6_InitialDataDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A6_InitialDataDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A6_InitialDataDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A6_InitialDataDisplayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new A6_InitialDataDisplayGUI(fileLocation).setVisible(false);
        });
    }
    
    /**
     * Method to create Labels for the MUX data.
     * @param muxInput The data to be displayed
     */
    public void displayDataMUX(String muxInput){
        /* Create and initialize a new label */
        JLabel newLabel = new JLabel();
        /* Set the text of the new label */
        newLabel.setText(muxInput);
        /* Adds the label to the panel */
        displayPanelMUX.add(newLabel);
        /* Makes the label visible */
        newLabel.setVisible(true);
    }
    
    /**
     * Method to create Labels for the TMX data.
     * @param tmxInput The data to be displayed
     * @param tmxNumber The specific TMX number
     */
    public void displayDataTMX(String tmxInput, int tmxNumber){
        /* Creates a new label */
        JLabel newLabel = new JLabel();
        /* Sets the new label's text */
        newLabel.setText(tmxInput);
        
        /* Checks if the label is device name in order to make it clickable */
        if(tmxNumber >= 1) {
            newLabel.addMouseListener(new MouseAdapter(){
                /**
                 * Method to allow the "name" label to be clicked.
                 * @param ev The Mouse Click Event
                 */
               @Override
               public void mouseClicked(MouseEvent ev){
                   /* Creates a and initializes a new TMX object */
                   A7_TMX tmxData = new A7_TMX(fileLocation);
                   /* Function call to display the expanded TMX display */
                   tmxData.displayExpandedTMX(tmxList, tmxNumber);
               } 
            });

        }
        /* Adds the new label to the panel */
        displayPanelTMX.add(newLabel);
        /* Makes label visible */
        newLabel.setVisible(true);
    }
    
    /**
     * Method to create Labels for the SEM data.
     * @param semInput The data to be displayed
     * @param semNumber The specific SEM number
     */
    public void displayDataSEM(String semInput, int semNumber) {
        /* Creates and initializes a new label */
        JLabel newLabel = new JLabel();
        /* Sets the text for the new label */
        newLabel.setText(semInput);
        /* Makes the label clickable for the "name" variable */
        if(semNumber >= 1){
            /* Adds a mouse listener to label */
            newLabel.addMouseListener(new MouseAdapter(){
                /**
                 * Method to allow the "name" label to be clicked.
                 * @param ev The mouse click event
                 */
                @Override
                public void mouseClicked(MouseEvent ev){
                    /* Creates a new SEMdisplay object */
                    A7_SEM semData = new A7_SEM(fileLocation);
                    /* Function call to display the SEM data that was clicked */
                    semData.displayExpandedSEM(semList, semNumber);
                }
            });
        }
        /* Adds label to the panel */
        displayPanelSEM.add(newLabel);
        /* Makes label visible */
        newLabel.setVisible(true);
    }
    
    /**
     * Method to create Labels for the Encoder data.
     * @param encInput The data to be displayed
     * @param encNumber The specific encoder number
     * @return The new label created
     */
    public JLabel displayDataENC(String encInput, int encNumber){
        /* Creates an initializes a new label */
        JLabel newLabel = new JLabel();
        /* Sets the text of the new label */
        newLabel.setText(encInput);
        
        /* Makes the label clickable for the "name" variable */
        if(encNumber >= 1){
            /* Adds a mouse listener to label */
            newLabel.addMouseListener(new MouseAdapter(){
                /**
                 * Method to allow the "name" label to be clicked.
                 * @param ev The mouse click event
                 */
                @Override
                public void mouseClicked(MouseEvent ev){
                    /* Creates a new Encdisplay object */
                    A7_Encoder encData = new A7_Encoder(fileLocation);
                    /* Function call to display the Encoder data */
                    encData.displayExpandedENC(encList, encNumber);
                }
            });
        }
        /* Makes new label visible */
        newLabel.setVisible(true);
        /* Returns the new label created */
        return newLabel;
    }
    
    /**
     * Method to append labels to a panel.
     * @param name The device name label
     * @param type The device type label
     * @param address The device address label
     * @param role The device role
     */
    public void createEncPanel(JLabel name, JLabel type, JLabel address, 
            JLabel role){
        /* Creates and initializes a new panel */
        JPanel newPanel = new JPanel();
        /* Sets the layout of the panel */
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        
        /* Adds the labels to the panel */
        newPanel.add(name);
        newPanel.add(type);
        newPanel.add(address);
        newPanel.add(role);
        
        /* Adds the panel to the display */
        displayPanelENC.add(newPanel);
        /* Makes the panel visible */
        newPanel.setVisible(true);
    }
   
    /**
     * TMX Linked List Setter.
     * @param tList The TMX Linked List
     */
    public void setTMXList(LinkedList tList){
        tmxList = tList;
    } 
    /**
     * TMX Border Setter.
     * @param borderName The TMX Border Name
     */
    public void setTmxBorder(String borderName){
        /* Creates and initalizes a new Titled Border */
        TitledBorder title = BorderFactory.createTitledBorder(borderName);
        /* Sets the border text */
        displayPanelTMX.setBorder(title);
    }
    
    /**
     * SEM Linked List Setter.
     * @param sList The SEM Linked List
     */
    public void setSEMList(LinkedList sList){
        this.semList = sList;
    }
    
    /**
     * SEM Border Setter.
     * @param borderName The SEM Border Name
     */
    public void setSemBorder(String borderName){
        /* Creates and initializes a new Titled Border */
        TitledBorder title = BorderFactory.createTitledBorder(borderName);
        /* Sets the border text */
        displayPanelSEM.setBorder(title);
    }  
    
    /**
     * Encoder Linked List Setter.
     * @param eList The Encoder Linked List
     */
    public void setEncList(LinkedList eList){
        this.encList = eList;
    }
    
    /**
     * Encoder Border Setter.
     * @param borderName The Encoder Border Name
     */
    public void setEncBorder(String borderName){
        /* Creates and initializes a new Titled Border */
        TitledBorder title = BorderFactory.createTitledBorder(borderName);
        /* Sets the border text */
        displayPanelENC.setBorder(title);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displayPanelENC;
    private javax.swing.JPanel displayPanelMUX;
    private javax.swing.JPanel displayPanelSEM;
    private javax.swing.JPanel displayPanelTMX;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
