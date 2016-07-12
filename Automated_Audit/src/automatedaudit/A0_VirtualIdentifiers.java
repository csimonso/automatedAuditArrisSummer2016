/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

/**
 * This interface is used for all virtual objects to obtain any relevant 
 * information pertaining to those objects.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public interface A0_VirtualIdentifiers {
    /**
     * This method is used to get the virtual objects name.
     * @return name
     */
    public String getName();
    
    /**
     * This method is used to set the virtual objects name.
     * @param name The name for the element
     */
    public void setName(String name);
    
     /**
     * This method is used to get the virtual objects IP address.
     * @return address
     */
    public String getIPAddress();
    
    /**
     * This method is used to set the virtual objects IP address.
     * @param address The IP address for the element
     */
    public void setIPAddress(String address);
}
