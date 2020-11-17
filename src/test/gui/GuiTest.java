package gui;

import static org.junit.jupiter.api.Assertions.*;

import model.Album;
import model.Photo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Tests for the GUI
 */
public class GuiTest {

    Album album;
    Photo p1;

    MainFrame gui;
    private static final String JSON_STORE = "./data/workroom.json";

    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);

    @BeforeEach
    void runBefore() {
        album = new Album();
        p1 = new Photo("1");
    }

    @Test
    void testJsonReader() throws IOException {
        //album.addPhoto(p1);
        Album alb = jsonReader.read();
        ArrayList<Photo> album = alb.getPhotos();
        assertEquals(6, album.size());
        //assertEquals("Apples", album.get(0));
        //assertEquals("Bananas",album.get(1));
        //assertEquals("Bananas",album.get(2));
        //assertEquals("Bananas",album.get(3));
        //assertEquals("Bananas",album.get(4));
        //assertEquals("Bananas",album.get(5));

//        assertEquals(album, jsonReader.read());
//        assertEquals(MainFrame.PhotoPanel.)
//                MainFrame.getB
    }

}
