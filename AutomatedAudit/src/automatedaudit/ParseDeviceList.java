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
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Class to parse through the "~positions" file to gather all the relevant 
 * device information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class ParseDeviceList {
    
    private final String fileLocation;
    private final Path filePath;
    private Scanner scan;
    private Scanner pID;
    private Scanner data;
    private int tmxCount;
    private int semCount;
    private int encoderCount;
    private String line;
    private String device;
    private String type;
    private String positionID;
    private String address;
    private String name;
    private LinkedList tmxList;
    private LinkedList semList;
    private LinkedList encoderList;
    
    /**
     * Class constructor that creates a file path
     */
    public ParseDeviceList(){
        fileLocation = "C:\\Users\\csimonson\\Documents\\NetBeansProjects\\"
                + "automatedAuditArrisSummer2016\\AutomatedAudit\\bnccfg_tmp\\"
                + "config\\~positions";
        filePath = Paths.get(fileLocation);
        tmxList = new LinkedList();
        semList = new LinkedList();
        encoderList = new LinkedList();
    }
    
    /**
     * Method to scan through the input file.
     * @throws IOException on error 
     */
    public void scanList() throws IOException{
        /* Creates new Scanner object of the filePath */
        scan = new Scanner(filePath);
        
        tmxCount = 0;//initializes the TMX device count
        semCount = 0;//initializes the SEM device count
        encoderCount = 0;//initializes the encoder device count
        
        /* Skips first two lines of "~positions" file which are headers */
        scan.nextLine();
        scan.nextLine();
        
        /* Loop through "~positions" file parsing each line */
        while(scan.hasNextLine()) {
            /* Function call to parse data from current line */
            this.parseLine();
            /* Switch statements to set all device information */
            switch (device) {
                case "TMX"://device is a TMX
                    TMX tmxData = new TMX();//creates new TMX object
                    tmxData.setType(type);//sets type to TMX
                    tmxData.setPositionID(positionID);//sets TMX positionID
                    tmxData.setName(name);//sets TMX name
                    tmxData.setAddress(address);//sets TMX IP address
                    tmxList.add(tmxData);//adds device to LinkedList
                    tmxCount++;//increments total TMX device count
                    break;
                case "SEM"://device is a SEM
                    SEM semData = new SEM();//creates new SEM object
                    semData.setType(type);//sets type to SEM
                    semData.setPositionID(positionID);//sets SEM positionID
                    semData.setName(name);//sets SEM name
                    semData.setAddress(address);//sets SEM IP address
                    semList.add(semData);//adds device to LinkedList
                    semCount++;//increments total SEM device count
                    break;
                case "Encoder"://device is a encoder
                    Encoder encoderData = new Encoder();//creates new encoder object
                    encoderData.setType(type);//sets type to encoder
                    encoderData.setPositionID(positionID);//sets encoder positionID
                    encoderData.setName(name);//sets encoder name
                    encoderData.setAddress(address);//sets encoder IP address
                    encoderList.add(encoderData);//adds device to LinkedList
                    encoderCount++;//increments total encoder device count
                    break;
                case "non-device":
                    break;
            }
        }
        /* USED FOR TESTING */
        this.printData();
    }
    
    /**
     * Method to parse each specific line of the input file.
     */
    private void parseLine(){
        /* Creates a new Scanner object to get the position ID */
        pID = new Scanner(scan.next()).useDelimiter("=");
        /* Sets the Position ID */
        positionID = pID.next();
        /* Skips over the "~sys-config" line in positions file */
        if(positionID.startsWith("~")) {
            device = "non-device";
            return;
        }
        /* Creates a new Scanner object to parse the rest of the line */
        data = new Scanner(pID.next()).useDelimiter("[|]");
        /* Sets the device type */
        type = data.next();
        /* Sets device for switch statements */
        if(type.matches("SEM")) {
            device = "SEM";
        }
        else if(type.contains("SE")) {
            device = "Encoder";
        }
        else {
            device = type;
        }
        /* Sets the device Ip address */
        address = data.next();
        /* Sets the device name */
        name = data.next();
        /* Reads rest of the current line and saves it as a string */
        line = scan.nextLine();
        /* Checks if a blank space was reached when reading the device name */
        if(line.startsWith(" ")){
            name = name.concat(line);//appends letters/words after space to name
            /* Splits rest of line and sets device name to include any spaces */
            for(String deviceName: name.split("[|]")){
                name = deviceName;
                break;//breaks right away since we only need full device name
            }
        }
        /*---------USED FOR TESTING---------
        System.out.println("Device Type: " + type);
        System.out.println("Device Position ID: " + positionID);
        System.out.println("Device Ip: " + address);
        System.out.println("Device Name: " + name);
        System.out.println();
        ------------------------------------*/
    }
    
    public void printData(){
        
        TMX tdata = new TMX();
        SEM sdata = new SEM();
        Encoder edata = new Encoder();
        
        for(int i = 0; i < tmxList.size(); i++){
            tdata = (TMX) tmxList.get(i);
            System.out.println("Device Type: " + tdata.getType());
            System.out.println("Device Name: " + tdata.getName());
            System.out.println("Device IP Address: " + tdata.getAddress());
            System.out.println("Device Position ID: " + tdata.getPositionID());
            System.out.println();
        }
        System.out.println("Total TMX Devices: " + tmxCount);
        System.out.println();
        
        for(int i = 0; i < semList.size(); i++){
            sdata = (SEM) semList.get(i);
            System.out.println("Device Type: " + sdata.getType());
            System.out.println("Device Name: " + sdata.getName());
            System.out.println("Device IP Address: " + sdata.getAddress());
            System.out.println("Device Position ID: " + sdata.getPositionID());
            System.out.println();
        }
        System.out.println("Total SEM Devices: " + semCount);
        System.out.println();
            
        for(int i = 0; i < encoderList.size(); i++){
            edata = (Encoder) encoderList.get(i);
            System.out.println("Device Type: " + edata.getType());
            System.out.println("Device Name: " + edata.getName());
            System.out.println("Device IP Address: " + edata.getAddress());
            System.out.println("Device Position ID: " + edata.getPositionID());
            System.out.println();
        }
        System.out.println("Total Encoder Devices: " + encoderCount);
        System.out.println();
    }
}