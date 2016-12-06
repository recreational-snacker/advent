package advent2016;

import util.MapUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Deesha Singh on 2016/12/06.
 */
public class AdventDay6 {
    public static String solution1(String input, String lessOrMore) {
        String[] array = input.split("\n");
        String code = "";
        Map<String, Integer> countLetters = new HashMap<>();
        for (int j = 0; j<array[0].length(); j++) {
            for (int i = 0; i < array.length; i++) {
                String[] word = array[i].split("");
                if (countLetters.containsKey(word[j])) {
                    Integer count = countLetters.get(word[j]);
                    countLetters.put(word[j], count + 1);
                } else {
                    countLetters.put(word[j], 1);
                }
            }
            countLetters = MapUtil.sortByValue(countLetters, lessOrMore);
            Set s = countLetters.entrySet();
            Iterator it = s.iterator();
            while ( it.hasNext() ) {
                Map.Entry entry = (Map.Entry) it.next();
                String value = (String) entry.getKey();
                code += value;
                break;
            }
            countLetters.clear();
        }
        System.out.println(code);
        return code;
    }


}
