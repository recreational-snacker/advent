package advent2020;

import org.junit.Test;

import java.util.List;

public class Day3Test {

    private static String TREE = "#";
    private static String OPEN_LAND = ".";

    private String sample = "..##.......\n" +
            "#...#...#..\n" +
            ".#....#..#.\n" +
            "..#.#...#.#\n" +
            ".#...##..#.\n" +
            "..#.##.....\n" +
            ".#.#.#....#\n" +
            ".#........#\n" +
            "#.##...#...\n" +
            "#...##....#\n" +
            ".#..#...#.#";

    private String addInputLineToArray(String line, int totalRight) {
        while (line.length()<=totalRight) {
            line += line;
        }
        return line;
    }

    private Integer countTrees(String input, int right, int down) {
        int treeCount = 0;
        int totalRight = 0;
        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length-1; ) {
            i = i + down;
            String line = lines[i];
            totalRight += right;
            if (line.length() <= totalRight) {
                line = addInputLineToArray(line, totalRight);
            }
            String[] land = line.split("");
            if (land[totalRight].equals(TREE)) {
                treeCount++;
            }
        }
        return treeCount;
    }

    private Integer countTreesForSlopeProbability(String input) {
        int treeCount = 1;

        treeCount *= countTrees(input, 1, 1);
        treeCount *= countTrees(input, 3, 1);
        treeCount *= countTrees(input, 5, 1);
        treeCount *= countTrees(input, 7, 1);
        treeCount *= countTrees(input, 1, 2);

        return treeCount;
    }

    @Test
    public void test() {
        System.out.println("trees counted: "+ countTrees(sample, 3, 1));
        System.out.println("trees counted: "+ countTrees(input, 3, 1));

        System.out.println("2) Trees counted: " + countTreesForSlopeProbability(sample));
        System.out.println("2) Trees counted: " + countTreesForSlopeProbability(input));
    }

    private String input = "....#..#.......#........#....#.\n" +
            "..##.#.#.#...................#.\n" +
            "....#.#.##..#....#......#......\n" +
            ".........#.#......##.....#.....\n" +
            "..........#.###.##...##........\n" +
            "#....#.#.......##.....#..#.....\n" +
            "#...........#.#...#..#..##.##..\n" +
            "......##.............#.....#...\n" +
            "..##..........###..#.#..##.....\n" +
            "...........#........#......##..\n" +
            "..##...........##..............\n" +
            "..#......###.#.....#.#.#.......\n" +
            "..#..#..#..........#.#....#....\n" +
            ".#.....##......................\n" +
            "...#...##..#...#.........#..##.\n" +
            ".#......#..#..#...#......#.##..\n" +
            "..##.##.......#..#.....#..#...#\n" +
            "..............#..#..#...#......\n" +
            "...#...#....##.....#...#...#...\n" +
            "......................#...#....\n" +
            ".......#......#...#..##...#.#..\n" +
            "##......#..#.....#....#.....#..\n" +
            "....#.#.##.#.#....#............\n" +
            "#.....##.............#.........\n" +
            "..........#...........#.#.....#\n" +
            "...#...##....#.#........#..#...\n" +
            "................#..#.##.##....#\n" +
            "......#...#...##...##....#.....\n" +
            "##....#..#..#...#..#...........\n" +
            "#..................#...#.#..#..\n" +
            "....##....##.#....#..#......#..\n" +
            ".....#...........#.........##..\n" +
            "..#..............#.........#..#\n" +
            "......##....................#..\n" +
            "..#.....###...####...#...#.##..\n" +
            "#..#.#......#.....#.......#.#..\n" +
            "##.#.........######........#...\n" +
            "..#....###...#.#..............#\n" +
            ".....#..............#.........#\n" +
            "....#......#..#.........#...#..\n" +
            ".....###.....#.###.......###...\n" +
            "#.#..#.....#....##...#........#\n" +
            "..##....#..#.........#...#.#...\n" +
            "..#..##.............#....#.#.#.\n" +
            "..##.#..#.#.#.........##.......\n" +
            "#.#..#.........#..............#\n" +
            "#..#.........###.......#.#..#.#\n" +
            ".............#...#....#......#.\n" +
            "..........#.#...##.###.....#.#.\n" +
            "..#.....#......................\n" +
            ".......#......###.#.......#....\n" +
            "....#....#.........#...###.#.#.\n" +
            ".#.............#............#..\n" +
            "....#..#.............#.#....#..\n" +
            "....#.....#...#...##.#.........\n" +
            "..#...#...#..................#.\n" +
            "........#....#.....#...........\n" +
            ".....##.......#...#.#..#..#....\n" +
            "...#............#..#.#.........\n" +
            "......................#........\n" +
            "....#......#.....#.#....#......\n" +
            ".....#..#.........#.........##.\n" +
            "...............#.....#....##...\n" +
            "...#.#.#...#..#...........#....\n" +
            ".#....###......##...#.#.#.#....\n" +
            ".....#...#....####....##.......\n" +
            "..#......#..#.....##.#...#.....\n" +
            "...#.##..#....#..##.....#......\n" +
            "..#......#...#...##.....#...#..\n" +
            "......#.....#........#.........\n" +
            "..#.#....#..............##....#\n" +
            "..#...#......##............#...\n" +
            ".##.#.......#.......#......#..#\n" +
            "...##.##...#.....#.......#..#..\n" +
            "......##..#....#.......#.......\n" +
            ".....#..#..#.#.....#.....#...##\n" +
            "##.#...#.#.#.....#...#.#.#.##.#\n" +
            "...................###...#..#..\n" +
            ".#.....##.#......#........#....\n" +
            ".##...##.#..........#...#....#.\n" +
            "......#..............#.#......#\n" +
            "...#.......#..#...........#....\n" +
            ".###...#............##..#...##.\n" +
            "##..#.#.........#............#.\n" +
            "#...#.#......#.##...........#.#\n" +
            ".#.#...#........#......##......\n" +
            "....#...#...#.....#...#....#...\n" +
            "...##...........##.........#...\n" +
            ".........#...#..###............\n" +
            "..#........#...............#...\n" +
            ".............#....#.#..........\n" +
            "........#......#.#.......#....#\n" +
            ".................#....##.#.##..\n" +
            "..#...##........#..............\n" +
            "#..#........#...#....#.........\n" +
            "......#.#.....#.....#..###.#..#\n" +
            "....#............#...#.#.#.....\n" +
            "............#..........#...#...\n" +
            "..........#....##.#.........#..\n" +
            "..............#...#...#..#.....\n" +
            "#......#....#..##....#......##.\n" +
            "...#....#.................#....\n" +
            ".#.##.............#...#....##..\n" +
            "....#..#.........#..#....#....#\n" +
            "..#.....##..#......#.#..#......\n" +
            "..#..#.....#........#...#..#..#\n" +
            ".........##.#.##.#.......#....#\n" +
            "..#.......##.##...#.....#.....#\n" +
            ".............##...#...........#\n" +
            "..#......#..#....#...#..#.##...\n" +
            "....#........#......#.........#\n" +
            ".......#........#..#.#.#..##..#\n" +
            "..#......#...........##...#....\n" +
            ".....#..#.#...#..............##\n" +
            ".#..#......#......#........#..#\n" +
            "...##...............#....#.....\n" +
            ".......#...#.......##..#.......\n" +
            ".....#....#...#...#..#.....#.#.\n" +
            "...#.........#.....#...........\n" +
            "...#.....###....#....#...#...#.\n" +
            "#..#.....#.........#.........#.\n" +
            ".................#.#.....#....#\n" +
            "...........#..........#..#.....\n" +
            "........#.#....#...#..#.....###\n" +
            "#............................#.\n" +
            "..##..#..#...##.........#......\n" +
            "......##....#.#...#.........#..\n" +
            "......#..##.#......#..#.....#..\n" +
            "...#.......##....#.#....#......\n" +
            ".....#........#...#............\n" +
            "#.......#...#.........#......#.\n" +
            "......#......#....#..#.........\n" +
            "..#.#........#..#......#....#..\n" +
            ".#..#.#..........##....###.#..#\n" +
            "...#....#.##..#...#....#.......\n" +
            "..#.....#......#.###.......#...\n" +
            "..............................#\n" +
            ".....#..#...#...........#......\n" +
            ".##...#....##....#.#.#.#....#.#\n" +
            ".#...#....#...#........#.......\n" +
            "....#............#...##..#.....\n" +
            "....##..#....#....#.....#....##\n" +
            ".............#..##.#.#.#.......\n" +
            "#.......#.#.#.......#..#..#....\n" +
            "#..#...........#.......###..#..\n" +
            ".#..##.#.....#........#........\n" +
            "..#.#.......#............#..#..\n" +
            "...........#..#............##.#\n" +
            ".....#.......#.....#..#.##.#..#\n" +
            "......#......##.....##.........\n" +
            "..##.#..#.#..#..#..............\n" +
            ".....#.............##...#.#.##.\n" +
            ".#......##.#..........#........\n" +
            "..#..#.........#.....#.#.#.....\n" +
            "..#.....#.......#.....#..#.....\n" +
            "#.#.#........#.#...#....#..#...\n" +
            ".#.#.......#............#....#.\n" +
            "......#..................#....#\n" +
            ".#...#...#.....#.#..........#..\n" +
            ".#..##....####...........#.#...\n" +
            "..##.....#...#.#....#....#.....\n" +
            "#.....................#....#.#.\n" +
            "###..###.#.#...........#.....##\n" +
            "......#......#..........#......\n" +
            "...#......#.##.....#......###.#\n" +
            ".............#..#.#...........#\n" +
            "..#.............#.#..#.....#...\n" +
            "...#...............#....##...##\n" +
            "........#.................#....\n" +
            "#..###.....#.......##.#......##\n" +
            "....#.#..............#.........\n" +
            "#..........#.....#..##...#.....\n" +
            "................#...#..#....#..\n" +
            "..#...#....##..........#.#.....\n" +
            "......#........##......#..#...#\n" +
            "...#....#..#.....#.......#...#.\n" +
            ".#.....#..#...#..###....#......\n" +
            "....#.........#....#.#.#.....#.\n" +
            "#.#....#...#....#.....#..##....\n" +
            ".......#..#..#..........#...#..\n" +
            "..#.#..#.....##.#.#............\n" +
            "..#....#.....#..##..#..#.#..#..\n" +
            "..#.##.#...........#...#..#....\n" +
            ".........#........#...#........\n" +
            "..#.#.#.......##.........#.##..\n" +
            "#.#..........#.#...#..#......##\n" +
            ".#..#....................#.#...\n" +
            ".##......#................#...#\n" +
            "..##.#######......#....#.......\n" +
            "....#...##.#....#.#............\n" +
            ".##....#...##.......#...#..#...\n" +
            "...........#...#...#...#..#....\n" +
            "#...#.....#.......#....#.....#.\n" +
            ".............#.................\n" +
            "........#.#.......#...#.#.#....\n" +
            "..............#............#.#.\n" +
            "......#......##..#.......#....#\n" +
            "##...#..................#......\n" +
            ".....#......###.....#.......#.#\n" +
            ".....#.#............#.#........\n" +
            "..#.#..#............#....#.#...\n" +
            "##.#.###.#.#.#..#......#.......\n" +
            "...##........#..#.....#.#.#..#.\n" +
            "##......#.##.....####..#.......\n" +
            "............#...#..#...#..#....\n" +
            "...#..#................##.#..#.\n" +
            ".#....#.#...........##.#.#...#.\n" +
            "####..#...........#.......###..\n" +
            ".......#.................#.....\n" +
            ".......#....#.......##....#....\n" +
            "..#.........#...#....#.........\n" +
            "..........#..#...#.#...##..#...\n" +
            "....##..........#.........##...\n" +
            "#.........##..#.#..#.......#...\n" +
            ".#...........#....#...#...#.#..\n" +
            "....#..#.....#...##....#.#....#\n" +
            ".#....#.....#......#..##.##.#.#\n" +
            "#......#..#.......##...........\n" +
            "...#..#...#.#.................#\n" +
            "......#.......##....##.#......#\n" +
            "....#....#.#.#.....#....#....#.\n" +
            "..#..........#.##...##..#......\n" +
            "...#..#........#....#.#..#....#\n" +
            "##.......#........#..........#.\n" +
            ".#........#.......#...#..##...#\n" +
            "..#..#..##..#...........#...###\n" +
            "..#......#..........#..##......\n" +
            ".#.....#..#.#...#...#.........#\n" +
            "#.#......##....................\n" +
            "#...#.....##...........#.......\n" +
            "........#...#....#.......##....\n" +
            "...#.##...#....#....#..#..#..#.\n" +
            "...#..#......##....#..#..##....\n" +
            "#...#..........#.#.............\n" +
            "##..#........##.....#.........#\n" +
            ".....#......#.#...###..#.......\n" +
            "#..##.#..#.###...........##..#.\n" +
            ".....#....#..........#.......#.\n" +
            "##.........##.#................\n" +
            "....#.........#............##..\n" +
            ".......#........#......#..#..##\n" +
            ".#...#...##..#....#..#.........\n" +
            ".............#...#.#........#..\n" +
            "......#..#...#..#.###..#.......\n" +
            "........##.#..#.#..#..#........\n" +
            "#.##..#..#..........#...##..###\n" +
            ".##...#............#.#...##..#.\n" +
            "................#....##.#...#..\n" +
            "#.................#..........#.\n" +
            "...#..#..#.....................\n" +
            "..#...##.#.#...................\n" +
            ".....#...#.......#............#\n" +
            "..#..#.........#..##.#..#.#...#\n" +
            ".....#.#.....#.#.......#.....#.\n" +
            "..................#..#....#.#..\n" +
            "..#.....###.##.......##....#.#.\n" +
            "..#......##.......#....##.#....\n" +
            "....#...................#..##.#\n" +
            ".......#....#.##.#.......#....#\n" +
            "..#...#......#..#...###....#.#.\n" +
            "..#..#.#....#...........#.....#\n" +
            ".....#..#..#.......#........#..\n" +
            "......#.##.#......#...........#\n" +
            "#...#....#.#..##.##..#..##.....\n" +
            "#...##....#.#...##........#....\n" +
            "..##............#.#.#..........\n" +
            "....#.....#.#..#.......#..#....\n" +
            "#..#.#.....#..#..##...#..##....\n" +
            "...##........#...........#...#.\n" +
            ".####......#..##.........#.#...\n" +
            ".......#.......................\n" +
            ".................#....#..#.....\n" +
            ".........##......###...........\n" +
            ".##......#.#.#....#.#...#..###.\n" +
            "....#......##.###.#.#..#.......\n" +
            "..........#.......##......##..#\n" +
            "...........#.......#..##.......\n" +
            ".....###..#..............##....\n" +
            "........##..#.#.#......#....#..\n" +
            "#....#.........................\n" +
            "...........#...............##..\n" +
            "......#.................#......\n" +
            ".....#...#..##...##...#...#....\n" +
            "..........#.#...##.####......#.\n" +
            "..#.#.....##....#...........#..\n" +
            "..........#....#..#....##...#..\n" +
            ".#.......#..##...#...#.....#...\n" +
            "...##....#.#......##...##....#.\n" +
            "#.......#.......#.##.#...#.#...\n" +
            "#...#..................#......#\n" +
            "..#.......#...............#..##\n" +
            "#.....#..................#....#\n" +
            ".##.....#.....#......####.....#\n" +
            "..#........#...#.#........#...#\n" +
            "..##.....#....#...#...........#\n" +
            "..#..#.....##..#.##...#........\n" +
            "..........###..#....##.....#...\n" +
            "...#...#....#.##.#...#.#.......\n" +
            "..##......#.......#.......##...\n" +
            "............#............#.....\n" +
            ".##....#.........#.............\n" +
            "....#....#....#........##...#.#\n" +
            ".......##......................\n" +
            "..........#.#.................#\n" +
            "......##.#...#.........#.....#.\n" +
            "..#...#......#..#.............#\n" +
            "..........###.#..#.#...#..#..#.\n" +
            "#..#.#..#....##...#...#.#...#..\n" +
            ".#........##...#......#.##.....\n" +
            "...###.#...##..............##..\n" +
            "#.#.#...#...#..#....#.#..#.....\n" +
            ".#.#.##..#....#......#.#.......\n" +
            "...#..#.#....##...........#..#.\n" +
            ".....##..##......#.#...........\n" +
            "......#.....#....####....#.....\n" +
            ".#.#.#...#..#..#...........#...\n" +
            ".....#......................#..\n" +
            ".........#.........#.###.##....\n" +
            ".....#......##..........#......\n" +
            "..#...........##...........#...\n" +
            "..............#.........#.....#\n" +
            "..#....#..#...#...##.#.........\n" +
            ".#.#.#....#..........#.........";

}
