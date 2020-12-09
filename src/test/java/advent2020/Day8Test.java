package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day8Test {

    private String sample = "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";

    private String[] splitString (String input) {
        return input.split("\n");
    }

    private String getInstruction(String value) {
        return value.split(" ")[0];
    }

    private Integer processAcc(Integer accumulator, String value) {
        String dir = value.split("")[0];
        Integer dist = Integer.parseInt(value.substring(1));
        if ("+".equals(dir)) {
            return accumulator += dist;
        } else {
            return accumulator -= dist;
        }
    }

    private String processInstructions(String input) {
        String[] instructions = splitString(input);
        Integer accumulator = 0;
        List<Integer> processedIndexes = new ArrayList<>();
        for (int i = 0; i < instructions.length; i++) {
            if (processedIndexes.contains(i)) {
                return "repeat "+accumulator;
            }
            processedIndexes.add(i);
            String instruction = getInstruction(instructions[i]);
            if ("nop".equalsIgnoreCase(instruction)) {
                continue;
            } else if ("jmp".equalsIgnoreCase(instruction)) {
                String value = instructions[i].split(" ")[1];
                i = processJmp(i, value);
            } else if ("acc".equalsIgnoreCase(instruction)) {
                String value = instructions[i].split(" ")[1];
                accumulator = processAcc(accumulator, value);
            }
        }
        return accumulator.toString();
    }

    private Integer processJmp(int i, String value) {
        String dir = value.split("")[0];
        Integer dist = Integer.parseInt(value.substring(1));
        if ("+".equals(dir)) {
            i += dist - 1;
        } else {
            i -= dist + 1;
        }
        return i;
    }

    private Integer findTerminatingProcess(String input) {
        String[] split = splitString(input);
        for (int i = 0; i < split.length; i++) {
            String newInstr = null;
            if (split[i].contains("jmp")) {
                newInstr = split[i].replace("jmp", "nop");
            } else if (split[i].contains("nop")) {
                newInstr = split[i].replace("nop", "jmp");
            }
            String newInput = replaceInstr(newInstr, i, split);
            String result = processInstructions(newInput);
            if (!result.contains("repeat")) {
                return Integer.parseInt(result);
            }
        }
        return null;
    }

    private String replaceInstr(String newInstr, int i, String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i1 = 0; i1 < input.length; i1++) {
            if (i == i1) {
                stringBuilder.append(newInstr+"\n");
            } else {
                stringBuilder.append(input[i1]+"\n");
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(processInstructions(input));
        System.out.println(findTerminatingProcess(input));
    }

    private String input = "acc +40\n" +
            "jmp +187\n" +
            "acc +47\n" +
            "acc +20\n" +
            "acc -12\n" +
            "jmp +225\n" +
            "nop +488\n" +
            "acc +13\n" +
            "nop +462\n" +
            "jmp +374\n" +
            "acc +15\n" +
            "acc +42\n" +
            "jmp +116\n" +
            "acc +23\n" +
            "nop +216\n" +
            "acc -15\n" +
            "jmp +398\n" +
            "jmp +103\n" +
            "acc +17\n" +
            "acc +7\n" +
            "jmp +571\n" +
            "jmp +1\n" +
            "jmp +217\n" +
            "acc +7\n" +
            "jmp +1\n" +
            "acc +35\n" +
            "jmp +257\n" +
            "acc +24\n" +
            "nop +20\n" +
            "jmp +309\n" +
            "acc +2\n" +
            "acc -15\n" +
            "acc -13\n" +
            "nop +457\n" +
            "jmp +19\n" +
            "acc +46\n" +
            "acc +45\n" +
            "acc +35\n" +
            "jmp +295\n" +
            "acc -15\n" +
            "acc +49\n" +
            "acc +22\n" +
            "jmp +400\n" +
            "jmp +202\n" +
            "nop -38\n" +
            "jmp +381\n" +
            "acc +0\n" +
            "jmp +137\n" +
            "acc +27\n" +
            "jmp +196\n" +
            "acc +46\n" +
            "acc -15\n" +
            "jmp +348\n" +
            "jmp +457\n" +
            "acc +50\n" +
            "acc +8\n" +
            "jmp +452\n" +
            "acc -14\n" +
            "nop +321\n" +
            "acc +39\n" +
            "jmp +273\n" +
            "acc -9\n" +
            "jmp +413\n" +
            "acc +32\n" +
            "jmp +64\n" +
            "acc +18\n" +
            "jmp +152\n" +
            "acc -4\n" +
            "acc +9\n" +
            "acc +10\n" +
            "acc -1\n" +
            "jmp +433\n" +
            "acc +40\n" +
            "jmp -55\n" +
            "acc +28\n" +
            "nop +279\n" +
            "jmp +145\n" +
            "acc +24\n" +
            "nop +416\n" +
            "acc +45\n" +
            "jmp +45\n" +
            "acc +0\n" +
            "acc +49\n" +
            "acc -14\n" +
            "jmp +44\n" +
            "acc +17\n" +
            "acc +18\n" +
            "nop +224\n" +
            "acc +3\n" +
            "jmp +261\n" +
            "jmp -84\n" +
            "acc -11\n" +
            "acc +29\n" +
            "acc +42\n" +
            "jmp -13\n" +
            "acc -5\n" +
            "jmp +210\n" +
            "acc +26\n" +
            "acc -19\n" +
            "acc -19\n" +
            "jmp -82\n" +
            "acc +29\n" +
            "acc +31\n" +
            "acc -4\n" +
            "jmp +53\n" +
            "acc +46\n" +
            "jmp +139\n" +
            "acc +45\n" +
            "acc +30\n" +
            "jmp +1\n" +
            "jmp +418\n" +
            "jmp +248\n" +
            "acc +24\n" +
            "acc +15\n" +
            "acc +34\n" +
            "acc +17\n" +
            "jmp +52\n" +
            "acc +23\n" +
            "acc +18\n" +
            "jmp +65\n" +
            "jmp +1\n" +
            "acc +37\n" +
            "acc +25\n" +
            "jmp +385\n" +
            "jmp +281\n" +
            "nop +345\n" +
            "jmp -25\n" +
            "jmp +149\n" +
            "acc +21\n" +
            "acc +28\n" +
            "acc +15\n" +
            "jmp -74\n" +
            "jmp +179\n" +
            "jmp +287\n" +
            "acc +14\n" +
            "acc -3\n" +
            "acc -7\n" +
            "jmp -9\n" +
            "acc +17\n" +
            "acc -8\n" +
            "jmp +344\n" +
            "jmp +1\n" +
            "acc +36\n" +
            "acc -16\n" +
            "acc -17\n" +
            "jmp -82\n" +
            "jmp +1\n" +
            "acc +41\n" +
            "acc -8\n" +
            "acc +27\n" +
            "jmp +381\n" +
            "acc -10\n" +
            "nop -71\n" +
            "acc +23\n" +
            "nop +377\n" +
            "jmp -125\n" +
            "jmp +319\n" +
            "nop +119\n" +
            "nop +309\n" +
            "nop +195\n" +
            "jmp +307\n" +
            "acc +8\n" +
            "acc +31\n" +
            "jmp +1\n" +
            "acc -15\n" +
            "jmp +398\n" +
            "jmp +265\n" +
            "jmp -55\n" +
            "nop +143\n" +
            "jmp -36\n" +
            "acc +38\n" +
            "nop -38\n" +
            "jmp +298\n" +
            "acc -17\n" +
            "acc +39\n" +
            "acc -13\n" +
            "jmp -38\n" +
            "acc +23\n" +
            "jmp +133\n" +
            "acc +23\n" +
            "jmp -90\n" +
            "acc +14\n" +
            "jmp +1\n" +
            "jmp +100\n" +
            "nop +230\n" +
            "jmp +346\n" +
            "acc +36\n" +
            "jmp +14\n" +
            "jmp +126\n" +
            "jmp -32\n" +
            "jmp -142\n" +
            "acc +25\n" +
            "jmp +146\n" +
            "nop +118\n" +
            "acc -3\n" +
            "jmp +1\n" +
            "acc -8\n" +
            "jmp +101\n" +
            "nop +277\n" +
            "acc +27\n" +
            "jmp +328\n" +
            "acc -11\n" +
            "acc +17\n" +
            "nop +135\n" +
            "jmp +196\n" +
            "acc -9\n" +
            "jmp +39\n" +
            "nop +110\n" +
            "acc +14\n" +
            "nop +3\n" +
            "jmp +17\n" +
            "jmp +220\n" +
            "acc +17\n" +
            "jmp +5\n" +
            "acc +18\n" +
            "acc +39\n" +
            "acc -12\n" +
            "jmp -204\n" +
            "jmp +317\n" +
            "acc +37\n" +
            "jmp +222\n" +
            "nop +146\n" +
            "nop +248\n" +
            "jmp +182\n" +
            "acc +48\n" +
            "acc -13\n" +
            "jmp +174\n" +
            "jmp +342\n" +
            "nop -189\n" +
            "jmp +324\n" +
            "acc +35\n" +
            "acc +25\n" +
            "acc +21\n" +
            "jmp -152\n" +
            "nop -92\n" +
            "acc -3\n" +
            "acc -15\n" +
            "acc +30\n" +
            "jmp -157\n" +
            "acc -17\n" +
            "acc +37\n" +
            "acc +7\n" +
            "acc +5\n" +
            "jmp -225\n" +
            "jmp -177\n" +
            "acc +21\n" +
            "jmp +244\n" +
            "acc +42\n" +
            "acc -4\n" +
            "jmp -116\n" +
            "nop +225\n" +
            "nop -63\n" +
            "acc +20\n" +
            "jmp +195\n" +
            "acc +20\n" +
            "acc +21\n" +
            "jmp +228\n" +
            "acc +16\n" +
            "acc -8\n" +
            "acc +12\n" +
            "nop +188\n" +
            "jmp +9\n" +
            "acc +6\n" +
            "acc -13\n" +
            "acc +36\n" +
            "jmp -86\n" +
            "jmp -253\n" +
            "nop -60\n" +
            "acc +25\n" +
            "jmp -174\n" +
            "acc +10\n" +
            "nop -114\n" +
            "jmp -65\n" +
            "jmp +1\n" +
            "acc +24\n" +
            "jmp -150\n" +
            "acc +27\n" +
            "jmp -47\n" +
            "acc +50\n" +
            "nop -58\n" +
            "acc -17\n" +
            "acc -16\n" +
            "jmp -170\n" +
            "jmp -104\n" +
            "jmp -177\n" +
            "acc +46\n" +
            "jmp +106\n" +
            "jmp -206\n" +
            "acc +2\n" +
            "acc +10\n" +
            "acc +17\n" +
            "nop -107\n" +
            "jmp -126\n" +
            "jmp +1\n" +
            "acc +50\n" +
            "acc -14\n" +
            "acc +29\n" +
            "jmp -234\n" +
            "nop +144\n" +
            "acc +43\n" +
            "acc +34\n" +
            "jmp +221\n" +
            "jmp +1\n" +
            "nop +97\n" +
            "acc +39\n" +
            "jmp -60\n" +
            "acc +44\n" +
            "jmp -240\n" +
            "acc +11\n" +
            "acc +36\n" +
            "jmp -71\n" +
            "acc -5\n" +
            "jmp +149\n" +
            "jmp +54\n" +
            "acc +38\n" +
            "jmp +44\n" +
            "jmp -165\n" +
            "acc +14\n" +
            "jmp -134\n" +
            "acc +3\n" +
            "acc +22\n" +
            "nop +46\n" +
            "acc -12\n" +
            "jmp -57\n" +
            "acc +49\n" +
            "acc +24\n" +
            "acc +16\n" +
            "jmp +27\n" +
            "acc +6\n" +
            "nop -5\n" +
            "acc +45\n" +
            "acc +34\n" +
            "jmp -175\n" +
            "jmp -76\n" +
            "acc +3\n" +
            "acc +15\n" +
            "acc -19\n" +
            "jmp +1\n" +
            "nop -226\n" +
            "acc -2\n" +
            "jmp -55\n" +
            "jmp -284\n" +
            "acc +2\n" +
            "jmp +1\n" +
            "jmp +15\n" +
            "acc +11\n" +
            "acc +12\n" +
            "acc -1\n" +
            "acc +2\n" +
            "jmp +179\n" +
            "acc +19\n" +
            "acc +17\n" +
            "jmp -329\n" +
            "jmp -272\n" +
            "jmp -104\n" +
            "acc +41\n" +
            "nop +189\n" +
            "acc +47\n" +
            "jmp -88\n" +
            "acc +4\n" +
            "acc +16\n" +
            "acc +43\n" +
            "acc +25\n" +
            "jmp +71\n" +
            "acc -2\n" +
            "acc +45\n" +
            "jmp -173\n" +
            "jmp +1\n" +
            "acc +44\n" +
            "acc +33\n" +
            "jmp -53\n" +
            "acc +45\n" +
            "acc +9\n" +
            "acc +0\n" +
            "acc +12\n" +
            "jmp +178\n" +
            "jmp -100\n" +
            "acc +14\n" +
            "jmp -67\n" +
            "acc +42\n" +
            "jmp +201\n" +
            "acc +30\n" +
            "jmp -319\n" +
            "nop -4\n" +
            "nop -211\n" +
            "acc -3\n" +
            "nop -165\n" +
            "jmp -175\n" +
            "acc +12\n" +
            "acc -10\n" +
            "acc -14\n" +
            "jmp -53\n" +
            "acc -13\n" +
            "nop -143\n" +
            "jmp +159\n" +
            "acc -5\n" +
            "nop +18\n" +
            "nop -5\n" +
            "acc +13\n" +
            "jmp -248\n" +
            "jmp +114\n" +
            "acc +10\n" +
            "nop -396\n" +
            "nop -246\n" +
            "jmp +16\n" +
            "acc -3\n" +
            "acc +33\n" +
            "nop +174\n" +
            "acc +48\n" +
            "jmp -289\n" +
            "nop +98\n" +
            "acc +18\n" +
            "acc -17\n" +
            "jmp -137\n" +
            "jmp +1\n" +
            "acc +34\n" +
            "acc +36\n" +
            "jmp -216\n" +
            "acc +11\n" +
            "jmp -102\n" +
            "acc +10\n" +
            "jmp +10\n" +
            "acc +26\n" +
            "acc +35\n" +
            "acc -9\n" +
            "jmp -83\n" +
            "acc +15\n" +
            "nop -397\n" +
            "jmp -140\n" +
            "nop +111\n" +
            "jmp +139\n" +
            "jmp -165\n" +
            "acc +16\n" +
            "jmp -343\n" +
            "acc +8\n" +
            "acc +35\n" +
            "acc -17\n" +
            "acc -8\n" +
            "jmp +29\n" +
            "acc +50\n" +
            "nop -256\n" +
            "jmp -268\n" +
            "jmp +132\n" +
            "acc +13\n" +
            "acc +38\n" +
            "acc -6\n" +
            "acc -7\n" +
            "jmp -327\n" +
            "acc -8\n" +
            "jmp -256\n" +
            "nop -139\n" +
            "acc +30\n" +
            "jmp -60\n" +
            "acc -1\n" +
            "acc +11\n" +
            "jmp -216\n" +
            "acc -12\n" +
            "nop -390\n" +
            "acc +17\n" +
            "acc +39\n" +
            "jmp +101\n" +
            "acc +28\n" +
            "jmp +1\n" +
            "acc -7\n" +
            "acc -18\n" +
            "jmp -277\n" +
            "jmp -90\n" +
            "acc -10\n" +
            "jmp -326\n" +
            "jmp -368\n" +
            "nop -396\n" +
            "jmp -320\n" +
            "acc +42\n" +
            "acc +3\n" +
            "jmp -430\n" +
            "acc +47\n" +
            "acc +11\n" +
            "acc +19\n" +
            "acc +41\n" +
            "jmp -354\n" +
            "acc +30\n" +
            "acc +7\n" +
            "nop -106\n" +
            "jmp -420\n" +
            "acc +22\n" +
            "acc -15\n" +
            "jmp -296\n" +
            "acc -7\n" +
            "acc +48\n" +
            "jmp -19\n" +
            "jmp -148\n" +
            "acc +10\n" +
            "jmp +1\n" +
            "jmp +17\n" +
            "nop -273\n" +
            "acc +42\n" +
            "acc -4\n" +
            "nop -130\n" +
            "jmp +47\n" +
            "nop -436\n" +
            "acc -7\n" +
            "jmp +1\n" +
            "acc +42\n" +
            "jmp -330\n" +
            "acc +35\n" +
            "jmp +56\n" +
            "acc -19\n" +
            "jmp -440\n" +
            "jmp -335\n" +
            "jmp -279\n" +
            "nop -390\n" +
            "jmp +74\n" +
            "acc -5\n" +
            "jmp -456\n" +
            "acc +38\n" +
            "acc +3\n" +
            "jmp +47\n" +
            "acc +50\n" +
            "acc +26\n" +
            "acc +46\n" +
            "acc -7\n" +
            "jmp -491\n" +
            "acc -4\n" +
            "acc -7\n" +
            "acc +14\n" +
            "nop -105\n" +
            "jmp -487\n" +
            "jmp -326\n" +
            "nop -360\n" +
            "jmp -378\n" +
            "jmp -285\n" +
            "acc +46\n" +
            "jmp -190\n" +
            "acc +10\n" +
            "jmp -346\n" +
            "acc +49\n" +
            "jmp -492\n" +
            "acc -9\n" +
            "acc -17\n" +
            "jmp -147\n" +
            "acc +20\n" +
            "jmp -217\n" +
            "nop -183\n" +
            "acc +35\n" +
            "jmp -268\n" +
            "nop -51\n" +
            "jmp +1\n" +
            "jmp -440\n" +
            "acc +22\n" +
            "acc +24\n" +
            "jmp +1\n" +
            "acc +26\n" +
            "jmp -451\n" +
            "acc -14\n" +
            "acc +48\n" +
            "acc +3\n" +
            "jmp -363\n" +
            "acc +21\n" +
            "acc +24\n" +
            "acc +36\n" +
            "jmp -418\n" +
            "jmp -108\n" +
            "jmp -323\n" +
            "jmp +20\n" +
            "acc +1\n" +
            "acc +21\n" +
            "nop -212\n" +
            "acc -3\n" +
            "jmp -338\n" +
            "acc +36\n" +
            "acc -19\n" +
            "jmp -192\n" +
            "acc +49\n" +
            "jmp -380\n" +
            "acc -12\n" +
            "acc +14\n" +
            "acc +38\n" +
            "acc +4\n" +
            "jmp -228\n" +
            "acc +2\n" +
            "jmp -197\n" +
            "jmp -41\n" +
            "jmp -265\n" +
            "jmp -113\n" +
            "jmp -459\n" +
            "jmp +1\n" +
            "acc +38\n" +
            "jmp -79\n" +
            "acc +16\n" +
            "nop -456\n" +
            "jmp -129\n" +
            "acc +12\n" +
            "acc +29\n" +
            "nop -575\n" +
            "acc -7\n" +
            "jmp +1";
}
