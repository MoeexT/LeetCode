package problemset.doublePointer;

/*
 * @date_time: 2020-05-02 22:07
 * @author: MoeexT
 * @problem: 438
 * @url: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    /*
     * fuck
     * @time: 33 ms 43.39%
     * @mem: 41.4MB 5.88%
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.equals("") || p.equals("")) return ans;

        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int full = 0;

        while (right < s.length()) {
            char ch = s.charAt(right++);
            if (chars.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (chars.get(ch).compareTo(window.get(ch)) == 0)
                    full++;
            }

            while (right - left >= p.length()) {
                if (full == chars.size()) {
                    ans.add(left);
                }

                char rc = s.charAt(left++);
                if (chars.containsKey(rc)) {
                    if (chars.get(rc).compareTo(window.get(rc)) == 0)
                        full--;
                    window.put(rc, window.get(rc) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();
//        System.out.println(solution.findAnagrams("abacbabc", "abc"));
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
//        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}

