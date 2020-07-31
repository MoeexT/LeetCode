package problemset.bfs;
/**
 * Problem : 200
 * https://leetcode-cn.com/problems/number-of-islands/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

    boolean[][] dfs_flag;

    public int Num(char[][] grid) {
        int res = 0;
        // dfs_flag = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        int[] v = new int[] { i, j };
        queue.offer(v);
        set.add(Arrays.toString(v));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] tmp = queue.poll();
                int p = tmp[0];
                int q = tmp[1];
                grid[p][q] = '0';

                if (p + 1 < grid.length && grid[p + 1][q] == '1') {
                    int[] vis = new int[] { p + 1, q };
                    if (!set.contains(Arrays.toString(vis))) {
                        queue.offer(vis);
                        set.add(Arrays.toString(vis));
                    }
                }
                if (q + 1 < grid[0].length && grid[p][q + 1] == '1') {
                    int[] vis = new int[] { p, q + 1 };
                    if (!set.contains(Arrays.toString(vis))) {
                        queue.offer(vis);
                        set.add(Arrays.toString(vis));
                    }
                }
                if (p - 1 >= 0 && grid[p - 1][q] == '1') {// && !set.contains("[" + (p - 1) +", " + q + "]")
                    int[] vis = new int[] { p - 1, q };
                    if (!set.contains(Arrays.toString(vis))) {
                        queue.offer(vis);
                        set.add(Arrays.toString(vis));
                    }
                }
                if (q - 1 >= 0 && grid[p][q - 1] == '1') {
                    int[] vis = new int[] { p, q - 1 };
                    if (!set.contains(Arrays.toString(vis))) {
                        queue.offer(vis);
                        set.add(Arrays.toString(vis));
                    }
                }
            }
        }
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        /*
         * long start = System.currentTimeMillis(); int res = 0; for (int i = 0; i <
         * 10000; i++) { res = nIslands.Num(new char[][] { { '1', '1', '1', '1', '0' },
         * { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1',
         * '1', '1' } }); } long end = System.currentTimeMillis();
         * System.out.println("Time: " + (end - start));
         */
        NumberOfIslands nIslands = new NumberOfIslands();
        int res = nIslands.Num(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '1', '1', '1' } });
        System.out.println(res);
        // Queue<Integer[]> q = new LinkedList<>();
        // q.offer(new Integer[]{0,1,2});
        // System.out.println(Arrays.toString(q.poll()));
    }
}
