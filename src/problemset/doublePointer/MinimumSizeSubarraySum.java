package problemset.doublePointer;

/*
 * @date_time: 2020-04-03 18:12
 * @author: MoeexT
 * @problem: 209
 * @url: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */

public class MinimumSizeSubarraySum {
    /*
     * @help: https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode/
     * @time: 2ms 88.54%
     * @mem: 40.1MB 5.06%
     */
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i+1-left);
                sum -= nums[left++];
            }
        }

        return (res != Integer.MAX_VALUE) ? res : 0;
    }

    /*
     * @help: https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-43/
     * @time: 2ms 88.54%
     * @mem: 39.8MB 5.06%
     */
    public int minSubarrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int low = 0, high = 0;
        int sum = 0 , min = Integer.MAX_VALUE;

        while (high < len) {
            sum += nums[high++];
            while (sum >= s) {
                min = Math.min(min, high - low);
                sum -= nums[low++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}

