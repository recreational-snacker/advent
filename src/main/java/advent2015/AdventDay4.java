package advent2015;

import util.MD5Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay4 {

    public static String solution(String input, String matcher) {
        String md5;
        for (int i = 0; ; i++) {
            String attempt = input+i;
            md5 = MD5Util.createHexMd5(attempt);
            if (md5.startsWith(matcher)) {
                return String.valueOf(i);
            }
        }
    }
}
