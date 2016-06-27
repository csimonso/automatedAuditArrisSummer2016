/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.io.*;
import org.apache.commons.compress.compressors.gzip.*;
import org.apache.commons.compress.archivers.tar.*;

/**
 * The AutomatedAudit program implements an application that reviews a backup
 * file from the server and outputs all relevant data and information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class AutomatedAudit {
    /**
     * This is the main method which opens the input file and makes all 
     * function calls.
     * @param args the command line arguments
     * @throws FileNotFoundException if file doesn't exist
     * @throws IOException if stream could not be created
     */
    public static void main(String[] args) 
            throws FileNotFoundException, IOException {
        
        /* Creates a FileInputStream by opening specified TAR file */
        FileInputStream backupFile = new FileInputStream(
                "C:\\Users\\csimonson\\Desktop\\backup_20160602_135011.tar");
        /* Creates a BufferedInputStream and saves input file for later use */
        BufferedInputStream bInput = new BufferedInputStream(backupFile);
        /* Creates new input stream that decompresses data from input stream */
        GzipCompressorInputStream gzInput = new GzipCompressorInputStream(bInput);
        /* Creates a new UnpackTar Object */
        UnpackTar unpackFile = new UnpackTar();
        /* Creates a UNIX tar archive as InputStream */ 
        TarArchiveInputStream tarIn;
        tarIn = new TarArchiveInputStream(gzInput);
        /* Function call to unpack TarArchiveInputStream */
        unpackFile.unPack(tarIn);
        /* Closes TarAchiveInputStream */
        tarIn.close();
    }
    
}
