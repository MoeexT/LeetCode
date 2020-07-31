package problemset.math;

import java.util.Arrays;

/**
 * @date: 2020-04-21
 * @time: 15:37:54
 * @author: MoeexT
 * @problem: 1248
 * @url: https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */

public class CountNumberOfNiceSubarrays {
    /*
     * @help: https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/tong-ji-you-mei-zi-shu-zu-by-leetcode-solution/
     * @time: 6ms 85.63%
     * @mem: 47.7MB 100.00%
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] odd = new int[nums.length+2];
        odd[0] = -1;
        int n = nums.length, oddCur = 1, ans = 0;

        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) {
                odd[oddCur++] = i;
            }
        }
        odd[oddCur++] = n;
        for (int i = 1; i < oddCur - k; i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }

    public int niceNumber(int[] nums, int k) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int odd = 0, ans = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                odd++;
            }
            if (odd >= k) {
                ans += cnt[odd - k];
            }
            cnt[odd]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays solution = new CountNumberOfNiceSubarrays();
        System.out.println(solution.numberOfSubarrays(new int[]
                {1,1,2,1,1}, 3));
        int[] n = {0};
        for (int i = 0; i < 5; i++) {
            n[0]++;
        }
        System.out.println(Arrays.toString(n));
    }
}
