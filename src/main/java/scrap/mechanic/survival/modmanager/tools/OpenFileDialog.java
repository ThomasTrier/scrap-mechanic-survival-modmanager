package scrap.mechanic.survival.modmanager.tools;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;

public class OpenFileDialog {

    public String openFileDialog(String heading, String path) {
        final JFileChooser chooser = new JFileChooser(heading);
        chooser.setDialogTitle(heading);
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (path != null) {
            final File file = new File(path);
            if (file.exists()) {
                chooser.setCurrentDirectory(file);
            }
        }

        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                    final File f = (File) e.getNewValue();
                }
            }
        });

        chooser.setVisible(true);
        final int result = chooser.showOpenDialog(null);
        if (result == 0) {
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }

    public String openDirectoryDialog(String heading, String path) {
        final JFileChooser chooser = new JFileChooser(heading);
        chooser.setDialogTitle(heading);
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (path != null) {
            final File file = new File(path);
            if (file.exists()) {
                chooser.setCurrentDirectory(file);
            }
        }

        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                    final File f = (File) e.getNewValue();
                }
            }
        });

        chooser.setVisible(true);
        final int result = chooser.showOpenDialog(null);
        if (result == 0) {
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }

    public String askForScrapRoot() {
        final JFileChooser chooser = new JFileChooser("Select Scrap Mechanics directory!");
        chooser.setDialogTitle("Select Scrap Mechanics directory");
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        final File file = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Scrap Mechanic");
        if (file.exists()) {
            chooser.setCurrentDirectory(file);
        }

        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                    final File f = (File) e.getNewValue();
                }
            }
        });

        chooser.setVisible(true);
        final int result = chooser.showOpenDialog(null);
        if (result == 0) {
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }

    public String askForIconFolder() {
        final JFileChooser chooser = new JFileChooser("Where to find the new icons?");
        chooser.setDialogTitle("Where to find the new icons?");
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
                    final File f = (File) e.getNewValue();
                }
            }
        });

        chooser.setVisible(true);
        final int result = chooser.showOpenDialog(null);
        if (result == 0) {
            return chooser.getSelectedFile().getPath();
        }
        return null;
    }
}
