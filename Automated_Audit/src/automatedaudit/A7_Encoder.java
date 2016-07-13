/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class is used to gather the Encoder information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A7_Encoder implements A0_EquipmentIdentifiers{
    
    private int encNumber;
    private String name, address, version, role, type, site, positionID;
    private String elementGroup, redundancyGroup, encoderGroup;
    private String primaryDevice, encFileLocation, line;
    private final String mainFileLocation;
    private A8_ExpandedEncUI expEncUI;
    private Path encFilePath;
    private Scanner encScan, encData;
    
    /**
     * Class constructor that sets the main file folder location
     * @param location The main file folder location
     */
    public A7_Encoder(String location){
        mainFileLocation = location;
    }
    
    /**
     * Method to initialize the Encoder expanded display.
     * @param encList The List of Encoder Devices
     * @param encNumber The Specific Encoder Device Number
     */
    public void displayExpandedENC(LinkedList encList, int encNumber){
        
        /* Initialize a new Expanded Encoder UI Display */
        expEncUI = new A8_ExpandedEncUI();
        
        /* Loop through the Encoder list to get the specific Encoder data */
        for(int i = 0; i < encList.size(); i++){
            /* Creates a new Encoder Object from the Encoder Object at i */
            A7_Encoder eData = (A7_Encoder) encList.get(i);
            /* Checks if Encoder in list matches specified Encoder device */
            if( eData.getEncNumber() == encNumber) {
                /* Sets all the device labels for the expanded UI */
                expEncUI.setDeviceLabel(eData.getName());
                expEncUI.setAddressLabel(eData.getAddress());
                expEncUI.setRoleLabel(eData.getRole());
                expEncUI.setSiteLabel(eData.getSite());
                expEncUI.setElementGroupLabel(eData.getElementGroup());
                expEncUI.setRedundancyGroupLabel(eData.getRedundancyGroup());
                expEncUI.setEncoderGroupLabel(eData.getEncoderGroup());
                expEncUI.setPrimaryDeviceLabel(eData.getPrimaryDevice());
            }
        }
        /* Makes Display Visible */
        expEncUI.setVisible(true);
    }
    
    
    /**
     * Method to parse the specific encoder file to get all the encoder data.
     * @throws IOException If an error occurs
     */
    public void parseEncFile() throws IOException{
        
        /* Concats the encoder file location to the main folders location*/
        encFileLocation = mainFileLocation.concat("config\\" + positionID);
        /* Initializes a file path for the encoder file */
        encFilePath = Paths.get(encFileLocation);
        /* Initializes a scanner for the file */
        encScan = new Scanner(encFilePath);
        
        /* Loop through each line of the encoder file */
        while(encScan.hasNextLine()){
            /* Sets string to the full line */
            line = encScan.nextLine();
            
            /* If statements checking if a line matches the data we need */
            if(line.contains("Site")){
                /* Initializes scanner to next "=" */
                encData = new Scanner(line).useDelimiter("=");
                encData.next();
                this.setSite(encData.next());//sets site
            }
            else if(line.contains("ElementGroup")){
                /* Initializes scanner to next "=" */
                encData = new Scanner(line).useDelimiter("=");
                encData.next();
                this.setElementGroup(encData.next());//sets element group
            }
            else if(line.contains("Role")){
                /* Initializes scanner to next "=" */
                encData = new Scanner(line).useDelimiter("=");
                encData.next();
                this.setRole(encData.next());//sets role
            }
            else if(line.contains("RedundancyGroup")){
                /* Initializes scanner to next "=" */
                encData = new Scanner(line).useDelimiter("=");
                encData.next();
                this.setRedundancyGroup(encData.next());//sets redundant group
            }
            else if(line.contains("EncoderGroup")){
                /* Initializes scanner to next "=" */
                encData = new Scanner(line).useDelimiter("=");
                encData.next();
                this.setEncoderGroup(encData.next());//sets encoder group
            }
        }
    }
    
    /**
     * Encoder Primary Device Getter.
     * @return The Encoder Primary Device
     */
    public String getPrimaryDevice() {
        return primaryDevice;
    }

    /**
     * Encoder Primary Device Setter.
     * @param primary The Encoder Primary Device
     */
    public void setPrimaryDevice(String primary) {
        primaryDevice = primary;
    }
    
    /**
     * Encoder Number Setter
     * @param number The Encoder Number
     */
    public void setEncNumber(int number){
        encNumber = number;
    }
    
    /**
     * Encoder Number Getter.
     * @return The Encoder Number
     */
    public int getEncNumber(){
        return encNumber;
    }
    
    /**
     * Encoder Site Getter.
     * @return The Encoder Site
     */
    public String getSite() {
        return site;
    }

    /**
     * Encoder Site Setter.
     * @param encSite The encoder Site
     */
    public void setSite(String encSite) {
        site = encSite;
    }
    
    /**
     * Encoder Element Group Getter.
     * @return The Encoder Element Group
     */
    public String getElementGroup() {
        return elementGroup;
    }

    /**
     * Encoder Element Group Setter.
     * @param eGroup The Encoder Element Group
     */
    public void setElementGroup(String eGroup) {
        elementGroup = eGroup;
    }
    
    /**
     * Encoder Redundancy Group Getter.
     * @return The Encoder Redundancy Group
     */
    public String getRedundancyGroup() {
        return redundancyGroup;
    }

    /**
     * Encoder Redundancy Group Setter.
     * @param rGroup The Encoder Redundancy Group
     */
    public void setRedundancyGroup(String rGroup) {
        redundancyGroup = rGroup;
    }
    
    /**
     * Encoder Group Getter.
     * @return The Encoder Group
     */
    public String getEncoderGroup() {
        return encoderGroup;
    }

    /**
     * Encoder Group Setter.
     * @param eGroup The Encoder Group
     */
    public void setEncoderGroup(String eGroup) {
        encoderGroup = eGroup;
    }
    
    /**
     * Encoder Name Getter.
     * @return The Encoder Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Encoder Name Setter.
     * @param name The Encoder Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Encoder IP Address Getter.
     * @return The Encoder IP Address
     */
    @Override
    public String getAddress() {
       return address;
    }

    /**
     * Encoder IP Address Setter.
     * @param address The Encoder IP Address
     */
    @Override
    public void setAddress(String address) {
       this.address = address;
    }

    /**
     * Encoder Version Getter.
     * @return The Encoder Version Number
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * Encoder Version Setter.
     * @param version The Encoder Version Number
     */
    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Encoder Role Getter.
     * @return The Encoder Role
     */
    @Override
    public String getRole() {
       return role;
    }

    /**
     * Encoder Role Setter.
     * @param role The Encoder Role
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Encoder Type Getter.
     * @return The Encoder Type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Encoder Type Setter.
     * @param type The Encoder Type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Encoder Position ID Getter.
     * @return The Encoder Position ID
     */
    @Override
    public String getPositionID() {
        return positionID;
    }

    /**
     * Encoder Position ID Setter.
     * @param positionID The Encoder Position ID
     */
    @Override
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
}
