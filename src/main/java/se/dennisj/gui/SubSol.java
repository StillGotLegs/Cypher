package se.dennisj.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import se.dennisj.model.SubstitutionModel;



public class SubSol extends JFrame  {

    public SubSol() throws FileNotFoundException {
        super("Substitution Solver");
        FileScanner fs = new FileScanner();
        String data = fs.getString();
        SubstitutionModel SubstitutionModel = new SubstitutionModel(data.toUpperCase());
        setVisible(true);
        StyledDocument doc = new DefaultStyledDocument();
        SubJTextPane textArea = new SubJTextPane(doc);
        textArea.setPreferredSize(new Dimension(750, 430));
        textArea.setFont(new Font("Courier New", Font.PLAIN, 40));
        textArea.setText(data);
        textArea.setEditable(false);
        add(NORTH, textArea);
        textSquare textSquare = new textSquare(SubstitutionModel);
        add(SOUTH, new ButtonRow(SubstitutionModel));
        ModelObserver mo = new ModelObserver(textArea);
        SubstitutionModel.addObserver(mo);
        add(CENTER, textSquare);
        pack();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) throws FileNotFoundException {
        new SubSol();
    }
}
