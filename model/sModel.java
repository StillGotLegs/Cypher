package model;

import java.util.*;

public class sModel extends Observable {

    private String data, orgData;
    private Map<Character, Character> changes = new TreeMap<>();
    private LinkedList<ChangeCommand> commands = new LinkedList<>();
    private LinkedList<ChangeCommand> redoCommands = new LinkedList<>();
    private FrequencyAnalyser fa;
    private Map<Character, Double> thisFrequency;
    private Map<Character, Double> standardFrequency;
    private Double[] standardFrequencies = {8.1 , 1.6, 3.2, 3.7, 12.3, 2.3, 1.6, 5.1, 7.2, 0.1, 0.5, 4.0, 2.3, 7.2, 7.9,
            2.3, 0.2, 6.0, 6.6, 9.6, 3.1, 0.9, 2.0, 0.2, 1.9, 0.1};

    public sModel(String data){
        this.data = data.toUpperCase();
        orgData = data;
        fa = new FrequencyAnalyser(data);
        thisFrequency = fa.getFrequency();
        createStandardFrequencyMap();
        execute();
    }

    public String getData(){
        return data;
    }

    public Map<Character, Character> getChanges(){
        return changes;
    }

    public Map<Character, Double> getThisFrequency(){
        return thisFrequency;
    }

    public Map<Character, Double> getStandardFrequency(){
        return standardFrequency;
    }

    public void changeLetter(char orgLetter, char newLetter){
        if(commands.size() >= 50){
            commands.removeLast();
        }

        ChangeCommand command = new ChangeCommand(changes, orgLetter, newLetter);
        command.execute();
        commands.addFirst(command);
        redoCommands.clear();
        execute();
    }

    public void undo(){
        if(redoCommands.size() >= 50){
            redoCommands.removeLast();
        }

        if(commands.size() > 0) {
            ChangeCommand cc = commands.pop();
            cc.undo();
            redoCommands.addFirst(cc);
            execute();
        }
    }

    public void redo(){
        if(redoCommands.size() > 0) {
            ChangeCommand command = redoCommands.pop();
            command.undo();
            commands.addFirst(command);
            execute();
        }
    }

    private void execute(){
        data = orgData;
        for(Map.Entry<Character, Character> entry : changes.entrySet() ){
            if(entry.getValue() != '\u0000') {
                data = data.replace(entry.getKey(), entry.getValue());
            }
        }

        setChanged();
        notifyObservers();
    }

    private void createStandardFrequencyMap(){
        int i = 0;
        standardFrequency = new TreeMap<>();

        for(char ch = 'A'; ch <= 'Z'; ch++){
            standardFrequency.put(ch, standardFrequencies[i]);
            i++;
        }
        return;
    }
}
