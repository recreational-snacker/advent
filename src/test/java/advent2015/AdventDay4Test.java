package advent2015;

import org.junit.Assert;
import org.junit.Test;
import util.MD5Util;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay4Test {

    @Test
    public void testMD5CreationOfExampl1() throws Exception {
        String input = "abcdef609043";
        String md5 = MD5Util.createHexMd5(input);
        System.out.println(md5);
        Assert.assertEquals("000001dbbfa3a5c83a2d506429c7b00e", md5);
    }

    @Test
    public void testMD5CreationOfExampl2() throws Exception {
        String input = "pqrstuv1048970";
        String md5 =  MD5Util.createHexMd5(input);
        System.out.println(md5);
        Assert.assertEquals("000006136ef2ff3b291c85725f17325c", md5);
    }

    @Test
    public void testMSolution() throws Exception {
        String input = "bgvyzdsv";
        String matcher = "00000";
        String md5 = AdventDay4.solution(input, matcher);
        System.out.println(md5);
    }

    @Test
    public void testMSolution2() throws Exception {
        String input = "bgvyzdsv";
        String matcher = "000000";
        String md5 = AdventDay4.solution(input, matcher);
        System.out.println(md5);
    }

}