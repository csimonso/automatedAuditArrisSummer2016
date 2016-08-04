/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is used to gather the TMX information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A7_TMX implements A0_EquipmentIdentifiers {

    private final String fileLocation;
    private String type, name, address, role, positionID, site, version, line;
    private String elementGroup, redundancyGroup, encoderGroup, device, service;
    private String backupDevice, primaryDevice, osVersion, tmxFileLocation;
    private Path tmxFilePath;
    private Scanner tmxScan;
    private int tmxNumber, priorityNumber, statGroupNumber, serviceGroupNumber,
            componentGroupNumber;
    private ArrayList statGroupList, serviceNumber, componentNumber;
    
    private final String[] strings = {"Role","Site", "ElementGroup",
        "RedundancyGroup", "EncoderGroup",  "AppVersion",  "OSVersion", 
        "Primary", "Backup", "StatGroup", "TMX.Service", "TMX.Component"};
    private final String[] compStrings = {"Name", "OutputPID", "ComponentType", 
        "Description", "TranscodeMode", "TranscodeBias", "AudioType", 
        "Ac3DescPassThru", "DVSAudio", "SourceStreamType"};
    private final String[] serviceStrings = {"Name", "PmtPID", "BitRate", 
        "Type", "TargetPcrPid"};
    
    
    private final Map results = new HashMap<>();
    private final Map serviceResults = new HashMap<>();
    private final Map componentResults = new HashMap<>();
    
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
        /* Loops through the List of TMX to display the correct one */
        for(int i = 0; i < tmxList.size(); i++){
            /* Gets the current TMX from the list */
            A7_TMX tData = (A7_TMX) tmxList.get(i);
            /* Checks if current TMX is the correct one to be displayed */
            if(tData.getTmxNumber() == tmxNumber){
                /* Sets the Expanded Display Labels */
                expTmxUI.setDeviceLabel(tData.getName() + " (" + 
                        tData.results.get("Role") + ")");
                expTmxUI.setAddressLabel(tData.getAddress());
                expTmxUI.setSiteLabel( (String) tData.results.get("Site"));
                expTmxUI.setElementGroupLabel( (String) tData.results.get(
                        "ElementGroup"));
                expTmxUI.setRedundancyGroupLabel( (String) tData.results.get(
                        "RedundancyGroup"));
                expTmxUI.setEncoderGroupLabel( (String) tData.results.get(
                        "EncoderGroup"));
                expTmxUI.setVersionLabel( (String) tData.results.get(
                        "AppVersion"));
                expTmxUI.setOsVersionLabel( (String) tData.results.get(
                        "OSVersion"));
                /* Checks if current TMX is the primary device */
                if(tData.getPriorityNumber() == 1){
                    /* Loop through list to find the backup device */
                    for(int j = 0; j < tmxList.size(); j++){
                        A7_TMX otherDevice = (A7_TMX) tmxList.get(j);
                        /* Sets the Backup Device label */
                        if(otherDevice.getPriorityNumber() == 2){
                            expTmxUI.setBackupDeviceLabel(otherDevice.getName());
                        }
                    }
                }
                else {
                    /* Loop through list to find the Primary Device */
                    for(int j = 0; j < tmxList.size(); j++){
                        A7_TMX otherDevice = (A7_TMX) tmxList.get(j);
                        /* Sets the Primary Device Label */
                        if(otherDevice.getPriorityNumber() == 1){
                            expTmxUI.setPrimaryDeviceLabel(otherDevice.getName());
                        }
                    }
                }
                /* Sets the Stat Group Drop Down Menu */
                expTmxUI.setStatGroupDropDown(tData);
                /* Creates the Service Display Dialog Box */
                expTmxUI.serviceDisplay(tData);
                expTmxUI.pack();
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
        /* Declare Local Variables */
        String value;
        String[] splitString;
        String[] serviceLine;
        String[] componentLine;
        
        /* Concats the TMX file location to the main folders location*/
        tmxFileLocation = fileLocation.concat("config\\" + positionID);
        /* Initializes a file path for the TMX file */
        tmxFilePath = Paths.get(tmxFileLocation);
        /* Initializes a scanner for the file */
        tmxScan = new Scanner(tmxFilePath);
        /* Initializes the Array Lists */
        statGroupList = new ArrayList();
        serviceNumber = new ArrayList();
        componentNumber = new ArrayList();
        /* Initialize the number variables */
        statGroupNumber = 0;
        serviceGroupNumber = 0;
        componentGroupNumber = 0;
        /* Loops through each line of the file */
        while(tmxScan.hasNextLine()){
            /* Sets the string to the next line */
            line = tmxScan.nextLine();
            /* Loops through each member of the strings array */
            for(String sub:strings){
                /* Checks if the current line is part of the strings array */
                if(line.contains(sub)){
                    /* Splits the string at the equals sign */
                    splitString = line.split("=");
                    /* Checks that there is data after the equals sign */
                    if(splitString.length > 1){
                        value = splitString[1];
                    }
                    /* If no data, sets value to represent that */
                    else value = "No Data"; 
                    /* Checks for Stat Group, Service and Component data */
                    switch (sub) {
                        /* Stat Group Data */
                        case "StatGroup":
                            /* Sets the Stat Group Name */
                            if(line.contains("Name")){
                                statGroupNumber++;//increments count
                                sub = sub + ".Name" + statGroupNumber;
                                statGroupList.add(sub);
                                results.put(sub, value);
                            }   break;
                        /* Service Data */
                        case "TMX.Service":
                            /* Loops through the Service Strings */
                            for(String serv:serviceStrings){
                                /* Checks for a String match */
                                if(line.contains(serv)){
                                    /* Splits the current line */
                                    serviceLine = line.split("\\.");
                                    /* Adds new Service ID to List */
                                    if(serv.equals("Name")){
                                        /* Increment Total Service's */
                                        serviceGroupNumber++;
                                        serviceNumber.add(serviceLine[2]);
                                        service = serviceLine[2];
                                    }
                                    serv ="Service" + serviceLine[2] + serv;
                                    serviceResults.put(serv, value);
                                }
                            } break;
                        /* Component Data */  
                        case "TMX.Component":
                            /* Loops through the Component Strings */
                            for(String comp:compStrings){
                                /* Checks for a String match */
                                if(line.contains(comp)){
                                    /* Splits the current line */
                                    componentLine = line.split("\\.");
                                    /* Adds new Component ID to List */
                                    if(comp.equals("Name")){
                                        componentNumber.add(componentLine[2]);
                                    }
                                    comp = service + "Component" + 
                                            componentLine[2] + comp;
                                    componentResults.put(comp, value);
                                }
                            } break;
                        default:
                            results.put(sub, value);
                            break;
                    }
                }
            }
        }
    }
    
    /**
     * TMX Data Map Getter.
     * @return TMX Data Map
     */
    public Map getDataMap(){
        return results;
    }
    /**
     * TMX STAT Group List Getter.
     * @return TMX STAT Group List
     */
    public ArrayList getStatGroupList(){
        return statGroupList;
    }
    /**
     * TMX STAT Group Setter.
     * @param list The TMX STAT Group List
     */
    public void setStatGroupList(ArrayList list){
        statGroupList = list;
    }
    /**
     * TMX Service Map Getter.
     * @return TMX Service Map
     */
    public Map getServiceMap(){
        return serviceResults;
    }
    /**
     * TMX Service Group Number Getter.
     * @return TMX Service Group Number
     */
    public int getServiceGroupNumber(){
        return serviceGroupNumber;
    }
    /**
     * TMX Service Number Getter.
     * @return TMX Service Number
     */
    public ArrayList getServiceNumber(){
        return serviceNumber;
    }
    /**
     * TMX Component Map Getter.
     * @return TMX Component Map
     */
    public Map getComponentMap(){
        return componentResults;
    }
    /**
     * TMX Component Group Number Getter.
     * @return TMX Component Group Number
     */
    public int getComponentGroupNumber(){
        return componentGroupNumber;
    }
    /**
     * TMX Component Number List Getter.
     * @return TMX Component Number List
     */
    public ArrayList getComponentNumber(){
        return componentNumber;
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
    public String getVersion() {
        return version;
    }
    /**
     * TMX AppVersion Setter.
     * @param appVersion The TMX AppVersion Number
     */
    public void setVersion(String appVersion) {
        version = appVersion;
    }
    /**
     * TMX Role Getter.
     * @return The TMX Role
     */
    public String getRole() {
       return role;
    }
    /**
     * TMX Role Setter.
     * @param role The TMX Role
     */
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
