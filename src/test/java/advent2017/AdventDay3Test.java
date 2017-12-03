package advent2017;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdventDay3Test {

    Integer input = 265149;

    @Test
    public void test() {
        List<Integer> spiral = new ArrayList<>();
        spiral.add(1);
        for (int i = 1; ; i++) {
            Integer corner = spiral.get(spiral.size() - 1) + (8 * i);
            if (corner > input) {
                spiral.add(corner);
                break;
            } else {
                spiral.add(corner);
            }
        }
        Integer ringStart = spiral.get(spiral.size() - 2);
        Integer noInRow = (spiral.size() - 1) * 2;
        Integer rowStart = ringStart;
        Integer rowEnd = rowStart + noInRow;
        while (rowEnd < input) {
            rowStart = rowEnd;
            rowEnd = rowStart + noInRow;
        }
        Integer distanceTo1 = Math.abs(input - (rowEnd - (noInRow / 2))) + spiral.size() - 1;
        System.out.println("Distance to 1: " + distanceTo1);
        Assert.assertEquals(438, distanceTo1.intValue());
    }
}
