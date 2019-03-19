package se.dennisj.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.dennisj.model.SubstitutionModel;

public class UndoButtonListener implements ActionListener {
    SubstitutionModel SubstitutionModel;

    public UndoButtonListener(SubstitutionModel SubstitutionModel){
        this.SubstitutionModel = SubstitutionModel;
    }

    public void actionPerformed(ActionEvent e) {
        SubstitutionModel.undo();
    }
}
