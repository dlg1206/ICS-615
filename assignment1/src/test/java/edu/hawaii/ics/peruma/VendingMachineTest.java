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

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private final int MAX_ITEM_CAPACITY = 10;
    private final int MAX_ITEM_ROW_INDEX = 10;
    private final int MAX_ITEM_COL_INDEX = 10;
    private final String ITEM_DEFAULT_NAME = "Apple Juice";
    private final double ITEM_DEFAULT_PRICE = 2.25;
    private final int ITEM_DEFAULT_QUANTITY = 1;
    private final int ITEM_DEFAULT_ROW_INDEX = 1;
    private final int ITEM_DEFAULT_COL_INDEX = 1;


    VendingMachine vendingMachine;

    /**
     * Create a default item
     *
     * @return Valid item
     */
    private Item createItem() {
        return new Item(ITEM_DEFAULT_NAME, ITEM_DEFAULT_PRICE, ITEM_DEFAULT_QUANTITY, new Location(ITEM_DEFAULT_ROW_INDEX, ITEM_DEFAULT_COL_INDEX));
    }

    /**
     * Create an item with a quantity
     *
     * @param quantity Quantity of item
     * @return item
     */
    private Item createItem(int quantity) {
        return new Item(ITEM_DEFAULT_NAME, ITEM_DEFAULT_PRICE, quantity, new Location(ITEM_DEFAULT_ROW_INDEX, ITEM_DEFAULT_COL_INDEX));
    }

    /**
     * Create an item with an index
     *
     * @param row Row of item
     * @param col Column of item
     * @return item
     */
    private Item createItem(int row, int col) {
        return new Item(ITEM_DEFAULT_NAME, ITEM_DEFAULT_PRICE, ITEM_DEFAULT_QUANTITY, new Location(row, col));

    }


    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void test_addItem_new_item_success() {
        // Given
        Item newItem = createItem();

        // When
        AddStatus addStatus = vendingMachine.addItem(newItem);

        // Then
        assertTrue("Could not add item", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.SUCCESS, addStatus.getAddMessage());
    }

    @Test
    public void test_addItem_existing_item_success() {
        // Given
        Item item = createItem();
        vendingMachine.addItem(item);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertTrue("Could not add item", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.SUCCESS, addStatus.getAddMessage());

    }

    @Test
    public void test_getItems() {
        // Given
        Item item = createItem();
        vendingMachine.addItem(item);

        // When

        // Then
        assertEquals(List.of(item), vendingMachine.getItems());
    }

    @Test
    public void test_addItem_new_item_exceed_item_capacity() {
        // Given
        Item item = createItem(MAX_ITEM_CAPACITY + 1);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertFalse("Added item that exceeds the item capacity", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INSUFFICIENT_SPACE, addStatus.getAddMessage());
    }

    @Test
    public void test_addItem_existing_item_exceed_item_capacity() {
        // Given
        Item item = createItem(MAX_ITEM_CAPACITY);
        vendingMachine.addItem(item);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertFalse("Added item that exceeds the item capacity", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INSUFFICIENT_SPACE, addStatus.getAddMessage());
    }


    @Test
    public void test_addItem_invalid_row_location() {
        // Given
        Item item = createItem(MAX_ITEM_ROW_INDEX + 1, ITEM_DEFAULT_COL_INDEX);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertFalse("Added item that is outside the allowed row range", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INVALID_LOCATION, addStatus.getAddMessage());

    }

    @Test
    public void test_addItem_invalid_col_location() {
        // Given
        Item item = createItem(ITEM_DEFAULT_ROW_INDEX, MAX_ITEM_COL_INDEX + 1);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertFalse("Added item that is outside the allowed column range", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INVALID_LOCATION, addStatus.getAddMessage());

    }

    @Test
    public void test_addItem_invalid_row_and_col_location() {
        // Given
        Item item = createItem(MAX_ITEM_ROW_INDEX + 1, MAX_ITEM_COL_INDEX + 1);

        // When
        AddStatus addStatus = vendingMachine.addItem(item);

        // Then
        assertFalse("Added item that is outside the allowed row and column range", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INVALID_LOCATION, addStatus.getAddMessage());

    }

    @Test
    public void test_vendItem_success() {
        // Given
        Item item = createItem();
        vendingMachine.addItem(item);

        // When
        VendingStatus vendingStatus = vendingMachine.vendItem(item.getLocation(), item.getPrice());

        // Then
        assertTrue("Did not vend an item that could be vended", vendingStatus.isSuccess());
        assertEquals(0.0, vendingStatus.getChange(), 0);
        assertEquals(VendingStatus.VendingMessage.SUCCESS, vendingStatus.getMessage());

    }

    @Test
    public void test_vendItem_insufficient_funds() {
        // Given
        Item item = createItem();
        double deposit = 0.0;
        vendingMachine.addItem(item);

        // When
        VendingStatus vendingStatus = vendingMachine.vendItem(item.getLocation(), deposit);

        // Then
        assertFalse("Vended item that cost more than deposit provided", vendingStatus.isSuccess());
        assertEquals(deposit, vendingStatus.getChange(), 0);
        assertEquals(VendingStatus.VendingMessage.INSUFFICIENT_FUNDS, vendingStatus.getMessage());
    }

    @Test
    public void test_vendItem_item_out_of_stock() {
        // Given
        Item item = createItem(0);
        vendingMachine.addItem(item);

        // When
        VendingStatus vendingStatus = vendingMachine.vendItem(item.getLocation(), item.getPrice());

        // Then
        assertFalse("Vended item that was out of stock", vendingStatus.isSuccess());
        assertEquals(0.0, vendingStatus.getChange(), 0);
        assertEquals(VendingStatus.VendingMessage.OUT_OF_STOCK, vendingStatus.getMessage());
    }

    @Test
    public void test_vendItem_item_unknown_location() {
        // Given
        Item item = createItem();
        Location location = new Location(ITEM_DEFAULT_ROW_INDEX + 1, ITEM_DEFAULT_COL_INDEX + 1);   // so loc will always be different
        vendingMachine.addItem(item);

        // When
        VendingStatus vendingStatus = vendingMachine.vendItem(location, item.getPrice());

        // Then
        assertFalse("Vended item that is outside the allowed row and column range", vendingStatus.isSuccess());
        assertEquals(0.0, vendingStatus.getChange(), 0);
        assertEquals(VendingStatus.VendingMessage.UNKNOWN_LOCATION, vendingStatus.getMessage());
    }


}
