/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, August 2016
 */
package automatedaudit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 * This class is used to write any tables to a Excel File.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-08-01
 */
public class WriteTablesToFile {
    
    private final DefaultTableModel model;
    private String fileName;
    
    /**
     * Class Constructor.
     * @param table The table to be written to file.
     */
    public WriteTablesToFile(DefaultTableModel table){
        model = table;
    }
    
    /**
     * Method to write the table to a file
     * @param name The name of the file being written
     * @throws IOException If error occurs
     */
    public void writeTable(String name) throws IOException{
        /* Sets the format for the output file */
        fileName = name + ".xls";
        /* Creates a new excel file */
        File file = new File(fileName);
        /* Creates a new File Write to write to the excel file */
        try (FileWriter excelFile = new FileWriter(file)) {
            /* Loops through the column names and writes to file */
            for(int col = 0; col < model.getColumnCount(); col++){
                excelFile.write(model.getColumnName(col) + "\t");
            }
            excelFile.write("\n");//skips to next row
            /* Loops through each row and column to write to excel file */
            for(int row = 0; row < model.getRowCount(); row++){
                for(int col = 0; col < model.getColumnCount(); col++){
                    excelFile.write(model.getValueAt(row, col).toString() +
                            "\t");
                }
                excelFile.write("\n");
            }
            /* Closes File Writer */
            excelFile.close();
        }
    } 
}
