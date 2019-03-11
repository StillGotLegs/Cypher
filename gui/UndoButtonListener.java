package gui;

import model.sModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoButtonListener implements ActionListener {
    sModel sModel;

    public UndoButtonListener(sModel sModel){
        this.sModel = sModel;
    }

    public void actionPerformed(ActionEvent e) {
        sModel.undo();
    }
}
