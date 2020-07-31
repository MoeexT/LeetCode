package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() { this(-1); }

    public ListNode(int x) {
        val = x;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

}
