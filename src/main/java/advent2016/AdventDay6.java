package advent2016;

import java.util.*;

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
            countLetters = sortByValue(countLetters, lessOrMore);
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

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, String direction) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (direction.equals("<")) {
                return (o1.getValue()).compareTo(o2.getValue());
            } else {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
