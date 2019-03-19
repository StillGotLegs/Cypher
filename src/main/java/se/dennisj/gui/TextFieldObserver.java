package se.dennisj.gui;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import se.dennisj.model.SubstitutionModel;

public class TextFieldObserver implements Observer {
    private Map<Character, SubSolTextField> textFields;
    private Map<Character, Character> changes;
    private Map<Character, Double> thisFrequency;
    private Map<Character, Double> standardFrequency;

    public TextFieldObserver(Map<Character, SubSolTextField> textFields, SubstitutionModel SubstitutionModel){
        this.textFields = textFields;
        changes = SubstitutionModel.getChanges();
        thisFrequency = SubstitutionModel.getThisFrequency();
        standardFrequency = SubstitutionModel.getStandardFrequency();

    }

    public void update(Observable o, Object arg) {

        SwingUtilities.invokeLater(() -> {
                for(Map.Entry<Character, Character> entry : changes.entrySet()) {

                    SubSolTextField tf = textFields.get(entry.getKey());
                    tf.setText(entry.getValue().toString());
                    if(entry.getValue() != '\u0000') {
                        tf.setToolTipText(entry.getKey() + ": " + String.format("%.1f", thisFrequency.get(entry.getKey())) + " | "
                                + entry.getValue().toString().toLowerCase() + ": " + String.format("%.1f", standardFrequency.get(entry.getValue().toString().toUpperCase().charAt(0))));
                    } else {
                        tf.setToolTipText(null);
                    }

                }
        });
    }
}
