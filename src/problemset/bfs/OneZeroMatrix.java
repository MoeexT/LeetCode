package problemset.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date: 2020-03-23
 * @time: 19:50:18
 * @author: MoeexT Problem: 542 url: https://leetcode-cn.com/problems/01-matrix/
 */

public class OneZeroMatrix {
    static class Node {
        public int x;
        public int y;
        public int step;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public String toString() {
            return "{(" + x + ", " + y + "), " + step + "}";
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        /** 
        * @from: https://leetcode-cn.com/problems/01-matrix/solution/01-ju-zhen-by-leetcode/
        * @time: 6ms 99.07%
        * @mem: 44.7MB 100%
        */
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                dist[i][j] = Integer.MAX_VALUE - 100000;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

    // 超时 -.-
    public void bfs(int[][] matrix, int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        visit[i][j] = true;
        queue.offer(new Node(i, j, 0));
        while (!queue.isEmpty()) {
            for (int k = 0; k < queue.size(); k++) {
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                int step = node.step;
                if (matrix[x][y] == 0) {
                    System.out.println(node);
                    matrix[i][j] = step;
                    return;
                }
                if (x + 1 < matrix.length && !visit[x + 1][y]) {
                    queue.offer(new Node(x + 1, y, step + 1));
                    visit[x + 1][y] = true;
                }
                if (y + 1 < matrix[0].length && !visit[x][y + 1]) {
                    queue.offer(new Node(x, y + 1, step + 1));
                    visit[x][y + 1] = true;
                }
                if (x > 0 && !visit[x - 1][y]) {
                    queue.offer(new Node(x - 1, y, step + 1));
                    visit[x - 1][y] = true;
                }
                if (y > 0 && !visit[x][y - 1]) {
                    queue.offer(new Node(x, y - 1, step + 1));
                    visit[x][y - 1] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        OneZeroMatrix obj = new OneZeroMatrix();
        int[][] res = obj.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, });
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }
}
