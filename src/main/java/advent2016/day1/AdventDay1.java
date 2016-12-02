package advent2016.day1;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AdventDay1 {

    public static String[] getStringArrayOfDirections(String input) {
        return input.split(", ");
    }

    public static Boolean getDirection(String direction) {
        Boolean isRight = direction.startsWith("R");
        return isRight;
    }

    public static Integer getDistance(String direction) {
        return Integer.parseInt(direction.substring(1));
    }

    public static void solution(String list) {
        String[] input = getStringArrayOfDirections(list);
        Set<Point> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add(new Point(x, y));
        String current = "NORTH";
        for (String d : input) {
            Boolean isRight = getDirection(d);
            Integer distance = getDistance(d);
            current = changeDirection(current, isRight);
            for (int i = 0; i < distance; i++) {
                x = x + findXCoord(current);
                y = y + findYCoord(current);
                Point p = new Point(x, y);
                if (visited.contains(p)) {
                    System.out.println("Already Visited: " + x + " , " + y);
                }
                visited.add(p);
            }
        }
        System.out.println("Blocks: " + (Math.abs(x)+Math.abs(y)));
    }

    private static Integer findXCoord(String current) {
        int x = 0;
        if (current.contentEquals("EAST")) {
            x = 1;
        } else if (current.contentEquals("WEST")) {
            x = -1;
        }
        return x;
    }

    private static Integer findYCoord(String current) {
        int y = 0;
        if (current.contentEquals("NORTH")) {
            y = 1;
        } else if (current.contentEquals("SOUTH")) {
            y = -1;
        }
        return y;
    }

    private static String changeDirection(String current, Boolean isRight) {
        if (current.contentEquals("NORTH")) {
            if (isRight) {
                return "EAST";
            } else {
                return "WEST";
            }
        } else if (current.contentEquals("SOUTH")) {
            if (isRight) {
                return "WEST";
            } else {
                return "EAST";
            }
        } else if (current.contentEquals("EAST")) {
            if (isRight) {
                return "SOUTH";
            } else {
                return "NORTH";
            }
        } else if (current.contentEquals("WEST")) {
            if (isRight) {
                return "NORTH";
            } else {
                return "SOUTH";
            }
        }
        return null;
    }

}