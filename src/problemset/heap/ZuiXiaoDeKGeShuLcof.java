package problemset.heap;

import java.util.Arrays;

class ZuiXiaoDeKGeShuLcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        /**
         * 8ms 65.35%
         * 42.3MB 100.00%
         */
        int[] res = new int[k];
        // quick_sort(arr, 0, arr.length-1);
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] quick_sort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = quick_pass(arr, low, high);
            quick_sort(arr, low, mid - 1);
            quick_sort(arr, mid + 1, high);
        }
        return arr;
    }

    public int quick_pass(int[] arr, int low, int high) {
        int flag = arr[low], i = low, j = high + 1;

        while (true) {
            while (++i <= high && arr[i] < flag);
            while (--j >= low && arr[j] > flag);
            if (i >= j)
                break;
            arr[i] = arr[j] + (arr[j] = arr[i]) * 0;
        }
        arr[low] = arr[j];
        arr[j] = flag;
        return j;
    }

    public static void main(String[] args) {
        ZuiXiaoDeKGeShuLcof numbers = new ZuiXiaoDeKGeShuLcof();
        // System.out.println(Arrays.toString(numbers.getLeastNumbers(new int[] {0,0,0,2,0,5}, 0)));
        System.out.println(Arrays.toString(numbers.quick_sort(new int[] {0,0,1,2,4,2,2,3,1,4 }, 0, 9)));
        // int[] a =new int[]{1,2};
        // a[0] ^= a[1];
        // a[1] ^= a[0];
        // a[0] ^= a[1];
        // System.out.println(Arrays.toString(a));
    }
}
