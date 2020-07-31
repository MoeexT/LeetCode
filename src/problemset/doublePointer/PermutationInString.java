package problemset.doublePointer;

/*
 * @date_time: 2020-05-02 20:03
 * @author: MoeexT
 * @problem: 567
 * @url: https://leetcode-cn.com/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    /*
     * 从大佬@labuladong学（抄）的双指针滑动窗口方法
     * @time: 30 ms 43.04%
     * @mem: 40.2MB 6.25%
     */
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int full = 0;

        while (right < s2.length()) {
            char ch = s2.charAt(right++);
            if (chars.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (chars.get(ch).compareTo(window.get(ch)) == 0)
                    full++;
            }

            // right - left >= s1.size()
            while (full == chars.size()) {
                if (right - left == s1.length()) return true;

                char rc = s2.charAt(left++);
                if (chars.containsKey(rc)) {
                    if (chars.get(rc).compareTo(window.get(rc)) == 0)
                        full--;
                    window.put(rc, window.get(rc) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("abccc", "acbvccbvacoabcaobiau"));
    }
}

