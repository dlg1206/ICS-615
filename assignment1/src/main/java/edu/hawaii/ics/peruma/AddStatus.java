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
 * This class is used to return the status of adding an item to the vending machine
 */
public class AddStatus {
    private boolean isSuccess;
    private AddMessage message;

    /**
     * @param isSuccess - boolean to determine if adding an item was successful
     * @param message - message associated with the add operation
     */
    public AddStatus(boolean isSuccess, AddMessage message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    /**
     * @return the isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * @return the message
     */
    public AddMessage getAddMessage() {
        return message;
    }

    /**
     * Enum for AddMessage
     */
    public enum AddMessage {
        SUCCESS, INVALID_LOCATION, INSUFFICIENT_SPACE
    }
}
