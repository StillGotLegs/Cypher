package se.dennisj.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextPane;

import se.dennisj.model.sModel;

public class ModelObserver implements Observer {
    private JTextPane textArea;

    public ModelObserver(JTextPane textArea){
        this.textArea = textArea;
    }

    public void update(Observable o, Object arg) {
        textArea.setText(((sModel)o).getData());
    }
}
