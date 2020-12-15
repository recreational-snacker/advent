package advent2020;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Day15Test {

    private String sample = "11,0,1,10,5,19";

    @Test
    public void test1() {
        process(sample);
    }

    private void process(String input) {
        Map<Integer, String> map = new HashMap<>();
        Integer currentNum = null;
        Integer previousNum = null;
        String[] ints = input.split(",");
        boolean firstOccurrence = false;
        boolean processInput = true;
        for (int j = 1; j < 30000001; j++) {
            if (processInput) {
                for (int i = 0; i < ints.length; i++) {
                    currentNum = Integer.parseInt(ints[i]);
                    saveNumber(currentNum, map, String.valueOf(i + 1));
                    if (i == ints.length - 1) {
                        firstOccurrence = true;
                    }
                    j = i+1;
                }
                processInput = false;
            } else {
                if (firstOccurrence) {
                    currentNum = 0;
                    saveNumber(currentNum, map, String.valueOf(j));
                    firstOccurrence = false;
                } else {
                    currentNum = determineCurrentNumber(map, previousNum);
                    if (!map.containsKey(currentNum)) {
                        firstOccurrence = true;
                    }
                    saveNumber(currentNum, map, String.valueOf(j));
                }
            }
            previousNum = currentNum;
            currentNum = null;
        }
        System.out.println(previousNum);
    }

    private void saveNumber(Integer currentNum, Map<Integer, String> map, String turn) {
        if (map.containsKey(currentNum)) {
            String[] turnCount = new String[2];
            String[] turns = map.get(currentNum).split(",");
            if (turns.length == 2) {
                turnCount[0] = turns[1];
                turnCount[1] = turn;
            } else {
                turnCount[0] = turns[0];
                turnCount[1] = turn;
            }
            map.put(currentNum, turnCount[0] + "," + turnCount[1]);
        } else {
            map.put(currentNum, turn);
        }
    }

    private Integer determineCurrentNumber(Map<Integer, String> map, Integer previousNum) {
        if (previousNum != null) {
            if (map.containsKey(previousNum)) {
                String[] previousNumTurns = map.get(previousNum).split(",");
                if (previousNumTurns.length == 2) {
                    return Integer.parseInt(previousNumTurns[1]) - Integer.parseInt(previousNumTurns[0]);
                } else {
                    return previousNum;
                }
            }
        } else {
            return 0;
        }
        return null;
    }

}
