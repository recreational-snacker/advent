package advent2018;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Advent2018Day11Test {

    private int input = 1723;

    private int testInput = 42;

    @Test
    public void part1() {
        int serial = input;
        Map<String, Integer> powerLevels = new HashMap<>();
        for (int x = 1; x < 301; x++) {
            for (int y = 1; y < 301; y++) {
                int rackId = x + 10;
                int powerLevel = rackId * y;
                powerLevel += serial;
                powerLevel *= rackId;
                String power = String.valueOf(powerLevel);
                if (power.length() < 3) {
                    powerLevel = 0;
                } else {
                    powerLevel = Integer.parseInt(power.substring(power.length() - 3, power.length() - 2));
                }
                powerLevel -= 5;
                powerLevels.put(x + "," + y, powerLevel);
            }
        }

        Map<String, Integer> totalPowerSets = getTotalPowerCalcMap(powerLevels, 3);
        System.out.println("Max power: " + findMaxInMap(totalPowerSets));

        Map<String, Integer> totalPowerSetsForVariableSize = null;
        String coord = null;
        int maxPower = 0;
        for (int i = 1; i < 301; i++) {
            totalPowerSetsForVariableSize = getTotalPowerCalcMap(powerLevels, i);
            for (Map.Entry<String, Integer> entry : totalPowerSetsForVariableSize.entrySet()) {
                if (entry.getValue() > maxPower) {
                    maxPower = entry.getValue();
                    coord = entry.getKey();
                }
            }
            System.out.println("Max power for variable sets" + coord + " - " + maxPower);
        }
    }

    private String findMaxInMap(Map<String, Integer> totalPowerSets) {
        String coord = null;
        int maxPower = 0;
        for (Map.Entry<String, Integer> entry : totalPowerSets.entrySet()) {
            if (entry.getValue() > maxPower) {
                maxPower = entry.getValue();
                coord = entry.getKey();
            }
        }
        return coord + " - " + maxPower;
    }

    private Map<String, Integer> getTotalPowerCalcMap(Map<String, Integer> powerLevels, int max) {
        Map<String, Integer> totalPowerSets = new HashMap<>();
        for (Map.Entry<String, Integer> entry : powerLevels.entrySet()) {
            String startingCoord = entry.getKey();
            String startingCoordAndSize = startingCoord + "," + max;
            int totalPower = 0;
            int xCoord = Integer.parseInt(startingCoord.split(",")[0]);
            int yCoord = Integer.parseInt(startingCoord.split(",")[1]);

            for (int x = 0; x < max; x++) {
                int newXCoord = xCoord + x;
                if (newXCoord > 300) {
                    break;
                }
                for (int y = 0; y < max; y++) {
                    int newYCoord = yCoord + y;
                    if (newYCoord > 300) {
                        break;
                    }
                    String getNextCoord = newXCoord + "," + newYCoord;
                    Integer additionalPower = powerLevels.get(getNextCoord);
                    if (additionalPower != null) {
                        totalPower += additionalPower;
                    }
                }
            }
            totalPowerSets.put(startingCoordAndSize, totalPower);
        }
        return totalPowerSets;
    }
}
