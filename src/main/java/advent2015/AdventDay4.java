package advent2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay4 {

    private final static String MD5 = "MD5";

    public static String solution(String input, String matcher) {
        String md5;
        for (int i = 0; ; i++) {
            String attempt = input+i;
            md5 = createMd5(attempt);
            if (md5.startsWith(matcher)) {
                return String.valueOf(i);
            }
        }
    }

    public static String createMd5(String input) {
        String md5;
        if(null == input) return null;
        try {
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(input.getBytes(), 0, input.length());
            BigInteger integer = new BigInteger(1, digest.digest());
            md5 = String.format("%1$032x", integer);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return md5;
    }
}
