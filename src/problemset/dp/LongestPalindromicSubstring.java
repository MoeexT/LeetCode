package problemset.dp;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    /*
     * 中心扩散法
     * @time: 13ms 91.86%
     * @mem: 38.5MB 79.77%
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int begin = 0, ml = 0;
        char[] chs = s.toCharArray();
        for (int i = 1; i < len; i++) {
            int l = diffuse(chs, i, true);
            if (l > ml) {
                ml = l;
                begin = i - (l >> 1);
            }
            l = diffuse(chs, i, false);
            if (l > ml) {
                ml = l;
                begin = i - (l >> 1);
            }
        }
//        System.out.println(s + ", " + begin + ", " + ml);
        return s.substring(begin, begin + ml);
    }

    private int diffuse(char[] chs, int center, boolean even) {
        int r = 0, mr = 0;
        int len = chs.length;
        if (even) {
            while (center - ++r > -1 && center + r <= len && chs[center - r] == chs[center + r - 1]) {
                mr = r << 1;
            }
        } else {
            while (center - ++r > -1 && center + r < len && chs[center - r] == chs[center + r]) {
                mr = (r << 1) + 1;
            }
        }
//        System.out.println(String.valueOf(chs) + ":" + center + ", " + r + ", " + mr);
        if (mr == 0) return 1;
        return mr;
    }

     public String longestPalindromeDP(String s) {
         int len = s.length();
         if (len < 2) return s;
         boolean dp[][] = new boolean[len][len];
         int maxLen = 1, begin = 0;
         for (int i = 0; i < len; i++)
             dp[i][i] = true;
         char[] chs = s.toCharArray();
         for (int j = 1; j < len; j++) {
             for (int i = 0; i < j; i++) {
                 if (chs[i] != chs[j]) {
                     dp[i][j] = false;
                 } else {
                     if (j - i < 3) {
                         dp[i][j] = true;
                     } else {
                         dp[i][j] = dp[i+1][j-1];
                     }
                 }
                 if (dp[i][j] && j-i+1 > maxLen) {
                     maxLen = j-i+1;
                     begin = i;
                 }
             }
         }
         return s.substring(begin, begin + maxLen);
     }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babab"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cc"));
    }
}
