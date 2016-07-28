/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;


/**
 * The AutomatedAudit program implements an application that reviews a backup
 * file from the server and outputs all relevant data and information.
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
        /* Creates a new GUI object */
        A2_MainUI run = new A2_MainUI();

        /* Function call to run the main GUI display */
        run.runProgram();
        
         //TEST FILE LOCATION     
         //C:\Users\csimonson\Desktop\backup_20160602_135011.tar
    }
}
