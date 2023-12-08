package advent2023;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Day7Test {

    @Test
    public void sol1() {
        Map<String, Integer> handBids = new HashMap<>();
        List<String> hands = new ArrayList<>();
        for (String s : input.split("\n")) {
            handBids.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
            hands.add(s.split(" ")[0]);
        }

        List<String> highCardHands = new ArrayList<>();
        List<String> onePairHands = new ArrayList<>();
        List<String> twoPairHands = new ArrayList<>();
        List<String> threeOfAKind = new ArrayList<>();
        List<String> fullHouse = new ArrayList<>();
        List<String> fourOfAKind = new ArrayList<>();
        List<String> fiveOfAKind = new ArrayList<>();
        findOnePairHands(hands, highCardHands, onePairHands, twoPairHands, threeOfAKind, fullHouse, fourOfAKind, fiveOfAKind);

//        System.out.println("----------------------- High Cards");
//        for (String onePairHand : highCardHands) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- One Pair");
//        for (String onePairHand : onePairHands) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- Two Pair");
//        for (String onePairHand : twoPairHands) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- Three Pair");
//        for (String onePairHand : threeOfAKind) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- Full House");
//        for (String onePairHand : fullHouse) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- 4 of a kind");
//        for (String onePairHand : fourOfAKind) {
//            System.out.println(onePairHand);
//        }
//        System.out.println("----------------------- 5 of a kind");
//        for (String onePairHand : fiveOfAKind) {
//            System.out.println(onePairHand);
//        }

        Map<Integer, String> highCardHandMap = sort(highCardHands);
        Map<Integer, String> onePairHandMap = sort(onePairHands);
        Map<Integer, String> twoPairHandMap = sort(twoPairHands);
        Map<Integer, String> threeKindHandMap = sort(threeOfAKind);
        Map<Integer, String> fullHouseHandMap = sort(fullHouse);
        Map<Integer, String> fourKindHandMap = sort(fourOfAKind);
        Map<Integer, String> fiveKindHandMap = sort(fiveOfAKind);

        int count = input.split("\n").length;
        long score = 0;
        for (Map.Entry<Integer, String> entry : fiveKindHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : fourKindHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : fullHouseHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : threeKindHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : twoPairHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : onePairHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        for (Map.Entry<Integer, String> entry : highCardHandMap.entrySet()) {
            String v = entry.getValue();
            score += (long) handBids.get(v) * count;
            count--;
        }
        System.out.println(count);
        System.out.println(score);
    }

    private Map<Integer, String> sort(List<String> hands) {
        List<String> convertedHands = new ArrayList<>();
        Map<Integer, String> sortedHands = new HashMap<>();
        for (String hand : hands) {
            StringBuilder s = new StringBuilder();
            for (String s1 : hand.split("")) {
                switch (s1) {
                    case "2":
                        s.append("B");
                        break;
                    case "3":
                        s.append("C");
                        break;
                    case "4":
                        s.append("D");
                        break;
                    case "5":
                        s.append("E");
                        break;
                    case "6":
                        s.append("F");
                        break;
                    case "7":
                        s.append("G");
                        break;
                    case "8":
                        s.append("H");
                        break;
                    case "9":
                        s.append("I");
                        break;
                    case "T":
                        s.append("J");
                        break;
                    case "J":
                        s.append("K");
                        break;
                    case "Q":
                        s.append("L");
                        break;
                    case "K":
                        s.append("M");
                        break;
                    case "A":
                        s.append("N");
                        break;
                }
            }
            convertedHands.add(s.toString());
        }
        Collections.sort(convertedHands);
        Collections.reverse(convertedHands);
        int count = 0;
        for (String hand : convertedHands) {
            StringBuilder s = new StringBuilder();
            for (String s1 : hand.split("")) {
                switch (s1) {
                    case "B":
                        s.append("2");
                        break;
                    case "C":
                        s.append("3");
                        break;
                    case "D":
                        s.append("4");
                        break;
                    case "E":
                        s.append("5");
                        break;
                    case "F":
                        s.append("6");
                        break;
                    case "G":
                        s.append("7");
                        break;
                    case "H":
                        s.append("8");
                        break;
                    case "I":
                        s.append("9");
                        break;
                    case "J":
                        s.append("T");
                        break;
                    case "K":
                        s.append("J");
                        break;
                    case "L":
                        s.append("Q");
                        break;
                    case "M":
                        s.append("K");
                        break;
                    case "N":
                        s.append("A");
                        break;
                }
            }
            sortedHands.put(count, s.toString());
            count++;
        }
        return sortedHands;
    }

    private Map<Integer, String> sortPart2(List<String> hands) {
        List<String> convertedHands = new ArrayList<>();
        Map<Integer, String> sortedHands = new HashMap<>();
        for (String hand : hands) {
            StringBuilder s = new StringBuilder();
            for (String s1 : hand.split("")) {
                switch (s1) {
                    case "J":
                        s.append("A");
                        break;
                    case "2":
                        s.append("B");
                        break;
                    case "3":
                        s.append("C");
                        break;
                    case "4":
                        s.append("D");
                        break;
                    case "5":
                        s.append("E");
                        break;
                    case "6":
                        s.append("F");
                        break;
                    case "7":
                        s.append("G");
                        break;
                    case "8":
                        s.append("H");
                        break;
                    case "9":
                        s.append("I");
                        break;
                    case "T":
                        s.append("J");
                        break;
                    case "Q":
                        s.append("L");
                        break;
                    case "K":
                        s.append("M");
                        break;
                    case "A":
                        s.append("N");
                        break;
                }
            }
            convertedHands.add(s.toString());
        }
        Collections.sort(convertedHands);
        Collections.reverse(convertedHands);
        int count = 0;
        for (String hand : convertedHands) {
            StringBuilder s = new StringBuilder();
            for (String s1 : hand.split("")) {
                switch (s1) {
                    case "A":
                        s.append("J");
                        break;
                    case "B":
                        s.append("2");
                        break;
                    case "C":
                        s.append("3");
                        break;
                    case "D":
                        s.append("4");
                        break;
                    case "E":
                        s.append("5");
                        break;
                    case "F":
                        s.append("6");
                        break;
                    case "G":
                        s.append("7");
                        break;
                    case "H":
                        s.append("8");
                        break;
                    case "I":
                        s.append("9");
                        break;
                    case "J":
                        s.append("T");
                        break;
                    case "L":
                        s.append("Q");
                        break;
                    case "M":
                        s.append("K");
                        break;
                    case "N":
                        s.append("A");
                        break;
                }
            }
            sortedHands.put(count, s.toString());
            count++;
        }
        return sortedHands;
    }

    private void findOnePairHands(List<String> hands, List<String> highcard, List<String> onePair, List<String> twoPair, List<String> threeOfAKind, List<String> fullHouse, List<String> fourOfAKind, List<String> fiveOfAKind) {
        for (String hand : hands) {
            Map<String, Integer> pairMap = new HashMap<>();
            for (String s : hand.split("")) {
                int count = 0;
                for (String s1 : hand.split("")) {
                    if (s.equals(s1)) {
                        count++;
                    }
                }
               pairMap.put(s, count);
            }
            pairMap = sortByValue(pairMap);
            if (Arrays.stream(pairMap.values().toArray()).distinct().allMatch(n -> n.equals(1))) {
                highcard.add(hand);
                continue;
            }
            if (Arrays.stream(pairMap.values().toArray()).distinct().anyMatch(n -> n.equals(5))) {
                fiveOfAKind.add(hand);
                continue;
            }
            if (Arrays.stream(pairMap.values().toArray()).distinct().anyMatch(n -> n.equals(4))) {
                fourOfAKind.add(hand);
                continue;
            }
            StringBuilder s = new StringBuilder("");
            for (Map.Entry<String, Integer> entry : pairMap.entrySet()) {
                s.append(entry.getValue());
            }
            if (s.toString().equals("1112")) {
                onePair.add(hand);
                continue;
            }
            if (s.toString().equals("122")) {
                twoPair.add(hand);
                continue;
            }
            if (s.toString().equals("113")) {
                threeOfAKind.add(hand);
                continue;
            }
            if (s.toString().equals("23")) {
               fullHouse.add(hand);
            }
        }
    }

    private void findHandsPart2(List<String> hands, List<String> highcard, List<String> onePair, List<String> twoPair, List<String> threeOfAKind, List<String> fullHouse, List<String> fourOfAKind, List<String> fiveOfAKind) {
        for (String hand : hands) {
            Map<String, Integer> pairMap = new HashMap<>();
            for (String s : hand.split("")) {
                int count = 0;
                for (String s1 : hand.split("")) {
                    if (s.equals(s1)) {
                        count++;
                    }
                }
                pairMap.put(s, count);
            }
            pairMap = sortByValue(pairMap);

            if (Arrays.stream(pairMap.values().toArray()).distinct().allMatch(n -> n.equals(1)) && !pairMap.containsKey("J")) {
                highcard.add(hand);
                continue;
            }
            if (Arrays.stream(pairMap.values().toArray()).distinct().allMatch(n -> n.equals(1)) && pairMap.containsKey("J")) {
                highcard.add(hand);
                continue;
            }
            if (Arrays.stream(pairMap.values().toArray()).distinct().anyMatch(n -> n.equals(5))) {
                fiveOfAKind.add(hand);
                continue;
            }
            if (Arrays.stream(pairMap.values().toArray()).distinct().anyMatch(n -> n.equals(4))) {
                fourOfAKind.add(hand);
                continue;
            }
            StringBuilder s = new StringBuilder("");
            for (Map.Entry<String, Integer> entry : pairMap.entrySet()) {
                s.append(entry.getValue());
            }
            if (s.toString().equals("1112")) {
                onePair.add(hand);
                continue;
            }
            if (s.toString().equals("122")) {
                twoPair.add(hand);
                continue;
            }
            if (s.toString().equals("113")) {
                threeOfAKind.add(hand);
                continue;
            }
            if (s.toString().equals("23")) {
                fullHouse.add(hand);
            }
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private String input = "757T6 637\n" +
            "TTT2T 589\n" +
            "4567T 670\n" +
            "J77QQ 261\n" +
            "Q63KQ 179\n" +
            "T87KQ 969\n" +
            "Q2Q62 401\n" +
            "333Q3 241\n" +
            "K5A64 839\n" +
            "3JKJ4 152\n" +
            "Q8332 122\n" +
            "59K7J 32\n" +
            "A6666 977\n" +
            "Q76JJ 522\n" +
            "Q8992 704\n" +
            "58555 402\n" +
            "79987 147\n" +
            "T9K27 364\n" +
            "83J38 74\n" +
            "48442 128\n" +
            "789J8 223\n" +
            "4QT43 625\n" +
            "T5557 525\n" +
            "222J9 329\n" +
            "6AQ65 386\n" +
            "5J924 255\n" +
            "6326T 848\n" +
            "9Q398 108\n" +
            "8ATTT 150\n" +
            "6JT6A 160\n" +
            "32T9A 587\n" +
            "9T874 49\n" +
            "66686 669\n" +
            "26666 887\n" +
            "89K46 768\n" +
            "88T85 846\n" +
            "JTA9T 582\n" +
            "JK494 722\n" +
            "K5855 437\n" +
            "T4J8T 851\n" +
            "J3J99 299\n" +
            "639KK 436\n" +
            "K4JK3 219\n" +
            "99797 211\n" +
            "4A797 18\n" +
            "KT6JT 31\n" +
            "237T5 711\n" +
            "95599 491\n" +
            "946K9 941\n" +
            "AKKQ7 621\n" +
            "Q24T8 460\n" +
            "66J3J 756\n" +
            "3QK24 760\n" +
            "69A5K 280\n" +
            "Q42A4 20\n" +
            "43939 931\n" +
            "567JT 506\n" +
            "29992 177\n" +
            "A9TJA 62\n" +
            "K666A 440\n" +
            "AA8AA 707\n" +
            "9K9K9 125\n" +
            "K6J22 442\n" +
            "59T28 53\n" +
            "4K5T4 238\n" +
            "JK6JK 636\n" +
            "4922K 120\n" +
            "5A837 814\n" +
            "Q55J8 627\n" +
            "5QQ5J 925\n" +
            "JA8A8 39\n" +
            "4J482 483\n" +
            "AA323 302\n" +
            "95439 315\n" +
            "T5T45 724\n" +
            "64J44 679\n" +
            "JAA93 618\n" +
            "T69T5 623\n" +
            "47744 630\n" +
            "A77A7 78\n" +
            "88A8A 469\n" +
            "9A357 828\n" +
            "72A68 106\n" +
            "6AQT9 278\n" +
            "77557 447\n" +
            "757J7 899\n" +
            "7T264 40\n" +
            "7K77K 264\n" +
            "JQ98Q 256\n" +
            "A7377 50\n" +
            "443TK 493\n" +
            "99898 205\n" +
            "A8AAK 93\n" +
            "A525A 408\n" +
            "JQKKQ 526\n" +
            "64J74 651\n" +
            "K2KTK 661\n" +
            "9999J 616\n" +
            "T9TJK 486\n" +
            "Q9J9Q 176\n" +
            "8T838 895\n" +
            "2K222 877\n" +
            "399J9 251\n" +
            "AA7KT 936\n" +
            "T494K 249\n" +
            "AQAAQ 90\n" +
            "5TTT5 750\n" +
            "48843 689\n" +
            "37Q7Q 823\n" +
            "77722 236\n" +
            "9K482 390\n" +
            "AQQ76 712\n" +
            "2QQQ9 270\n" +
            "QKQKQ 320\n" +
            "35Q33 396\n" +
            "T52T2 967\n" +
            "3Q3QQ 2\n" +
            "KT57K 709\n" +
            "8AT8A 672\n" +
            "A7799 59\n" +
            "TT888 880\n" +
            "5TTT2 648\n" +
            "3A62J 654\n" +
            "22545 960\n" +
            "34T9Q 757\n" +
            "74477 311\n" +
            "AQAJ5 989\n" +
            "3K366 138\n" +
            "4AA44 987\n" +
            "85458 206\n" +
            "2K322 259\n" +
            "2822J 660\n" +
            "JJ73K 371\n" +
            "44Q4Q 954\n" +
            "7A3TA 529\n" +
            "Q794J 418\n" +
            "84488 742\n" +
            "7J77J 6\n" +
            "J4459 165\n" +
            "JQK9K 345\n" +
            "22ATT 154\n" +
            "88778 729\n" +
            "97497 600\n" +
            "55AQQ 42\n" +
            "68888 172\n" +
            "69JJQ 970\n" +
            "85A38 746\n" +
            "57J55 189\n" +
            "74977 114\n" +
            "Q3389 605\n" +
            "37883 499\n" +
            "QQ3QJ 734\n" +
            "955K9 590\n" +
            "3T5J6 488\n" +
            "7227J 296\n" +
            "3K63K 753\n" +
            "QQJJJ 260\n" +
            "K4867 766\n" +
            "J4TKQ 307\n" +
            "TJAJ2 514\n" +
            "99AQ5 662\n" +
            "K2A2T 774\n" +
            "29242 169\n" +
            "T99J9 393\n" +
            "T5QQ3 213\n" +
            "K4K4K 567\n" +
            "JATQ6 520\n" +
            "93J78 463\n" +
            "J43JJ 56\n" +
            "2J222 7\n" +
            "9T374 638\n" +
            "76695 694\n" +
            "3J748 641\n" +
            "AA4A4 549\n" +
            "4444J 412\n" +
            "J8Q99 309\n" +
            "99695 680\n" +
            "7Q7QQ 112\n" +
            "KK2KQ 728\n" +
            "5746A 971\n" +
            "JA4J4 952\n" +
            "599Q9 391\n" +
            "74574 457\n" +
            "5K477 642\n" +
            "KK899 751\n" +
            "9JK25 12\n" +
            "TKK9J 257\n" +
            "35333 235\n" +
            "7KKKK 407\n" +
            "22442 141\n" +
            "KJ55K 565\n" +
            "JQQQQ 933\n" +
            "22323 888\n" +
            "AT2Q4 560\n" +
            "5T5T5 357\n" +
            "38KA5 431\n" +
            "86668 869\n" +
            "QJ44Q 715\n" +
            "TAT8A 603\n" +
            "6J6J6 573\n" +
            "KJKK5 174\n" +
            "7T6TT 900\n" +
            "36353 350\n" +
            "545J5 508\n" +
            "39336 476\n" +
            "7Q977 535\n" +
            "99A99 470\n" +
            "8898J 234\n" +
            "QJ9QQ 304\n" +
            "J5892 13\n" +
            "K8427 765\n" +
            "J2555 541\n" +
            "6257Q 862\n" +
            "63529 272\n" +
            "3KK55 339\n" +
            "68A2K 867\n" +
            "4JJJT 949\n" +
            "2A2Q7 510\n" +
            "6KAKK 721\n" +
            "QAAQJ 703\n" +
            "3K343 875\n" +
            "A25A6 564\n" +
            "Q9977 873\n" +
            "99222 795\n" +
            "47772 30\n" +
            "QT4K5 864\n" +
            "K5978 216\n" +
            "QQQ4Q 76\n" +
            "K3KJJ 419\n" +
            "KKKJK 305\n" +
            "57272 594\n" +
            "TTT87 341\n" +
            "Q2AQJ 335\n" +
            "5Q23Q 444\n" +
            "77774 972\n" +
            "J8Q44 700\n" +
            "JJ444 314\n" +
            "A428J 183\n" +
            "TK725 290\n" +
            "332T3 929\n" +
            "TQ5J2 321\n" +
            "797K9 163\n" +
            "JT222 983\n" +
            "A666A 441\n" +
            "QTQQ7 790\n" +
            "AKKAT 400\n" +
            "J9JQA 596\n" +
            "7K93A 443\n" +
            "3Q869 904\n" +
            "5TTQ5 609\n" +
            "KTK8J 33\n" +
            "9A338 131\n" +
            "TK22T 650\n" +
            "5J25T 732\n" +
            "A5422 190\n" +
            "KK68K 719\n" +
            "TQ7KT 367\n" +
            "92438 217\n" +
            "89895 3\n" +
            "8J8QQ 1\n" +
            "JJJJJ 613\n" +
            "6366T 584\n" +
            "TQ4QQ 745\n" +
            "6KJJQ 449\n" +
            "JTT88 502\n" +
            "736QQ 847\n" +
            "687Q3 570\n" +
            "K8TA4 807\n" +
            "TATTA 298\n" +
            "TTKTT 186\n" +
            "47KKK 597\n" +
            "TAAJT 145\n" +
            "QQ6TQ 926\n" +
            "739Q9 519\n" +
            "43895 922\n" +
            "795TQ 389\n" +
            "264AJ 996\n" +
            "A5Q4T 166\n" +
            "77JQJ 914\n" +
            "Q5T99 720\n" +
            "67Q66 45\n" +
            "8J499 859\n" +
            "393K3 501\n" +
            "3TQ4A 63\n" +
            "AA8AJ 254\n" +
            "A343Q 375\n" +
            "T6T6J 965\n" +
            "Q594A 838\n" +
            "4T29Q 101\n" +
            "3QJJ3 267\n" +
            "K3J3K 958\n" +
            "78K88 126\n" +
            "J42KJ 824\n" +
            "78T53 195\n" +
            "44Q9Q 676\n" +
            "43434 592\n" +
            "6J524 918\n" +
            "KQK85 88\n" +
            "Q66Q6 671\n" +
            "45Q34 207\n" +
            "J95KK 810\n" +
            "9J997 588\n" +
            "42944 882\n" +
            "JQQQJ 871\n" +
            "98Q9Q 490\n" +
            "AAJA5 279\n" +
            "5A87T 285\n" +
            "AAAJ2 252\n" +
            "77KA3 932\n" +
            "7J68K 699\n" +
            "A3Q33 944\n" +
            "8634T 303\n" +
            "5T555 373\n" +
            "27865 752\n" +
            "94999 27\n" +
            "A7JJJ 579\n" +
            "22J26 577\n" +
            "99944 659\n" +
            "444T4 903\n" +
            "66Q9Q 340\n" +
            "QQJQ7 404\n" +
            "K29JJ 487\n" +
            "6QQ64 4\n" +
            "88A88 158\n" +
            "444Q4 845\n" +
            "7JT29 657\n" +
            "92KQ5 889\n" +
            "36JJQ 366\n" +
            "Q4866 865\n" +
            "4433J 376\n" +
            "Q98TK 975\n" +
            "J9734 192\n" +
            "9JAAA 817\n" +
            "22779 674\n" +
            "6Q877 917\n" +
            "77773 553\n" +
            "Q9899 28\n" +
            "T4A32 198\n" +
            "64448 11\n" +
            "92T8Q 181\n" +
            "36233 123\n" +
            "6KK46 44\n" +
            "23273 829\n" +
            "8AJ7Q 83\n" +
            "64293 966\n" +
            "Q6666 295\n" +
            "3T2J3 812\n" +
            "63633 962\n" +
            "37T2A 355\n" +
            "KQ565 726\n" +
            "3TQJT 149\n" +
            "999T9 681\n" +
            "7AKK5 66\n" +
            "44T4T 9\n" +
            "2TTT2 702\n" +
            "KK82K 313\n" +
            "TTJT7 538\n" +
            "8JKAA 548\n" +
            "JJ222 593\n" +
            "K3JKK 855\n" +
            "23KQ6 432\n" +
            "33745 531\n" +
            "6393J 324\n" +
            "75885 982\n" +
            "656KK 91\n" +
            "A7JKA 383\n" +
            "73979 919\n" +
            "AAKA7 948\n" +
            "56565 536\n" +
            "8A345 119\n" +
            "3QT37 911\n" +
            "5T5T8 504\n" +
            "96Q4T 552\n" +
            "KAJKK 271\n" +
            "5T57T 148\n" +
            "3K6Q7 433\n" +
            "3K98K 316\n" +
            "77TT6 837\n" +
            "Q4QQJ 178\n" +
            "7T7TT 602\n" +
            "75AA5 527\n" +
            "42K2K 992\n" +
            "53JAA 910\n" +
            "AJ6K6 629\n" +
            "38333 769\n" +
            "KK668 533\n" +
            "TK77T 439\n" +
            "67Q57 598\n" +
            "A2AA2 416\n" +
            "888QA 156\n" +
            "Q2J6J 951\n" +
            "32568 673\n" +
            "57377 569\n" +
            "9T954 47\n" +
            "65523 292\n" +
            "46754 98\n" +
            "55367 248\n" +
            "Q2JJ3 532\n" +
            "6826K 731\n" +
            "44227 231\n" +
            "92223 95\n" +
            "KQQ2Q 701\n" +
            "QQ9A5 262\n" +
            "T42T4 534\n" +
            "8T4Q4 868\n" +
            "4TTJK 139\n" +
            "46589 934\n" +
            "5252K 717\n" +
            "2TQT2 118\n" +
            "5JT82 414\n" +
            "5T4T3 852\n" +
            "599QQ 913\n" +
            "67765 51\n" +
            "67777 968\n" +
            "K2K22 682\n" +
            "A49J7 453\n" +
            "232J4 388\n" +
            "23585 892\n" +
            "92988 980\n" +
            "JQ9T9 323\n" +
            "T3T33 545\n" +
            "2QKT5 94\n" +
            "K859Q 777\n" +
            "TQJ3K 758\n" +
            "QT8J3 110\n" +
            "A3AA2 326\n" +
            "8TJ88 187\n" +
            "8K8K8 22\n" +
            "99J89 617\n" +
            "J4KA4 844\n" +
            "A2A22 863\n" +
            "46Q75 981\n" +
            "Q55AA 666\n" +
            "9J555 737\n" +
            "92295 599\n" +
            "J7482 785\n" +
            "AA77A 772\n" +
            "Q8QQJ 872\n" +
            "777A7 467\n" +
            "444AT 542\n" +
            "9K9AA 834\n" +
            "27222 784\n" +
            "5357T 878\n" +
            "4T2T3 343\n" +
            "A8996 8\n" +
            "73A3A 19\n" +
            "AA592 151\n" +
            "3JT48 38\n" +
            "5QQ5Q 286\n" +
            "KK573 793\n" +
            "QQQ2Q 497\n" +
            "J6T65 274\n" +
            "8K56T 233\n" +
            "2299J 735\n" +
            "AA47Q 413\n" +
            "529A3 344\n" +
            "K5955 706\n" +
            "77Q7Q 245\n" +
            "66J44 116\n" +
            "999A8 804\n" +
            "75J8A 434\n" +
            "57525 111\n" +
            "4K4TK 107\n" +
            "98A88 781\n" +
            "QT896 767\n" +
            "J6666 691\n" +
            "AJT9Q 764\n" +
            "Q66TT 991\n" +
            "QTTQQ 96\n" +
            "77679 132\n" +
            "59J2Q 310\n" +
            "8T886 803\n" +
            "AQ379 17\n" +
            "4TQTT 301\n" +
            "2J882 606\n" +
            "848TK 15\n" +
            "TQQ7A 927\n" +
            "QQ5TA 964\n" +
            "222TT 759\n" +
            "444K4 399\n" +
            "J6356 204\n" +
            "59549 334\n" +
            "AJTT3 780\n" +
            "97J97 137\n" +
            "AAJAA 782\n" +
            "5T37T 820\n" +
            "5T9TT 663\n" +
            "4A969 406\n" +
            "6Q595 164\n" +
            "66J26 220\n" +
            "965T3 41\n" +
            "44949 716\n" +
            "A5555 771\n" +
            "3366J 586\n" +
            "QJ3TQ 48\n" +
            "94464 336\n" +
            "7KQ53 456\n" +
            "75JA9 718\n" +
            "3Q3TQ 668\n" +
            "589A4 369\n" +
            "9K437 228\n" +
            "Q5347 438\n" +
            "9J758 492\n" +
            "KTA7K 747\n" +
            "Q333K 129\n" +
            "3Q294 370\n" +
            "2K7A7 832\n" +
            "4445J 561\n" +
            "63333 513\n" +
            "T3J47 656\n" +
            "74444 612\n" +
            "KK69K 325\n" +
            "55575 557\n" +
            "8JK82 622\n" +
            "42KT7 896\n" +
            "JTAJA 422\n" +
            "K7843 318\n" +
            "5AA59 273\n" +
            "J3373 595\n" +
            "TQJ88 244\n" +
            "TK637 884\n" +
            "6J496 485\n" +
            "TTQT2 997\n" +
            "679J6 489\n" +
            "A692K 909\n" +
            "2J834 854\n" +
            "69A35 201\n" +
            "77KJ6 171\n" +
            "4QKT4 52\n" +
            "QJ88A 349\n" +
            "5A3QK 692\n" +
            "69943 221\n" +
            "9Q3QQ 374\n" +
            "92J78 686\n" +
            "3KA7Q 224\n" +
            "33898 794\n" +
            "44666 104\n" +
            "TK23A 841\n" +
            "22327 97\n" +
            "39377 842\n" +
            "35335 836\n" +
            "KA383 604\n" +
            "87J53 450\n" +
            "5KQ88 723\n" +
            "TJTQ7 54\n" +
            "33343 876\n" +
            "77667 539\n" +
            "K9K4Q 558\n" +
            "Q737J 505\n" +
            "88223 498\n" +
            "278A3 827\n" +
            "AJAJA 426\n" +
            "7KKK7 976\n" +
            "76J94 461\n" +
            "5666J 959\n" +
            "A872Q 879\n" +
            "999AJ 347\n" +
            "66888 749\n" +
            "QJQQT 544\n" +
            "9666Q 109\n" +
            "KJ72T 755\n" +
            "4J829 620\n" +
            "22888 372\n" +
            "JJTT9 853\n" +
            "QJQT9 105\n" +
            "Q32T4 687\n" +
            "5T5KJ 800\n" +
            "JJ464 494\n" +
            "JT565 819\n" +
            "A4635 639\n" +
            "79475 571\n" +
            "TATTT 822\n" +
            "98656 559\n" +
            "62276 268\n" +
            "9TK4A 826\n" +
            "J2K55 275\n" +
            "4QQ4K 84\n" +
            "73878 354\n" +
            "82593 825\n" +
            "J5TT5 902\n" +
            "22626 801\n" +
            "K63Q3 175\n" +
            "4Q8TT 874\n" +
            "9TT8T 363\n" +
            "K2K5K 25\n" +
            "22525 986\n" +
            "33443 776\n" +
            "977A7 675\n" +
            "TT9TT 332\n" +
            "4A6AA 23\n" +
            "JAAJ8 802\n" +
            "Q99J9 649\n" +
            "33J99 956\n" +
            "4K74T 495\n" +
            "K38Q6 479\n" +
            "245QK 521\n" +
            "K25K5 395\n" +
            "QAAAA 16\n" +
            "QQQKQ 46\n" +
            "J8488 300\n" +
            "3JTTT 835\n" +
            "66993 478\n" +
            "44356 554\n" +
            "93329 883\n" +
            "55545 167\n" +
            "39999 477\n" +
            "29999 392\n" +
            "J3AJ5 738\n" +
            "KKK33 87\n" +
            "TTTT8 144\n" +
            "A33AA 831\n" +
            "52555 287\n" +
            "3TT3T 658\n" +
            "5KK55 199\n" +
            "8J6AA 237\n" +
            "J5TJ8 619\n" +
            "JJAT3 218\n" +
            "A7A62 786\n" +
            "5KKK5 379\n" +
            "9A8AA 247\n" +
            "KKA5K 857\n" +
            "56555 736\n" +
            "8637A 197\n" +
            "7AA25 365\n" +
            "9K474 516\n" +
            "74944 792\n" +
            "K66K6 890\n" +
            "7222A 912\n" +
            "JA55A 67\n" +
            "768TJ 284\n" +
            "26222 240\n" +
            "T7K5Q 833\n" +
            "76357 162\n" +
            "T2KJT 632\n" +
            "JAQQQ 468\n" +
            "6T769 984\n" +
            "88J62 773\n" +
            "393Q3 405\n" +
            "KQKJ4 79\n" +
            "422A3 640\n" +
            "743KT 924\n" +
            "TA5KA 420\n" +
            "4A7QJ 950\n" +
            "9297J 282\n" +
            "A33JA 928\n" +
            "45296 317\n" +
            "T7279 979\n" +
            "J3AAA 555\n" +
            "A75KQ 92\n" +
            "5J662 387\n" +
            "K999Q 741\n" +
            "TT4TT 466\n" +
            "T8JK5 998\n" +
            "AQA83 5\n" +
            "42374 696\n" +
            "A23QT 893\n" +
            "KQ49A 362\n" +
            "4KKJK 427\n" +
            "J7K7K 86\n" +
            "853AJ 830\n" +
            "A888T 184\n" +
            "K3KKK 957\n" +
            "Q2425 474\n" +
            "82822 923\n" +
            "9JKKK 475\n" +
            "JA6A9 540\n" +
            "88577 645\n" +
            "44443 653\n" +
            "6Q444 518\n" +
            "2833J 667\n" +
            "AK685 194\n" +
            "2783J 243\n" +
            "T6JA5 543\n" +
            "TA887 43\n" +
            "47958 799\n" +
            "9399T 955\n" +
            "6AT23 276\n" +
            "4AA88 610\n" +
            "JA9K8 860\n" +
            "QQ5QQ 743\n" +
            "5J6Q4 698\n" +
            "JJ56J 89\n" +
            "AT9AA 563\n" +
            "4JA44 464\n" +
            "24444 938\n" +
            "882K3 524\n" +
            "4KJKT 646\n" +
            "5T525 209\n" +
            "T8TT8 870\n" +
            "59555 75\n" +
            "6KTQJ 840\n" +
            "288Q2 68\n" +
            "TT777 985\n" +
            "9TTJ4 410\n" +
            "JTJ36 818\n" +
            "39Q37 953\n" +
            "36T6T 10\n" +
            "A8AJ7 193\n" +
            "5599J 124\n" +
            "AT8JA 961\n" +
            "3J3T3 121\n" +
            "9Q637 55\n" +
            "66K88 170\n" +
            "44449 159\n" +
            "Q6688 65\n" +
            "73AT7 117\n" +
            "3K2AQ 103\n" +
            "77878 338\n" +
            "3669A 378\n" +
            "JA552 377\n" +
            "TTJTT 342\n" +
            "JA27K 451\n" +
            "5JKKJ 849\n" +
            "2998J 465\n" +
            "A4Q4A 359\n" +
            "J3393 210\n" +
            "7KA83 142\n" +
            "4T3KJ 417\n" +
            "27QQQ 291\n" +
            "Q4QQ4 288\n" +
            "35ATJ 289\n" +
            "7T292 787\n" +
            "9966J 748\n" +
            "A9A99 113\n" +
            "2JK74 906\n" +
            "T856Q 683\n" +
            "8KKK7 77\n" +
            "Q2727 385\n" +
            "882TA 202\n" +
            "AA298 655\n" +
            "9TT92 945\n" +
            "738K9 943\n" +
            "KKKTT 61\n" +
            "Q3T3T 821\n" +
            "88T88 788\n" +
            "57TTK 60\n" +
            "T7QK9 994\n" +
            "2Q3A3 523\n" +
            "73377 226\n" +
            "3T337 452\n" +
            "JTJ94 306\n" +
            "766JT 423\n" +
            "Q555Q 269\n" +
            "AJQAA 730\n" +
            "75T5A 808\n" +
            "Q6A7T 29\n" +
            "KQKQT 551\n" +
            "Q7T38 381\n" +
            "J7567 283\n" +
            "4ATA2 239\n" +
            "333J3 935\n" +
            "A232A 789\n" +
            "44623 115\n" +
            "KT77A 915\n" +
            "4888K 230\n" +
            "K398T 693\n" +
            "8AAA8 102\n" +
            "3KT3K 763\n" +
            "27272 665\n" +
            "52222 937\n" +
            "96966 939\n" +
            "AT4TT 222\n" +
            "8JJTJ 294\n" +
            "J33Q4 398\n" +
            "J5886 140\n" +
            "KT26Q 575\n" +
            "68788 99\n" +
            "6TKTT 999\n" +
            "TJ823 861\n" +
            "22246 293\n" +
            "KQK7K 705\n" +
            "6A3T8 739\n" +
            "T4T6T 568\n" +
            "A8373 225\n" +
            "663J6 127\n" +
            "5KA52 644\n" +
            "66ATT 916\n" +
            "88863 446\n" +
            "84444 196\n" +
            "99298 34\n" +
            "3TAJ8 26\n" +
            "3A746 633\n" +
            "33838 481\n" +
            "KJ66K 806\n" +
            "T9577 566\n" +
            "TAAJQ 677\n" +
            "76875 473\n" +
            "Q88Q8 448\n" +
            "8995Q 454\n" +
            "AJ766 35\n" +
            "26A9J 635\n" +
            "2TJ7A 229\n" +
            "T2242 615\n" +
            "QA3JT 214\n" +
            "373A7 500\n" +
            "5TT33 330\n" +
            "63TQ7 990\n" +
            "2522J 684\n" +
            "99339 942\n" +
            "KT63A 576\n" +
            "93226 995\n" +
            "86T5A 628\n" +
            "9QAK8 312\n" +
            "7J797 697\n" +
            "T2TJT 797\n" +
            "8Q28Q 963\n" +
            "J45TK 168\n" +
            "7777J 394\n" +
            "33424 624\n" +
            "A7A3A 72\n" +
            "ATAKT 511\n" +
            "6K4QA 778\n" +
            "Q5Q4Q 974\n" +
            "JQ333 988\n" +
            "AA2J2 459\n" +
            "TK68Q 556\n" +
            "Q8888 462\n" +
            "7J676 70\n" +
            "4A72T 445\n" +
            "QAQQA 901\n" +
            "T6QQ5 608\n" +
            "4K44Q 881\n" +
            "2A33K 81\n" +
            "74AK2 253\n" +
            "6J6QQ 775\n" +
            "2Q77J 509\n" +
            "78K69 770\n" +
            "2JAQK 537\n" +
            "T66T6 482\n" +
            "2K2KT 322\n" +
            "3TT37 607\n" +
            "ATAAT 744\n" +
            "TTKK8 409\n" +
            "22333 783\n" +
            "44422 708\n" +
            "JT39T 424\n" +
            "79279 348\n" +
            "QQQ9K 811\n" +
            "JKTQ7 908\n" +
            "8AA7A 580\n" +
            "33K37 626\n" +
            "27962 429\n" +
            "8Q838 250\n" +
            "JQ24J 153\n" +
            "T5599 796\n" +
            "23333 421\n" +
            "8KJ8J 188\n" +
            "T4544 815\n" +
            "T8QT2 71\n" +
            "A9J43 425\n" +
            "4J4TT 740\n" +
            "KJ73A 319\n" +
            "2T6TT 327\n" +
            "5KK7K 517\n" +
            "A5AAA 581\n" +
            "8868J 993\n" +
            "T5A5T 856\n" +
            "TQQ48 14\n" +
            "ATTT6 346\n" +
            "TQ3TQ 136\n" +
            "6A9JJ 308\n" +
            "9Q5QK 471\n" +
            "J99KQ 161\n" +
            "999Q9 130\n" +
            "J9692 258\n" +
            "64TT6 182\n" +
            "Q2534 227\n" +
            "97779 710\n" +
            "8632Q 905\n" +
            "56TQT 263\n" +
            "55JJ5 173\n" +
            "99799 100\n" +
            "3Q489 185\n" +
            "2Q2TJ 208\n" +
            "99693 73\n" +
            "5555J 191\n" +
            "A4JA9 134\n" +
            "27426 528\n" +
            "5AKJK 215\n" +
            "789AJ 921\n" +
            "53435 885\n" +
            "6626A 664\n" +
            "K634T 384\n" +
            "4388T 356\n" +
            "JJ8JJ 36\n" +
            "7QQ6Q 685\n" +
            "43664 266\n" +
            "Q4593 920\n" +
            "88884 200\n" +
            "244QJ 733\n" +
            "99JJ9 82\n" +
            "4474T 816\n" +
            "64TA9 382\n" +
            "42Q55 562\n" +
            "J6646 337\n" +
            "6TQTQ 688\n" +
            "4J4JT 57\n" +
            "3Q373 472\n" +
            "25QJA 946\n" +
            "99QKQ 64\n" +
            "9T929 647\n" +
            "3JQ83 591\n" +
            "8JK86 265\n" +
            "78Q37 331\n" +
            "7A965 368\n" +
            "T3T7Q 85\n" +
            "58642 643\n" +
            "2944Q 695\n" +
            "8JJ88 411\n" +
            "23K43 798\n" +
            "63663 1000\n" +
            "J895Q 973\n" +
            "K9T3T 886\n" +
            "TQJ98 351\n" +
            "7KJ4T 480\n" +
            "56566 761\n" +
            "AAKAA 940\n" +
            "5JTTJ 484\n" +
            "Q45A4 80\n" +
            "JJKKK 403\n" +
            "55298 297\n" +
            "4K4TT 547\n" +
            "JQQ6Q 546\n" +
            "89AJT 809\n" +
            "J33J3 578\n" +
            "8A5A8 246\n" +
            "JA8KJ 21\n" +
            "62426 203\n" +
            "K43Q9 690\n" +
            "J2Q85 813\n" +
            "6AK27 727\n" +
            "QQ8QQ 333\n" +
            "6A9T3 435\n" +
            "22242 805\n" +
            "55K66 428\n" +
            "K4K2K 894\n" +
            "T7T44 37\n" +
            "TQTJT 898\n" +
            "AA2AA 978\n" +
            "7AKA9 277\n" +
            "5KA56 430\n" +
            "99989 652\n" +
            "4A8AQ 58\n" +
            "5KJ55 843\n" +
            "4KQ5A 550\n" +
            "K976T 157\n" +
            "T2222 24\n" +
            "37733 358\n" +
            "A9AQ5 631\n" +
            "T2847 583\n" +
            "27226 714\n" +
            "92332 503\n" +
            "94K4K 515\n" +
            "JTTJT 507\n" +
            "K8A89 135\n" +
            "AT72T 530\n" +
            "269J8 512\n" +
            "59Q3T 69\n" +
            "8822K 397\n" +
            "KJQ42 455\n" +
            "Q9T47 496\n" +
            "62KAJ 907\n" +
            "3KKK6 574\n" +
            "4K7K8 713\n" +
            "55AAK 930\n" +
            "T9878 133\n" +
            "2JTTQ 380\n" +
            "79K87 611\n" +
            "4K72K 212\n" +
            "44643 180\n" +
            "K5555 281\n" +
            "K7276 458\n" +
            "7224Q 634\n" +
            "T9TT9 143\n" +
            "A44JA 614\n" +
            "4J5A6 754\n" +
            "88J88 155\n" +
            "A4938 866\n" +
            "K22J2 762\n" +
            "684KT 678\n" +
            "99599 779\n" +
            "T78J9 353\n" +
            "A7A37 572\n" +
            "9KKKK 601\n" +
            "6T666 361\n" +
            "4949J 328\n" +
            "76784 791\n" +
            "2T68T 850\n" +
            "K4KKK 725\n" +
            "37J6T 897\n" +
            "A327A 146\n" +
            "39J7A 858\n" +
            "8TA4Q 415\n" +
            "5T83K 352\n" +
            "JJ99J 360\n" +
            "8894T 242\n" +
            "Q49QQ 232\n" +
            "Q9QQQ 891\n" +
            "6262A 585\n" +
            "K2K2K 947";
}
