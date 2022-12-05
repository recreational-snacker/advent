package advent2022;

import org.junit.Test;

public class Day3Test {

    @Test
    public void test() {
        int count = 0;
        for (String pack : input.split("\n")) {
            String comp1 = pack.substring(0, (pack.length()/2));
            String comp2 = pack.substring(pack.length()/2);
            for (Character s : comp2.toCharArray()) {
                if (comp1.contains(s.toString())) {
                    count += getScore(s);
                    break;
                }
            }
        }
        System.out.println("1: "+count);

        int badge = 0;
        for (int i = 0; i <= input.split("\n").length-3; i+=3) {
            String pack1 = input.split("\n")[i];
            String pack2 = input.split("\n")[i+1];
            String pack3 = input.split("\n")[i+2];
            for (Character s : pack1.toCharArray()) {
                if (pack2.contains(s.toString()) && pack3.contains(s.toString())) {
                    badge += getScore(s);
                    break;
                }
            }
        }
        System.out.println("2: "+badge);
    }

    private int getScore(Character s) {
        if (s >= 'A' && s <= 'Z') {
            return  (int) s - 'A' + 27;
        } else {
            return  (int) s - 'a' + 1;
        }
    }

    String input = "mmbclcsDHCflDDlCrzzrDWjPJvjPvqJPjfpqZQdfWd\n" +
            "NNFLnFRNhgNQtMLSFSgwSwGJPZWLPvjpjjJGZJPvWPvJ\n" +
            "BnwFNgVVhwNwVQrmzbrrCHVTmDsm\n" +
            "CTsVssjPTWPbzhfbfqqpbqJq\n" +
            "RRttdQlRdnNpdmwBnBDhFrGrqDGBqJJfJD\n" +
            "HttgcggdNwQtgcpTsvjVPTcssjsv\n" +
            "bWrpnrpPcFNbfPtwVPddVVDw\n" +
            "jLgqqJgjZLhHjRqLHLjqHgftpmJVtTmwQmtGddwwDVJm\n" +
            "HhzgshZLpHLjqhLLZRZpLRbbrlBNsrrNsFWcCvvFCcNN\n" +
            "PCJJfJhjhzjjdBVBcd\n" +
            "RnNnMHnRNtWnBSQHVbqSzFcq\n" +
            "ZlnZZZNmLrNrgZmmccGJwGwmGPJs\n" +
            "hFZLsjjjMzwPPjqw\n" +
            "SQtTcpWWcpMSDlQpDCQJqbHzdSzPzJvPPwqqvH\n" +
            "tVfpGWGDVlCGGDCpVWppVcrZFMrnmnLfsrBrnngLmMBh\n" +
            "PFPhCmpfhSMWnmgrtgMW\n" +
            "RRQdGQvTQRzQDGQTQcRqTTQLvsntnltvrWZlsWlZftntrMtt\n" +
            "NQTzfGfzcdTBhPJSNJbCCVhJ\n" +
            "sbtqfrqNfcdqsJrfhzQmzhpvzvpQmpNG\n" +
            "SHsSDsZVHBHnRZDBZRWSVDnwFhzvphggwGhQzQhgwzmmPzmg\n" +
            "jjHVHBlHljMsJjbbCcdttc\n" +
            "NccBbvbNZbbvBGPVTGhhlCZCPg\n" +
            "tdWHQtLLMrrdWQRqWrMrMrMPsTPThDlTssFFCFCVTDtCDC\n" +
            "zzWmMQQLVQrWrbBczNnwNbnpnN\n" +
            "THGhBHgHThvnHRrQRpMNSwZSMrwD\n" +
            "szsCzWljNfVFFVllPPzzVWJMJZQMJbpSrwQCCJMDZbbb\n" +
            "WzlfFlflfcmfsFPVfWVVhnNgchHndHgdTnqdNHTh\n" +
            "zPhDwsWgszftMNfPjjLL\n" +
            "RTRbbJFHSrqRRrHRrjGQBnfjQQMjLnmNnF\n" +
            "ddpNSNNpSdWsvpllWzsl\n" +
            "FgDgbSMnhhntCLCC\n" +
            "HlqzJgPfJJgmrthhrtTLqL\n" +
            "fjfQgJPGVjwGJcFMcSvdScWjMD\n" +
            "pnFwRPlVVlLSwpGbvSmZHmbbdbHm\n" +
            "sCzTQtzrrQMzpthTdvbGHdvdHNsZqqqZ\n" +
            "ChTTWhWBWCDrrTrjCrhtLwwLFgfLFgjnpfpwLnVg\n" +
            "MRDfBDMJsQdmGWsM\n" +
            "pFPqwswhGzWSCwGN\n" +
            "jphpbgbqgFnqjjnthLtJsZfJRHfllfTllDLflJ\n" +
            "sdbLCqnbllplrdrsqbZHRPRBcBcBZBcHcZrM\n" +
            "JJFwDDQmzfmhmWhJhwFWbMbcNBNRBBzbNPHcMHPj\n" +
            "DFWVQVGGGbpGClllqLSl\n" +
            "mRmFhZRsmFJfFRzwRrFrqmRFtNLLDTPccVqVtGTLDnPccPDN\n" +
            "SBddBlZMjpQvvBbZvVDTtDTDDVGnLTMPVT\n" +
            "dCHWlbHbdbllsRCCgFwrrZCJ\n" +
            "hwvwFHhlTLwpLDQhpHwTwBLSfvzSZZsvVsqCGqzZSfCvVG\n" +
            "WNdtmjPjcWdWJWntcWbjzmFzrrVrzsGzsVsSVrZZ\n" +
            "PbJPntMRbbdJbcNPcNFjnhlwwgpDHRBpggTlQThhpQ\n" +
            "mJvRGHfWmvWJJVmZZnZVffpglGggrTLNzLwNLrszzNpz\n" +
            "FqFMMShqjcMcqPbbjPthNgRggPgLwPsgLgszwNpl\n" +
            "DFQqQMhRhDRmWndDnJvmWW\n" +
            "jVzfvzSVpnnNSGjjVpNlSNDzqBBmWCBtWWtfFFCCmPmJCCJW\n" +
            "HLrRLhwrMZbHrWqWBhGPCGBFJW\n" +
            "wHHMRMQRQrcQRTTcHrwwRcQbDnpvnppzGSnvnSNzDSNTpjnS\n" +
            "qzrgfppGzPDJHfbZbHZn\n" +
            "vTsMvMTclhNlFlFhdhdqHHmHJSJDVJnJFFwJHHDn\n" +
            "slccWTTTcdCcCqRQPrzgBWPPRz\n" +
            "thfHHdDwbnVzwwdthZlqjZmmTmjfZcfMQl\n" +
            "sGFGJFFvGpFPCJvLPGPgZlpmlTMcmlmZrmMjcr\n" +
            "sJGLSWRSPBBCCPRFWPsNBNwMNNVMNwBzzMDhnh\n" +
            "RwJMwdbzMGWbLtLVQpPl\n" +
            "gqNfBmBjNmcCqjqjQllWhhQlgDQtpWlh\n" +
            "cfccjmcNmHrHBmCBcTMGtTJtZzrTvddRGR\n" +
            "vbbvqMhcrqMQQLHHvFvHHvpPlnPLfVfPnfmwsNwwwlnVls\n" +
            "ZdBZZgDRDzBRJWBzzDZjDDNWNnNnPfwNPwmSwlnCnfCW\n" +
            "JgRggTDtZmmbbFqrvT\n" +
            "lSgzfSzgGcNfDPsbMpspbPnnrrVV\n" +
            "FmWFBFQHBJJBmmWJFHWFrwtsVrMbnrVVwwwpWMMp\n" +
            "FFmmJmvZjQBRQRRQZQBvNNglRhDNDffDSDSMGlDD\n" +
            "VQPBCZVfHQZGRVVpmzPFmgSgbSPTFb\n" +
            "NcwLjcWnFhCpLvCF\n" +
            "tNCDtsqltDwtWdncJZVJVRMGdBQffHZH\n" +
            "pTzgPsLQfMLqTVFLGbVbbFVJVF\n" +
            "ZnjgjvSwNNbFJVwN\n" +
            "jWcCnWHWRvWRHHnWRWjvdZnZtspMqfzrMqfQtTPQgfPzfzcM\n" +
            "CTqHMNSSVnpjNSTFzMwPdslwnlPccbblgcbd\n" +
            "WDLqvLQRfLBgbJPwlWgdPd\n" +
            "QRBqqDmZZRBGGfCTpCCSMSmzjSpz\n" +
            "bPlRhmnPhTwhrvrlRrjgLjgsLpszFldgFlgF\n" +
            "tGHWfcQHWfLZnsLQnjpn\n" +
            "cVGtCtGGcNWcWtBStqnWrwmvmbmJwJPwbRBhRRMb\n" +
            "BjVTVfBsLlLjLcBcZDRJpnJRDPRJqlPRqJ\n" +
            "SzbQMQzFgfFzmMSrbzGpqqRDtqmnvDHtvppHDm\n" +
            "CrSQSdgrWdbFQCWggjWZTfBWcwBcTVBjTs\n" +
            "RtqdCqCTbRfRbbHR\n" +
            "FhwWWqgGJJgJHLHPFFsDbsFP\n" +
            "MrpmmwqhMmJMwpvlNvtlTrvtZSSr\n" +
            "VscvcmcmbhDrRMCCJlqnSlJnSljR\n" +
            "FWdwWgpZgdBLTgTWFwZBgWpjbCNqPptCSlNCStnSJJNPPJ\n" +
            "FdFWGgWTQGGbGvvDHDHzMD\n" +
            "WhhBJrBqBchcQBBqcqqGRZRlrtStlSlRszlzSSRl\n" +
            "fHdwgdjbNCbCCHNgPgHNPNplSRtQtltlRDZsQfZsZMRQMR\n" +
            "jQbQNwVNvWFJvqcV\n" +
            "bjbmmgSjwTWqWwWqcw\n" +
            "sQGfPZQDPqMMWWWd\n" +
            "fqBDfqqZZGHGDsNLjtmlttpgBllpJt\n" +
            "ZDmCWtftfWBLfRDWwbhqcNNtqwjtjwqt\n" +
            "SnTTsnlPMTlSSsGMMSddSbHjhwJwwjPbcvHwLwcqjj\n" +
            "GrFGzSgnTzLgDVfQfQrrDDfm\n" +
            "PngprCCmcBDssRFBSbFRRs\n" +
            "fjwHtjfNWfGwHfdtjGMdWSSdQTsQRLFSSslPSFTRlS\n" +
            "jGjMwMffWHNZfhwnDzqCpZDgrqCcPr\n" +
            "qzGPbzbDZGSPvpvrTvQsQwLWWNLj\n" +
            "tFddBhgnVnMMhBhLJWLwjQMwMrMLwT\n" +
            "BHFtVHgtmlhRRZmSTDTpSq\n" +
            "ZwzLWWWvWdSJdJQwQLzBqqbbhhCcNzchqCNPhb\n" +
            "rHfDRfHGfHsGTPPmhmrrNhjmNg\n" +
            "GlfsfRTfsfRtsstfDVHpGsPSFQJSWQMJwdSLwQWpZZLd\n" +
            "vnvJvpJtQwDBTljHlLHhDL\n" +
            "zzGqMwqMqbfRfVGzFmLmLTLddjmTSRLBBB\n" +
            "zGfrbqzwNvPPcCtr\n" +
            "jwCwSgvPSmCwSqwgbCRQGvsRVnddGZdflsfB\n" +
            "MhzHLWpMWHHzNzMccDHdnZVZRZRGQnGlGRGLsZ\n" +
            "nccNHTzWHDcMWHcphpptDrcDJmSgFTPjgPFjTjgSbqJSJqbg\n" +
            "bVhPWqBBbdbdPqVVqhSfpcmFsfwLnmmjnfBFmn\n" +
            "TDWDGzgRvrNJJJrzzzGspwpjncsncFmwFmsNfw\n" +
            "vMDgDJRWgDJtHDJMMPQQMdQlqdlhZZQbbC\n" +
            "SpdpQqLwrDcmPhggcS\n" +
            "ZHCZstHMhjGmtPDc\n" +
            "NNnnRHMZNzTMHZZTTsZMvvRhJJwWzBVLVQJJqWwVhwJpdJ\n" +
            "mrlMQlQPPPhhCbZRNpRZcffmFmgc\n" +
            "VvJVJqDqvqjDqvtVttVSHTTHLLcggBNBBSRRFfRLncfFLpBB\n" +
            "jHVHvdDHtJjtDWjwMhWwhwwwlNswPr\n" +
            "MJvzvFLhbTnJCvRwWSTmSWWWmRpc\n" +
            "tlVlNqBsVNNBQPrWgqmcgfwpcWpdcg\n" +
            "ZBjHPsttQrPrrVsBQpVJzhZhvnnbMMLvFJJZMJ\n" +
            "hBfJffJJNhnDlmQdnmSGcd\n" +
            "sQrCpRsPCrwFZQprpQCzljdjMMjMGGdGSmgSFFDS\n" +
            "zZpzQpwzHRPPTrQwCpRzWZHqLVvtBJvbBtVJhJLhHtLbVv\n" +
            "DsPnQGnnwlVJbSsb\n" +
            "HCfCfTDMTfHvCWMZDcRVVSwpbtlhVZbhhpVllp\n" +
            "TmCMTvfjRCCvcrgNNPQDmNzrLF\n" +
            "ghwNtnMMRTZtwTphjjBQfLJjfJFdSBTL\n" +
            "lldzbqzrCrfLJJBBbSWj\n" +
            "DCvlvqvshNhRndGs\n" +
            "rWwWWDJWWrFLdRWtRhFZTCbCSqThFTCbmm\n" +
            "BgMvSzvMpVpBlQNQVgfqhhGCbGbThQZTcbZTCs\n" +
            "nMpfjVMnzlgRSrnHnwdSDH\n" +
            "blFhFgFgPLvjDwNvWPnD\n" +
            "qMBzMCCzZMzJHRrzMFZsnFjQdZnvvNvvWQ\n" +
            "FzpMpGMRrlSSghLhtG\n" +
            "hDlVfDdSTjTJwjMTZT\n" +
            "HgnqtGgQRgRHGtrgqgSZJCrwBZZCrZwWJWjMWZ\n" +
            "zqRbGNSbbGRRQGRQFzddfVDLVhhfhddV\n" +
            "JwhLdLNLbwmJggCbbbhjHnDQNZWQWQjWZZPlHQ\n" +
            "GStzfBFzBMGMftpGcFFQDDjDQfZPfnnmDPfZZj\n" +
            "FqMBtFstpcTMBMSBGSBtqMhrwJLLTCbLhJbrhTCmrChv\n" +
            "WwWnTNVBNvWwBngdSqdRJJzncLSLpc\n" +
            "HPMZlGZQGtQjPdpqScpdjP\n" +
            "GltlGDDCMMplHCDphtbCHDwmWNBgVgvWhrmWssTBwWWV\n" +
            "clNNclslcLVWBNlGcVvdSHQvTMHZZSdsdQHM\n" +
            "gGhfpRwRZHMdJgZJ\n" +
            "fnDrpDtDrrWGcWVW\n" +
            "zdVzgdPSWRsHVzPsRRPHRHRRntnQrbDmfDfwfQwwZwfnbgMD\n" +
            "qNCJvjNLqjNhBBGjBvchhBCqffbffDGMnbwtfnbmQwQnZQMt\n" +
            "jccqJBvCjqvLTLJhJZpsPdSVdPszPRFssT\n" +
            "lDLvltDpvSpqGjVVMljGjW\n" +
            "zrdnswzcSzCgrdnBBjVcBBcjWTVTGb\n" +
            "PZgFdgHHnrdNDPvvtfNQSJ\n" +
            "GlLFbFNFtzcvddVpJVfGsCCC\n" +
            "PWhhMgWTTnhQrqMHTWqwddCVjSwQJddpBdQffp\n" +
            "WqJZDHPWgJrHnPqhnnqLbzzcLmbFDNmcbRzbbN\n" +
            "vtDcSfcWfmfTSGwvGDwTvFZVppsszCsVVVFjVzSVSM\n" +
            "NrrLPhdBRJLbPhrrRJwhBFZsFVzQzszsZzMCZjsJQF\n" +
            "glgwPqPhrRqPqBdNLwBrLRtnGHnDGmDqHWfGWfGcncHH\n" +
            "BtSfgpgvQhlSlwzZ\n" +
            "VHRmVzMPdPVRmcdhQwQwhClNNNCb\n" +
            "PcPMRWrVRRHTMDRVLPVzBnnJprjppBJtJftvpBfp\n" +
            "RpgBRVpLgBpDFCCPPVGvPSVVvb\n" +
            "dHrMdlWwwljjrlHrqmWjmWlGNvNSBBNhhSCSbSvNtNvQGd\n" +
            "TfmjqrwqHmqHrqlHwHpgfZFBzJgpZnpDcDBZ\n" +
            "NWTdFWlSMMMWTzVzdQfVpVDwwf\n" +
            "RHrrGrLqJLBqgpDgQfwfffHz\n" +
            "cssRRsBjvrGRjLBLrZcBvBqWPQNnlWTmSnjFllWMnCTFll\n" +
            "DCCDbHDhgbtCLHFHCQdQdSVfbNMdnfcSMS\n" +
            "ZZjPsqRZJlJlGZPTTqqRwJjZQVnMszVfzdSVScQQSQcNQNfM\n" +
            "mlGJJqmZjBZPhLBrgrWHFnDL\n" +
            "wLpCpDmmLwplgwVLwLwVgLLbWWJvJRTsRvbbJWCRsfbssv\n" +
            "FHHPFZnnhZQrqTTlSJRSrlfvrv\n" +
            "llZlPQFcZZHchjhjPqnjNFqNwggmDDwVNBBDwtpGMVDwDwVp\n" +
            "CctttjCrftNrBZpPgpgbNqdq\n" +
            "JhMwhMTGhMVhwDDMJJHGJJJBldWggWglddlbqlbPHbfqgf\n" +
            "DvJRMJVVJMTfJtnrnRjCSRFnrL\n" +
            "snDPGSQPnSSQQFwFFdzWFvmCVmmnjmCJjHjbZZhHZp\n" +
            "clgrgrMrRfqRlNggmhmHrhvVbpCjCVvV\n" +
            "fNgcBgqqLMqRqgLggtcTftBFdDFWQzDSQWPPGwWpwtGGsP\n" +
            "wSJWDCbwVdQfbffHfZZr\n" +
            "glgTBzzPSFhLFRvRQnZspZQpnvRp\n" +
            "qTLqglLNFqBqVMJqwwMVcS\n" +
            "rCWNCsrGrGGHrwQQHrfNDfvgLmmvMmLLMpmLvLPpPgww\n" +
            "djcdVdqJJcqqBstdBczbStThPPMPghvSpRgmlvghlmLpLp\n" +
            "qtjdBqzbTTtzTJTzVnbBdsNfDHZGGGDDnGfNDHDHFZFD\n" +
            "mlzzVHZmzvHflTJHqlJcZTvdcdCCPnddFGhPdBGhMFGCGc\n" +
            "QDRrWSprdqqCqDhF\n" +
            "NWtQNRrgWjpLjLsrRrQpfwVVqvwHzvvmVszlvlvm\n" +
            "DmDDtBDStSLcjLBDhhhmfnNFNlJJMFWFHSMWFpJNHp\n" +
            "PgMCgVgsCvVwRVRCwvgTzCMRWWwdnWHpNHFwWJJnHdHpprnp\n" +
            "RgZvvMbsbPCRGRTVPGmfBqDDqmthDQcmcZDc\n" +
            "WrfWpwwCwpdWCMBzqbtpjVbqzVqp\n" +
            "RvQQSFJNFZNNLPGbMMPqGtGPzF\n" +
            "DRvmNhZvJZmNmLcDZQcQNRfnnTMwrMHnfTrTCslsclCn\n" +
            "httbcnSsgtVMsnssnzghmmHvNmlHVLBHBLrVGGLN\n" +
            "QFpjZqpqWddZjjDWPWPwjFpfGLBfBBrrNLlBBgGrLCLmrfBB\n" +
            "QRjRjwjwDhbRTJnhgR\n" +
            "FTBTZqFVJnVTTPBTVmFbNjRffzrRrNQrPNQbzh\n" +
            "tCWwHMLCLDstlzdjwbzbQhRl\n" +
            "GvtChDChvtGSnZqnTVvBVF\n" +
            "spnFVspFPScprWrGvTpTWpvW\n" +
            "CgMqCqPLfqBBJGHlMrrJrWWl\n" +
            "ChjqhCtgdLPSQhQsRnVQ\n" +
            "bCQVZCJcrSSStrWTdhQqhzzMdhMz\n" +
            "lPDwNfgpDfBNgfnlDPRDpLWRhLbMjzWqMqWsMLLhLz\n" +
            "wpNPgPwwBDfvBnfgBfwglHDCJmtFGFmGSmCVrVCGbrCcFv\n" +
            "zNMJCHVJQmNLQFhZ\n" +
            "PPRPdGcRdPPjfjflqdjPDPTZQrhTFZFrmQZQBGZCFmLL\n" +
            "CcWfjjgWtjtMJWzVnSJVzJ\n" +
            "LjhDjVCVsjNfMsMQ\n" +
            "SdRpGSndZnlgpdSFtrQMtqNZJtwrMfQQ\n" +
            "cdRpcpnggRSmWpcLDHCCHfhBmPHTCV\n" +
            "zpmsJlptmfNwwFswGHThRcTqqHqhhWCWzh\n" +
            "SLgLMMgnPbSLPbPMDqZZcTWCnZWtRcWCZC\n" +
            "MbbvQtMVSLVrDMvSMSvSlwNsFNJspJFfNNmJrGGf\n" +
            "wvcQjfjQvQDJvwNwRdpRScCHbpdMbSpl\n" +
            "rfrZzrzWWmzlRpMMdpzd\n" +
            "LqrmFrVhFJjNfFfw\n" +
            "fVflVfmjQtZhzdrdlN\n" +
            "HwLLJvCcpcbRvDwpDvDCpqtTPPMNWTzTrHZTMPzPMPdH\n" +
            "LbvbJqgcqbpJLwvbbbmsmgVGmQmnjdSfSVjV\n" +
            "FngtfmfTTSFjFDnfjDbwnGzzGBGzbVRwVcwz\n" +
            "WWMrLLZLvZMWsrCcjzBGcpzLcGcVcB\n" +
            "NhMWllrsNZNrWZWhjCmmSmfgSTFDHTJfFSNq\n" +
            "lpqpqlhTSZqfZlwthPHsHcdHPhsCHLrP\n" +
            "zVDTjMgFbscczPbz\n" +
            "jRRmvmngNngqTZBqNlftTJ\n" +
            "wrMrJZPPrNZPZzhzMFPlDqSllsLSbWDWlWqNbb\n" +
            "VpGftgghtgQfVBgdnpBBngtWDSRbbSqltbRblDDDtqSlqS\n" +
            "gVggVgpVHTpmndffdVQVTVggjMwwjjMCjJFhPvZMwHvzMzjC\n" +
            "CtQPCFVlljWrNhTmCgLL\n" +
            "zsZbsnsqbMznDGNrrTqTLqWRHghN\n" +
            "zsMMGMSssSSzMGGMcvDGJFphFwPPvPvQfJppwQfj\n" +
            "njfVlRDDfDwHSfwVwSLnQZqGBbGsnZBnbGqZMbbpGG\n" +
            "zvddNNdWFgTPFgWNvNgcZqZbbqMMgBpsZrRZpgGG\n" +
            "CPchdcRTcNvvTWcmTNDSSfjwSDHCfQwlJLHl\n" +
            "LPmccvvFzzLvvQSzlFvFSSQDDtDfdDVdnDTBDsVTjDndlV\n" +
            "CbgNZWgZrbbqhrgTnVjjCsGdBfCfTs\n" +
            "BhwRrNrpQvLzvJSw\n" +
            "DpGFVsprFpTBJjsnJnnhdjWh\n" +
            "fbHCcbVHCgfMLwcqfLwgNdqhjRhnJQQdtQWnnSSJJj\n" +
            "gCZNVNzbHbfNHcHNgfCMLHHzPBDPvPDrlvDrDlvpmFTFBF\n" +
            "tsBQFgFpFBfsmtLjtgmtrQvCddSwSCwwbRvbwdLvwvRG\n" +
            "nqPZnMznTZHZlZPfGCHfbHwNVwdRwC\n" +
            "MPWqqzhZmBWFQfFW\n" +
            "FNMTTwqwNpVWPgZFFQ\n" +
            "crScdztJtcccSzWtzzzbStZQRZVVVHZVRgRQPHQhhjSZ\n" +
            "lCDCCdJJdbCdbcJzrcnrJWbnLLlvMMTLNwwMvfvwvMmNBNMG\n" +
            "WHsJMlBHCscDPDPtPBRDrL\n" +
            "jmTvgnqdsbPmSrrPVrwL\n" +
            "pdTgjgqbTqQFdjjQdqTZzCcJsZzQzcfsCCHMMl\n" +
            "QqMQGbMGGGzSsQSqCPcCPrCRNNlSZllc\n" +
            "vDHdmDWTdmwphhDdJwWvHdDCZPZVllPVRPRZNPVcZbTBZN\n" +
            "pmWHDmpmLgJvhvLpmvdvLWbsMgfsQGjqjtsnGfGqzGzzzQ\n" +
            "tFvMtFtFMvDDtMvLTpffQWWSGTsDTlSS\n" +
            "jqVnBjHqhPHbnhqPqWllfpfSTplQPQPGff\n" +
            "bbjHVHdjzqBznqVHBHzzqVFMJNMvmJtvtmcQFMZQFdJL\n" +
            "dcldCJQnldtTMdsccThhDDDDFhwTqDRwHR\n" +
            "ZbGzmgZSBpPPmmbNbZmgmNPPRqFzzVVhrwVHwRVHrVRHRRrR\n" +
            "bSSNmhPGWWZgQtLWtlCdJCMd\n" +
            "ttGBGNNgBgVBltlTJGJZpZlHSHCHfDSWpRWWpS\n" +
            "LhcLrcFFqdhLFLqvwMdhcPWpHHSSZWjjjCDwSSSfpWpD\n" +
            "fPMrqMMnqMFMbqcfnPMMBsgNttgggBmzJzbmGtbb\n" +
            "fjFhHHHmfjtLjrFmPhLbCdzBCpPCJQpJJGzJCp\n" +
            "RcDTnvlVqRnvnvRNcSzCJGJGCSJJCCdQqw\n" +
            "NTlMZVVlVVVlRTDTNjgGLfhrmgLFfZFGhr\n" +
            "GmbVGWttmpmbbqDWgVGGGtWNvNCCsHLLFsvHMHHLFnFn\n" +
            "wQQSdDTfSTsLCNnFwvFv\n" +
            "dPDBTBjzDftcBqBVbGBg\n" +
            "LmsfRLwCfZslcjljcjDjwN\n" +
            "gdRSrHHrSbdrggBzHBShHlqVvVDvcNvlcccjGlGjqB\n" +
            "zgTnSFFJdngddTZTPTWmspWQWWPR\n" +
            "RMZMtdsVCsRdddbsVcfcqgNfNDqGqGfzPzmf\n" +
            "BpwQrJvrjnSnQpBBBJCJjBBQlzvmDPzmDmglPzPgDNfNmNgz\n" +
            "LjLTnSpwjQTrnnLCBJLQjhstbMhsRtTdtMHMtbtsZd\n" +
            "PfrPHmrCRmRhcHCcmCfhhmWMLVpwVqFvvGGLVpQSwwSvSFFP\n" +
            "sJnjsgsDDdjjjdTglTgDBsBnSLdvwSqpQQbwQSLLLFSpQpbL\n" +
            "tBlngnqgqZggTZWfCRZmMCHHmM\n" +
            "LGGPQLDLPWmQLVdVdLLGbdvMNjfvHNFNNBbZnNMlHlBf\n" +
            "CshzsJBqTTwhttzCJzRtcNcMljnnnMjHlFnMcvnHfM\n" +
            "gqJsCwzBrQWDSgGmSS\n" +
            "FWVzVJjmbbJVpPwjjJDQsQNDgtcrWtddDQMg\n" +
            "TqRqCfGGBTzgTzDNNs\n" +
            "qRffnhhGvvvpwbvFzp\n" +
            "gLmMTpTCmRhgTLhCCZBSScJFQQQclWWMQJSJQW\n" +
            "rvfbDGjGssqbbrRSJJWclqcSwzwScc\n" +
            "PsDfGfVRjfTTTZNBPTZT\n" +
            "hWqrPzzMhrfmfdNtdZLNrnGndn\n" +
            "SwvwSFslbbjRsspQwsRwzcnbnNdTnZDbGctZdTNtNt\n" +
            "wvJJFsvpSSvJFjlHjzplQwJhCfVVhmBmVWhHWmWVWqBqMW\n" +
            "GjQtgjhPhGgsQjgtthrrvBlvljCrpCdlqBMb\n" +
            "RFDHDRFRczzlbqlbvqvHdb\n" +
            "DDFcRWTWFbSwRWbGtSGtgPfGGSPPtg";

}
