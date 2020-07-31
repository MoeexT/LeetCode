package problemset.hashTable;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        /**
         * 11ms 19.96%
         * 38.1MB 5.25%
         */
        int count = 0;
        boolean odd = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int value : map.values()) {
            if (!odd && value == 1) {
                // System.out.println("1: " + value);
                count ++;
                odd = true;
            } else if (value % 2 == 0) {
                // System.out.println("2: " + value);
                count += value;
            } else {
                // System.out.println("3: " + value);
                if (!odd) {
                    odd = true;
                    count += value;
                }
                else
                    count += value - 1;
                    
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome("bananas"));
    }
}
