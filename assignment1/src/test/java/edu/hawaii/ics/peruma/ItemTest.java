package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <b>File:</b> ItemTest.java
 * <p>
 * <b>Description:</b> Test the Item class
 *
 * @author Derek Garcia
 */
public class ItemTest {
    private final String ITEM_NAME = "bepsi";
    private final double ITEM_PRICE = 3.5;
    private final int ITEM_QUANTITY = 1;

    private Item item;
    private Location location;

    @Before
    public void setUp() {
        location = new Location(0, 0);
        item = new Item(ITEM_NAME, ITEM_PRICE, ITEM_QUANTITY, location);
    }

    @Test
    public void test_getName() {
        // Given

        // When

        // Then
        assertEquals(item.getName(), ITEM_NAME);
    }

    @Test
    public void test_getLocation() {
        // Given

        // When

        // Then
        assertEquals(item.getLocation(), location);
    }

    @Test
    public void test_getPrice() {
        // Given

        // When

        // Then
        assertEquals(item.getPrice(), ITEM_PRICE, 0);
    }

    @Test
    public void test_getQuantity() {
        // Given

        // When

        // Then
        assertEquals(item.getQuantity(), ITEM_QUANTITY);
    }

    @Test
    public void test_setQuantity() {
        // Given
        int new_quantity = 5;
        // When
        item.setQuantity(new_quantity);
        // Then
        assertEquals(item.getQuantity(), new_quantity);
    }

}
