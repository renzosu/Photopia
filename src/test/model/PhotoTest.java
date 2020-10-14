package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhotoTest {
    Photo p1;
    Photo p2;
    Photo p3;

    @BeforeEach
    void runBefore() {
        p1 = new Photo("apples");
        p2 = new Photo("bananas");
        p3 = new Photo("cherries");
    }

    @Test
    void testConstructor() {
        assertEquals("apples", p1.getName());
    }

    @Test
    void testGetName() {
        assertEquals(p1.getName(), "apples");
        assertEquals(p2.getName(), "bananas");
        assertEquals(p3.getName(), "cherries");
    }

    @Test
    void testEquals() {
        Photo p = new Photo("apples");
        assertTrue(p1.equals(p));
        assertFalse(p2.equals(p));
    }
}



