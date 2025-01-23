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

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a vending machine. A vending machine contains a collection of items.
 * Items can be added to the vending machine.
 * A user can remove an item from the vending machine by specifying the row and column of the item and providing the correct amount of money.
 */
public class VendingMachine {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    /**
     * Constructor for VendingMachine
     */
    public VendingMachine() {
        items = new ArrayList<>();

    }

    /**
     * This method adds an item to the vending machine
     * @param item - item to be added to the vending machine
     * @return AddStatus - status of the add operation
     */
    public AddStatus addItem(Item item) {
        if (item.getQuantity() > 10) {
            return new AddStatus(false, AddStatus.AddMessage.INSUFFICIENT_SPACE);
        }

        if (item.getLocation().getRow() > 10 || item.getLocation().getColumn() > 10) {
            return new AddStatus(false, AddStatus.AddMessage.INVALID_LOCATION);
        }

        Item existingItem = items.stream().filter(x -> x.getLocation().getRow() == item.getLocation().getRow()
                && x.getLocation().getColumn() == item.getLocation().getColumn()).findFirst().orElse(null);
        if (existingItem != null && (existingItem.getQuantity() + item.getQuantity()) > 10) {
            return new AddStatus(false, AddStatus.AddMessage.INSUFFICIENT_SPACE);
        }

        items.add(item);
        return new AddStatus(true, AddStatus.AddMessage.SUCCESS);
    }

    /**
     * This method removes an item from the vending machine
     * @param location - location of the item to be removed
     * @param depositAmount - amount of money provided by the user
     * @return VendingStatus - status of the vending operation
     */
    public VendingStatus vendItem(Location location, double depositAmount) {
        for (Item item : items) {
            if (item.getLocation().equals(location)) {
                if (item.getQuantity() > 0) {
                    if (item.getPrice() <= depositAmount) {
                        item.setQuantity(item.getQuantity() - 1);
                        double change = depositAmount - item.getPrice();
                        return new VendingStatus(true, change, VendingStatus.VendingMessage.SUCCESS);
                    } else {
                        return new VendingStatus(false, 0, VendingStatus.VendingMessage.INSUFFICIENT_FUNDS);
                    }
                } else {
                    return new VendingStatus(false, 0, VendingStatus.VendingMessage.OUT_OF_STOCK);
                }
            }
        }
        return new VendingStatus(false, 0, VendingStatus.VendingMessage.UNKNOWN_LOCATION);
    }
}
