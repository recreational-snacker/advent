package advent2017;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventDay2Test {

    String input = "5806\t6444\t1281\t38\t267\t1835\t223\t4912\t5995\t230\t4395\t2986\t6048\t4719\t216\t1201\n" +
            "74\t127\t226\t84\t174\t280\t94\t159\t198\t305\t124\t106\t205\t99\t177\t294\n" +
            "1332\t52\t54\t655\t56\t170\t843\t707\t1273\t1163\t89\t23\t43\t1300\t1383\t1229\n" +
            "5653\t236\t1944\t3807\t5356\t246\t222\t1999\t4872\t206\t5265\t5397\t5220\t5538\t286\t917\n" +
            "3512\t3132\t2826\t3664\t2814\t549\t3408\t3384\t142\t120\t160\t114\t1395\t2074\t1816\t2357\n" +
            "100\t2000\t112\t103\t2122\t113\t92\t522\t1650\t929\t1281\t2286\t2259\t1068\t1089\t651\n" +
            "646\t490\t297\t60\t424\t234\t48\t491\t245\t523\t229\t189\t174\t627\t441\t598\n" +
            "2321\t555\t2413\t2378\t157\t27\t194\t2512\t117\t140\t2287\t277\t2635\t1374\t1496\t1698\n" +
            "101\t1177\t104\t89\t542\t2033\t1724\t1197\t474\t1041\t1803\t770\t87\t1869\t1183\t553\n" +
            "1393\t92\t105\t1395\t1000\t85\t391\t1360\t1529\t1367\t1063\t688\t642\t102\t999\t638\n" +
            "4627\t223\t188\t5529\t2406\t4980\t2384\t2024\t4610\t279\t249\t2331\t4660\t4350\t3264\t242\n" +
            "769\t779\t502\t75\t1105\t53\t55\t931\t1056\t1195\t65\t292\t1234\t1164\t678\t1032\n" +
            "2554\t75\t4406\t484\t2285\t226\t5666\t245\t4972\t3739\t5185\t1543\t230\t236\t3621\t5387\n" +
            "826\t4028\t4274\t163\t5303\t4610\t145\t5779\t157\t4994\t5053\t186\t5060\t3082\t2186\t4882\n" +
            "588\t345\t67\t286\t743\t54\t802\t776\t29\t44\t107\t63\t303\t372\t41\t810\n" +
            "128\t2088\t3422\t111\t3312\t740\t3024\t1946\t920\t131\t112\t477\t3386\t2392\t1108\t2741";

    @Test
    public void testPart1() {
        String[] linesToProcess = input.split("\\n");
        Integer checkSum = 0;
        for (String line : linesToProcess) {
            String[] numbers = line.split("\\t");
            List<Integer> list = new ArrayList<>();
            for (String n : numbers) {
                list.add(Integer.valueOf(n));
            }
            Integer max = Collections.max(list);
            Integer min = Collections.min(list);
            checkSum = checkSum +(max-min);
        }
        System.out.println("CheckSum: "+checkSum);
    }

    @Test
    public void testPart2() {
        String[] linesToProcess = input.split("\\n");
        Integer checkSum = 0;
        for (String line : linesToProcess) {
            String[] numbers = line.split("\\t");
            List<Integer> list = new ArrayList<>();
            for (String n : numbers) {
                list.add(Integer.valueOf(n));
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i!=j && list.get(i)%list.get(j)==0) {
                        checkSum = checkSum + (list.get(i)/list.get(j));
                        break;
                    }
                }
            }
        }
        System.out.println("CheckSum: "+checkSum);
    }

}
