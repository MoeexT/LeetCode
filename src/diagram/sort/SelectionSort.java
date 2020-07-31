package diagram.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            nums[maxIndex] = nums[i] + (nums[i] = nums[maxIndex]) * 0;
        }
    }

    public static void selectionSort_(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i] + (nums[i] = nums[minIndex]) * 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        SelectionSort.selectionSort_(array);
        System.out.println(Arrays.toString(array));
    }
}

