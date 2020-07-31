package problemset.math;

import java.util.Arrays;

/**
 * date: 2020-03-26 time: 16:57:02 author: MoeexT problem: 498 url:
 * https://leetcode-cn.com/problems/diagonal-traverse/
 */

public class DiagonalTraverse {
    /** 
     * help: https://leetcode-cn.com/problems/diagonal-traverse/comments/15761
     * time: 3ms 64.51%
     * mem: 43.9MB 75.79%
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) 
            return new int[] {};
        int mn = matrix.length * matrix[0].length;
        int[] res = new int[mn];
        int i = 0, j = 0;
        for (int n = 0; n < mn; n++) {
            res[n] = matrix[i][j];
            if ((i + j) % 2 == 1) {
                if (i == matrix.length-1)
                    j++;
                else if (j == 0)
                    i++;
                else {
                    i++;
                    j--;
                }
            } else {
                if (j == matrix[0].length-1)
                    i++;
                else if (i == 0)
                    j++;
                 else {
                    j++;
                    i--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverse obj = new DiagonalTraverse();
        System.out
                .println(Arrays.toString(obj.findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })));
    }
}
