package problemset.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @date_time: 2021-03-25 16:54
 * @author: MoeexT
 * @problem: 54
 * @url: https://leetcode-cn.com/problems/spiral-matrix/
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        while (matrix.length > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            matrix = rotate(matrix);
        }
        return list;
    }

    private int[][] rotate(int[][] matrix) {
        int width = matrix.length - 1, height = matrix[0].length;
        int[][] res = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = matrix[j + 1][height - 1 - i];
            }
        }

        /* 先转置再列对调
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = matrix[j + 1][i];
            }
        }

        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width; j++) {
                int tmp = res[i][j];
                res[i][j] = res[height - i - 1][j];
                res[height - i - 1][j] = tmp;
            }
        }*/
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}));
    }
}

