package advent2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Day2Test {

    private String sample = "1-3 a: abcde\n" +
            "1-3 b: cdefg\n" +
            "2-9 c: ccccccccc";

    private List<String> makeList(String problem) {
        String[] string = problem.split("\n");
        return Arrays.asList(string);
    }

    private PasswordPolicy formatPassword(String password) {
        String[] passwordConditions = password.split(" ");
        int min = Integer.parseInt(passwordConditions[0].split("-")[0]);
        int max = Integer.parseInt(passwordConditions[0].split("-")[1]);

        String req = passwordConditions[1].replace(":", "");

        String pass = passwordConditions[2];
        return new PasswordPolicy(min, max, req, pass);
    }

    private boolean isValidProblem1(PasswordPolicy passwordPolicy) {
        String[] pass = passwordPolicy.getPassword().split("");
        int count = 0;
        for (String s : pass) {
            if (s.equalsIgnoreCase(passwordPolicy.getReq())) {
                count++;
            }
        }
        if (count <= passwordPolicy.getMax() && count >= passwordPolicy.getMin()) {
            return true;
        }
        return false;
    }

    private int countValidPasswords(String input, int problemSet) {
        int count = 0;
        List<String> stringList = makeList(input);
        for (String s : stringList) {
            PasswordPolicy passwordPolicy = formatPassword(s);
            if (problemSet == 1) {
                if (isValidProblem1(passwordPolicy)) {
                    count++;
                }
            } else {
                if (isValidProblem2(passwordPolicy)) {
                    count++;
                }
            }

        }
        return count;
    }

    private boolean isValidProblem2(PasswordPolicy passwordPolicy) {
        String[] pass = passwordPolicy.getPassword().split("");
        boolean lowCountIsValid = false;
        boolean highCountIsValid = false;
        int lowIndex = passwordPolicy.getMin()-1;
        int highIndex = passwordPolicy.getMax()-1;
        if (pass.length>lowIndex && pass[lowIndex].equalsIgnoreCase(passwordPolicy.getReq())) {
            lowCountIsValid = true;
        }
        if (pass.length>highIndex && pass[highIndex].equalsIgnoreCase(passwordPolicy.getReq())) {
            highCountIsValid = true;
        }
        if (lowCountIsValid && highCountIsValid) {
            return false;
        } else if (!lowCountIsValid && !highCountIsValid) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println("1 - Sample: "+countValidPasswords(sample, 1));
        System.out.println("1 - Input: "+countValidPasswords(input, 1));
        System.out.println("2 - Sample: "+countValidPasswords(sample, 2));
        System.out.println("2 - Input: "+countValidPasswords(input, 2));
    }

    private class PasswordPolicy {

        private int min;
        private int max;
        private String req;
        private String password;

        public PasswordPolicy(int min, int max, String req, String password) {
            this.min = min;
            this.max = max;
            this.req = req;
            this.password = password;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getReq() {
            return req;
        }

        public void setReq(String req) {
            this.req = req;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private String input = "2-6 w: wkwwwfwwpvw\n" +
            "14-15 v: hvhvlhvvvwxvdvscdpvg\n" +
            "2-3 b: bkkb\n" +
            "3-4 v: wgvvzvhcvlrvjvvmv\n" +
            "11-12 c: cccccccccqcccckcc\n" +
            "2-5 z: zkzpzlzzzzz\n" +
            "7-13 x: xxxxxxxxxxxxxxx\n" +
            "7-10 f: zffxbwffqfxfffxf\n" +
            "16-17 h: hvhhhhhhhhhhhhhrt\n" +
            "2-3 k: krjkk\n" +
            "10-11 k: kkkkkkkkkkg\n" +
            "17-20 d: dmfpddzdlddtvdddwdtk\n" +
            "3-5 m: tdwmmmmj\n" +
            "4-6 b: ncdbbpgxrg\n" +
            "8-13 d: bdfddglkdddgqwdfczs\n" +
            "2-5 s: tsszkhgf\n" +
            "2-3 k: zbkt\n" +
            "5-9 k: qqwmdqkzkldhpjql\n" +
            "4-6 p: bpjfhrpd\n" +
            "10-11 r: rrrxrrrrwhrrrr\n" +
            "6-9 n: nnxnwnnnbl\n" +
            "4-6 k: kmgpkkjd\n" +
            "4-5 v: vvdgv\n" +
            "3-4 h: jhhh\n" +
            "5-14 n: gnsnnnlvbzcsjjwqj\n" +
            "14-17 f: qfqffffqffnlwcffz\n" +
            "11-12 j: mchrqljrjhjjhjvmjwb\n" +
            "1-4 k: kkkkk\n" +
            "13-14 q: qqqqqqqqxqqqqlqq\n" +
            "1-3 k: cmkrdptlkxlkh\n" +
            "7-9 m: mmmmmmmmmm\n" +
            "4-10 b: brbxqbbblb\n" +
            "3-4 f: fqdff\n" +
            "3-4 r: rqrpzrr\n" +
            "6-7 n: cknndnngpnnn\n" +
            "2-6 b: pkbbbbb\n" +
            "3-9 s: lssssssjswzss\n" +
            "1-6 m: kmmmmmmmmmm\n" +
            "1-4 n: nnnnnn\n" +
            "3-4 p: pppqp\n" +
            "7-16 s: ssnslsmshfsvstxsprw\n" +
            "1-5 x: nxxxxxx\n" +
            "2-4 q: qcqqhq\n" +
            "4-5 r: rrprz\n" +
            "2-5 q: kqqqqqq\n" +
            "6-7 m: nggpmcm\n" +
            "4-9 r: rrrrrrrrr\n" +
            "3-6 j: zqjpzkkpspsjs\n" +
            "1-4 h: hhhs\n" +
            "4-8 l: wlqgklsl\n" +
            "6-7 f: zxfwcpf\n" +
            "5-17 g: cgvfqmggggqggggzgw\n" +
            "2-13 m: mpsmmmmmmmmmmmm\n" +
            "8-12 b: bdbbblbbbbxkbmb\n" +
            "17-18 z: zzzzzzzzzzzzzzzzjz\n" +
            "6-11 h: dlkhchqxthn\n" +
            "1-6 x: lxxxxxsxdxdhxxfj\n" +
            "3-4 m: mmpm\n" +
            "4-8 l: ncphmhtldmrtvslrbt\n" +
            "14-15 c: ncgjthcdvgjcwcjz\n" +
            "4-5 s: bsjsssbt\n" +
            "2-5 j: psjvjzbghz\n" +
            "11-12 b: bbbbbbbbbbbbl\n" +
            "6-7 b: bbbbbbb\n" +
            "6-7 k: kkkkkkps\n" +
            "9-10 w: wwwcrxcwwwwwwf\n" +
            "1-3 k: rkkk\n" +
            "4-5 q: dqxcq\n" +
            "2-14 v: vhhtvgwvdhvmqvmsp\n" +
            "2-3 c: nbzrfvv\n" +
            "5-9 h: hhkvmrxhsf\n" +
            "3-5 v: bdlgvcqftvvx\n" +
            "8-9 p: ppppppppw\n" +
            "4-6 f: dfkfdf\n" +
            "7-8 m: mnnmmqwmmzjfb\n" +
            "11-17 w: wgwwwwwwwwwwwwjbwwww\n" +
            "1-5 q: ccbwhgqszgnqtf\n" +
            "1-6 d: dkxxddd\n" +
            "5-10 c: ccccrcckccccc\n" +
            "10-13 x: rxcxxxxxhxcxkxxx\n" +
            "2-6 p: pppppfp\n" +
            "4-5 k: mkjnkmtkkpk\n" +
            "7-14 f: ffffffkwfffhpf\n" +
            "8-9 h: hhhhhhhwwhhhh\n" +
            "3-4 r: rrrrr\n" +
            "3-4 t: swptmltp\n" +
            "7-10 l: lmllgllwll\n" +
            "6-13 q: zqnrkqpqcdfnqvdnlrqq\n" +
            "2-3 k: ccvmrkxl\n" +
            "11-15 l: llllllllllllllpll\n" +
            "11-18 v: vvvgvvvvvtmvrvvvsqv\n" +
            "11-14 t: dshqbfvbdttqcx\n" +
            "7-8 n: wghnnnwnnnmvnn\n" +
            "4-7 b: bpxcbffcsr\n" +
            "6-10 l: rnlnwlmvtl\n" +
            "17-20 j: jjvjjjjjjsjjjjjtmjjz\n" +
            "5-8 g: mvcfkrfcgppfjv\n" +
            "3-11 f: crzfpxmtlkwwnnfrd\n" +
            "4-6 v: vvvvmsvd\n" +
            "3-7 d: dddddddd\n" +
            "10-11 m: mmmmmmmkmgmm\n" +
            "5-10 s: jgsssgsssqsh\n" +
            "12-18 g: fbggtqvjggxmgggjkg\n" +
            "10-11 v: nfclzhbnphxx\n" +
            "2-10 m: ntqmdkhrrj\n" +
            "4-7 g: ggxtmdggmghgc\n" +
            "8-11 g: rggggxttqggg\n" +
            "7-9 t: tthsjppttftt\n" +
            "15-16 v: vvvvvvvvvvvvvvvh\n" +
            "2-5 g: sgcgr\n" +
            "5-7 f: fxffjffffp\n" +
            "10-15 r: rrrrrrdrrrrrjrr\n" +
            "13-16 p: ppppppbppppppwpmppp\n" +
            "5-11 z: zbmxftzzzzmz\n" +
            "11-13 k: jkkxkkkkvkwkkkkvk\n" +
            "6-7 n: nnntnnz\n" +
            "8-11 j: gjjjjnjkdjqpjtj\n" +
            "2-4 x: xxxjj\n" +
            "2-13 r: rgnrlpwrbrrxvrrrrzw\n" +
            "5-6 p: pppppp\n" +
            "14-16 n: pcnnxqnglnnznngn\n" +
            "1-2 f: fffffx\n" +
            "4-5 d: ddpvcdv\n" +
            "2-3 n: kfnn\n" +
            "4-6 q: qbhbcwmhph\n" +
            "5-6 p: pnbccxp\n" +
            "5-9 v: vvvvvvvvmv\n" +
            "2-4 x: rjsv\n" +
            "9-16 x: xxxxxxxxmxxxxxxnx\n" +
            "2-5 j: jdjbjjjjj\n" +
            "6-12 t: tttgtttltbtnhrtgk\n" +
            "7-10 v: vvvvvvvvvsv\n" +
            "4-7 h: zmlhhpljhjjhqfh\n" +
            "8-9 m: mmmxmsmkmmmm\n" +
            "10-11 z: zzzzzzzzztwz\n" +
            "6-11 x: xxxxxxxxxxhxxxxxxx\n" +
            "1-13 g: gggfgggggggggggggz\n" +
            "14-15 f: frjzssdfnnzflffpsqfj\n" +
            "10-18 f: fffffffffffffffffff\n" +
            "3-4 s: ssmg\n" +
            "13-14 t: ttttttttttttgt\n" +
            "6-7 l: lllscll\n" +
            "14-16 r: tbbnrgdkdrrsdrnrjnb\n" +
            "11-12 k: lkkkkkqkkkkclkkqkk\n" +
            "2-4 n: hnfnn\n" +
            "4-5 n: nsnptgcccnrtc\n" +
            "9-10 z: zzzzzzzzzrz\n" +
            "7-8 m: pmcgtmmmmmxmvm\n" +
            "6-9 x: xxxxfxxxq\n" +
            "2-4 w: wwws\n" +
            "9-17 h: hbhhcvhrhctvhhhhx\n" +
            "2-11 k: qfnkfhlbfkshtqvcnk\n" +
            "5-9 k: kkkkkkkkbkkkkklkk\n" +
            "3-5 v: pgsjv\n" +
            "10-14 n: nnnnnznnnnnnnknr\n" +
            "6-8 k: ppkhkkgkjkqjkkhzkbv\n" +
            "1-2 f: pfcm\n" +
            "10-11 g: gggggwgggbgg\n" +
            "3-4 f: fffsjqff\n" +
            "7-13 x: kxwpsxxwqkxtx\n" +
            "3-13 k: klxrstnsxxvmk\n" +
            "3-6 w: dwrwgw\n" +
            "1-3 q: qqqq\n" +
            "4-7 s: pdsdmsssm\n" +
            "2-9 d: dtzdfddmcbtddjddc\n" +
            "4-5 j: jjhjjj\n" +
            "1-5 l: ldjll\n" +
            "7-11 m: mmwmmlmmmmmmm\n" +
            "9-11 b: bklmbbbbbdmfb\n" +
            "4-9 b: bbbbbbbbbbb\n" +
            "10-14 h: jhgchkhkhhhhhqhh\n" +
            "5-6 g: lhqrggfngdkrdthzlvxg\n" +
            "3-4 z: zzzzzzzz\n" +
            "2-6 z: lptzfpx\n" +
            "1-4 m: msjscmmmcmpcj\n" +
            "6-7 k: xsklqkq\n" +
            "8-16 m: mmmmmmmmmmmmmmmmmm\n" +
            "1-13 k: kjzbztnmnqkckcgkt\n" +
            "15-17 d: ddmckddddkfqdmddn\n" +
            "4-7 t: tzttvbtxltst\n" +
            "2-12 t: ntkdzntftxnjl\n" +
            "3-5 t: tttttt\n" +
            "7-10 t: ttfgtlfhftzkft\n" +
            "1-3 z: bzbzz\n" +
            "4-5 q: wqkqp\n" +
            "13-14 s: mssssssscssssvcxs\n" +
            "1-11 t: ttttttttxts\n" +
            "6-8 x: xxxxsxxxxsf\n" +
            "1-3 g: cxngg\n" +
            "12-14 h: hvhbhhnhhhhhhhh\n" +
            "1-5 q: qqqqqq\n" +
            "4-8 n: nnhnkzzrbgwtbvnprnjx\n" +
            "2-5 t: qrlttrdf\n" +
            "5-6 h: hhhhhlhhh\n" +
            "1-12 w: wwwwwwfgqwggwxwfwbw\n" +
            "6-10 p: pppppppppcppp\n" +
            "12-13 k: klpvkmrlnkfpmv\n" +
            "2-7 n: nnpswzxxhd\n" +
            "4-6 k: pnkgkqrhg\n" +
            "7-9 g: ggggzgqgngm\n" +
            "9-12 d: ddkddddddpdd\n" +
            "4-9 l: lhhlxcsqlkxxsbj\n" +
            "9-16 c: ccdcckrccchcccpccs\n" +
            "5-11 l: jshrlcrlkxqp\n" +
            "4-6 c: cwcvcccctcc\n" +
            "6-8 d: dsbmlddlqc\n" +
            "4-6 r: frrrhsb\n" +
            "1-2 f: frhhfjgffwnnf\n" +
            "5-13 b: bbbbbbbbbbbbbbbbb\n" +
            "5-13 g: jnxbjmfbgmmbg\n" +
            "1-9 g: gkggrbggg\n" +
            "1-9 z: zzzzzzzzzzz\n" +
            "15-16 k: kkkkkkkkkkkkkkks\n" +
            "3-4 b: bttm\n" +
            "7-8 k: kkkkkkkt\n" +
            "13-14 f: ffffsffffffffj\n" +
            "8-9 q: dqqqqqqwfqqbq\n" +
            "4-5 m: mmfvm\n" +
            "4-10 z: hzjzprfqtzfzlcdpvm\n" +
            "19-20 x: xxxxxxxxxxxzxxxxxxxc\n" +
            "10-11 l: lzllldlllhlllcpll\n" +
            "9-15 l: lflllblllllqllhl\n" +
            "6-9 c: ccccczccxvckck\n" +
            "7-14 w: xjchwqvkfgswpwpskc\n" +
            "3-6 v: vvvxtb\n" +
            "3-5 f: ffksvqx\n" +
            "10-12 m: nxztknmwgmfgq\n" +
            "4-7 n: nbcwzbvhgnnn\n" +
            "3-4 d: pdhdgwdd\n" +
            "10-13 l: ltmwlllxlltclqpllp\n" +
            "16-20 t: tttttttttttttttttttt\n" +
            "6-7 z: gflqpzzzpx\n" +
            "1-6 x: fxtmtlxgxl\n" +
            "2-3 r: rsrr\n" +
            "2-16 p: tpsthmqblbjdvxfspm\n" +
            "13-15 c: ccccccccccccccc\n" +
            "8-9 f: fffkfxfgfff\n" +
            "1-6 f: fzfffjf\n" +
            "5-6 d: dddcdrd\n" +
            "3-5 f: fffffff\n" +
            "5-6 h: gchlpkxhshhh\n" +
            "2-3 n: rnvx\n" +
            "1-3 d: dmfp\n" +
            "7-8 g: ggzggjwgkg\n" +
            "8-13 n: cndnnknvpnvnnn\n" +
            "2-4 z: xztz\n" +
            "2-3 h: hhzzm\n" +
            "4-5 c: ccccckzdqcw\n" +
            "5-9 w: qqwwwwvsw\n" +
            "1-2 g: ggmgggjg\n" +
            "6-7 g: bggxggkgsmgg\n" +
            "4-7 j: zrjgsvj\n" +
            "4-6 g: vgccgdc\n" +
            "1-11 m: cnmbjlmhlqx\n" +
            "8-12 m: mmmmmbmmmmgmsmmm\n" +
            "14-15 n: nwpnnnnnnnnnnnnnpn\n" +
            "14-18 k: tkkkkpkkpkkkkkxhkj\n" +
            "3-5 m: mpmmnmd\n" +
            "12-13 m: qmmmmmmmmmmmxmm\n" +
            "6-8 b: cbbbbkbb\n" +
            "7-8 m: mmmmmmtm\n" +
            "2-7 s: ntbjsswshs\n" +
            "2-3 r: btrgr\n" +
            "15-16 h: vgxdgxjvhzdbhjhhj\n" +
            "15-16 j: jjbjjjjjpqjjjjjj\n" +
            "2-4 r: rrrr\n" +
            "1-9 n: nntshwzsf\n" +
            "2-4 n: nnnpnjcc\n" +
            "3-4 p: hrzpsp\n" +
            "7-8 l: lllnlbqm\n" +
            "1-9 d: sddddddddd\n" +
            "2-3 s: scssswssq\n" +
            "2-5 p: zpvwp\n" +
            "16-19 z: zzzzzzzzfrzzzzzszmz\n" +
            "5-6 g: gtgkgggzgr\n" +
            "4-7 x: bclxbtq\n" +
            "11-12 k: kkkkkkkkkkdk\n" +
            "9-18 x: bxlqxvxxxxxxxxxcvmc\n" +
            "8-18 g: dgpgfgngjmqgqgqpnm\n" +
            "4-10 f: fffsfffffwfff\n" +
            "1-4 f: dfcztnztghj\n" +
            "7-10 t: tttpttkttjtt\n" +
            "3-4 h: vfhhhhv\n" +
            "7-9 s: wkjsslxdss\n" +
            "5-14 z: zzzzzzzzprzzzfzzcwzz\n" +
            "1-3 v: vpvrvcvvdkmm\n" +
            "5-9 c: bcbcccccmcchrgz\n" +
            "7-12 f: ffqfvffkfrztjdfcff\n" +
            "6-7 n: crmdnmvmnnnnnqnnnzn\n" +
            "9-12 t: tttsqtttpttrtttlrt\n" +
            "2-3 n: jnxpgngtgmx\n" +
            "8-10 p: pxpsppzvpppppp\n" +
            "4-5 x: nkbvx\n" +
            "1-3 w: nrlj\n" +
            "1-2 b: bdhs\n" +
            "5-11 q: qqqqbqqqqqqqqq\n" +
            "2-4 n: nnlmmzhtnknb\n" +
            "4-16 h: xhhhhchhhhhhghhphhs\n" +
            "6-11 t: tttzqtbttttt\n" +
            "10-11 q: jqqqrqqpqsnq\n" +
            "13-14 f: ffhffffkffffff\n" +
            "10-12 d: dddddddkdrddd\n" +
            "12-13 h: qghhdvthxqhhh\n" +
            "1-4 b: bnvsbb\n" +
            "6-11 q: xqnfqqqqvqfqvqqqh\n" +
            "3-8 k: skskkkkvkk\n" +
            "4-6 b: bbbbbm\n" +
            "6-9 v: fvthvvvvzhvv\n" +
            "5-9 w: wwwwwwrwgw\n" +
            "3-19 c: vlpkjhtcvbktwwrcmnc\n" +
            "10-13 r: zrrrrrgwrrrsrrrcvr\n" +
            "5-16 n: svcqnnvkmjhbgjxh\n" +
            "4-15 n: nnnknnnhnnnnnnnnnn\n" +
            "9-13 q: fqxlqsqlqgxkqvrfqgb\n" +
            "15-16 z: zzzzzzzzzzzzzzhdzz\n" +
            "2-18 j: pjrkwwdbsfbbncjkpz\n" +
            "11-12 z: zzzzzzzzzzzm\n" +
            "2-4 h: kpfj\n" +
            "5-17 h: whwdzvthhhhhhhhhhhh\n" +
            "5-7 r: rrcqvnsjrcvrwrfrp\n" +
            "5-7 w: wwrwwwww\n" +
            "1-3 l: llhl\n" +
            "12-16 r: bhlqqxszwnnstrff\n" +
            "3-5 f: pxdrf\n" +
            "5-8 x: hcjxszxxcxxxxx\n" +
            "3-4 q: qqqlc\n" +
            "4-5 n: sfnhn\n" +
            "3-5 n: nnmnnx\n" +
            "4-11 g: gkmnglkjxdn\n" +
            "7-10 r: rrrbqqrrgbrrmp\n" +
            "1-6 t: ttncttttzbtcst\n" +
            "16-19 h: hhhpgcthnhdrtcbhvjh\n" +
            "4-6 c: ccpcldcc\n" +
            "11-12 s: sbvzssshsnvl\n" +
            "8-17 w: scwwpwwwwwwtvwwwwwh\n" +
            "8-9 x: xxxxxxxxk\n" +
            "12-13 g: ggtbxqgggzxcpshgg\n" +
            "4-12 l: prllqnlgzsqxlvwbj\n" +
            "8-9 d: dddddddngd\n" +
            "3-6 f: rfffkfqf\n" +
            "12-16 g: zfvpgsmmhtprpcrgzkww\n" +
            "12-13 q: qqqqtqqqqqqxxq\n" +
            "4-8 d: dpzddfddhvjspzpn\n" +
            "2-5 n: kjmbgf\n" +
            "1-16 x: xlxcxxxxpxxqfxxlxrx\n" +
            "4-7 b: cvbrbhlsbzc\n" +
            "1-4 f: hffpff\n" +
            "4-6 f: fffnfmf\n" +
            "10-11 s: sssssssmsfsh\n" +
            "1-4 q: qpzdqqqqcqtqqqqq\n" +
            "7-8 s: sdhjmdvwtssv\n" +
            "13-14 t: tttctgttttttttttx\n" +
            "4-12 h: zhxlbhhhhhzch\n" +
            "6-10 p: ppdpptpxkpppd\n" +
            "2-6 s: pslhftrg\n" +
            "2-5 g: stgfgsq\n" +
            "3-4 b: bbxbw\n" +
            "5-6 s: qjdmshssqjpksmv\n" +
            "17-18 q: qqqmknmrlqqpkqtlqc\n" +
            "16-17 c: cccccdcccccdcccdccc\n" +
            "2-4 n: nvnvd\n" +
            "7-8 d: dddddddd\n" +
            "4-14 d: mdcqlgcrjdrvfd\n" +
            "6-9 m: mpmmfmmmvm\n" +
            "9-17 v: vvvvvvvvvvvvvvvvvv\n" +
            "2-3 r: rrrj\n" +
            "10-13 s: sjrssssdftsssss\n" +
            "12-16 j: bjznjjjjwjgxjjqj\n" +
            "8-9 t: dttttttcttttttf\n" +
            "1-5 n: nnnnnn\n" +
            "1-7 p: ptdpsggktwjkpzpp\n" +
            "1-5 w: rwpwwwqww\n" +
            "11-12 k: kxrkkrnnlgkkz\n" +
            "3-5 p: ppqppp\n" +
            "1-2 l: jkrmtrnflxhj\n" +
            "9-11 x: pqxxxvmxqxx\n" +
            "14-17 f: wftqlzbvmhnlfjbvf\n" +
            "2-5 x: xxxxj\n" +
            "3-13 m: zjmmxcbcbksmntxghsm\n" +
            "1-8 v: nvvvvvvjvvg\n" +
            "3-4 b: bblb\n" +
            "1-3 p: qppmwvhmgmkcspdml\n" +
            "3-4 n: nnntnn\n" +
            "2-3 p: nrppvr\n" +
            "10-11 r: crrrrrrrrrrr\n" +
            "4-5 p: jqpkm\n" +
            "12-14 k: kkjklkkhkrkkkbkkkkk\n" +
            "3-13 l: lqfjldlxflnvrlcdmhll\n" +
            "9-13 c: cxsccbqkhccccxcjcp\n" +
            "5-6 c: cvcsccp\n" +
            "13-14 d: dddddddddddddjd\n" +
            "1-5 d: cmbdxnxndpct\n" +
            "3-4 l: lllk\n" +
            "5-6 b: bbbbdb\n" +
            "5-6 v: kczqvvvv\n" +
            "4-13 s: sszsbksgtssbdmsls\n" +
            "2-13 q: kqxqrccgfhwcq\n" +
            "4-12 t: ttttlttttttlk\n" +
            "9-10 j: jjjjcjjjjgjjjjj\n" +
            "14-16 h: hhhhhhhhhhhhhhhh\n" +
            "10-11 z: zzzzzzzzzzz\n" +
            "1-5 x: xxnxs\n" +
            "2-6 h: hwshhhzhhzhsdhxh\n" +
            "12-14 x: xsxxxxxxxxxtkxx\n" +
            "3-9 f: fvffvfxxf\n" +
            "14-15 l: llwllfnlllrjxhlx\n" +
            "7-8 g: ggggbgjt\n" +
            "1-3 w: wwcw\n" +
            "5-11 p: pppwqpbpppppppp\n" +
            "14-18 v: vvvvvvvvvvvvvvvvvvv\n" +
            "5-6 j: gjjjqpjj\n" +
            "5-8 n: nqtxngdznfwrjxtx\n" +
            "2-3 h: hchzhk\n" +
            "2-4 z: vtzz\n" +
            "1-4 q: mqqnqq\n" +
            "3-5 g: gggggggg\n" +
            "5-7 v: vnvvvvv\n" +
            "1-3 h: hlcsjhs\n" +
            "8-19 s: stsssspqwsssssssssss\n" +
            "1-3 f: nffn\n" +
            "15-17 d: dddddddddddddddddd\n" +
            "2-4 x: gxhl\n" +
            "11-12 n: nnnnnnnnknnjwnn\n" +
            "4-6 w: wwwkww\n" +
            "10-17 p: ppwppzpppvqppszbxp\n" +
            "11-14 z: zzzhszzfzzlxcz\n" +
            "3-10 d: ndnddmwdsnpdkbn\n" +
            "7-9 f: ffffffwtf\n" +
            "9-11 l: lhndlllllljmqccll\n" +
            "1-2 r: jrrrrrrrr\n" +
            "2-3 b: bbbbn\n" +
            "1-4 h: hhhhh\n" +
            "4-8 s: gsmsmtrs\n" +
            "1-3 s: ksssss\n" +
            "13-14 k: kkkkskkkkkkkkxkkkk\n" +
            "4-7 v: tdgsvvjvvqvvvn\n" +
            "6-11 r: dqkpngrmzrrlt\n" +
            "13-14 k: kkkgkkkkgkkkkkkh\n" +
            "2-6 x: xxxxjllxsx\n" +
            "9-12 v: vvvvvvvvsvvv\n" +
            "12-14 z: zzzzzpzzzzzvzcz\n" +
            "14-15 w: wwwwwvwwwwwwwwpw\n" +
            "3-4 k: kjkkwkk\n" +
            "2-8 m: hhtmwxgm\n" +
            "5-13 z: zpzzwzzzzfwzdznzmwzf\n" +
            "4-6 x: xfxxxg\n" +
            "6-9 p: smjdwprpzh\n" +
            "5-10 f: nfxffpffffffpf\n" +
            "13-14 h: phhhhhhhwtrhjhfhhhh\n" +
            "4-12 l: nbrstqwkwgclcbznzlfj\n" +
            "2-4 j: jvjvjjjmj\n" +
            "2-3 p: pxxp\n" +
            "4-5 g: gggngg\n" +
            "11-13 d: gddddqddzdzdddh\n" +
            "4-6 t: bdltkmtttcwctm\n" +
            "7-11 f: bxwxmhftfbm\n" +
            "12-13 g: gpggwghghcgghgggkpgg\n" +
            "6-7 w: wwwwprr\n" +
            "2-12 l: lllmxrnlgllvlwltcl\n" +
            "1-4 g: grgk\n" +
            "5-9 k: lxkhkklkbkdqlkk\n" +
            "4-7 r: pjgrzzrrgpxnckxzrcxc\n" +
            "4-5 m: mmmmm\n" +
            "7-17 v: sbtvbpgbnqbfswdhbv\n" +
            "2-3 w: wtwx\n" +
            "3-5 v: lvdhvb\n" +
            "7-10 s: szssjsshdvs\n" +
            "9-10 p: ptfpsfpjpnvppxpghpp\n" +
            "15-17 m: mmmmmmmmmmxmmmqldmrm\n" +
            "18-19 z: zzzzzzzzzzzzztzzzzk\n" +
            "5-7 f: flfqfffvffn\n" +
            "4-6 x: sxrqkl\n" +
            "1-2 b: kzbb\n" +
            "2-9 c: cccccccbjjv\n" +
            "16-17 p: pvpfppppppppppppwp\n" +
            "9-16 h: hshhhtjhthhhwhkh\n" +
            "2-10 b: fmwfbcdwvbj\n" +
            "8-10 j: jjjjjjjrjjj\n" +
            "1-7 x: xtxzjwdxmcjdh\n" +
            "4-5 j: jjjrjj\n" +
            "3-7 f: ffvfffnf\n" +
            "11-13 z: dlchjrjjrlzzz\n" +
            "2-8 s: ssssssssss\n" +
            "4-5 k: bfvjvgqkzkwbhk\n" +
            "2-5 b: zkkcnrrglcxfk\n" +
            "17-18 m: lmmmmmmmmmmmmmmmgh\n" +
            "7-9 p: tdppkcpnkpkpf\n" +
            "10-12 t: ttgqmntbtptg\n" +
            "2-5 m: fmkhm\n" +
            "10-11 g: gggdxggdggxg\n" +
            "6-12 j: jgwjjjjjxjvjjqdjg\n" +
            "7-16 z: zzzzzzzzzzzzzzzzzzz\n" +
            "4-6 b: nsrtbb\n" +
            "2-5 j: kjxjtrl\n" +
            "3-6 b: bhtxxhjbxbbb\n" +
            "3-12 q: npnlkbqfgpxqjzdfjn\n" +
            "5-7 v: vbvvsgv\n" +
            "2-9 h: mhhhhhhhh\n" +
            "11-13 n: nnnnnnnnnnnnhn\n" +
            "5-6 n: nncnnl\n" +
            "3-4 h: phxhh\n" +
            "6-8 w: wwwwnwwwglwgw\n" +
            "5-6 j: qjwjjj\n" +
            "9-11 h: hhhhhhhhhhg\n" +
            "4-5 b: chbdb\n" +
            "5-6 l: lllljl\n" +
            "12-13 q: qqlqqqqqqqqgq\n" +
            "2-5 j: jkwlt\n" +
            "4-12 w: gmgtvwfwcwwwb\n" +
            "2-3 m: qmvdv\n" +
            "2-7 k: hkkmsspkrm\n" +
            "3-7 k: tlklhkwk\n" +
            "3-5 c: chgzcccd\n" +
            "9-19 x: xxxxxxxxxxxxxxxxxxqx\n" +
            "3-4 b: bbxbbz\n" +
            "1-3 f: fhhf\n" +
            "4-5 d: fddhp\n" +
            "1-3 j: jjnj\n" +
            "8-9 n: nnnnnnnnn\n" +
            "3-4 c: cjct\n" +
            "10-11 m: mmmmmmmmmmh\n" +
            "1-2 x: xbxxx\n" +
            "12-14 j: vtkjdjjjhgpjjjgj\n" +
            "5-6 n: rldnpnnlxnbjmgnxncv\n" +
            "7-8 f: pnrcpmgffzjffffrxf\n" +
            "5-9 n: nffdnnnnqnnm\n" +
            "10-18 s: sssssvsskxssssrsbsss\n" +
            "10-11 k: kkkkkkkkkkkk\n" +
            "4-5 x: xxxlgxxxx\n" +
            "4-5 s: ssksgsssss\n" +
            "4-5 b: bbbbkb\n" +
            "1-3 b: bbbxb\n" +
            "1-4 t: vttthjtttrs\n" +
            "7-9 r: rjcfrhrqmrrrrrr\n" +
            "1-4 f: kffcffff\n" +
            "14-15 d: ddxmmdddddtdddv\n" +
            "6-8 h: hfhhvhvq\n" +
            "15-19 q: qcqqqqqqqqqqqqhqqjsq\n" +
            "2-4 n: cnwn\n" +
            "3-4 b: btbn\n" +
            "4-5 p: sncdvppkphpp\n" +
            "14-16 h: zqbhrnhhvlhgxhhw\n" +
            "5-7 z: zjzctzfzl\n" +
            "4-10 m: gmpmmmrqmqcm\n" +
            "3-4 n: nnnnnnn\n" +
            "7-9 k: tdqwklhlwncdz\n" +
            "7-10 d: hmddhvnddznddd\n" +
            "2-5 q: sqpjm\n" +
            "2-4 p: zpwpkppvp\n" +
            "3-4 g: gxggggqgg\n" +
            "5-14 p: vzpppprdfzbkntdd\n" +
            "4-8 m: vldmnlpmmsdbz\n" +
            "3-4 q: qqlmqqqqq\n" +
            "3-16 n: pztmwhjmznjqckmnxrr\n" +
            "8-11 b: bvhbsbnbhbmbfjbqbr\n" +
            "5-7 q: wqqqqqgq\n" +
            "4-14 n: nnnrfsnndncmnnmdw\n" +
            "3-12 c: ktcccvpzgkfqcc\n" +
            "8-10 s: mcwvgsdspsl\n" +
            "3-6 l: lllllv\n" +
            "1-3 q: fqmqq\n" +
            "14-15 z: zzzzzzzzzzzzzwz\n" +
            "5-11 z: zzmzbxzjzzzzp\n" +
            "12-13 w: wwwwshwwwwkwlwwwwww\n" +
            "15-18 r: rrrrrrrrrrrrrrrrrlr\n" +
            "6-8 x: fcgqdxbxwlgxh\n" +
            "10-11 c: ccccccccccfc\n" +
            "5-16 t: ttstjrttzbttjltktk\n" +
            "6-12 g: lgwgdfdzggggj\n" +
            "15-17 v: vvvvvvvvvjvvvvvhgv\n" +
            "1-5 n: cnnnnn\n" +
            "5-7 w: mwwwxww\n" +
            "9-12 w: wvwwwpwwwwwbvwwm\n" +
            "1-6 b: bbbbbbb\n" +
            "4-5 g: qggbrg\n" +
            "19-20 r: btvfzlvzmrzhxkclxkfr\n" +
            "9-11 j: mkmmvjjldqx\n" +
            "1-4 l: lqlgrlcqfll\n" +
            "13-15 z: czzrzzzzzhzzzzzzzz\n" +
            "7-9 h: hzghwhwhh\n" +
            "7-17 g: gggggglggggggggggg\n" +
            "2-4 r: rjfzr\n" +
            "5-6 n: nnnnsnbmn\n" +
            "2-8 k: vdqhfccdkjm\n" +
            "2-4 z: tszh\n" +
            "5-7 j: pjgtjwpr\n" +
            "4-8 g: gggggggggg\n" +
            "8-12 h: dnkgcqlhszwqpkzhgdp\n" +
            "1-4 n: pnnnnn\n" +
            "3-10 d: ddrdddlrnrchdfddd\n" +
            "4-5 h: thzdq\n" +
            "7-15 d: wkvnfwdhxgvdfjr\n" +
            "13-15 j: jpjjjjslgjjjbgjrjjj\n" +
            "11-12 n: nnntnnnntntnn\n" +
            "1-2 n: nnnnnn\n" +
            "7-11 s: sswssnssssfsn\n" +
            "3-4 x: xmxz\n" +
            "9-10 v: jvvvxvvvgvvt\n" +
            "5-7 c: cmccfgdc\n" +
            "2-5 q: jqdqq\n" +
            "17-20 x: wrdkznpjxcwjxqtnxpvx\n" +
            "4-6 c: mczcccc\n" +
            "11-13 b: crbbhxbbbbbfxbbbbx\n" +
            "16-19 f: fvffffqgfjffffpffqd\n" +
            "10-11 k: kkjkkkkkqckkk\n" +
            "2-6 r: rrsntpc\n" +
            "2-17 q: qcpzdqfbqqqqqqqqw\n" +
            "2-5 d: fvdpddbkq\n" +
            "1-8 q: dqqqfqzz\n" +
            "9-14 t: kkpbzspjgtzztft\n" +
            "1-2 v: gvvv\n" +
            "12-13 w: wkwwwwntwwwtwktmwwww\n" +
            "13-19 s: ssssssssxssskssssss\n" +
            "8-10 k: kkkkkkkbkxkk\n" +
            "8-9 q: qcqdjblnvqqqsqqqqq\n" +
            "10-13 r: rrrjrprrjrrrvr\n" +
            "4-6 k: kqkkmv\n" +
            "2-4 z: dkzb\n" +
            "2-3 b: wbbc\n" +
            "17-18 p: pppppgppppppppppxppp\n" +
            "5-14 v: vdvlvvjzvdvpvc\n" +
            "3-12 x: xnxxxtjxxkxxxxx\n" +
            "5-6 b: gqzbbvbbbb\n" +
            "6-10 k: kkhxqkkkkkcncxgkk\n" +
            "9-10 j: jjjjjjjjcsjj\n" +
            "4-9 t: wzttttxgthbfbbt\n" +
            "2-12 v: vzvvvkpfvprwmvxjgsvd\n" +
            "3-9 t: lttcmtrntxwjhhmqhnbc\n" +
            "7-11 m: dpmqpmdvkmlw\n" +
            "16-17 s: zssssswsstpssssjmsss\n" +
            "3-8 h: hhvhbhhhh\n" +
            "7-9 c: nccccnxcc\n" +
            "4-5 z: mzzzz\n" +
            "6-7 g: ggggggg\n" +
            "2-4 t: wqmtqzkln\n" +
            "4-6 r: rrcrfrg\n" +
            "2-4 n: ngndn\n" +
            "8-9 p: sjppxxgcn\n" +
            "5-6 j: wjjjmj\n" +
            "3-7 g: qskprfh\n" +
            "4-9 x: dxxxxxxqvqcxfdjzx\n" +
            "7-13 q: qqqttqqxmfqqlzqpqqq\n" +
            "8-11 g: gggggggpgggg\n" +
            "3-4 q: qqlx\n" +
            "1-3 q: qqtktrq\n" +
            "9-17 b: bbbbbbbbgbbbbbbbbbb\n" +
            "6-9 r: rrrbrzrrc\n" +
            "9-11 r: rrrrrrrrsrrr\n" +
            "3-9 d: lsvdztpddd\n" +
            "9-12 z: xzzzzzzgzzzcztzz\n" +
            "3-13 f: fkffdzbtdffpfgjffff\n" +
            "1-2 d: tddd\n" +
            "4-6 c: wsgfhccrwxfd\n" +
            "1-2 d: hdtnbxqdjnmsksm\n" +
            "6-9 r: rlrrmxdrrrr\n" +
            "8-9 c: cccccccmc\n" +
            "5-13 w: wtwzkwwwjwxdwwvgbwjg\n" +
            "7-8 t: ttkqgstt\n" +
            "5-11 f: fjfffgfffdlf\n" +
            "6-7 l: llllllcl\n" +
            "4-6 g: ggglggg\n" +
            "11-12 r: rrrrrrrrrrrx\n" +
            "3-4 r: rrrr\n" +
            "4-8 p: sbpppdrpppmplfq\n" +
            "2-3 k: kkghkzkrxwx\n" +
            "9-11 m: vwmmmdpxlczmwmmmmgmj\n" +
            "2-5 k: dpjrsxkhn\n" +
            "2-12 k: kkkkchsksjwbkkw\n" +
            "8-17 r: rrrrrrvrkrlrrrrtz\n" +
            "3-4 q: nrqq\n" +
            "6-7 j: crwjljtjxjjk\n" +
            "1-6 w: qwwwpwwwwt\n" +
            "8-9 v: vvvvvvvkv\n" +
            "5-6 b: bttbbbb\n" +
            "8-11 j: tjbpjjjjfdj\n" +
            "7-9 f: rfwfffnmvjwktfwfff\n" +
            "14-15 r: rrrrrrrrrrllrrr\n" +
            "12-14 s: sflzzssqlcmsdsn\n" +
            "12-14 n: nnnnnnnnnnnnnnwn\n" +
            "4-9 k: kkkckxkgz\n" +
            "5-6 r: rrdrrsrr\n" +
            "1-2 p: qplxp\n" +
            "4-16 c: ccccccczfwphcbcmc\n" +
            "2-3 z: bsrz\n" +
            "7-8 x: xxlhxxsxxxjctxx\n" +
            "2-4 k: kzkkkk\n" +
            "4-10 n: nnnrnnnnnnn\n" +
            "1-2 c: pzzfbl\n" +
            "1-2 q: spqqq\n" +
            "4-6 g: pgnvgwttgfg\n" +
            "10-12 f: fffffffffffff\n" +
            "7-8 f: fkrfffns\n" +
            "6-7 b: bbbbbbt\n" +
            "2-5 m: mmmmmmmmm\n" +
            "6-15 m: qxhmlmmxmmnmmmppmrtn\n" +
            "10-16 n: shknnnnqnnclnjnnn\n" +
            "2-10 d: ddxddddddddd\n" +
            "11-12 n: nnncnnnnnnpn\n" +
            "1-3 z: xzlz\n" +
            "1-4 s: mssss\n" +
            "1-7 p: bbppppppkgp\n" +
            "5-6 w: wwwwbq\n" +
            "4-6 g: ggpgggg\n" +
            "2-3 z: dzzz\n" +
            "15-17 q: qqqqqqqqqqqqqqqqtqqq\n" +
            "13-15 p: ppppzpppzpfpfpp\n" +
            "6-11 t: xlthtttttccbqtrvqqst\n" +
            "7-10 r: rrwrrrrrrx\n" +
            "10-11 z: zvzzwzzskzkzzzzqc\n" +
            "4-8 r: rrrxvrrsrw\n" +
            "9-12 j: jhzjjjjjjbjn\n" +
            "1-4 h: hhhzhh\n" +
            "5-11 r: mrrptkrtrqjsrr\n" +
            "13-14 l: dllllllllllllp\n" +
            "6-12 x: gxxxbgkqvwgh\n" +
            "5-8 s: ssfscsnt\n" +
            "8-9 c: chgcggccq\n" +
            "4-5 r: rrrrrr\n" +
            "8-9 f: fffpfffhfcf\n" +
            "2-3 x: xltcxkg\n" +
            "14-15 s: qssssssssdsssdjss\n" +
            "4-7 k: ckkcqkk\n" +
            "3-7 q: lrqpqbn\n" +
            "2-5 p: qvfpp\n" +
            "1-6 w: twwwwmwwqwww\n" +
            "4-7 k: wkkkcfkrkhxd\n" +
            "12-18 g: gggggggggggjgggggxg\n" +
            "3-4 c: jjtwmcgl\n" +
            "6-10 p: pppppppppp\n" +
            "4-6 w: fgwwwwwcbkw\n" +
            "1-5 l: blllll\n" +
            "3-4 t: nrtbtstxwt\n" +
            "1-10 d: dddjdddddddddqdbdd\n" +
            "1-3 h: xchh\n" +
            "3-7 p: wnhxrpp\n" +
            "11-13 v: vvvvxvvvvvvvvvvvvv\n" +
            "16-17 f: ffffftfffffffffff\n" +
            "1-9 m: mkmbjmpbr\n" +
            "3-5 x: xxxxx\n" +
            "9-10 f: ffffjvrfgfffff\n" +
            "4-5 d: ddddsdbdd\n" +
            "6-10 j: jjjjjjjmjqjjjj\n" +
            "4-10 q: lqqbqqqqqgqq\n" +
            "4-13 d: dddwdddddddddddddddd\n" +
            "3-5 t: gdtlxbtsnc\n" +
            "6-15 t: tfbjchtdhdvtfcfgtjtk\n" +
            "6-7 d: dddddddd\n" +
            "7-18 w: sgbbkwxgdxvwlhjfct\n" +
            "8-11 n: pbfnnnwntnnnn\n" +
            "1-15 j: jjjjjjjjjjjjjjj\n" +
            "3-12 b: zbbsdblxbqvbp\n" +
            "5-6 p: zxpjtp\n" +
            "4-7 k: kgdhskkkklkmfgnkrtm\n" +
            "9-10 s: sssshssfsjpxssvc\n" +
            "2-4 w: whlhw\n" +
            "11-16 z: zzbzzzzzzztzzzzsz\n" +
            "8-10 x: txmxxvxpxxxxxmmlrnj\n" +
            "7-8 r: zrrrrrrs\n" +
            "4-9 v: vvvbbvvvvb\n" +
            "10-11 z: zxzzzzzxmzz\n" +
            "7-14 h: hhvxcrhhkhhhtrbwtghx\n" +
            "9-10 h: hhfkhchhhpwsphhjdhhc\n" +
            "3-5 q: qqqqtq\n" +
            "4-5 f: ffmftff\n" +
            "3-13 l: llwmlldllfjlt\n" +
            "2-3 b: bqkp\n" +
            "2-3 j: jjbj\n" +
            "6-11 r: rnwdrpjrrpxrwrr\n" +
            "9-11 q: pqlsqjqjqztsqvhmq\n" +
            "2-4 m: mccmm\n" +
            "6-8 f: kfffffffffj\n" +
            "13-14 l: xlllllllllllkkml\n" +
            "8-12 p: pppppvpppkpdppp\n" +
            "10-19 x: txnxxhxcxmxrdxfjkvx\n" +
            "8-9 x: xxxxxbxct\n" +
            "1-2 s: bsjssr\n" +
            "2-5 h: hcbhcl\n" +
            "11-12 c: dsdklbhrncccc\n" +
            "2-3 c: ccncccc\n" +
            "7-8 f: fffltfft\n" +
            "12-13 c: ccccccccjcccgc\n" +
            "2-9 r: nsrqvqtrrd\n" +
            "1-4 r: trrr\n" +
            "9-11 z: gzmlcrbbrsvz\n" +
            "7-11 t: thtbhtxprtcttttt\n" +
            "4-6 g: zxgtfb\n" +
            "7-8 d: dfkmhqrjsddqf\n" +
            "14-15 h: whhhxmrqhjhsvgshvvcx\n" +
            "2-3 t: ttxxprtpdtrrgn\n" +
            "9-11 t: ttttttttpttt\n" +
            "1-4 p: pnpp\n" +
            "2-4 f: fvfvf\n" +
            "14-15 x: xxxxxgxxxxxxxxl\n" +
            "6-10 n: hmdnlrpnkn\n" +
            "1-3 n: gtvnhdnjnn\n" +
            "14-15 d: mddddddddddddtld\n" +
            "12-16 z: zqzzzzztzcdwzzzz\n" +
            "2-3 f: mffjfj\n" +
            "10-13 l: mlrlvlmxlllkk\n" +
            "4-20 j: mvbxdjhxvtxmrnfjvlsr\n" +
            "5-15 m: zkchpzsgjgvxssmjpm\n" +
            "8-14 b: bbbbrbwbbjbbbzbb\n" +
            "4-17 v: vlvmvvvvvnwtvvvnvvhv\n" +
            "16-17 w: wwwwwwbtjwwwwwwwwww\n" +
            "7-9 x: sjhjrbxxbq\n" +
            "14-15 w: kwwwwwwwwwwwwwwwwww\n" +
            "12-13 w: wwwwwwwwwwwxxwwwwlw\n" +
            "2-5 m: mmmmsmmm\n" +
            "1-2 n: ndng\n" +
            "1-2 w: wpcmtlpwwnzrdzc\n" +
            "13-14 z: zzzzzzzzzzzzzvz\n" +
            "8-10 l: lllllllxlkl\n" +
            "8-9 s: ssssssssp\n" +
            "9-12 s: sdsssssvssss\n" +
            "2-3 g: ggxv\n" +
            "6-9 c: cccpcjccc\n" +
            "4-10 j: bmwjqhtmfzkwlsjrc\n" +
            "3-4 f: ffwff\n" +
            "7-12 c: qwrcrtcqczqdxc\n" +
            "3-4 p: vvpm\n" +
            "8-14 k: dkkgkkzkqkkkzwj\n" +
            "9-18 s: ssssssssxsssssssssss\n" +
            "12-15 g: gsggrgglggngggrglggt\n" +
            "3-6 w: wwwpch\n" +
            "3-7 p: ppppppkppp\n" +
            "5-6 n: nnnnnbn\n" +
            "8-11 m: nmlwmdcmmtmb\n" +
            "11-15 t: ttttttttttttttt\n" +
            "3-4 f: fffn\n" +
            "5-7 b: bbbbbbtb\n" +
            "17-20 l: lllllllnllllllllpllg\n" +
            "3-4 n: rnbs\n" +
            "10-18 h: hhhhphhhmnhhhnhhvhhh\n" +
            "4-5 h: hhmph\n" +
            "2-5 k: fndkkkksvbk\n" +
            "1-3 s: ssssss\n" +
            "3-16 k: kkkkkkkkkkkkkkkzk\n" +
            "5-9 t: ttzwssrltt\n" +
            "3-4 b: blmbgqphpnq\n" +
            "12-16 d: zdjcndpdjgbddcddd\n" +
            "15-17 b: ldjbbdxfwdgldfbfn\n" +
            "9-17 n: rhxsgngwnvdfdwtnntr\n" +
            "13-14 z: zzzpzzzzzzzzszz\n" +
            "2-3 s: sfssjssxssk\n" +
            "1-6 n: dwngnnrnnn\n" +
            "4-9 n: nnghfsvnnp\n" +
            "8-10 d: cxxdnmpdkh\n" +
            "8-9 p: pppllpprnppp\n" +
            "8-9 h: hhhqngfrhhhhhhh\n" +
            "13-17 d: ddddrnddddddbdddd\n" +
            "2-14 w: rptqzcsdvbjctwsfkwb\n" +
            "3-6 x: mhxxqx\n" +
            "4-6 k: kkktkkkck\n" +
            "2-4 f: fcffhkff\n" +
            "17-18 t: ttttttttttttttttjt\n" +
            "1-2 q: zcgfq\n" +
            "1-4 b: bbbjbbbbrb\n" +
            "5-6 g: ggggtx\n" +
            "5-12 q: qwqpqpmkhqqj\n" +
            "8-9 b: bbgbbbbxb\n" +
            "3-4 x: xxxxxb\n" +
            "4-5 n: ktskn\n" +
            "9-10 z: zlzdgmpzzz\n" +
            "9-12 j: bjjqjjjjgjjj\n" +
            "2-12 g: cqnrtxhkgzrmxfbp\n" +
            "2-6 q: qngktqqqw\n" +
            "1-2 z: nzfzlfdqk\n" +
            "3-10 m: jmrwmhwmmxdmmmm\n" +
            "7-9 z: ckzzdjjrzb\n" +
            "3-4 m: mmmg\n" +
            "5-16 l: llllflllllllllllll\n" +
            "10-20 h: rxxkbjnvjpvzqjhbhjhh\n" +
            "5-6 m: xkmmqv\n" +
            "1-3 x: xxxx\n" +
            "10-16 w: wdqwwhwwcwmcfwwh\n" +
            "7-11 m: mmmmmtmmmmmmm\n" +
            "2-7 z: frrzczznn\n" +
            "3-7 k: kbkkrgkgzmtlkwkljcq\n" +
            "10-13 l: clgwvjbxfwrll\n" +
            "6-7 t: tdcthtt\n" +
            "2-6 k: hknhpk\n" +
            "5-13 p: pppptppppppppp\n" +
            "8-14 j: jjjpjqxhjbjjjjjj\n" +
            "5-6 z: zzzkzzpzz\n" +
            "2-5 m: mwpfmrnscgpbbbwt\n" +
            "3-4 t: tpmt\n" +
            "8-12 d: lbddddvdmddddzdddl\n" +
            "1-7 p: ppppppxpp\n" +
            "6-7 t: cttttpl\n" +
            "2-3 j: jhrj\n" +
            "11-12 j: cnbrzpcjghjj\n" +
            "8-9 w: wwwwwwwww\n" +
            "11-12 f: fffffgfffffcf\n" +
            "3-4 n: nnnh\n" +
            "4-8 h: dztmrvhhchhhh\n" +
            "13-18 l: llllllllllllfllllll\n" +
            "2-3 s: tzssns\n" +
            "4-6 p: ppppphprln\n" +
            "5-7 g: cjljggsgvlkgqlg\n" +
            "5-12 g: kkgxghvkrzwggvf\n" +
            "4-10 w: jwwznwkmrj\n" +
            "7-11 p: cpbhppcmgztfpbp\n" +
            "4-5 g: ghgcfz\n" +
            "2-3 w: nfwwqklwr\n" +
            "3-4 x: gxxh\n" +
            "16-19 c: gzhxgqzvclbrmfkclls\n" +
            "11-13 f: fffffffjffpffsffhffl\n" +
            "2-5 h: hqdmxxhbhhhhhghhhh\n" +
            "2-3 l: hllw\n" +
            "3-13 v: vvvzvzvgvxlzflvr\n" +
            "6-12 m: kmscmmnmdtxm\n" +
            "14-15 t: clhtqdcfdncdtbt\n" +
            "4-5 k: fbkkwxkrpxtkctjzhndk\n" +
            "6-11 g: zggggndgggsggg\n" +
            "7-10 n: mdnntkntnj\n" +
            "5-6 b: xlbbbbb\n" +
            "7-11 s: sssszssmsss\n" +
            "3-10 k: qkkkkkkrgkkkfhkrhk\n" +
            "14-20 p: qcdpppdnppjppgcptppq\n" +
            "2-3 n: wnknrjwtqcksmlw\n" +
            "7-10 n: jnztbnnzrw\n" +
            "9-10 j: jjjjjjjjjp\n" +
            "3-5 f: hbfnfjkmfpnfjfv\n" +
            "5-7 n: pckprbrnx\n" +
            "2-4 r: rbqr\n" +
            "1-11 q: qqqqqqqqqqzq\n" +
            "2-13 k: kkmqckkgqqntkmr\n" +
            "2-4 j: vjzjj\n" +
            "11-12 q: qqqqqqcqqqfpqr\n" +
            "2-10 x: dxhqtxtbkxnnpcrbtgp\n" +
            "6-10 h: wlhzdhcchhj\n" +
            "7-19 k: snktsqkmckmzfklbzkv\n" +
            "3-9 d: ddhdvzpdw\n" +
            "9-18 f: flpgfvffsffwfffgsk\n" +
            "14-17 t: tttttttxtttttttttt\n" +
            "7-14 l: wnpxlllqllvhkbhxlk\n" +
            "11-12 n: nnnnnnnnhnnx\n" +
            "8-12 r: fhrrrtrrrcwg\n" +
            "5-6 p: psptpx\n" +
            "3-4 x: xxxxx\n" +
            "12-15 b: bbbbbbbbbbbbbbqfb\n" +
            "3-4 f: ffsg\n" +
            "8-15 n: nnnnnmnnndnnnngnnnnn\n" +
            "4-9 t: ttfhtftwt\n" +
            "4-5 f: ffvff\n" +
            "4-18 s: jssjsssssssssssnsvms\n" +
            "2-5 z: tzzsz\n" +
            "9-17 g: nwpqgggbggjfgggmglhd\n" +
            "5-6 c: kccdbccc\n" +
            "3-4 r: rgrr\n" +
            "9-15 d: dqddhddngdddddnzd\n" +
            "4-12 c: zmlpclmdxsqc\n" +
            "6-8 q: fwkptqfqqxg\n" +
            "3-4 s: hznnsqdx\n" +
            "8-9 q: qqhqqqqczqq\n" +
            "7-8 z: nzzzzzzzzz\n" +
            "15-16 p: pppmpppppppppltdpp\n" +
            "8-14 h: hhhhhhhmhhhhhrhhhhhh\n" +
            "3-4 k: fwnchdkstg\n" +
            "10-17 h: kpcnnpljchcqbcsvbq\n" +
            "8-9 v: tzhcvbtzvtlm\n" +
            "12-16 l: fkjlmjdcllkpwxhxhnl\n" +
            "6-15 k: llfkkknskkbkkkbkkjkk\n" +
            "7-12 n: tnbjngwnnnlnvgj\n" +
            "16-19 r: gbtxrqmrrrrrrrwrflw\n" +
            "3-12 c: ccqcccccfccccccccc\n" +
            "14-15 z: zzvzzzzzzzzzznczz\n" +
            "5-6 d: qpddzd\n" +
            "4-7 m: mmmrmmmhtmcmpmm\n" +
            "15-18 g: lghrgggggwqgggxnmqwg\n" +
            "9-12 d: ddddjrddmddnd\n" +
            "6-15 t: tttttmttttttttqtttt\n" +
            "9-12 g: gbdgggnggcggpg\n" +
            "5-9 c: ccvshdqtcvcczl\n" +
            "9-10 v: xvvtfxrvxvvvvvtvbc\n" +
            "3-4 j: jjjjjjjnq\n" +
            "5-6 h: pkhzhh\n" +
            "5-6 g: gggggm\n" +
            "1-6 j: djjjjjj\n" +
            "4-5 c: xvfcfkfz\n" +
            "2-6 p: dpcjksgxtp\n" +
            "1-2 w: rrwwwdw\n" +
            "4-5 t: ngrttjftxttkrt\n" +
            "1-8 t: gchtttbtt\n" +
            "5-11 r: bhvgmszrpgrgwcdp\n" +
            "4-12 j: sjjjmzjjjjjpj\n" +
            "7-15 t: tslntctttxtkgtm\n" +
            "16-18 j: jwjwpjjjjzfjjjxvjjj\n" +
            "4-9 c: rbdpccfghwrn\n" +
            "1-8 k: kkkkkntkkcdqk\n" +
            "1-3 c: cctdcvcdqc\n" +
            "5-6 m: mmmmmm\n" +
            "6-10 w: lqwcqwqzkhcbwtgvzxb\n" +
            "3-4 h: hgxhjchhlpms\n" +
            "11-14 b: bkbxxdkrbzbswb\n" +
            "1-2 r: drcr\n" +
            "19-20 l: llllllllllllllllllll\n" +
            "2-7 g: fmggdgggx\n" +
            "11-14 z: zzzzzzvzzxbzzh\n" +
            "7-8 p: ppppppdx";
}