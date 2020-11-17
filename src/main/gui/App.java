package gui;

import javax.swing.*;

public class App {

    /**
     * Represents the main window that opens the Photo album app
     * Modelled based on PhotoAlbumBase
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
