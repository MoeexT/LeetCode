package problemset.dp;

/*
 * @date_time: 2020-05-06 14:41
 * @author: MoeexT
 * @problem: 983
 * @url: https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */

import com.sun.deploy.util.SyncAccess;

import java.util.Arrays;

public class MinimumCostForTickets {
    /*
     * 评论中的状态转移方程：dp[n] = min(dp[n-1] + cost[0], dp[n-7] + cost[1], dp[n-30] + cost[2])
     * @time: 1ms 97.22%
     * @mem: 37.9MB 100.00%
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length + 1;
        int[] Days = new int[len];
        System.arraycopy(days, 0, Days, 1, len - 1);
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = Days[1];

        for (int i = 1; i < len; i++) {

            int pre1 = dp[i - 1] + costs[0];
            int pre2 = dp[furthestIndex(Days, i, 7)] + costs[1];
            int pre3 = dp[furthestIndex(Days, i, 30)] + costs[2];

            dp[i] = Math.min(pre1, Math.min(pre2, pre3));
        }
        return dp[len - 1];
    }

    /**
     * 从 nums[i]往前搜索 nums[j], 满足: nums[i] - nums[j] + 1 <= x
     *
     * @param nums 数组
     * @param i    起始位置
     * @param x    范围
     * @return j
     */
    private int furthestIndex(int[] nums, int i, int x) {
        for (int j = i; j > 0; j--) {
            if (nums[i] - nums[j] + 1 <= x && nums[i] - nums[j - 1] + 1 > x)
                return j - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumCostForTickets solution = new MinimumCostForTickets();
//        System.out.println(solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
//        System.out.println(solution.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
//        System.out.println(solution.mincostTickets(new int[]{1}, new int[]{2, 7, 15}));
//        System.out.println(solution.mincostTickets(new int[]{1, 7}, new int[]{2, 7, 15}));
//        System.out.println(solution.mincostTickets(new int[]{1, 2, 3, 7}, new int[]{2, 7, 15}));
        System.out.println(solution.mincostTickets(new int[]{1, 2, 3, 6, 7, 8}, new int[]{2, 7, 15}));
//        System.out.println(solution.mincostTickets(new int[]{1, 8}, new int[]{2, 7, 15}));
//        System.out.println(solution.furthestIndex(new int[]{1, 4, 6, 7, 8, 20}, 3, 7));
    }
}

