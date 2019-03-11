package gui;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import model.sModel;

public class ModelObserver implements Observer {
    private JTextPane textArea;

    public ModelObserver(JTextPane textArea){
        this.textArea = textArea;
    }

    public void update(Observable o, Object arg) {
        textArea.setText(((sModel)o).getData());
    }
}
