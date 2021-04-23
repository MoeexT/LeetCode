package problemset.array;

/*
 * @date_time: 2021-03-19 13:52
 * @author: MoeexT
 * @problem: 75
 * @url: https://leetcode-cn.com/problems/sort-colors/comments/
 */

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, cnt0);
                if (nums[i] < nums[cnt1]) {
                    swap(nums, i, cnt1);
                }
                cnt0++;
                cnt1++;
            } else if (nums[i] == 1) {
                swap(nums, i, cnt1++);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        solution.sortColors(new int[]{1});
    }
}

