package advent2019;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day4Test {

    private String input = "387638-919123";

    @Test
    public void problem1() {
        int count = 0;
        String[] arr = input.split("-");
        for (int i = Integer.parseInt(arr[0]); i < Integer.parseInt(arr[1]); i++) {
            if (testDoubleCriteria(String.valueOf(i)) && testAjacentValuesAreIncreasingCriteria(String.valueOf(i))) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void problem2() {
        List<String> valid = new ArrayList<>();
        int count = 0;
        String[] arr = input.split("-");
        for (int i = Integer.parseInt(arr[0]); i < Integer.parseInt(arr[1]); i++) {
            if (testDoubleCriteria(String.valueOf(i)) && testAjacentValuesAreIncreasingCriteria(String.valueOf(i))) {
                valid.add(String.valueOf(i));
            }
        }
        for (String s : valid) {
            if (testStrictDoubleCriteria(s)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private boolean testDoubleCriteria(String number) {
        String[] arr = number.split("");
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1 && arr[i].equalsIgnoreCase(arr[i+1])) {
                return true;
            }
        }
        return false;
    }

    private boolean testStrictDoubleCriteria(String number) {
        String[] arr = number.split("");
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1 && arr[i].equalsIgnoreCase(arr[i+1])) {
                if (i == 0 && !arr[i+1].equalsIgnoreCase(arr[i+2])) {
                    return true;
                }
                if (i == 4 && !arr[i-1].equalsIgnoreCase(arr[i])) {
                    return true;
                }
                if (i > 0 && i < 4 && !arr[i-1].equalsIgnoreCase(arr[i]) && !arr[i+1].equalsIgnoreCase(arr[i+2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean testAjacentValuesAreIncreasingCriteria(String number) {
        String[] arr = number.split("");
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1) {
                Integer a = Integer.parseInt(arr[i]);
                Integer b = Integer.parseInt(arr[i+1]);
                if (b < a) {
                    return false;
                }
            }
        }
        return true;
    }

}
