package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14Test {

    private String sample = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\n" +
            "mem[8] = 11\n" +
            "mem[7] = 101\n" +
            "mem[8] = 0";

    private String sample2 = "mask = 000000000000000000000000000000X1001X\n" +
            "mem[42] = 100\n" +
            "mask = 00000000000000000000000000000000X0XX\n" +
            "mem[26] = 1";

    private List<String> splitString(String input) {
        return Arrays.asList(input.split("mask = "));
    }

    private void processMask(Map<Long, Long> valueMap, String input, boolean part2) {
        String[] split = input.split("\n");
        String mask = split[0];
        for (int i = 1; i < split.length; i++) {
            Integer val = Integer.parseInt(split[i].split(" = ")[1]);
            Integer mem = Integer.parseInt(split[i].split(" = ")[0].replace("mem[", "").replace("]", ""));
            String v;
            if (!part2) {
                v = findBitThing(val);
            } else {
                v = findBitThing(mem);
            }
            Long t = calculateValue(v.split(""));
            String[] maskSplit = mask.split("");
            String[] memSplit = v.split("");
            applyMask(maskSplit, memSplit, part2, valueMap, mem, val);
        }
    }

    private void applyMask(String[] maskSplit, String[] memSplit, boolean part2, Map<Long, Long> valueMap, Integer mem, Integer val) {
        if (!part2) {
            for (int j = 0; j < memSplit.length; j++) {
                if (!maskSplit[j].equalsIgnoreCase("X")) {
                    memSplit[j] = maskSplit[j];
                }
            }
            Long value = calculateValue(memSplit);
            valueMap.put(mem.longValue(), value);
        } else {
            for (int j = 0; j < memSplit.length; j++) {
                if (maskSplit[j].equalsIgnoreCase("0")) {
                    continue;
                }
                if (maskSplit[j].equalsIgnoreCase("1")) {
                    memSplit[j] = "1";
                }
                if (maskSplit[j].equalsIgnoreCase("X")) {
                    memSplit[j] = "X";
                }
            }

            List<String> checkedStrings = new ArrayList<>();
            String[] copy = Arrays.copyOf(memSplit, memSplit.length);
            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "0";
                }
            }
            String clean = clean(copy);
            Long value = calculateValue(copy);
            valueMap.put(value, val.longValue());
            checkedStrings.add(clean);

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean2 = clean(copy);
                    if (!checkedStrings.contains(clean2)) {
                        Long value2 = calculateValue(copy);
                        valueMap.put(value2, val.longValue());
                        checkedStrings.add(clean2);
                    }
                }
            }
            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "0";
                    String clean2 = clean(copy);
                    if (!checkedStrings.contains(clean2)) {
                        Long value2 = calculateValue(copy);
                        valueMap.put(value2, val.longValue());
                        checkedStrings.add(clean2);
                    }
                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean1 = clean(copy);
                    if (!checkedStrings.contains(clean1)) {
                        Long value1 = calculateValue(copy);
                        valueMap.put(value1, val.longValue());
                        checkedStrings.add(clean1);
                    }

                    for (int j = i+1; j < memSplit.length; j++) {
                        if (memSplit[j].equalsIgnoreCase("X")) {
                            copy[j] = "1";
                            String clean2 = clean(copy);
                            if (!checkedStrings.contains(clean2)) {
                                Long value2 = calculateValue(copy);
                                valueMap.put(value2, val.longValue());
                                checkedStrings.add(clean2);
                            }
                            copy[j] = "0";
                        }
                    }

                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "0";
                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean1 = clean(copy);
                    if (!checkedStrings.contains(clean1)) {
                        Long value1 = calculateValue(copy);
                        valueMap.put(value1, val.longValue());
                        checkedStrings.add(clean1);
                    }
                    for (int j = i+1; j < memSplit.length; j++) {
                        if (memSplit[j].equalsIgnoreCase("X")) {
                            copy[j] = "1";
                            String clean2 = clean(copy);
                            if (!checkedStrings.contains(clean2)) {
                                Long value2 = calculateValue(copy);
                                valueMap.put(value2, val.longValue());
                                checkedStrings.add(clean2);
                            }
                            copy[j] = "0";
                        }
                    }
                    copy[i] = "0";
                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean1 = clean(copy);
                    if (!checkedStrings.contains(clean1)) {
                        Long value1 = calculateValue(copy);
                        valueMap.put(value1, val.longValue());
                        checkedStrings.add(clean1);
                    }
                    for (int j = i+1; j < memSplit.length; j++) {
                        if (memSplit[j].equalsIgnoreCase("X")) {
                            copy[j] = "1";
                            String clean2 = clean(copy);
                            if (!checkedStrings.contains(clean2)) {
                                Long value2 = calculateValue(copy);
                                valueMap.put(value2, val.longValue());
                                checkedStrings.add(clean2);
                            }
                            for (int k = j+1; k < memSplit.length; k++) {
                                if (memSplit[k].equalsIgnoreCase("X")) {
                                    copy[k] = "1";
                                    String clean3 = clean(copy);
                                    if (!checkedStrings.contains(clean3)) {
                                        Long value3 = calculateValue(copy);
                                        valueMap.put(value3, val.longValue());
                                        checkedStrings.add(clean3);
                                    }
                                    copy[k] = "0";
                                }
                            }
                            copy[j] = "0";
                        }
                    }
                    copy[i] = "0";
                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean1 = clean(copy);
                    if (!checkedStrings.contains(clean1)) {
                        Long value1 = calculateValue(copy);
                        valueMap.put(value1, val.longValue());
                        checkedStrings.add(clean1);
                    }
                    for (int j = i+1; j < memSplit.length; j++) {
                        if (memSplit[j].equalsIgnoreCase("X")) {
                            copy[j] = "1";
                            String clean2 = clean(copy);
                            if (!checkedStrings.contains(clean2)) {
                                Long value2 = calculateValue(copy);
                                valueMap.put(value2, val.longValue());
                                checkedStrings.add(clean2);
                            }
                            for (int k = j+1; k < memSplit.length; k++) {
                                if (memSplit[k].equalsIgnoreCase("X")) {
                                    copy[k] = "1";
                                    String clean3 = clean(copy);
                                    if (!checkedStrings.contains(clean3)) {
                                        Long value3 = calculateValue(copy);
                                        valueMap.put(value3, val.longValue());
                                        checkedStrings.add(clean3);
                                    }
//                                    copy[k] = "0";
                                }
                            }
//                            copy[j] = "0";
                        }
                    }
