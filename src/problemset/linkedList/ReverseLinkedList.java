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
    /*
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (head != null) {
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }*/

    /*
     *
     * @time: 0ms 100.00%
     * @mem: 38.1MB 81.05%
     */
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode nxt = cur.next;
        cur.next = pre;
        return reverse(cur, nxt);
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode node = ListNode.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(node);
        ListNode.printList(obj.reverseList(node));
    }
}
