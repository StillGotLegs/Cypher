package se.dennisj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import se.dennisj.NpletChecker;

public class sub4 {

    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("C:\\Users\\denni\\Desktop\\data - kopia.txt");
        Scanner scan = new Scanner(file);
        String s = "";

        while (scan.hasNextLine()) {
            s = s.concat(scan.next());
        }

        NpletChecker NpletChecker = new NpletChecker("JCWSVLIVLVGSJJFJCWCVL" , 2);
        NpletChecker.run();

    }
}

