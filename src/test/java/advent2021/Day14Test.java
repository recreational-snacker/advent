package advent2021;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Day14Test {

    @Test
    public void solution() {
        String testInput = input;
        String template = testInput.split("\n")[0];
        Map<String, String> rulesMap = getRulesMap(testInput, template);
        int steps = 40;
        while (steps > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < template.length()-1; i++) {
                String check = template.substring(i, i+2);
                String add = rulesMap.get(check);
                if (add != null) {
                    if (sb.toString().isEmpty()) {
                        sb.append(check.split("")[0]).append(add).append(check.split("")[1]);
                    } else {
                        sb.append(add).append(check.split("")[1]);
                    }
                }
            }
            template = sb.toString();
            steps--;
        }
        Map<String, Integer> count = mapElements(template);
        int mostCommon = findMostCommon(count);
        int leastCommon = findLeastCommon(count);
        System.out.println(mostCommon-leastCommon);
    }

    private int findLeastCommon(Map<String, Integer> count) {
        Optional<Map.Entry<String, Integer>> minEntry = count.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
        System.out.println(minEntry.get().getKey()+" "+minEntry.get().getValue());
        return minEntry.get().getValue();
    }

    private int findMostCommon(Map<String, Integer> count) {
        Optional<Map.Entry<String, Integer>> maxEntry = count.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        System.out.println(maxEntry.get().getKey()+" "+maxEntry.get().getValue());
        return maxEntry.get().getValue();
    }

    private Map<String, Integer> mapElements(String template) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : template.split("")) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s)+1);
            } else {
                countMap.put(s, 1);
            }
        }
        return countMap;
    }

    private Map<String, String> getRulesMap(String testInput, String template) {
        Map<String, String> rules = new HashMap<>();
        for (String s : testInput.split("\n")) {
            if (s.equals("") || s.equals(template)) {
                continue;
            } else {
                rules.put(s.split(" -> ")[0], s.split(" -> ")[1]);
            }
        }
        return rules;
    }


    private String sample = "NNCB\n" +
            "\n" +
            "CH -> B\n" +
            "HH -> N\n" +
            "CB -> H\n" +
            "NH -> C\n" +
            "HB -> C\n" +
            "HC -> B\n" +
            "HN -> C\n" +
            "NN -> C\n" +
            "BH -> H\n" +
            "NC -> B\n" +
            "NB -> B\n" +
            "BN -> B\n" +
            "BB -> N\n" +
            "BC -> B\n" +
            "CC -> N\n" +
            "CN -> C";

    private String input = "HHKONSOSONSVOFCSCNBC\n" +
            "\n" +
            "OO -> N\n" +
            "VK -> B\n" +
            "KS -> N\n" +
            "PK -> H\n" +
            "FB -> H\n" +
            "BF -> S\n" +
            "BB -> V\n" +
            "KO -> N\n" +
            "SP -> K\n" +
            "HK -> O\n" +
            "PV -> K\n" +
            "BP -> O\n" +
            "VO -> V\n" +
            "OP -> C\n" +
            "BS -> V\n" +
            "OK -> V\n" +
            "KN -> H\n" +
            "KC -> N\n" +
            "PP -> F\n" +
            "NB -> V\n" +
            "CH -> V\n" +
            "HO -> K\n" +
            "PN -> H\n" +
            "SS -> O\n" +
            "CK -> P\n" +
            "VV -> K\n" +
            "FN -> O\n" +
            "BH -> B\n" +
            "SC -> B\n" +
            "HH -> P\n" +
            "FO -> O\n" +
            "CC -> H\n" +
            "OS -> H\n" +
            "FP -> S\n" +
            "HC -> F\n" +
            "BO -> F\n" +
            "CF -> S\n" +
            "NC -> S\n" +
            "HS -> V\n" +
            "KF -> O\n" +
            "ON -> C\n" +
            "CN -> K\n" +
            "VF -> F\n" +
            "NO -> K\n" +
            "CP -> N\n" +
            "HF -> K\n" +
            "CV -> N\n" +
            "HN -> K\n" +
            "VH -> B\n" +
            "KK -> P\n" +
            "CS -> O\n" +
            "VS -> P\n" +
            "NH -> F\n" +
            "CB -> S\n" +
            "BV -> P\n" +
            "FK -> F\n" +
            "NV -> O\n" +
            "OV -> K\n" +
            "SB -> N\n" +
            "NF -> O\n" +
            "VN -> S\n" +
            "OH -> O\n" +
            "PS -> N\n" +
            "HB -> H\n" +
            "SV -> V\n" +
            "CO -> H\n" +
            "SO -> P\n" +
            "FV -> N\n" +
            "PF -> O\n" +
            "NN -> S\n" +
            "KB -> P\n" +
            "NP -> F\n" +
            "OC -> S\n" +
            "FS -> P\n" +
            "FH -> P\n" +
            "VP -> K\n" +
            "BN -> O\n" +
            "NS -> H\n" +
            "VB -> V\n" +
            "PO -> K\n" +
            "KP -> N\n" +
            "SN -> O\n" +
            "BC -> H\n" +
            "SF -> V\n" +
            "PC -> O\n" +
            "NK -> F\n" +
            "BK -> V\n" +
            "KH -> S\n" +
            "SH -> S\n" +
            "SK -> H\n" +
            "OB -> V\n" +
            "PH -> N\n" +
            "PB -> C\n" +
            "HV -> N\n" +
            "HP -> V\n" +
            "FF -> B\n" +
            "OF -> P\n" +
            "VC -> S\n" +
            "KV -> C\n" +
            "FC -> F";
}
