package se.dennisj.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.dennisj.model.SubstitutionModel;

public class RedoButtonListener implements ActionListener {
    SubstitutionModel SubstitutionModel;

    public RedoButtonListener(SubstitutionModel SubstitutionModel){
        this.SubstitutionModel = SubstitutionModel;
    }

    public void actionPerformed(ActionEvent e) {
        SubstitutionModel.redo();
    }
}
