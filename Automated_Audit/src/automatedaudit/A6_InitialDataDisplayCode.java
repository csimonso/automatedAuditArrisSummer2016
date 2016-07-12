/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.util.LinkedList;
import javax.swing.JLabel;

/**
 * Class to initialize the main data display.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A6_InitialDataDisplayCode {
    
    private final A6_InitialDataDisplayGUI display;
    
    /**
     * Class Constructor to initialize the GUI.
     * @param location The File Location
     */
    public A6_InitialDataDisplayCode(String location){
        display = new A6_InitialDataDisplayGUI(location);
    }
    
    /**
     * Method to display relevant MUX data.
     * @param muxData The data to be displayed.
     */
    public void displayMUX(A4_MUX muxData){
        display.displayDataMUX("Server Name: " + muxData.getName());
        display.displayDataMUX("Server Address: " + muxData.getIPAddress());
        display.displayDataMUX("Server Version: " + muxData.getVersion());
    }
    
    /**
     * Method to display relevant SEM data.
     * @param semList The Linked List of all SEM devices
     */
    public void displaySEM(LinkedList semList){
        /* Loop through the list of SEM devices */
        for(int i = 0; i < semList.size(); i++){
            /* Initialize a new SEM data object from the SEM device list */
            A7_SEM semData = (A7_SEM) semList.get(i);
            /* Function calls to set all the main data of each SEM */
            display.displayDataSEM("Name: " + semData.getName(), 
                    semData.getSemNumber());
            display.displayDataSEM("Type: " + semData.getType(), 0);
            display.displayDataSEM("Address: " + semData.getAddress(), 0);
            display.displayDataSEM("Role: " + semData.getRole(), 0);
            display.displayDataSEM("\n", 0); 
        }
        /* Function call to set the SEM data border */
        display.setSemBorder("SEM Data (" + semList.size() + " Total)");
        /* Function call to set the SEM Linked List */
        display.setSEMList(semList);
    }
    
    /**
     * Method to display relevant TMX data.
     * @param tmxList The Linked List of all TMX devices
     */
    public void displayTMX(LinkedList tmxList){
        /* Loop through the list of TMX devices */
        for(int i = 0; i < tmxList.size(); i++){
            /* Initialize a new TMX data object from the TMX device list */
            A7_TMX tmxData = (A7_TMX) tmxList.get(i);
            /* Function calls to set all the main data of each TMX */
            display.displayDataTMX("Name: " + tmxData.getName(), 
                    tmxData.getTmxNumber());
            display.displayDataTMX("Type: " + tmxData.getType(), 0);
            display.displayDataTMX("Address: " + tmxData.getAddress(), 0);
            display.displayDataTMX("Role: " + tmxData.getRole(), 0);
            display.displayDataTMX("\n", 0); 
        }
        /* Function call to set the TMX data border */
        display.setTmxBorder("TMX Data (" + tmxList.size() + " Total)");
        /* Function call to set the TMX Linked List */
        display.setTMXList(tmxList);
    }
    
    /**
     * Method to display relevant Encoder data.
     * @param encData The data to be displayed.
     * @param encList The Linked List of all encoders
     */
    public void displayENC(Encoder encData, LinkedList encList){
        JLabel nameLabel;
        JLabel typeLabel;
        JLabel addressLabel;
        
        nameLabel = display.displayDataENC("Name: " + encData.getName());
        typeLabel = display.displayDataENC("Type: " + encData.getType());
        addressLabel = display.displayDataENC("Address: " + encData.getAddress());
        
        display.createEncPanel(nameLabel, typeLabel, addressLabel);
    }
    
    /**
     * Method to make the display visible
     */
    public void runDisplay(){
        display.setVisible(true);
    }
}
