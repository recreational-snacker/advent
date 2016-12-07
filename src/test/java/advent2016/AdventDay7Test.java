package advent2016;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeeshaSingh on 2016-12-07.
 */
public class AdventDay7Test {

    @Test
    public void testExample1Solution1() {
        List<String> validIPs = new ArrayList<>();
        String input = "abcd[bddb]xyyx";
        AdventDay7.solution1(input, validIPs);
    }

    @Test
    public void testExample2Solution1() {
        List<String> validIPs = new ArrayList<>();
        String input = "abcd[bddb]xyyx\nabba[mnop]qrst\naaaa[qwer]tyui\nioxxoj[asdfgh]zxcvbn";
        AdventDay7.solution1(input, validIPs);
    }

    @Test
    public void testSolution1() {
        AdventDay7.solution();
    }


}