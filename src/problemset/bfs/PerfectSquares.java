package problemset.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int bfs(int n) {
        // 不对， step加的过多，用Node比较好
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        queue.offer(n);
        visit[n-1] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            for (int i = 1;; i++) {
                int nextVal = value - i * i;
                if (nextVal < 0)
                    break;
                if (nextVal == 0)
                    return step;
                if (!visit[nextVal]) {
                    queue.offer(nextVal);
                    visit[nextVal] = true;
                }
            }
            step ++;
        }

        return -1;
    }

    public int numSquares(int n) {
        // https://leetcode-cn.com/problems/perfect-squares/solution/yan-du-you-xian-sou-suo-java-by-1874-14/
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean[] record = new boolean[n];
        while (!queue.isEmpty()) {
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                if (nextVal < 0)
                    break;
                if (nextVal == 0)
                    return step;
                if (!record[nextVal]) {
                    queue.add(new Node(nextVal, step + 1));
                    record[nextVal] = true;
                }
            }
        }

        return -1;
    }

    public int numSquares1(int n) {
        /**
         * https://leetcode-cn.com/problems/perfect-squares/comments/7455 1ms: 100%
         * 36.9MB: 12.70%
         */
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        int a = 0;
        while (a * a <= n) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n)
                if (a != 0 && b != 0)
                    return 2;
                else
                    return 1;
            a++;
        }
        return 3;
    }

    public static void main(String[] args) {
        PerfectSquares square = new PerfectSquares();
        System.out.println(square.bfs(11));
    }
}
