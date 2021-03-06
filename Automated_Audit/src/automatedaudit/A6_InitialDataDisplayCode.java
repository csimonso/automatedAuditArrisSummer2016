/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JLabel;

/**
 * Class to initialize the main data display.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A6_InitialDataDisplayCode {
    
    private final A6_InitialDataDisplayGUI display;
    private String ntpIpAddress, operatorGroup;
    
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
        display.displayDataMUX(muxData.getName());
        display.displayDataMUX(muxData.getIPAddress());
        display.displayDataMUX(muxData.getVersion());
        display.displayDataMUX("NTP IP Address: " + ntpIpAddress);
        display.displayDataMUX("Operator Group: " + operatorGroup);
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
                    semData.getDataMap().get("Role"), 0, semData.getDevice());
            /* Function call to create a panel for the SEM's */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    semData.getDevice());
        }
        /* Function call to set the SEM data border */
        display.setBorder("SEM Data (" + semList.size() + " Total)", "SEM");
        /* Function call to set the SEM Linked List */
        display.setList(semList, "SEM");
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
                    tmxData.getDataMap().get("Role"), 0, tmxData.getDevice());
            /* Function call to create a panel for the TMX device */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    tmxData.getDevice());
        }
        /* Function call to set the TMX data border */
        display.setBorder("TMX Data (" + tmxList.size() + " Total)", "TMX");
        /* Function call to set the TMX Linked List */
        display.setList(tmxList, "TMX");   
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
            if(encData.getDataMap().get("Role").equals("Primary")){
                /* Set the NTP IP Address for the System */
                ntpIpAddress = (String)encData.getDataMap()
                        .get("ntpPeerIpAddress");
            }
            /* Create new labels with each piece of data */
            JLabel nameLabel = display.createLabel(encData.getName(), 
                    encData.getEncNumber(), encData.getDevice());
            JLabel typeLabel = display.createLabel("Type: " + 
                    encData.getType(), 0, encData.getDevice());
            JLabel addressLabel = display.createLabel("Address: " + 
                    encData.getAddress(), 0, encData.getDevice());
            JLabel roleLabel = display.createLabel("Role: " + 
                    encData.getDataMap().get("Role"), 0, encData.getDevice());
            /* Function call to create a panel for the encoders */
            display.createPanel(nameLabel, typeLabel, addressLabel, roleLabel, 
                    encData.getDevice());
        }
        /* Function call to set the Encoder data border */
        display.setBorder("Encoder Data (" + encList.size() + " Total)", "ENC");
        /* Function call to set the Encoder Linked List */
        display.setList(encList, "ENC");
    }
    
    /**
     * Method to display relevant Satellite data.
     * @param satData The Satellite data
     */
    public void displaySAT(A7_SATELLITE satData){
        Map satMap = satData.getDataMap();
        ArrayList satList = satData.getSatList();
        
        for(int i = 0; i < satList.size(); i++){
            int satNumber = Integer.parseInt((String)satList.get(i));
            
            JLabel nameLabel = display.createSatLabel((String) satMap.get(
                    "Satellite" + satNumber + "Name"), satNumber, satData);
            JLabel fullNameLabel = display.createSatLabel("Name: " + satMap.get(
                    "Satellite" + satNumber + "FullName"), 0, satData);
            JLabel hemisphereLabel = display.createSatLabel(
                    "Hemi: " + satMap.get("Satellite" + satNumber + 
                            "Hemisphere"), 0, satData);
            JLabel polarizationLabel = display.createSatLabel(
                    "Polar: " + satMap.get("Satellite" + satNumber + 
                            "Polarization"), 0, satData);
            
            display.createSatPanel(nameLabel, fullNameLabel, hemisphereLabel, 
                    polarizationLabel);
        } 
    }
    
    /**
     * Method to make the display visible
     */
    public void runDisplay(){
        display.setVisible(true);
    }
    /**
     * Operator Group Setter.
     * @param opGroup The Operator Group
     */
    public void setOperatorGroup(String opGroup){
        operatorGroup = opGroup;
    }
}