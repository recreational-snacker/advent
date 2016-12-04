package advent2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Deesha Singh on 2016/12/04.
 */
public class AdventDay4 {

    public static void solution2(String input) {
        List<String> validRooms = solution1(input);
        for (String room : validRooms) {
            String decryption = "";
            String checkSum = findCheckSum(room);
            Integer number = findNumber(room);
            String analyseString = room.replace("-" + number + "[" + checkSum + "]", "");
            Integer move = number%26;
            String[] letters = analyseString.split("");
            for (String s : letters) {
                if (s.equalsIgnoreCase("-")) {
                    decryption += " ";
                } else {
                    String newLetter = moveLetter(s, move);
                    decryption += newLetter;
                }
            }
            if (decryption.contains("north")) {
                System.out.println(decryption + "  :  " + number);
            }
        }

    }

    private static String moveLetter(String s, Integer move) {
        String newLetter;
        Letter letter = Letter.valueOf(s);
        Integer newValue = letter.number+move;
        if (newValue>26) {
            newValue = newValue % 26;
        }
        newLetter = getLetter(newValue).name();
        return newLetter;
    }

    public static Letter getLetter(Integer number) {
        for (Letter e : Letter.values()) {
            if (e.number == number) {
                return e;
            }
        }
        return null;
    }

    enum Letter {
        a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8), i(9), j(10), k(11), l(12), m(13), n(14), o(15), p(16), q(17), r(18)
        , s(19), t(20), u(21), v(22), w(23), x(24), y(25), z(26);

        Integer number;

        Letter(Integer number) {
            this.number = number;
        }
    }

    public static List<String> solution1(String input) {
        List<String> validRooms = new ArrayList<>();
        String[] list = input.split("\n");
        Integer total = 0;
        for (String line : list) {
            String checkSum = findCheckSum(line);
            Integer number = findNumber(line);
            String analyseString = line.replace("-" + number + "[" + checkSum + "]", "");
            String[] checkSumArray = checkSum.split("");
            Boolean valid = true;
            for (String a : checkSumArray) {
                if (!analyseString.contains(a)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                String checkSumForwards = createCheckSum(analyseString);
                if (checkSumForwards.equalsIgnoreCase(checkSum)) {
                    validRooms.add(line);
                    total = total + number;
                } else {
                }
            } else {
                continue;
            }
        }
        System.out.println("Total: " + total);
        return validRooms;
    }

    private static String createCheckSum(String analyseString) {
        String checkSum = "";

        String[] array = analyseString.split("");
        Arrays.sort(array);

        Map<String, Integer> instancesOfAllLetters = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equalsIgnoreCase("-")) {
                instancesOfAllLetters.put(array[i], countInstancesOfLetter(array, array[i]));
            }
        }
        instancesOfAllLetters = sortByValue(instancesOfAllLetters);
        Integer previousNumber = null;
        Iterator it = instancesOfAllLetters.entrySet().iterator();
        List<String> perNoCheckSum = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (previousNumber != null && previousNumber > 1) {
                if (previousNumber > Integer.valueOf(pair.getValue().toString())) {
                    if (perNoCheckSum.size() > 0) {
                        Collections.sort(perNoCheckSum);
                        for (String s : perNoCheckSum) {
                            checkSum += s;
                        }
                        perNoCheckSum.clear();
                    }
                    perNoCheckSum.add(pair.getKey().toString());
                    previousNumber = Integer.valueOf(pair.getValue().toString());
                    continue;
                } else if (previousNumber == Integer.valueOf(pair.getValue().toString())) {
                    perNoCheckSum.add(pair.getKey().toString());
                    previousNumber = Integer.valueOf(pair.getValue().toString());
                    continue;
                }
            } else if (previousNumber==null) {
                perNoCheckSum.add(pair.getKey().toString());
                previousNumber = Integer.valueOf(pair.getValue().toString());
            } else {
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equalsIgnoreCase("-")) {
                Integer count = countInstancesOfLetter(array, array[i]);
                if (count == 1) {
                    checkSum += array[i];
                }
            }
        }
        checkSum = checkSum.substring(0, 5);
//        System.out.println("CheckSum: " + checkSum);
        return checkSum;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    private static Integer countInstancesOfLetter(String[] analyseString, String letter) {
        int count = 0;
        for (String s : analyseString) {
            if (letter.equalsIgnoreCase(s)) {
                count++;
            }
        }
        return count;
    }

    private static Integer findNumber(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            return Integer.valueOf(m.group());
        }
        return 0;
    }

    private static String findCheckSum(String line) {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(line);
        while (m.find()) {
            return m.group(1);
        }
        return null;
    }
}
