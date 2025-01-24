package edu.hawaii.ics.peruma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * <b>File:</b> LocationTest.java
 * <p>
 * <b>Description:</b> Test Location Class
 *
 * @author Derek Garcia
 */
public class LocationTest {
    private final int LOCATION_ROW_A = 0;
    private final int LOCATION_COL_A = 0;
    private final int LOCATION_ROW_B = 1;
    private final int LOCATION_COL_B = 1;

    private Location locationA;

    @Before
    public void setUp() {
        locationA = new Location(LOCATION_ROW_A, LOCATION_COL_A);
    }

    @Test
    public void test_getRow() {
        // Given

        // When

        // Then
        assertEquals(locationA.getRow(), LOCATION_ROW_A);
    }

    @Test
    public void test_getColumn() {
        // Given

        // When

        // Then
        assertEquals(locationA.getColumn(), LOCATION_COL_A);
    }

    @Test
    public void test_equals_location_with_same_coordinates() {
        // Given
        Location otherLocation = new Location(LOCATION_ROW_A, LOCATION_COL_A);
        // When

        // Then
        assertEquals(locationA, otherLocation);
    }

    @Test
    public void test_equals_location_with_same_row_different_column() {
        // Given
        Location otherLocation = new Location(LOCATION_ROW_A, LOCATION_COL_B);
        // When

        // Then
        assertNotEquals(locationA, otherLocation);
    }

    @Test
    public void test_equals_location_with_different_row_same_column() {
        // Given
        Location otherLocation = new Location(LOCATION_ROW_B, LOCATION_COL_A);
        // When

        // Then
        assertNotEquals(locationA, otherLocation);
    }

    @Test
    public void test_equals_location_with_different_row_different_column() {
        // Given
        Location otherLocation = new Location(LOCATION_ROW_B, LOCATION_COL_B);
        // When

        // Then
        assertNotEquals(locationA, otherLocation);
    }

    @Test
    public void test_equals_location_with_non_location_object() {
        // Given
        String nonLocationObject = "spiffy";
        // When

        // Then
        assertNotEquals(locationA, nonLocationObject);
    }

    @Test
    public void test_equals_location_with_null() {
        // Given
        Location otherLocation = null;
        // When

        // Then
        assertNotEquals(locationA, otherLocation);
    }
}
