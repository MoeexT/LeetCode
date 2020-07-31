package problemset.dfs;

/*
 * @date_time: 2020-04-10 22:22
 * @author: MoeexT
 * @problem: 面试题12
 * @url: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */


public class RouteInMatrixLcof {
    char[][] board;
    boolean[][] visit;
    String word;

    /*
     * @time: 9 ms 35.53%
     * @mem: 40.7MB 100%
     */
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false; 
    }

    private boolean dfs(int x, int y, int idx) {
        if (idx == word.length() - 1) {
            return true;
        }
        int[] offx = {1, -1, 0, 0};
        int[] offy = {0, 0, 1, -1};
        boolean step = false;
        for (int i = 0; i < 4; i++) {
            int newX = x + offx[i], newY = y + offy[i];
            if (newX > -1 && newX < board.length && newY > -1 && newY < board[0].length
                    && !visit[newX][newY] && board[newX][newY] == word.charAt(idx + 1)) {
                System.out.println("(" + newX + ", " + newY + ")" + board[newX][newY]);
                visit[x][y] = true;
                step = step || dfs(newX, newY, idx + 1);
                visit[x][y] = false;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        RouteInMatrixLcof solution = new RouteInMatrixLcof();
        System.out.println(solution.exist(new char[][]{
                {}
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
        }, "BFCE"));
    }
}

