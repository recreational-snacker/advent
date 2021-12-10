package advent2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6Test {

    @Test
    public void solution1() {
        int days = 256;
        String[] inputList = input.split(",");
        ArrayList<Integer> fish = new ArrayList<>();
        for (String s : inputList) {
            fish.add(Integer.parseInt(s));
        }

        while(days>0) {
            for (int i = 0; i < fish.size(); i++) {
                int index = i;
                if (fish.get(i)==0) {
                    fish.add(0,8);
                    i++;
                    index++;
                    fish.set(index, 6);
                    continue;
                }
                int val = fish.get(i)-1;
                fish.set(index, val);
            }
            days--;
        }

        System.out.println(fish.size());
    }

    private String sample = "3,4,3,1,2";

    private String input = "1,3,3,4,5,1,1,1,1,1,1,2,1,4,1,1,1,5,2,2,4,3,1,1,2,5,4,2,2,3,1,2,3,2,1,1,4,4,2,4,4,1,2,4,3,3,3,1,1,3,4,5,2,5,1,2,5,1,1,1,3,2,3,3,1,4,1,1,4,1,4,1,1,1,1,5,4,2,1,2,2,5,5,1,1,1,1,2,1,1,1,1,3,2,3,1,4,3,1,1,3,1,1,1,1,3,3,4,5,1,1,5,4,4,4,4,2,5,1,1,2,5,1,3,4,4,1,4,1,5,5,2,4,5,1,1,3,1,3,1,4,1,3,1,2,2,1,5,1,5,1,3,1,3,1,4,1,4,5,1,4,5,1,1,5,2,2,4,5,1,3,2,4,2,1,1,1,2,1,2,1,3,4,4,2,2,4,2,1,4,1,3,1,3,5,3,1,1,2,2,1,5,2,1,1,1,1,1,5,4,3,5,3,3,1,5,5,4,4,2,1,1,1,2,5,3,3,2,1,1,1,5,5,3,1,4,4,2,4,2,1,1,1,5,1,2,4,1,3,4,4,2,1,4,2,1,3,4,3,3,2,3,1,5,3,1,1,5,1,2,2,4,4,1,2,3,1,2,1,1,2,1,1,1,2,3,5,5,1,2,3,1,3,5,4,2,1,3,3,4";
}
