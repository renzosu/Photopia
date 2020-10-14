package ui;

import model.Album;
import model.Photo;

import java.util.Scanner;

/**
 * Photo Album application
 */

public class PhotoAlbumApp {
    private Album album;
    private Photo photo1;
    private Photo photo2;
    private Photo photo3;
    Photo displayedPhoto;
    private Scanner input;

    // EFFECTS: runs the photoAlbum application
    public PhotoAlbumApp() {
        runPhotoAlbum();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPhotoAlbum() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye! Come look at more photos next time.");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("n")) {
            doNext();
        } else if (command.equals("p")) {
            doPrevious();
        } else if (command.equals("s")) {
            doSize();
        } else if (command.equals("a")) {
            doAdd();
        } else if (command.equals("r")) {
            doRemove();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // MODIFIES: this
    // EFFECTS: initializes photos
    private void init() {
        photo1 = new Photo("Apples");
        photo2 = new Photo("Bananas");
        photo3 = new Photo("Cherries");
        album = new Album();
        album.addPhoto(photo1);
        album.addPhoto(photo2);
        album.addPhoto(photo3);
        displayedPhoto = photo1;
        input = new Scanner(System.in);
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tn -> next");
        System.out.println("\tp -> previous");
        System.out.println("\ts -> size");
        System.out.println("\ta -> add");
        System.out.println("\tr -> remove");
        System.out.println("\tq -> quit");
    }


    // MODIFIES: this
    // EFFECTS: conduct a displays of next photo
    private void doNext() {
        if (album.sizeAlbum() >= 1) {
            System.out.print("Displaying next photo");

            displayedPhoto = album.nextPhoto(displayedPhoto);
            System.out.println("\n" + displayedPhoto.getName());

        } else {
            System.out.print("There are no photos. Please add a photo first.");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a display of previous photo
    private void doPrevious() {
        if (album.sizeAlbum() >= 1) {
            System.out.print("Displaying previous photo");

            displayedPhoto = album.prevPhoto(displayedPhoto);
            System.out.println("\n" + displayedPhoto.getName());

        } else {
            System.out.print("There are no photos. Please add a photo first.");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a return of number of photos in album
    private void doSize() {
        System.out.print("There are " + album.sizeAlbum() + " photos in the album");
    }

    // MODIFIES: this
    // EFFECTS: conduct addition of a photo to album
    private void doAdd() {
        System.out.print("Adding a new photo. Enter new photo name: ");
        String newName = input.next();

        if (newName.length() >= 1) {
            Photo photo3 = new Photo(newName);
            album.addPhoto(photo3);
        }
    }

    // MODIFIES: this
    // EFFECTS: conduct removal of a photo from album
    private void doRemove() {
        System.out.print("Removing an old photo. Enter old photo name: ");
        String oldName = input.next();

        if (album.removePhoto(album.getPhotoByName(oldName))) {
            System.out.print("Successfully removed photo from album.");
        } else {
            System.out.print("Photo does not exist in album.");
        }
    }
}