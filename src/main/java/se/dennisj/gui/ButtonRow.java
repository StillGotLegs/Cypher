package se.dennisj.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import se.dennisj.model.SubstitutionModel;

public class ButtonRow extends JPanel {

    public ButtonRow(SubstitutionModel SubstitutionModel){
        super(new GridLayout(1, 2));

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoButtonListener(SubstitutionModel));
        add(undoButton);

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(new RedoButtonListener(SubstitutionModel));
        add(redoButton);
    }
}
