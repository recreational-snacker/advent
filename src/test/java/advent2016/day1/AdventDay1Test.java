package advent2016.day1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deesha Singh on 2016/12/01.
 */
public class AdventDay1Test {

    @Test
    public void testGetStringArrayOfInputPoints() {
        String input = "R5, L5, R5, R3";
        String[] directions = AdventDay1.getStringArrayOfDirections(input);
        Assert.assertNotNull(directions);
        Assert.assertEquals(4, directions.length);
    }

    @Test
    public void figureOutDirectionRight() {
        String direction = "R2 ";
        Boolean isRight = AdventDay1.getDirection(direction);
        Assert.assertTrue(isRight);
    }

    @Test
    public void figureOutDirectionLeft() {
        String direction = "L5 ";
        Boolean isRight = AdventDay1.getDirection(direction);
        Assert.assertFalse(isRight);
    }

    @Test
    public void getDistance() {
        String direction = "L4";
        Integer distance = AdventDay1.getDistance(direction);
        Assert.assertEquals(4, distance.longValue());
    }

    @Test
    public void testExampleSolution() {
        String input = "R5, L5, R5, R3";
        AdventDay1.solution(input);
    }

    @Test
    public void testSolution() {
        String input = "R5, L2, L1, R1, R3, R3, L3, R3, R4, L2, R4, L4, R4, R3, L2, L1, L1, R2, R4, R4, L4, R3, L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2, R2, L1, L4, R191, R5, L2, R46, R3, L1, R74, L2, R2, R187, R3, R4, R1, L4, L4, L2, R4, L5, R4, R3, L2, L1, R3, R3, R3, R1, R1, L4, R4, R1, R5, R2, R1, R3, L4, L2, L2, R1, L3, R1, R3, L5, L3, R5, R3, R4, L1, R3, R2, R1, R2, L4, L1, L1, R3, L3, R4, L2, L4, L5, L5, L4, R2, R5, L4, R4, L2, R3, L4, L3, L5, R5, L4, L2, R3, R5, R5, L1, L4, R3, L1, R2, L5, L1, R4, L1, R5, R1, L4, L4, L4, R4, R3, L5, R1, L3, R4, R3, L2, L1, R1, R2, R2, R2, L1, L1, L2, L5, L3, L1";
        AdventDay1.solution(input);
    }

}