package advent2023;

import org.junit.Test;

import java.util.Map;

public class Day2Test {

    @Test
    public void test1() {

        int red = 12;
        int green = 13;
        int blue = 14;

        int idSum = 0;

        for (String s : input.split("\n")) {
            int gameId = Integer.parseInt(s.split(":")[0].replace("Game ", ""));
            boolean passes = true;
            for (String game : s.split(": ")[1].split("; ")) {
                for (String c : game.split(", ")) {
                    if (c.contains("red") && Integer.parseInt(c.replace(" red", "")) > red) {
                        passes = false;
                    }
                    if (c.contains("green") && Integer.parseInt(c.replace(" green", "")) > green) {
                        passes = false;
                    }
                    if (c.contains("blue") && Integer.parseInt(c.replace(" blue", "")) > blue) {
                        passes = false;
                    }
                }
            }
            if (passes) {
                idSum+=gameId;
            }
        }
        System.out.println(idSum);
    }

    @Test
    public void test2() {
        int powerSum = 0;

        for (String s : input.split("\n")) {
            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;
            for (String game : s.split(": ")[1].split("; ")) {
                for (String c : game.split(", ")) {
                    if (c.contains("red")) {
                        int currRed = Integer.parseInt(c.replace(" red", ""));
                        if (currRed > maxRed) {
                            maxRed = currRed;
                        }
                    }
                    if (c.contains("green")) {
                        int currGreen = Integer.parseInt(c.replace(" green", ""));
                        if (currGreen > maxGreen) {
                            maxGreen = currGreen;
                        }
                    }
                    if (c.contains("blue")) {
                        int currBlue = Integer.parseInt(c.replace(" blue", ""));
                        if (currBlue > maxBlue) {
                            maxBlue = currBlue;
                        }
                    }
                }
            }
            int power = maxRed * maxGreen * maxBlue;
            powerSum+=power;
        }
        System.out.println(powerSum);
    }

