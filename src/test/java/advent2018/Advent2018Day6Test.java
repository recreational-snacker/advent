package advent2018;

import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Advent2018Day6Test {

    private String input = "341, 330\n" +
            "85, 214\n" +
            "162, 234\n" +
            "218, 246\n" +
            "130, 67\n" +
            "340, 41\n" +
            "206, 342\n" +
            "232, 295\n" +
            "45, 118\n" +
            "93, 132\n" +
            "258, 355\n" +
            "187, 302\n" +
            "181, 261\n" +
            "324, 246\n" +
            "150, 203\n" +
            "121, 351\n" +
            "336, 195\n" +
            "44, 265\n" +
            "51, 160\n" +
            "63, 133\n" +
            "58, 117\n" +
            "109, 276\n" +
            "292, 241\n" +
            "81, 56\n" +
            "281, 284\n" +
            "226, 104\n" +
            "98, 121\n" +
            "178, 234\n" +
            "319, 332\n" +
            "279, 234\n" +
            "143, 163\n" +
            "109, 333\n" +
            "80, 188\n" +
            "106, 242\n" +
            "65, 59\n" +
            "253, 137\n" +
            "287, 317\n" +
            "185, 50\n" +
            "193, 132\n" +
            "96, 319\n" +
            "193, 169\n" +
            "100, 155\n" +
            "113, 161\n" +
            "182, 82\n" +
            "157, 148\n" +
            "132, 67\n" +
            "339, 296\n" +
            "243, 208\n" +
            "196, 234\n" +
            "87, 335";

    private String testInput = "1, 1\n" +
            "1, 6\n" +
            "8, 3\n" +
            "3, 4\n" +
            "5, 5\n" +
            "8, 9";

    @Test
    public void part1() {
        findLargestArea(input);
    }

    private void findLargestArea(String input) {
        String[] inputArray = input.split("\n");
        Map<Integer, Point> points = new HashMap<>();

        int maxx = 0;
        int maxy = 0;
        int count = 0;
        for (String str : inputArray) {
            String s[] = str.trim().split(", ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            points.put(count, new Point(x, y));
            count++;
            if (x > maxx) {
                maxx = x;
            }
            if (y > maxy) {
                maxy = y;
            }
        }

        int[][] grid = new int[maxx + 1][maxy + 1];
        Map<Integer, Integer> regions = new HashMap<>();

        for (int x = 0; x <= maxx; x++) {
            for (int y = 0; y <= maxy; y++) {
                int best = maxx + maxy;
                int bestnum = -1;

                // find distance to closest point
                for (int i = 0; i < count; i++) {
                    Point p = points.get(i);

                    int dist = Math.abs(x - p.x) + Math.abs(y - p.y);
                    if (dist < best) {
                        best = dist;
                        bestnum = i;
                    } else if (dist == best) {
                        bestnum = -1;
                    }
                }

                grid[x][y] = bestnum;
                Integer total = regions.get(bestnum);
                if (total == null) {
                    total = 1;
                } else {
                    total = total + 1;
                }
                regions.put(bestnum, total);
            }
        }
        // remove infinite
        for (int x = 0; x <= maxx; x++) {
            int bad = grid[x][0];
            regions.remove(bad);
            bad = grid[x][maxy];
            regions.remove(bad);
        }
        for (int y = 0; y <= maxy; y++) {
            int bad = grid[0][y];
            regions.remove(bad);
            bad = grid[maxx][y];
            regions.remove(bad);
        }

        // find biggest
        int biggest = 0;
        for (int size : regions.values()) {
            if (size > biggest) {
                biggest = size;
            }
        }

        System.out.println("Biggest: " + biggest);

        int inarea = 0;

        for (int x = 0; x <= maxx; x++) {
            for (int y = 0; y <= maxy; y++) {

                int size = 0;
                for (int i = 0; i < count; i++) {
                    Point p = points.get(i);
                    int dist = Math.abs(x - p.x) + Math.abs(y - p.y);
                    size += dist;
                }

                if (size < 10000) {
                    inarea++;
                }

            }
        }
        System.out.println("Area Size: " + inarea);
    }
}
