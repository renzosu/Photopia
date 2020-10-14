package model;

import java.util.ArrayList;


public class Album {
    private final ArrayList<Photo> album;

    // EFFECTS: initializes each newly created Album as an empty album
    public Album() {
        album = new ArrayList<>();
    }

    // EFFECTS: returns a list of all the photos in album.
    public ArrayList<Photo> getAlbum() {
        return album;
    }

    // EFFECTS: add a photo to album
    public void addPhoto(Photo photo) {
        this.album.add(photo);
    }

    // EFFECTS: remove a photo from album
    public Boolean removePhoto(Photo photo) {
        if (album.contains(photo)) {
            this.album.remove(photo);
            return true;
        }
        return false;
    }

    // EFFECTS: return photo index
    public Integer getIndex(Photo photo) {
        return album.indexOf(photo);
    }

    // EFFECTS: return next photo index
    public Integer nextIndex(Photo photo) {
        if (album.indexOf(photo) < getAlbum().size() - 1) {
            return album.indexOf(photo) + 1;
        } else {
            return album.indexOf(photo);
        }
    }

    // REQUIRES: index cannot be negative
    // EFFECTS: return previous photo index
    public Integer prevIndex(Photo photo) {
        if (album.indexOf(photo) >= 1) {
            return album.indexOf(photo) - 1;
        } else {
            return 0;
            //return album.indexOf(photo);
        }
    }

    // EFFECTS: show next photo
    public Photo nextPhoto(Photo photo) {
        return album.get(nextIndex(photo));
    }

    // EFFECTS: show previous photo
    public Photo prevPhoto(Photo photo) {
        return album.get(prevIndex(photo));
    }

    // EFFECTS: return number of photos in album
    public Integer sizeAlbum() {
        return album.size();
    }

    // REQUIRES: a photo with same name must be in album
    // EFFECTS: return a photo by name
    public Photo getPhotoByName(String name) {
        Photo p = new Photo(name);
        if (album.contains(p)) {
            return album.get(album.indexOf(p));
        } else {
            return null;
        }
    }
}
