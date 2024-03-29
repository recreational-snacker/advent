package advent2021;

import org.junit.Test;

public class Day2Test {

    @Test
    public void solution() {
      String[] splitString = input.split("\n");
      int horizontal = 0;
      int vertical = 0;
      int aim = 0;
      int horizontalAim = 0;
      int verticalAim = 0;
        for (String s : splitString) {
            String dir = s.split(" ")[0];
            Integer dist = Integer.parseInt(s.split(" ")[1]);
            if (dir.equalsIgnoreCase("forward")) {
                horizontal+=dist;
                horizontalAim+=dist;
                verticalAim += aim*dist;

            }
            if (dir.equalsIgnoreCase("down")) {
                vertical+=dist;
                aim+=dist;
            }
            if (dir.equalsIgnoreCase("up")) {
                vertical-=dist;
                aim-=dist;
            }
        }
        Integer sol1 = horizontal * vertical;
        System.out.println("solution 1: "+sol1);

        Integer sol2 = horizontalAim * verticalAim;
        System.out.println("solution 2: "+sol2);
    }

    private String input = "forward 8\n" +
            "down 9\n" +
            "up 4\n" +
            "down 8\n" +
            "down 3\n" +
            "down 3\n" +
            "down 2\n" +
            "forward 1\n" +
            "forward 4\n" +
            "down 5\n" +
            "up 7\n" +
            "forward 1\n" +
            "down 1\n" +
            "down 6\n" +
            "down 9\n" +
            "down 5\n" +
            "forward 5\n" +
            "forward 6\n" +
            "forward 4\n" +
            "down 2\n" +
            "down 8\n" +
            "forward 3\n" +
            "down 5\n" +
            "forward 6\n" +
            "up 7\n" +
            "up 2\n" +
            "forward 2\n" +
            "forward 4\n" +
            "forward 1\n" +
            "up 8\n" +
            "up 9\n" +
            "down 8\n" +
            "up 8\n" +
            "up 6\n" +
            "up 2\n" +
            "down 7\n" +
            "up 3\n" +
            "forward 8\n" +
            "forward 5\n" +
            "down 8\n" +
            "down 8\n" +
            "forward 5\n" +
            "down 3\n" +
            "down 4\n" +
            "down 5\n" +
            "down 2\n" +
            "up 7\n" +
            "down 1\n" +
            "forward 9\n" +
            "forward 9\n" +
            "up 6\n" +
            "down 5\n" +
            "up 1\n" +
            "down 8\n" +
            "up 1\n" +
            "forward 2\n" +
            "down 4\n" +
            "down 5\n" +
            "down 2\n" +
            "up 7\n" +
            "forward 9\n" +
            "up 8\n" +
            "down 3\n" +
            "up 6\n" +
            "down 2\n" +
            "up 2\n" +
            "forward 3\n" +
            "up 1\n" +
            "up 1\n" +
            "forward 9\n" +
            "down 3\n" +
            "down 5\n" +
            "up 7\n" +
            "down 1\n" +
            "up 5\n" +
            "up 5\n" +
            "up 7\n" +
            "down 9\n" +
            "down 3\n" +
            "up 3\n" +
            "forward 9\n" +
            "forward 7\n" +
            "up 9\n" +
            "down 3\n" +
            "down 2\n" +
            "up 8\n" +
            "forward 5\n" +
            "forward 9\n" +
            "down 5\n" +
            "down 2\n" +
            "down 9\n" +
            "down 6\n" +
            "down 6\n" +
            "up 3\n" +
            "forward 3\n" +
            "up 6\n" +
            "forward 9\n" +
            "down 3\n" +
            "down 2\n" +
            "forward 6\n" +
            "down 7\n" +
            "down 2\n" +
            "down 8\n" +
            "forward 2\n" +
            "forward 8\n" +
            "forward 4\n" +
            "forward 1\n" +
            "up 6\n" +
            "forward 2\n" +
            "forward 8\n" +
            "forward 5\n" +
            "forward 4\n" +
            "up 1\n" +
            "down 8\n" +
            "up 3\n" +
            "forward 8\n" +
            "forward 4\n" +
            "up 6\n" +
            "down 2\n" +
            "forward 6\n" +
            "forward 9\n" +
            "down 2\n" +
            "up 3\n" +
            "forward 8\n" +
            "down 6\n" +
            "up 4\n" +
            "down 7\n" +
            "up 3\n" +
            "forward 4\n" +
            "down 8\n" +
            "forward 5\n" +
            "forward 1\n" +
            "down 3\n" +
            "forward 1\n" +
            "forward 8\n" +
            "down 3\n" +
            "forward 4\n" +
            "forward 2\n" +
            "up 7\n" +
            "forward 6\n" +
            "forward 8\n" +
            "forward 6\n" +
            "down 5\n" +
            "down 2\n" +
            "down 8\n" +
            "down 2\n" +
            "down 9\n" +
            "down 5\n" +
            "down 3\n" +
            "down 8\n" +
            "up 1\n" +
            "forward 1\n" +
            "up 5\n" +
            "up 1\n" +
            "up 6\n" +
            "up 3\n" +
            "up 2\n" +
            "forward 5\n" +
            "forward 6\n" +
            "down 4\n" +
            "up 3\n" +
            "up 9\n" +
            "down 1\n" +
            "forward 1\n" +
            "forward 6\n" +
            "down 9\n" +
            "forward 5\n" +
            "forward 3\n" +
            "forward 2\n" +
            "down 7\n" +
            "down 5\n" +
            "down 8\n" +
            "forward 9\n" +
            "forward 4\n" +
            "down 2\n" +
            "up 9\n" +
            "down 1\n" +
            "forward 5\n" +
            "forward 1\n" +
            "forward 9\n" +
            "down 8\n" +
            "forward 5\n" +
            "down 8\n" +
            "forward 3\n" +
            "up 4\n" +
            "down 7\n" +
            "down 9\n" +
            "forward 3\n" +
            "forward 7\n" +
            "down 9\n" +
            "up 5\n" +
            "up 7\n" +
            "forward 8\n" +
            "down 3\n" +
            "down 9\n" +
            "down 1\n" +
            "forward 3\n" +
            "down 1\n" +
            "up 9\n" +
            "forward 6\n" +
            "down 9\n" +
            "forward 1\n" +
            "forward 5\n" +
            "down 6\n" +
            "up 7\n" +
            "forward 9\n" +
            "down 9\n" +
            "forward 6\n" +
            "down 3\n" +
            "up 6\n" +
            "up 2\n" +
            "up 1\n" +
            "up 9\n" +
            "down 9\n" +
            "forward 4\n" +
            "forward 6\n" +
            "up 7\n" +
            "forward 2\n" +
            "down 5\n" +
            "forward 7\n" +
            "down 5\n" +
            "forward 4\n" +
            "down 8\n" +
            "up 3\n" +
            "down 1\n" +
            "forward 5\n" +
            "down 5\n" +
            "up 6\n" +
            "down 6\n" +
            "forward 4\n" +
            "down 8\n" +
            "down 6\n" +
            "down 7\n" +
            "down 9\n" +
            "down 4\n" +
            "forward 5\n" +
            "down 8\n" +
            "down 7\n" +
            "forward 3\n" +
            "forward 5\n" +
            "up 8\n" +
            "down 4\n" +
            "down 1\n" +
            "up 6\n" +
            "up 9\n" +
            "down 2\n" +
            "down 2\n" +
            "up 1\n" +
            "up 7\n" +
            "forward 1\n" +
            "down 1\n" +
            "down 4\n" +
            "down 8\n" +
            "forward 1\n" +
            "forward 3\n" +
            "down 8\n" +
            "up 9\n" +
            "forward 1\n" +
            "down 6\n" +
            "forward 3\n" +
            "down 9\n" +
            "down 2\n" +
            "up 8\n" +
            "forward 5\n" +
            "up 1\n" +
            "forward 9\n" +
            "down 4\n" +
            "forward 3\n" +
            "up 6\n" +
            "up 4\n" +
            "down 9\n" +
            "down 8\n" +
            "down 3\n" +
            "forward 6\n" +
            "forward 6\n" +
            "down 1\n" +
            "down 2\n" +
            "down 2\n" +
            "down 2\n" +
            "up 7\n" +
            "down 2\n" +
            "forward 9\n" +
            "down 3\n" +
            "up 5\n" +
            "forward 9\n" +
            "up 5\n" +
            "forward 1\n" +
            "down 1\n" +
            "forward 7\n" +
            "down 8\n" +
            "down 9\n" +
            "down 1\n" +
            "forward 8\n" +
            "up 1\n" +
            "forward 8\n" +
            "down 1\n" +
            "forward 9\n" +
            "down 8\n" +
            "down 2\n" +
            "forward 4\n" +
            "up 2\n" +
            "down 7\n" +
            "forward 6\n" +
            "forward 6\n" +
            "forward 4\n" +
            "up 8\n" +
            "up 2\n" +
            "down 8\n" +
            "up 7\n" +
            "forward 2\n" +
            "forward 6\n" +
            "forward 3\n" +
            "up 5\n" +
            "forward 9\n" +
            "down 9\n" +
            "forward 6\n" +
            "up 2\n" +
            "down 6\n" +
            "forward 4\n" +
            "forward 5\n" +
            "down 3\n" +
            "up 2\n" +
            "forward 3\n" +
            "forward 2\n" +
            "up 7\n" +
            "down 1\n" +
            "up 1\n" +
            "up 8\n" +
            "down 4\n" +
            "forward 7\n" +
            "forward 2\n" +
            "up 2\n" +
            "down 4\n" +
            "forward 4\n" +
            "forward 2\n" +
            "forward 2\n" +
            "down 8\n" +
            "down 2\n" +
            "down 2\n" +
            "forward 6\n" +
            "up 2\n" +
            "up 9\n" +
            "down 1\n" +
            "down 7\n" +
            "forward 9\n" +
            "forward 4\n" +
            "up 8\n" +
            "forward 2\n" +
            "forward 5\n" +
            "down 3\n" +
            "down 6\n" +
            "down 4\n" +
            "forward 7\n" +
            "up 1\n" +
            "forward 7\n" +
            "down 8\n" +
            "up 2\n" +
            "down 8\n" +
            "forward 6\n" +
            "down 3\n" +
            "up 9\n" +
            "up 6\n" +
            "up 6\n" +
            "forward 5\n" +
            "forward 1\n" +
            "forward 3\n" +
            "forward 3\n" +
            "down 7\n" +
            "down 3\n" +
            "forward 8\n" +
            "forward 2\n" +
            "down 7\n" +
            "down 1\n" +
            "up 4\n" +
            "forward 2\n" +
            "forward 1\n" +
            "up 6\n" +
            "forward 9\n" +
            "up 4\n" +
            "forward 5\n" +
            "up 4\n" +
            "forward 3\n" +
            "down 1\n" +
            "forward 6\n" +
            "forward 2\n" +
            "down 3\n" +
            "down 7\n" +
            "forward 7\n" +
            "down 4\n" +
            "forward 6\n" +
            "down 8\n" +
            "forward 5\n" +
            "up 9\n" +
            "up 9\n" +
            "forward 4\n" +
            "forward 8\n" +
            "down 6\n" +
            "down 7\n" +
            "forward 1\n" +
            "up 4\n" +
            "forward 9\n" +
            "forward 7\n" +
            "forward 2\n" +
            "forward 6\n" +
            "up 4\n" +
            "forward 4\n" +
            "down 3\n" +
            "down 2\n" +
            "up 4\n" +
            "forward 4\n" +
            "forward 3\n" +
            "up 8\n" +
            "forward 8\n" +
            "down 9\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 7\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 3\n" +
            "up 2\n" +
            "down 4\n" +
            "forward 1\n" +
            "up 3\n" +
            "forward 4\n" +
            "down 7\n" +
            "down 9\n" +
            "down 6\n" +
            "up 7\n" +
            "down 2\n" +
            "down 5\n" +
            "forward 7\n" +
            "up 6\n" +
            "down 2\n" +
            "forward 4\n" +
            "down 9\n" +
            "up 8\n" +
            "forward 6\n" +
            "down 4\n" +
            "down 3\n" +
            "up 9\n" +
            "down 6\n" +
            "down 9\n" +
            "up 3\n" +
            "down 2\n" +
            "forward 3\n" +
            "down 1\n" +
            "forward 1\n" +
            "forward 5\n" +
            "down 7\n" +
            "forward 2\n" +
            "down 8\n" +
            "down 8\n" +
            "down 7\n" +
            "forward 5\n" +
            "forward 9\n" +
            "forward 9\n" +
            "forward 2\n" +
            "up 5\n" +
            "down 2\n" +
            "forward 3\n" +
            "down 2\n" +
            "forward 9\n" +
            "up 1\n" +
            "forward 1\n" +
            "up 6\n" +
            "down 1\n" +
            "forward 4\n" +
            "down 5\n" +
            "forward 2\n" +
            "up 7\n" +
            "up 4\n" +
            "up 3\n" +
            "forward 6\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 6\n" +
            "forward 6\n" +
            "down 2\n" +
            "down 8\n" +
            "up 9\n" +
            "forward 2\n" +
            "down 4\n" +
            "forward 4\n" +
            "forward 9\n" +
            "up 9\n" +
            "down 4\n" +
            "up 7\n" +
            "down 6\n" +
            "up 2\n" +
            "up 7\n" +
            "down 5\n" +
            "down 6\n" +
            "down 8\n" +
            "down 1\n" +
            "forward 6\n" +
            "forward 6\n" +
            "forward 7\n" +
            "down 3\n" +
            "forward 3\n" +
            "forward 8\n" +
            "forward 1\n" +
            "forward 2\n" +
            "down 8\n" +
            "forward 6\n" +
            "down 6\n" +
            "forward 8\n" +
            "forward 3\n" +
            "forward 6\n" +
            "down 4\n" +
            "down 2\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 8\n" +
            "down 3\n" +
            "down 3\n" +
            "down 4\n" +
            "up 1\n" +
            "forward 3\n" +
            "down 2\n" +
            "down 3\n" +
            "down 9\n" +
            "down 3\n" +
            "down 8\n" +
            "down 1\n" +
            "down 6\n" +
            "forward 5\n" +
            "down 5\n" +
            "down 7\n" +
            "up 3\n" +
            "forward 5\n" +
            "down 7\n" +
            "down 7\n" +
            "forward 6\n" +
            "down 6\n" +
            "up 6\n" +
            "forward 2\n" +
            "up 9\n" +
            "down 3\n" +
            "forward 3\n" +
            "forward 4\n" +
            "up 6\n" +
            "down 7\n" +
            "forward 1\n" +
            "up 8\n" +
            "forward 3\n" +
            "down 1\n" +
            "forward 6\n" +
            "forward 7\n" +
            "down 5\n" +
            "down 6\n" +
            "down 8\n" +
            "up 6\n" +
            "down 4\n" +
            "down 5\n" +
            "down 1\n" +
            "up 1\n" +
            "up 9\n" +
            "up 4\n" +
            "forward 2\n" +
            "down 5\n" +
            "down 7\n" +
            "forward 5\n" +
            "forward 2\n" +
            "up 1\n" +
            "down 7\n" +
            "up 6\n" +
            "forward 5\n" +
            "down 5\n" +
            "down 9\n" +
            "up 4\n" +
            "down 6\n" +
            "forward 8\n" +
            "down 5\n" +
            "forward 6\n" +
            "forward 1\n" +
            "forward 5\n" +
            "forward 4\n" +
            "down 2\n" +
            "down 7\n" +
            "up 7\n" +
            "down 9\n" +
            "down 7\n" +
            "up 4\n" +
            "down 3\n" +
            "up 9\n" +
            "forward 3\n" +
            "up 1\n" +
            "up 7\n" +
            "forward 4\n" +
            "forward 6\n" +
            "up 2\n" +
            "forward 2\n" +
            "forward 4\n" +
            "down 6\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 9\n" +
            "forward 4\n" +
            "forward 8\n" +
            "up 9\n" +
            "up 4\n" +
            "forward 1\n" +
            "forward 3\n" +
            "down 5\n" +
            "down 4\n" +
            "up 6\n" +
            "up 2\n" +
            "forward 9\n" +
            "up 9\n" +
            "up 2\n" +
            "forward 6\n" +
            "down 5\n" +
            "up 7\n" +
            "forward 3\n" +
            "forward 4\n" +
            "down 5\n" +
            "up 8\n" +
            "forward 7\n" +
            "forward 3\n" +
            "up 5\n" +
            "down 7\n" +
            "down 6\n" +
            "forward 9\n" +
            "up 2\n" +
            "forward 5\n" +
            "down 2\n" +
            "down 9\n" +
            "forward 1\n" +
            "down 4\n" +
            "forward 3\n" +
            "up 9\n" +
            "down 2\n" +
            "up 5\n" +
            "down 8\n" +
            "forward 1\n" +
            "up 9\n" +
            "up 7\n" +
            "up 1\n" +
            "forward 7\n" +
            "forward 1\n" +
            "forward 7\n" +
            "down 2\n" +
            "up 6\n" +
            "forward 6\n" +
            "down 1\n" +
            "forward 1\n" +
            "down 7\n" +
            "down 9\n" +
            "forward 9\n" +
            "up 3\n" +
            "forward 3\n" +
            "down 1\n" +
            "forward 1\n" +
            "forward 9\n" +
            "down 7\n" +
            "forward 2\n" +
            "down 7\n" +
            "forward 2\n" +
            "forward 4\n" +
            "down 5\n" +
            "down 5\n" +
            "forward 5\n" +
            "down 9\n" +
            "down 4\n" +
            "forward 3\n" +
            "down 4\n" +
            "down 3\n" +
            "down 3\n" +
            "down 2\n" +
            "forward 1\n" +
            "up 8\n" +
            "forward 1\n" +
            "forward 5\n" +
            "forward 1\n" +
            "forward 2\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 8\n" +
            "forward 7\n" +
            "down 5\n" +
            "up 6\n" +
            "forward 8\n" +
            "down 9\n" +
            "up 3\n" +
            "up 2\n" +
            "down 4\n" +
            "up 1\n" +
            "forward 6\n" +
            "up 6\n" +
            "forward 9\n" +
            "forward 3\n" +
            "down 3\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 6\n" +
            "down 4\n" +
            "up 6\n" +
            "forward 4\n" +
            "up 8\n" +
            "down 4\n" +
            "down 8\n" +
            "down 3\n" +
            "down 1\n" +
            "down 6\n" +
            "down 7\n" +
            "down 8\n" +
            "down 2\n" +
            "down 5\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 7\n" +
            "down 1\n" +
            "down 5\n" +
            "forward 9\n" +
            "down 6\n" +
            "forward 6\n" +
            "forward 7\n" +
            "forward 4\n" +
            "forward 2\n" +
            "forward 2\n" +
            "up 6\n" +
            "forward 9\n" +
            "up 6\n" +
            "down 1\n" +
            "forward 4\n" +
            "down 2\n" +
            "up 3\n" +
            "forward 5\n" +
            "up 1\n" +
            "forward 4\n" +
            "forward 4\n" +
            "up 4\n" +
            "down 7\n" +
            "down 5\n" +
            "up 4\n" +
            "forward 5\n" +
            "up 8\n" +
            "up 4\n" +
            "up 2\n" +
            "up 8\n" +
            "forward 6\n" +
            "down 9\n" +
            "down 8\n" +
            "down 4\n" +
            "down 4\n" +
            "up 9\n" +
            "forward 4\n" +
            "forward 5\n" +
            "forward 4\n" +
            "forward 9\n" +
            "down 7\n" +
            "down 4\n" +
            "down 3\n" +
            "down 7\n" +
            "forward 3\n" +
            "forward 1\n" +
            "down 1\n" +
            "forward 5\n" +
            "forward 6\n" +
            "down 1\n" +
            "forward 3\n" +
            "down 7\n" +
            "up 4\n" +
            "forward 4\n" +
            "forward 7\n" +
            "up 1\n" +
            "up 9\n" +
            "down 7\n" +
            "down 5\n" +
            "up 8\n" +
            "forward 3\n" +
            "forward 5\n" +
            "forward 3\n" +
            "down 6\n" +
            "down 1\n" +
            "down 9\n" +
            "up 9\n" +
            "forward 5\n" +
            "down 1\n" +
            "down 1\n" +
            "down 8\n" +
            "forward 8\n" +
            "up 2\n" +
            "down 1\n" +
            "down 2\n" +
            "down 6\n" +
            "down 3\n" +
            "forward 7\n" +
            "forward 1\n" +
            "down 4\n" +
            "up 9\n" +
            "down 7\n" +
            "down 6\n" +
            "down 9\n" +
            "forward 5\n" +
            "forward 4\n" +
            "forward 9\n" +
            "up 7\n" +
            "forward 5\n" +
            "down 6\n" +
            "forward 9\n" +
            "forward 2\n" +
            "forward 8\n" +
            "up 9\n" +
            "forward 2\n" +
            "down 8\n" +
            "up 8\n" +
            "down 8\n" +
            "down 8\n" +
            "forward 2\n" +
            "down 1\n" +
            "forward 5\n" +
            "down 4\n" +
            "up 2\n" +
            "forward 8\n" +
            "up 4\n" +
            "up 8\n" +
            "forward 4\n" +
            "forward 6\n" +
            "forward 6\n" +
            "forward 3\n" +
            "forward 5\n" +
            "forward 4\n" +
            "down 6\n" +
            "up 6\n" +
            "forward 7\n" +
            "up 3\n" +
            "down 1\n" +
            "down 1\n" +
            "down 9\n" +
            "forward 6\n" +
            "down 9\n" +
            "forward 2\n" +
            "down 7\n" +
            "down 2\n" +
            "down 5\n" +
            "forward 3\n" +
            "down 4\n" +
            "down 8\n" +
            "down 3\n" +
            "forward 6\n" +
            "up 9\n" +
            "forward 1\n" +
            "forward 4\n" +
            "forward 8\n" +
            "up 9\n" +
            "down 5\n" +
            "up 5\n" +
            "up 9\n" +
            "forward 6\n" +
            "up 2\n" +
            "forward 7\n" +
            "up 5\n" +
            "forward 8\n" +
            "forward 6\n" +
            "down 2\n" +
            "down 7\n" +
            "up 8\n" +
            "up 3\n" +
            "forward 4\n" +
            "forward 1\n" +
            "down 8\n" +
            "down 4\n" +
            "forward 6\n" +
            "forward 6\n" +
            "up 6\n" +
            "up 3\n" +
            "up 7\n" +
            "forward 6\n" +
            "up 2\n" +
            "down 8\n" +
            "forward 1\n" +
            "forward 3\n" +
            "down 3\n" +
            "forward 8\n" +
            "forward 5\n" +
            "forward 3\n" +
            "forward 9\n" +
            "down 6\n" +
            "forward 9\n" +
            "up 7\n" +
            "down 3\n" +
            "down 8\n" +
            "forward 4\n" +
            "down 9\n" +
            "up 8\n" +
            "up 1\n" +
            "forward 2\n" +
            "down 2\n" +
            "forward 1\n" +
            "down 8\n" +
            "forward 7\n" +
            "up 4\n" +
            "down 1\n" +
            "forward 8\n" +
            "down 2\n" +
            "forward 3\n" +
            "forward 9\n" +
            "down 7\n" +
            "up 4\n" +
            "up 2\n" +
            "forward 1\n" +
            "down 2\n" +
            "up 8\n" +
            "forward 4\n" +
            "down 1\n" +
            "forward 5\n" +
            "forward 1\n" +
            "down 5\n" +
            "forward 1\n" +
            "up 2\n" +
            "forward 6\n" +
            "down 5\n" +
            "down 8\n" +
            "down 3\n" +
            "down 2\n" +
            "forward 1\n" +
            "forward 5\n" +
            "down 8\n" +
            "down 1\n" +
            "forward 5\n" +
            "down 7\n" +
            "down 4\n" +
            "forward 5\n" +
            "down 1\n" +
            "down 1\n" +
            "forward 9\n" +
            "down 7\n" +
            "up 9\n" +
            "down 6\n" +
            "forward 4\n" +
            "up 8\n" +
            "forward 6\n" +
            "forward 1\n" +
            "up 6\n" +
            "forward 3\n" +
            "down 3\n" +
            "up 6\n" +
            "forward 2\n" +
            "down 2\n" +
            "forward 3\n" +
            "down 2\n" +
            "up 4\n" +
            "down 6\n" +
            "forward 4\n" +
            "down 6\n" +
            "down 4\n" +
            "up 2\n" +
            "down 2\n" +
            "up 5\n" +
            "up 2\n" +
            "down 9\n" +
            "down 5\n" +
            "forward 1\n" +
            "down 6\n" +
            "forward 4\n" +
            "forward 9\n" +
            "down 1\n" +
            "down 9\n" +
            "forward 3\n" +
            "forward 8\n" +
            "forward 9\n" +
            "down 4\n" +
            "down 1\n" +
            "up 1\n" +
            "up 7\n" +
            "down 5\n" +
            "down 3\n" +
            "down 2\n" +
            "down 8\n" +
            "forward 5\n" +
            "up 1\n" +
            "down 4\n" +
            "down 8\n" +
            "down 8\n" +
            "forward 1\n" +
            "down 5\n" +
            "forward 7\n" +
            "forward 9\n" +
            "forward 5\n" +
            "forward 2\n" +
            "down 9\n" +
            "up 1\n" +
            "down 6\n" +
            "down 5\n" +
            "forward 4\n" +
            "forward 3\n" +
            "down 4\n" +
            "down 3\n" +
            "down 8\n" +
            "forward 6\n" +
            "down 2\n" +
            "forward 7\n" +
            "down 7\n" +
            "forward 8\n" +
            "forward 1\n" +
            "forward 7\n" +
            "forward 8\n" +
            "forward 6";
}
