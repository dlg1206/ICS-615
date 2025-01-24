package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <b>File:</b> VendingStatusTest.java
 * <p>
 * <b>Description:</b> Test the VendingStatus class
 *
 * @author Derek Garcia
 */
public class VendingStatusTest {
    private final boolean VENDING_STATUS_IS_SUCCESS = true;
    private final double VENDING_STATUS_CHANGE = 3.5;
    private final VendingStatus.VendingMessage VENDING_STATUS_VENDING_MESSAGE = VendingStatus.VendingMessage.SUCCESS;

    private VendingStatus vendingStatus;

    @Before
    public void setUp() {
        vendingStatus = new VendingStatus(VENDING_STATUS_IS_SUCCESS, VENDING_STATUS_CHANGE, VENDING_STATUS_VENDING_MESSAGE);
    }

    @Test
    public void test_isSuccess() {
        // Given

        // When

        // Then
        assertEquals(vendingStatus.isSuccess(), VENDING_STATUS_IS_SUCCESS);
    }

    @Test
    public void test_getChange() {
        // Given

        // When

        // Then
        assertEquals(vendingStatus.getChange(), VENDING_STATUS_CHANGE, 0);
    }

    @Test
    public void test_getMessage() {
        // Given

        // When

        // Then
        assertEquals(vendingStatus.getMessage(), VENDING_STATUS_VENDING_MESSAGE);
    }


}
