package problemset.dp;

/*
 * @date_time: 2020-05-08 14:21
 * @author: MoeexT
 * @problem: 221
 * @url: https://leetcode-cn.com/problems/maximal-square/
 */

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int X = matrix.length;
        if (X < 1) return 0;
        int Y = matrix[0].length, max = 0;
        int[][] dp = new int[X + 1][Y + 1];


        for (int i = 1; i <= X; i++) {
            for (int j = 1; j <= Y; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int square(char[][] matrix) {
        if (matrix == null) return 0;
        int m = matrix.length, n = matrix[0].length;
        if (m * n == 0) return 0;
        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(res, dp[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        for (int[] chars : dp) {
            System.out.println(Arrays.toString(chars));
        }
        return res * res;
    }

    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();
        System.out.println(solution.square(new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}
        }));
    }
}

