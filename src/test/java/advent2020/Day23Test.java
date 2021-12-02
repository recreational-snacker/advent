package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day23Test {

    private String sample = "389125467";

    private void sol1(String input) {
        List<String> splitList = new ArrayList<>(Arrays.asList(input.split("")));

        Integer min = findMin(splitList);
        Integer max = findMax(splitList);

        int turn = 1;
        List<String> loopList = new ArrayList<>(splitList);
        System.out.println("Turn "+ turn + " " +Arrays.toString(loopList.toArray()));

        for (int i = 0; i < loopList.size(); i++) {
            Integer current = Integer.parseInt(splitList.get(i));

            Integer one = Integer.parseInt(splitList.get(i+1));
            Integer two = Integer.parseInt(splitList.get(i+2));
            Integer three = Integer.parseInt(splitList.get(i+3));

            splitList.remove(loopList.get(i+1));
            splitList.remove(loopList.get(i+2));
            splitList.remove(loopList.get(i+3));

            Integer destination = null;
            Integer destIndex = null;
            while (destination == null) {
                int count = 1;
                Integer valueToFind = current - count;
                if (valueToFind < min) {
                    valueToFind = max;
                }
                if (splitList.contains(valueToFind.toString())) {
                    destination = valueToFind;
                    destIndex = splitList.indexOf(destination.toString());
                    break;
                }
                if (!splitList.contains(valueToFind.toString())) {
                    current = valueToFind;
                }
            }

            splitList.add(destIndex+1, one.toString());
            splitList.add(destIndex+2, two.toString());
            splitList.add(destIndex+3, three.toString());
            loopList = new ArrayList<>(splitList);
            turn +=1;
            System.out.println("Turn "+ turn + " " +Arrays.toString(loopList.toArray()));
        }

    }

    private Integer findMin(List<String> splitList) {
        Integer min = null;
        for (String s : splitList) {
            Integer i = Integer.parseInt(s);
            if (min == null) {
                min = i;
            }
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    private Integer findMax(List<String> splitList) {
        Integer min = null;
        for (String s : splitList) {
            Integer i = Integer.parseInt(s);
            if (min == null) {
                min = i;
            }
            if (min < i) {
                min = i;
            }
        }
        return min;
    }

    @Test
    public void test() {
        sol1(sample);
    }

}
