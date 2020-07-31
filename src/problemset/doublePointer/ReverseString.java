package problemset.doublePointer;

import java.util.Arrays;

/**
 * @date: 2020-04-01
 * @time: 19:59:45
 * @author: MoeexT
 * @problem: 344
 * @url: https://leetcode-cn.com/problems/reverse-string/
 */

public class ReverseString {
    /** 
     * @time: 1ms 100.00%
     * @mem: 46.4MB 97.44%
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i = -1, j = s.length;
        while (++i < --j) {
            s[i] = (char)(s[j] + (s[j] = s[i]) * 0);
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] arr = new char[] {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a' };
        solution.reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }
}
