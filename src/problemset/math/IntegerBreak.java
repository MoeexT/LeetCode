package problemset.math;

/*
 * @date_time: 2020-04-11 22:59
 * @author: MoeexT
 * @problem: 343
 * @url: https://leetcode-cn.com/problems/integer-break/
 * @url: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @url: https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */

public class IntegerBreak {
    /*
     * @help: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     * @time: 0ms 100%
     * @mem: 36.4MB 100%
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int N3 = n / 3;
        int A3 = n % 3;
        if (A3 == 1) {
            return (int) Math.pow(3, N3 - 1) * 4;
        } else if (A3 == 2) {
            return (int) Math.pow(3, N3) * 2;
        } else {
            return (int) Math.pow(3, N3);
        }
    }

    public int cuttingDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
//                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        System.out.println(solution.cuttingRope(10));
    }
}

