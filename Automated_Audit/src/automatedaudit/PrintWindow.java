/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author csimonson
 */
public class PrintWindow implements Printable {
    
    JFrame printFrame;
    
    private final String fileLocation;
    
    public PrintWindow(JFrame frame, String location) throws IOException{
        printFrame = frame;
        fileLocation = location;
        
    }
    
    public void printButtonPressed(){
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if(ok){
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(PrintWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public int print(Graphics graphic, PageFormat pFormat, int page){
        if(page > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g = (Graphics2D) graphic;
        g.translate(pFormat.getImageableX(), pFormat.getImageableY());
        printFrame.printAll(graphic);
        return PAGE_EXISTS;
    }
}
