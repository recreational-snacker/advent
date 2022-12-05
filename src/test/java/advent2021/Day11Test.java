package advent2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Day11Test {

    @Test
    public void solution() {
        String testInput = sample;
        int flashes = 0;
        int maxX = testInput.split("\n")[0].split("").length;
        int maxY = testInput.split("\n").length;
        Map<String, Integer> map = setupMap(testInput);
        int rounds = 1;
        while (rounds <= 100) {
            for (int x = 0; x < maxX; x++) {
                for (int y = 0; y < maxY; y++) {
                    int val = map.get(x+","+y);
                    val += 1;
                    if (val > 9) {
                        flashes++;
                        val = 0;
                        //topleft
                        if (y-1 >= 0 && x-1 >= 0) {

                        }
                        //top
                        if (y-1>=0) {

                        }
                        //topright
                        if (y-1>=0 && x+1<=maxX) {

                        }
                        //left
                        if (x-1 >= 0) {

                        }
                        //right
                        if (x+1 <= maxX) {
                            int x1 = x+1;
                            int valR = map.get(x1+","+y);
                            valR += 1;

                        }

                    } else {
                        map.put(x+","+y, val);
                    }
                }
            }
            rounds--;
        }
    }

    private Map<String, Integer> setupMap(String sample) {
        Map<String, Integer> map = new HashMap<>();
        int y = 0;
        for (String s : sample.split("\n")) {
            for (int x = 0; x < s.split("").length; x++) {
                map.put(x+","+y, Integer.parseInt(s.split("")[x]));
            }
            y++;
        }
        return map;
    }

    private String sample = "5483143223\n" +
            "2745854711\n" +
            "5264556173\n" +
            "6141336146\n" +
            "6357385478\n" +
            "4167524645\n" +
            "2176841721\n" +
            "6882881134\n" +
            "4846848554\n" +
            "5283751526";
}
