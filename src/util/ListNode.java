package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() { this(-1); }

    public ListNode(int x) {
        val = x;
    }

    public static ListNode generateList(int[] list) {
        ListNode head = new ListNode(), cur = head;
        for (int value : list) {
            ListNode node = new ListNode(value);
            cur.next = node;
            cur = node;
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.printf("%d",node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public static void main(String[] args) {
        ListNode list = ListNode.generateList(new int[]{});
        ListNode.printList(list);
    }
}
