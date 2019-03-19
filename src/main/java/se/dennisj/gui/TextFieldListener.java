package se.dennisj.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.dennisj.model.SubstitutionModel;

public class TextFieldListener implements ActionListener {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String text;
    private SubstitutionModel SubstitutionModel;
    private char c, orgLetter;

    public TextFieldListener(SubstitutionModel SubstitutionModel, char orgLetter){
        this.SubstitutionModel = SubstitutionModel;
        this.orgLetter = orgLetter;
    }

    public void actionPerformed(ActionEvent e) {
        text = e.getActionCommand();
        if(checkAlphabet(text)){
            SubstitutionModel.changeLetter(orgLetter, c);
        }
    }

    private boolean checkAlphabet(String s){
        if(s.length() != 1){
            return false;
        }
        c = s.charAt(0);

        for(Character ch : alphabet){
            if(ch.equals(c)){
                return true;
            }
        }

        return false;
    }
}
