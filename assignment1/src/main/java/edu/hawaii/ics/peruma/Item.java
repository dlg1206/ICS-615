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
 * This class represents an item in the vending machine
 */
public class Item {
    private String name;
    private Location location;
    private double price;
    private int quantity;

    /**
     * Constructor for Item
     * @param name - name of the item
     * @param price - price of the item
     * @param quantity - quantity of the item
     * @param location - location of the item
     */
    Item(String name,  double price, int quantity,Location location) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity - the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
