/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;


import java.io.IOException;
import javax.swing.JOptionPane;



/**
 * This class is used to create the main display UI.  Function calls are also
 * done from here after a button is pressed by the user.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A2_MainUI extends javax.swing.JFrame {

    private String userInput, fileFolder;
    
    /**
     * Creates new form MainUI
     */
    public A2_MainUI() {      
        initComponents();
   
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
        mainPanel = new javax.swing.JPanel();
        mainTextField = new javax.swing.JTextField();
        mainLabel = new javax.swing.JLabel();
        mainEnterButton = new javax.swing.JButton();
        mainExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Automated Audit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        mainTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainTextFieldActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainLabel.setText("Enter Backup File Location:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        mainEnterButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainEnterButton.setText("Enter");
        mainEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainEnterButtonActionPerformed(evt);
            }
        });

        mainExitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainExitButton.setText("Exit");
        mainExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mainEnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(mainExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainEnterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(mainExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action event method to exit the program when the exit button is clicked.
     * @param evt The button action event
     */
    private void mainExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mainExitButtonActionPerformed

    /**
     * Action event method to run the rest of the program once the enter button
     * is clicked by the user.
     * @param evt The button action event
     */
    private void mainEnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainEnterButtonActionPerformed

        /* Displays error if no file location was entered */
        if(mainTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No File Entered.  "
                    + "Please Try Again.");
            return;
        }
        /* Gets the text input from the user */
        userInput = mainTextField.getText();

        /* Creates a new UnpackTar object to unpack the input file */
        A3_UnpackTar unpackFile = new A3_UnpackTar();

        try {
            /* Sets the unpacked files main folder after creation */
            fileFolder = unpackFile.createFiles(userInput);
            /* Creates a new MUX object to obtain relavent MUX info */
            A4_MUX server = new A4_MUX(fileFolder);
            /* Function call to parse all the MUX information */
            server.parseFile();
            /* Creates a new ParseDeviceList object to get equipment info */
            A5_ParseDeviceList devices = new A5_ParseDeviceList(fileFolder);
            A6_InitialDataDisplayCode display = 
                    new A6_InitialDataDisplayCode(fileFolder);
            /* Function call to parse all relavent data for each device */
            devices.scanList(display);
            /* Function call to display the MUX data */
            display.displayMUX(server);
            /* Turns off the visibility of the main GUI */
            this.setVisible(false);
            /* Function call to run the display */
            display.runDisplay();
        } catch (IOException ex) {
            /* Displays error message if file location is invalid */
            JOptionPane.showMessageDialog(this, "Invalid File.  "
                    + "Please Try Again.");
            /* Sets the cursor focus back to the text box */
            mainTextField.requestFocusInWindow();
        }
    }//GEN-LAST:event_mainEnterButtonActionPerformed

    private void mainTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainTextFieldActionPerformed
        
        if(evt.getSource() == mainTextField){
            mainEnterButton.doClick();
        }
    }//GEN-LAST:event_mainTextFieldActionPerformed

    /**
     * Method to run the main program.
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
            java.util.logging.Logger.getLogger(A2_MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A2_MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A2_MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A2_MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new A2_MainUI().setVisible(true);
            
        });   
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mainEnterButton;
    private javax.swing.JButton mainExitButton;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField mainTextField;
    // End of variables declaration//GEN-END:variables
}
