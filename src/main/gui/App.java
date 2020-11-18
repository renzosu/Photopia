package gui;

import javax.swing.*;

/**
 * Represents the main window that opens the photo album App
 * Modelled based on PhotoAlbumBase, https://github.students.cs.ubc.ca/CPSC210/PhotoAlbumBase.git
 */

public class App {
    /**
     * Runs the photo album App
     */
    public static void main(String[] args) {

        // Enable a pre-set native look & feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start the main window
        new MainFrame();
    }
}
