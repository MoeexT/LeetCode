package problemset.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    private class Node {
        private String val;
        private int step;
        public Node(String val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int openLock(String[] deadends, String target) {
        if (target == "0000")
            return 0;
        else if (target == null || target == "" || Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000"))
            return -1;

        Queue<Node> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(new Node("0000", 1));
        set.add("0000");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = node.step;
            for (String nextStr : spin(node.val)) {
                if (nextStr.equals(target)) {
                    return step;
                }
                if (!set.contains(nextStr) && !Arrays.asList(deadends).contains(nextStr)) {
                    queue.add(new Node(nextStr, step + 1));
                    set.add(nextStr);
                }
            }
        }
        return -1;
    }

    private ArrayList<String> spin(String str) {
        assert str.length() == 4;
        String[] ch = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < 4; i++) {
            char C = sb.charAt(i);
            int c = Character.getNumericValue(C);
            list.add(sb.replace(i, i + 1, ch[(c + 1) % 10]).toString());
            list.add(sb.replace(i, i + 1, ch[(c - 1 + 10) % 10]).toString());
            sb.setCharAt(i, C);
        }
        return list;
    }

    public static void main(String[] args) {
        OpenTheLock Solution = new OpenTheLock();
        System.out.println(Solution.openLock(new String[] {"0000"}, "8888"));
    }
}
