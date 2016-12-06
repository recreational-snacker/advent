package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DeeshaSingh on 2016-12-06.
 */
public class MD5Util {

    private final static String MD5 = "MD5";

    public static String createHexMd5(String input) {
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
