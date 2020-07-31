package diagram.sort;

import java.util.Arrays;

class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j + 1] = nums[j] + (nums[j] = nums[j + 1]) * 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 3, 2, 5, 79, 3, 4, 8, 2, 0, 5, 8, 5, 1, 3, 4, 89, 1, 0 };
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
