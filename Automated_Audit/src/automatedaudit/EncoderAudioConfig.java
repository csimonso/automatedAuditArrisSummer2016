/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Class to create a display to view the Encoder Audio Configuration.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class EncoderAudioConfig extends javax.swing.JDialog {

    DefaultTableModel audioModel;
    DefaultTableModel proxyModel;
    DefaultTableCellRenderer render;
    private final String[] audioHeader = {"CH", "Active", "Out PID", 
        "Hold PID", "Compression Type", "Bitrate", "DLG NORM", 
        "Source"}; 
    private final Map<String, String> rateMap = new HashMap<String, String>() 
        {{ 
            put(" 0", "96K"); put(" 1", "112K"); put(" 2", "128K"); 
            put(" 3", "160K"); put(" 4", "192K"); put(" 5", "224K");
            put(" 6", "256K"); put(" 7", "320K"); put(" 8", "384K"); 
            put(" 9", "448K"); put(" 10", "512K"); put(" 11", "576K");
            put(" 12", "640K"); put(" 13", "48K"); put(" 14", "64K"); 
            put(" 16", "80K"); put(" 17", "56K"); put(" 18", "40K");
            put(" 19", "32K");
        }};
    private final Map<String, String> compressionMap = 
            new HashMap<String, String>() 
        {{ 
            put(" 1", "PassThrough AC-3"); put(" 2", "Encode MPEG 1 Layer II"); 
            put(" 4", "Encode Pulse Pro AAC"); put(" 10", "Encode AC-3"); 
            put(" 12", "PassThrough DD+Pro"); 
            put(" 17", "Downsample To Stereo AC-3"); 
            put(" 18", "Downsample To PulsePro AAC"); 
        }};
    private final Map<String, String> sourceMap = new HashMap<String, String>() 
        {{ 
            put(" 2", "SDI Group1 Ch 1/2"); put(" 3", "SDI Group1 Ch 3/4"); 
            put(" 4", "SDI Group2 Ch 5/6"); put(" 5", "SDI Group2 Ch 7/8"); 
            put(" 6", "AES Input 1"); put(" 7", "AES Input 2");
            put(" 48", "SDI Group3 Ch 9/10"); put(" 49", "SDI Group3 Ch 11/12"); 
            put(" 50", "SDI Group4 Ch 13/14"); 
            put(" 51", "SDI Group4 Ch 15/16"); 
        }};
    
    /**
     * Creates new form EncoderAudioConfig
     * @param parent The parent display
     */
    public EncoderAudioConfig(java.awt.Frame parent) {
        super(parent);
        initComponents();
        audioModel = new DefaultTableModel(0, 0);
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        audioModel.setColumnIdentifiers(audioHeader);
        audioTable.setModel(audioModel);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        audioTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();
        writeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Audio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        audioTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        audioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No Data", null, "No Data", "No Data", "No Data", "No Data", "No Data", null}
            },
            new String [] {
                "Channel", "Active", "Out PID", "HOLD PID", "Compression Type", "Bit Rate", "Dialog Normalization", "Source"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(audioTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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
                .addContainerGap(518, Short.MAX_VALUE)
                .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(writeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(49, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(740, 294));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Button event to close the display.
     * @param evt The action event
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * Button event to call the class that writes the data to an Excel file.
     * @param evt The action event
     */
    private void writeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeButtonActionPerformed
        WriteTablesToFile write = new WriteTablesToFile(audioModel);
        try {
            write.writeTable("AudioTable");
            JOptionPane.showMessageDialog(this, 
                    "Table Written To File Successfully");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error Writing To File");
        } 
    }//GEN-LAST:event_writeButtonActionPerformed

    /**
     * Method to create the dialog box.
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
            java.util.logging.Logger.getLogger(EncoderAudioConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncoderAudioConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncoderAudioConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncoderAudioConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            EncoderAudioConfig dialog = 
                    new EncoderAudioConfig(new javax.swing.JFrame());
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
     * Method to set the data in the audio table rows.
     * @param eData The Encoders Data
     */
    public void setTableRows(A7_Encoder eData){
        /* Gets the audio Map from current encoder */
        Map audioMap = eData.getAudioMap();
        
        /* Loops through all 8 channels of Audio */
        for(int j = 0; j < 8; j++){
            /* Sets string to the current channel */
            String channel = Integer.toString(j+1);
            /* Sets the Audio Table Keys */
            String enable = "audioMainTable/audioEnable/1/" + channel;
            String outPid = "audioMainTable/atsc_audioOutPid/1/" + channel;
            String compression = "audioMainTable/audioStandard/1/" + channel;
            String bitRate = "audioMainTable/audioRate/1/" + channel;
            String dialNorm = "audioMainTable/audioDialnormEncode/1/" + 
                    channel;
            String source = "audioMainTable/audioGroupId/1/" + channel;
            String hold = "audioMainTable/audioHold/1/" + channel;
            
            /* Sets the Audio Table data */
            if(audioMap.containsKey(enable)){
                /* Adds a new row to the table */
                audioModel.addRow(new Object[] {"UNK", "UNK", "UNK", 
                    "UNK", "UNK", "UNK", "UNK", "UNK"});
                
                /* Adds Channel to table and sets column size */
                audioModel.setValueAt(channel, j, 0);
                audioTable.getColumnModel().getColumn(0).setMinWidth(40);
                audioTable.getColumnModel().getColumn(0).setMaxWidth(50);
                audioTable.getColumnModel().getColumn(0)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(0).setResizable(true);
                
                /* Adds Audio Enabled variable to table and sets column size */
                if(audioMap.get(enable).equals(" 1")){
                    audioModel.setValueAt("ENBLD", j, 1);
                }
                else if(audioMap.get(enable).equals(" 2"))
                    audioModel.setValueAt("DSBLD", j, 1);
                audioTable.getColumnModel().getColumn(1).setMinWidth(55);
                audioTable.getColumnModel().getColumn(1).setMaxWidth(65);
                audioTable.getColumnModel().getColumn(1)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(1).setResizable(true);
                
                /* Adds PID to table and sets column size */
                if(audioMap.containsKey(outPid) && 
                        !audioMap.get(outPid).equals("UNK")){
                    String pid = (String) audioMap.get(outPid);
                    audioModel.setValueAt(pid, j, 2);
                }
                audioTable.getColumnModel().getColumn(2).setMinWidth(55);
                audioTable.getColumnModel().getColumn(2).setMaxWidth(65);
                audioTable.getColumnModel().getColumn(2)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(2).setResizable(true);
                
                /* Adds Audio Hold to table and sets column size */
                if(audioMap.containsKey(hold) && 
                        !audioMap.get(hold).equals("UNK")){
                    if(audioMap.get(hold).equals(" 1"))
                        audioModel.setValueAt("Enabled", j, 3); 
                    else if(audioMap.get(hold).equals(" 0"))
                        audioModel.setValueAt("DSBLD", j, 3);
                }
                audioTable.getColumnModel().getColumn(3).setMinWidth(60);
                audioTable.getColumnModel().getColumn(3).setMaxWidth(70);
                audioTable.getColumnModel().getColumn(3)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(3).setResizable(true);
                
                /* Adds the Audio Compression Type to table, sets column size */
                if(audioMap.containsKey(compression) && 
                        !audioMap.get(compression).equals("UNK")){
                    String comp =compression((String)audioMap.get(compression));
                    audioModel.setValueAt(comp, j, 4);
                }
                audioTable.getColumnModel().getColumn(4).setMinWidth(150);
                audioTable.getColumnModel().getColumn(4).setMaxWidth(170);
                audioTable.getColumnModel().getColumn(4)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(4).setResizable(true);
                
                /* Adds the Audio Bitrate to the table, sets column size */
                if(audioMap.containsKey(bitRate) && 
                        !audioMap.get(bitRate).equals("UNK")){
                    String rate = bitRate((String) audioMap.get(bitRate));
                    audioModel.setValueAt(rate, j, 5);
                }
                audioTable.getColumnModel().getColumn(5).setMinWidth(55);
                audioTable.getColumnModel().getColumn(5).setMaxWidth(65);
                audioTable.getColumnModel().getColumn(5)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(5).setResizable(true);
                
                /* Adds the Dialog Normalization setting to table */
                if(audioMap.containsKey(dialNorm) && 
                        !audioMap.get(dialNorm).equals("UNK")){
                    String normalization = "-" + 
                            (String) audioMap.get(dialNorm) + "dB";
                    audioModel.setValueAt(normalization, j, 6);
                }
                audioTable.getColumnModel().getColumn(6).setMinWidth(80);
                audioTable.getColumnModel().getColumn(6).setMaxWidth(100);
                audioTable.getColumnModel().getColumn(6)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(6).setResizable(true);
                
                /* Adds the Source setting to table, sets column size */
                if(audioMap.containsKey(source) && 
                        !audioMap.get(source).equals("UNK")){
                    String src = source((String) audioMap.get(source));
                    audioModel.setValueAt(src, j, 7);
                }
                audioTable.getColumnModel().getColumn(7).setMinWidth(140);
                audioTable.getColumnModel().getColumn(7).setMaxWidth(160);
                audioTable.getColumnModel().getColumn(7)
                        .setCellRenderer(render);
                audioTable.getColumnModel().getColumn(7).setResizable(true);
            } 
        }
    }
    /**
     * Method to determine the mode of the Audio Compression.
     * @param value The number value of the compression setting
     * @return The compression setting
     */
    private String compression(String value){
        if(compressionMap.containsKey(value))
            return compressionMap.get(value);
        return "UNK";
    }
    /**
     * Method to determine the source of the Audio.
     * @param value The number value of the source setting
     * @return The source setting
     */
    private String source(String value){
        if(sourceMap.containsKey(value))
            return sourceMap.get(value);
        else return "UNK";
    }
    /**
     * Method to determine the BitRate of the Audio.
     * @param value The number value of the BitRate setting
     * @return The BitRate setting
     */
    private String bitRate(String value){
        if(rateMap.containsKey(value))
            return rateMap.get(value);
        else return "UNK";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable audioTable;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton writeButton;
    // End of variables declaration//GEN-END:variables
}