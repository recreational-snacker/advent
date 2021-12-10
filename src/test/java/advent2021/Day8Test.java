package advent2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Day8Test {

    private String zero;
    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;
    private String seven;
    private String eight;
    private String nine;

    @Test
    public void solution() {
        String[] split = input.split("\n");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            String[] outputValues = split[i].split(" \\| ")[1].split(" ");
            for (String s : outputValues) {
                if (checkLength(s)) {
                    count++;
                }
            }
        }
        System.out.println(count);

        Integer total = 0;
        for (int i = 0; i < split.length; i++) {
            String inputValues = split[i];
            Integer code = calcValues(inputValues);
            total += code;
        }
        System.out.println(total);
    }

    private boolean checkLength(String s) {
        if (s.length()==2 || s.length()==3 || s.length()==4 || s.length()==7) {
            return true;
        }
        return false;
    }

    private Integer calcValues (String s) {
        String[] inputValues = s.split(" \\| ")[0].split(" ");
        String[] outputValues = s.split(" \\| ")[1].split(" ");
        Map<String, Integer> inputValueMap = new HashMap<>();
        for (String inputValue : inputValues) {
            inputValueMap.put(inputValue, inputValue.length());
        }
        List<String> sixes = findKeysForValues(6, inputValueMap);
        one = findKeysForValues(2, inputValueMap).get(0);
        four = findKeysForValues(4, inputValueMap).get(0);
        seven = findKeysForValues(3, inputValueMap).get(0);
        eight = findKeysForValues(7, inputValueMap).get(0);

        Map<String, String> coords = new HashMap<>();
        coords.put("top", findTop(one, seven));
        coords.put("topRight", findTopRight(sixes, eight, one));
        coords.put("bottomRight", findBottomRight(coords.get("topRight"), one));
        coords.put("middle", findMiddle(one, four, sixes));
        coords.put("topLeft", findTopLeft(coords.get("middle"), one, four));
        for (String s1 : nine.split("")) {
            if (!s1.equals(coords.get("top")) && !s1.equals(coords.get("topRight")) && !s1.equals(coords.get("topLeft")) && !s1.equals(coords.get("middle")) && !s1.equals(coords.get("bottomRight"))) {
                coords.put("bottom", s1);
            }
        }
        for (String s1 : eight.split("")) {
            if (!s1.equals(coords.get("top")) && !s1.equals(coords.get("topRight")) && !s1.equals(coords.get("topLeft")) && !s1.equals(coords.get("middle")) && !s1.equals(coords.get("bottomRight")) && !s1.equals(coords.get("bottom"))) {
                coords.put("bottomLeft", s1);
            }
        }
        List<String> fives = findKeysForValues(5, inputValueMap);
        findTwoThreeAndFive(coords, fives);
        return findCode(outputValues, coords);
    }

    private Integer findCode(String[] outputValues, Map<String, String> coords) {
        StringBuilder sb = new StringBuilder();
        for (String outputValue : outputValues) {
            if (outputValue.length()==2) {
                sb.append("1");
            } else if (outputValue.length()==4) {
                sb.append("4");
            } else if (outputValue.length()==3) {
                sb.append("7");
            } else if (outputValue.length()==7) {
               sb.append("8");
            } else {
                sb.append(findVal(outputValue, coords));
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private String findVal(String s1, Map<String, String> coords) {
        if (s1.length()==5 && s1.contains(coords.get("top")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomLeft")) && s1.contains(coords.get("bottom"))) {
            return "2";
        }
        if (s1.length()==5 && s1.contains(coords.get("top")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
            return "3";
        }
        if (s1.length()==5 && s1.contains(coords.get("top")) && s1.contains(coords.get("topLeft")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
            return "5";
        }
        if (s1.length()==6 && s1.contains(coords.get("top")) && s1.contains(coords.get("topLeft")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottomLeft")) && s1.contains(coords.get("bottom"))) {
            return "6";
        }
        if (s1.length()==6 && s1.contains(coords.get("top")) && s1.contains(coords.get("topLeft")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
            return "9";
        }
        if (s1.length()==6 && s1.contains(coords.get("top")) && s1.contains(coords.get("topLeft")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("bottomLeft")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
            return "0";
        }
        return null;
    }

    private void findTwoThreeAndFive(Map<String, String> coords, List<String> fives) {
        for (String s1 : fives) {
            if (s1.contains(coords.get("top")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomLeft")) && s1.contains(coords.get("bottom"))) {
                two = s1;
            }
            if (s1.contains(coords.get("top")) && s1.contains(coords.get("topRight")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
                three = s1;
            }
            if (s1.contains(coords.get("top")) && s1.contains(coords.get("topLeft")) && s1.contains(coords.get("middle")) && s1.contains(coords.get("bottomRight")) && s1.contains(coords.get("bottom"))) {
                five = s1;
            }
        }

    }


    private String findTopLeft(String middle, String one, String four) {
        List<String> list = new ArrayList<>();
        for (String s : four.split("")) {
            if (!one.contains(s)) {
                list.add(s);
            }
        }
        for (String s : list) {
            if (!s.equals(middle)) {
                return s;
            }
        }
        return null;
    }

    private String findMiddle(String one, String four, List<String> sixes) {
        String middle = null;
        List<String> list = new ArrayList<>();
        for (String s : four.split("")) {
            if (!one.contains(s)) {
                list.add(s);
            }
        }
        for (String s : sixes) {
            if (!s.equals(six)) {
                for (String s1 : list) {
                    if (!s.contains(s1)) {
                        zero = s;
                        middle = s1;
                    }
                }
            }
        }
        for (String s : sixes) {
            if (!s.equals(six) && !s.equals(zero)) {
                nine = s;
            }
        }
        return middle;
    }

    private String findBottomRight(String topRight, String one) {
        for (String s : one.split("")) {
            if (!s.equals(topRight)) {
                return s;
            }
        }
        return null;
    }

    private String findTopRight(List<String> sixes, String eight, String one) {
        Map<String, String> map = new HashMap<>();
        for (String s : eight.split("")) {
            for (String six : sixes) {
                if (!six.contains(s)) {
                    map.put(six, s);
                }
            }
        }
        AtomicReference<String> topRight = new AtomicReference<>();
        map.forEach((k,v) -> {
            if (one.contains(v)) {
                topRight.set(v);
                six = k;
            }
        });
        return topRight.get();
    }

    private String findTop(String one, String seven) {
        for (String s : seven.split("")) {
            if (!one.contains(s)) {
                return s;
            }
        }
        return null;
    }

    private List<String> findKeysForValues(Integer val, Map<String, Integer> map) {
        List<String> keys = new ArrayList<>();
        map.forEach((k,v) -> {
            if (val.equals(v)) {
                keys.add(k);
            }
        });
        return keys;
    }

    private String smallSample = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf";

    private String sample = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe\n" +
            "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc\n" +
            "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg\n" +
            "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb\n" +
            "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea\n" +
            "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb\n" +
            "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe\n" +
            "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef\n" +
            "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb\n" +
            "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce";

    private String input = "beacf afbd bcead cgefa ecdbga efb gbfdeac ecgfbd acbdfe fb | bf efb bgecdfa egcfa\n" +
            "cbdgef cdfageb cegbd fecba edgf dcfbe dbcafg df fcd dbegca | bgcdef dgbec bfeac fdeg\n" +
            "bgdcfa dgabf bfdec baefd abeg eda afcdge ea bfceadg dfegba | efbad fbdea dae fagbd\n" +
            "cfdabe fcgbe gcdeb ecdfgb bdc cdgf cd cfageb bgdae daebfcg | decbaf cdfg deabg cd\n" +
            "eacgdfb fdbeca agedc cbedf dcfgab bgef gdf fdgec fbcged gf | gf acegd fdeabgc gfd\n" +
            "egcd aebdcf gbeca eg edfcbga gbe cfbag bdeca gadbec bdgefa | caegfbd dgcebfa eg bgdfae\n" +
            "fcgab egafb gedbca gfc cf ceagdf cafbdeg gcafbd dbagc cfdb | dbecga dbgcefa cfg fcg\n" +
            "geacd bg cbfead efgabcd fbace ceabg efbadg gfbc gab geabcf | cfbg fabce bg fdgeacb\n" +
            "bfceg ca baefc caedfb acfedgb cfad edacbg eac debaf bdfage | geadbc bfgeacd efagcdb cefbg\n" +
            "fd dcfbge fcad dfg bgaefc fdcgab fgdceab afdbg cbagf gdaeb | aecdgfb dbcfag cdaf gfecba\n" +
            "dabce gceab fegcab fbdca adeg gcabdfe gedbac ed egdfbc deb | fdegcb acbdf ed gdae\n" +
            "bgcea cbfdage egad ecadb beg befdcg fcgba aecbdf ge abedcg | geb gbe deag eg\n" +
            "bfecag egbdfac abecg gcebf efdagc ca acbf cfbegd eac bgaed | bdcegfa gbfce dbgecaf ac\n" +
            "fcbed dbfegca cdafbe edfgc abfde ebc egcfab dbca fdgbea cb | cb fgedc cb cdfeb\n" +
            "fb fdeacb bfe bfdc ebcgda afdeb acbfge agedf ecbad fdagcbe | gfcdbae fb abcefgd bef\n" +
            "egbca cfe eadbfg baedgfc cf bcfd afbde acebf fecdag edafbc | cfe caedfgb fc eadfgc\n" +
            "gfabc fbcaeg bagd cgbfaed dfecb gfdcb fcedga dg dafbgc dgf | abgd bdgcf ebcdfga fcedbga\n" +
            "cdb abce ebgfdc bfagdec abdcef dbfea gfdca facbd dfaebg cb | cdb cb dbc cdafbeg\n" +
            "afdbe dcfegb gedca adcbe ecfgbad fcadge cb acgdeb cbe agcb | dcage bec cb cb\n" +
            "gafdec cbdg fdgbce dce dfegb fceab becagdf dc dfbce agdefb | dgebf dc bfgde cde\n" +
            "bagfc bdef cgeafd eagfbcd afceb fe cfabde agcdeb cef eabdc | fbdgaec ef ef cafbe\n" +
            "fbage cgfba bdcage edagbf fe agcfdeb gfe adfe dgabe egbfdc | fe gfe geabf dgecab\n" +
            "gdfec bgfc dbgafe gfdebc dbfeg fc fabdcge fcd gedac dcbfea | egadc cfd efbdg gcbf\n" +
            "dacgf dfabc ebgcad daegfcb aedfbc dbgf agd aegfc cbfdag gd | agd gbdf bdafcge bcfegad\n" +
            "gdbea ebacdf adebfgc dfb df fbdea gcfebd fceab bfcgea fdac | gfabecd efdgbc fcebgd fbd\n" +
            "fba gbdcf cbae ebfgca fbcegda ab gbedfa gbacf gface gecdfa | ba bacgfde edfgac ab\n" +
            "fgebda bfgae cfdgba agcbe dbaegcf gbfda ef bfe gcbdfe dfea | ebgfdc eagcb eafd bef\n" +
            "agfecb cabef dafgec adfeb fbc gacb cb afbegdc cfaeg cbdefg | aegbfc fcb cgfdbe fcaged\n" +
            "agf eadfc cegabfd eagdf efdgb cgfbde agbfed gfbcae ag abdg | abdegf gbad baecgf afdbeg\n" +
            "gfbdac bd gcaefd bdcegfa gadbce dgb badf gbfdc fgecb cgadf | bgd fcbgd gdb dbfa\n" +
            "cbgf efcgbd aefdcbg feabd dcf cdebf ebcgda cf egcbd fadceg | dcf cf gcedaf bgfc\n" +
            "bacgfe fbc cgfe bcdagf gebfa cafeb bdcafge afdegb caedb cf | befga cbf gcfe bcf\n" +
            "bgdf geacf acedgb gb aecbfd bdcfa abgcf bgc acgefdb cdgabf | cdbgea gcb fdbg adgefcb\n" +
            "bdacgef fadeb abcg gfcebd gbf afbge egacf dgceaf bg aefgcb | gfb fbg dbgecfa bacg\n" +
            "dcegf bg cdafegb cfdebg fagced bge ecfab dbgace cgbef bdgf | gb gbfd adgefc ebg\n" +
            "gbf fbcdega egdafc bg aefgd gbecfd agbe abcdf edgafb fbdag | cgaefbd dfaeg dafgb dfeagc\n" +
            "beaf aed aecdf aebcgd eafdcb cgfabd ea gfcde cbdfa ceagdfb | fabe bafecd fecgdab ae\n" +
            "bdcfe gbdae bcgafd daegfb aecg cdagbe gfbadec gbc gc edcgb | cdbge efbgcda dagcbe agebdf\n" +
            "ec fdcag aegcbf bagfcd cgfade adecg fdaebcg fecd degba egc | deagc ec ebagd cafgeb\n" +
            "dcgaeb egadc agcfde efac beagdfc fcdagb dgcef gbfde dfc cf | cdf cf febadgc ecgfd\n" +
            "afd df gdafecb bdcf fecba acged edcabf egdbfa egfabc acdfe | cgebaf dacge fdbc decga\n" +
            "ga beafc cgbea dceagf feabdc bfagec abgf cga fdeagbc cebdg | cagbe bgfa gbced gabf\n" +
            "edag cdafb ae efacd eacgbf cedgbf afe fbceadg cdgaef egcdf | eaf cdafb efa ae\n" +
            "eagdbfc cagdf badcge fgec cg cdg bdfca feadg fecdga dfbega | abcfd dgc cgd gdc\n" +
            "beadg ca cdeba gcda acfebg dfbce fcbadge dbafge gdabec cae | gcad eca agbced gdbace\n" +
            "agfcde gdceab dbeaf agfed dg acfegb gaedbfc adg aegcf fgcd | bdefa cgebfad gdfc gd\n" +
            "gafcdb bfgaec daecf bcfgdea bged be dcgfb cfebd fbe dfebgc | fcabge dbfagec gebdfca gbfcd\n" +
            "dcaef agfbec gea ge bged cbdfag fgbade gbdefca abfgd faged | bfdcega aeg bdgaf bedg\n" +
            "dcbfa ag fcaegb fcdaegb gebdf adeg bdfga dgfeba ebcdgf gaf | cbgedfa ag egda ga\n" +
            "bcgdaef fcabde dbfage cfdgb daegf bfe dgefb gfadce egab eb | bfe gfeabd gdbef dagfbec\n" +
            "be egb fgcbde agdbcf gcdfb edbf bagecf ecadg bdefgca bdegc | efcdgab edgbcf efabcg dgecb\n" +
            "bcegfd ceafd gbefca eba dacebfg gebfd baegdf dabg dbfae ab | bae abcgef gbdcefa dbga\n" +
            "dceagfb edac ecfba cbgadf dfbge bcdefa fdc cd fcaegb edcbf | bdface cgfabde cdf cdafeb\n" +
            "cgaedbf acd afbdge afdcg bdcaeg gadfb ac gcbdfa abcf cdgef | gdfac cgdef cgfad cfbedga\n" +
            "gaefdcb debga cd aebcd gceafb afdceb cfabe dfcb dca agdcef | dbcafeg dfecag dbfc efgdacb\n" +
            "abdeg eaf cedfba aefdg gcadfe af gdfaecb gcfa gdfec cbgdef | fea cebfda dfceag fadcebg\n" +
            "bcgdfe fbdce fcdbea bcead adc ca bdgcaf edcgbaf baged feac | ecbad bfdec acd ac\n" +
            "bd aecfgb bfad gdb dgbace fbaegdc egbaf ecdgf egbdf fgadeb | fcageb dgb dgfeb bfad\n" +
            "bfcea dfbcea badge bfegdca gac cafdgb gc aecbgf caebg gefc | fegc bcaeg beafc feadbc\n" +
            "cagef fadgebc fd daf dcfbga ebdgfa cbeadg afdeg abegd ebdf | gbafedc daefg fd gbadec\n" +
            "dfaebc bcgaf bcaeg abecgf eagf dgecb cae ae dcgbafe gbadcf | ea gdecb bfacge gbace\n" +
            "dfbec gcbade fadb df badefcg dbeac cfgeb ebafcd fecdga edf | febcg cfadeg ebcgda dbfa\n" +
            "cadgfe bdfea dgbfeca dab dgbaec afdegb fdgb gaefd db cbfae | dgbf edabf bd dfgb\n" +
            "decbga ebfcgd gcebf cabfe aec cbfad ea eafg adbgcef cebfag | efga ea cgafbed acfdb\n" +
            "dcgefb gafc bagfce ca fcaeb aec dfbae ebgcf bcfdega deacgb | begcdfa ace fdegbac ac\n" +
            "gafc dgafecb cdgeba dbgafc fa bacdg fceabd fbgde afb fadgb | cafgdbe fbedagc adefbc gacefdb\n" +
            "dgfe dfa fd agcfbd bedac gfaec bdfcgae ebgcaf edfac acegfd | adf degf fad fedacgb\n" +
            "efgacdb gedfc eadbfg efd dcagf cfdage gdbacf gcbed fe fcae | eafdgb fdcge cafe dfe\n" +
            "aebg gbfdac dcebfga bdcef ebcfag abcfg acfeb dfcaeg ea eca | bega ace bacfg bgadcf\n" +
            "ceag caefgb agb fbgdc ag cafbg becfa cfeabd deafgb eafcgbd | cgadbef gba ag bag\n" +
            "bdge agbec dgcfae agbedcf gdc gbecad dabgc gd fbadc abefcg | gfcbaed dbge dg acfbd\n" +
            "dcef efb dbcfgae gbecfa fe ebcdag cafedb cadbe afdbe badfg | edcf ef fe fe\n" +
            "cdagfeb fgabc cafd fcb bdagc dfcgeb gbfacd cf baefg bdegac | cf acgbd fdac cdbfega\n" +
            "cefbdg debgca abfeg cebgf fdbgac adcgefb fcde cbe ce cdbgf | bgfae bec cfdebga cfegbd\n" +
            "fcbag gcfbed adgbefc afbdeg adbgf dbea ad cefagd daf debfg | da afd baegdfc afd\n" +
            "ba gbcda degcb bad adbegc fgcad eacb adgefb gdfaecb gcbedf | dgbaec gdbcfe dba ba\n" +
            "cdabf cbdgae facgb fadg acg gfbce ag cgdafb edcfab dbcegfa | dafg bdafec cbfeg facbg\n" +
            "edbaf cfebad aec cdaf ca gfabce cbeda afgebd fbdacge bcgde | ac afgbce dacf fcda\n" +
            "egdba bafeg bd gdfeba bcedfa agcde bad fgdb fceabg gabdefc | fbgae efgacb cadfeb bgdf\n" +
            "fdcgae dcefb cdb fecgabd afecb dbcfeg bgceda bd gfdb cdegf | dgabec cbdgae bcd aedcbgf\n" +
            "beg eg bfcea cdfgeb baefg abgdf fgeabd gcfdba agde dgbaefc | cdabgf dbefgc bdgfa facgebd\n" +
            "dbgef bfecgad egfcd agfbce agbde bf gcebdf dagfce cbdf feb | fbe ebfcdg bcfd fgcdabe\n" +
            "abgdec fgd fcgeb gedabf gfbdc dgaecbf afdc dgcafb fd bgcad | fgd adcf bgfcd fdegba\n" +
            "cafdb acdbge acedb dfbcg af ceadfbg adf adfgec faeb dcfeab | gdabfec bdgfc dcfba feab\n" +
            "dbcgae bcdfeg bfceadg bafgcd dacgb dfac cfgba bfc aefgb cf | dcegbf fc becagd fc\n" +
            "geacb gebfda gbcdafe efgc ge ecabd bcefag gfbcda age gafbc | adbfecg acbge cabedfg gea\n" +
            "gabce feagdb dgb fceadb deagb edbfa gd cbfgde agdbfec afdg | gbd begdcf aegbd bgd\n" +
            "afecbg fgeda dfeabgc cdafe adgb dg dbcegf fabged faebg egd | ged abfgced gd afcde\n" +
            "ec badfec cfe befgd gdacfe bace fgedbac gbcadf fdcba cfedb | ecf ec ce efcdb\n" +
            "dacfgb fd gfdbae ecbdgfa ecbdag cbfeg faed gdf aegbd egdfb | eacdbg gbfdea begfd becfdag\n" +
            "faegbd fgdace acbfeg dfgecba ed dabge fdbe dae badcg eagbf | dfeb dfgabe adcgb de\n" +
            "dbe gbcef acdebf defa geabdc de dfcbag dbgaecf cabfd becdf | eadf adcegb efcbg cfabdg\n" +
            "gcaed adgbce abfeg cb egcba cdba cgadef cgbefda fdbegc ebc | gbeaf cb bcad fadcge\n" +
            "cef fbacd gafedc ec gaecbdf bfedg gdcfeb bfdce cegb bfadeg | ec fbceagd fce fec\n" +
            "gfdae adgb cabfde fgdceb dea gafec bdgafec agdebf ad degfb | bcedgf bedacgf cegfa bcfgead\n" +
            "ec cge dagef eacgbf cdafegb cfgadb gbedca ecagd cdeb agcbd | cfagbd dcega gaecdb bgfaecd\n" +
            "ebgac cegbad dfcegb abegdf gbdec bae dcae efabgdc ea cgfba | ea eba deca bea\n" +
            "dcgfba adgbef feac afedgc dcegf egabfdc fc fdaeg bdceg dcf | beagcfd gdbcafe efac cf\n" +
            "cadfg gb cedagf gbd abgcfd fdcebga acgb febgda fdbec bdgcf | cagb cfagd gbd fegcbad\n" +
            "fgdca afcdeg bcdeagf gc fcaed defabc aedcbg bgfad cdg cfge | gc gdeacf agdbce fbacdge\n" +
            "fea adgeb bgfe fe dcfeag bafegd badcf aedbfgc adefb bcdeag | eafbd abfged begf egfb\n" +
            "gace dagcf fedac fbceagd defab cfe gdcfeb cdfgae ec gbfadc | ecf cagefbd befgdac acge\n" +
            "afc gaedf dfecga bafcdge cf bgdac dafcg eacbfd gbdafe gcef | adbcg fca agdbfce acf\n" +
            "cdfebg dcbe fgbdac bfegd be beagfc gfdea gacfbed fbe cgfbd | gedabfc eb eb aegcbfd\n" +
            "afg dfgec gcfeab ebcfagd fa adfe bagcd gdcfa gfbedc gecdfa | fa eacgdbf fa defa\n" +
            "bfdag gbecd cefg efcbdga fbc cf gbcfd badfec bedfcg egcbda | gadefcb bfc bacfde bgedc\n" +
            "cafde dce dcbfa dgcefb cgea dgafceb fgcdae dagfe gfebad ec | fcdae dbgfec gfdea dfcgeba\n" +
            "gcebad cfgdb cfgeab cdb cd egcdbf gbdaf fcde fgdbcae gfbec | cbd geacdb adbcge dc\n" +
            "afegb adbfg becafdg dg bgd gaebfc fdge cdfba gbcead abfdeg | gd gbd dabfc defg\n" +
            "fabeg gd dfebcg dgfae bfgeca fecad adgb efabgd ecfdbag deg | gd cfead dcfea cbefgda\n" +
            "bfceag dafgb fdce fc cfg gcdebf becgfda dgbec aedcgb cbgdf | fc adfgb dgfab cgbedf\n" +
            "bfeg decaf cegfa ecfgab gcf dbfeacg caedgb aegbc dbcafg fg | bgdcfea fg bfdaegc afgcdbe\n" +
            "eac ae cbdfe cbaedf abcfedg bade aefcbg bdcgef cedaf gdfca | efcdbg ae bdfce cdefa\n" +
            "gdebfca bfgca fda bcafd ad gcda cfgdab fadbeg edfcb gcbfae | cgafdb fad fda acdg\n" +
            "gfbdcae afed gedac facegd bgeac de fgbecd cagfd ged bdgfca | bacge egbacfd adgfc deg\n" +
            "gdafbe dbacgf cbefag cbfdg bfdag fcedg cdbgfae adbc cgb cb | bc gadefb bc acbd\n" +
            "fa egcad acfed ebdcfa dgcbef daf bdecf fgadbc fbae gabdecf | cedfa egdcbfa fa afd\n" +
            "cfd fd gbafc dcagf daecg dbfa cbfage egfdbc bfdgcae cbdfga | ecbdgf df dabf fd\n" +
            "eafbdgc baegd fe bagfed aebfg cabedg efg facgb bdgfec fade | defa ef ef fdae\n" +
            "cfdeagb bdeacf eac gcdbfa egab egacfb cdgfe ea ecfga cgfba | aecfg dfbacge cae ea\n" +
            "aefcdgb bacfg cdg afecd gedbcf afgcbe abgd adbfcg fgdac dg | bagfc gbfcdea gfdac bgda\n" +
            "becf baefgd dcafg cb cdbage dcgfb bcg gdbef edbfcg egbcafd | fbce cbg gcbfde gefabd\n" +
            "gb bgedca fedga cfdeag fegb dcbfa gab afgdb acbgefd bdgaef | bga gb gb ebfg\n" +
            "dca cedbf dcfebga ca egbcad cdaefb fedag efdac acbf cfgdbe | fbcade cebfdag adc acd\n" +
            "bgdeafc gaefd fbeagc cdfa fgc degcf dgbafe gcedaf dgcbe fc | gfc egafd cf bcdeg\n" +
            "dfaeb fae ebacfd egadb fe gadbfc febc gbfeacd fagcde dcabf | beadg adefb fcbe dagfcb\n" +
            "fgaed gd dacgfb egcd gdf acfed adbfceg edbfca dcafeg baefg | decaf bacdgf fgd ebgaf\n" +
            "bcfeadg dfagce fdcgba dfcab gabec gcf gf abgfc bacedf bdgf | bcgfeda bdgf fg gf\n" +
            "ceab gafec cef fcdgba cbfeadg bcagf ce ceagbf agdfe degcbf | efgca efgca cef ebac\n" +
            "abgef abf gbeac gabfcde degcfb efdbga aefd bgdcfa af befdg | afbcdg fa bdfgec dfbgae\n" +
            "gdafce cfb agfbc ebaf fcebdg aegfc cbgfea egbfdca dbgac bf | fb abfe aebf dgecbf\n" +
            "ceadf fecag dcgaeb dgbfcea edc bcafd cdabef ed befd gfcdab | badecf ed egfca edfb\n" +
            "gecdbaf dbag bfade gabfed cedfba gfade cfaebg fgdce ag fga | bafgdce gacbef ga dagb\n" +
            "defbcg gbfce beag gacdf cfbaeg dbcfea ea cefga ceafbgd ace | aefcg ae aegcbf ebga\n" +
            "egbdac fgadb cefdbg aceg gc cedba dcbag ecafdb fgeacdb gcd | cg ecbad egdafbc cgd\n" +
            "bdac ac fcdaebg afbdeg dbagf fbcge acf cadgbf afedgc bgfca | cdab fgceb ac fgbac\n" +
            "ba eacfg cab aefcb cdeabgf ecgdbf dcbfe dbfeac acdbeg dfab | bacef adbf bfda cab\n" +
            "gbfca ceafbd geda gcdfae efbcdg fgced da degbcfa adf cdagf | aegd ad da geabcfd\n" +
            "fgdacb dg efagc gcd cgefab edcgfa cbedf gfdce eabgcfd daeg | dgc gdc cfedga cdg\n" +
            "bcadeg fbgaec ecdag gbafced ba bca edab bgadc fdcgae gdbcf | bcadfge edgacf bac dabgce\n" +
            "aedfb dbfcae caefbdg aefcdg gafcb dfcba bgfeda dc fdc edcb | bdfae cd eafdb cdf\n" +
            "cga afdebc gc adcgefb adbgf acgfde gcabd gbedac ecgb acdeb | gbce ecadb daebcg gc\n" +
            "cdf dcafg df cgade cebgad dcgfea fdacbeg dgbfec afbgc fade | bgeafdc feda edaf fbgac\n" +
            "fagbc dbag feadgc gfa dcebfg gbdcf ag gecafbd ceafb bagcfd | fadegcb gacfed defcbg dgcbaef\n" +
            "cadbfeg dbgace fcagd bedfca cfegd afgb bgdfca ga adg fdabc | dfcag gcedf cefabd fbadc\n" +
            "fgeabd egbca dfage fdagec fb dacbfe badgecf baf gfaeb bdgf | bfdg fdbg ebagc beafg\n" +
            "gbdaefc fa dgafb feda fegbdc dfbeg gaf cegfba gacdb badgfe | bagdf fa afg ebgcdf\n" +
            "bedc fbagd bdage cgdeab eba gcabef afcdge edgca be cfbgeda | geadb be dceb ebdgca\n" +
            "fe fceb acegdfb efg fdgce fagbed bedgc fedbgc dagbce agdfc | febcdg egdcfab dcebgf gef\n" +
            "fagdc ebacgd ecgdb decafgb cefbda geba bagcd bad fbdgce ba | ecdbg abeg dfbeac fgdaceb\n" +
            "decgaf cgab aedbc cbaegd ca bdegc fcegdab efabd cda cdbfeg | aedbf ebdaf cda dca\n" +
            "gafbde ecfda afdegc ecdgb ba cbfa cfadeb edabc bea ecbdfga | eab ecdgb bea ab\n" +
            "gbecaf dbgf facbgde cegabd gebdfa fdaec dfage egf adebg fg | gfe egf becafg abfgedc\n" +
            "gfceabd adgcb bcdf afb gafbd becafg bf dagef agbdec fgcdba | cbagfd fdbga dcbega dfgecba\n" +
            "ba afegdb cdab cfgeb facebdg fcabg cdagf fdgcab gab decgfa | cfbdega dacb agdcfb gabfdc\n" +
            "adebgc bdefcga afegdb bcedf bfg fedbg fg efga dbgea facdbg | gf gf debafg fgb\n" +
            "cegfda gfa ecgf gf ebgdac afcbd ecagd afebgd fcdag begcafd | fcabd dfacgbe fcabedg ceadfg\n" +
            "febgcd fcbda cdgab fcgbad bf fdcea dfb egbadfc bgcdae fbag | cedfa fb fb gabf\n" +
            "ebfag fcbade ad adec bgecdfa afd gebfcd bfdec fbade bgcdfa | adf ecad ebadf bdcgafe\n" +
            "cafbgde bdace cefadg gefcbd ag egdcf gae bcfaeg gcdae adfg | egabcdf cedga cedag adgf\n" +
            "agcef egcab fc dfeagb fce gbaefdc ebcadf aefdg adefcg gcfd | dfgc aebcg egdcfba agbec\n" +
            "db fdbcge dgb gfaced bfacgde dfba egdfba cabge edgfa gebda | eafbgdc db db gdafcbe\n" +
            "cad cdfgea caegbf agbd cbdef gbcdaf gadecbf ad bcafg dacbf | fgecba cgbfeda da dbecafg\n" +
            "bdegaf gfde gf bcadeg dafgcb afg bgaef eagdb cfbeadg fbeac | ebgad gfed debfcag fdge\n" +
            "bgac edgacbf dfbea cgebda gea cfedga agedb ag dcgeb fcedgb | dbage bdgacef cfagdeb deabg\n" +
            "caebd edf edgfbc fe abfegdc cdfea gfdac eacfgd gfacbd gaef | fega fgae gafe cabde\n" +
            "bfadegc dafec dbgaec abdcef fdaegc dag cagf ga aedgf fbedg | bcafedg ag ga adg\n" +
            "dcgfa dgcafeb cfb bf cegafb begcda fdgbce dcebg bfed fcgdb | dgcebaf bedf fb bcged\n" +
            "cbegd edfa fdc gadcfb gbcefad bgacef acfbe ebacfd bfecd fd | fdc dbgafc cefbd cdf\n" +
            "fgd dgbfe gf gcef bdecf dgcfba acfbde gdefbc badge facbdeg | dcfaebg fg fgd fbgced\n" +
            "abdeg adebcg ebafdc bgcadfe gedc ega bgdaf cabed efacbg ge | ge gae age afebgdc\n" +
            "debfa dfbga fagdc fbg cadgfe acgfbd efgcab cgfeabd dbcg bg | fgdba bg gfacbed ecabgf\n" +
            "bc egdba ebdacg cgba dabfec bec defcg cdbefga gbfead becdg | bcefagd bec cebfgda cb\n" +
            "deagbfc agebdc fbedca fa edgafc bfac adcbe gfedb afd efdab | fad dbaef cbfdae af\n" +
            "afgdeb beagd daecbfg gbfedc ecd becad egac agecbd ce fbcda | fbadge eacdbg cde ce\n" +
            "fgabec gefb cdagefb fbacgd dgecba adecf eg cefga egc gcfba | dafgbc gec bfeg gefb\n" +
            "gbcf fceag gb bag bdafge gbeac fdegca cfegdab egfacb daceb | bg cagfeb aedbc cbaeg\n" +
            "gbac fedagb gaf adcbf ceabfd abecgfd bfcdga ga edgcf gfcda | badcf fcedg adbcfg agebfd\n" +
            "gdbfc fbaecd gaef ef efb agebc gabdefc ebcgad facegb bgcfe | cfgdbae faeg efga cdegab\n" +
            "fbacge decgba bcafd fedgab fageb ed efgd ebafd gedbcfa bed | de ed bdafe de\n" +
            "bcgdf badgec de fecgd cfeag dfbe dcgafeb gdacfb ced fdbgce | de de edc gafbdc\n" +
            "gebfa fd dgacb dfgba bfdeca daf becfga edfg afgebcd gfadbe | bdcfea bafecgd acdegfb fgbdea\n" +
            "fgdcb efdcg gcfabd gcdbafe gbf acfb aegcdb edfabg fb gbcda | bgafde gfcbd fb cedbfga\n" +
            "de fadcg befcdg fbeac adcef efd ebgfca cbefadg edba dbaecf | eagbfcd beagfc bcefgd beda\n" +
            "ebcfad fbecgd edgba df adgfcbe dfe bcfaeg bedgf bcefg dgfc | df bcagef df aecfgb\n" +
            "acgdb gdc gcebdaf abcge ecgdfa egbd cbaegf gdacbe fcdba dg | egcfda aebgfc aegcbdf cgd\n" +
            "gc cge cgdb deafbgc dageb cbega agbcde cedgfa gbefad cefab | dabfeg gc eabcgdf gabde\n" +
            "abegc agecf adfcbge bcdaeg fbadec bca cb bcgd egdba gbafde | gbdc begad bfecda cb\n" +
            "daecgb abegd bagedf begfcd fe feag abefd bfe fbgceda fbdac | fbdac gcebdaf egfa fe\n" +
            "eafcbdg abcdg acegf dfcga fgaebc defcbg aefd dfc dfgace df | df adef fd dfea\n" +
            "fdecabg ba agebdc adb gcdea befdg gabc egdba badefc ecagdf | bda gcabde gdaec fgdcae\n" +
            "cdfg dbecf dg caebdf gbd beafg cbegfd ebcgdfa gdfeb agdecb | cedfb gd cbgeafd debgacf\n" +
            "bca cadbfeg gabfcd bcgafe caebg adgfec bc bcfe gefac beadg | cgefab cgfae befc acbegf\n" +
            "cabgdef cgabde efcab degcf gcfdeb da fgda cda feagcd aedcf | adc da cgaedf cgdfbe\n" +
            "dagfbe gaefb efcgadb fbcae fg gbf edbag cbgdae gadfbc gfde | bgf gf acgdfb cfgdba\n" +
            "cbedag edgca bfcagde gfbae gfdea df adfc dafceg fedbcg gdf | adecg gbafe acdbfeg df\n" +
            "ebfc ef gecfad gfdcb egbad gfabcd ecgdafb feg bfgdce dbefg | aegdb bfged ef bafdgc\n" +
            "ce cefd cafdg cdgefa geacbd eca gcbfad gebfa afecg bfedcga | ecgfa cea defc ce\n" +
            "ceb edbgafc fabec cb dfagec fgbea daefcb efdca cebgda bfdc | bec eadfgbc degabc adgfce\n" +
            "cgf aefbdgc gf bagf gedacf ecgfb cdfeb acgbe ebcfga cedbga | gf fbgcade cbegfda acbdfeg";
}
