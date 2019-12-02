package advent2019;

import org.junit.Test;

import java.util.Arrays;

public class Day2Test {

    private String testInput1 = "1,9,10,3,2,3,11,0,99,30,40,50";

    private String input = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,5,19,23,2,9,23,27,1,6,27,31,1,31,9,35,2,35,10,39,1,5,39,43,2,43,9,47,1,5,47,51,1,51,5,55,1,55,9,59,2,59,13,63,1,63,9,67,1,9,67,71,2,71,10,75,1,75,6,79,2,10,79,83,1,5,83,87,2,87,10,91,1,91,5,95,1,6,95,99,2,99,13,103,1,103,6,107,1,107,5,111,2,6,111,115,1,115,13,119,1,119,2,123,1,5,123,0,99,2,0,14,0";

    @Test
    public void problem2() {
        Integer finalResult = 19690720;
        Integer[] intArray = convertToArray(input);
        Integer result = null;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Integer[] copyArray = intArray.clone();
                copyArray[1] = i;
                copyArray[2] = j;
                Integer output = calculate(copyArray);
                if (output.equals(finalResult)) {
                    System.out.println("Noun: "+i+" Verb: "+j);
                    result = 100 * i + j;
                    System.out.println(result);
                    break;
                }
            }
            if (result != null) {
                break;
            }
        }

    }

    @Test
    public void problem1() {
        Integer[] intArray = convertToArray(input);
        intArray[1] = 12;
        intArray[2] = 2;
        calculate(intArray);
    }

    private Integer calculate(Integer[] intArray) {
        for (int i = 0; i < intArray.length; ) {
            Integer command = intArray[i];
            if (command.equals(1)) {
                Integer added = intArray[intArray[i+1]] + intArray[intArray[i+2]];
                intArray[intArray[i+3]] = added;
            } else if (command.equals(2)) {
                Integer multiplied = intArray[intArray[i+1]] * intArray[intArray[i+2]];
                intArray[intArray[i+3]] = multiplied;
            } else if (command.equals(99)) {
                break;
            }
            i=i+4;
        }
        return intArray[0];
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
}
