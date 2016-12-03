package advent2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Deesha Singh on 2016/12/03.
 */
public class AdventDay3 {

    public static Integer solution(String input, String rowColumn) {
        String[] list = input.split("\n");
        Integer countValid = 0;
        if (rowColumn.equalsIgnoreCase("ROW")) {
            for (String triangle : list) {
                String triangleTrim = triangle.trim();
                List<String> sides = getIndivLengths(triangleTrim);
                countValid = determineValidTriangles(countValid, sides);
            }
        } else {
            List<String > triangle1 = new ArrayList<>();
            List<String > triangle2 = new ArrayList<>();
            List<String > triangle3 = new ArrayList<>();
            for (int i=1; i<=list.length;i++) {
                List<String> lengths = getIndivLengths(list[i-1]);
                triangle1.add(lengths.get(0));
                triangle2.add(lengths.get(1));
                triangle3.add(lengths.get(2));
                if (i % 3 == 0) {
                    countValid = determineValidTriangles(countValid, triangle1);
                    countValid = determineValidTriangles(countValid, triangle2);
                    countValid = determineValidTriangles(countValid, triangle3);
                    triangle1.clear();
                    triangle2.clear();
                    triangle3.clear();
                }
            }
        }
        return countValid;
    }

    private static Integer determineValidTriangles(Integer countValid,  List<String> sides) {
        Boolean isValid = false;
        Integer sum1 = Integer.valueOf(sides.get(0)) + Integer.valueOf(sides.get(1));
        if (sum1 > Integer.valueOf(sides.get(2))) {
           isValid = true;
        } else {
            return countValid;
        }
        Integer sum2 = Integer.valueOf(sides.get(1)) + Integer.valueOf(sides.get(2));
        if (sum2 > Integer.valueOf(sides.get(0))) {
            isValid = true;
        } else {
            return countValid;
        }
        Integer sum3 = Integer.valueOf(sides.get(2)) + Integer.valueOf(sides.get(0));
        if (sum3 > Integer.valueOf(sides.get(1))) {
            isValid = true;
        } else {
            return countValid;
        }
        if (isValid) {
            countValid++;
        }
        return countValid;
    }

    private static List<String> getIndivLengths(String triangleTrim) {
        List<String> lengths = new ArrayList<>();
        triangleTrim = triangleTrim+" ";
        List<String> chars = Arrays.asList(triangleTrim.split(""));
        String length = "";
        for (String c : chars) {
            if (!c.equals(" ")) {
                length = length + c;
            } else if (c.equals(" ")) {
                if (!length.isEmpty()) {
                    lengths.add(length);
                    length = "";
                }
            }
        }
        return lengths;
    }
}
