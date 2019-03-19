package se.dennisj.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.ToolTipManager;

import se.dennisj.model.SubstitutionModel;


public class SubSolTextField extends JTextField {
    private char label;
    private SubstitutionModel SubstitutionModel;
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public SubSolTextField(char label, SubstitutionModel SubstitutionModel){
        super();
        this.label = label;
        this.SubstitutionModel = SubstitutionModel;
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);

        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (getText().length() >= 1 ) {
                    e.consume();
                }
                update(e);
            }
        });
    }

    public void update(KeyEvent e){
        char c = e.getKeyChar();

        if(checkAlphabet(c)){
            SubstitutionModel.changeLetter(label, c);
        } else {
            SubstitutionModel.changeLetter(label, '\u0000');
        }
    }

    private boolean checkAlphabet(char c){
        for(Character ch : alphabet){
            if(ch.equals(c)){
                return true;
            }
        }

        return false;
    }
}


