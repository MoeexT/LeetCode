package problemset.linkedList;

/*
 * @date_time: 2020-04-15 17:09
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @url: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/submissions/
 */

import util.ListNode;

public class MergeTwoSortedLists {
    /*
     * @time: 1 ms 73.19%
     * @mem: 39.3MB 59.81%
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1), cur;
        cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next =  l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(8);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(10);
        ListNode ans = solution.mergeTwoLists(l1, l2);
        ListNode.printList(ans);
    }
}

