package gui;

import model.sModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.function.BooleanSupplier;

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
