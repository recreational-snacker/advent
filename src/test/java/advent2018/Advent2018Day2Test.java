package advent2018;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Advent2018Day2Test {

    private String input = "rvefnvyxzbodgpnpkumawhijsc\n" +
            "rvefqtyxzsddglnppumawhijsc\n" +
            "rvefqtywzbodglnkkubawhijsc\n" +
            "rvefqpyxzbozglnpkumawhiqsc\n" +
            "rvefqtyxzbotgenpkuyawhijsc\n" +
            "rvefqtyxzbodglnlkumtphijsc\n" +
            "rwefqtykzbodglnpkumawhijss\n" +
            "rvynqtyxzbodglnpkumawrijsc\n" +
            "rvefqtyxlbodgcnpkumawhijec\n" +
            "rvefqtyxzbodmlnpnumawhijsx\n" +
            "rvefqtyxzbqdbdnpkumawhijsc\n" +
            "rvefqtyxzlodblnpkuiawhijsc\n" +
            "rvefqtyizrodelnpkumawhijsc\n" +
            "rveffjyxzgodglnpkumawhijsc\n" +
            "rvefqjyxzbodalnpkumadhijsc\n" +
            "rvefqtidzbodglnpkumawhdjsc\n" +
            "hvefqtygzbodglnpkumawhijfc\n" +
            "rzefqtyxzbodglfhkumawhijsc\n" +
            "rmefqtyxzbolglnpkumaehijsc\n" +
            "rnefqqyxzbodglnhkumawhijsc\n" +
            "rvwfqvyxzbodglnpcumawhijsc\n" +
            "rvefqtyxzbokgltpkumavhijsc\n" +
            "rvefciyxzbodglnmkumawhijsc\n" +
            "rvefptyxzbodglnpkuhashijsc\n" +
            "rvefqtyxzrodglnpkxmawhiqsc\n" +
            "rvefqtyxzbotglnpkumawriwsc\n" +
            "rvufqtyxzbodglnplumawhijvc\n" +
            "rvefutykzbodglnpkumaahijsc\n" +
            "rvefqtyxqbodgllprumawhijsc\n" +
            "rvegqttxzbodgllpkumawhijsc\n" +
            "dvefqtyxzsodglnpkumawdijsc\n" +
            "rvefqtyxkbodglnfkumawhijsj\n" +
            "rvefqtyxzbodnlnpcumawhijnc\n" +
            "rvefqtyxzbodglfpkuocwhijsc\n" +
            "rvecqtyxzbbdganpkumawhijsc\n" +
            "rvefytyxzbodglnpkubgwhijsc\n" +
            "rvefxtyazbomglnpkumawhijsc\n" +
            "rvefqgyxzbodglnpkumawyiksc\n" +
            "avefqtyxzbodglnfkummwhijsc\n" +
            "fvefqtyxzbbdglnpkumswhijsc\n" +
            "rvefqtyxzxodglnpkumuuhijsc\n" +
            "rvezqtyxzbydclnpkumawhijsc\n" +
            "rvefqtyxzbohglnpkumawdijjc\n" +
            "rvejqtyxzbodrlnpkumawhijsd\n" +
            "rvefitzxzbxdglnpkumawhijsc\n" +
            "rvefutyxzbvdglnikumawhijsc\n" +
            "rvefqtyazbodgqnbkumawhijsc\n" +
            "rvefqtyxzbolglnpkwmajhijsc\n" +
            "rvefqtyxzjodglnpgwmawhijsc\n" +
            "rvefhtyxzbodglbpaumawhijsc\n" +
            "mvexqtyxzbodglnpkumawrijsc\n" +
            "rvefqtyxwbodglnpkumawhbxsc\n" +
            "rvefqtyxzbodgsnpkudawsijsc\n" +
            "rvwfqtyxzbonglnwkumawhijsc\n" +
            "rvefqtyxzjodglnpkfmawhwjsc\n" +
            "rvefqtyxzbodglntkumughijsc\n" +
            "rvefctyxzbodglnpkumawhiwsx\n" +
            "avefqtyvzbodglnpkumawhijsb\n" +
            "rfefqtyxzlodglnphumawhijsc\n" +
            "rvefqtyxzfowglnpkumaehijsc\n" +
            "rvhfvtyxzbodgqnpkumawhijsc\n" +
            "rfefqtyxzbodglapkumuwhijsc\n" +
            "rvefqclxzbodglnzkumawhijsc\n" +
            "qvefqtyxzbodglnckumcwhijsc\n" +
            "rvefqtyxzkodglnpkymawgijsc\n" +
            "rvefqtyxzbodgfnpkumafhizsc\n" +
            "rvefqtyxzbodglnxkumavhijsf\n" +
            "rvevqtyxzbodgpnpkurawhijsc\n" +
            "rvefqtyxziodglnpkubawhijss\n" +
            "rrefqtpxzyodglnpkumawhijsc\n" +
            "rvefqfyxzbodglcpkxmawhijsc\n" +
            "rvefdtyxzbodglnpkumvwhijsn\n" +
            "rverqtyxzbodglnpkwmawhijuc\n" +
            "rvecjtyxzboxglnpkumawhijsc\n" +
            "rvefqtyxzbodglnpkqmaxhifsc\n" +
            "rtnfqtyxzbodglnpkumawhijmc\n" +
            "lvefqtyxzbodelnpkumawhijsz\n" +
            "dvefqtyxzbbdgvnpkumawhijsc\n" +
            "rvefqlyhzbodglnpkumtwhijsc\n" +
            "roefqtyxlbodglnpkumawhyjsc\n" +
            "rvefqsydzjodglnpkumawhijsc\n" +
            "rveybtyxzbodglnpkumawhijsn\n" +
            "rvefqtyhzbodgvnpmumawhijsc\n" +
            "rvefqxyazboddlnpkumawhijsc\n" +
            "vvefqtyxzbohglqpkumawhijsc\n" +
            "reefhtyxzbodglnpkkmawhijsc\n" +
            "rvefqtyxzbodglnpkulowhijrc\n" +
            "rveqqtyxzbodgknpkumawhijsk\n" +
            "jvefqtqxzbodglnpkumawiijsc\n" +
            "rvefqtyxzboxglnpvuqawhijsc\n" +
            "rvefquyxzbodglwwkumawhijsc\n" +
            "rvefqtyxzbodnlnpkumawhgjbc\n" +
            "rvdfqthxdbodglnpkumawhijsc\n" +
            "rvefqtyxzbodllnpkumawhujsb\n" +
            "evefqtyxzboyglnpkumowhijsc\n" +
            "rvefktyxzbomglnpzumawhijsc\n" +
            "rvefqtyxzbodhlnnkrmawhijsc\n" +
            "rvefqtyxrbodglnpkujaehijsc\n" +
            "rvefqtyzzbodglnpkumrwhijsb\n" +
            "evefqtyxzpodglfpkumawhijsc\n" +
            "rvefqtyxibodglkpyumawhijsc\n" +
            "rrefqtyxzbodglnpkudawhajsc\n" +
            "rvifqtyxzbodglxpkumawhijlc\n" +
            "rxefqtyxzbedglnpkumawhijsp\n" +
            "rvnfqtyxzbopglnpkuqawhijsc\n" +
            "rvefqtyxkbodglnpoumawoijsc\n" +
            "dvefwtyxzbodglnpksmawhijsc\n" +
            "rvkfqtyxzbodglnpkdmawhijsa\n" +
            "rcefytyxzzodglnpkumawhijsc\n" +
            "rvefqtkxzbodglnpktqawhijsc\n" +
            "nvezqhyxzbodglnpkumawhijsc\n" +
            "rrefqtyxzbodgunpkumpwhijsc\n" +
            "rvefqtaxzbodgknpkumawhijic\n" +
            "pvefqtyxzbodglnpkuxawsijsc\n" +
            "rvefqtyxzbodglkpvumawhjjsc\n" +
            "wvefqtyxzkodglnpkumawhhjsc\n" +
            "rzefqtyxzbotglnpkumawhxjsc\n" +
            "rvefqtxpzbodglnpkumawzijsc\n" +
            "bgefqtyxzbodglnpkrmawhijsc\n" +
            "rvefqlyxzbodglnpkumilhijsc\n" +
            "cbefqtyxzbodglnpkumawhiesc\n" +
            "rvefqtyxzbydelnpkumahhijsc\n" +
            "rvefntyxzbodglnpkumaehijsw\n" +
            "rverqtyxztodglopkumawhijsc\n" +
            "rvefqtyxzdodgwrpkumawhijsc\n" +
            "rvefqtyxibodglnikumawhtjsc\n" +
            "qvafqtyxzbodglnpkurawhijsc\n" +
            "rvefqtyxwbodglnpaumawoijsc\n" +
            "rvefqtyxzoodglndknmawhijsc\n" +
            "rvdfqtlxzyodglnpkumawhijsc\n" +
            "rvefqtyxzbodglngfumawhinsc\n" +
            "rsefqtyxzbodglnpkumawhijek\n" +
            "rvoestyxzbodglnpkumawhijsc\n" +
            "svefqtyxzboaglnprumawhijsc\n" +
            "rvefqtybzbodgwnpkumawwijsc\n" +
            "rvefqtyxzdwdglnpkvmawhijsc\n" +
            "rvlfqtyxzbodglnpkrmawhixsc\n" +
            "rvefqtyxwbodglepkumawhijsd\n" +
            "rvefqtbxzbodglnqkumawhijmc\n" +
            "rvefqtzxzbodglnpkumuzhijsc\n" +
            "rvefqtyxzbodglnpkumawzwnsc\n" +
            "rvwfqtyxzboiglnpkumawhijsg\n" +
            "rtehotyxzbodglnpkudawhijsc\n" +
            "rvegqtyxzbodglnpyumawhijsl\n" +
            "rvecqtyxzbsdglnpkumawhojsc\n" +
            "rvefqtyxzbodmlnpkumaghijfc\n" +
            "rvefqtyxzxodglnpkumanvijsc\n" +
            "rvefqtyxzbodglnbiugawhijsc\n" +
            "lvefqtlxzbodglnplumawhijsc\n" +
            "rvefqtyxvbodglnpkumaldijsc\n" +
            "rmefqtyxzbodgvnpkuuawhijsc\n" +
            "rvefqtyxzbodglnpkymeuhijsc\n" +
            "rvefqtyxzuodganpsumawhijsc\n" +
            "rxefqtyxzbodglnpkumgwhijwc\n" +
            "rvefgtyxzbodglnpkudawxijsc\n" +
            "ahefqtyxzbodglnpkumawhejsc\n" +
            "rfefqtyxzbzdglnpkusawhijsc\n" +
            "rvefqtyszqodgljpkumawhijsc\n" +
            "rvefqtylzboiglnpkumrwhijsc\n" +
            "rvefqtyxzltdglnpkumawhijsu\n" +
            "rbefqtyxzbodglnpqumawhijsi\n" +
            "rvefqtyozpodglnpkumawhijsa\n" +
            "zvefqtyxzpopglnpkumawhijsc\n" +
            "rvefqtyxzbodglnfkqmawhijsp\n" +
            "rvefqtyxzbodgliakumawhijsf\n" +
            "rvefqtymzrodgfnpkumawhijsc\n" +
            "ivejqtyxzbodglnpkumawhijuc\n" +
            "rvefqtyxzbodflnpkxwawhijsc\n" +
            "dvrfqtyxzbodglnpkumashijsc\n" +
            "rqefqtyxzbwdglnpkumawvijsc\n" +
            "tvefqtkxzbodgltpkumawhijsc\n" +
            "rvefdtyxzbodguxpkumawhijsc\n" +
            "rveqqtyxvbodglnykumawhijsc\n" +
            "rvefqtypzcovglnpkumawhijsc\n" +
            "rvefqnyxzbosglnpkumdwhijsc\n" +
            "rvefstjxzbodslnpkumawhijsc\n" +
            "rvefqzyxzpodglnpkummwhijsc\n" +
            "rvefqkyxzbodglnhgumawhijsc\n" +
            "rvufqvyxzbodklnpkumawhijsc\n" +
            "rvefotyxzhodglnpkumawhijsk\n" +
            "rvefqtyxzbokglnpkumawvcjsc\n" +
            "lvefqtyxzbolglnpkumawoijsc\n" +
            "rvefqtywzoodglfpkumawhijsc\n" +
            "rvehqtqxzbodglnpkumawhcjsc\n" +
            "rqefqtyxzbodolnpkumjwhijsc\n" +
            "rvefqtyxzbodglrpkunawgijsc\n" +
            "rvefqtyxzbodglamkumawdijsc\n" +
            "rvefvtyzzbodllnpkumawhijsc\n" +
            "rvefqtyxzbldglnpfcmawhijsc\n" +
            "rvefppyxzbodglnpkucawhijsc\n" +
            "rvefquyuzbodglnpkumkwhijsc\n" +
            "rvefqtyxzbodgqxpkumawhivsc\n" +
            "rtefotyxzbodglnpkudawhijsc\n" +
            "rvefqtyxzbodgbnmkuzawhijsc\n" +
            "ivefqtyxzbodgsnpkumzwhijsc\n" +
            "rvhfqtyxzbodolnpkumawhijsz\n" +
            "rvefvtyxzbodwlnpkusawhijsc\n" +
            "riemqtyxzbodglnpkumawhiasc\n" +
            "rvtfqtyxzbqdglnpkumawuijsc\n" +
            "raesqtyxzbodglnpkumawhijsj\n" +
            "rvefqtyxzbodalmpkumawhihsc\n" +
            "rvefqtlxzbodgznpkkmawhijsc\n" +
            "rvefqbyxzbodglgpkubawhijsc\n" +
            "rvefqtyxnbodgxnpkumswhijsc\n" +
            "rvefqtyxzkodvlnukumawhijsc\n" +
            "rvefqtyzzbocglnpkumafhijsc\n" +
            "rvhfqtyxzbodglmpkumgwhijsc\n" +
            "rvsfrtyxzbodnlnpkumawhijsc\n" +
            "rvefqtyxzbxdglnpkujcwhijsc\n" +
            "rvefqtyvzrodglnphumawhijsc\n" +
            "reetatyxzbodglnpkumawhijsc\n" +
            "rvefqtyxzbodglnpzumaoqijsc\n" +
            "ovefqtyyzbodglnvkumawhijsc\n" +
            "rvefqbyxzbodnlnpkumawhijsi\n" +
            "xvefqtyxzbodgrnpkumawrijsc\n" +
            "rvebqtyxzbodglnpkumazhiasc\n" +
            "rqeretyxzbodglnpkumawhijsc\n" +
            "rvefqtyxzyodglapkumvwhijsc\n" +
            "rvesqxyxzbodglnpvumawhijsc\n" +
            "rvefqtyxeborglnpkufawhijsc\n" +
            "rvecqtyxzbodflnpkumawnijsc\n" +
            "rvefdpyxtbodglnpkumawhijsc\n" +
            "rvefqtyfzbodclnpkymawhijsc\n" +
            "rvefqtywzbodglnpxumawhiusc\n" +
            "rvefqtyxzbodglnpkumawzbjwc\n" +
            "rvewqtyxdbodglnpxumawhijsc\n" +
            "rvefqtyxzgocglnpkgmawhijsc\n" +
            "rvufqtyxzbodggnpkuzawhijsc\n" +
            "rvefqtynzlodgllpkumawhijsc\n" +
            "rvedqtyxzbodghnpkumawhujsc\n" +
            "rvefqtyxlbodgnnpkpmawhijsc\n" +
            "rvefqtyxzboqglnpkzmawhijec\n" +
            "rvefqtyxzbodglnpkfmwwyijsc\n" +
            "rwefqtkxzbodzlnpkumawhijsc\n" +
            "rvefqtyxvbodglnpkufawhyjsc\n" +
            "rvefqtyxzbodgltpkumawhqmsc\n" +
            "rvefctyxzbodglfpkumathijsc\n" +
            "rvefqtyxzbodgfnpkuuawhijfc\n" +
            "rvefqttxzbodglnpmumawhijwc\n" +
            "rvefqtyxzbodglnpkqmawhihsj\n" +
            "rvefqtyxzbsdglcnkumawhijsc\n" +
            "rvbiqtyxzbodglnpkumawhijlc\n" +
            "rnefqtylzvodglnpkumawhijsc\n" +
            "mvefqtyxzbddglnpkumcwhijsc\n" +
            "rvefwtyxzbodglnpkgmawhijxc\n" +
            "rvefqtyxljodglnpkumxwhijsc\n" +
            "rvefqtyxzbodglnpkuprwhijsd\n" +
            "rcxfqtyxzbldglnpkumawhijsc\n" +
            "rvetqtyxzbojglnpkumewhijsc\n" +
            "rvxfqtyxzbtdglnpkbmawhijsc";

    @Test
    public void testPart1() {
        int checkSum = calculateChecksum(input);
        System.out.println("Checksum: " + checkSum);
    }

    private int calculateChecksum(String input) {
        String[] inputArray = input.split("\\n");
        int twoCount = 0;
        int threeCount = 0;
        for (String s : inputArray) {
            Map<String, Integer> letterCount = new HashMap<>();
            String[] rowInput = s.split("");
            for (String letter : rowInput) {
                if (letterCount.containsKey(letter)) {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                } else {
                    letterCount.put(letter, 1);
                }
            }
            for (Map.Entry<String, Integer> entry : letterCount.entrySet()) {
                if (entry.getValue() == 2) {
                    twoCount++;
                    break;
                }
            }
            for (Map.Entry<String, Integer> entry : letterCount.entrySet()) {
                if (entry.getValue() == 3) {
                    threeCount++;
                    break;
                }
            }
        }
        return twoCount * threeCount;
    }

    @Test
    public void testPart2() {
        String commonLetters = findCommonLetters(input);
        System.out.println("Common code: " + commonLetters);
    }

    private String findCommonLetters(String input) {
        String[] inputArray = input.split("\\n");
        for (String originalString : inputArray) {
            for (String compareString : inputArray) {
                if (originalString.equals(compareString)) {
                    continue;
                }
                String[] originalStringArray = originalString.split("");
                String[] compareStringArray = compareString.split("");
                Boolean matching = compareLetters(originalStringArray, compareStringArray);
                if (matching) {
                    return getCommonLetters(originalStringArray, compareStringArray);
                }
            }
        }
        return null;
    }

    private String getCommonLetters(String[] originalStringArray, String[] compareStringArray) {
        StringBuilder finalSB = new StringBuilder("");
        for (int i = 0; i < originalStringArray.length; i++) {
            if (originalStringArray[i].equals(compareStringArray[i])) {
                finalSB.append(originalStringArray[i]);
            }
        }
        return finalSB.toString();
    }

    private Boolean compareLetters(String[] originalStringArray, String[] compareStringArray) {
        Boolean matching = true;
        Boolean foundFirstNonMatchingLetter = false;
        for (int i = 0; i < originalStringArray.length; i++) {
            if (!originalStringArray[i].equals(compareStringArray[i])) {
                if (!foundFirstNonMatchingLetter) {
                    foundFirstNonMatchingLetter = true;
                } else {
                    matching = false;
                }
            }
        }
        return matching;
    }


}
