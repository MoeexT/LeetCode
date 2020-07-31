package problemset.binarySearch;

import java.util.Arrays;

/**
 * @date: 2020-04-01
 * @time: 11:38:34
 * @author: MoeexT
 * @problem: 1111
 * @url: https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    /**
     * @time: 1ms 100.00%
     * @mem: 39.8MB 7.14%
     */
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = seq.charAt(i) == '(' ? depth++ & 1 : --depth & 1;
        }
        return res;
    }

    public static void testCharArray(String seq) {
        // 9~10ms/100000次
        int[] ay = new int[seq.length()];
        int idx = 0;
        for (char ch : seq.toCharArray()) {
            ay[idx++] = ch;
        }
    }
    public static void testCharAt(String seq) {
        // 8~9ms/100000次
        int[] ay = new int[seq.length()];
        for (int i = 0; i < ay.length; i++) {
            ay[i] = seq.charAt(i);
        }
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTwoValidParenthesesStrings obj = new MaximumNestingDepthOfTwoValidParenthesesStrings();
        System.out.println(Arrays.toString(obj.maxDepthAfterSplit("(()())")));
        /* long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            MaximumNestingDepthOfTwoValidParenthesesStrings.testCharAt("123456789");
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1); */
    }
}
