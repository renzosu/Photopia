package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for the Photo class
 */
public class PhotoTest {
    Photo p1;
    Photo p2;
    Photo p3;

    @BeforeEach
    void runBefore() {
        p1 = new Photo("Apples");
        p2 = new Photo("Bananas");
        p3 = new Photo("Cherries");
    }

    @Test
    void testConstructor() {
        assertEquals("Apples", p1.getName());
    }

    @Test
    void testGetName() {
        assertEquals(p1.getName(), "Apples");
        assertEquals(p2.getName(), "Bananas");
        assertEquals(p3.getName(), "Cherries");
    }

    @Test
    void testEquals() {
        Photo p = new Photo("Apples");
        assertTrue(p1.equals(p));
        assertFalse(p2.equals(p));
    }

    @Test
    void testHashCode() {
        assertEquals(1967772824, p1.hashCode());
        assertEquals(1327314349, p2.hashCode());
        assertEquals(1615603766, p3.hashCode());
    }



//    @Test
//    void testToJson() {
//        JSONObject json = new JSONObject();
//        String name = new String();
//
//        json.put("Apples", name);
//        assertEquals(json, p1.toJson());
//    }
}



