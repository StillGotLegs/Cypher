package se.dennisj.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import se.dennisj.model.sModel;

public class ButtonRow extends JPanel {

    public ButtonRow(sModel sModel){
        super(new GridLayout(1, 2));

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoButtonListener(sModel));
        add(undoButton);

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(new RedoButtonListener(sModel));
        add(redoButton);
    }
}
