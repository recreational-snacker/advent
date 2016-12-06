package advent2016;

import util.MD5Util;
import util.MapUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by DeeshaSingh on 2016-12-05.
 */
public class AdventDay5 {

    public static void solution1(String input) {
        Map<Integer, String> password2 = setupMap();
        String matcher = "00000";
        String password = "";
        String md5;
        for (int i = 0; ; i++) {
            String attempt = input+i;
            md5 = MD5Util.createHexMd5(attempt);
            if (md5.startsWith(matcher)) {
                String firstDigit = String.valueOf(md5.charAt(5));
                if (password.length()<8) {
                    password += firstDigit;
                }
                Integer foundValue = isValid(firstDigit);
                if (foundValue!=null) {
                    if (password2.get(foundValue).equalsIgnoreCase("_")) {
                        password2.put(foundValue, String.valueOf(md5.charAt(6)));
                        MapUtil.printMap(password2);
                    }
                }
            }
            if (stop(password2)) {
                System.out.println("Password for Solution1: "+password);
                break;
            }
        }
    }

    private static boolean stop(Map<Integer, String> password2) {
        Set s = password2.entrySet();
        Iterator it = s.iterator();
        while ( it.hasNext() ) {
            Map.Entry entry = (Map.Entry) it.next();
            String value = (String) entry.getValue();
            if (value.equalsIgnoreCase("_")) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, String> setupMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"_");
        map.put(1,"_");
        map.put(2,"_");
        map.put(3,"_");
        map.put(4,"_");
        map.put(5,"_");
        map.put(6,"_");
        map.put(7,"_");
        MapUtil.printMap(map);
        return map;
    }

    private static Integer isValid(String value) {
        try {
            Integer no = Integer.valueOf(value);
            if (no>=0 && no<=7) {
                return no;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
