package problemset.string;

/**
 * @date: 2020-04-01
 * @time: 18:26:24
 * @author: MoeexT
 * @problem: 14
 * @url: https://leetcode-cn.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {
    /** 
     * @time: 1ms 80.43%
     * @mem: 37.8MB 25.71%
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int col = Integer.MAX_VALUE;

        for (String string : strs) {
            if (string != null && string.length() != 0) {
                col = col < string.length() ? col : string.length();
            } else {
                return "";
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < strs.length; j++) {
                // System.out.println(j + ", " + i);
                if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[] { "aa", "a" }));
    }
}
