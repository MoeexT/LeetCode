package problemset.array;

/*
 * @date_time: 2021-03-28 11:52
 * @author: MoeexT
 * @problem: 215
 * @url: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */

import java.util.Arrays;
import java.util.Random;

public class KthLargestElementInAnArray {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int i = select(nums, 0, nums.length - 1, nums.length - k);
        System.out.println(Arrays.toString(nums));
        return i;
    }

    private int select(int[] nums, int low, int high, int index) {

        int mid = randomPartition(nums, low, high);
        if (mid == index)
            return nums[mid];
        else
            return mid > index ? select(nums, low, mid - 1, index) : select(nums, mid + 1, high, index);

    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, left);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int flag = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            if (nums[j] <= flag) {
                swap(nums, j, ++i);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}

