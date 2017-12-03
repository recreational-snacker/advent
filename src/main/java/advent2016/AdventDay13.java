package advent2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deesha Singh on 2016/12/14.
 */
public class AdventDay13 {

    static Map<Integer, String> room = new HashMap<>();

    public static void createRoom(int fave, int sizeX, int sizeY, int destX, int destY) {
        for (int y = 0; y < sizeY; y++) {
            String row = "";
            for (int x = 0; x < sizeX; x++) {
                if (isOpenSpace(x, y, fave)) {
                    row += ".";
                } else {
                    row += "#";
                }
            }
            System.out.println(row);
            room.put(y, row);
        }
        countSteps(destX, destY);
    }

    static int startX = 1;
    static int startY = 1;
    static int currentX = startX;
    static int currentY = startY;
    static int steps = 0;

    public static void countSteps(int destX, int destY) {
        Boolean finished = false;
        if (currentX == destX && currentY == destY) {
            finished = true;
        }
        while (!finished) {
            String[] row = room.get(currentY).split("");
            if (destX - currentX > 0) {
                if (row[currentX + 1].equalsIgnoreCase(".")) {
                    //move horizontally
                    moveHorizontally(">");
                    steps++;
                } else {
                    moveHorizontally("<");
                    steps--;
                }
            }
            if (destY - currentY > 0) {
                String[] nextRow = room.get(currentY + 1).split("");
                if (nextRow[currentX].equalsIgnoreCase(".")) {
                    //move down
                    moveVertically("v");
                    steps++;
                } else {
                    moveHorizontally("<");
                    steps--;
                }
            }
        }
        System.out.println("Steps: " + steps);
    }

    public static void moveHorizontally(String dir) {
        if (dir.equalsIgnoreCase(">")) {
            currentX += 1;
        } else {
            currentX -= 1;
        }
    }

    public static void moveVertically(String dir) {
        if (dir.equalsIgnoreCase("v")) {
            currentY += 1;
        } else {
            currentY -= 1;
        }
    }

//    public static void moveHorizontally(int steps, int destX) {
//        int startX = 1;
//        int startY = 1;
//        int currentX = startX;
//        int currentY = startY;
//        int steps = 0;
//        String[] row = room.get(startY).split("");
//        for (int i = startX+1; i < row.length; i++) {
//            if (row[i].equalsIgnoreCase(".")) {
//                System.out.println("open");
//                currentX = i;
//                steps++;
//            } else {
//                break;
//            }
//        }
//    }
//
//    public static void moveHorizontally(int destX, int destY) {
//        int startX = 1;
//        int startY = 1;
//        int currentX = startX;
//        int currentY = startY;
//        int steps = 0;
//        String[] row = room.get(startY).split("");
//        for (int i = startX+1; i < row.length; i++) {
//            if (row[i].equalsIgnoreCase(".")) {
//                System.out.println("open");
//                currentX = i;
//                steps++;
//            } else {
//                break;
//            }
//        }
//    }

    public static Boolean isOpenSpace(int x, int y, int fave) {
        Boolean isOpen = false;
        int calc = (x * x + 3 * x + 2 * x * y + y + y * y) + fave;
        String binary = Integer.toBinaryString(calc);
//        System.out.println(binary);
        String[] binaryList = binary.split("");
        int count = 0;
        for (String s : binaryList) {
            if (s.equalsIgnoreCase("1")) {
                count++;
            }
        }
        if (count % 2 == 0) {
            isOpen = true;
        }
//        System.out.println(isOpen);
        return isOpen;
    }
}
