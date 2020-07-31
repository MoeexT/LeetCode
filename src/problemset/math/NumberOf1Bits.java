package problemset.math;

/*
 * @date_time: 2020-04-12 15:02
 * @author: MoeexT
 * @problem: 191
 * @url: https://leetcode-cn.com/problems/number-of-1-bits/
 */

public class NumberOf1Bits {
    /*
     * @help: https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     * @time: 1ms 99.61%
     * @mem: 36.8MB 5.62%
     */
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                ans++;
            }
            mask <<= 1;
        }
        return ans;
    }

    public int hammingW(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();
        System.out.println(solution.hammingWeight(00000000000000000000000000001011));
    }
}

