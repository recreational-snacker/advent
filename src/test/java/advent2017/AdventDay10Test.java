package advent2017;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventDay10Test {

    String testInput = "1,2,3";
    String input = "165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153";
    int skipSize = 0;
    int start = 0;
    List<Integer> sparseHash = populateArrayList(false);

    @Test
    public void testPart1() {
        String[] inputArray = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            list.add(Integer.valueOf(inputArray[i]));
        }
        processSequence(list);
        int sum = sparseHash.get(0) * sparseHash.get(1);
        System.out.println(sum);
        Assert.assertEquals(4114, sum);
    }

    String testInput2 = "1,2,3";

    @Test
    public void testPart2() {
        byte[] inputArray = testInput2.getBytes();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            char c = (char) inputArray[i];
            int ascii = (int) c;
            list.add(ascii);
        }
        list.add(17);
        list.add(31);
        list.add(73);
        list.add(47);
        list.add(23);
        for (int j = 1; j < 65; j++) {
            processSequence(list);
        }
        List<Integer> denseHash = new ArrayList<>();
        int index = 1;
        int stopValue = (index * 16) - 1;
        int xor = 0;
        for (int k = 0; k < 256; k++) {
            if (k == stopValue) {
                xor = xor ^ sparseHash.get(k);
                denseHash.add(xor);
                index++;
                stopValue = (index * 16) - 1;
            } else {
                xor = xor ^ sparseHash.get(k);
            }
        }
        StringBuilder hashBuilder = new StringBuilder("");
        for (Integer n : denseHash) {
            String hex = Integer.toHexString(n);
            if (hex.length() < 2) {
                hex = "0" + hex;
            }
            hashBuilder.append(hex);
        }
        System.out.println(hashBuilder.toString());
    }

    @Test
    public void testHexString() {
        String hex = Integer.toHexString(11);
        System.out.println(hex);
    }

    private void processSequence(List<Integer> inputArray) {
        for (Integer n : inputArray) {
            List<Integer> section = new ArrayList<>();
            for (int i = start; i < n + start; i++) {
                if (i <= sparseHash.size() - 1) {
                    section.add(sparseHash.get(i));
                } else if (i > sparseHash.size() - 1) {
                    section.add(sparseHash.get(i - (sparseHash.size())));
                }
            }
            Collections.reverse(section);
            int index = 0;
            for (int i = start; i < n + start; i++) {
                if (i <= sparseHash.size() - 1) {
                    sparseHash.set(i, section.get(index));
                } else if (i > sparseHash.size() - 1) {
                    sparseHash.set((i - (sparseHash.size())), section.get(index));
                }
                index++;
            }
            start = (start + n + skipSize);
            while (start > sparseHash.size() - 1) {
                start = start - sparseHash.size();
            }
            skipSize = skipSize + 1;
        }
    }


    private List<Integer> populateArrayList(boolean test) {
        List<Integer> list = new ArrayList<>();
        if (!test) {
            for (int i = 0; i < 256; i++) {
                list.add(i);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                list.add(i);
            }
        }
        return list;
    }
}
