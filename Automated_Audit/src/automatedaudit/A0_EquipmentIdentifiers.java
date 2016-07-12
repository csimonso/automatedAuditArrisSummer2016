/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

/**
 * This interface is used for all device's within an element group to obtain
 * any relevant information about the device.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public interface A0_EquipmentIdentifiers {
    
    /**
     * This method is used to get the device name.
     * @return name
     */
    public String getName();
    
    /**
     * This method is used to set the device name.
     * @param name The name for the device
     */
    public void setName(String name);
    
    /**
     * This method is used to get the device IP address.
     * @return IP address
     */
    public String getAddress();
    
    /**
     * This method is used to set the device IP address.
     * @param address The IP address for the device
     */
    public void setAddress(String address);
    
    /**
     * This method is used to get the device version number.
     * @return Version
     */
    public String getVersion();
    
    /**
     * This method is used to set the device version number.
     * @param version The device version number
     */
    public void setVersion(String version);
    
    /**
     * This method is used to get the device role.
     * @return Role
     */
    public String getRole();
    
    /**
     * This method is used to set the device role.
     * @param role The device role
     */
    public void setRole(String role);
    
    /**
     * This method is used to get the device type.
     * @return Type
     */
    public String getType();
    
    /**
     * This method is used to set the device type.
     * @param type The device type
     */
    public void setType(String type);
    
    /**
     * This method is used to get the device position ID.
     * @return Position ID
     */
    public String getPositionID();
    
    /**
     * This method is used to set the device position ID.
     * @param positionID The device position ID
     */
    public void setPositionID(String positionID);
}
