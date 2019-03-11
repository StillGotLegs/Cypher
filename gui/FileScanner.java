package gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {


    public FileScanner(){
    }

    public String getString() throws FileNotFoundException {
        String s = "";
        JFileChooser fileChooser = new JFileChooser("users.denni.desktop");
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(fileChooser);
        if (option == JFileChooser.APPROVE_OPTION) {
           s = scanFile(fileChooser.getSelectedFile());
        }
        return s;
    }

    private String scanFile(File file) throws FileNotFoundException {
        String s = "";
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            s = s.concat(scan.next());
        }
        return s.toUpperCase();
    }

}
