package advent2019;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Test {

    @Test
    public void problem1() {
        List<String> inputs = Arrays.asList(input1.split("\n"));
        Integer finalFuel = calculateTotalFuel(inputs);
        System.out.println("Final fuel: "+finalFuel);
    }

    @Test
    public void problem2() {
        String[] inputs = input1.split("\n");
        Integer totalFuel = 0;
        for (String input : inputs) {
            Integer fuel = calculateFuel(Integer.valueOf(input), 0);
            Integer currentFuel = fuel;
            while (!checkIfCalculatedValueIsNegative(currentFuel)) {
                currentFuel = calculateFuel(currentFuel, 0);
                fuel += currentFuel;
            }
            totalFuel += fuel;
        }
        System.out.println("Final fuel: "+totalFuel);
    }

    private Integer calculateTotalFuel(List<String> inputs) {
        Integer requiredFuel = 0;
        for (String input : inputs) {
            Integer in = Integer.valueOf(input);
            requiredFuel = calculateFuel(in, requiredFuel);
        }
        return requiredFuel;
    }

    private Boolean checkIfCalculatedValueIsNegative(Integer value) {
        Integer calculatedValue = calculateFuel(value, 0);
        if (calculatedValue > 0) {
            return false;
        }
        return true;
    }

    private Integer calculateFuel(Integer input, Integer requiredFuel) {
        BigDecimal value = new BigDecimal(input).divide(new BigDecimal(3), RoundingMode.DOWN).subtract(new BigDecimal(2));
        requiredFuel += value.intValue();
        return requiredFuel;
    }

    private String input1 = "60077\n" +
            "148191\n" +
            "77039\n" +
            "138122\n" +
            "109889\n" +
            "140187\n" +
            "116411\n" +
            "94170\n" +
            "149976\n" +
            "70913\n" +
            "64860\n" +
            "149414\n" +
            "146246\n" +
            "143889\n" +
            "105615\n" +
            "143060\n" +
            "82445\n" +
            "108411\n" +
            "54193\n" +
            "102892\n" +
            "136407\n" +
            "147470\n" +
            "129652\n" +
            "75887\n" +
            "104208\n" +
            "131104\n" +
            "82815\n" +
            "72880\n" +
            "104513\n" +
            "64130\n" +
            "112780\n" +
            "71099\n" +
            "108700\n" +
            "137290\n" +
            "53878\n" +
            "146277\n" +
            "68897\n" +
            "118713\n" +
            "141895\n" +
            "74593\n" +
            "111125\n" +
            "62545\n" +
            "114375\n" +
            "140815\n" +
            "137314\n" +
            "129250\n" +
            "78915\n" +
            "63391\n" +
            "133745\n" +
            "99785\n" +
            "104597\n" +
            "140050\n" +
            "118183\n" +
            "67394\n" +
            "84529\n" +
            "82530\n" +
            "109998\n" +
            "126649\n" +
            "56545\n" +
            "139507\n" +
            "71148\n" +
            "71421\n" +
            "99495\n" +
            "59804\n" +
            "118055\n" +
            "110401\n" +
            "84557\n" +
            "69630\n" +
            "130090\n" +
            "110550\n" +
            "115260\n" +
            "88256\n" +
            "97149\n" +
            "62192\n" +
            "142398\n" +
            "85462\n" +
            "132228\n" +
            "102567\n" +
            "67005\n" +
            "54685\n" +
            "83284\n" +
            "142337\n" +
            "117615\n" +
            "90445\n" +
            "78048\n" +
            "68070\n" +
            "99049\n" +
            "83965\n" +
            "124845\n" +
            "76143\n" +
            "96194\n" +
            "92299\n" +
            "128558\n" +
            "64150\n" +
            "85126\n" +
            "63567\n" +
            "103223\n" +
            "125883\n" +
            "58363\n" +
            "72622";
}
