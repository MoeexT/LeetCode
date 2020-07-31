package problemset.linkedList;

/*
 * @date_time: 2020-04-12 22:49
 * @author: MoeexT
 * @problem: 面试题18
 * @url: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */

import util.ListNode;

public class DeleteLinkedListNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteNode(ListNode head, ListNode val) {
        if (val.next != null) {
            val.val = val.next.val;
            val.next = val.next.next;
        } else if (head == val) {
            head = null;
        } else {
            ListNode cur = head;
            while (cur.next != val) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteLinkedListNode solution = new DeleteLinkedListNode();
        ListNode n1 = new ListNode(4);
        n1.next = new ListNode(5);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(9);
        // 4 -> 5 -> 1 -> 9
        ListNode dNode = solution.deleteNode(n1.next.next.next, n1.next.next.next);
        while (dNode != null) {
            System.out.println(dNode.val);
            dNode = dNode.next;
        }
    }
}

