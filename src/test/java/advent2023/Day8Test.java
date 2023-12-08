package advent2023;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day8Test {

    @Test
    public void sol1() {
        String direction = input.split("\n")[0];
        Map<String, Node> network = new LinkedHashMap<>();
        String[] ar = input.split("\n");
        for (int i = 2; i < ar.length; i++) {
            String n = ar[i].split(" = ")[0];
            String l = ar[i].split(" = ")[1].replace("(", "").replace(")", "").split(", ")[0];
            String r = ar[i].split(" = ")[1].replace("(", "").replace(")", "").split(", ")[1];
            network.put(n, new Node(l, r));
        }
        String current = "AAA";
        int count = 0;
        String[] s = direction.split("");
        for (int i = 0; i < s.length; i++) {
            if (current.equals("ZZZ")) {
                System.out.println(count);
                break;
            }
            if (s[i].equals("L")) {
                current = network.get(current).getLeft();
            } else {
                current = network.get(current).getRight();
            }
            count++;
            if (i == s.length - 1) {
                i = -1;
            }
        }
        System.out.println(count);
    }

    @Test
    public void sol2m() {
        String direction = input.split("\n")[0];
        Map<String, Node> network = new LinkedHashMap<>();
        String[] ar = input.split("\n");
        for (int i = 2; i < ar.length; i++) {
            String n = ar[i].split(" = ")[0];
            String l = ar[i].split(" = ")[1].replace("(", "").replace(")", "").split(", ")[0];
            String r = ar[i].split(" = ")[1].replace("(", "").replace(")", "").split(", ")[1];
            network.put(n, new Node(l, r));
        }
        Map<Integer, String> startingNodes = new LinkedHashMap<>();
        int index = 0;
        for (Map.Entry<String, Node> entry : network.entrySet()) {
            String k = entry.getKey();
            if (k.split("")[2].equals("A")) {
                startingNodes.put(index, k);
                index++;
            }
        }

        Map<Long, String> endsMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : startingNodes.entrySet()) {
            String current = entry.getValue();
            long count = 0;
            String[] s = direction.split("");
            for (int i = 0; i < s.length; i++) {
                if (current.endsWith("Z")) {
                    break;
                }
                if (s[i].equals("L")) {
                    current = network.get(current).getLeft();
                } else {
                    current = network.get(current).getRight();
                }
                count++;
                if (i == s.length - 1) {
                    i = -1;
                }
            }
            endsMap.put(count, entry.getValue());
        }

        Long total = null;
        for (Map.Entry<Long, String> entry : endsMap.entrySet()) {
            Long k = entry.getKey();
            if (total == null) {
                total = k;
                continue;
            }
            total = lcm(total, k);
        }
        System.out.println(total);
    }

    private long lcm(long x, long y) {
        long max = Math.max(x, y);
        long min = Math.min(x, y);
        long lcm = max;
        while (lcm % min != 0) {
            lcm += max;
        }
        return lcm;
    }

    class Node {
        private String right;
        private String left;

        public Node(String left, String right) {
            this.right = right;
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public String getLeft() {
            return left;
        }
    }

    private String input = "LRLRRRLRLLRRLRLRRRLRLRRLRRLLRLRRLRRLRRRLRRRLRLRRRLRLRRLRRLLRLRLLLLLRLRLRRLLRRRLLLRLLLRRLLLLLRLLLRLRRLRRLRRRLRRRLRRLRRLRRRLRLRLRRLRLRLRLRRLRRRLLRLLRRLRLRRRLRLRRRLRLRRRLRRRLRRLRLLLLRLRRRLRLRRLRLRRLRRLRRLLRRRLLLLLLRLRRRLRRLLRRRLRRLLLRLRLRLRRRLRRLRLRRRLRRLRRRLLRRLRRLLLRRRR\n" +
            "\n" +
            "QSF = (JQX, GGN)\n" +
            "VBT = (XTD, KGR)\n" +
            "SMK = (SNK, LBX)\n" +
            "LSJ = (JMQ, TJJ)\n" +
            "QFG = (XLT, TVF)\n" +
            "BTF = (SLQ, DJX)\n" +
            "XDF = (JKG, XFH)\n" +
            "PFR = (JGJ, SPB)\n" +
            "QVS = (PXH, PXH)\n" +
            "HVA = (NMF, CTG)\n" +
            "FRS = (GSX, JQK)\n" +
            "GJX = (BRV, LVQ)\n" +
            "NDD = (XMG, PTS)\n" +
            "RDJ = (GHT, TPR)\n" +
            "PJG = (KMR, GCV)\n" +
            "SQM = (KFD, VPC)\n" +
            "DTN = (NCL, HHT)\n" +
            "TRX = (NGH, BBT)\n" +
            "DVR = (JGL, VBL)\n" +
            "FSH = (HVL, XXL)\n" +
            "NSK = (NCX, QHD)\n" +
            "HKC = (XNV, MHL)\n" +
            "QRV = (QNS, FQH)\n" +
            "BVQ = (KHF, VLM)\n" +
            "DXS = (TNK, PVV)\n" +
            "SNL = (DMG, NFH)\n" +
            "DTM = (XMF, BTF)\n" +
            "QHD = (CXS, KXX)\n" +
            "STP = (QNH, FGM)\n" +
            "CMJ = (KCD, LGF)\n" +
            "SDM = (XXT, GKQ)\n" +
            "MXN = (KKH, DXG)\n" +
            "DCS = (HND, MBD)\n" +
            "BKV = (VBT, TNH)\n" +
            "JNS = (QSF, PRS)\n" +
            "BDB = (JXM, NMH)\n" +
            "KQC = (PQS, BJV)\n" +
            "CVC = (JNS, NDN)\n" +
            "FSJ = (RPS, SDM)\n" +
            "LHG = (VMQ, LBF)\n" +
            "KKN = (LPC, MJQ)\n" +
            "CXL = (VKM, QPC)\n" +
            "LNL = (GRQ, DXM)\n" +
            "DFV = (SDM, RPS)\n" +
            "JHQ = (VNF, GBS)\n" +
            "XXT = (BSF, QJX)\n" +
            "NRL = (BJV, PQS)\n" +
            "PVD = (GFK, NVN)\n" +
            "DXM = (LQX, KTN)\n" +
            "JGL = (HSC, CTT)\n" +
            "LLH = (NCV, NKL)\n" +
            "KLN = (HQM, JPV)\n" +
            "TTG = (GJX, QRT)\n" +
            "BFB = (LXC, HNR)\n" +
            "QBX = (CLB, XLR)\n" +
            "DBV = (SSL, CXV)\n" +
            "MBB = (THC, LDK)\n" +
            "JVJ = (VHF, CNL)\n" +
            "GJB = (NGH, BBT)\n" +
            "CNT = (CTS, SKH)\n" +
            "KBX = (LNS, BTN)\n" +
            "VJF = (PXQ, QMF)\n" +
            "CVH = (BGQ, XBL)\n" +
            "TKD = (MFV, PPF)\n" +
            "XLG = (XJK, XBH)\n" +
            "XRK = (RLQ, PDX)\n" +
            "TCS = (SCM, KCB)\n" +
            "DLD = (VPV, BKD)\n" +
            "RNK = (TMJ, MVH)\n" +
            "JJG = (TBT, HGC)\n" +
            "MRV = (KQL, XDB)\n" +
            "JFN = (BTS, DCB)\n" +
            "TMR = (KRR, DKC)\n" +
            "XXL = (VMC, FNR)\n" +
            "LSB = (QRB, TFM)\n" +
            "SRH = (FXT, JQN)\n" +
            "FDS = (LMM, PRM)\n" +
            "QVB = (DQX, LDD)\n" +
            "NSQ = (CMP, MBB)\n" +
            "JMC = (JQK, GSX)\n" +
            "VXF = (BKV, KTH)\n" +
            "NJF = (MFV, PPF)\n" +
            "KMG = (KXD, GNB)\n" +
            "VPV = (VDP, GRG)\n" +
            "HSC = (RBP, TBQ)\n" +
            "RSR = (DLD, MBC)\n" +
            "JGF = (TDM, LSB)\n" +
            "KGP = (CHX, XDR)\n" +
            "DHQ = (BXX, FKB)\n" +
            "VDP = (HCX, RGB)\n" +
            "XLX = (NQX, CLR)\n" +
            "VPB = (LNJ, KDH)\n" +
            "TML = (HMS, NHC)\n" +
            "KLT = (MDQ, NFK)\n" +
            "SHV = (GDL, MKV)\n" +
            "VVX = (DGT, QPK)\n" +
            "VMC = (FRQ, BVH)\n" +
            "MPN = (XHB, DXS)\n" +
            "QGF = (STF, XSH)\n" +
            "HBM = (JDQ, RKC)\n" +
            "RRR = (LLD, HPK)\n" +
            "LVG = (SDF, QVT)\n" +
            "PMR = (BHP, VVQ)\n" +
            "LNP = (MCN, HXT)\n" +
            "XBX = (HRJ, CNH)\n" +
            "LBL = (RKV, FVM)\n" +
            "KFP = (NLX, HCG)\n" +
            "KBM = (QQV, FKL)\n" +
            "HVL = (VMC, FNR)\n" +
            "FKL = (FLX, GHH)\n" +
            "LCB = (SGN, CDX)\n" +
            "RKC = (MQR, DPM)\n" +
            "HLV = (GBS, VNF)\n" +
            "RXD = (SJJ, CXL)\n" +
            "HFK = (QRT, GJX)\n" +
            "GRV = (CRT, BNZ)\n" +
            "LJB = (LCN, CKX)\n" +
            "RMQ = (RBV, RBK)\n" +
            "BGQ = (LSJ, LLK)\n" +
            "HDH = (XFK, LQV)\n" +
            "KXS = (DBV, FVV)\n" +
            "JDQ = (MQR, DPM)\n" +
            "QXP = (FQH, QNS)\n" +
            "MJD = (TDM, LSB)\n" +
            "PKC = (DPN, DQL)\n" +
            "DLJ = (NCK, SSN)\n" +
            "TTK = (VVK, GHD)\n" +
            "MDF = (CDP, NJL)\n" +
            "FQH = (QJT, FGK)\n" +
            "JGJ = (FDS, DFL)\n" +
            "SKH = (FTN, HBT)\n" +
            "PGP = (TLX, QMX)\n" +
            "NDN = (QSF, PRS)\n" +
            "RBK = (HBM, JGV)\n" +
            "FTM = (PBK, TJQ)\n" +
            "DLG = (DPN, DQL)\n" +
            "SDF = (JGF, MJD)\n" +
            "SBV = (MLH, LNL)\n" +
            "MLH = (DXM, GRQ)\n" +
            "NKN = (MVS, NRR)\n" +
            "MLX = (VLK, KTD)\n" +
            "HDJ = (LVG, TKC)\n" +
            "SDP = (CFH, FBJ)\n" +
            "QQV = (FLX, FLX)\n" +
            "KBF = (HBP, PVD)\n" +
            "XJS = (MSK, TTK)\n" +
            "JFC = (LLH, XMJ)\n" +
            "HBT = (TSF, DJJ)\n" +
            "SRS = (JCT, CLN)\n" +
            "KGR = (LJB, BXQ)\n" +
            "TMP = (PVG, PVG)\n" +
            "PXC = (DTM, MXH)\n" +
            "KMJ = (TXV, FJT)\n" +
            "VRP = (BSV, RBF)\n" +
            "VLK = (PMR, MQQ)\n" +
            "GJG = (CLC, JVM)\n" +
            "CPF = (NNP, DCS)\n" +
            "CMP = (LDK, THC)\n" +
            "PTB = (XTL, DVH)\n" +
            "PVG = (DKP, DKP)\n" +
            "KCB = (VGS, NSQ)\n" +
            "THC = (TNN, TLG)\n" +
            "RBV = (HBM, JGV)\n" +
            "NRX = (CSF, DLK)\n" +
            "XTD = (BXQ, LJB)\n" +
            "TXV = (JPT, BFB)\n" +
            "CKB = (FGM, QNH)\n" +
            "VVR = (SJG, KXS)\n" +
            "HMS = (FRG, NNM)\n" +
            "DXG = (KGB, LSV)\n" +
            "XKB = (KHF, VLM)\n" +
            "GKG = (DXS, XHB)\n" +
            "GSC = (XNT, SBV)\n" +
            "RGN = (DBF, RFT)\n" +
            "LXR = (XBX, LGT)\n" +
            "SCM = (VGS, NSQ)\n" +
            "PXM = (TMP, LBG)\n" +
            "BXX = (DVR, MQV)\n" +
            "SJH = (TKD, NJF)\n" +
            "JPT = (HNR, LXC)\n" +
            "XHC = (NRL, KQC)\n" +
            "LQX = (NDT, MNM)\n" +
            "HHT = (TPT, TKK)\n" +
            "KFD = (SFF, RCP)\n" +
            "GSK = (GFB, DLJ)\n" +
            "DVN = (HCG, NLX)\n" +
            "SXF = (CSD, TQJ)\n" +
            "KRR = (TGF, DMC)\n" +
            "QRB = (JHQ, HLV)\n" +
            "LBA = (TBT, HGC)\n" +
            "SBN = (FMH, SNL)\n" +
            "BBK = (CTS, SKH)\n" +
            "HQM = (GXM, KJV)\n" +
            "HVN = (FSJ, DFV)\n" +
            "GXM = (TTG, HFK)\n" +
            "MVS = (BGS, DHQ)\n" +
            "RDS = (VXP, SRS)\n" +
            "MFX = (XQX, FSH)\n" +
            "KQL = (VQM, BFP)\n" +
            "CHF = (RFD, BBQ)\n" +
            "VFS = (TCM, HXD)\n" +
            "CSD = (CMJ, PRT)\n" +
            "GQF = (KTD, VLK)\n" +
            "CXV = (KRD, RRR)\n" +
            "LMF = (LQL, QLJ)\n" +
            "JJC = (SRH, HQG)\n" +
            "HGS = (JBR, TBH)\n" +
            "SHJ = (HBP, PVD)\n" +
            "PKM = (FVM, RKV)\n" +
            "CMV = (NMF, CTG)\n" +
            "JKS = (KJC, LLN)\n" +
            "XLR = (PLQ, DLN)\n" +
            "CTG = (BJM, BHH)\n" +
            "HJB = (TTK, MSK)\n" +
            "QJT = (NCC, SFB)\n" +
            "BFP = (JSG, KJJ)\n" +
            "CHX = (VGP, SRT)\n" +
            "HCX = (DMB, FPG)\n" +
            "LTN = (GBK, XMH)\n" +
            "KTH = (TNH, VBT)\n" +
            "JBC = (LBX, SNK)\n" +
            "MDL = (NTS, KFJ)\n" +
            "JPQ = (NJF, TKD)\n" +
            "GHM = (SSD, XTX)\n" +
            "CLR = (RMT, TLR)\n" +
            "GNT = (NFK, MDQ)\n" +
            "QNV = (RDS, XGC)\n" +
            "NVN = (TJG, TCS)\n" +
            "TPR = (TQT, GRJ)\n" +
            "GTQ = (BLJ, DGL)\n" +
            "LMM = (NXN, RXH)\n" +
            "CTB = (LRS, NDD)\n" +
            "MCN = (KCJ, NVD)\n" +
            "JGV = (RKC, JDQ)\n" +
            "NRR = (BGS, DHQ)\n" +
            "DJQ = (SXF, CQG)\n" +
            "MNC = (CHX, XDR)\n" +
            "MFV = (JNK, JBJ)\n" +
            "JBJ = (KLQ, SQM)\n" +
            "DCB = (PXX, RJR)\n" +
            "FXA = (MQX, NDF)\n" +
            "FVJ = (DLK, CSF)\n" +
            "PXH = (JJG, JJG)\n" +
            "CBT = (HQP, NDS)\n" +
            "NKC = (BLJ, DGL)\n" +
            "TFM = (JHQ, HLV)\n" +
            "LSF = (LRS, NDD)\n" +
            "XNV = (GDJ, KBX)\n" +
            "TXQ = (MHQ, VXT)\n" +
            "PNV = (VDD, FKH)\n" +
            "MSK = (VVK, GHD)\n" +
            "SRL = (GNS, BKJ)\n" +
            "XXC = (CKR, DCJ)\n" +
            "FBJ = (LFK, TJR)\n" +
            "FRL = (KMJ, NMT)\n" +
            "JQN = (BRL, NMG)\n" +
            "RVQ = (TML, KNH)\n" +
            "CMQ = (FMH, SNL)\n" +
            "NDF = (PPK, VPB)\n" +
            "HRJ = (TVL, CPX)\n" +
            "XTR = (HPT, JFM)\n" +
            "XNT = (MLH, LNL)\n" +
            "LBG = (PVG, MNS)\n" +
            "QRF = (XCG, XCG)\n" +
            "NXN = (LNP, QGG)\n" +
            "SLQ = (GSK, NDG)\n" +
            "TNN = (DPL, CKF)\n" +
            "PQS = (JBC, SMK)\n" +
            "TJR = (KMG, KHR)\n" +
            "CGL = (LXR, XRG)\n" +
            "GGN = (TDT, RXD)\n" +
            "PQP = (NKN, KNK)\n" +
            "KRJ = (CTB, LSF)\n" +
            "FGK = (NCC, SFB)\n" +
            "RCP = (GKG, MPN)\n" +
            "HTP = (LBF, VMQ)\n" +
            "VMQ = (HBQ, JBB)\n" +
            "NDM = (CMV, NMZ)\n" +
            "PJF = (QMF, PXQ)\n" +
            "CFX = (JGJ, SPB)\n" +
            "TLF = (TKC, LVG)\n" +
            "HVK = (PXH, QFQ)\n" +
            "CHB = (JPQ, SJH)\n" +
            "MVH = (HBC, DJQ)\n" +
            "FPG = (TBJ, RVQ)\n" +
            "JCT = (FKM, MRV)\n" +
            "DLK = (NSK, SFN)\n" +
            "GRQ = (KTN, LQX)\n" +
            "PRQ = (RDJ, CGP)\n" +
            "LBJ = (CMV, CMV)\n" +
            "RJR = (SXG, QNK)\n" +
            "RBP = (JMP, TMR)\n" +
            "RNV = (QKN, KRJ)\n" +
            "SJJ = (QPC, VKM)\n" +
            "GDJ = (BTN, LNS)\n" +
            "XHJ = (CVH, FSG)\n" +
            "GKQ = (BSF, QJX)\n" +
            "SSD = (CKB, STP)\n" +
            "KPT = (FHX, DTN)\n" +
            "TKC = (QVT, SDF)\n" +
            "SFN = (QHD, NCX)\n" +
            "JQX = (RXD, TDT)\n" +
            "SSC = (BKB, VQQ)\n" +
            "TBH = (PFR, CFX)\n" +
            "SRT = (GLQ, CPF)\n" +
            "MDQ = (HDJ, TLF)\n" +
            "RFT = (QXP, QRV)\n" +
            "QHG = (LDD, DQX)\n" +
            "SFF = (GKG, MPN)\n" +
            "RDQ = (DQQ, XLM)\n" +
            "QDS = (KTH, BKV)\n" +
            "JHC = (DFV, FSJ)\n" +
            "TGF = (FTM, XSD)\n" +
            "XDB = (VQM, BFP)\n" +
            "SGD = (KJC, LLN)\n" +
            "TDM = (QRB, TFM)\n" +
            "CFH = (TJR, LFK)\n" +
            "VDD = (FRR, CBT)\n" +
            "PTS = (PTB, LVB)\n" +
            "RLX = (GDL, MKV)\n" +
            "SFB = (HJM, SRD)\n" +
            "CGP = (TPR, GHT)\n" +
            "GBL = (TMP, LBG)\n" +
            "JSG = (QVS, QVS)\n" +
            "LSM = (TMJ, MVH)\n" +
            "BKD = (GRG, VDP)\n" +
            "NJL = (RSR, TNZ)\n" +
            "PSS = (STF, XSH)\n" +
            "PLQ = (NRX, FVJ)\n" +
            "CPX = (PSK, XRK)\n" +
            "JLK = (GSC, CKL)\n" +
            "BHH = (DRV, HQH)\n" +
            "GBK = (FDD, FDD)\n" +
            "KFJ = (HFG, BCR)\n" +
            "KMV = (NRL, KQC)\n" +
            "TNK = (RDQ, DKS)\n" +
            "HCG = (CXN, JLR)\n" +
            "LVQ = (MFX, CPJ)\n" +
            "RGX = (CHT, TTX)\n" +
            "TVF = (VKL, CLT)\n" +
            "FVT = (JMC, FRS)\n" +
            "SMT = (KVV, NFL)\n" +
            "DMG = (PSV, HGD)\n" +
            "MDS = (KDR, JMT)\n" +
            "DFK = (TXQ, HTM)\n" +
            "HBC = (SXF, CQG)\n" +
            "NFK = (TLF, HDJ)\n" +
            "BNZ = (HHG, MLN)\n" +
            "HGD = (CHB, MHT)\n" +
            "QNK = (VFS, BVV)\n" +
            "KNH = (HMS, NHC)\n" +
            "RMT = (XKB, BVQ)\n" +
            "KKH = (LSV, KGB)\n" +
            "MXH = (XMF, BTF)\n" +
            "HHG = (NKC, GTQ)\n" +
            "XFH = (DFK, CPS)\n" +
            "FDD = (CRT, CRT)\n" +
            "GBS = (FHF, HDB)\n" +
            "PRS = (GGN, JQX)\n" +
            "GXR = (KXS, SJG)\n" +
            "XSH = (KSB, RKF)\n" +
            "KTD = (MQQ, PMR)\n" +
            "FRR = (HQP, NDS)\n" +
            "VQQ = (FKQ, TRM)\n" +
            "HBP = (NVN, GFK)\n" +
            "FCH = (PVP, QFG)\n" +
            "DFF = (BKJ, GNS)\n" +
            "FKM = (KQL, XDB)\n" +
            "PXQ = (BQV, DMV)\n" +
            "GHA = (DLD, MBC)\n" +
            "RLQ = (GJG, FGQ)\n" +
            "PVP = (TVF, XLT)\n" +
            "RBF = (XCX, MDS)\n" +
            "BGS = (BXX, FKB)\n" +
            "CHT = (JCG, XTR)\n" +
            "MNK = (BKB, VQQ)\n" +
            "NNM = (MXN, QTC)\n" +
            "LVB = (DVH, XTL)\n" +
            "CKR = (TGL, SFJ)\n" +
            "FXT = (NMG, BRL)\n" +
            "PCP = (RQK, KNF)\n" +
            "HFB = (XHP, LTN)\n" +
            "TJQ = (NTM, PXC)\n" +
            "CXH = (PQP, GRL)\n" +
            "LDK = (TLG, TNN)\n" +
            "GSX = (KBM, RCT)\n" +
            "ZZZ = (XLR, CLB)\n" +
            "GND = (NPS, JVJ)\n" +
            "DQQ = (KPT, FVC)\n" +
            "JVM = (KMV, XHC)\n" +
            "KVV = (HQQ, RNV)\n" +
            "XHP = (GBK, GBK)\n" +
            "HGF = (XCG, CJF)\n" +
            "VKL = (XLX, DPD)\n" +
            "SPB = (FDS, DFL)\n" +
            "VHF = (NLM, LGX)\n" +
            "TDT = (SJJ, CXL)\n" +
            "JQK = (KBM, RCT)\n" +
            "QKN = (CTB, LSF)\n" +
            "NTM = (DTM, MXH)\n" +
            "PPF = (JNK, JBJ)\n" +
            "QMF = (DMV, BQV)\n" +
            "LSV = (QBL, VVX)\n" +
            "NMT = (TXV, FJT)\n" +
            "NHC = (NNM, FRG)\n" +
            "GNB = (GQF, MLX)\n" +
            "GHD = (DFF, SRL)\n" +
            "TRM = (LGL, RGX)\n" +
            "FJC = (DCJ, CKR)\n" +
            "DRV = (HDR, PJG)\n" +
            "MHL = (GDJ, KBX)\n" +
            "HRF = (XHP, LTN)\n" +
            "LNS = (KBF, SHJ)\n" +
            "JGX = (FSG, CVH)\n" +
            "TVL = (PSK, XRK)\n" +
            "DQX = (BBK, CNT)\n" +
            "VLM = (TRX, GJB)\n" +
            "BVH = (QFP, JFN)\n" +
            "JPV = (GXM, KJV)\n" +
            "HPB = (XBH, XJK)\n" +
            "RQK = (JKS, SGD)\n" +
            "JBB = (FCH, NJB)\n" +
            "KJC = (CXH, QFN)\n" +
            "NFL = (HQQ, RNV)\n" +
            "NVL = (NPS, JVJ)\n" +
            "XHB = (PVV, TNK)\n" +
            "QRT = (LVQ, BRV)\n" +
            "KNF = (JKS, SGD)\n" +
            "PRN = (NTS, KFJ)\n" +
            "BVV = (HXD, TCM)\n" +
            "HXM = (VJF, PJF)\n" +
            "BTS = (RJR, PXX)\n" +
            "TJG = (KCB, SCM)\n" +
            "LXC = (RGD, QCR)\n" +
            "HJM = (KLM, KKN)\n" +
            "JCG = (HPT, JFM)\n" +
            "LBX = (GTV, CHF)\n" +
            "NPQ = (CSP, KHM)\n" +
            "NLM = (HPQ, VRP)\n" +
            "MQV = (JGL, VBL)\n" +
            "DJJ = (HGS, LJJ)\n" +
            "JLR = (SDP, GJC)\n" +
            "LDD = (CNT, BBK)\n" +
            "RGD = (HMN, CVC)\n" +
            "HNR = (RGD, QCR)\n" +
            "CKX = (DLG, PKC)\n" +
            "TLG = (DPL, CKF)\n" +
            "BKB = (FKQ, TRM)\n" +
            "TNZ = (MBC, DLD)\n" +
            "CLC = (KMV, XHC)\n" +
            "BQS = (KHH, RBR)\n" +
            "KHH = (QTR, PNV)\n" +
            "NCX = (CXS, KXX)\n" +
            "SDK = (RBK, RBV)\n" +
            "QTR = (VDD, FKH)\n" +
            "VPC = (SFF, RCP)\n" +
            "SRD = (KLM, KKN)\n" +
            "BDJ = (CDX, SGN)\n" +
            "LRS = (PTS, XMG)\n" +
            "RJP = (GSC, CKL)\n" +
            "SJT = (JMC, FRS)\n" +
            "JXM = (BPQ, QNV)\n" +
            "XMH = (FDD, GRV)\n" +
            "BBT = (DDV, SCH)\n" +
            "FJT = (JPT, BFB)\n" +
            "NLX = (JLR, CXN)\n" +
            "PPH = (XDF, VLV)\n" +
            "BHP = (CMQ, SBN)\n" +
            "PBK = (NTM, PXC)\n" +
            "CRT = (MLN, HHG)\n" +
            "HQG = (FXT, JQN)\n" +
            "LBF = (JBB, HBQ)\n" +
            "HDB = (HLT, RCX)\n" +
            "NNP = (HND, MBD)\n" +
            "PSA = (MLN, HHG)\n" +
            "CSF = (SFN, NSK)\n" +
            "CJF = (MHV, GNZ)\n" +
            "BQV = (QRQ, GHV)\n" +
            "JPJ = (QRF, HGF)\n" +
            "VQM = (JSG, KJJ)\n" +
            "SFS = (QRF, QRF)\n" +
            "DCN = (KVV, NFL)\n" +
            "SGN = (BQS, CKP)\n" +
            "FLX = (LBJ, LBJ)\n" +
            "BJV = (SMK, JBC)\n" +
            "NQX = (TLR, RMT)\n" +
            "CTT = (TBQ, RBP)\n" +
            "BCR = (GXR, VVR)\n" +
            "HQH = (PJG, HDR)\n" +
            "VJP = (SRH, HQG)\n" +
            "LGT = (HRJ, CNH)\n" +
            "LLD = (BDB, XDT)\n" +
            "QMX = (HKC, MCP)\n" +
            "HBH = (XVX, TBP)\n" +
            "XMF = (SLQ, DJX)\n" +
            "TPT = (NRN, TSK)\n" +
            "CKF = (XJS, HJB)\n" +
            "QTC = (DXG, KKH)\n" +
            "KDR = (CXR, PRQ)\n" +
            "RCX = (CGL, GFM)\n" +
            "KCD = (QDS, VXF)\n" +
            "LNJ = (QGF, PSS)\n" +
            "KNK = (NRR, MVS)\n" +
            "FKQ = (RGX, LGL)\n" +
            "VXG = (QMX, TLX)\n" +
            "JMQ = (BLT, PRD)\n" +
            "RCT = (QQV, FKL)\n" +
            "SNK = (GTV, CHF)\n" +
            "FMH = (NFH, DMG)\n" +
            "TJJ = (BLT, PRD)\n" +
            "LGF = (VXF, QDS)\n" +
            "XCG = (MHV, MHV)\n" +
            "MNS = (DKP, MSD)\n" +
            "CXN = (SDP, GJC)\n" +
            "QCR = (CVC, HMN)\n" +
            "VBL = (HSC, CTT)\n" +
            "GCV = (NVL, GND)\n" +
            "DFL = (LMM, PRM)\n" +
            "CQG = (CSD, TQJ)\n" +
            "NCV = (CLJ, PPH)\n" +
            "GTV = (RFD, BBQ)\n" +
            "NCK = (JGX, XHJ)\n" +
            "XLT = (CLT, VKL)\n" +
            "KCJ = (JJS, JJS)\n" +
            "LLN = (QFN, CXH)\n" +
            "TQJ = (PRT, CMJ)\n" +
            "VTT = (KHM, CSP)\n" +
            "SJZ = (HGC, TBT)\n" +
            "NCL = (TPT, TKK)\n" +
            "CNL = (NLM, LGX)\n" +
            "FKH = (CBT, FRR)\n" +
            "GRG = (RGB, HCX)\n" +
            "FSG = (BGQ, XBL)\n" +
            "HXT = (KCJ, NVD)\n" +
            "DLN = (FVJ, NRX)\n" +
            "MQR = (VJP, JJC)\n" +
            "HCS = (KMJ, NMT)\n" +
            "LQV = (QHG, QVB)\n" +
            "KLM = (LPC, MJQ)\n" +
            "CGD = (DBF, RFT)\n" +
            "SKX = (XVX, TBP)\n" +
            "SSN = (XHJ, JGX)\n" +
            "SXG = (BVV, VFS)\n" +
            "MCP = (XNV, MHL)\n" +
            "DPD = (NQX, CLR)\n" +
            "JMP = (KRR, DKC)\n" +
            "QRQ = (RGN, CGD)\n" +
            "VGP = (GLQ, CPF)\n" +
            "CLT = (DPD, XLX)\n" +
            "TNH = (XTD, KGR)\n" +
            "DGL = (RLX, SHV)\n" +
            "VVK = (DFF, SRL)\n" +
            "HTM = (MHQ, VXT)\n" +
            "GHH = (LBJ, NDM)\n" +
            "GRJ = (KGP, MNC)\n" +
            "QVT = (MJD, JGF)\n" +
            "QNS = (FGK, QJT)\n" +
            "NMG = (PKM, LBL)\n" +
            "FVV = (SSL, CXV)\n" +
            "HXK = (RQK, KNF)\n" +
            "GNZ = (NDF, MQX)\n" +
            "KSB = (QXN, SCD)\n" +
            "RFD = (JHC, HVN)\n" +
            "CXR = (RDJ, CGP)\n" +
            "KML = (QLJ, LQL)\n" +
            "DCJ = (TGL, SFJ)\n" +
            "VGN = (LQV, XFK)\n" +
            "DGT = (HXK, PCP)\n" +
            "KDH = (PSS, QGF)\n" +
            "TKK = (NRN, TSK)\n" +
            "DQL = (HCS, FRL)\n" +
            "VNF = (FHF, HDB)\n" +
            "TBT = (FJC, XXC)\n" +
            "FTN = (DJJ, TSF)\n" +
            "FGQ = (CLC, JVM)\n" +
            "FVC = (DTN, FHX)\n" +
            "QJX = (PXM, GBL)\n" +
            "CLN = (MRV, FKM)\n" +
            "NTS = (BCR, HFG)\n" +
            "JFM = (SSX, KLN)\n" +
            "BRV = (MFX, CPJ)\n" +
            "CTS = (FTN, HBT)\n" +
            "JKG = (DFK, CPS)\n" +
            "KGB = (VVX, QBL)\n" +
            "DPN = (HCS, FRL)\n" +
            "LCN = (DLG, PKC)\n" +
            "MLN = (GTQ, NKC)\n" +
            "KHM = (HXM, LBN)\n" +
            "TCM = (RKN, GHM)\n" +
            "NMZ = (CTG, NMF)\n" +
            "RXH = (LNP, QGG)\n" +
            "NDT = (PRN, MDL)\n" +
            "QFP = (BTS, DCB)\n" +
            "KJV = (HFK, TTG)\n" +
            "RKN = (SSD, XTX)\n" +
            "QNH = (DCN, SMT)\n" +
            "KMR = (NVL, GND)\n" +
            "PSV = (CHB, MHT)\n" +
            "GHV = (RGN, CGD)\n" +
            "HND = (LSM, RNK)\n" +
            "NCC = (HJM, SRD)\n" +
            "BTN = (KBF, SHJ)\n" +
            "XGC = (VXP, SRS)\n" +
            "DDV = (PRX, VXJ)\n" +
            "CLJ = (VLV, XDF)\n" +
            "SSX = (HQM, JPV)\n" +
            "NMF = (BJM, BHH)\n" +
            "DBF = (QRV, QXP)\n" +
            "DKS = (DQQ, XLM)\n" +
            "FHX = (HHT, NCL)\n" +
            "CKL = (SBV, XNT)\n" +
            "DPL = (XJS, HJB)\n" +
            "TTX = (XTR, JCG)\n" +
            "NJB = (QFG, PVP)\n" +
            "XBH = (DVN, KFP)\n" +
            "DKC = (DMC, TGF)\n" +
            "SSL = (RRR, KRD)\n" +
            "FVM = (HTP, LHG)\n" +
            "MNM = (MDL, PRN)\n" +
            "NFH = (HGD, PSV)\n" +
            "MQQ = (VVQ, BHP)\n" +
            "VXJ = (RJP, JLK)\n" +
            "GFM = (LXR, XRG)\n" +
            "HBQ = (FCH, NJB)\n" +
            "XFK = (QHG, QVB)\n" +
            "JBR = (CFX, PFR)\n" +
            "RHN = (SDK, RMQ)\n" +
            "HPT = (SSX, KLN)\n" +
            "GDL = (MNK, SSC)\n" +
            "DJX = (GSK, NDG)\n" +
            "LQL = (VTT, NPQ)\n" +
            "SFJ = (RHN, GDT)\n" +
            "BLT = (VGN, HDH)\n" +
            "DVH = (HFB, HRF)\n" +
            "VLV = (XFH, JKG)\n" +
            "BSV = (MDS, XCX)\n" +
            "BBQ = (JHC, HVN)\n" +
            "JMT = (PRQ, CXR)\n" +
            "HPK = (XDT, BDB)\n" +
            "CPJ = (FSH, XQX)\n" +
            "QFQ = (JJG, SJZ)\n" +
            "TSK = (SKX, HBH)\n" +
            "HFG = (VVR, GXR)\n" +
            "PRX = (JLK, RJP)\n" +
            "MKV = (SSC, MNK)\n" +
            "XTL = (HFB, HRF)\n" +
            "KHR = (KXD, GNB)\n" +
            "SJG = (DBV, FVV)\n" +
            "TLR = (BVQ, XKB)\n" +
            "CNH = (CPX, TVL)\n" +
            "LGX = (VRP, HPQ)\n" +
            "QGG = (MCN, HXT)\n" +
            "BXQ = (CKX, LCN)\n" +
            "PPK = (LNJ, KDH)\n" +
            "XVX = (JFC, PBJ)\n" +
            "NKL = (CLJ, PPH)\n" +
            "XLM = (KPT, FVC)\n" +
            "XDT = (NMH, JXM)\n" +
            "PRM = (RXH, NXN)\n" +
            "XBL = (LLK, LSJ)\n" +
            "BLJ = (SHV, RLX)\n" +
            "RPS = (GKQ, XXT)\n" +
            "NMH = (QNV, BPQ)\n" +
            "MHT = (SJH, JPQ)\n" +
            "TBQ = (JMP, TMR)\n" +
            "CDX = (BQS, CKP)\n" +
            "HDR = (KMR, GCV)\n" +
            "CKP = (RBR, KHH)\n" +
            "TBJ = (TML, KNH)\n" +
            "XRG = (LGT, XBX)\n" +
            "NDS = (GNT, KLT)\n" +
            "KLQ = (VPC, KFD)\n" +
            "GHT = (TQT, GRJ)\n" +
            "MBD = (RNK, LSM)\n" +
            "XSD = (PBK, TJQ)\n" +
            "PVV = (DKS, RDQ)\n" +
            "KRD = (LLD, HPK)\n" +
            "VKM = (SJT, FVT)\n" +
            "FNR = (FRQ, BVH)\n" +
            "HMN = (NDN, JNS)\n" +
            "NGH = (SCH, DDV)\n" +
            "PRD = (VGN, HDH)\n" +
            "BKJ = (HPB, XLG)\n" +
            "GDT = (RMQ, SDK)\n" +
            "FGM = (SMT, DCN)\n" +
            "MHQ = (SFS, JPJ)\n" +
            "VXT = (SFS, JPJ)\n" +
            "CXS = (LMF, KML)\n" +
            "DMV = (QRQ, GHV)\n" +
            "AAA = (CLB, XLR)\n" +
            "QPC = (SJT, FVT)\n" +
            "PRT = (LGF, KCD)\n" +
            "PSK = (RLQ, PDX)\n" +
            "LJJ = (JBR, TBH)\n" +
            "LBN = (VJF, PJF)\n" +
            "QFN = (GRL, PQP)\n" +
            "SCD = (VXG, PGP)\n" +
            "GJC = (CFH, FBJ)\n" +
            "MQX = (VPB, PPK)\n" +
            "QLJ = (VTT, NPQ)\n" +
            "RKF = (QXN, SCD)\n" +
            "PBJ = (LLH, XMJ)\n" +
            "SCH = (PRX, VXJ)\n" +
            "VVQ = (CMQ, SBN)\n" +
            "KTN = (MNM, NDT)\n" +
            "FRG = (QTC, MXN)\n" +
            "XCX = (JMT, KDR)\n" +
            "CDP = (RSR, RSR)\n" +
            "XMG = (PTB, LVB)\n" +
            "PXX = (SXG, QNK)\n" +
            "MBC = (BKD, VPV)\n" +
            "PDX = (GJG, FGQ)\n" +
            "DPM = (JJC, VJP)\n" +
            "BPQ = (RDS, XGC)\n" +
            "XJK = (KFP, DVN)\n" +
            "NVD = (JJS, MDF)\n" +
            "GLQ = (DCS, NNP)\n" +
            "MHV = (MQX, NDF)\n" +
            "CPS = (TXQ, HTM)\n" +
            "BRL = (LBL, PKM)\n" +
            "VGS = (MBB, CMP)\n" +
            "HQQ = (KRJ, QKN)\n" +
            "LGL = (CHT, TTX)\n" +
            "KJJ = (QVS, HVK)\n" +
            "KXD = (MLX, GQF)\n" +
            "KHF = (TRX, GJB)\n" +
            "GFB = (NCK, SSN)\n" +
            "BSF = (PXM, GBL)\n" +
            "TMJ = (DJQ, HBC)\n" +
            "MSD = (QBX, ZZZ)\n" +
            "TGL = (GDT, RHN)\n" +
            "XQX = (XXL, HVL)\n" +
            "NPS = (VHF, CNL)\n" +
            "LFK = (KMG, KHR)\n" +
            "LPC = (BDJ, LCB)\n" +
            "CLB = (DLN, PLQ)\n" +
            "QBL = (DGT, QPK)\n" +
            "GRL = (NKN, KNK)\n" +
            "MJQ = (LCB, BDJ)\n" +
            "HQP = (KLT, GNT)\n" +
            "NRN = (HBH, SKX)\n" +
            "JNK = (KLQ, SQM)\n" +
            "JJS = (CDP, CDP)\n" +
            "TBP = (PBJ, JFC)\n" +
            "TSF = (HGS, LJJ)\n" +
            "STF = (RKF, KSB)\n" +
            "NDG = (GFB, DLJ)\n" +
            "DMC = (FTM, XSD)\n" +
            "GFK = (TJG, TCS)\n" +
            "GNS = (XLG, HPB)\n" +
            "FHF = (HLT, RCX)\n" +
            "FRQ = (JFN, QFP)\n" +
            "BJM = (HQH, DRV)\n" +
            "RKV = (LHG, HTP)\n" +
            "HGC = (XXC, FJC)\n" +
            "XTX = (STP, CKB)\n" +
            "FKB = (DVR, MQV)\n" +
            "XDR = (SRT, VGP)\n" +
            "RGB = (FPG, DMB)\n" +
            "VXP = (CLN, JCT)\n" +
            "TQT = (MNC, KGP)\n" +
            "LLK = (TJJ, JMQ)\n" +
            "DKP = (QBX, QBX)\n" +
            "XMJ = (NCV, NKL)\n" +
            "HXD = (GHM, RKN)\n" +
            "QXN = (VXG, PGP)\n" +
            "CSP = (LBN, HXM)\n" +
            "HPQ = (RBF, BSV)\n" +
            "DMB = (TBJ, RVQ)\n" +
            "QPK = (PCP, HXK)\n" +
            "KXX = (LMF, KML)\n" +
            "TLX = (MCP, HKC)\n" +
            "RBR = (PNV, QTR)\n" +
            "HLT = (GFM, CGL)";
}
