package problemset.string;

/*
 * @date_time: 2021-02-24 15:23
 * @author: MoeexT
 * @problem: 9
 * @url: https://leetcode-cn.com/problems/palindrome-number/
 */

import java.util.HashMap;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int len = String.valueOf(x).length();
        int pal = 0;
        for (int i = 0; i < len / 2; i++) {
            pal = pal * 10 + x % 10;
            x /= 10;
        }

//        System.out.println(pal + ", " + x);
        return (len & 1) == 0 ? pal == x : pal == x / 10;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1));
    }
}

