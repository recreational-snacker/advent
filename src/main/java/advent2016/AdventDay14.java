package advent2016;

import util.MD5Util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Deesha Singh on 2016/12/14.
 */
public class AdventDay14 {

    static Map<Integer, String> hashes = new HashMap<>();

    public static void solution1(String input, Boolean part2) {
        int count2 = 0;
        for (int i = 0; ; i++) {
            String hash;
            if (hashes.containsKey(i)) {
                hash = hashes.get(i);
            } else {
                hash = MD5Util.createHexMd5(input + i);
                if (part2) {
                    hash = createStretchedHash(hash);
                }
            }
            count2 = checkMatches(input, count2, i, hash, part2);
            if (count2 == 64) {
                System.out.println("Solution 2: " + i);
                break;
            }
        }
    }

    private static String createStretchedHash(String hash) {
        for (int i = 0; i < 2016; i++) {
            hash = MD5Util.createHexMd5(hash);
        }
        return hash;
    }

    private static int checkMatches(String input, int count, int i, String hash, Boolean part2) {
        Pattern patternLetter = Pattern.compile("(\\w)\\1\\1");
        if (hash.matches("[a-z0-9]*(\\w)\\1\\1[a-z0-9]*")) {
//                System.out.println(hash);
            Matcher matcher = patternLetter.matcher(hash);
            if (matcher.find()) {
//                    System.out.println(matcher.group(0));
                String[] check = matcher.group(1).split("");
                for (int j = i + 1; j < i + 1000; j++) {
                    String hash2;
                    if (hashes.containsKey(j)) {
                        hash2 = hashes.get(j);
                    } else {
                        hash2 = MD5Util.createHexMd5(input + j);
                        if (part2) {
                            hash2 = createStretchedHash(hash2);
                        }
                        hashes.put(j, hash2);
                    }
                    String checkString = check[0] + check[0] + check[0] + check[0] + check[0];
                    if (hash2.contains(checkString)) {
                        count++;
                        System.out.println(count + " : " + i + " : " + hash + " : " + hash2 + " : " + j);
                        break;
                    }
                }
            }
        }
        return count;
    }
}
