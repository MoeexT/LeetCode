package problemset.dp;

/*
 * @date_time: 2020-05-08 14:21
 * @author: MoeexT
 * @problem: 221
 * @url: https://leetcode-cn.com/problems/maximal-square/
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int X = matrix.length;
        if (X < 1) return 0;
        int Y = matrix[0].length, max = 0;
        int[][] dp = new int[X + 1][Y + 1];


        for (int i = 1; i <= X; i++) {
            for (int j = 1; j <= Y; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();
        System.out.println(solution.maximalSquare(new char[][]{
                {1}
        }));
    }
}

