package advent2019;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Day5Test {

    private String input = "3,225,1,225,6,6,1100,1,238,225,104,0,101,71,150,224,101,-123,224,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,2,205,209,224,1001,224,-3403,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,1101,55,24,224,1001,224,-79,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,1,153,218,224,1001,224,-109,224,4,224,1002,223,8,223,101,5,224,224,1,224,223,223,1002,201,72,224,1001,224,-2088,224,4,224,102,8,223,223,101,3,224,224,1,223,224,223,1102,70,29,225,102,5,214,224,101,-250,224,224,4,224,1002,223,8,223,1001,224,3,224,1,223,224,223,1101,12,52,225,1101,60,71,225,1001,123,41,224,1001,224,-111,224,4,224,102,8,223,223,1001,224,2,224,1,223,224,223,1102,78,66,224,1001,224,-5148,224,4,224,1002,223,8,223,1001,224,2,224,1,223,224,223,1101,29,77,225,1102,41,67,225,1102,83,32,225,1101,93,50,225,1102,53,49,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1107,677,677,224,1002,223,2,223,1005,224,329,101,1,223,223,7,677,677,224,1002,223,2,223,1005,224,344,1001,223,1,223,7,226,677,224,102,2,223,223,1006,224,359,101,1,223,223,1108,226,226,224,1002,223,2,223,1005,224,374,1001,223,1,223,8,226,677,224,1002,223,2,223,1006,224,389,1001,223,1,223,1108,226,677,224,1002,223,2,223,1006,224,404,101,1,223,223,1107,677,226,224,102,2,223,223,1006,224,419,101,1,223,223,1007,677,677,224,1002,223,2,223,1005,224,434,101,1,223,223,7,677,226,224,102,2,223,223,1006,224,449,1001,223,1,223,1008,226,677,224,1002,223,2,223,1006,224,464,101,1,223,223,8,677,677,224,1002,223,2,223,1006,224,479,101,1,223,223,108,226,226,224,102,2,223,223,1005,224,494,101,1,223,223,1107,226,677,224,1002,223,2,223,1006,224,509,101,1,223,223,107,226,226,224,1002,223,2,223,1006,224,524,1001,223,1,223,107,677,677,224,1002,223,2,223,1005,224,539,101,1,223,223,1007,226,226,224,102,2,223,223,1006,224,554,101,1,223,223,108,677,677,224,102,2,223,223,1005,224,569,101,1,223,223,107,677,226,224,102,2,223,223,1005,224,584,101,1,223,223,1008,226,226,224,102,2,223,223,1006,224,599,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,614,101,1,223,223,8,677,226,224,102,2,223,223,1005,224,629,1001,223,1,223,1008,677,677,224,102,2,223,223,1006,224,644,101,1,223,223,1007,226,677,224,102,2,223,223,1005,224,659,101,1,223,223,108,226,677,224,102,2,223,223,1006,224,674,101,1,223,223,4,223,99,226";

    @Test
    public void problem1() {
        Integer[] intArray = convertToArray(input);
        Integer inputId = 1;
        Integer output = calculate(false, inputId, intArray);
        assertEquals(4511442, output.intValue());
    }

    @Test
    public void problem2() {
        Integer[] intArray = convertToArray(input);
        Integer inputId = 5;
        Integer output = calculate(true, inputId, intArray);
//        assertEquals(4511442, output.intValue());
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
