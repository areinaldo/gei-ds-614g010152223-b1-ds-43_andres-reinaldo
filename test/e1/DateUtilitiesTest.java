package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilitiesTest {

    @Test
    void isLeap() {
        assertFalse(DataUtilities.isLeap(2022));
        assertFalse(DataUtilities.isLeap(2023));
        assertFalse(DataUtilities.isLeap(1900));
        assertTrue(DataUtilities.isLeap(2020));
        assertTrue(DataUtilities.isLeap(2000));
    }

    @Test
    void numberOfDays() {
        assertEquals(31, DataUtilities.numberOfDays(1, 2022));
        assertEquals(28, DataUtilities.numberOfDays(2, 2022));
        assertEquals(31, DataUtilities.numberOfDays(3, 2022));
        assertEquals(30, DataUtilities.numberOfDays(4, 2022));
        assertEquals(31, DataUtilities.numberOfDays(5, 2022));
        assertEquals(30, DataUtilities.numberOfDays(6, 2022));
        assertEquals(31, DataUtilities.numberOfDays(7, 2022));
        assertEquals(31, DataUtilities.numberOfDays(8, 2022));
        assertEquals(30, DataUtilities.numberOfDays(9, 2022));
        assertEquals(31, DataUtilities.numberOfDays(10, 2022));
        assertEquals(30, DataUtilities.numberOfDays(11, 2022));
        assertEquals(31, DataUtilities.numberOfDays(12, 2022));

        assertEquals(29, DataUtilities.numberOfDays(2, 2020));
        assertThrows(IllegalArgumentException.class, () -> DataUtilities.numberOfDays(13, 2020));
    }

    @Test
    void convertToISODate() {
        assertEquals("2022-01-01", DataUtilities.convertToISODate("January 01, 2022"));
        assertEquals("2022-02-02", DataUtilities.convertToISODate("February 02, 2022"));
        assertEquals("2022-03-03", DataUtilities.convertToISODate("March 03, 2022"));
        assertEquals("2022-04-04", DataUtilities.convertToISODate("April 04, 2022"));
        assertEquals("2022-05-05", DataUtilities.convertToISODate("May 05, 2022"));
        assertEquals("2022-06-06", DataUtilities.convertToISODate("June 06, 2022"));
        assertEquals("2022-07-07", DataUtilities.convertToISODate("July 07, 2022")); //  Saint Fermin
        assertEquals("2022-08-08", DataUtilities.convertToISODate("August 08, 2022"));
        assertEquals("2022-09-09", DataUtilities.convertToISODate("September 09, 2022"));
        assertEquals("2022-10-10", DataUtilities.convertToISODate("October 10, 2022"));
        assertEquals("2022-11-11", DataUtilities.convertToISODate("November 11, 2022"));
        assertEquals("2022-12-12", DataUtilities.convertToISODate("December 12, 2022"));
    }

    @Test
    void checkISODate() {
        assertTrue(DataUtilities.checkISODate("2022-07-07"));
        assertTrue(DataUtilities.checkISODate("2020-02-29"));
        assertTrue(DataUtilities.checkISODate("2000-10-14"));

        assertFalse(DataUtilities.checkISODate("2022-13-01"));
        assertFalse(DataUtilities.checkISODate("2022-02-29"));
        assertFalse(DataUtilities.checkISODate("2022-07-35"));
    }
}
