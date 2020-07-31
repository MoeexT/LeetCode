package problemset.array;

/*
 * @date_time: 2020-04-07 10:57
 * @author: MoeexT
 * @problem: 面试题01.07
 * @url: https://leetcode-cn.com/problems/rotate-matrix-lcci/submissions/
 */

import java.util.Arrays;

public class RotateMatrixLcci {
    /*
     * @help: https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/jian-dan-java-yuan-di-shuang-bai-by-sweetiee/
     * @time: 0 ms 100.00%
     * @mem: 39.3MB 100.00%
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[j][i] + (matrix[j][i] = matrix[i][j]) * 0;
            }
        }
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                matrix[i][j] = matrix[i][n-1-j] + (matrix[i][n-1-j] = matrix[i][j]) * 0;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrixLcci solution = new RotateMatrixLcci();
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(mat);
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

