package diagram.sort;

import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5, 2, 7, 3, 6, 1, 0, -2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= high)
            temp[k++] = array[j++];
        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + low] = temp[k2];
        }
    }
}
