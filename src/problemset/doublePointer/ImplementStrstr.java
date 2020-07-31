package problemset.doublePointer;

/**
 * @date: 2020-04-01
 * @time: 17:18:49
 * @author: MoeexT
 * @problem: 28
 * @url: https://leetcode-cn.com/problems/implement-strstr/
 */

public class ImplementStrstr {
    /** 
     * @time: 0ms 100.00%
     * @mem: 28.9MB 5.00%
     */
    public int strstr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        char ch = needle.charAt(0);
        for (int i = 0, len = haystack.length() - needle.length(); i <= len; i++) {
            if (haystack.charAt(i) == ch && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrstr obj = new ImplementStrstr();
        System.out.println(obj.strstr("hello", "llo"));
    }
}
