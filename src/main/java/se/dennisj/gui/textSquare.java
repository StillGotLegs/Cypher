package se.dennisj.gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

import se.dennisj.model.SubstitutionModel;

public class textSquare extends JPanel {
    private Map<Character, SubSolTextField> textFields = new TreeMap<>();

    public textSquare(SubstitutionModel SubstitutionModel){
        super(new GridLayout(7, 8, 2, 2));

        for (char ch = 'A'; ch <= 'Z'; ch++){
            Label label = new Label(ch + " =");
            SubSolTextField textField = new SubSolTextField(ch, SubstitutionModel);
            textFields.put(ch, textField);
            textField.setSize(20, 20);
            add(new charFieldPair(label, textField));
        }

        TextFieldObserver tfo = new TextFieldObserver(textFields, SubstitutionModel);
        SubstitutionModel.addObserver(tfo);
    }
}
