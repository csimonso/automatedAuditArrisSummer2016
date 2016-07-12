/*
 * Copyright (C) ARRIS Solutions Inc. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Christopher Simonson <chris.simonson@arris.com>, July 2016
 */
package automatedaudit;

/**
 * This class is used to gather the Encoder information.
 * 
 * @author Christopher Simonson
 * @version 1.0
 * @since 2016-07-01
 */
public class Encoder implements A0_EquipmentIdentifiers{
    
    private String name;
    private String address;
    private String version;
    private String role;
    private String type;
    private String positionID;
    
    /**
     * Encoder Name Getter.
     * @return The Encoder Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Encoder Name Setter.
     * @param name The Encoder Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Encoder IP Address Getter.
     * @return The Encoder IP Address
     */
    @Override
    public String getAddress() {
       return address;
    }

    /**
     * Encoder IP Address Setter.
     * @param address The Encoder IP Address
     */
    @Override
    public void setAddress(String address) {
       this.address = address;
    }

    /**
     * Encoder Version Getter.
     * @return The Encoder Version Number
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * Encoder Version Setter.
     * @param version The Encoder Version Number
     */
    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Encoder Role Getter.
     * @return The Encoder Role
     */
    @Override
    public String getRole() {
       return role;
    }

    /**
     * Encoder Role Setter.
     * @param role The Encoder Role
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Encoder Type Getter.
     * @return The Encoder Type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Encoder Type Setter.
     * @param type The Encoder Type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Encoder Position ID Getter.
     * @return The Encoder Position ID
     */
    @Override
    public String getPositionID() {
        return positionID;
    }

    /**
     * Encoder Position ID Setter.
     * @param positionID The Encoder Position ID
     */
    @Override
    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }
}
