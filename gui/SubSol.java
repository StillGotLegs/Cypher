package gui;

import model.sModel;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.io.FileNotFoundException;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.*;



public class SubSol extends JFrame  {

    public SubSol() throws FileNotFoundException {
        super("Substitution Solver");
        FileScanner fs = new FileScanner();
        String data = fs.getString();
        sModel sModel = new sModel(data);
        setVisible(true);
        StyledDocument doc = new DefaultStyledDocument();
        SubJTextPane textArea = new SubJTextPane(doc);
        textArea.setPreferredSize(new Dimension(750, 430));
        textArea.setFont(new Font("Courier New", Font.PLAIN, 40));
        textArea.setText(data);
        textArea.setEditable(false);
        add(NORTH, textArea);
        textSquare textSquare = new textSquare(sModel);
        add(SOUTH, new ButtonRow(sModel));
        ModelObserver mo = new ModelObserver(textArea);
        sModel.addObserver(mo);
        add(CENTER, textSquare);
        pack();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) throws FileNotFoundException {
        new SubSol();
    }
}
