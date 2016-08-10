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
import java.util.Map;
import java.util.Scanner;

/**
 * This class is used to gather the Satellite information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A7_SATELLITE {
    
    private final String fileLocation;
    private String configFileLocation, line, satNumber, tranNumber, vctNumber, 
            opGroup;
    private Path configPath;
    private Scanner scan;
    private final String[] strings = {"Messaging.Satellite", "Messaging.VCT", 
        "Partition"};
    private final String[] satStrings = {".Name", "FullName", "Hemisphere", 
        "Polarization",  "Frequency", "TransportType", "Modulation", "VCT"};
    private final String[] vctStrings = {"Name", "Source", "ChannelType", 
        "Satellite", "Carrier", ".Transport"};
    private final Map satResults = new HashMap<>();
    private final Map transResults = new HashMap<>();
    private final Map vctResults = new HashMap<>();
    private final ArrayList satList = new ArrayList();
    private final ArrayList tranList = new ArrayList();
    private final ArrayList vctList = new ArrayList();
    
    /**
     * Class constructor that sets the main file folder location
     * @param location The main file folder location
     */
    public A7_SATELLITE(String location){
        fileLocation = location;
    }
    
    /**
     * Method to parse the configuration file to get all the satellite data.
     * @throws IOException If an error occurs
     */
    public void parseConfigFile() throws IOException{
        /* Declare Local Variables */
        String value;
        String[] splitString;
        /* Concats the config file location to the main folders location*/
        configFileLocation = fileLocation.concat("config\\~sys-config");
        /* Initializes a file path for the config file */
        configPath = Paths.get(configFileLocation);
        /* Initializes a scanner for the file */
        scan = new Scanner(configPath);
        /* Loops through each line of the file */
        while(scan.hasNextLine()){
            /* Sets the string to the next line */
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
                    /* If no data, sets value to represent that */
                    else value = "NO DATA"; 
                    /* Checks for Satellite data */
                    switch (sub) {
                        case "Messaging.Satellite":
                            /* Loops through the Satellite Strings */
                            for(String sat:satStrings){
                                /* Checks for a String match */
                                if(line.contains(sat) && 
                                        !line.contains("Transponder")){
                                    if(sat.equals(".Name")){
                                        splitString = splitString[0]
                                                .split("\\.");
                                        satNumber = splitString[2];
                                        sat = "Name";
                                        satList.add(satNumber);
                                    }
                                    sat = "Satellite" + satNumber + sat;
                                    satResults.put(sat, value);
                                }
                                else if(line.contains(sat) && 
                                        line.contains("Transponder")){
                                    if(sat.equals(".Name")){
                                        splitString = splitString[0]
                                                .split("\\.");
                                        tranNumber = splitString[4];
                                        sat = "Name";
                                        tranList.add(tranNumber);
                                    }
                                    sat = "Satellite" + satNumber + 
                                            "Transponder" + tranNumber + sat; 
                                    transResults.put(sat, value);
                                }
                            } break;
                        case "Messaging.VCT":
                            for(String vct:vctStrings){
                                if(line.contains(vct)){
                                    if(vct.equals("Name")){
                                        splitString = splitString[0]
                                                .split("\\.");
                                        vctNumber = "VCT" + splitString[2] + 
                                                "Channel" + splitString[4];
                                        vctList.add(vctNumber);
                                    }
                                    vct = vctNumber + vct;
                                    vctResults.put(vct, value);
                                }
                            }break;
                        case "Partition":
                            if(line.contains(".OperatorGroup")){
                                opGroup = value;
                            }break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    
    /**
     * Operator Group Getter.
     * @return Operator Group
     */
    public String getOperatorGroup(){
        return opGroup;
    }
    /**
     * Satellite Data Map Getter.
     * @return Satellite Data Map
     */
    public Map getDataMap(){
        return satResults;
    }
    /**
     * Satellite Transponder Map Getter.
     * @return Transponder Data Map
     */
    public Map getTransMap(){
        return transResults;
    }
    /**
     * Satellite VCT Map Getter.
     * @return VCT Data Map
     */
    public Map getVctMap(){
        return vctResults;
    }
    /**
     * Satellite List Getter.
     * @return Satellite List
     */
    public ArrayList getSatList(){
        return satList;
    }
    /**
     * Transponder List Getter.
     * @return Transponder List
     */
    public ArrayList getTransponderList(){
        return tranList;
    }
    /**
     * VCT List Getter.
     * @return VCT List
     */
    public ArrayList getVctList(){
        return vctList;
    }
    
}
