package problemset.string;

/*
 * @date_time: 2020-05-07 22:14
 * @author: MoeexT
 * @problem: 125
 * @url: https://leetcode-cn.com/problems/valid-palindrome/comments/
 */

public class ValidPalindrome {
    /*
     * 
     * @time: 4ms 74%
     * @mem: 40.3MB 4%
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = (char)(s.charAt(i) | 0x20);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                sb.append(ch);
        }
        len = sb.length();
        for (int i = 0; i <= len / 2; i++) {
            if (sb.charAt(i) != sb.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println((int)'A');
//        System.out.println('A' | 0x20);
//        System.out.println((char)('A' | 0x20));
    }
}

