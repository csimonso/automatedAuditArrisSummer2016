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
import java.util.Scanner;

/**
 * This class is used to gather the SEM information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class SEM implements EquipmentIdentifiers {
    
    private String name;
    private String address;
    private String version;
    private String role;
    private String type;
    private String positionID;
    private String operatingMode;
    private String bootMethod;
    private String autoBoot;
    private String multiController;
    private String fileLocation;
    private String controllerPort;
    private String semPort;
    private String commandTimeout;
    private String detectPsiLoss;
    private String psiLossTimeout;
    private String encryptionAlgorithm;
    private String copyProtectionSource;
    private String pidRemapping;
    private String messageInsertMode;
    private String timeSource;
    private String gpsUtcOffset;
    private String asiMonitorTransportIndex;
    private String highSpeedMode;
    private String redundancyGroup;
    private String elementGroup;
    private String site;
    private String inputFailureAlarm;
    private ArrayList clockRate;
    private String line;
    private int clockRateNumber;
    private Path filePath;
    private Scanner scan;
    private Scanner data;
    
    
    public void parseSEMData(String inputLocation) throws IOException{
        
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
            line = scan.nextLine();
            if(line.contains("Role")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                role = data.next();
            }
            if(line.contains("ClockRate")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                clockRateNumber++;
                clockRate.add(clockRateNumber + ": " + data.next());
            }
            else if(line.contains("ElementGroup")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                elementGroup = data.next();
            }
            else if(line.contains("Site")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                site = data.next();
            }
            else if(line.contains("RedundancyGroup")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                redundancyGroup = data.next();
            }
            else if(line.contains("HostAppVersion")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.version = data.next();
            }
            else if(line.contains("InputFailureAlarm")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                inputFailureAlarm = data.next();
            }
            else if(line.contains("OperatingMode")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.operatingMode = data.next();
            }
            else if(line.contains("BootMethod")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.bootMethod = data.next();
            }
            else if(line.contains("AutoBoot")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.autoBoot = data.next();
            }
            else if(line.contains("MultiController")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.multiController = data.next();
            }
            else if(line.contains("ControllerPort")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.controllerPort = data.next();
            }
            else if(line.contains("SemPort")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.semPort = data.next();
            }
            else if(line.contains("CommandTimeOut")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.commandTimeout = data.next();
            }
            else if(line.contains("DetectPsiLoss")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.detectPsiLoss = data.next();
            }
            else if(line.contains("PsiLossTimeout")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.psiLossTimeout = data.next();
            }
            else if(line.contains("EncryptionAlgorithm")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.encryptionAlgorithm = data.next();
            }
            else if(line.contains("CopyProtectionSource")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.copyProtectionSource = data.next();
            }
            else if(line.contains("PidRemapping")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.pidRemapping = data.next();
            }
            else if(line.contains("MessageInsertMode")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.messageInsertMode = data.next();
            }
            else if(line.contains("TimeSource")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.timeSource = data.next();
            }
            else if(line.contains("GpsUtcOffset")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.gpsUtcOffset = data.next();
            }
            else if(line.contains("AsiMonitorTransportIndex")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.asiMonitorTransportIndex = data.next();
            }
            else if(line.contains("HighSpeedMode")){
                data = new Scanner(line).useDelimiter("=");
                data.next();
                this.highSpeedMode = data.next();
            }
            
        }
    }
    
    public ArrayList getClockRate(){
        return clockRate;
    }
    
    public String getOperatingMode(){
        return operatingMode;
    }
    public String getRedundancyGroup(){
        return redundancyGroup;
    }
    public String getSite(){
        return site;
    }
    public String getElementGroup(){
        return elementGroup;
    }
    
    public String getInputFailureAlarm(){
        return inputFailureAlarm;
    }
    
    public String getBootMethod(){
        return bootMethod;
    }
    public String getAutoBoot(){
        return autoBoot;
    }
    public String getMultiController(){
        return multiController;
    }
    public String getControllerPort(){
        return controllerPort;
    }
    public String getSemPort(){
        return semPort;
    }
    public String getCommandTimeout(){
        return commandTimeout;
    }
    public String getDetectPsiLoss(){
        return detectPsiLoss;
    }
    public String getPsiLossTimeout(){
        return psiLossTimeout;
    }
    public String getEncryptionAlgorithm(){
        return encryptionAlgorithm;
    }
    public String getCopyProtectionSource(){
        return copyProtectionSource;
    }
    public String getPidRemapping(){
        return pidRemapping;
    }
    public String getMessageInsertMode(){
        return messageInsertMode;
    }
    public String getTimeSource(){
        return timeSource;
    }
    public String getGpsUtcOffset(){
        return gpsUtcOffset;
    }
    public String getAsiMonitorTransportIndex(){
        return asiMonitorTransportIndex;
    }
    public String getHighSpeedMode(){
        return highSpeedMode;
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
