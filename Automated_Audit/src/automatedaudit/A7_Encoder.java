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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is used to gather the Encoder information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A7_Encoder implements A0_EquipmentIdentifiers{
    
    private int encNumber, priorityNumber;
    private String name, address, version,  type, positionID, device, 
            primaryDevice, encFileLocation, line;
    private final String[] strings = {"Site", "ElementGroup", "Role", 
        "RedundancyGroup", "EncoderGroup", "ntpPeerIpAddress", 
        "statMuxActiveCtrlr", "statMuxRecvGroupAddr", "statMuxMaxVideoTsRate", 
        "statMuxMinVideoTsRate", "statMuxSendGroupPort", "statMuxRecvGroupPort", 
        "statMuxSendGroupAddress", "audioMainTable/audioEnable", 
        "audioMainTable/audioStandard", "audioMainTable/audioRate", 
        "audioMainTable/audioDialogNormalization", 
        "audioMainTable/audioGroupId"};
    private final String fileLocation;
    private Path encFilePath;
    private Scanner scan;
    
    private final Map results = new HashMap<>();
    private final Map audioResults = new HashMap<>();
    
    /**
     * Class constructor that sets the main file folder location
     * @param location The main file folder location
     */
    public A7_Encoder(String location){
        fileLocation = location;
    }
    
    /**
     * Method to initialize the Encoder expanded display.
     * @param expEncUI The expanded Encoder UI
     * @param encList The List of Encoder Devices
     * @param encNumber The Specific Encoder Device Number
     */
    public void displayExpandedENC(A8_ExpandedEncUI expEncUI, 
            LinkedList encList, int encNumber){
        /* Loop through the Encoder list to get the specific Encoder data */
        for(int i = 0; i < encList.size(); i++){
            /* Creates a new Encoder Object from the Encoder Object at i */
            A7_Encoder eData = (A7_Encoder) encList.get(i);
            /* Checks if Encoder in list matches specified Encoder device */
            if( eData.getEncNumber() == encNumber) {
                /* Sets all the device labels for the expanded UI */
                expEncUI.setDeviceLabel(eData.getName() + " (" + 
                        eData.results.get("Role") + ")");
                expEncUI.setAddressLabel(eData.getAddress());
                expEncUI.setSiteLabel((String) eData.results.get("Site"));
                expEncUI.setElementGroupLabel((String) eData.results.get(
                        "ElementGroup"));
                expEncUI.setRedundancyGroupLabel((String) eData.results.get(
                        "RedundancyGroup"));
                expEncUI.setEncoderGroupLabel((String) eData.results.get(
                        "EncoderGroup"));
                expEncUI.setEncoderData(eData);
                expEncUI.audioDisplay();
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
        /* Declare Local Variables */
        String value;
        String[] splitString;
        
        /* Concats the encoder file location to the main folders location*/
        encFileLocation = fileLocation.concat("config\\" + positionID);
        /* Initializes a file path for the encoder file */
        encFilePath = Paths.get(encFileLocation);
        /* Initializes a scanner for the file */
        scan = new Scanner(encFilePath);
        /* Loop through each line of the encoder file */
        while(scan.hasNextLine()){
            /* Sets string to the full line */
            line = scan.nextLine();
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
                    else value = "No Data";
                    /* Checks for Encoder Audio Data */
                    if(sub.contains("audioMainTable")){
                        /* Function call to set the Audio channel to key */
                        sub = setChannels(sub, splitString[0]);
                        audioResults.put(sub, value);
                    }
                    
                    
                    
                    
                    /* Checks if data already exists in Map */
                    if(results.containsKey(sub) && 
                            results.get(sub).equals("No Data") || 
                            !results.containsKey(sub)){
                        /* Adds data to the Map */
                        results.put(sub, value);
                    } 
                }
            }
        }
    }
    
    /**
     * Method to get the Audio Channel from the parsed line.
     * @param key The current Hash Map Key
     * @param currLine The current line being parsed
     * @return The new Hash Map key
     */
    private String setChannels(String key, String currLine){
        /* Splits the current line being parsed */
        String[] split = currLine.split("/| ");
        /* Sets the new key to include the Audio Channel */
        key = key + "/" + split[3] + "/" + split[4];
        /* Returns the new key */
        return key;
    }
    
    /**
     * Encoder Data Map Getter.
     * @return Encoder Hash Map
     */
    public Map getDataMap(){
        return results;
    }
    /**
     * Encoder Audio Data Map Getter.
     * @return Encoder Audio Hash Map
     */
    public Map getAudioMap(){
        return audioResults;
    }
    
    /**
     * Encoder Priority Number Setter
     * @param pNumber The Encoder priority number(1-primary, 2-backup)
     */
    @Override
    public void setPriorityNumber(int pNumber){
        priorityNumber = pNumber;
    }
    /**
     * Encoder Priority Number Getter
     * @return The Encoder Priority Number(1-primary, 2-backup)
     */
    @Override
    public int getPriorityNumber(){
        return priorityNumber;
    }
    
    /**
     * Setter for the type of device.
     * @param dev The type of device(Encoder)
     */
    @Override
    public void setDevice(String dev){
        device = dev;
    }
    /**
     * Getter for the type of device.
     * @return The device type(Encoder)
     */
    @Override
    public String getDevice(){
        return device;
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
    public String getVersion() {
        return version;
    }

    /**
     * Encoder Version Setter.
     * @param version The Encoder Version Number
     */
    public void setVersion(String version) {
        this.version = version;
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
