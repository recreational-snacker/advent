package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10Test {

    private String sample1 = "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4";

    private String sample2 = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

    private List<Integer> splitList(String input) {
        List<Integer> ints = new ArrayList<>();
        String[] integers = input.split("\n");
        for (String s : integers) {
            ints.add(Integer.parseInt(s));
        }
        ints.add(0);
        Collections.sort(ints);
        ints.add(ints.get(ints.size() - 1) + 3);
        return ints;
    }

    private Map<Integer, Integer> findJoltDifferences(String input) {
        List<Integer> ints = splitList(input);
        int currentJolt = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 0);
        counts.put(1,0);
        counts.put(2,0);
        counts.put(3,0);
        for (Integer i : ints) {
            int diff = i - currentJolt;
            counts.put(diff, counts.get(diff)+1);
            currentJolt = i;
        }
        return counts;
    }

    private Integer findMultipliedDifferences(String input) {
        Map<Integer, Integer> diffs = findJoltDifferences(input);
        return diffs.get(1) * diffs.get(3);
    }

    private void part2(String input) {
        List<Integer> inputs = splitList(input);
        Map<Integer, List<Integer>> possibleConnections = new HashMap<>();
        for (int i = inputs.size() - 1; i >=0; --i) {
            int j = i - 1;
            List<Integer> children = new ArrayList<>();
            while (j >= 0 && inputs.get(i) <= inputs.get(j) + 3) {
                children.add(inputs.get(j));
                --j;
            }
            possibleConnections.put(inputs.get(i), children);
        }

        Map<Integer, Long> waysToGetTo = new HashMap<>();
        waysToGetTo.put(0, 1L);
        long total = 0;
        for (int i = 1; i < inputs.size(); ++i) {
            for (int e : possibleConnections.get(inputs.get(i))) {
                if (waysToGetTo.containsKey(e)) {
                    long l = waysToGetTo.get(e);
                    total += l;
                }
            }
            waysToGetTo.put(inputs.get(i), total);
            total = 0;
        }

        System.out.println("Part2: " + total);
    }

    @Test
    public void test() {
        System.out.println(findMultipliedDifferences(input));
        part2(input);
    }

    private String input = "66\n" +
            "7\n" +
            "73\n" +
            "162\n" +
            "62\n" +
            "165\n" +
            "157\n" +
            "158\n" +
            "137\n" +
            "125\n" +
            "138\n" +
            "59\n" +
            "36\n" +
            "40\n" +
            "94\n" +
            "95\n" +
            "13\n" +
            "35\n" +
            "136\n" +
            "96\n" +
            "156\n" +
            "155\n" +
            "24\n" +
            "84\n" +
            "42\n" +
            "171\n" +
            "142\n" +
            "3\n" +
            "104\n" +
            "149\n" +
            "83\n" +
            "129\n" +
            "19\n" +
            "122\n" +
            "68\n" +
            "103\n" +
            "74\n" +
            "118\n" +
            "20\n" +
            "110\n" +
            "54\n" +
            "127\n" +
            "88\n" +
            "31\n" +
            "135\n" +
            "26\n" +
            "126\n" +
            "2\n" +
            "51\n" +
            "91\n" +
            "16\n" +
            "65\n" +
            "128\n" +
            "119\n" +
            "67\n" +
            "48\n" +
            "111\n" +
            "29\n" +
            "49\n" +
            "12\n" +
            "132\n" +
            "17\n" +
            "41\n" +
            "166\n" +
            "75\n" +
            "146\n" +
            "50\n" +
            "30\n" +
            "1\n" +
            "164\n" +
            "112\n" +
            "34\n" +
            "18\n" +
            "72\n" +
            "97\n" +
            "145\n" +
            "11\n" +
            "117\n" +
            "58\n" +
            "78\n" +
            "152\n" +
            "90\n" +
            "172\n" +
            "163\n" +
            "89\n" +
            "107\n" +
            "45\n" +
            "37\n" +
            "79\n" +
            "159\n" +
            "141\n" +
            "105\n" +
            "10\n" +
            "115\n" +
            "69\n" +
            "170\n" +
            "25\n" +
            "100\n" +
            "80\n" +
            "4\n" +
            "85\n" +
            "169\n" +
            "106\n" +
            "57\n" +
            "116\n" +
            "23";
}
