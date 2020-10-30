package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

/**
 * Represents a photo having a name.
 */

public class Photo implements Writable {
    private final String name;

    // REQUIRES: photoName has a non-zero length
    // EFFECTS: name is set to photoName
    public Photo(String photoName) {
        name = photoName;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
////        if (o == null || getClass() != o.getClass()) {
////            return false;
//        }
        Photo photo = (Photo) o;
        return name.equals(photo.name);
    }

//    public boolean equals(Object o) {
//        Photo p = (Photo) o;
//        return p.name.equals(this.name);
//    }

    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }


    // TODO: possible feature to add
    //public String getId() {
    //    return id;
    //}

    // TODO: necessary feature to add
    //instance var for source
    //string -> file path for source


    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        return json;
    }
}
