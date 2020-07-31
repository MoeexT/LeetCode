package problemset.dp;

/*
 * @date_time: 2020-05-03 12:14
 * @author: MoeexT
 * @problem: 53
 * @url: https://leetcode-cn.com/problems/maximum-subarray/
 */

import java.util.Arrays;

public class MaximumSubarray {
    /*
     * f(i) = max{f(i-1) + ai, ai}
     * @time: 1 ms 95.72%
     * @mem: 39.6MB 40.45%
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /*
     *
     * @time: 1ms 98.51%
     * @mem: 46.5MB 100.00%
     */
    public int maxSubarray(int[] nums) {
        int pre = 0, max = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }


    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}

