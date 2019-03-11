import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sub4 {

    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("C:\\Users\\denni\\Desktop\\data - kopia.txt");
        Scanner scan = new Scanner(file);
        String s = "";

        while (scan.hasNextLine()) {
            s = s.concat(scan.next());
        }

        NpletChecker tripletChecker = new NpletChecker("JCWSVLIVLVGSJJFJCWCVL" , 2);
        tripletChecker.run();

    }
}

