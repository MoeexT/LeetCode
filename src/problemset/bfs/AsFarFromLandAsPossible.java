package problemset.bfs;

import util.BFSNode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    /**
     * @time: 873ms 12.77%
     * @mem: 42.2MB 99.0%
     */
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int rb = bfs(grid, i, j);
                    max = max > rb ? max : rb;
                }
            }
        }
        return max;
    }

    public int bfs(int[][] grid, int i, int j) {
        int gridLen = grid.length;
        int gridHigh = grid[0].length;
        boolean[][] visit = new boolean[gridLen][gridHigh];
        Queue<BFSNode> queue = new LinkedList<>();
        queue.offer(new BFSNode(i, j, 0));
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            for (int k = 0; k < queue.size(); k++) {
                BFSNode node = queue.poll();
                int step = node.step;
                int[] dx = { 0, 0, 1, -1 };
                int[] dy = { 1, -1, 0, 0 };
                for (int l = 0; l < 4; l++) {
                    int newX = node.x + dx[l];
                    int newY = node.y + dy[l];
                    if (newX >= 0 && newX < gridLen && newY >= 0 && newY < gridHigh && !visit[newX][newY]) {
                        if (grid[newX][newY] == 0) {
                            visit[newX][newY] = true;
                            queue.offer(new BFSNode(newX, newY, step + 1));
                        } else
                            return step + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();
        System.out.println(
                obj.maxDistance(new int[][] {
                { 1, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, }));
    }
}
