
import java.util.Map;
import java.util.TreeMap;

public class NpletChecker {

    private String s;
    private int tup;
    private Map <String, Integer> data;

    public NpletChecker(String s, int tup){
        this.s = s;
        this.tup = tup;
    }

    public void run(){
        calcFrec();
        printMap();
    }

    private void calcFrec(){
        data = new TreeMap();
        for(int i = 0; i < s.length() - (tup - 1); i++){

            String key = "";
            for(int j = 0; j < tup; j++){
                key += s.charAt(i + j);
            }
            int prev = data.containsKey(key) ? data.get(key) : 0;
            data.put(key, prev + 1);

        }
    }

    private void printMap(){
        for(Map.Entry<String, Integer> entry : data.entrySet() ){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " ; " + entry.getValue());
            }
        }
    }

}
