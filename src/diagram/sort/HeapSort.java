package diagram.sort;

import java.util.Arrays;

public class HeapSort {

    private static int[] nums;

    /**
     * 大顶堆排序吧，小顶堆不好排
     *
     * @param data 待排序数组
     */
    public static void sort(int[] data) {
        nums = new int[data.length + 1];
        System.arraycopy(data, 0, nums, 1, data.length);

        for (int i = 2; i < nums.length; i++) {
            int j = i;
            while (nums[j] > nums[j / 2]) {
//                nums[j] = nums[j / 2] + (nums[j / 2] = nums[j]) * 0;
                swap(j, j / 2);
                if (j / 2 == 1) {
                    break;
                }
                j /= 2;
            }
        }
        int end = nums.length - 1;
        for (int i = 2; i < nums.length; i++) {
            swap(1, end--);
            heapify(nums, end);
        }
        System.arraycopy(nums, 1, data, 0, data.length);
    }

    /**
     * 大顶堆 堆化
     *
     * @param nums
     * @param end
     */
    private static void heapify(int[] nums, int end) {
        for (int i = 1; i < end; ) {
            int left = i << 1;
            int right = left + 1;

            if (right <= end) {
                if (nums[left] >= nums[right]) {
                    if (nums[left] > nums[i])
                        swap(left, i);
                    i = left;
                } else if (nums[left] < nums[right]) {
                    if (nums[right] > nums[i])
                        swap(right, i);
                    i = right;
                }
            } else if (left == end && nums[left] > nums[i]) {
                swap(left, i);
                return;
            } else {
                return;
            }
        }
    }

    private static void swap(int a, int b) {
        nums[a] = nums[b] + (nums[b] = nums[a]) * 0;
    }

    public static void main(String[] args) {
        int[] nums = {55, 94, 87, 1, 4, 32, 11, 77, 39, 42, 64, 53, 70, 12, 9};
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
