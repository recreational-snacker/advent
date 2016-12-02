package advent2015;

import advent2015.AdventDay2;
import org.junit.Test;

/**
 * Created by Deesha Singh on 2016/12/01.
 */
public class AdventDay2Test {

    @Test
    public void testSolution() {
        AdventDay2.solution("1x1x10");
    }

    @Test
    public void testFullSolution() {
        AdventDay2.solveAll();
    }

    @Test
    public void testRibbon() {
        AdventDay2.ribbonSolution("2x3x4");
    }
}