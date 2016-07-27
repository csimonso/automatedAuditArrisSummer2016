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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is used to gather the SEM information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A7_SEM implements A0_EquipmentIdentifiers {
    
    private ArrayList clockRate, semDataList;
    private Path filePath;
    private Scanner scan, data;
    private int semNumber, clockRateNumber, priorityNumber;
    private String name, address, type, fileLocation, line, positionID, device;
    private final String[] strings = new String[]{"Role", "ElementGroup", "Site", 
        "RedundancyGroup", "HostAppVersion", "InputFailureAlarm", 
        "OperatingMode", "BootMethod", "AutoBoot", "MultiController",
        "ControllerPort", "SemPort", "CommandTimeOut", "DetectPsiLoss", 
        "PsiLossTimeout", "EncryptionAlgorithm", "CopyProtectionSource", 
        "PidRemapping", "MessageInsertMode", "TimeSource", "GpsUtcOffset", 
        "AsiMonitorTransportIndex", "HighSpeedMode", "ClockRate", 
        "EMMStream.Name", "EMMStream.OutputPID", "EMMStream.CaSystemID", 
        "EMMStream.EmmProviderID", "EMMStream.IsConsumerStream"};
    private final Map results = new HashMap<>();
    private Map emmResults = new HashMap<>();
    
    /**
     * Class constructor that sets the main file folder location
     * @param location The main file folder location
     */
    public A7_SEM(String location){
        fileLocation = location;
    }
    
    /**
     * Method to initialize the SEM expanded display.
     * @param expSemUI The expanded SEM UI
     * @param semList The List of SEM Devices
     * @param semNumber The Specific SEM Device Number
     */
    public void displayExpandedSEM(A8_ExpandedSemUI expSemUI, 
            LinkedList semList, int semNumber){
        /* Loop through the SEM list to get the specific SEM data */
        for(int i = 0; i < semList.size(); i++){
            /* Creates a new SEM Object from the SEM Object at i */
            A7_SEM sData = (A7_SEM) semList.get(i);
            /* Checks if SEM in list matches specified SEM device */
            if(sData.getSemNumber() == semNumber){
                /* Sets all the device labels for the expanded UI */
                expSemUI.setDeviceLabel(sData.getName() + " (" + 
                        sData.results.get("Role") + ")");
                expSemUI.setAddressLabel(sData.getAddress());
                expSemUI.setAsiTransportIndexLabel(
                        (String) sData.results.get("AsiMonitorTransportIndex"));
                expSemUI.setAutoBootLabel((String) sData.results.get(
                        "AutoBoot"));
                expSemUI.setBootMethodLabel((String) sData.results.get(
                        "BootMethod"));
                expSemUI.setCommandTimeoutLabel((String) sData.results.get(
                        "CommandTimeOut"));
                expSemUI.setControllerPortLabel((String) sData.results.get(
                        "ControllerPort"));
                expSemUI.setCopyProtectionSourceLabel(
                        (String) sData.results.get("CopyProtectionSource"));
                expSemUI.setDetectPsiLossLabel((String) sData.results.get(
                        "DetectPsiLoss"));
                expSemUI.setElementGroupLabel((String) sData.results.get(
                        "ElementGroup"));
                expSemUI.setEncryptionAlgorithmLabel(
                        (String) sData.results.get("EncryptionAlgorithm"));
                expSemUI.setGpsOffsetLabel((String) sData.results.get(
                        "GpsUtcOffset"));
                expSemUI.setHighSpeedLabel((String) sData.results.get(
                        "HighSpeedMode"));
                expSemUI.setInputFailureAlarmLabel(
                        (String) sData.results.get("InputFailureAlarm"));
                expSemUI.setMessageInsertModeLabel(
                        (String) sData.results.get("MessageInsertMode"));
                expSemUI.setMultiControllerLabel((String) sData.results.get(
                        "MultiController"));
                expSemUI.setOpModeLabel((String) sData.results.get(
                        "OperatingMode"));
                expSemUI.setPidRemappingLabel((String) sData.results.get(
                        "PidRemapping"));
                expSemUI.setRedundancyGroupLabel((String) sData.results.get(
                        "RedundancyGroup"));
                expSemUI.setPsiLossTimeoutLabel((String) sData.results.get(
                        "PsiLossTimeout"));
                expSemUI.setSiteLabel((String) sData.results.get("Site"));
                expSemUI.setSemPortLabel((String) sData.results.get("SemPort"));
                expSemUI.setTimeSourceLabel((String) sData.results.get(
                        "TimeSource"));
                expSemUI.setVersionLabel((String) sData.results.get(
                        "HostAppVersion"));
                /* Sets the values in the drop down menu for the ClockRates */
                expSemUI.setClockRateDropDown(sData.getClockRate());
                /* Function call to create the EMM dialog box */
                expSemUI.emmDisplay(sData);
                /* Sets the List of SEM devices */
                expSemUI.setSemList(semList);
                /* Sets the specific SEM's data */
                expSemUI.setSemData(sData);
                expSemUI.pack();
            }
        }
        /* Makes display visible */
        expSemUI.setVisible(true);
    }
    
    /**
     * Method to parse through the specified SEM device
     * @param inputLocation The file location
     * @throws IOException If error occurs
     */
    public void parseSemFile(String inputLocation) throws IOException{
        /* Concats the SEM file location to the main folders location*/
        fileLocation = inputLocation.concat("config\\" + positionID);
        /* Initializes a file path for the SEM file */
        filePath = Paths.get(fileLocation);
        /* Initializes a scanner for the file */
        scan = new Scanner(filePath);
        /* Initializes the arrayLists */
        clockRate = new ArrayList();
        semDataList = new ArrayList();
        /* Initializes the clock rate counter */
        clockRateNumber = 0;
        String value;//creates a string to hold all the values
        /* Loops through each line of the device file */
        while(scan.hasNextLine()){
            line = scan.nextLine();//gets the next line of the file
            /* Loops through the array of Strings to see if there is a match */
            for(String sub:strings){
                /* Checks if a match is found */
                if(line.contains(sub)){
                    /* Initializes scanner object and sets its delimiter */
                    data = new Scanner(line).useDelimiter("=");
                    data.next();//moves scanner to the equals sign
                    /* Sets string equal to the value after the equals sign */
                    value = data.next();
                    /* If value is a ClockRate, adds it to the ClockRate List */
                    if(line.contains("ClockRate")){
                        clockRateNumber++;
                        clockRate.add(clockRateNumber + ": " + value);
                    }
                    /* If value is EMM data, adds value to EMM Map */
                    else if(line.contains("EMMStream")){
                        emmResults.put(sub, value);
                    }
                    /* Adds required values to the results Map */
                    else results.put(sub, value);
                }  
            }
        }

            
   /***********IN PROGRESS FOR OUTPUT DATA **********************************         
            /* Output Configuration Data *
            else if(line.contains("Transport") && line.contains("Name")){
                /* Initializes scanner to next "=" *
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.transportName = data.next();//sets transport name
            }
            else if(line.contains("Transport") &&
                    line.contains("PATInsertionRate")){
                /* Initializes scanner to next "=" *
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.transportPatInsertRate = data.next();//sets transport name
            }
    /************************************************************************/            
    }
    
    /**
     * SEM Data Map Getter.
     * @return The specified device's data Map
     */
    public Map getDataMap(){
        return results;
    }
    /**
     * SEM EMM Map Getter.
     * @return The SEM's EMM Data
     */
    public Map getEmmMap(){
        return emmResults;
    }
    /**
     * SEM EMM Map Setter.
     * @param eMap The Map for the SEM data
     */
    public void setEmmMap(Map eMap){
        emmResults = eMap;
    }
    /**
     * SEM Clock Rate List Getter.
     * @return The SEM Clock Rate List
     */
    public ArrayList getClockRate(){
        return clockRate;
    }
    /**
     * List of specific SEM data to be used for SEM comparisons
     * @return List of SEM data
     */
    public ArrayList getSemDataList(){
        return semDataList;
    }
    /**
     * SEM Number Setter.
     * @param number The SEM Device Number
     */
    public void setSemNumber(int number){
        this.semNumber = number;
    }
    /**
     * SEM Device Number Getter.
     * @return The SEM Device Number
     */
    public int getSemNumber(){
        return semNumber;
    }
    /**
     * Setter for the type of device.
     * @param dev The type of device(SEM)
     */
    @Override
    public void setDevice(String dev){
        device = dev;
    }
    /**
     * Getter for the type of device.
     * @return The device type(SEM)
     */
    @Override
    public String getDevice(){
        return device;
    }
    /**
     * SEM Type Getter.
     * @return The SEM Type
     */
    @Override
    public String getType() {
        return type;
    }
    /**
     * SEM Type Setter.
     * @param type The SEM Type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }
    /**
     * SEM Position ID Getter.
     * @return The SEM Position ID
     */
    @Override
    public String getPositionID() {
        return positionID;
    }
    /**
     * SEM Position ID Setter.
     * @param positionID The SEM Position ID
     */
    @Override
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
    /**
     * SEM Name Getter.
     * @return The SEM Name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * SEM Name Setter.
     * @param name The SEM Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * SEM IP Address Getter.
     * @return The SEM IP Address
     */
    @Override
    public String getAddress() {
       return address;
    }
    /**
     * SEM IP Address Setter.
     * @param address The SEM IP Address
     */
    @Override
    public void setAddress(String address) {
       this.address = address;
    }
    /**
     * SEM Priority Number Setter
     * @param pNumber The SEM priority number(1-primary, 2-backup)
     */
    @Override
    public void setPriorityNumber(int pNumber){
        priorityNumber = pNumber;
    }
    /**
     * SEM Priority Number Getter
     * @return The SEM Priority Number(1-primary, 2-backup)
     */
    @Override
    public int getPriorityNumber(){
        return priorityNumber;
    }
}
