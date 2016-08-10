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
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Class to parse through the "~positions" file to gather all the relevant 
 * device information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A5_ParseDeviceList {
    
    private final String positionsFileLocation, mainFolderLocation;
    private final Path filePath;
    private Scanner scan, pID, data;
    private String line, device, type, positionID, address, name;
    private int semNumber, tmxNumber, encNumber;
    private final LinkedList<A7_SEM> semList;
    private final LinkedList<A7_TMX> tmxList;
    private final LinkedList<A7_Encoder> encoderList;
    private ArrayList statGroupList;
    
    /**
     * Class constructor that creates a file path for the ~positions file.
     * @param inputLocation The files location
     */
    public A5_ParseDeviceList(String inputLocation){
        /* Sets the main folder location variable */
        mainFolderLocation = inputLocation;
        /* Concats the ~positions file location to the main folders location*/
        positionsFileLocation = mainFolderLocation.concat("config\\~positions");
        /* Initializes a file path for the ~positions file */
        filePath = Paths.get(positionsFileLocation);
        /* Initializes each Linked List for the devices*/
        tmxList = new LinkedList<>();
        semList = new LinkedList<>();
        encoderList = new LinkedList<>();
    }
    
    /**
     * Method to scan through the input file.
     * @param display The display data GUI
     * @throws IOException on error 
     */
    public void scanList(A6_InitialDataDisplayCode display) throws IOException{
        /* Creates new Scanner object of the filePath */
        scan = new Scanner(filePath);
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
                    tmxNumber++;//increments TMX number
                    A7_TMX tmxData = new A7_TMX(mainFolderLocation);
                    tmxData.setTmxNumber(tmxNumber);//sets TMX number
                    tmxData.setDevice(device);//sets device to TMX
                    tmxData.setType(type);//sets type to TMX
                    tmxData.setPositionID(positionID);//sets TMX positionID
                    tmxData.setName(name);//sets TMX name
                    tmxData.setAddress(address);//sets TMX IP address
                    tmxData.parseTmxFile();//parses the TMX device file 
                    /* Sets Priority Number of TMX(1-Primary, 2-Backup) */
                    if(tmxData.getDataMap().get("Role").equals("Primary")){
                        tmxData.setPriorityNumber(1);//Primary
                        statGroupList = tmxData.getStatGroupList();
                    }
                    else tmxData.setPriorityNumber(2);//Backup
                    /* Adds device to linked list */
                    tmxList.add(tmxData);
                    break;  
                case "SEM"://device is a SEM
                    semNumber++;//increments SEM number
                    A7_SEM semData = new A7_SEM(mainFolderLocation);
                    semData.setSemNumber(semNumber);//sets SEM number
                    semData.setDevice(device);//sets device to SEM
                    semData.setType(type);//sets type to SEM
                    semData.setPositionID(positionID);//sets SEM positionID
                    semData.setName(name);//sets SEM name
                    semData.setAddress(address);//sets SEM IP address
                    semData.parseSemFile(mainFolderLocation);//parses SEM file
                    /* Sets Priority Number of SEM(1-Primary, 2-Backup) */
                    if(semData.getDataMap().get("Role").equals("Primary")){
                        semData.setPriorityNumber(1);//Primary
                    }
                    else semData.setPriorityNumber(2);//Backup
                    /* Adds device to linked list */
                    semList.add(semData);
                    break; 
                    
                case "Encoder"://device is a encoder
                    encNumber++;//increments Encoder Number
                    A7_Encoder encoderData = new A7_Encoder(mainFolderLocation);
                    encoderData.setEncNumber(encNumber);//sets encoder number
                    encoderData.setDevice(device);//sets device to encoder
                    encoderData.setType(type);//sets type to encoder
                    encoderData.setPositionID(positionID);//sets positionID
                    encoderData.setName(name);//sets encoder name
                    encoderData.setAddress(address);//sets encoder IP address
                    encoderData.parseEncFile();//parses encoder file 
                    /* Sets the priority number(1-Primary, 2-Backup) */
                    if(encoderData.getDataMap().get("Role").equals("Primary")){
                        encoderData.setPriorityNumber(1);//device is primary
                    }
                    else encoderData.setPriorityNumber(2);//device is backup 
                    /* Adds device to linked list */
                    encoderList.add(encoderData);//adds device to LinkedList
                    break;  
                case "non-device"://catch all case
                    break;
            }
        }
        /* Sorts SEM list by role */
        Collections.sort(semList, (A7_SEM a, A7_SEM b) -> {
            if(a.getPriorityNumber() < b.getPriorityNumber()){
                return -1;
            }
            if(a.getPriorityNumber() > b.getPriorityNumber()){
                return 1;
            }
            return 0;
        });
        /* Sorts TMX list by role */
        Collections.sort(tmxList, (A7_TMX a, A7_TMX b) -> {
            if(a.getPriorityNumber() < b.getPriorityNumber()){
                return -1;
            }
            if(a.getPriorityNumber() > b.getPriorityNumber()){
                return 1;
            }
            return 0;
        });
        /* Sorts Encoder list by role */
        Collections.sort(encoderList, (A7_Encoder a, A7_Encoder b) -> {
            if(a.getPriorityNumber() < b.getPriorityNumber()){
                return -1;
            }
            if(a.getPriorityNumber() > b.getPriorityNumber()){
                return 1;
            }
            return 0;
        });
        
        A7_SATELLITE satData = new A7_SATELLITE(mainFolderLocation);
        satData.parseConfigFile();
        display.setOperatorGroup(satData.getOperatorGroup());
        display.displaySAT(satData);
        /* Function call to display SEM data on GUI */
        display.displaySEM(semList);
        /* Function call to display TMX data on GUI */
        display.displayTMX(tmxList);
        /* Function call to display Encoder data on GUI */
        display.displayENC(encoderList); 
    }
    
    /**
     * Method to parse each specific line of the ~positions file.
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
    }
}