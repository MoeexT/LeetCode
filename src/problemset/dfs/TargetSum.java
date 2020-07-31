package problemset.dfs;

/**
 * Problem : 494 https://leetcode-cn.com/problems/target-sum/
 */

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        /**
         * https://leetcode-cn.com/problems/target-sum/solution/c-dfshe-01bei-bao-by-bao-bao-ke-guai-liao/
         * 777ms 8.32%
         * 37.2MB 5.03%
         *  */ 
        
        return dfs(nums, S, 0);
    }

    public int dfs(int[] nums, int target, int left) {
        if (target == 0 && left == nums.length)
            return 1;
        if (left >= nums.length)
            return 0;
        int ans = 0;
        ans += dfs(nums, target - nums[left], left + 1);
        ans += dfs(nums, target + nums[left], left + 1);
        return ans;
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
    }
}
