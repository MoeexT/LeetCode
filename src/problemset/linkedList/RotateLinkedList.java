package problemset.linkedList;

import util.ListNode;

// 从k处断开成两条，然后前面那条放到后面那条的尾部去，k可能大于链表本身长度
public class RotateLinkedList {
    public static ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0) return head;

        ListNode cur = head;
        while (--k > 0) cur = cur.next;
        ListNode head1 = cur.next;
        cur.next = null;
        tail.next = head;
        return head1;
    }

    public static void main(String[] args) {
        ListNode.printList(rotate(ListNode.generateList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), 9));
    }
}
