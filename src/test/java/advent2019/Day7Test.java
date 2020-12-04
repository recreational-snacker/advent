package advent2019;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day7Test {

    public String sample1 = "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0";

    public String input = "3,8,1001,8,10,8,105,1,0,0,21,42,55,76,89,114,195,276,357,438,99999,3,9,1001,9,3,9,1002,9,3,9,1001,9,3,9,1002,9,2,9,4,9,99,3,9,102,2,9,9,101,5,9,9,4,9,99,3,9,102,3,9,9,101,5,9,9,1002,9,2,9,101,4,9,9,4,9,99,3,9,102,5,9,9,1001,9,3,9,4,9,99,3,9,1001,9,4,9,102,5,9,9,1001,9,5,9,1002,9,2,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99";

    @Test
    public void testSection1() {

    }

    @Test
    public void problem1() {
        Integer maxThrusterSignal = 0;
        String[] phaseSetting = "10432".split("");
        Integer output = 0;
        for (String s : phaseSetting) {
            Integer[] intArray = convertToArray(sample1);
            List<Integer> inputs = new ArrayList<>();
            inputs.add(Integer.parseInt(s));
            inputs.add(output);
//            output = calculate(true, inputs, intArray);
            System.out.println(output);
        }
        System.out.println(output);
    }

    private Integer[] convertToArray(String testInput1) {
        String [] str = testInput1.split(",");
        int size = str.length;
        Integer [] arr = new Integer[size];
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    private Integer calculate(Boolean use, Integer inputId, Integer[] intArray) {
        Integer finalOutput = null;
        for (int i = 0; i < intArray.length; ) {
            Integer value = intArray[i];
            String[] commandArr = value.toString().split("");
            Collections.reverse(Arrays.asList(commandArr));
            Integer command = getCommand(value, commandArr);
            Integer mode1 = getMode(commandArr, 2);
            Integer mode2 = getMode(commandArr, 3);
            Integer mode3 = getMode(commandArr, 4);
            System.out.println("i="+i+" : "+command+" "+mode1+" "+mode2+" "+mode3);
            if (command.equals(1)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                Integer added = a + b;
                replaceValue(intArray, i, mode3, added);
                i = i + 4;
            } else if (command.equals(2)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                Integer multiplied = a * b;
                replaceValue(intArray, i, mode3, multiplied);
                i = i + 4;
            } else if (command.equals(3)) {
                int position = intArray[i+1];
                intArray[position] = inputId;
                i = i + 2;
            } else if (command.equals(4)) {
                System.out.println("Output: " + intArray[intArray[i+1]]);
                finalOutput = intArray[intArray[i+1]];
                i = i + 2;
            } else if (use && command.equals(5)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                if (a != 0) {
                    i = b;
                } else {
                    i += 3;
                }
            } else if (use && command.equals(6)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                if (a == 0) {
                    i = b;
                } else {
                    i += 3;
                }
            } else if (use && command.equals(7)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                if (a < b) {
                    setValue(intArray, i, mode3, 3, 1);
                } else {
                    setValue(intArray, i, mode3, 3, 0);
                }
                i += 4;
            } else if (use && command.equals(8)) {
                Integer a = getValue(intArray, i, mode1, 1);
                Integer b = getValue(intArray, i, mode2, 2);
                if (a.equals(b)) {
                    setValue(intArray, i, mode3, 3, 1);
                } else {
                    setValue(intArray, i, mode3, 3, 0);
                }
                i += 4;
            } else if (command.equals(99)) {
                break;
            } else {
                i++;
            }
        }
        return finalOutput;
    }

    private boolean replaceValue(Integer[] intArray, int i, Integer mode3, Integer added) {
        if (mode3.equals(0)) {
            intArray[intArray[i + 3]] = added;
        } else {
            intArray[i + 3] = added;
        }
        return false;
    }

    private Integer getValue(Integer[] intArray, int i, Integer mode1, int i2) {
        if (mode1.equals(0)) {
            return intArray[intArray[i + i2]];
        } else {
            return intArray[i + i2];
        }
    }

    private void setValue(Integer[] intArray, int i, Integer mode1, int i2, int value) {
        if (mode1.equals(0)) {
            intArray[intArray[i + i2]] = value;
        } else {
            intArray[i + i2] = value;
        }
    }

    private Integer getMode(String[] commandArr, int i2) {
        if (commandArr.length > i2 && !commandArr[i2].equalsIgnoreCase("-")) {
            return Integer.parseInt(commandArr[i2]);
        } else {
            return  0;
        }
    }

    private Integer getCommand(Integer value, String[] commandArr) {
        if (commandArr.length > 1) {
            return Integer.parseInt(commandArr[1]+""+commandArr[0]);
        } else {
            return value;
        }
    }
}
