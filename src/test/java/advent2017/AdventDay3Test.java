package advent2017;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

    private Map<String, Integer> values = new HashMap<>();
    private List<String> coordinates = new ArrayList<>();
    Integer value = 0;

    @Test
    public void testPart2() {
        coordinates.add("0,0");
        values.put("0,0", 1);
        for (int ring = 1; ; ring++) {
            int noInRing = (8 * ring);
            int noInRow = noInRing / 4;
            List<String> coords = Arrays.asList(coordinates.get(coordinates.size() - 1).split(","));
            int x = Integer.valueOf(coords.get(0)) + 1;
            int y = Integer.valueOf(coords.get(1));
            calculateValue(x, y);
            for (int j = 0; j < noInRow - 1; j++) {
                coords = Arrays.asList(coordinates.get(coordinates.size() - 1).split(","));
                x = Integer.valueOf(coords.get(0));
                y = Integer.valueOf(coords.get(1)) + 1;
                calculateValue(x, y);
            }
            for (int j = 0; j < noInRow; j++) {
                coords = Arrays.asList(coordinates.get(coordinates.size() - 1).split(","));
                x = Integer.valueOf(coords.get(0)) - 1;
                y = Integer.valueOf(coords.get(1));
                calculateValue(x, y);
            }
            for (int j = 0; j < noInRow; j++) {
                coords = Arrays.asList(coordinates.get(coordinates.size() - 1).split(","));
                x = Integer.valueOf(coords.get(0));
                y = Integer.valueOf(coords.get(1)) - 1;
                calculateValue(x, y);
            }
            for (int j = 0; j < noInRow; j++) {
                coords = Arrays.asList(coordinates.get(coordinates.size() - 1).split(","));
                x = Integer.valueOf(coords.get(0)) + 1;
                y = Integer.valueOf(coords.get(1));
                calculateValue(x, y);
            }
            if (value!=0) {
                break;
            }
        }
        System.out.println(value);
        Assert.assertEquals(266330, value.intValue());
    }

    private void calculateValue(int x, int y) {
        Integer sumValue = 0;
        //north
        int nx = x;
        int ny = y + 1;
        sumValue = sumValue + findValue(nx, ny);
        //nw
        int nwx = x - 1;
        int nwy = y + 1;
        sumValue = sumValue + findValue(nwx, nwy);
        //w
        int wx = x - 1;
        int wy = y;
        sumValue = sumValue + findValue(wx, wy);
        //sw
        int swx = x - 1;
        int swy = y - 1;
        sumValue = sumValue + findValue(swx, swy);
        //s
        int sx = x;
        int sy = y - 1;
        sumValue = sumValue + findValue(sx, sy);
        //se
        int sex = x + 1;
        int sey = y - 1;
        sumValue = sumValue + findValue(sex, sey);
        //e
        int ex = x + 1;
        int ey = y;
        sumValue = sumValue + findValue(ex, ey);
        //ne
        int nex = x + 1;
        int ney = y + 1;
        sumValue = sumValue + findValue(nex, ney);
        values.put(x + "," + y, sumValue);
        coordinates.add(x + "," + y);
        if (value==0 && sumValue>input) {
            value = sumValue;
        }
    }

    private int findValue(int x, int y) {
        String coord = x + "," + y;
        Integer nv = values.get(coord);
        if (nv == null) {
            nv = 0;
        }
        return nv;
    }
}
