package gui;

import model.sModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedoButtonListener implements ActionListener {
    sModel sModel;

    public RedoButtonListener(sModel sModel){
        this.sModel = sModel;
    }

    public void actionPerformed(ActionEvent e) {
        sModel.redo();
    }
}
