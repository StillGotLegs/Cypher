package gui;

import model.sModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListener implements ActionListener {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String text;
    private sModel sModel;
    private char c, orgLetter;

    public TextFieldListener(sModel sModel, char orgLetter){
        this.sModel = sModel;
        this.orgLetter = orgLetter;
    }

    public void actionPerformed(ActionEvent e) {
        text = e.getActionCommand();
        if(checkAlphabet(text)){
            sModel.changeLetter(orgLetter, c);
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
