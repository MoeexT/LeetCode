package problemset.array;

/*
 * @date_time: 2020-04-10 14:46
 * @author: MoeexT
 * @problem: 面试题01.08
 * @url: https://leetcode-cn.com/problems/zero-matrix-lcci/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrixLcci {
    /*
     * @time: 3 ms 18.8%
     * @mem: 41.2MB 100%
     */
    public void setZeros(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer r : row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }
        for (Integer c : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        ZeroMatrixLcci solution = new ZeroMatrixLcci();
        int[][] mat = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        solution.setZeros(mat);
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

