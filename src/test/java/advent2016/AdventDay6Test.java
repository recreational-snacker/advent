package advent2016;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deesha Singh on 2016/12/06.
 */
public class AdventDay6Test {

    @Test
    public void testExample() {
        String testInput = "eedadn\n" +
                "drvtee\n" +
                "eandsr\n" +
                "raavrd\n" +
                "atevrs\n" +
                "tsrnev\n" +
                "sdttsa\n" +
                "rasrtv\n" +
                "nssdts\n" +
                "ntnada\n" +
                "svetve\n" +
                "tesnvt\n" +
                "vntsnd\n" +
                "vrdear\n" +
                "dvrsen\n" +
                "enarar";
        AdventDay6.solution1(6, testInput, ">");
    }

    @Test
    public void testSolution1() {
       AdventDay6.solution1(8, fullInput, ">");
    }

    @Test
    public void testSolution2() {
        AdventDay6.solution1(8, fullInput, "<");
    }

    String fullInput = "hgxcejbh\n" +
            "xllyqcqh\n" +
            "wfbuksyy\n" +
            "gdfkgzny\n" +
            "jaswdllt\n" +
            "vadfhcsm\n" +
            "dhgjfpey\n" +
            "phsldudv\n" +
            "gqsvicsf\n" +
            "dwcscmwp\n" +
            "nskyvzkd\n" +
            "aajypkwi\n" +
            "pspqneoq\n" +
            "xuxxotja\n" +
            "dmloldlr\n" +
            "szehutoh\n" +
            "ngyqirdf\n" +
            "kvetagoj\n" +
            "ncyieonn\n" +
            "rqlovfab\n" +
            "rrctmccu\n" +
            "htpmxyac\n" +
            "ruibmndi\n" +
            "bdknfprt\n" +
            "jvhdlgau\n" +
            "locicolj\n" +
            "leotycqq\n" +
            "hewhjckj\n" +
            "pfvpzxls\n" +
            "wobjbaob\n" +
            "yknrcnjn\n" +
            "iytvslou\n" +
            "amrrqzon\n" +
            "slvukfco\n" +
            "qtynzmjq\n" +
            "feehamqb\n" +
            "qvfmcrue\n" +
            "gsipukcv\n" +
            "twpaaett\n" +
            "lacpegbj\n" +
            "mzrumyhz\n" +
            "qwukkyoz\n" +
            "notkeoxh\n" +
            "fmhfrsxd\n" +
            "tlacfjep\n" +
            "kjvdjvbg\n" +
            "bwayfidl\n" +
            "bkswohdl\n" +
            "ozhxwhfr\n" +
            "djuddmzm\n" +
            "ocjmsazq\n" +
            "lbmswjjq\n" +
            "zbqyacqu\n" +
            "ludbuvwq\n" +
            "lxbodlvj\n" +
            "awznlqzd\n" +
            "gfxdnhyg\n" +
            "aimrenku\n" +
            "lpnpwquo\n" +
            "zvyyphgs\n" +
            "nbozurjs\n" +
            "rmarpyso\n" +
            "fblptqts\n" +
            "ebwlxqdk\n" +
            "excpawrh\n" +
            "yrecdjcj\n" +
            "upbsbhdn\n" +
            "tdwkedjg\n" +
            "fvdcambp\n" +
            "fksvqfin\n" +
            "eizfmmsg\n" +
            "pstyvbho\n" +
            "oecxiuhk\n" +
            "rtonwtsl\n" +
            "kinfvfic\n" +
            "kicoycji\n" +
            "ozqaixkp\n" +
            "tphzcynp\n" +
            "cqgaopux\n" +
            "jkczaayd\n" +
            "bhsacjfc\n" +
            "bugrbpkf\n" +
            "jshlmvtx\n" +
            "tltbcihe\n" +
            "xrspledr\n" +
            "llciifht\n" +
            "qpfstkca\n" +
            "jtoadgyw\n" +
            "sweggqqm\n" +
            "wsfrosga\n" +
            "xbwgrbim\n" +
            "vcjcxkba\n" +
            "skpgsmih\n" +
            "nurbhrvz\n" +
            "doffmusw\n" +
            "mxrnpvwm\n" +
            "yhrcrmun\n" +
            "ftrsobzx\n" +
            "ansgphyt\n" +
            "lnorwllg\n" +
            "bmvoqagr\n" +
            "fgjeyahg\n" +
            "hvkhjzcf\n" +
            "cgqyzrzo\n" +
            "mzkjeupz\n" +
            "bwnsskeo\n" +
            "ilpzdsjz\n" +
            "pznjzsih\n" +
            "uivlqzlr\n" +
            "appuxmue\n" +
            "shbvjujl\n" +
            "asdiirav\n" +
            "zmxqpszh\n" +
            "yzjovpns\n" +
            "zxvoieyc\n" +
            "eeyrbdma\n" +
            "swkgytac\n" +
            "acuntifb\n" +
            "brdscjom\n" +
            "rjxefdhb\n" +
            "wenjxsqa\n" +
            "yutcange\n" +
            "vtdhdbhs\n" +
            "rqbtwivr\n" +
            "sfaipzzg\n" +
            "utaillto\n" +
            "ylptxyph\n" +
            "adkckfjw\n" +
            "gpgchlro\n" +
            "jilodzga\n" +
            "bscfyvyu\n" +
            "obbkxatw\n" +
            "jpjxbqhp\n" +
            "rnyesgmb\n" +
            "fvwkstan\n" +
            "rbsafdzy\n" +
            "iffdgdjf\n" +
            "exfvgkgy\n" +
            "uascsncj\n" +
            "dxfacgwz\n" +
            "dbjgvpei\n" +
            "tmpljqba\n" +
            "yyzrihfj\n" +
            "exmpvsnz\n" +
            "wmrpykzf\n" +
            "gkbutcvc\n" +
            "bexeuhvc\n" +
            "vfdbkxek\n" +
            "opftyriv\n" +
            "eyxdevku\n" +
            "aoxzgltj\n" +
            "uquxvoig\n" +
            "emuquomm\n" +
            "roqemvtl\n" +
            "zdccsuuk\n" +
            "hwgjrsdw\n" +
            "pnzirncg\n" +
            "ehhjveuy\n" +
            "eiikyxmd\n" +
            "vysfvwum\n" +
            "ouqbtjsq\n" +
            "zofwuilp\n" +
            "ikfwrsug\n" +
            "eonlyayj\n" +
            "oxjfkhpa\n" +
            "crowmesi\n" +
            "ojzteiqu\n" +
            "kifnubpc\n" +
            "kaypapxw\n" +
            "mslioqke\n" +
            "pqmwtjjr\n" +
            "ywpibqfy\n" +
            "wgaywazu\n" +
            "zhwptdyx\n" +
            "wpgadcpx\n" +
            "tutllkof\n" +
            "aaecopiv\n" +
            "zeugcyxl\n" +
            "mtfhjuev\n" +
            "muagnkwh\n" +
            "ykagxelx\n" +
            "wdziqoru\n" +
            "gydoheaz\n" +
            "kfuecyql\n" +
            "kmrwawxf\n" +
            "iegbycsd\n" +
            "ggqzbgen\n" +
            "cmyxshxs\n" +
            "fjrwlydh\n" +
            "aqljfioq\n" +
            "kcrjfwrf\n" +
            "pckdymrd\n" +
            "dgmrwezu\n" +
            "ehnehwes\n" +
            "llqjzgwl\n" +
            "wlrtpgmz\n" +
            "fxkwqfbn\n" +
            "khoxtgyd\n" +
            "skannanr\n" +
            "frwceace\n" +
            "jvlkukvc\n" +
            "kqytgmma\n" +
            "armrvvbx\n" +
            "vlogkabz\n" +
            "rubwxaqk\n" +
            "ptuqzfmj\n" +
            "svcbliie\n" +
            "pojmduei\n" +
            "ilnllmpc\n" +
            "kknhoqbe\n" +
            "lgfbqtmk\n" +
            "fyoahbgy\n" +
            "vpreqyfm\n" +
            "cimhwdjj\n" +
            "kaedpmty\n" +
            "rrzhcsve\n" +
            "bjizbuge\n" +
            "cvemdpoz\n" +
            "chclijyf\n" +
            "onxwjlxg\n" +
            "mbovuyqp\n" +
            "lwqswkkx\n" +
            "ztuwpgbo\n" +
            "lsmdgxjc\n" +
            "fqmgfbnu\n" +
            "pnbsykbb\n" +
            "kmiojphc\n" +
            "vtoslzrm\n" +
            "ljyxlohm\n" +
            "vrojksuk\n" +
            "jsqorzaq\n" +
            "fbzjpqev\n" +
            "zbrqrfjw\n" +
            "gkhuondt\n" +
            "onesgynd\n" +
            "gycikyum\n" +
            "ybzwzpoi\n" +
            "vthldcvu\n" +
            "dwjydabe\n" +
            "ymzkrvir\n" +
            "cdpkkjwl\n" +
            "saadgstz\n" +
            "pdenxhxt\n" +
            "uvqupdxr\n" +
            "dcumeusl\n" +
            "irvyjjvr\n" +
            "udiwgqfb\n" +
            "snvjlntg\n" +
            "sxphpbhc\n" +
            "cfmknplw\n" +
            "oeutwhrl\n" +
            "nbielpqm\n" +
            "ixwqbffn\n" +
            "tcniaygg\n" +
            "adyiictb\n" +
            "weqmwrvf\n" +
            "qddmzxgb\n" +
            "zujfexyp\n" +
            "hxugbirz\n" +
            "tzaxcnxu\n" +
            "imuzgivb\n" +
            "qlhybxpk\n" +
            "ejtpcqpf\n" +
            "aznioyvv\n" +
            "hghnzrlq\n" +
            "htgeytti\n" +
            "najifjpn\n" +
            "ildqsszg\n" +
            "uhqqfreo\n" +
            "iitvmokq\n" +
            "rksbwwns\n" +
            "xtsahjif\n" +
            "ymlvkvqf\n" +
            "wvvvkotu\n" +
            "lzzulwtn\n" +
            "finonfjx\n" +
            "tnpdotkb\n" +
            "fpkmlrab\n" +
            "vezyrksc\n" +
            "xjqprbds\n" +
            "thusmecy\n" +
            "ukopisob\n" +
            "pctjgrde\n" +
            "vygxtiro\n" +
            "ysquoaps\n" +
            "clckbexi\n" +
            "dzoapzat\n" +
            "hfdxhkcr\n" +
            "halnnrhk\n" +
            "ftbzymnt\n" +
            "surfiwgo\n" +
            "gsziigch\n" +
            "eaataomp\n" +
            "gtufatpz\n" +
            "lfprtwwg\n" +
            "gmzjyycz\n" +
            "hcelomtr\n" +
            "jswycfmn\n" +
            "ceqswbii\n" +
            "rwepuwiz\n" +
            "zdbnfmlo\n" +
            "niwzfzgj\n" +
            "mjybffdh\n" +
            "xdduqtym\n" +
            "fliehvft\n" +
            "xzpuhtdy\n" +
            "djxpcruf\n" +
            "ujxpdmlv\n" +
            "abjdlrya\n" +
            "bcabevnv\n" +
            "oigfmczk\n" +
            "mjmvxizt\n" +
            "yorbdfdx\n" +
            "tfqigium\n" +
            "qctmefwv\n" +
            "ihisthen\n" +
            "zghlvbpo\n" +
            "rxteedcs\n" +
            "kxuqubfo\n" +
            "jgizmuiw\n" +
            "zisahocr\n" +
            "rohgilxu\n" +
            "nqlfqwgk\n" +
            "jmxxghvt\n" +
            "qqafryea\n" +
            "nciuzjoa\n" +
            "hilqglwt\n" +
            "homjiopk\n" +
            "oikdsxlr\n" +
            "pndbvsap\n" +
            "pdjrmebt\n" +
            "xrwtknep\n" +
            "ggyinugw\n" +
            "zgjnzxtw\n" +
            "iwqselka\n" +
            "alloswxo\n" +
            "tmkcdpvc\n" +
            "mutmbsst\n" +
            "xhzwhekw\n" +
            "akiujnga\n" +
            "yyxzwuqe\n" +
            "wfpagrof\n" +
            "wfthfibw\n" +
            "qpjsgbwm\n" +
            "ucptinah\n" +
            "kjdwjzwl\n" +
            "ukwoiojf\n" +
            "wwiqkzww\n" +
            "rhvwrxzy\n" +
            "cxdrcpee\n" +
            "iqozocxr\n" +
            "bxnfodiy\n" +
            "ctjrqbai\n" +
            "ngykqlsi\n" +
            "oyvwtxry\n" +
            "qujqbfpe\n" +
            "oyhadvwy\n" +
            "lhntcocd\n" +
            "peyujuxh\n" +
            "yyfpypio\n" +
            "wfvkvdep\n" +
            "qwfbxnvd\n" +
            "gdstqqoj\n" +
            "uktwzvuq\n" +
            "coegngxz\n" +
            "deraggel\n" +
            "vazttrwj\n" +
            "lywzkjix\n" +
            "pwxzolvq\n" +
            "myuhmkhg\n" +
            "lrevrwpu\n" +
            "ajldvrxw\n" +
            "omakmbrx\n" +
            "tpqvzoat\n" +
            "thghpigl\n" +
            "begsfabn\n" +
            "hqzsdllv\n" +
            "crkbwfzx\n" +
            "opgzqtuw\n" +
            "edqwdgea\n" +
            "gzzbbonl\n" +
            "ggpcarrh\n" +
            "xvgkoazj\n" +
            "kzuorpfj\n" +
            "iiiyqdzr\n" +
            "ooabacmq\n" +
            "kxivhdmb\n" +
            "zqatngjz\n" +
            "kafggqrc\n" +
            "otlgcmus\n" +
            "dlmfgjwu\n" +
            "gueyhwmx\n" +
            "idmuuxsw\n" +
            "parlnjpq\n" +
            "hsbxrsuw\n" +
            "qrrxvlct\n" +
            "qogmkdss\n" +
            "suvfnyto\n" +
            "fohupzib\n" +
            "nbxhnwun\n" +
            "mwfzfznd\n" +
            "vysajakf\n" +
            "kkvqsitx\n" +
            "zpmdmaxx\n" +
            "kevovgav\n" +
            "vevfwige\n" +
            "vvwalhay\n" +
            "iddouupj\n" +
            "jcmddtsk\n" +
            "asmzyujq\n" +
            "uicrhvhp\n" +
            "knsnqzbs\n" +
            "kumbhfzi\n" +
            "nhswzwkk\n" +
            "prkdftfs\n" +
            "vhetckmx\n" +
            "hthdokgd\n" +
            "vfccndkx\n" +
            "eskmayfo\n" +
            "jmhibxev\n" +
            "dbyjssyr\n" +
            "uxxundtr\n" +
            "duhlinsd\n" +
            "nhxpfezv\n" +
            "cvzzkjbu\n" +
            "sqffcjcq\n" +
            "tpvxwcvi\n" +
            "wotqrhjg\n" +
            "uzkoggfj\n" +
            "zdovsxos\n" +
            "jeinbcua\n" +
            "emxeeebg\n" +
            "dsoeakyp\n" +
            "fpzuyofz\n" +
            "criuytns\n" +
            "sotounvb\n" +
            "jdehwhkp\n" +
            "tzzhhodg\n" +
            "ccxtvwcq\n" +
            "dvycjmrq\n" +
            "ujfgtthi\n" +
            "jqadncvs\n" +
            "qvoaxaqf\n" +
            "xctriirj\n" +
            "jwsybfcu\n" +
            "bylmuoxv\n" +
            "msraxfkc\n" +
            "hexvzcmk\n" +
            "mqkwtifm\n" +
            "nanmatfb\n" +
            "qntqnwtq\n" +
            "mnmlurqh\n" +
            "ekwityoy\n" +
            "hxlsmlav\n" +
            "qqkeiiyv\n" +
            "qbynezgt\n" +
            "xuvcwmds\n" +
            "hlqjbppb\n" +
            "xroxleqr\n" +
            "chnrropt\n" +
            "aiactdrx\n" +
            "sobbngnv\n" +
            "tromqcnb\n" +
            "jchtevxo\n" +
            "nineqzst\n" +
            "nubinxor\n" +
            "jbgazubs\n" +
            "yjqpxblt\n" +
            "oajgxvsi\n" +
            "elyvdgue\n" +
            "ybbursqw\n" +
            "cyhlxtgt\n" +
            "zkdvoshz\n" +
            "horygpna\n" +
            "cnhnwkmu\n" +
            "fekqjcfm\n" +
            "btqmekph\n" +
            "ygplicxw\n" +
            "xwwvnjwz\n" +
            "mpzlfuqm\n" +
            "hqlalemp\n" +
            "jasswvyk\n" +
            "uptxkysc\n" +
            "zhdfxnog\n" +
            "pljoiili\n" +
            "byejegvv\n" +
            "umfkjrwf\n" +
            "ngeovebl\n" +
            "hkdoxqkh\n" +
            "mtuldmyl\n" +
            "ihvxsdrp\n" +
            "sekthxeh\n" +
            "mcykfuyy\n" +
            "epjemyte\n" +
            "wxwzsvoc\n" +
            "czpmaoch\n" +
            "wcvzmhra\n" +
            "xjenhgak\n" +
            "xfgntwjj\n" +
            "dvhbjksi\n" +
            "uvpphkal\n" +
            "rrtvyuqg\n" +
            "yjxpozoq\n" +
            "odgcltlz\n" +
            "qthfkeqz\n" +
            "gnazslxp\n" +
            "mawnfpil\n" +
            "gurspbvf\n" +
            "jolfibhc\n" +
            "vnajgdft\n" +
            "zzdazljd\n" +
            "xqvdlrvb\n" +
            "tlimxoam\n" +
            "cnestuvr\n" +
            "syovtpho\n" +
            "iejylome\n" +
            "ejyiuqek\n" +
            "bntrmhox\n" +
            "afgbkqyj\n" +
            "iiwfnkad\n" +
            "bbplpgic\n" +
            "hgumzcqn\n" +
            "vvujryss\n" +
            "dyikvxhg\n" +
            "ifedoxly\n" +
            "wwixpagm\n" +
            "raxqxaji\n" +
            "hgphlvtu\n" +
            "wyhhubup\n" +
            "tfnrzzrd\n" +
            "pztqmdcy\n" +
            "ukahrffj\n" +
            "rzcgyped\n" +
            "lcytbxhb\n" +
            "mvxcabdi\n" +
            "tfafxrln\n" +
            "qmmvbxah\n" +
            "djfztprn\n" +
            "dgmmjtad\n" +
            "rfduzoxi\n" +
            "qucytfpa\n" +
            "ynreylbh\n" +
            "pqnqvsqk\n" +
            "drfeotqw\n" +
            "tsdqsnnn\n" +
            "wxbnqdvl\n" +
            "nztxxumu\n" +
            "fnvtvjda\n" +
            "bvbvqnzx\n" +
            "dzclzhkq\n" +
            "qwbxcelx\n" +
            "polupxdc\n" +
            "ivleqeft\n" +
            "lcvlhzti\n" +
            "ufbmaipk\n" +
            "trggewmp\n" +
            "zanmfvrp\n" +
            "vqmpckuh\n" +
            "nqciltkr\n" +
            "mybgynmy\n" +
            "eigdzafh\n" +
            "wgdnnxlc\n" +
            "exnmuwhb\n" +
            "fxjwouiw\n" +
            "orzqutan\n" +
            "sbgbeehd\n" +
            "sshcbebw\n" +
            "baqkrldu\n" +
            "jklbmakl\n" +
            "gukrrngy\n" +
            "alxrbynd\n" +
            "rjicvzso\n" +
            "glurpmlk\n" +
            "wgcawxjb\n" +
            "xypekblz\n" +
            "ldsksqmn\n" +
            "yjuvtnif\n" +
            "ijprxzor\n" +
            "szyhuhda\n" +
            "uggdkbzx\n" +
            "fkohgtnd\n" +
            "yojohlwv\n" +
            "aszgjquf\n" +
            "qnrxmqnq\n" +
            "rjqealny\n" +
            "rbljpiky\n" +
            "gikdyumv\n" +
            "upmuomdi\n" +
            "vzwkawpp\n" +
            "lmwhksdk\n" +
            "nseonmgv\n" +
            "pvchhjck\n" +
            "nsclplue\n" +
            "kcdyrfwl\n" +
            "xbkzjitp\n" +
            "cdkucsgf\n" +
            "myowhqye\n" +
            "bungujil\n" +
            "vpukqfen\n" +
            "ygvejpye\n" +
            "erbpwand\n" +
            "khisszwm\n" +
            "snfyeebg\n" +
            "vcwyjvzd\n" +
            "zxtqshmg\n" +
            "mwiamqrq\n" +
            "jagquwfm\n" +
            "xdlidnhk\n" +
            "qfmxzdiw\n" +
            "lnxtnlxo\n" +
            "xeanphqe\n" +
            "blbxavza\n" +
            "xtikznke\n" +
            "zwsgkjwo\n" +
            "qarjtkri\n" +
            "wfysfdev\n" +
            "bpenwbsn\n" +
            "oiwvjbkl\n" +
            "goklbvfc\n" +
            "itnfjgws\n" +
            "mqbyswnx\n" +
            "tpseqrya\n" +
            "snojvhlj\n" +
            "nkshiqcm";

}