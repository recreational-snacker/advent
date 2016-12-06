package advent2016;

import java.util.*;

/**
 * Created by Deesha Singh on 2016/12/06.
 */
public class AdventDay6 {
    public static String solution1(Integer no, String input, String lessOrMore) {
        String[] array = input.split("\n");
        String code = "";
        Map<String, Integer> countLetters = new HashMap<>();
        for (int j = 0; j<no; j++) {
            for (int i = 0; i < array.length; i++) {
                String[] word = array[i].split("");
                if (countLetters.containsKey(word[j])) {
                    Integer count = countLetters.get(word[j]);
                    countLetters.put(word[j], count + 1);
                } else {
                    countLetters.put(word[j], 1);
                }
            }
            if (lessOrMore.equalsIgnoreCase(">")) {
                countLetters = sortByValue(countLetters);
            } else {
                countLetters = sortByValueLeast(countLetters);
            }
            Set s = countLetters.entrySet();
            Iterator it = s.iterator();
            while ( it.hasNext() ) {
                Map.Entry entry = (Map.Entry) it.next();
                String value = (String) entry.getKey();
                code += value;
                break;
            }
            System.out.println(code);
            countLetters.clear();
        }
        printMap(countLetters);
        return "";
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueLeast(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static void printMap(Map<String, Integer> password2) {
        Map<String, Integer> treeMap = new TreeMap<>(password2);
        Set s = treeMap.entrySet();
        Iterator it = s.iterator();
        String password = "";
        while ( it.hasNext() ) {
            Map.Entry entry = (Map.Entry) it.next();
            String value = String.valueOf(entry.getKey());
            password += value;
        }
        System.out.println(password);
    }
}
