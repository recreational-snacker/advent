package util;

import java.util.*;

/**
 * Created by DeeshaSingh on 2016-12-06.
 */
public class MapUtil {

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

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByKey(Map<K, V> map, String direction) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (direction.equals("<")) {
                return (o1.getKey().toString()).compareTo(o2.getKey().toString());
            } else {
                return (o2.getKey().toString()).compareTo(o1.getKey().toString());
            }
        });
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void printMap(Map<Integer, String> password2) {
        Map<Integer, String> treeMap = new TreeMap<>(password2);
        Set s = treeMap.entrySet();
        Iterator it = s.iterator();
        String password = "";
        while ( it.hasNext() ) {
            Map.Entry entry = (Map.Entry) it.next();
            String value = (String) entry.getValue();
            password += value;
        }
        System.out.println(password);
    }
}
