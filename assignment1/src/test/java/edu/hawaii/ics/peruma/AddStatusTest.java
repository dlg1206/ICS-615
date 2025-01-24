package edu.hawaii.ics.peruma;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <b>File:</b> AddStatusTest.java
 * <p>
 * <b>Description:</b> Test the AddStatus Class
 *
 * @author Derek Garcia
 */
public class AddStatusTest {

    @Test
    public void test_isSuccess_success() {
        // Given
        AddStatus addStatus = new AddStatus(true, AddStatus.AddMessage.SUCCESS);
        // When

        // Then
        assertTrue("Successful add should be true", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.SUCCESS, addStatus.getAddMessage());
    }

    @Test
    public void test_isSuccess_fail_invalid_location() {
        // Given
        AddStatus addStatus = new AddStatus(false, AddStatus.AddMessage.INVALID_LOCATION);
        // When

        // Then
        assertFalse("Failure to add should be false", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INVALID_LOCATION, addStatus.getAddMessage());
    }

    @Test
    public void test_isSuccess_fail_insufficient_space() {
        // Given
        AddStatus addStatus = new AddStatus(false, AddStatus.AddMessage.INSUFFICIENT_SPACE);
        // When

        // Then
        assertFalse("Failure to add should be false", addStatus.isSuccess());
        assertEquals(AddStatus.AddMessage.INSUFFICIENT_SPACE, addStatus.getAddMessage());
    }

}
