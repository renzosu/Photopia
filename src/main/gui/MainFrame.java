package gui;

import model.Album;
import model.Photo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Represents the photo album app implementation
 * Modelled with elements from PhotoAlbumBase, https://github.students.cs.ubc.ca/CPSC210/PhotoAlbumBase.git
 */

public class MainFrame extends JFrame {

//    private Photo photo;
    private Album album = new Album();

    // UI components
    private PhotoPanel photoPanel = new PhotoPanel();

    //private BrowsePanel browsePanel = new BrowsePanel();
    private PhotoFileChooser photoFileChooser = new PhotoFileChooser();

    /**
     * Create and display the main window.
     */
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane()
                .add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(
                                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), photoPanel),
                        BorderLayout.CENTER);

        setTitle("Personalized Photo Album"); //set title of frame

        populateLibrary();

        setSize(800, 600);
        setVisible(true);

    }

    /**
     * Add some test data to the library.
     */
    private void populateLibrary() {

        try {
//            Photo photo1 = new Photo("1");
//            Photo photo2 = new Photo("2");
//            Photo photo = new Photo("1");
//            album.addPhoto(photo1);
//            album.addPhoto(photo2);
//            photo.loadPhoto();

            Album photos = album;
            for (int i = 1; i <= 10; i++) {
                Photo p = new Photo("" + i);
                p.loadPhoto();
                album.addPhoto(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Display an error message box.
     */
    private void errorPopup(String message) {
        JOptionPane.showMessageDialog(this, message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Display a confirmation box.
     */
    private boolean confirmPopup(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Confirm action",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
    }

    /**
     * Cleanly adds a photo to the album.
     * !!!!!!!!!!!!!! not used...
     */
    public void addPhoto(Photo photo) {
        try {
            album.addPhoto(photo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Cleanly removes a photo from the album.
     */
    public void removePhoto(Photo photo) {
        try {
            album.removePhoto(photo);
        } catch (Exception e) {
            System.out.println("Photo cannot be removed");
        }
    }


    /**
     * The panel for displaying a photo and managing its associated info
     */
    public class PhotoPanel extends JPanel {

        private Photo selectedPhoto;
        private Photo displayedPhoto;

        private JPanel imagePanel = new JPanel();
        private JPanel infoPanel = new JPanel();

        public PhotoPanel() {
            super(new BorderLayout());

//            Album album = new Album();
//            Photo photo2 = new Photo("2");
//            Photo photo3 = new Photo("3");
//            album.addPhoto(photo2);
//            album.addPhoto(photo3);

            JScrollPane scrollPane = new JScrollPane(imagePanel);
            scrollPane.setBackground(Color.WHITE);
            add(scrollPane, BorderLayout.CENTER);

            selectPhoto(displayedPhoto);

            //!!!!!!!!!!!!!;
            //selectPhoto(album.getPhotoByName("1"));
            //selectPhoto(album.getPhotos().get(1));
            //photo = album.nextPhoto(photo3);
            //selectPhoto(photo);

            JButton btnRemove = getBtnRemove();
            JButton btnAdd = getBtnAdd();
            JButton btnNext = getBtnNext(album);
            JButton btnPrev = getBtnPrev(album);
            JButton btnSize = getBtnSize(album);

            // Add the components to the panel
            addComponents(btnRemove, btnAdd, btnNext, btnPrev, btnSize);

            // center everything
            for (Component c : infoPanel.getComponents()) {
                ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            infoPanel.setPreferredSize(new Dimension(200, 300));
            add(infoPanel, BorderLayout.WEST);
        }

        private void addComponents(JButton btnRemove, JButton btnAdd,
                                   JButton btnNext, JButton btnPrev, JButton btnSize) {

            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

            infoPanel.add(btnNext);
            infoPanel.add(btnPrev);
            infoPanel.add(btnAdd);
            infoPanel.add(btnRemove);
            infoPanel.add(btnSize);
        }

        private JButton getBtnSize(Album album) {
            JButton btnSize = new JButton("View size of album");
            btnSize.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    album.sizeAlbum();
                    //selectPhoto(photo);
                }
            });
            return btnSize;
        }

        private JButton getBtnPrev(Album album) {
            JButton btnPrev = new JButton("View previous photo");
            btnPrev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayedPhoto = album.prevPhoto(displayedPhoto);
                    selectedPhoto = displayedPhoto;
                    //selectPhoto(photo);
                }
            });
            return btnPrev;
        }

        private JButton getBtnNext(Album album) {
            JButton btnNext = new JButton("View next photo");
            btnNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedPhoto = album.nextPhoto(displayedPhoto);
                    //photoPanel.selectPhoto(photo);
                    //selectPhoto(photo);
                }
            });
            return btnNext;
        }


        private JButton getBtnAdd() {
            JButton btnAdd = new JButton("Add a new photo");
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    photoFileChooser.showAddPhotoDialog();
                }
            });
            return btnAdd;
        }

        private JButton getBtnRemove() {
            JButton btnRemove = new JButton("Remove from album");
            btnRemove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (confirmPopup("Remove photo " + selectedPhoto.getName() + "?")) {
                        removePhoto(selectedPhoto);
                    }
                }
            });
            return btnRemove;
        }

        /**
         * Display the provided photo in the main image area.
         */
        private void selectPhoto(Photo photo) {
            selectedPhoto = photo;

            // Un-focus the description text area
            imagePanel.requestFocusInWindow();

            // Add the image
            //imagePanel.removeAll();
            if (photo != null) {
                imagePanel.add(new JLabel(new ImageIcon(photo.getImage())));
            } else {
                imagePanel.add(new JLabel("No photo selected."));
            }

            repaint();
            revalidate();
        }
    }

    /**
     * The JFileChooser for selecting photo files
     */
    private class PhotoFileChooser extends JFileChooser {

        public PhotoFileChooser() {
            JPanel accessory = new JPanel(new BorderLayout());
            accessory.add(new JLabel("Add to album:"), BorderLayout.NORTH);
            accessory.setPreferredSize(new Dimension(150, 275));
            accessory.setBorder(new EmptyBorder(0, 10, 0, 0));
            setAccessory(accessory);

            setMultiSelectionEnabled(true);
            setAcceptAllFileFilterUsed(false);
            setApproveButtonText("Add Photos");

            setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    }
                    String name = f.getName().toLowerCase();
                    return name.endsWith(".jpg") || name.endsWith(".jpeg");
                }

                @Override
                public String getDescription() {
                    return "JPEG images (*.jpg, *.jpeg)";
                }
            });
        }

        /**
         * Show the dialog to add a photo to the library
         */
        public void showAddPhotoDialog() {

            if (photoFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                for (File file : getSelectedFiles()) {
                    try {
                        Photo photo = new Photo(importPhotoFile(file));
                        photo.loadPhoto();

                        album.addPhoto(photo);
                    } catch (IOException e) {
                        errorPopup("Photo " + file.getPath() + " not found.");
                    }
                }
            }
        }

        /**
         * Given any JPEG image file, returns a name suitable for passing to the
         * Photo constructor.
         */
        private String importPhotoFile(File file) throws IOException {
            String name = file.getName().substring(0,
                    file.getName().lastIndexOf('.'));

            // If the file isn't in the photos folder with the expected
            // filename, copy it there
            if (!file.getCanonicalPath().equals(
                    new File("photos" + System.getProperty("file.separator")
                            + name + ".jpg").getCanonicalPath())) {

                // append a number that depends on the whole path, to reduce
                // collisions
                name += file.getCanonicalPath().hashCode() % 5000 + 5000;
                File dest = new File("photos"
                        + System.getProperty("file.separator") + name + ".jpg");

                if (!dest.exists()) {
                    InputStream in = new FileInputStream(file);
                    OutputStream out = new FileOutputStream(dest);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                }
            }
            return name;
        }
    }
}
