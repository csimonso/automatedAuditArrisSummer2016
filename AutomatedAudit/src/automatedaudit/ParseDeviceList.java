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
    private String line;
    private String type;
    private String positionID;
    private String address;
    private String name;
    private LinkedList deviceList;
    
    /**
     * Class constructor that creates a file path
     */
    public ParseDeviceList(){
        fileLocation = "C:\\Users\\csimonson\\Documents\\NetBeansProjects\\"
                + "automatedAuditArrisSummer2016\\AutomatedAudit\\bnccfg_tmp\\"
                + "config\\~positions";
        filePath = Paths.get(fileLocation);
        deviceList = new LinkedList();
    }
    
    /**
     * Method to scan through the input file.
     * @throws IOException on error 
     */
    public void scanList() throws IOException{
        /* Creates new Scanner object of the filePath */
        scan = new Scanner(filePath);
        
       
        tmxCount = 0;
        
        /* Skips first two lines of "~positions" file which are headers */
        scan.nextLine();
        scan.nextLine();
        
        /* Loop through "~positions" file parsing each line */
        while(scan.hasNextLine()) {
            /* Function call to parse data from current line */
            this.parseLine();
            /* Switch statements to set all device information */
            switch (type) {
                case "TMX"://device is a TMX
                    TMX tmxData = new TMX();//creates new TMX object
                    tmxData.setType(type);//sets type to TMX
                    tmxData.setPositionID(positionID);//sets TMX positionID
                    tmxData.setName(name);//sets TMX name
                    tmxData.setAddress(address);//sets TMX IP address
                    deviceList.add(tmxData);//adds device to LinkedList
                    tmxCount++;//increments total TMX device count
                case "default":
                    break;
            }
            scan.nextLine();//moves to next line in file
        }
        /* USED FOR TESTING */
        this.printData();
    }
    
    /**
     * Method to parse each specific line of the input file.
     */
    private void parseLine(){
        
        
        /* Creates new Scanner object to parse the device position ID */
        pID = new Scanner(scan.next()).useDelimiter("=");
        /* Stores the line as a string */
        line = pID.next();
        /* Skips over the ~sys-config line in positions file */
        if(line.startsWith("~")) {
            type = "default";
            return;
        }
        /* Set position ID */
        positionID = line;
        /* Creates new Scanner object to parse the device data */
        data = new Scanner(pID.next()).useDelimiter("[|]");
        
        /* Parse and set all the data */
        type = data.next();
        address = data.next();
        name = data.next();
        
        
        
        System.out.println(type);
        System.out.println(address);
        System.out.println(name);
        System.out.println();
    }
    
    public void printData(){
        System.out.println("Total TMX Devices: " + tmxCount);
        System.out.println();
        
        TMX data = new TMX();
        
        for(int i = 0; i<deviceList.size(); i++){
            data = (TMX) deviceList.get(i);
             System.out.println("Device Type: " + data.getType());
            System.out.println("Device Name: " + data.getName());
            System.out.println("Device IP Address: " + data.getAddress());
            System.out.println("Device Position ID: " + data.getPositionID());
            System.out.println();
        }
        
           
            

    }
}