package advent2023;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6Test {

    @Test
    public void sol1() {
        Map<Integer, Integer> timeDist = new HashMap<>();
        timeDist.put(44, 283);
        timeDist.put(70, 1134);
        timeDist.put(70, 1134);
        timeDist.put(80, 1491);

        Map<Integer, Integer> waysToWin = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : timeDist.entrySet()) {
            int wins = 0;
            Integer time = entry.getKey();
            Integer dist = entry.getValue();
            for (int i = 0; i <= time; i++) {
                int timeToMove = time-i;
                int speed = i;
                int distanceMoved = speed*timeToMove;
                if (distanceMoved>=dist) {
                    wins++;
                }
            }
            waysToWin.put(time, wins);
        }
        int total = 1;
        List<Integer> times = Arrays.asList(44, 70, 70, 80);
        for (Integer time : times) {
            total = total*waysToWin.get(time);
        }
        System.out.println(total);
    }

    @Test
    public void sol2() {
        Map<Long, Long> timeDist = new HashMap<>();
        timeDist.put(44707080L, 283113411341491L);
        Map<Long, Integer> waysToWin = new HashMap<>();
        for (Map.Entry<Long, Long> entry : timeDist.entrySet()) {
            int wins = 0;
            Long time = entry.getKey();
            Long dist = entry.getValue();
            for (int i = 0; i <= time; i++) {
                long timeToMove = time - (long) i;
                int speed = i;
                long distanceMoved = speed*timeToMove;
                if (distanceMoved>=dist) {
                    wins++;
                }
            }
            waysToWin.put(time, wins);
        }
        System.out.println(waysToWin.get(44707080L));
    }

    private String input =
            "Time:        44     70     70     80\n" +
            "Distance:   283   1134   1134   1491";

}
