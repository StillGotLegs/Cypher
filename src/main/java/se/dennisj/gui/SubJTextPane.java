package se.dennisj.gui;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class SubJTextPane extends JTextPane {
    private StyledDocument doc;
    public SubJTextPane(StyledDocument doc){
        super(doc);
        this.doc = doc;
    }

    @Override
    public void setText(String s){
        super.setText(s);
        for (int i = 0; i < getDocument().getLength(); i++){
            SimpleAttributeSet set = new SimpleAttributeSet();
            if(s.charAt(i) == Character.toLowerCase(s.charAt(i))) {
                StyleConstants.setBackground(set, new Color(0, 204, 0));
            }
            doc.setCharacterAttributes(i, 1, set, true);
        }

    }
}
