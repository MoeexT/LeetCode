package problemset.array;

import java.util.Arrays;

/**
 * @date: 2020-04-02
 * @time: 15:18:33
 * @author: MoeexT
 * @problem: 289
 * @url: https://leetcode-cn.com/problems/game-of-life/
 */

public class GameOfLife {
    /*
    @time: 0ms, 100.00%
    @mem: 38.5MB, 5.71%
     */
    public void gameOfLife(int[][] board) {
        /*
        case 1: 活细胞周围的活细胞少于俩，置死；1->0, 记为 3
        case 2: 活细胞周围的活细胞有俩或仨，不变
        case 3: 活细胞周围的活细胞多于仨，置死；1->0, 记为 3
        case 4: 死细胞周围的活细胞正好有仨，复活；0->1, 记为 2
        把3当作1，2当作0
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = liveAround(board, i, j);
                int cell = board[i][j] & 1;
                if (cell == 1) {
                    if (live < 2) {
                        board[i][j] = 3;
                    } else if (live > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    System.out.println("(" + i + "," + j + ") | " + cell + "," + live);
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public int liveAround(int[][] board, int i, int j) {
        int cnt = 0, bx = board.length, by = board[0].length;
        int[] offsetX = {-1, 0, 1};
        int[] offsetY = {-1, 0, 1};

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int ok = offsetX[k], ol = offsetY[l];
                if (ok != 0 || ol != 0) {
                    int offX = i + ok, offY = j + ol;
                    if (offX > -1 && offX < bx && offY > -1 && offY < by && (board[offX][offY] & 1) == 1) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        solution.gameOfLife(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
//        System.out.println(solution.liveAround(new int[][]{
//                {0, 1, 0},
//                {1, 1, 0},
//                {1, 1, 0},
//                }, 2, 2));
    }
}
