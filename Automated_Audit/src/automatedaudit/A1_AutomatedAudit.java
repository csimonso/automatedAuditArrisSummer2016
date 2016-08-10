/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AutomatedAudit program extracts the data from a backup file.  These files
 * are then parsed in order to display all relevant information to the screen.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class A1_AutomatedAudit {
    
    /**
     * This is the main class that initiates the main GUI where all the 
     * function calls are made from.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        
        /* A delay in program startup to allow for a splash screen */
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(A1_AutomatedAudit.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        /* Creates a new GUI object */
        A2_MainDisplay run = new A2_MainDisplay();

        /* Run the main GUI display */
        run.runProgram();
    }
}