    private String input = "Game 1: 1 blue, 1 red; 10 red; 8 red, 1 blue, 1 green; 1 green, 5 blue\n" +
            "Game 2: 9 green, 11 red; 1 green, 7 red, 1 blue; 1 red, 1 blue, 1 green; 11 green, 3 red, 1 blue; 5 green, 12 red; 8 green, 1 blue, 7 red\n" +
            "Game 3: 16 blue, 2 red, 4 green; 8 red, 4 green; 7 green, 16 blue\n" +
            "Game 4: 3 green, 4 blue, 6 red; 7 red, 12 green, 5 blue; 5 green, 16 red, 8 blue\n" +
            "Game 5: 4 green, 4 blue, 3 red; 4 green, 7 red, 1 blue; 2 blue, 2 red, 4 green; 3 green, 7 red, 4 blue; 2 blue, 3 green, 8 red\n" +
            "Game 6: 3 green, 4 blue, 10 red; 13 red, 3 green, 4 blue; 11 red; 14 red, 1 green; 6 red, 2 green, 1 blue; 10 red, 1 blue, 1 green\n" +
            "Game 7: 2 green, 9 red, 9 blue; 12 red, 14 blue; 8 red, 3 green\n" +
            "Game 8: 9 green, 1 red; 18 green, 2 red, 7 blue; 1 blue, 9 green, 3 red; 3 red, 15 blue, 18 green\n" +
            "Game 9: 2 red, 1 blue, 10 green; 4 red, 1 blue, 5 green; 6 green, 3 red; 1 green, 2 blue; 8 red\n" +
            "Game 10: 9 green; 6 red, 4 green, 4 blue; 9 red, 2 blue, 9 green; 8 blue, 9 red, 12 green; 4 red, 8 green, 2 blue; 6 green, 7 blue\n" +
            "Game 11: 1 blue, 15 red, 2 green; 3 green, 9 red; 1 blue, 3 red, 1 green; 10 red, 1 green; 3 red\n" +
            "Game 12: 6 blue, 9 red, 4 green; 1 green, 8 blue; 4 green, 8 blue, 1 red; 7 green, 7 blue, 2 red\n" +
            "Game 13: 11 green, 8 blue, 1 red; 5 blue, 2 red, 5 green; 2 red, 18 green; 5 blue, 5 green, 2 red\n" +
            "Game 14: 1 red, 4 blue, 3 green; 2 red, 1 green, 1 blue; 1 red, 5 green, 1 blue; 3 red, 4 green, 4 blue\n" +
            "Game 15: 2 blue, 1 green; 3 red, 2 blue, 7 green; 1 red, 4 green, 15 blue; 1 green, 14 blue, 2 red\n" +
            "Game 16: 3 red, 10 blue, 9 green; 20 blue, 13 green, 1 red; 9 green, 11 blue, 6 red\n" +
            "Game 17: 4 red, 1 green, 1 blue; 1 green, 1 red, 11 blue; 1 red, 7 blue\n" +
            "Game 18: 5 red, 9 green; 17 green, 2 blue, 16 red; 11 red, 2 blue, 1 green\n" +
            "Game 19: 3 red, 14 green; 4 blue, 1 red, 17 green; 14 green, 3 red, 9 blue; 9 blue, 8 green, 8 red; 4 green, 8 blue\n" +
            "Game 20: 8 green, 3 blue, 3 red; 5 green, 6 red, 1 blue; 1 blue, 6 red, 13 green; 1 blue, 4 red; 4 red, 4 green, 1 blue\n" +
            "Game 21: 10 green, 3 blue, 7 red; 4 green, 14 blue, 11 red; 2 red, 8 green, 15 blue; 13 green, 7 blue, 4 red\n" +
            "Game 22: 3 blue, 11 green, 3 red; 7 green, 2 blue, 2 red; 3 red, 3 blue, 15 green; 12 green, 2 blue, 5 red\n" +
            "Game 23: 4 red, 3 blue; 2 green, 7 red, 6 blue; 1 green, 2 red, 3 blue\n" +
            "Game 24: 7 red, 3 green, 2 blue; 3 red, 9 green, 9 blue; 8 green, 6 red, 7 blue\n" +
            "Game 25: 2 red, 2 green, 2 blue; 3 green, 1 red, 4 blue; 4 red, 3 blue; 4 green, 1 blue, 5 red; 2 green, 4 red, 2 blue; 5 green, 3 red\n" +
            "Game 26: 1 red, 7 blue, 12 green; 2 blue, 2 red, 7 green; 3 green, 5 red, 6 blue; 8 green, 3 blue, 5 red; 15 green, 7 blue\n" +
            "Game 27: 4 blue, 7 red, 15 green; 4 red, 1 blue, 15 green; 3 red; 8 red, 4 blue, 10 green; 4 red\n" +
            "Game 28: 2 blue, 5 red, 8 green; 13 red, 9 green; 2 blue, 4 red, 5 green; 1 blue, 14 green, 12 red; 13 green, 11 red, 3 blue\n" +
            "Game 29: 7 green, 10 red; 9 green, 2 red, 1 blue; 3 blue, 13 green, 5 red\n" +
            "Game 30: 3 green, 6 blue, 5 red; 3 green, 1 red, 13 blue; 2 red, 2 green, 7 blue; 13 red, 2 green, 9 blue; 2 blue, 7 red, 2 green\n" +
            "Game 31: 8 red, 16 green, 1 blue; 10 red, 3 blue, 11 green; 2 green, 4 blue, 3 red; 2 blue, 7 red, 12 green; 16 green, 9 red, 6 blue; 8 blue, 9 red, 11 green\n" +
            "Game 32: 6 red, 3 green, 7 blue; 3 green, 7 blue, 3 red; 4 green, 1 red, 7 blue; 7 blue, 6 green, 5 red; 9 green, 11 red\n" +
            "Game 33: 8 green, 6 blue; 2 green, 8 red, 1 blue; 12 green, 4 blue, 14 red; 11 blue, 1 green, 7 red; 1 blue, 5 green, 9 red; 7 green, 7 red, 5 blue\n" +
            "Game 34: 5 blue, 6 green, 7 red; 6 blue, 5 green, 10 red; 9 red, 3 blue, 7 green; 9 red, 4 green; 15 red, 6 green, 4 blue\n" +
            "Game 35: 6 blue, 4 green, 7 red; 2 blue, 6 red; 4 green, 11 red, 2 blue; 2 red, 1 blue, 4 green; 10 red, 10 blue, 1 green; 11 blue, 4 green\n" +
            "Game 36: 13 blue, 6 green, 7 red; 5 red, 9 blue, 9 green; 6 red, 2 blue, 3 green; 2 blue, 7 green; 7 red, 5 blue; 12 blue, 7 red, 3 green\n" +
            "Game 37: 2 red, 12 green, 3 blue; 6 red, 4 blue; 3 blue, 1 green; 4 red, 5 blue, 6 green\n" +
            "Game 38: 3 red, 16 blue, 10 green; 6 red, 5 green, 5 blue; 7 blue, 12 red, 5 green\n" +
            "Game 39: 17 red, 4 green, 6 blue; 6 blue, 11 red; 18 red, 3 green, 1 blue; 3 blue, 6 red, 2 green; 19 red, 5 blue\n" +
            "Game 40: 1 red, 2 green, 3 blue; 6 blue, 5 green, 1 red; 5 green, 1 blue\n" +
            "Game 41: 7 blue, 6 green; 8 blue, 2 red, 3 green; 2 blue, 3 green; 3 green, 7 red, 17 blue\n" +
            "Game 42: 6 blue; 10 red, 5 blue, 14 green; 1 blue, 11 green; 6 blue, 2 green, 5 red; 7 blue, 13 green, 11 red\n" +
            "Game 43: 15 green, 3 blue; 7 blue, 14 green; 11 blue, 3 green; 17 green, 1 red, 1 blue; 17 green, 2 blue, 1 red\n" +
            "Game 44: 11 red, 4 blue, 16 green; 11 blue, 16 green; 14 red, 10 blue, 17 green\n" +
            "Game 45: 6 blue; 6 green, 6 blue, 1 red; 5 blue, 11 green; 4 green, 6 blue\n" +
            "Game 46: 6 green, 3 blue, 2 red; 9 green, 4 red, 2 blue; 9 green, 1 red, 3 blue\n" +
            "Game 47: 6 red, 3 blue, 9 green; 3 green, 11 blue; 4 blue, 1 red; 11 green, 11 blue\n" +
            "Game 48: 13 blue, 15 red; 9 red, 9 blue; 15 green, 9 red, 1 blue\n" +
            "Game 49: 8 green, 4 red; 1 red, 6 blue; 5 blue, 8 green; 1 red, 2 green, 3 blue; 2 red, 5 blue, 5 green\n" +
            "Game 50: 1 red, 8 green, 3 blue; 1 blue, 9 green; 3 green, 6 blue\n" +
            "Game 51: 8 green, 8 red, 8 blue; 9 green, 2 red, 6 blue; 1 green, 1 red, 1 blue; 5 blue, 1 red, 7 green; 7 blue, 5 red, 5 green\n" +
            "Game 52: 2 green, 1 red; 4 blue, 7 red, 2 green; 3 red, 4 blue; 1 green, 1 blue, 7 red; 8 red, 1 green, 8 blue; 4 blue, 3 green, 4 red\n" +
            "Game 53: 9 blue, 9 red; 3 blue, 3 green, 5 red; 1 green, 6 blue, 2 red; 4 red, 3 green, 3 blue\n" +
            "Game 54: 1 blue, 2 red, 2 green; 6 green, 1 blue, 3 red; 1 green, 1 blue\n" +
            "Game 55: 14 red, 8 blue; 9 red, 2 green, 8 blue; 6 blue, 11 red, 1 green; 10 red, 3 blue, 4 green; 13 red, 2 green, 4 blue; 5 green, 5 blue, 3 red\n" +
            "Game 56: 12 green, 3 blue; 1 red, 13 green, 5 blue; 17 blue, 6 red, 2 green; 4 red, 12 green, 12 blue\n" +
            "Game 57: 9 green, 9 red, 10 blue; 10 blue, 10 red, 9 green; 4 blue, 14 red, 8 green; 14 red, 7 green; 10 green, 3 blue, 7 red; 1 red, 2 blue, 1 green\n" +
            "Game 58: 1 green, 9 red, 11 blue; 5 green, 11 red, 6 blue; 2 green, 3 red, 8 blue; 2 green, 14 blue, 4 red; 9 blue, 1 red\n" +
            "Game 59: 10 blue, 13 green, 3 red; 4 red, 12 green, 8 blue; 4 red, 9 blue, 10 green; 17 green, 5 red, 7 blue; 4 red, 3 blue, 10 green\n" +
            "Game 60: 4 green; 5 blue, 8 red; 19 red, 3 blue, 2 green; 4 green, 14 blue, 3 red\n" +
            "Game 61: 2 red, 6 blue; 15 blue, 5 red; 1 green, 2 red; 1 green, 2 blue, 8 red; 7 red, 10 blue; 11 blue\n" +
            "Game 62: 10 blue, 2 green, 7 red; 2 red, 2 green, 10 blue; 5 red\n" +
            "Game 63: 19 red; 1 green, 2 blue, 3 red; 1 blue, 11 red\n" +
            "Game 64: 11 red, 3 green; 3 red, 1 blue, 3 green; 2 green, 2 red, 4 blue; 9 red, 1 green; 3 green, 7 red, 4 blue; 9 red, 2 blue, 3 green\n" +
            "Game 65: 2 red, 12 green; 3 red, 3 green; 8 green, 1 blue, 4 red; 2 red, 3 green\n" +
            "Game 66: 4 blue, 11 red, 15 green; 1 blue, 2 green, 10 red; 4 red, 5 green; 16 red, 16 green, 4 blue\n" +
            "Game 67: 6 red, 1 green; 1 green, 1 blue, 12 red; 11 red, 2 blue\n" +
            "Game 68: 4 green, 5 red; 9 blue, 1 red; 1 green, 2 red, 7 blue; 6 red, 5 green, 8 blue; 2 green, 7 red, 2 blue\n" +
            "Game 69: 9 red, 16 green, 12 blue; 5 red, 4 green, 3 blue; 6 green, 11 blue, 6 red; 13 green, 16 blue, 7 red; 1 red, 8 blue, 14 green\n" +
            "Game 70: 7 red, 5 blue, 4 green; 6 red, 12 blue, 13 green; 5 green, 4 red, 8 blue; 9 blue, 5 green, 2 red\n" +
            "Game 71: 15 red, 3 green, 3 blue; 1 red, 5 green, 6 blue; 6 green, 7 blue, 16 red\n" +
            "Game 72: 4 blue, 4 green, 6 red; 9 green, 2 blue; 15 green, 5 red\n" +
            "Game 73: 1 green, 7 red; 6 red, 2 blue; 5 red, 9 blue; 12 blue, 9 red\n" +
            "Game 74: 6 blue, 4 red, 4 green; 17 green, 1 blue; 4 blue, 7 green, 4 red\n" +
            "Game 75: 3 green, 2 blue, 10 red; 17 red, 14 green, 2 blue; 2 green, 1 blue, 14 red; 16 red, 1 blue, 9 green; 14 red, 1 blue, 9 green\n" +
            "Game 76: 1 red, 10 green, 4 blue; 4 blue, 4 red, 7 green; 1 red, 2 blue, 15 green; 5 blue, 7 green, 1 red; 5 blue, 3 red, 17 green; 18 green, 4 blue, 1 red\n" +
            "Game 77: 4 green, 5 blue, 7 red; 3 blue, 4 red, 5 green; 1 red, 1 green; 6 green, 4 blue, 16 red\n" +
            "Game 78: 2 blue, 9 red; 7 red, 3 blue, 18 green; 2 blue, 12 green\n" +
            "Game 79: 3 red, 10 green, 10 blue; 10 blue, 12 green; 7 green, 10 blue, 3 red\n" +
            "Game 80: 10 green, 2 blue, 14 red; 3 blue, 4 red; 12 green; 3 red, 2 blue, 1 green; 10 red, 12 green, 2 blue\n" +
            "Game 81: 1 green, 3 red, 6 blue; 5 blue, 1 red, 1 green; 6 blue, 9 red\n" +
            "Game 82: 3 blue, 11 red, 20 green; 15 red, 5 green, 3 blue; 4 red, 7 green, 3 blue\n" +
            "Game 83: 5 red, 12 blue, 6 green; 11 green, 9 blue, 6 red; 6 green, 1 red, 7 blue; 16 blue, 4 red; 3 green, 6 blue\n" +
            "Game 84: 3 red, 3 blue, 2 green; 3 red, 9 green; 2 blue, 11 green, 1 red; 1 red, 11 green, 1 blue\n" +
            "Game 85: 11 green, 1 red, 2 blue; 6 red, 8 green, 14 blue; 3 red, 6 green, 15 blue; 9 blue, 7 red, 1 green; 19 blue, 2 green, 5 red; 6 blue, 7 red, 6 green\n" +
            "Game 86: 11 red, 4 green; 2 green, 1 blue, 10 red; 11 red, 3 blue, 9 green\n" +
            "Game 87: 2 green, 17 blue; 12 blue, 3 red, 2 green; 3 green, 2 blue, 13 red; 6 red, 3 green; 13 blue, 11 red, 3 green; 5 blue, 7 red, 1 green\n" +
            "Game 88: 1 red, 12 green; 4 green, 3 blue; 6 blue, 12 green; 1 red, 2 blue\n" +
            "Game 89: 9 green, 2 red, 12 blue; 19 green, 12 blue, 3 red; 2 red, 8 blue, 11 green; 13 blue, 8 red, 9 green\n" +
            "Game 90: 2 red, 2 blue, 7 green; 7 green, 2 red, 12 blue; 6 red, 9 green, 5 blue\n" +
            "Game 91: 14 blue, 2 red, 7 green; 7 blue, 7 green; 1 red, 5 green, 10 blue; 4 red, 7 blue, 4 green; 5 green, 1 red, 13 blue; 5 green, 1 red\n" +
            "Game 92: 6 green, 4 blue, 7 red; 18 blue, 3 red; 6 red, 2 blue; 16 blue, 5 red, 3 green\n" +
            "Game 93: 6 red, 17 blue, 5 green; 14 red, 16 blue, 10 green; 11 blue, 7 red, 11 green; 6 blue, 7 green, 3 red; 17 blue, 1 green\n" +
            "Game 94: 4 green, 9 blue; 2 green, 6 red, 3 blue; 5 red, 4 green, 8 blue; 4 green, 5 red, 6 blue; 7 green, 7 red, 6 blue\n" +
            "Game 95: 6 blue, 2 red, 3 green; 9 green, 2 blue; 2 red, 4 blue, 11 green; 4 blue, 4 red, 8 green; 13 green, 5 red, 7 blue; 4 red, 15 green, 2 blue\n" +
            "Game 96: 5 red, 8 blue, 5 green; 12 blue, 2 red; 15 blue, 2 red, 1 green; 4 red, 1 green\n" +
            "Game 97: 5 red, 5 blue; 1 red, 11 blue; 3 green, 10 blue; 3 green, 1 red, 7 blue; 2 blue, 6 red; 1 red, 1 green, 8 blue\n" +
            "Game 98: 4 red, 3 blue, 8 green; 5 blue, 2 red, 8 green; 7 green, 10 red, 2 blue; 11 blue, 9 red, 9 green; 6 blue, 10 green, 11 red\n" +
            "Game 99: 7 green, 3 red, 9 blue; 3 blue, 5 red, 4 green; 2 red, 6 green, 1 blue; 12 blue, 1 red, 1 green; 11 green, 1 red, 12 blue\n" +
            "Game 100: 2 blue, 1 red; 4 blue, 2 red, 1 green; 7 red, 5 blue; 2 red, 1 green, 5 blue";

}
