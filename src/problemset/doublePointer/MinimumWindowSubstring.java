package problemset.doublePointer;

/*
 * @date_time: 2020-05-02 12:36
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://leetcode-cn.com/problems/minimum-window-substring/
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*
     * 双指针，吞吞吐吐
     * @help: https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
     * @time: 16ms 65.79%
     * @mem: 40.9MB 6.67%
     */
    public String minWindow(String s, String t) {
        if (s.equals("") || t.equals("")) return "";

        // need: t's chars
        Map<Character, Integer> need = new HashMap<>();
        // window: window's chars
        Map<Character, Integer> window = new HashMap<>();

        /*for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }*/

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).compareTo(need.get(ch)) == 0)
                    valid++;
            }
            right++;

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d)) == 0)
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("vsasjvasbracavrars", "var"));
    }
}

