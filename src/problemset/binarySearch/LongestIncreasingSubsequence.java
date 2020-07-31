package problemset.binarySearch;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // https://leetcode-cn.com/problems/longest-increasing-subsequence/comments/284831
        int[] res = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0 ? -idx - 1 : idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        int r = sol.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
        System.out.println(r);
    }
}
