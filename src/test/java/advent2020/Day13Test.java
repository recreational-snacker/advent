package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13Test {

    private String sample = "939\n" +
            "1789,37,47,1889";

    private String input = "1008141\n" +
            "17,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,523,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,13,19,x,x,x,23,x,x,x,x,x,x,x,787,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29";

    private Integer returnTimeFromInput(String input) {
        return Integer.parseInt(input.split("\n")[0]);
    }

    private List<Integer> getValidTimes(String input) {
        List<Integer> numList = new ArrayList<>();
        for (String s : input.split("\n")[1].split(",")) {
            if (!s.equals("x")) {
                numList.add(Integer.parseInt(s));
            }
        }
        return numList;
    }

    private Integer calculateTimeClosestToInputTime(Integer target, Integer input) {
        Integer calc = 0;
        int count = 1;
        while (calc < target) {
            calc = input * count;
            count++;
        }
        return calc - target;
    }

    private Integer findClosestTimeForInputs(String input) {
        Integer target = returnTimeFromInput(input);
        int lowest = 0;
        int bus = 0;
        List<Integer> numList = getValidTimes(input);
        for (Integer i : numList) {
            Integer time = calculateTimeClosestToInputTime(target, i);
            if (lowest == 0 || time < lowest) {
                lowest = time;
                bus = i;
            }
        }
        System.out.println(bus+" "+lowest);
        return bus * lowest;
    }

    private Map<Integer, Integer> getBusDepatureSeq(String input) {
        Map<Integer, Integer> busTimes = new HashMap<>();
        int count = 0;
        for (String s : input.split("\n")[1].split(",")) {
            if (!s.equals("x")) {
                busTimes.put(Integer.parseInt(s), count);
            }
            count++;
        }
        return busTimes;
    }

    private void findCorrectBusSequence(long minStart, String input) {
        Map<Integer, Integer> busTimes = getBusDepatureSeq(input);
        int firstTime = getFirstTime(busTimes);
        minStart = findCorrectMinStart(minStart, firstTime);
        boolean loop = true;
        while (loop) {
            List<Boolean> check = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : busTimes.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                long departureTime = minStart + v;
                long mod = departureTime % k;
                if (mod == 0) {
                    check.add(true);
                } else {
                    break;
                }
            }
            if (check.size()==busTimes.size() && !check.contains(false)) {
                loop = false;
                System.out.println(minStart);
            }
            minStart+=firstTime;
        }
    }

    private long findCorrectMinStart(long minStart, int firstTime) {
        boolean count = true;
        long start = 0;
        while (count) {
            start+=firstTime;
            if (start > minStart) {
                count = false;
            }
        }
        return start;
    }

    private int getFirstTime(Map<Integer, Integer> busTimes) {
        for (Map.Entry<Integer, Integer> entry : busTimes.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v.equals(0)) {
                return k;
            }
        }
        return 1;
    }

    @Test
    public void test() {
//        System.out.println(findClosestTimeForInputs(input));
//        findCorrectBusSequence(0L, sample);
        findCorrectBusSequence(100000000000000L, input);
    }
}
