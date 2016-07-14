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
            
            /* Create new labels with each piece of data */
            JLabel nameLabel = display.createLabel(semData.getName(),
                    semData.getSemNumber(), semData.getDevice());
            /* Creates the rest of the labels for the SEM */
            JLabel typeLabel = display.createLabel("Type: " + 
                    semData.getType(), 0, semData.getDevice());
            JLabel addressLabel = display.createLabel("Address: " + 
                    semData.getAddress(), 0, semData.getDevice());
            JLabel roleLabel = display.createLabel("Role: " + 
                    semData.getRole(), 0, semData.getDevice());
            
            /* Function call to create a panel for the SEM's */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    semData.getDevice());
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
            
            /* Create new labels with each piece of data */
            JLabel nameLabel = display.createLabel(tmxData.getName(), 
                    tmxData.getTmxNumber(), tmxData.getDevice());
            JLabel typeLabel = display.createLabel("Type: " + 
                    tmxData.getType(), 0, tmxData.getDevice());
            JLabel addressLabel = display.createLabel("Address: " + 
                    tmxData.getAddress(), 0, tmxData.getDevice());
            JLabel roleLabel = display.createLabel("Role: " + 
                    tmxData.getRole(), 0, tmxData.getDevice());
            
            /* Function call to create a panel for the TMX device */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    tmxData.getDevice());
        }
        /* Function call to set the TMX data border */
        display.setTmxBorder("TMX Data (" + tmxList.size() + " Total)");
        /* Function call to set the TMX Linked List */
        display.setTMXList(tmxList);   
    }
    
    /**
     * Method to display relevant Encoder data.
     * @param encList The Linked List of all encoders
     */
    public void displayENC(LinkedList encList){
        /* Loop through the list of Encoder devices */
        for(int i = 0; i < encList.size(); i++){
            /* Initialize a new Encoder data object from the Encoder list */
            A7_Encoder encData = (A7_Encoder) encList.get(i);
            
            /* Create new labels with each piece of data */
            JLabel nameLabel = display.createLabel(encData.getName(), 
                    encData.getEncNumber(), encData.getDevice());
            JLabel typeLabel = display.createLabel("Type: " + 
                    encData.getType(), 0, encData.getDevice());
            JLabel addressLabel = display.createLabel("Address: " + 
                    encData.getAddress(), 0, encData.getDevice());
            JLabel roleLabel = display.createLabel("Role: " + 
                    encData.getRole(), 0, encData.getDevice());
            
            /* Function call to create a panel for the encoders */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    encData.getDevice());
        }
        
        /* Function call to set the Encoder data border */
        display.setEncBorder("Encoder Data (" + encList.size() + " Total)");
        /* Function call to set the Encoder Linked List */
        display.setEncList(encList);
    }
    
    /**
     * Method to make the display visible
     */
    public void runDisplay(){
        display.setVisible(true);
    }
}