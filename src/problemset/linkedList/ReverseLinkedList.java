package problemset.linkedList;

/**
 * @date: 2020-03-31
 * @time: 15:05:05
 * @author: MoeexT
 * @problem: 206
 * @url: https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 */

import util.ListNode;

public class ReverseLinkedList {
    /*
     * @time: 0ms 100.00%
     * @mem: 40.1MB 5.13%
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (head != null) {
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
            return cur;
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode rev = obj.reverseList(node);
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }
}
