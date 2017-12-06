package advent2017;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class AdventDay6Test {

    String input = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14";

    @Test
    public void testPart1() {
        String[] inputArray = input.split("\\t");
        List<Integer> intArray = new ArrayList<>();
        for (String n : inputArray) {
            intArray.add(Integer.valueOf(n));
        }
        Map<String, Integer> count = new HashMap<>();
        int blockCount = 0;
        for (int i = 0;;i++) {
            Integer max = Collections.max(intArray);
            int indexOfMax = intArray.indexOf(max);
            intArray.set(indexOfMax, 0);
            int addition = (int) Math.ceil(max / Double.valueOf(intArray.size()));
            int remainder = max % addition;
            for (int j=indexOfMax+1; ;j++) {
                if (j>intArray.size()-1) {
                    j=0;
                }
                if (max>=addition) {
                    intArray.set(j, intArray.get(j) + addition);
                    max = max - addition;
                } else {
                    intArray.set(j, intArray.get(j) + remainder);
                    break;
                }
            }
            String listString = intArray.stream().map(Object::toString)
                    .collect(Collectors.joining(""));
            blockCount++;
            if (count.containsKey(listString)) {
                System.out.println(blockCount);
                System.out.println(blockCount-count.get(listString));
                break;
            }
            count.put(listString, blockCount);
        }

    }

}
