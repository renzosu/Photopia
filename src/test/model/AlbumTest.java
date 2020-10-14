package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AlbumTest {
    Album a1;
    Photo p1;
    Photo p2;
    Photo p3;
    Photo p4;
    ArrayList<Photo> album;

    @BeforeEach
    void runBefore() {
        album = new ArrayList<>();
        a1 = new Album();
        p1 = new Photo("Apples");
        p2 = new Photo("Bananas");
        p3 = new Photo("Cherries");
        album.add(p1);
        album.add(p2);
        album.add(p3);
        album.remove(p3);
        a1.addPhoto(p1);
        a1.addPhoto(p2);
        a1.addPhoto(p3);
        a1.removePhoto(p3);
        a1.addPhoto(p3);
    }

    @Test
    void getPhoto() {

        assertEquals(p1, album.get(album.indexOf(p1)));
    }

    @Test
    void getPhotos() {
        ArrayList<Photo> album2 = new ArrayList<>();
        album2.add(p1);
        album2.add(p2);
        album2.add(p3);
        assertEquals(album2, a1.getAlbum());
    }


    @Test
    void testGetIndex() {
        assertEquals(0, album.indexOf(p1));
        assertEquals(1, a1.getIndex(p2));
    }

    @Test
    void testAddPhoto() {
       assertTrue(album.contains(p1));
    }

    @Test
    void testRemovePhoto() {
        assertFalse(album.contains(p3));
        assertTrue(album.contains(p1));
        assertEquals(true, a1.removePhoto(p3));
        assertEquals(false, a1.removePhoto(p4));

    }

    @Test
    void testNextPhoto() {
        assertEquals(p2, a1.nextPhoto(p1));
        assertEquals(p3, a1.nextPhoto(p2));
        assertEquals(p3, a1.nextPhoto(p3));
    }

    @Test
    void testPrevPhoto() {
        assertEquals(p1, a1.prevPhoto(p1));
        assertEquals(p1, a1.prevPhoto(p2));
        assertEquals(p2, a1.prevPhoto(p3));
    }

    @Test
    void testSizeAlbum() {
        assertEquals(3, a1.sizeAlbum());
    }

    @Test
    void testGetPhotoByName() {
        assertEquals(p1, album.get(album.indexOf(p1)));
        assertEquals(null, a1.getPhotoByName("Cake"));
        assertEquals(p1, a1.getPhotoByName("Apples"));
    }
}