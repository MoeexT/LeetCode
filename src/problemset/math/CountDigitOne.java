package problemset.math;

/* 
 * @date_time: 2020-05-04 17:57
 * @author: MoeexT
 * @problem: 面试题43
 * @url: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */

public class CountDigitOne {
    /*
     * @help: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * @time: 0ms 100.00%
     * @mem: 36.6MB 100.00%
     */
    public int countDigitOne(int n) {
        int res = 0, digit = 1;
        int high = n / 10, low = 0, cur = n % 10;

        while (high != 0 || cur != 0) {
            if (cur == 0)
                res += high * digit;
            else if (cur == 1)
                res += high * digit + low + 1;
            else
                res += (high + 1) * digit;
            low = cur * digit + low;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        CountDigitOne solution = new CountDigitOne();
        System.out.println(solution.countDigitOne(1861351));
    }
}

