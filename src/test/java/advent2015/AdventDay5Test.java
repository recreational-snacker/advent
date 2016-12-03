package advent2015;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay5Test {

    @Test
    public void testRegex() {
        String input = "ugknbfddgicrmopn";
        Boolean isValid = Pattern.matches("[a-z]+", input);
        System.out.println("Multiple letter: "+isValid);
        Boolean isValid1 = Pattern.matches("(u*)", input);
        System.out.println("Match sequence: "+isValid1);
    }

}