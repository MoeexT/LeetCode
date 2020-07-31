package problemset.linkedList;

/*
 * @date_time: 2020-04-14 11:55
 * @author: MoeexT
 * @problem: 面试题22
 * @url: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */

import util.ListNode;

public class KthNode {
    /* 快慢指针
     * 快指针先走K步，然后快慢指针一起走，快指针走到头，慢指针即为所求
     * @help: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/comments/239261
     * @time: 0ms 100%
     * @mem: 37.8MB 100%
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        // int count = 0;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        KthNode solution = new KthNode();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next = new ListNode(9);
        ListNode ans = solution.getKthFromEnd(l1, 3);
        ListNode.printList(ans);
    }
}

