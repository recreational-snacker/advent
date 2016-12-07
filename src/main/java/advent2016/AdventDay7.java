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
        String[] matcher = line.split("\\[");
        for (String s : matcher) {
            if (s.contains("]")) {
                String t = s.split("\\]")[0];
                if (t.matches("[a-z]*([a-z])([a-z]((?!\\1)))\\2\\1[a-z]*")) {
                    return;
                }
            }
        }
        for (String s : matcher) {
            if (s.contains("]")) {
                s = s.split("\\]")[1];
            }
            if (s.matches("[a-z]*([a-z])([a-z]((?!\\1)))\\2\\1[a-z]*")) {
                if (!validIPs.contains(line)) {
                    validIPs.add(line);
                }
            }
        }
    }

    public static List<String> solution(File file) {
        List<String> validIPs = new ArrayList<>();
        List<String> validIPs2 = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                solution1(line, validIPs);
                solution2(line, validIPs2);
            }
        } catch (Exception e) {

        }
        System.out.println("Solution 1: " + validIPs.size());
        System.out.println("Solution 2: " + validIPs2.size());
        return validIPs;
    }

    private static void solution2(String line, List<String> validIPs2) {
        String[] matcher = line.split("\\[");
        for (String s : matcher) {
            if (s.contains("]")) {
                String t = s.split("\\]")[0];
                if (!t.matches("[a-z]*([a-z])([a-z])((?!\\2))\\1[a-z]*")) {
                    return;
                } else {
                    Pattern pattern = Pattern.compile("[a-z]*([a-z])([a-z])((?!\\2))\\1[a-z]*");
                    Matcher matcher1 = pattern.matcher(t);
                    if (matcher1.find()) {
                        for (int i = 0; i < matcher1.end(); i++) {
                            String[] group = matcher1.group(i).split("");
                            String section = group[1] + group[0] + group[1];
                            for (String e : matcher) {
                                if (e.contains("]")) {
                                    e = e.split("\\]")[1];
                                }
                                if (e.contains(section)) {
                                    if (!validIPs2.contains(line)) {
                                        validIPs2.add(line);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
