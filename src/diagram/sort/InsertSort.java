package diagram.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        double ARR[] = {2.1, 0.67, 8.45, 6.66, 4, 2.24, 0.8, 5.4, 10};
        double result[] = InsertSort.insertSort(ARR);
        System.out.println(Arrays.toString(result));
    }

    public static double[] insertSort(double array[]) {
        for (int i = 1; i < array.length; i++) {
            double x = array[i];
            int j = i - 1;
            // while (array[j] > x && j > 0) {  // 第一个不参与排序
            // while (x < array[j] && j >= 0) {  // 会出现“数组越界”异常
            while (j >= 0 && x < array[j]) {  //正确
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = x;
        }
        return array;
    }
}
