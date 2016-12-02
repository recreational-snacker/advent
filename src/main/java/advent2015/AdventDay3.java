package advent2015;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay3 {

    public static Integer finalSolution(String directions, int noOfDeliverers) {
        String[] array = directions.split("");
        Map<Point, Integer> housesAndPresents = new HashMap<>();
        for (int i=0; i<noOfDeliverers;i++) {
            int x = 0;
            int y = 0;
            housesAndPresents.put(new Point(x, y), 1);
            for (int j = i; j<array.length;) {
                x = x + getX(array[j]);
                y = y + getY(array[j]);
                Point house = new Point(x, y);
                if (housesAndPresents.containsKey(house)) {
                    int count = housesAndPresents.get(house);
                    housesAndPresents.put(house, count+1);
                } else {
                    housesAndPresents.put(house, 1);
                }
                j=j+noOfDeliverers;
            }
        }
        System.out.println("Number of houses: "+housesAndPresents.size());
        return housesAndPresents.size();
    }

    private static int getY(String point) {
        int y = 0;
        if (point.equals("v")) {
            y = -1;
        } else if (point.equals("^")) {
            y = 1;
        }
        return y;
    }

    private static int getX(String point) {
        int x = 0;
        if (point.equals("<")) {
            x = -1;
        } else if (point.equals(">")) {
            x = 1;
        }
        return x;
    }
}
