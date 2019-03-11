package gui;

import model.sModel;
import javax.swing.*;
import java.awt.*;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

public class textSquare extends JPanel {
    private Map<Character, SubSolTextField> textFields = new TreeMap<>();

    public textSquare(sModel sModel){
        super(new GridLayout(7, 8, 2, 2));

        for (char ch = 'A'; ch <= 'Z'; ch++){
            Label label = new Label(ch + " =");
            SubSolTextField textField = new SubSolTextField(ch, sModel);
            textFields.put(ch, textField);
            textField.setSize(20, 20);
            add(new charFieldPair(label, textField));
        }

        TextFieldObserver tfo = new TextFieldObserver(textFields, sModel);
        sModel.addObserver(tfo);
    }
}
