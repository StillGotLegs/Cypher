package se.dennisj.gui;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class charFieldPair extends JPanel{

    public charFieldPair(Label label, SubSolTextField subSolTextField){
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(boxLayout);
        label.setPreferredSize(new Dimension(25, 20));
        add(label);
        add(subSolTextField);
        setSize(30, 20);
    }
}
