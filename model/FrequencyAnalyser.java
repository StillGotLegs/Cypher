package model;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyAnalyser {
    private String input;
    private Map<Character, Integer> data = new TreeMap<>();
    private Map<Character, Double> output = new TreeMap<>();

    public FrequencyAnalyser(String input){
        this.input = input;
    }

    public Map<Character, Double> getFrequency(){
        count();
        for(Map.Entry<Character, Integer> entry : data.entrySet() ){
            output.put(entry.getKey(), ((double) entry.getValue() / input.length()) * 100);
        }

        return output;
    }

    private void count(){
        for(int i = 0; i < input.length(); i++){

            char key = input.charAt(i);
            int prev = data.containsKey(key) ? data.get(key) : 0;
            data.put(key, prev + 1);
        }
    }
}
