package problemset.array;

import java.util.Arrays;

/**
 * @date: 2020-04-01
 * @time: 21:02:59
 * @author: MoeexT
 * @problem: 561
 * @url: https://leetcode-cn.com/problems/array-partition-i/
 */

public class ArrayPartitionI {
    /**
     * @time: 13ms 95.32%
     * @mem: 42.2MB 5.12%
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = quickPass(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    private static int quickPass(int[] nums, int low, int high) {
        int i = low, j = high + 1;
        int flag = nums[low];

        while (true) {
            while (++i <= high && nums[i] < flag);
            while (--j >= low && nums[j] > flag);
            if (i >= j) {
                break;
            }
            nums[i] = nums[j] + (nums[j] = nums[i]) * 0;
        }
        nums[low] = nums[j];
        nums[j] = flag;

        return j;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2 };
        // Solution solution = new Solution();
        // System.out.println(solution.arrayPairSum(arr));
        ArrayPartitionI.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
