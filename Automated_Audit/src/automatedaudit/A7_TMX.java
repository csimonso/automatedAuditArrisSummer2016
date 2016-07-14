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
 * This class is used to gather the TMX information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A7_TMX implements A0_EquipmentIdentifiers {

    private final String fileLocation;
    private String type, name, address, role, positionID, site, version, line;
    private String elementGroup, redundancyGroup, encoderGroup, device;
    private String backupDevice, primaryDevice, osVersion, tmxFileLocation;
    private Path tmxFilePath;
    private Scanner tmxScan, tmxData;
    private int tmxNumber, priorityNumber;
    
    /**
     * Class constructor that sets the main file folder location
     * @param location The main file folder location
     */
    public A7_TMX(String location){
        fileLocation = location;
    }
    
    /**
     * Method to initialize the TMX expanded display.
     * @param expTmxUI The expanded TMX UI
     * @param tmxList The List of TMX Devices
     * @param tmxNumber The Specific TMX Device Number
     */
    public void displayExpandedTMX(A8_ExpandedTmxUI expTmxUI, 
            LinkedList tmxList, int tmxNumber){
        
        /* Loop through the TMX list to get the specific TMX data */
        for(int i = 0; i < tmxList.size(); i++){
            /* Creates a new TMX Object from the TMX Object at i */
            A7_TMX tData = (A7_TMX) tmxList.get(i);
            /* Checks if TMX in list matches specified TMX device */
            if( tData.getTmxNumber() == tmxNumber) {
                /* Sets all the device labels for the expanded UI */
                expTmxUI.setDeviceLabel(tData.getName() + "(" +
                        tData.getRole() + ")");
                expTmxUI.setAddressLabel(tData.getAddress());
                expTmxUI.setSiteLabel(tData.getSite());
                expTmxUI.setElementGroupLabel(tData.getElementGroup());
                expTmxUI.setRedundancyGroupLabel(tData.getRedundancyGroup());
                expTmxUI.setEncoderGroupLabel(tData.getEncoderGroup());
                expTmxUI.setBackupDeviceLabel(tData.getBackupDevice());
                expTmxUI.setPrimaryDeviceLabel(tData.getPrimaryDevice());
                expTmxUI.setVersionLabel(tData.getVersion());
                expTmxUI.setOsVersionLabel(tData.getOsVersion());
            }
        }
        /* Makes Display Visible */
        expTmxUI.setVisible(true);
    }
    
    /**
     * Method to parse the specific TMX file to get all the TMX data.
     * @throws IOException If an error occurs
     */
    public void parseTmxFile() throws IOException{
        /* Concats the TMX file location to the main folders location*/
        tmxFileLocation = fileLocation.concat("config\\" + positionID);
        /* Initializes a file path for the TMX file */
        tmxFilePath = Paths.get(tmxFileLocation);
        /* Initializes a scanner for the file */
        tmxScan = new Scanner(tmxFilePath);
        
        /* Loop through each line of the TMX file */
        while(tmxScan.hasNextLine()){
            /* Sets string to the full line */
            line = tmxScan.nextLine();
            
            /* If statements checking if a line matches the data we need */
            if(line.contains("Role")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setRole(tmxData.next());//sets role
            }
            else if(line.contains("Site")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setSite(tmxData.next());//sets site
            }
            else if(line.contains("ElementGroup")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setElementGroup(tmxData.next());//sets element group
            }
            else if(line.contains("RedundancyGroup")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setRedundancyGroup(tmxData.next());//sets rundant group
            }
            else if(line.contains("EncoderGroup")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setEncoderGroup(tmxData.next());//sets encoder group
            }
            else if(line.contains("Backup")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setBackupDevice(tmxData.next());//sets backup device
            }
            else if(line.contains("Primary")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setPrimaryDevice(tmxData.next());//sets primary device
            }
            else if(line.contains("AppVersion")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setVersion(tmxData.next());//sets app version
            }
            else if(line.contains("OSVersion")){
                /* Initializes scanner to next "=" */
                tmxData = new Scanner(line).useDelimiter("=");
                tmxData.next();
                this.setOsVersion(tmxData.next());//sets os version
            }
        }
    }
    
    /**
     * TMX Priority Number Setter
     * @param pNumber The TMX priority number(1-primary, 2-backup)
     */
    @Override
    public void setPriorityNumber(int pNumber){
        priorityNumber = pNumber;
    }
    /**
     * TMX Priority Number Getter
     * @return The TMX Priority Number(1-primary, 2-backup)
     */
    @Override
    public int getPriorityNumber(){
        return priorityNumber;
    }
    
    /**
     * Setter for the type of device.
     * @param dev The type of device(TMX)
     */
    @Override
    public void setDevice(String dev){
        device = dev;
    }
    /**
     * Getter for the type of device.
     * @return The device type(TMX)
     */
    @Override
    public String getDevice(){
        return device;
    }
    
    /**
     * TMX Number Setter
     * @param number The TMX Number
     */
    public void setTmxNumber(int number){
        tmxNumber = number;
    }
    
    /**
     * TMX Number Getter.
     * @return The TMX Number
     */
    public int getTmxNumber(){
        return tmxNumber;
    }
    
    /**
     * TMX Name Getter.
     * @return The TMX Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * TMX Name Setter.
     * @param name The TMX Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TMX IP Address Getter.
     * @return The TMX IP Address
     */
    @Override
    public String getAddress() {
       return address;
    }

    /**
     * TMX IP Address Setter.
     * @param address The TMX IP Address
     */
    @Override
    public void setAddress(String address) {
       this.address = address;
    }

    /**
     * TMX AppVersion Getter.
     * @return The TMX AppVersion Number
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * TMX AppVersion Setter.
     * @param appVersion The TMX AppVersion Number
     */
    @Override
    public void setVersion(String appVersion) {
        version = appVersion;
    }

    /**
     * TMX Role Getter.
     * @return The TMX Role
     */
    @Override
    public String getRole() {
       return role;
    }

    /**
     * TMX Role Setter.
     * @param role The TMX Role
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * TMX Type Getter.
     * @return The TMX Type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * TMX Type Setter.
     * @param type The TMX Type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * TMX Position ID Getter.
     * @return The TMX Position ID
     */
    @Override
    public String getPositionID() {
        return positionID;
    }

    /**
     * TMX Position ID Setter.
     * @param positionID The TMX Position ID
     */
    @Override
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
    
    /**
     * TMX Site Getter.
     * @return The TMX Site
     */
    public String getSite() {
        return site;
    }

    /**
     * TMX Site Setter.
     * @param tmxSite The TMX Site
     */
    public void setSite(String tmxSite) {
        site = tmxSite;
    }
    
    /**
     * TMX Element Group Getter.
     * @return The TMX Element Group
     */
    public String getElementGroup() {
        return elementGroup;
    }

    /**
     * TMX Element Group Setter.
     * @param eGroup The TMX Element Group
     */
    public void setElementGroup(String eGroup) {
        elementGroup = eGroup;
    }
    
    /**
     * TMX Redundancy Group Getter.
     * @return The TMX Redundancy Group
     */
    public String getRedundancyGroup() {
        return redundancyGroup;
    }

    /**
     * TMX Redundancy Group Setter.
     * @param rGroup The TMX Redundancy Group
     */
    public void setRedundancyGroup(String rGroup) {
        redundancyGroup = rGroup;
    }
    
    /**
     * TMX Encoder Group Getter.
     * @return The TMX Encoder Group
     */
    public String getEncoderGroup() {
        return encoderGroup;
    }

    /**
     * TMX Encoder Group Setter.
     * @param eGroup The TMX Encoder Group
     */
    public void setEncoderGroup(String eGroup) {
        encoderGroup = eGroup;
    }
    
    /**
     * TMX Backup Device Getter.
     * @return The TMX Backup Device
     */
    public String getBackupDevice() {
        return backupDevice;
    }

    /**
     * TMX Backup Device Setter.
     * @param backup The TMX Backup Device
     */
    public void setBackupDevice(String backup) {
        backupDevice = backup;
    }
    
    /**
     * TMX Primary Device Getter.
     * @return The TMX Primary Device
     */
    public String getPrimaryDevice() {
        return primaryDevice;
    }

    /**
     * TMX Primary Device Setter.
     * @param primary The TMX Primary Device
     */
    public void setPrimaryDevice(String primary) {
        primaryDevice = primary;
    }
    
    /**
     * TMX OS Version Getter.
     * @return The TMX OS Version Number
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * TMX OS Version Setter.
     * @param oVersion The TMX OS Version Number
     */
    public void setOsVersion(String oVersion) {
        osVersion = oVersion;
    }
}
