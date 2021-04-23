package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 单链表
 * 双链表（也可作为树节点）
 * 复杂链表
 */
public class Node {
    public int val;
    // 单链表
    public Node next;
    // 双链表
    public Node prev;
    // 复杂链表
    public Node random;

    /**
     * 复杂链表，后继结点须手动指定
     *
     * @param val    值
     * @param random 随机后继，区别于后继
     */
    public Node(int val, Node random) {
        this.val = val;
        this.next = null;
        this.random = random;
    }

    /**
     * 双向链表
     *
     * @param val   值
     * @param left  前驱
     * @param right 后继
     */
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.prev = left;
        this.next = right;
    }

    public Node(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Expect at least 1 element.");
        }
        this.val = values[0];
        Node cur = this;
        for (int i = 1; i < values.length; i++) {
            cur.next = new Node(values[i]);
            cur = cur.next;
        }
    }

    public Node(int val) {
        this.val = val;
    }

    public Node() {}

    /*@Override
    public String toString() {
        return "DoublyNode{" +
                "val=" + val +
                ", random=" + random.val +
                '}';
    }*/

    /**
     * 打印单链表
     *
     * @param head 链表头
     */
    public static void printSinglyList(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 打印有环的双向链表
     *
     * @param head 链表头
     */
    public static void printDoublyList(Node head) {
        Set<Node> set = new HashSet<>();
        while (!set.contains(head)) {
            System.out.print(head.val);
            if (!set.contains(head.next))
                System.out.print(" -> ");
            set.add(head);
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 将字符串形式链表转化为真实链表，任何非数字的字符都会被忽略。
     * "1 -> 2 -> 3 -> 4 -> 5"
     * DoublyNode(1) -> DoublyNode(2) -> DoublyNode(3) -> DoublyNode(4) -> DoublyNode(5)
     *
     * @param string 字符串
     * @return 链表
     */
    public static Node from(String string) {
        // "1 -> 2 -> 3 -> 4 -> 5"
        String[] valList = string.trim().split("[^0-9]+");
        if (valList.length == 0)
            return null;

        Node head = new Node(), cur = head;

        for (String s : valList) {
            Node tmp = new Node(Integer.parseInt(s));
            cur.next = tmp;
            cur = tmp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node head = new Node(new int[]{1});
        Node.printSinglyList(head);
    }
}
