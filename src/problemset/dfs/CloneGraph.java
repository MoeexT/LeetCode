package problemset.dfs;
/**
 * Problem : 133
 * https://leetcode-cn.com/problems/clone-graph/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        // @Override
        // public String toString() {
        //     return "Node:  val->" + this.val + ", neighbors->" + this.neighbors;
        // }
    }

    Map<Node, Node> visit = new HashMap<>();

    public Node cloneGraph(Node node) {
        /**
         * https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode/
         * 35ms 62.06%
         * 38.9MB 5.21%
         */
        if (node == null) {
            return node;
        }
        if (visit.containsKey(node)) {
            return visit.get(node);
        }

        Node newNode = new Node(node.val);
        List<Node> neighbors = new ArrayList<>();
        newNode.neighbors = neighbors;
        visit.put(node, newNode);

        for (Node nextNode : node.neighbors) {
            neighbors.add(cloneGraph(nextNode));
        }
        return newNode;
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        List<Node> A = new ArrayList<>();
        a.neighbors = A;
        A.add(b);
        A.add(d);
        List<Node> B = new ArrayList<>();
        b.neighbors = B;
        B.add(a);
        B.add(c);
        List<Node> C = new ArrayList<>();
        c.neighbors = C;
        C.add(b);
        C.add(d);
        List<Node> D = new ArrayList<>();
        d.neighbors = D;
        D.add(a);
        D.add(c);
        System.out.println(cloneGraph.cloneGraph(a));
    }
}
