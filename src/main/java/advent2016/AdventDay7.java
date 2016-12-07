package advent2016;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DeeshaSingh on 2016-12-07.
 */
public class AdventDay7 {

    public static void solution1(String line, List<String> validIPs) {
        if (line.matches("[a-z]*\\[[a-z]*([a-z])([a-z]((?!\\1)))\\2\\1[a-z]*\\][a-z]*")) {
            System.out.println("Does match, not valid: " + line);
            //Do nothing
        }
//            String matcher = ip.split("\\[")[0];
//            if (matcher.matches("^[a-z]*([a-z])([a-z]((?!\\1)))\\2\\1[a-z]*$")) {
//                System.out.println("Does match, is valid");
//                validIPs.add(ip);
//            } else {
//                matcher = ip.split("\\]")[1];
//                if (matcher.matches("^[a-z]*([a-z])([a-z]((?!\\1)))\\2\\1[a-z]*$")) {
//                    System.out.println("Does match, is valid");
//                    validIPs.add(ip);
//                }
//            }
    }


    public static void solution() {
        List<String> validIPs = new ArrayList<>();
        try {
            File inFile = new File("Day7.txt");
            Scanner sc = new Scanner(inFile);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                solution1(line, validIPs);
            }
        } catch (Exception e) {

        }
    }
}
