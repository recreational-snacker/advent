package advent2015;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay5 {

    public static Integer solution(String input) {
        String[] list = input.split("\n");
        Integer validWords = 0;
        for (String word : list) {
            if (word.contains("ab")||word.contains("cd")||word.contains("pq")||word.contains("xy")) {
                continue;
            }
            String[] chars = word.split("");
            Integer countVowels = 0;
            Boolean doubleLetter = false;
            for (int i = 0; i<chars.length;i++) {
                if (isaVowel(chars[i])) {
                    countVowels++;
                }
                if (i<chars.length-1 && chars[i].equalsIgnoreCase(chars[i+1])) {
                    doubleLetter = true;
                }
            }
            if (countVowels>=3 && doubleLetter) {
                validWords++;
            }
        }
        return validWords;
    }

    private static boolean isaVowel(String c) {
        return c.equalsIgnoreCase("a")||c.equalsIgnoreCase("e")||c.equalsIgnoreCase("i")||c.equalsIgnoreCase("o")||c.equalsIgnoreCase("u");
    }

    public static Integer solution2(String input) {
        String[] list = input.split("\n");
        Integer validWords = 0;
        for (String word : list) {
            String[] chars = word.split("");
            Integer seqRepeat = 0;
            Boolean doubleLetter = false;
            for (int i = 0; i<chars.length;i++) {
                if (i<chars.length-1) {
                    String check = chars[i]+chars[i+1];
                    String checkString = word.substring(i+2);
                    if (checkString.contains(check)) {
                        seqRepeat++;
                    }
                }
                if (i<chars.length-2 && chars[i].equalsIgnoreCase(chars[i+2])) {
                    doubleLetter = true;
                }
            }
            if (seqRepeat>=1 && doubleLetter) {
                validWords++;
            }
        }
        return validWords;
    }
}
