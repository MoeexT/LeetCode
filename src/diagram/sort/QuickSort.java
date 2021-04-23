package diagram.sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private static void quick(int[] nums, int left, int right) {
        if (left < right) {
            int mid = quick_pass(nums, left, right);
            quick(nums, left, mid - 1);
            quick(nums, mid, right);
        }
    }

    private static int quick_pass(int[] nums, int left, int right) {
        int grd = nums[left];
        int l = left + 1, r = right;
        while (l < r) {
            while (l < r && nums[l] <= grd) l++;
            while (l < r && nums[r] >= grd) r--;
            nums[l] = nums[r] + (nums[r] = nums[l]) * 0;
        }
        if (nums[left] >= nums[l])
            nums[left] = nums[l] + (nums[l] = nums[left]) * 0;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 6, 4, 7, 8, 9, 3, 2, 5, 8, 7, 4, 6, 2, 1, 5, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
