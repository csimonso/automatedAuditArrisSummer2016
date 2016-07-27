/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.io.*;
import org.apache.commons.compress.archivers.tar.*;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

/**
 * This class is used to unpack the backup Tar files.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class A3_UnpackTar {
    
    final int BUFFER = 2048;//sets the buffer size
    private String fileFolder;
    
    /**
     * This method unpacks the Tar file.
     * @param tarInput The Tar file to be unpacked
     * @throws FileNotFoundException if file does not exist
     * @throws IOException on error
     */
    private String unPack(TarArchiveInputStream tarInput, String fileCopyLocation) 
            throws FileNotFoundException, IOException{

        /* Creates and Initializes a new TarArchiveEntry */
        TarArchiveEntry entry;
        entry = (TarArchiveEntry) tarInput.getNextTarEntry();
        /* Sets a string to the file location */
        String newFileDirectory = fileCopyLocation.concat(entry.getName());
        /* Loop to read each entry in the Tar file */
        while((entry = (TarArchiveEntry) tarInput.getNextEntry()) != null){
            
            /* Creates a directory if the current entry is a directory */
            if(entry.isDirectory()){
                String newDirLocation = fileCopyLocation.concat(entry.getName());
                /* Creates and initializes a new file */
                File file = new File(newDirLocation);
                /* Makes a new directory */
                file.mkdirs();
            }
            
            /* Writes file if the current entry is a file */
            else {
                int count;
                byte data[] = new byte[BUFFER];//initializes to buffer size
                
                /* Creates a new FileOutputsStream for the current entry */
                FileOutputStream out = new FileOutputStream(fileCopyLocation + 
                        entry.getName());
                /* Creates a new BufferedOutputStream to save for later use */
                BufferedOutputStream destination; 
                /* Initializes the BufferedOutputStream */
                destination = new BufferedOutputStream(out,BUFFER);
                
                /* Loops through the file to write data to destination */
                while((count = tarInput.read(data, 0, BUFFER)) != -1){
                    destination.write(data, 0, count);
                }
                /* Closes BufferedOutputStream */
                destination.close();
            }
        }
        return newFileDirectory;//returns the new directory
    }
    
    /**
     * Method to create each file thats being unpacked.
     * @param userInput The file main file folder from the user
     * @return The file folder created
     * @throws IOException If an error occurs
     */
    public String createFiles(String userInput) throws IOException{
      
        /* Creates and initializes a FileInputStream from the user input */
        FileInputStream backupFile = new FileInputStream(userInput);
        /* Splits the current file location using "\" */
        String[] fileLocation = userInput.split("\\\\");  
        /* Initializes a string for the location of the file copies */
        String fileCopyLocation = null;
        
        /* Loop through all the files to create copies of them */
        for(int i = 0; i < fileLocation.length - 1; i++){
            if(i == 0){
                fileCopyLocation = fileLocation[i];
            }
            else{
                fileCopyLocation = fileCopyLocation.concat("\\");
                fileCopyLocation = fileCopyLocation.concat(fileLocation[i]);
            }
        }
        fileCopyLocation = fileCopyLocation.concat("\\");

        /* Creates a BufferedInputStream and saves input file for later use */
        BufferedInputStream bInput = new BufferedInputStream(backupFile);
        /* Creates new input stream that decompresses data from input stream */
        GzipCompressorInputStream gzInput = new GzipCompressorInputStream(bInput);
        
        /* Creates a UNIX tar archive as InputStream */ 
        TarArchiveInputStream tarIn;
        tarIn = new TarArchiveInputStream(gzInput);
        
        /* Creates a file folder of all folder files */
        fileFolder = this.unPack(tarIn, fileCopyLocation);
        /* Closes the input file */
        tarIn.close();
        /* Returns the new file folder */
        return fileFolder;
    }
}
