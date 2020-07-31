package problemset.array;

/*
 * @date_time: 2020-04-24 14:52
 * @author: MoeexT
 * @problem: 面试题51
 * @url: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */

import java.util.Arrays;

public class ReversePairInArray {
    private int[] nums;

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid, left, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }


    /**
     * 思想
     * 从后向前走，一边走一边二分查找有序序列中比当前元素小的（最大的）数
     * 更新计数器后把当前元素插入到有序序列中
     * 写的不对，有问题
     * @param data
     * @return
     */
    public int reversePair(int[] data) {
        nums = data;
        int ans = 0;

        for (int i = nums.length - 2; i > -1; i--) {
            int cur = nums[i];
            int maxMinIdx = search(i + 1, cur);
            ans += maxMinIdx - i;
            System.arraycopy(nums, i + 1, nums, i, maxMinIdx - i);
            nums[maxMinIdx] = cur;
            System.out.println(maxMinIdx);
            System.out.println(Arrays.toString(nums));
        }
        return ans;
    }

    /**
     * 在有序序列中找出比x小的数a，a在比x小的序列中处于最后一位
     * @param start 查找起始处
     * @param x     目标
     * @return a的index
     */
    private int search(int start, int x) {
        int low = start, high = nums.length - 1;
        if (low == high) {
            if (nums[low] >= x)
                return low - 1;
            else
                return low;
        }
        while (low < high) {
            int mid = (low + high) >> 1;

            if (low + 1 == high) {
                if (nums[low] >= x)
                    return low - 1;
                else if (nums[high] >= x)
                    return low;
                else
                    return high;
            }

            if (nums[mid] < x) {
                low = mid;
            } else if (nums[mid] > x) {
                high = mid;
            } else {
                while (nums[mid] == x) {
                    if (mid == start)
                        return start-1;
                    mid--;
                }
                return mid + 1;
            }
        }
        // a statement which will never run.
        return low - 1;
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        ReversePairInArray solution = new ReversePairInArray();
//        solution.nums = new int[]{1,1,1,1,1};
//        System.out.println(solution.search(1,1));
        System.out.println(solution.reversePairs(nums));
//        System.out.println(Arrays.toString(nums));
    }
}

