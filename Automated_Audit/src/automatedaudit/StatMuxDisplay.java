/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

/**
 * This class is used to display the STAT MUX Dialog Box.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class StatMuxDisplay extends javax.swing.JDialog {

    /**
     * Creates new form StatMuxDialog
     * @param parent The parent frame
     */
    public StatMuxDisplay(java.awt.Frame parent) {
        super(parent);
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

        dataPanel = new javax.swing.JPanel();
        activeControllersLabel = new javax.swing.JLabel();
        receiverAddressLabel = new javax.swing.JLabel();
        senderAddressLabel = new javax.swing.JLabel();
        senderPortLabel = new javax.swing.JLabel();
        numberActiveLabelInput = new javax.swing.JLabel();
        receiverAddressLabelInput = new javax.swing.JLabel();
        senderAddressLabelInput = new javax.swing.JLabel();
        senderPortLabelInput = new javax.swing.JLabel();
        minRateLabel = new javax.swing.JLabel();
        minRateLabelInput = new javax.swing.JLabel();
        receiverPortLabel = new javax.swing.JLabel();
        receiverPortLabelInput = new javax.swing.JLabel();
        maxRateLabel = new javax.swing.JLabel();
        maxRateLabelInput = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "StatMux", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        activeControllersLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        activeControllersLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        activeControllersLabel.setText("No. Active Controllers:");

        receiverAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        receiverAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverAddressLabel.setText("Receiver Group Address:");

        senderAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        senderAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderAddressLabel.setText("Sender Group Address:");

        senderPortLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        senderPortLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        senderPortLabel.setText("Port:");

        numberActiveLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numberActiveLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numberActiveLabelInput.setText("Number Active");

        receiverAddressLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        receiverAddressLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiverAddressLabelInput.setText("Address");

        senderAddressLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        senderAddressLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        senderAddressLabelInput.setText("Address");

        senderPortLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        senderPortLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        senderPortLabelInput.setText("Number");

        minRateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        minRateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        minRateLabel.setText("Min. Video TS Rate:");

        minRateLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minRateLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        minRateLabelInput.setText("Min");

        receiverPortLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        receiverPortLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        receiverPortLabel.setText("Port:");

        receiverPortLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        receiverPortLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receiverPortLabelInput.setText("Number");

        maxRateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        maxRateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxRateLabel.setText("Max. Video TS Rate:");

        maxRateLabelInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maxRateLabelInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maxRateLabelInput.setText("Max");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maxRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receiverAddressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(activeControllersLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senderAddressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minRateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(numberActiveLabelInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataPanelLayout.createSequentialGroup()
                        .addComponent(receiverAddressLabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receiverPortLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataPanelLayout.createSequentialGroup()
                        .addComponent(senderAddressLabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senderPortLabel))
                    .addComponent(minRateLabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maxRateLabelInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(receiverPortLabelInput)
                    .addComponent(senderPortLabelInput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeControllersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberActiveLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiverAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receiverAddressLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receiverPortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receiverPortLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senderAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senderAddressLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senderPortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senderPortLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minRateLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxRateLabelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(373, 275));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Event Method to close the display.
     * @param evt The action event
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        /* Closes the dialog box when pressed */
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * Method to run the display.
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
            java.util.logging.Logger.getLogger(StatMuxDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatMuxDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatMuxDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatMuxDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            StatMuxDisplay dialog = 
                    new StatMuxDisplay(new javax.swing.JFrame());
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
    public void runDisplay(){
        this.setVisible(true);
    }
    /**
     * StatMux Number Active Controller Label Setter.
     * @param number The Number of Active Controllers
     */
    public void setNumberActiveControllersLabel(String number){
        numberActiveLabelInput.setText(number);    
    }
    /**
     * StatMux Receiver Address Label Setter.
     * @param address The Number of Active Controllers
     */
    public void setReceiverAddressLabel(String address){
        receiverAddressLabelInput.setText(address);    
    }
    /**
     * StatMux Receiver Port Label Setter.
     * @param port The Port Number
     */
    public void setReceiverPortLabel(String port){
        receiverPortLabelInput.setText(port);    
    }
    /**
     * StatMux Receiver Address Label Setter.
     * @param address The Number of Active Controllers
     */
    public void setSenderAddressLabel(String address){
        senderAddressLabelInput.setText(address);    
    }
    /**
     * StatMux Sender Port Label Setter.
     * @param port The Port Number
     */
    public void setSenderPortLabel(String port){
        senderPortLabelInput.setText(port);    
    }
    /**
     * StatMux Min Rate Label Setter.
     * @param min The Minimum Rate
     */
    public void setMinRateLabel(String min){
        minRateLabelInput.setText(min);    
    }
    /**
     * StatMux Max Rate Label Setter.
     * @param max The Maximum Rate
     */
    public void setMaxRateLabel(String max){
        maxRateLabelInput.setText(max);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeControllersLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel maxRateLabel;
    private javax.swing.JLabel maxRateLabelInput;
    private javax.swing.JLabel minRateLabel;
    private javax.swing.JLabel minRateLabelInput;
    private javax.swing.JLabel numberActiveLabelInput;
    private javax.swing.JLabel receiverAddressLabel;
    private javax.swing.JLabel receiverAddressLabelInput;
    private javax.swing.JLabel receiverPortLabel;
    private javax.swing.JLabel receiverPortLabelInput;
    private javax.swing.JLabel senderAddressLabel;
    private javax.swing.JLabel senderAddressLabelInput;
    private javax.swing.JLabel senderPortLabel;
    private javax.swing.JLabel senderPortLabelInput;
    // End of variables declaration//GEN-END:variables
}
