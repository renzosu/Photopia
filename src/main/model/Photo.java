package model;

/**
 * Represents a photo having a name.
 */

public class Photo {
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
        Photo p = (Photo) o;
        return p.name.equals(this.name);
    }


    // TODO: possible feature to add
    //public String getId() {
    //    return id;
    //}

    // TODO: necessary feature to add
    //instance var for source
    //string -> file path for source
}