//                    copy[i] = "0";
                }
            }

            for (int i = 0; i < memSplit.length; i++) {
                if (memSplit[i].equalsIgnoreCase("X")) {
                    copy[i] = "1";
                    String clean1 = clean(copy);
                    if (!checkedStrings.contains(clean1)) {
                        Long value1 = calculateValue(copy);
                        valueMap.put(value1, val.longValue());
                        checkedStrings.add(clean1);
                    }
                    for (int j = i+1; j < memSplit.length; j++) {
                        if (memSplit[j].equalsIgnoreCase("X")) {
                            copy[j] = "1";
                            String clean2 = clean(copy);
                            if (!checkedStrings.contains(clean2)) {
                                Long value2 = calculateValue(copy);
                                valueMap.put(value2, val.longValue());
                                checkedStrings.add(clean2);
                            }
                            for (int k = j+1; k < memSplit.length; k++) {
                                if (memSplit[k].equalsIgnoreCase("X")) {
                                    copy[k] = "1";
                                    String clean3 = clean(copy);
                                    if (!checkedStrings.contains(clean3)) {
                                        Long value3 = calculateValue(copy);
                                        valueMap.put(value3, val.longValue());
                                        checkedStrings.add(clean3);
                                    }
                                    copy[k] = "0";
                                }
                            }
                            copy[j] = "0";
                        }
                    }
//                    copy[i] = "0";
                }
            }

            checkedStrings.size();
        }
    }

    private String clean(String[] arr) {
        return Arrays.toString(arr).replace("[", "").replace("]", "").replace(", ", "");
    }

    private long getTotal(Map<Long, Long> valueMap) {
        long total = 0;
        for (Map.Entry<Long, Long> entry : valueMap.entrySet()) {
            Long v = entry.getValue();
            total += v;
        }
        return total;
    }

    private String findBitThing(Integer val) {
        String v = "000000000000000000000000000000000000";
        String[] stringSplit = v.split("");
        Collections.reverse(Arrays.asList(stringSplit));
        for (int i = 0; ; i++) {
            if (val == 0) {
                Collections.reverse(Arrays.asList(stringSplit));
                return Arrays.toString(stringSplit).replace("[", "").replace("]", "").replace(", ", "");
            }
            int c = Double.valueOf(Math.pow(2, i)).intValue();
            if (c > val) {
                int d = Double.valueOf(Math.pow(2, i-1)).intValue();
                val -=d;
                stringSplit[i-1] = "1";
                i=-1;
            } else if (c == val) {
                int d = Double.valueOf(Math.pow(2, i)).intValue();
                val -=d;
                stringSplit[i] = "1";
                i=-1;
            }
        }
    }

    private long calculateValue(String[] memSplit) {
        Collections.reverse(Arrays.asList(memSplit));
        long total = 0;
        for (int i = 0; i < memSplit.length; i++) {
            if (Integer.parseInt(memSplit[i]) == 1) {
                Double t = Math.pow(2, i);
                total += t;
            }
        }
        Collections.reverse(Arrays.asList(memSplit));
        return total;
    }

    private Long calculateTotalMemory(String input, boolean part2) {
        Map<Long, Long> valueMap = new HashMap<>();
        List<String> splitString = splitString(input);
        for (String s : splitString) {
            if (s.equals("")) {
                continue;
            }
            processMask(valueMap, s, part2);
        }
        return getTotal(valueMap);
    }



    @Test
    public void test() {
//        System.out.println(calculateTotalMemory(input, false));
        System.out.println("-----------------------------------------");
        System.out.println(calculateTotalMemory(input, true));
    }

    private String input = "mask = 1001X0X00110011X01X1000110100011000X\n" +
            "mem[5228] = 409649\n" +
            "mem[64037] = 474625\n" +
            "mask = 1X0110X0X110000100X01100000011101111\n" +
            "mem[62395] = 48627\n" +
            "mem[32253] = 16724249\n" +
            "mem[29843] = 241166\n" +
            "mask = 100X100X110001111101X0X0010100111X10\n" +
            "mem[9042] = 12448\n" +
            "mem[36389] = 14915399\n" +
            "mem[53378] = 2004566\n" +
            "mem[60022] = 121815\n" +
            "mem[46937] = 1238\n" +
            "mask = X001X0X101X10X10101X0000001110100011\n" +
            "mem[55791] = 2998\n" +
            "mem[16538] = 4120048\n" +
            "mem[36864] = 183554\n" +
            "mem[38989] = 7774725\n" +
            "mem[43983] = 18397304\n" +
            "mem[26551] = 1232\n" +
            "mask = 1111X0110110X0010110000010X1X1X10X1X\n" +
            "mem[28101] = 14619727\n" +
            "mem[35256] = 29030667\n" +
            "mem[63194] = 146129065\n" +
            "mem[44798] = 189\n" +
            "mem[2426] = 16693877\n" +
            "mem[695] = 30070848\n" +
            "mem[45241] = 4271881\n" +
            "mask = 1001X011X1100X01XX101X110001X110X101\n" +
            "mem[17482] = 7601\n" +
            "mem[35168] = 164940\n" +
            "mem[50171] = 1047374131\n" +
            "mask = X0010X101X00111X11100111110110X11X01\n" +
            "mem[55397] = 6883232\n" +
            "mem[36276] = 460553\n" +
            "mem[28164] = 6184\n" +
            "mem[32800] = 3846\n" +
            "mask = 100110X1X1100X110110XXX00X00101X010X\n" +
            "mem[34061] = 8335\n" +
            "mem[19672] = 806\n" +
            "mem[20346] = 45051423\n" +
            "mem[36909] = 75717\n" +
            "mem[14949] = 12484\n" +
            "mask = X00XX1100100111X00X11XX00000110X1010\n" +
            "mem[32991] = 13151\n" +
            "mem[26489] = 54180147\n" +
            "mem[55564] = 5690\n" +
            "mem[7187] = 807798\n" +
            "mem[4660] = 21323\n" +
            "mask = 0001X01001100111101X0111101X1110001X\n" +
            "mem[53378] = 33491\n" +
            "mem[11625] = 23905844\n" +
            "mem[11286] = 226133438\n" +
            "mem[59562] = 61\n" +
            "mem[39496] = 45492350\n" +
            "mem[35168] = 1063\n" +
            "mem[35116] = 1135415\n" +
            "mask = 1X011X100X1001X1111011011XX000010100\n" +
            "mem[14949] = 7088\n" +
            "mem[27179] = 249426\n" +
            "mem[12840] = 3398667\n" +
            "mask = 100110X0X1X0011111011X0001XX00111X1X\n" +
            "mem[9310] = 377264021\n" +
            "mem[39496] = 5310\n" +
            "mask = 1X0111100X0011X10001100X00X0X1X0X01X\n" +
            "mem[23624] = 3559669\n" +
            "mem[4358] = 25901\n" +
            "mask = X0X1111001X0111X11011X00110000000X10\n" +
            "mem[41470] = 74601\n" +
            "mem[46470] = 28860028\n" +
            "mem[28699] = 579\n" +
            "mem[50915] = 8018491\n" +
            "mem[9582] = 512\n" +
            "mem[17809] = 2468\n" +
            "mem[19264] = 382929593\n" +
            "mask = 1X01X01001X001X1XX100111X0000X110000\n" +
            "mem[53852] = 671\n" +
            "mem[829] = 14607863\n" +
            "mem[59475] = 42176426\n" +
            "mem[50352] = 917431806\n" +
            "mem[25565] = 2735024\n" +
            "mem[31268] = 8203\n" +
            "mem[63568] = 18725\n" +
            "mask = 1011X01101X0X0X1X1X0X0110X0100001110\n" +
            "mem[14581] = 534274885\n" +
            "mem[60208] = 23685066\n" +
            "mem[59262] = 268487956\n" +
            "mem[243] = 75944\n" +
            "mask = 1001XX0001X01111001XX1X0X01000X10X11\n" +
            "mem[53831] = 4237440\n" +
            "mem[24052] = 1451049\n" +
            "mem[64125] = 432782904\n" +
            "mem[8892] = 15419\n" +
            "mask = 10X0101101000X1XX010100X110001XXX11X\n" +
            "mem[47441] = 9514\n" +
            "mem[24633] = 4407646\n" +
            "mem[40184] = 15477\n" +
            "mem[1696] = 106342632\n" +
            "mem[36011] = 606150\n" +
            "mem[14545] = 874\n" +
            "mask = 100X1XX11110X001X1X011000X0011010100\n" +
            "mem[18822] = 1345\n" +
            "mem[31329] = 49781332\n" +
            "mem[1256] = 23323\n" +
            "mem[47095] = 360\n" +
            "mem[28233] = 122942\n" +
            "mask = 1X01XX100100X1110X1110X10001X100X00X\n" +
            "mem[20346] = 6255\n" +
            "mem[2088] = 10531698\n" +
            "mem[19802] = 23124041\n" +
            "mem[13152] = 64318\n" +
            "mask = 1XX110100X100011011000XX10X00XX10X00\n" +
            "mem[55530] = 462159\n" +
            "mem[53302] = 4050\n" +
            "mask = 11X1X01X00X0X011X1101100100X101X100X\n" +
            "mem[32170] = 2300\n" +
            "mem[60379] = 1946048\n" +
            "mem[38974] = 935362865\n" +
            "mem[30527] = 38214\n" +
            "mem[39317] = 309\n" +
            "mask = 0X0XX11011X001X11X101011111X01100101\n" +
            "mem[6761] = 3363\n" +
            "mem[30072] = 488192925\n" +
            "mem[30577] = 5587652\n" +
            "mem[36815] = 820921800\n" +
            "mem[48185] = 90597685\n" +
            "mem[45346] = 14766\n" +
            "mask = 10XX000X0100000X011000X1X1X0X1X00101\n" +
            "mem[65328] = 277939257\n" +
            "mem[32705] = 259305\n" +
            "mem[8201] = 1708\n" +
            "mask = 100110X101100X01X110X011X001101X1101\n" +
            "mem[1321] = 133255266\n" +
            "mem[33628] = 464\n" +
            "mem[58727] = 673\n" +
            "mask = 1001101001X001010XX0X00001X0X0100000\n" +
            "mem[19034] = 17040206\n" +
            "mem[34637] = 15994570\n" +
            "mem[58564] = 7623\n" +
            "mask = 1001101101100101011X11110000X1001XX0\n" +
            "mem[23305] = 8044\n" +
            "mem[64547] = 395\n" +
            "mem[37420] = 27907889\n" +
            "mem[27608] = 612\n" +
            "mem[7901] = 680129\n" +
            "mem[2047] = 829469\n" +
            "mask = 1X0X0X100100111100011011100111XX1100\n" +
            "mem[55530] = 17794\n" +
            "mem[35214] = 6843366\n" +
            "mem[55948] = 325722\n" +
            "mem[50625] = 1010688\n" +
            "mem[1409] = 7196\n" +
            "mem[61824] = 484817479\n" +
            "mem[18803] = 12612636\n" +
            "mask = 1001X01XX1X0X1111X1001110X110X011101\n" +
            "mem[28127] = 1963295\n" +
            "mem[11625] = 1018106\n" +
            "mem[30920] = 1636\n" +
            "mem[15448] = 10027\n" +
            "mem[13104] = 13415208\n" +
            "mask = 11011010011101111X100000X0X110XXX101\n" +
            "mem[32426] = 26317976\n" +
            "mem[33610] = 953396121\n" +
            "mem[18997] = 205749058\n" +
            "mask = 1001101XX1100XX1011010XXXX00011X1100\n" +
            "mem[16512] = 115996365\n" +
            "mem[9541] = 816\n" +
            "mem[2017] = 47814977\n" +
            "mem[48769] = 6960\n" +
            "mem[57904] = 17542395\n" +
            "mem[31268] = 536187\n" +
            "mask = 100X101011X0X1X100100010101000X1100X\n" +
            "mem[12315] = 151687693\n" +
            "mem[2426] = 585162\n" +
            "mem[58101] = 840013\n" +
            "mask = X00110000100111100X1001001000XX00XXX\n" +
            "mem[61146] = 100666431\n" +
            "mem[64619] = 4637046\n" +
            "mem[27122] = 237312\n" +
            "mem[43315] = 2538822\n" +
            "mem[6097] = 889148\n" +
            "mask = 101110100X10X0110110111X1X001000X110\n" +
            "mem[59937] = 1039821042\n" +
            "mem[5228] = 20695323\n" +
            "mem[16793] = 1847174\n" +
            "mem[58963] = 11095\n" +
            "mem[22680] = 5166227\n" +
            "mem[44856] = 15083\n" +
            "mask = X001X0111X10X0110X10X1X0010110010100\n" +
            "mem[60974] = 391897\n" +
            "mem[54413] = 376986\n" +
            "mem[16685] = 488\n" +
            "mask = 1X0X0X00X0000111X00110X10X000110X000\n" +
            "mem[16055] = 28402351\n" +
            "mem[30402] = 379124674\n" +
            "mem[34946] = 13507\n" +
            "mem[52357] = 5299\n" +
            "mem[64564] = 106012728\n" +
            "mem[2719] = 45355693\n" +
            "mem[12] = 89762\n" +
            "mask = XX011X1111X00011X1X0010000001101X101\n" +
            "mem[29208] = 29115\n" +
            "mem[18551] = 426909992\n" +
            "mem[23699] = 15195667\n" +
            "mem[3422] = 11107\n" +
            "mem[34134] = 15916\n" +
            "mem[18069] = 1238938\n" +
            "mem[50734] = 4062867\n" +
            "mask = 1001X000XX00011100X100X1100XX11000X0\n" +
            "mem[62530] = 18469859\n" +
            "mem[54219] = 239365\n" +
            "mem[43155] = 3473\n" +
            "mem[38944] = 358650\n" +
            "mask = 1X01001X11001110X11X1010X0X111X010XX\n" +
            "mem[10724] = 2916217\n" +
            "mem[44147] = 416\n" +
            "mem[4105] = 2413\n" +
            "mem[38699] = 1661\n" +
            "mem[64725] = 1933034\n" +
            "mem[20996] = 13732\n" +
            "mem[63194] = 484290\n" +
            "mask = 1001X010110X1111X11111110011X0010000\n" +
            "mem[56756] = 53912\n" +
            "mem[55265] = 2802\n" +
            "mem[55521] = 61411987\n" +
            "mem[43040] = 1167\n" +
            "mask = 1XX1111101001X11001001111110101X1011\n" +
            "mem[29769] = 87000096\n" +
            "mem[15343] = 480461\n" +
            "mem[16428] = 51254247\n" +
            "mem[13162] = 53048239\n" +
            "mask = 100100100100XX010X1001XX1XXXX0100100\n" +
            "mem[13117] = 136\n" +
            "mem[63074] = 35112135\n" +
            "mask = 1101101001XX01110010111X100XX11X1XX0\n" +
            "mem[21012] = 2037\n" +
            "mem[54144] = 3133068\n" +
            "mem[63961] = 14080353\n" +
            "mask = 1001X11X01101111110X10X1010001000X0X\n" +
            "mem[62471] = 12508052\n" +
            "mem[14338] = 435627\n" +
            "mem[318] = 3687092\n" +
            "mem[64508] = 2664\n" +
            "mem[58433] = 14556\n" +
            "mem[8995] = 938\n" +
            "mem[32875] = 1012574980\n" +
            "mask = 1X01XX100X10011101X01001011X11011X01\n" +
            "mem[26989] = 97197022\n" +
            "mem[9541] = 150895995\n" +
            "mem[36956] = 174431384\n" +
            "mem[43247] = 2881\n" +
            "mem[6758] = 18074756\n" +
            "mem[35444] = 3197755\n" +
            "mem[42854] = 28212\n" +
            "mask = 100X101X0X00X1110010100011X0X01X1010\n" +
            "mem[17239] = 76342363\n" +
            "mem[48185] = 30296621\n" +
            "mem[26693] = 55049\n" +
            "mem[30110] = 28232858\n" +
            "mem[40609] = 197705858\n" +
            "mem[63074] = 1491954\n" +
            "mask = 100X1X1XX100111100XXX01110X00000101X\n" +
            "mem[28233] = 16456060\n" +
            "mem[37936] = 1485\n" +
            "mem[60589] = 1108\n" +
            "mem[58201] = 178477087\n" +
            "mem[35353] = 5172\n" +
            "mem[58317] = 582\n" +
            "mem[3707] = 124900\n" +
            "mask = 1001X0110XXXX11X1X100101101X000X1011\n" +
            "mem[6853] = 53203870\n" +
            "mem[10134] = 15607855\n" +
            "mem[55789] = 65720\n" +
            "mem[40948] = 26255\n" +
            "mem[23925] = 247\n" +
            "mask = 10XX00X001X0X11101100101100X0XX1X011\n" +
            "mem[21991] = 12365\n" +
            "mem[60284] = 475281124\n" +
            "mem[27156] = 712381\n" +
            "mem[40992] = 32030028\n" +
            "mem[55639] = 459820\n" +
            "mask = XX0110000100011X1X011101111X0X0001X1\n" +
            "mem[21777] = 23804\n" +
            "mem[18660] = 16096160\n" +
            "mem[13001] = 133879324\n" +
            "mem[55679] = 16534\n" +
            "mem[35334] = 95963075\n" +
            "mask = 1111X01X01100X01X1X00101000010101X01\n" +
            "mem[42543] = 830\n" +
            "mem[35104] = 119069\n" +
            "mem[30672] = 237624\n" +
            "mem[57513] = 11273\n" +
            "mem[24425] = 8038\n" +
            "mem[15062] = 880\n" +
            "mem[3370] = 1147051\n" +
            "mask = 100110X00100X111001X10X100XX0010X0X0\n" +
            "mem[34880] = 47552929\n" +
            "mem[56463] = 1311038\n" +
            "mem[34134] = 48583\n" +
            "mem[26841] = 28022630\n" +
            "mem[34391] = 238829624\n" +
            "mem[61488] = 64163\n" +
            "mask = 100110100X000X11001000111000X1X00000\n" +
            "mem[64564] = 9373265\n" +
            "mem[45253] = 516852473\n" +
            "mem[54102] = 7680\n" +
            "mem[56373] = 6272\n" +
            "mem[32800] = 20520227\n" +
            "mask = 100XX0X00100011100110001X00X01X00000\n" +
            "mem[11445] = 17299797\n" +
            "mem[45739] = 26477\n" +
            "mem[35104] = 8020\n" +
            "mem[44856] = 5098\n" +
            "mask = 100110100XXX0111001010XX0100001100X0\n" +
            "mem[31855] = 4562526\n" +
            "mem[37196] = 49264053\n" +
            "mask = 10011X1011X0011X1X010X00000000100X11\n" +
            "mem[51356] = 2533530\n" +
            "mem[21991] = 617827134\n" +
            "mem[59007] = 146920\n" +
            "mask = 10X11010001000110110001010XX101X1110\n" +
            "mem[17438] = 724\n" +
            "mem[40037] = 26066923\n" +
            "mem[62740] = 64849289\n" +
            "mem[51356] = 362548959\n" +
            "mask = 1001111XX000X1010001X1X1X010X1X00001\n" +
            "mem[62654] = 495\n" +
            "mem[13661] = 784\n" +
            "mem[2201] = 825060967\n" +
            "mem[56463] = 25468\n" +
            "mem[11152] = 332175\n" +
            "mem[11201] = 318547\n" +
            "mem[56898] = 19359\n" +
            "mask = 10011011111X011X01101010X00101001X11\n" +
            "mem[39227] = 183088177\n" +
            "mem[11942] = 18427\n" +
            "mem[56845] = 74552997\n" +
            "mem[9386] = 30899\n" +
            "mem[7664] = 28246572\n" +
            "mask = 1001101001100X11X11X100010X00X110XX0\n" +
            "mem[18885] = 28794\n" +
            "mem[1321] = 2616\n" +
            "mem[31268] = 1924\n" +
            "mem[26938] = 384173\n" +
            "mem[12796] = 400542613\n" +
            "mem[64037] = 104083\n" +
            "mask = 1001X01101X001010110110X0110000011X0\n" +
            "mem[47972] = 49309\n" +
            "mem[45634] = 85099607\n" +
            "mem[34920] = 28977\n" +
            "mem[58564] = 2559\n" +
            "mem[4311] = 700\n" +
            "mem[60974] = 658\n" +
            "mem[5228] = 4807\n" +
            "mask = XX011X11X1100011011X010X100011000110\n" +
            "mem[17753] = 70529\n" +
            "mem[17324] = 248339160\n" +
            "mem[60589] = 5812\n" +
            "mask = 11011110010X0X110X111011X1000X0X10XX\n" +
            "mem[35474] = 63093\n" +
            "mem[35770] = 170945\n" +
            "mem[31209] = 658557270\n" +
            "mem[41345] = 3895120\n" +
            "mem[28522] = 164751383\n" +
            "mask = X0X11XX01100011111X1X0000100XX111000\n" +
            "mem[8995] = 18206851\n" +
            "mem[21601] = 756\n" +
            "mem[64169] = 2372\n" +
            "mem[54020] = 40408\n" +
            "mask = 000111XX0100XX1100010000000010000110\n" +
            "mem[32975] = 11379458\n" +
            "mem[35264] = 191\n" +
            "mem[48634] = 372213\n" +
            "mem[37443] = 12419\n" +
            "mem[11441] = 168862967\n" +
            "mask = 1X0001100100X1X1XXXX100000X011101X01\n" +
            "mem[60955] = 121774\n" +
            "mem[33433] = 728\n" +
            "mem[34602] = 174\n" +
            "mem[41800] = 4552421\n" +
            "mask = 10011010X11000X1XXX0111100001X111000\n" +
            "mem[6773] = 15578957\n" +
            "mem[28044] = 3493208\n" +
            "mem[62407] = 169767\n" +
            "mem[51334] = 52448434\n" +
            "mem[53093] = 4752\n" +
            "mem[14545] = 1251\n" +
            "mask = 100110X01XX0X11111110110X01100110XXX\n" +
            "mem[18935] = 231360\n" +
            "mem[19721] = 876\n" +
            "mem[63491] = 56496605\n" +
            "mask = 10011010X110011X11X10X10101000010000\n" +
            "mem[61488] = 115634\n" +
            "mem[1321] = 19197\n" +
            "mem[33154] = 31600682\n" +
            "mask = 10011X1101X00111101X10X101X11010000X\n" +
            "mem[31209] = 30697\n" +
            "mem[30292] = 56770\n" +
            "mem[46372] = 4474\n" +
            "mem[22434] = 894\n" +
            "mask = X1011X11XXXXX01101X0X100100001100011\n" +
            "mem[33610] = 386\n" +
            "mem[46743] = 9985\n" +
            "mem[18581] = 25393973\n" +
            "mask = 1XX100X101X000010X10X011X001101X0101\n" +
            "mem[56281] = 2427\n" +
            "mem[23013] = 124563907\n" +
            "mem[41470] = 6819267\n" +
            "mem[58727] = 5142531\n" +
            "mem[63093] = 802798807\n" +
            "mem[58709] = 88\n" +
            "mask = 1001101X11100X011110010001XX010X01X0\n" +
            "mem[35264] = 9076212\n" +
            "mem[58092] = 3559173\n" +
            "mem[48925] = 58523913\n" +
            "mem[28101] = 402638054\n" +
            "mask = 10011010011001010111100001XX0010X0X1\n" +
            "mem[47972] = 128418944\n" +
            "mem[62530] = 288\n" +
            "mem[17179] = 77713212\n" +
            "mask = X0011011X0100X010110100X000100011100\n" +
            "mem[24524] = 107898\n" +
            "mem[46010] = 82127781\n" +
            "mem[45253] = 156159\n" +
            "mask = X0011X000100X1110X11100110000XX01010\n" +
            "mem[47222] = 15963\n" +
            "mem[13206] = 184605823\n" +
            "mem[34890] = 92193985\n" +
            "mem[64547] = 606039\n" +
            "mask = 1X0X101X011X011101101X111X000X1X0001\n" +
            "mem[4144] = 85071\n" +
            "mem[63340] = 3568335\n" +
            "mem[42980] = 2223\n" +
            "mem[65165] = 15723492\n" +
            "mem[55303] = 228834\n" +
            "mem[41409] = 120704\n" +
            "mask = X0X11X1011X0XX1111100X0110110111X1X0\n" +
            "mem[28969] = 5451626\n" +
            "mem[23890] = 202\n" +
            "mem[32579] = 893738\n" +
            "mem[19768] = 9755\n" +
            "mem[46679] = 4469\n" +
            "mem[10572] = 2621\n" +
            "mask = 1X01X010011X011111X001XX0001101X100X\n" +
            "mem[13230] = 4177769\n" +
            "mem[6789] = 1570\n" +
            "mem[12814] = 6330042\n" +
            "mem[19862] = 399947\n" +
            "mask = 100X0110X1001111001111X10001X1100000\n" +
            "mem[16428] = 62747997\n" +
            "mem[57753] = 3812740\n" +
            "mem[53818] = 2042073\n" +
            "mem[57170] = 65402596\n" +
            "mask = 00000110010X1X1X0011010000001X0X1X1X\n" +
            "mem[39125] = 231032\n" +
            "mem[41182] = 8309392\n" +
            "mem[41659] = 69862358\n" +
            "mem[2426] = 3954\n" +
            "mem[29634] = 1877\n" +
            "mask = 10011XX00X00110100X11X01100001X10000\n" +
            "mem[3276] = 165739267\n" +
            "mem[18985] = 215914582\n" +
            "mem[51726] = 2911\n" +
            "mem[1198] = 2689\n" +
            "mem[25096] = 38217\n" +
            "mem[65146] = 750396\n" +
            "mask = 100X000X11100111X0111X111X010X0X0100\n" +
            "mem[55354] = 71488486\n" +
            "mem[26941] = 153429\n" +
            "mem[27903] = 1242771\n" +
            "mem[20076] = 13658750\n" +
            "mask = 1X0X1X111100011110100X11XX0001X01101\n" +
            "mem[8106] = 8655\n" +
            "mem[13105] = 326089686\n" +
            "mask = 11110011011000010110XX0X1X0111X0X1X1\n" +
            "mem[47972] = 4628833\n" +
            "mem[64742] = 108229\n" +
            "mem[20310] = 234311\n" +
            "mem[22525] = 1268681\n" +
            "mem[57315] = 2293399\n" +
            "mem[1415] = 309220\n" +
            "mask = 1X01101001100X110X10X01110000X110001\n" +
            "mem[63491] = 55284\n" +
            "mem[6892] = 1776247\n" +
            "mem[22680] = 10087682\n" +
            "mask = 100110100X100111XX10X011100100101001\n" +
            "mem[32836] = 529\n" +
            "mem[60379] = 108710\n" +
            "mem[3707] = 119489129\n" +
            "mem[41220] = 407759\n" +
            "mem[17438] = 4570597\n" +
            "mem[18735] = 116991\n" +
            "mem[45194] = 632\n" +
            "mask = 10X100000X10111100100110001X01X000X0\n" +
            "mem[29832] = 17415\n" +
            "mem[18326] = 149774707\n" +
            "mem[61969] = 27327701\n" +
            "mask = 10011X100110X1X1X1X1101X000000X00X10\n" +
            "mem[37977] = 32149847\n" +
            "mem[10572] = 23418\n" +
            "mem[21601] = 46807\n" +
            "mem[3432] = 205866675\n" +
            "mem[15290] = 52828\n" +
            "mask = 1001X0X0010X111100101X100X0X000001X0\n" +
            "mem[29496] = 3463669\n" +
            "mem[22900] = 14028901\n" +
            "mem[59821] = 26258\n" +
            "mem[6007] = 3083265\n" +
            "mem[26841] = 223727\n" +
            "mask = 100110XX010001110001X000100X0X110X11\n" +
            "mem[47185] = 37062\n" +
            "mem[53497] = 486088\n" +
            "mem[20646] = 1031395\n" +
            "mem[51185] = 335\n" +
            "mem[42320] = 2256917\n" +
            "mask = X1011X1X0XX00101011010X10000XX010000\n" +
            "mem[24688] = 536538\n" +
            "mem[30782] = 45733\n" +
            "mask = 100010110X0X00100X10100X01X01011110X\n" +
            "mem[3691] = 61776413\n" +
            "mem[37654] = 3873\n" +
            "mem[32875] = 780114\n" +
            "mask = 10011X001X1X011X1111X010X00X1X110001\n" +
            "mem[54410] = 836\n" +
            "mem[63661] = 970522\n" +
            "mem[62471] = 1855\n" +
            "mem[16994] = 201\n" +
            "mem[27546] = 1249156\n" +
            "mem[37773] = 220004102\n" +
            "mem[39306] = 22122687\n" +
            "mask = 10011011XX10010101101X0100X01X001000\n" +
            "mem[16428] = 1095\n" +
            "mem[56732] = 121853353\n" +
            "mem[58092] = 234\n" +
            "mask = X010X01X010011X101X001X11000X0XX1011\n" +
            "mem[367] = 74756331\n" +
            "mem[55921] = 529419\n" +
            "mem[39160] = 278975\n" +
            "mem[6758] = 920\n" +
            "mem[32922] = 33406\n" +
            "mem[59763] = 1563\n" +
            "mem[10382] = 886\n" +
            "mask = 10011X100XX0010110100011001X10010X01\n" +
            "mem[25565] = 26956\n" +
            "mem[23146] = 57605\n" +
            "mem[28925] = 962\n" +
            "mask = 1X11X100X100011X111XX010001110X01011\n" +
            "mem[35334] = 92117904\n" +
            "mem[34488] = 59287493\n" +
            "mem[7861] = 64986498\n" +
            "mask = X001X0XXX1X00111X01110111X0101100X00\n" +
            "mem[50457] = 17353399\n" +
            "mem[62959] = 16719393\n" +
            "mem[49674] = 134654\n" +
            "mem[55789] = 2243\n" +
            "mem[22434] = 99455\n" +
            "mem[8288] = 142594569\n" +
            "mask = 10011010X11001111111110010X00X1X0001\n" +
            "mem[37420] = 41618762\n" +
            "mem[11560] = 48435\n" +
            "mem[829] = 2389\n" +
            "mem[40014] = 70681907\n" +
            "mem[36217] = 715125593\n" +
            "mem[30774] = 510\n" +
            "mem[15212] = 10840";
}
