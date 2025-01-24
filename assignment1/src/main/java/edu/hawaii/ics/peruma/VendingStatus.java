//*******************************************************************
//  __description__ = "Assignment 01 - Unit Testing"
//  __course__ = "ics615"
//  __organization__ = "Information and Computer Sciences Department, University of Hawai‘i at Mānoa"
//  __author__ = "Anthony Peruma"
//  __email__ = "peruma@hawaii.edu"
//  __web__ = "https://www.peruma.me"
//  __version__ = "1.0"
//  __created__ = "2022-08-01"
//  __modified__ = "2023-03-01"
//  __maintainer__ = "Anthony Peruma"
//*******************************************************************
package edu.hawaii.ics.peruma;

/**
 * This class represents the status of an operation in the vending machine
 */
public class VendingStatus {
    private boolean isSuccess;
    private double change;
    private VendingMessage message;

    /**
     * @param isSuccess - boolean to determine if the operation was successful
     * @param change - change (i.e., money) to be returned to the user
     * @param message - message associated with the operation
     */
    public VendingStatus(boolean isSuccess, double change, VendingMessage message) {
        this.isSuccess = isSuccess;
        this.change = change;
        this.message = message;
    }

    /**
     * @return the isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * @return the change
     */
    public double getChange() {
        return change;
    }

    /**
     * @return the message
     */
    public VendingMessage getMessage() {
        return message;
    }

    /**
     * Enum for VendingMessage
     */
    public enum VendingMessage {
        SUCCESS, INSUFFICIENT_FUNDS, OUT_OF_STOCK, UNKNOWN_LOCATION
    }
}
