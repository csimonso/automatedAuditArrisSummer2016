/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * This class is used to gather the MUX information and contains all relevant
 * getter and setter methods for the MUX data.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A4_MUX implements A0_VirtualIdentifiers {
    
    private String name, address, version;
    private final String fileLocation;
    private final Path filePath;
    
    /**
     * Class Constructor that creates a file path for file.
     * @param inputLocation The directory location of the server.info file
     * @throws IOException on error
     */
    public A4_MUX (String inputLocation) throws IOException{
        fileLocation = inputLocation.concat("server.info");
        filePath = Paths.get(fileLocation);    
    }
    
    /**
     * This method parses the file with all the MUX data.
     * @throws IOException on error
     */
    public void parseFile() throws IOException {
        /* Creates new Scanner object of the filePath */
        Scanner scan = new Scanner(filePath).useDelimiter("version=");
        
        /* Creates new Scanner object for the server version */
        Scanner scanVersion = new Scanner(scan.next()).useDelimiter("name=");
        /* Sets the server version number */
        this.setVersion(scanVersion.next());
        
        /* Creates new Scanner object for the server name */
        Scanner scanName = 
                new Scanner(scanVersion.next()).useDelimiter("host=");
        /* Sets the server name */
        this.setName(scanName.next());
        
        /* Creates new Scanner object for the server ip address */
        Scanner scanAddress = new Scanner(scanName.next());
        /* Sets the server ip address */
        this.setIPAddress(scanAddress.next()); 
    }

    /**
     * MUX Version Setter.
     * @param version The MUX Version Number
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * MUX Version Getter.
     * @return The MUX Version Number
     */
    public String getVersion(){
        return version;
    }
    
    /**
     * MUX Name Getter.
     * @return The MUX Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * MUX Name Setter.
     * @param name The MUX Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * MUX IP Address Getter.
     * @return The MUX IP Address
     */
    @Override
    public String getIPAddress() {
        return address;
    }

    /**
     * MUX IP Address Setter
     * @param address The MUX IP Address
     */
    @Override
    public void setIPAddress(String address) {
        this.address = address;
    }
}
