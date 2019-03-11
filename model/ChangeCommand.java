package model;

import java.util.Map;

public class ChangeCommand {
    Map<Character, Character> changes;
    char orgLetter, newLetter ,lastLetter;

    public ChangeCommand(Map<Character, Character> changes, char orgLetter, char newLetter){
        this.changes = changes;
        this.orgLetter = orgLetter;
        this.newLetter = newLetter;
        if(changes.get(orgLetter) != null){
            this.lastLetter = changes.get(orgLetter);
        }
    }

    public void execute(){
        changes.put(Character.toUpperCase(orgLetter), Character.toLowerCase(newLetter));
    }

    public void undo(){
        changes.put(Character.toUpperCase(orgLetter), Character.toLowerCase(lastLetter));
        char temp = newLetter;
        newLetter = lastLetter;
        lastLetter = temp;
    }
}
