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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    
    VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
        vendingMachine.addItem(new Item("Soda", 1.25, 10, new Location(1, 1)));
        vendingMachine.addItem(new Item("Chips", 1.50, 5, new Location(1, 2)));
    }
    
    @Test
    public void addItem_Successful() {
        AddStatus addStatus = vendingMachine.addItem(new Item("Apple Juice", 2.25, 10, new Location(3, 1)));
        assertTrue("Could not add item", addStatus.isSuccess());
    }


}
