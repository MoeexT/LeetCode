package problemset.dp;

/*
 * @date_time: 2020-05-03 17:05
 * @author: MoeexT
 * @problem: 322
 * @url: https://leetcode-cn.com/problems/coin-change/
 */

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return dp(coins, amount, new int[amount]);
    }

    /*
     * 自上而下
     * @time: 41 ms 15.08%
     * @mem: 40.2MB 5.77%
     */
    private int dp(int[] coins, int rem, int[] count) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (count[rem - 1] != 0) return count[rem - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, rem - coin, count);
            if (sub >= 0 && sub < min)
                min = sub + 1;
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    /*
     * 自下而上
     * @time: 12 ms 90.68%
     * @mem: 40MB 5.77%
     */
    public int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                int rem = i - coin;
                if (rem >= 0)
                    min = Math.min(min, dp[rem] + 1);
            }
            dp[i] = min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        System.out.println(solution.change(new int[]{1}, 6));
    }
}

