package advent2018;

import org.junit.Test;

import java.util.*;

public class Advent2018Day7Test {

    private String testInput = "Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin.";

    @Test
    public void sumOfItsParts() {
        String[] inputArray = testInput.split("\n");

        Map<String, String> directions = new HashMap<>();
        for (String s : inputArray) {
            String[] line = s.split(" ");
            String first = line[1];
            String second = line[7];
            if (directions.containsKey(first)) {
                directions.put(first, directions.get(first) + "," + second);
            } else {
                directions.put(first, second);
            }
        }

        String firstPart = null;
        for (Map.Entry<String, String> entry : directions.entrySet()) {
            List<String> list = new ArrayList<>(directions.values());
            boolean found = false;
            for (String s : list) {
                if (s.contains(entry.getKey())) {
                    found = true;
                }
            }
            if (!found) {
                firstPart = entry.getKey();
            }
        }
        System.out.println("First step: " + firstPart);

        for (Map.Entry<String, String> entry : directions.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        ArrayList<String> process = new ArrayList<>();
        process.add(0, firstPart);
        for (int i = 0; i < directions.size(); i++) {
            String currentStep = process.get(i);
            String nextSteps = directions.get(currentStep);
            List<String> nextStepsList = Arrays.asList(nextSteps.split(","));
            Collections.sort(nextStepsList);
            for (int i1 = 0; i1 < nextStepsList.size(); i1++) {
                process.add(i + 1 + i1, nextStepsList.get(i1));
            }
        }
    }
}
