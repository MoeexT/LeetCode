package problemset.tree;

/*
 * @date_time: 2020-04-28 20:58
 * @author: MoeexT
 * @problem: 面试题36
 * @url: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */

import util.Node;

public class BinarySearchTreeToDoublyLinkedList {
    private final Node head = new Node();
    private Node cur = head;

    /*
     * @time: 0 ms 100.00%
     * @mem: 39.5MB 100.00%
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrder(root);
        cur.next = head.next;
        head.next.prev = cur;
        return head.next;
    }

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.prev);
        concat(root);
        inOrder((root.next));
    }

    private void concat(Node node) {
        cur.next = node;
        node.prev = cur;
        cur = cur.next;
    }

    public static void main(String[] args) {
        BinarySearchTreeToDoublyLinkedList solution = new BinarySearchTreeToDoublyLinkedList();
        Node root = new Node(4);
        root.prev = new Node(2);
        root.prev.prev = new Node(1);
        root.prev.next = new Node(3);
        root.next = new Node(5);

        Node ans = solution.treeToDoublyList(null);
        Node.printDoublyList(ans);
    }
}

