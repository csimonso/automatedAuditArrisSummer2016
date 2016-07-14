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
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class is used to gather the SEM information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A7_SEM implements A0_EquipmentIdentifiers {
    
    private ArrayList clockRate;
    private Path filePath;
    private Scanner scan, data;
    private int semNumber, clockRateNumber, priorityNumber;
    private String name, address, version, role,type, site, fileLocation, line,
            positionID, operatingMode, bootMethod, autoBoot, device,
            multiController, controllerPort, semPort, commandTimeout,
            detectPsiLoss, psiLossTimeout, encryptionAlgorithm,
            copyProtectionSource, pidRemapping, messageInsertMode,timeSource, 
            gpsUtcOffset, asiMonitorTransportIndex, highSpeedMode, 
            redundancyGroup, elementGroup, inputFailureAlarm, emmName, 
            emmOutputPid, emmCaSysId, emmProviderId, emmConsumerStream;
    
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
                expSemUI.setDeviceLabel(sData.getName(), sData.getRole());
                expSemUI.setAddressLabel(sData.getAddress());
                expSemUI.setAsiTransportIndexLabel(
                        sData.getAsiMonitorTransportIndex());
                expSemUI.setAutoBootLabel(sData.getAutoBoot());
                expSemUI.setBootMethodLabel(sData.getBootMethod());
                expSemUI.setCommandTimeoutLabel(sData.getCommandTimeout());
                expSemUI.setControllerPortLabel(sData.getControllerPort());
                expSemUI.setCopyProtectionSourceLabel(
                        sData.getCopyProtectionSource());
                expSemUI.setDetectPsiLossLabel(sData.getDetectPsiLoss());
                expSemUI.setElementGroupLabel(sData.getElementGroup());
                expSemUI.setEncryptionAlgorithmLabel(
                        sData.getEncryptionAlgorithm());
                expSemUI.setGpsOffsetLabel(sData.getGpsUtcOffset());
                expSemUI.setHighSpeedLabel(sData.getHighSpeedMode());
                expSemUI.setInputFailureAlarmLabel(
                        sData.getInputFailureAlarm());
                expSemUI.setMessageInsertModeLabel(
                        sData.getMessageInsertMode());
                expSemUI.setMultiControllerLabel(sData.getMultiController());
                expSemUI.setOpModeLabel(sData.getOperatingMode());
                expSemUI.setPidRemappingLabel(sData.getPidRemapping());
                expSemUI.setRedundancyGroupLabel(sData.getRedundancyGroup());
                expSemUI.setPsiLossTimeoutLabel(sData.getPsiLossTimeout());
                expSemUI.setSiteLabel(sData.getSite());
                expSemUI.setSemPortLabel(sData.getSemPort());
                expSemUI.setTimeSourceLabel(sData.getTimeSource());
                expSemUI.setVersionLabel(sData.getVersion());
                expSemUI.setClockRateDropDown(sData.getClockRate());
                expSemUI.emmDisplay(sData.getEmmName(), 
                        sData.getEmmOutputPid(), sData.getEmmCaSystemId(), 
                        sData.getEmmProviderId(), sData.getEmmConsumerStream());
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
        /* Initializes the arrayList */
        clockRate = new ArrayList();
        /* Initializes the clock rate counter */
        clockRateNumber = 0;
        
        /* Loop through each line of the SEM file */
        while(scan.hasNextLine()){
            /* Sets string to the full line */
            line = scan.nextLine();
            
            /* If statements checking if a line matches the data we need */
            if(line.contains("Role")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                role = data.next();//sets role
            }
            else if(line.contains("EMMStream.Name")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.emmName = data.next();//sets EMM Name
            }
            else if(line.contains("EMMStream.OutputPID")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                emmOutputPid = data.next();//sets EMM Output ID
            }
            else if(line.contains("EMMStream.CaSystemID")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                emmCaSysId = data.next();//sets EMM CA System ID
            }
            else if(line.contains("EMMStream.EmmProviderID")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                emmProviderId = data.next();//sets EMM Provider ID
            }
            else if(line.contains("EMMStream.IsConsumerStream")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                emmConsumerStream = data.next();//sets EMM Consumer Stream
            }
            else if(line.contains("ClockRate")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                clockRateNumber++;//increments clock rate number
                /* Adds to clock rate list */
                clockRate.add(clockRateNumber + ": " + data.next());
            }
            else if(line.contains("ElementGroup")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.elementGroup = data.next();//sets element group
            }
            else if(line.contains("Site")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.site = data.next();//sets site
            }
            else if(line.contains("RedundancyGroup")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.redundancyGroup = data.next();//sets redundancy group
            }
            else if(line.contains("HostAppVersion")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.version = data.next();//sets host app version
            }
            else if(line.contains("InputFailureAlarm")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.inputFailureAlarm = data.next();//sets failure alarm
            }
            else if(line.contains("OperatingMode")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.operatingMode = data.next();//sets operating mode
            }
            else if(line.contains("BootMethod")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.bootMethod = data.next();//sets boot method
            }
            else if(line.contains("AutoBoot")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.autoBoot = data.next();//sets autoboot
            }
            else if(line.contains("MultiController")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.multiController = data.next();//sets multi controller
            }
            else if(line.contains("ControllerPort")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.controllerPort = data.next();//sets controller port
            }
            else if(line.contains("SemPort")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.semPort = data.next();//sets sem port
            }
            else if(line.contains("CommandTimeOut")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.commandTimeout = data.next();//sets command timeout
            }
            else if(line.contains("DetectPsiLoss")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.detectPsiLoss = data.next();
            }
            else if(line.contains("PsiLossTimeout")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.psiLossTimeout = data.next();//sets psi loss timeout
            }
            else if(line.contains("EncryptionAlgorithm")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.encryptionAlgorithm = data.next();//sets encry algorithm
            }
            else if(line.contains("CopyProtectionSource")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.copyProtectionSource = data.next();//sets copy protect src
            }
            else if(line.contains("PidRemapping")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.pidRemapping = data.next();//sets pid remapping
            }
            else if(line.contains("MessageInsertMode")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.messageInsertMode = data.next();//sets message insert mode
            }
            else if(line.contains("TimeSource")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.timeSource = data.next();//sets time source
            }
            else if(line.contains("GpsUtcOffset")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.gpsUtcOffset = data.next();//sets gps utc offset
            }
            else if(line.contains("AsiMonitorTransportIndex")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.asiMonitorTransportIndex = data.next();//sets transport ind
            }
            else if(line.contains("HighSpeedMode")){
                /* Initializes scanner to next "=" */
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.highSpeedMode = data.next();//sets high speed mode
            }
        }
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
     * SEM Clock Rate List Getter.
     * @return The SEM Clock Rate List
     */
    public ArrayList getClockRate(){
        return clockRate;
    }
    
    /**
     * EMM Name Getter.
     * @return The EMM Name
     */
    public String getEmmName(){
        return emmName;
    }
    
    /**
     * EMM Output PID Getter.
     * @return The EMM Output PID
     */
    public String getEmmOutputPid(){
        return emmOutputPid;
    }
    
    /**
     * EMM CA System ID Getter.
     * @return The EMM CA System ID
     */
    public String getEmmCaSystemId(){
        return emmCaSysId;
    }
    
    /**
     * EMM Provider ID Getter.
     * @return The EMM Provider ID
     */
    public String getEmmProviderId(){
        return emmProviderId;
    }
    
    /**
     * EMM Consumer Stream Getter.
     * @return The EMM Consumer Stream Boolean
     */
    public String getEmmConsumerStream(){
        return emmConsumerStream;
    }
    
    /**
     * SEM Operating Mode Getter.
     * @return The SEM Operating Mode
     */
    public String getOperatingMode(){
        return operatingMode;
    }
    
    /**
     * SEM Redundancy Group Getter.
     * @return The SEM Redundancy Group
     */
    public String getRedundancyGroup(){
        return redundancyGroup;
    }
    
    /**
     * SEM Site Getter.
     * @return The SEM Site
     */
    public String getSite(){
        return site;
    }
    
    /**
     * SEM Element Group Getter.
     * @return The SEM Element Group
     */
    public String getElementGroup(){
        return elementGroup;
    }
    
    /**
     * SEM Input Failure Alarm Getter.
     * @return The SEM Input Failure Alarm
     */
    public String getInputFailureAlarm(){
        return inputFailureAlarm;
    }
    
    /**
     * SEM Boot Method Getter.
     * @return The SEM Boot Method
     */
    public String getBootMethod(){
        return bootMethod;
    }
    
    /**
     * SEM AutoBoot Getter.
     * @return The SEM AutoBoot
     */
    public String getAutoBoot(){
        return autoBoot;
    }
    
    /**
     * SEM Multi-Controller Getter.
     * @return The SEM Multi-Controller
     */
    public String getMultiController(){
        return multiController;
    }
    
    /**
     * SEM Controller Port Getter.
     * @return The SEM Controller Port
     */
    public String getControllerPort(){
        return controllerPort;
    }
    
    /**
     * SEM Port Getter.
     * @return The SEM Port
     */
    public String getSemPort(){
        return semPort;
    }
    
    /**
     * SEM Command Timeout Getter.
     * @return The SEM Command Timeout
     */
    public String getCommandTimeout(){
        return commandTimeout;
    }
    
    /**
     * SEM Detect PSI Loss Getter.
     * @return The SEM Detect PSI Loss
     */
    public String getDetectPsiLoss(){
        return detectPsiLoss;
    }
    
    /**
     * SEM PSI Loss Timeout Getter.
     * @return The SEM PSI Loss Timeout
     */
    public String getPsiLossTimeout(){
        return psiLossTimeout;
    }
    
    /**
     * SEM Encryption Algorithm Getter.
     * @return The SEM Encryption Algorithm
     */
    public String getEncryptionAlgorithm(){
        return encryptionAlgorithm;
    }
    
    /**
     * SEM Copy Protection Source Getter.
     * @return The SEM Copy Protection Source
     */
    public String getCopyProtectionSource(){
        return copyProtectionSource;
    }
    
    /**
     * SEM PID Re-mapping Getter.
     * @return The SEM PID Re-mapping
     */
    public String getPidRemapping(){
        return pidRemapping;
    }
    
    /**
     * SEM Message Insert Mode Getter.
     * @return The SEM Message Insert Mode
     */
    public String getMessageInsertMode(){
        return messageInsertMode;
    }
    
    /**
     * SEM Time Source Getter.
     * @return The SEM Time Source
     */
    public String getTimeSource(){
        return timeSource;
    }
    
    /**
     * SEM GPS UTC Offset Getter.
     * @return The SEM GPS UTC Offset
     */
    public String getGpsUtcOffset(){
        return gpsUtcOffset;
    }
    
    /**
     * SEM ASI Monitor Transport Index Getter.
     * @return The SEM ASI Monitor Transport Index
     */
    public String getAsiMonitorTransportIndex(){
        return asiMonitorTransportIndex;
    }
    
    /**
     * SEM High Speed Mode Getter.
     * @return The SEM High Speed Mode
     */
    public String getHighSpeedMode(){
        return highSpeedMode;
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
     * SEM Version Getter.
     * @return The SEM Version Number
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * SEM Version Setter.
     * @param version The SEM Version Number
     */
    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * SEM Role Getter.
     * @return The SEM Role
     */
    @Override
    public String getRole() {
       return role;
    }

    /**
     * SEM Role Setter.
     * @param role The SEM Role
     */
    @Override
    public void setRole(String role) {
        this.role = role;
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
}
