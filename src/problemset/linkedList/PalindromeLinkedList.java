package problemset.linkedList;

/*
 * @date_time: 2021-03-29 14:58
 * @author: MoeexT
 * @problem: 234
 * @url: https://leetcode-cn.com/problems/palindrome-linked-list/
 */

import util.ListNode;

import java.util.Arrays;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        ListNode pre = slow, cur = slow, nxt = slow.next;
        if (fast != null) {  // 偶数个
            middle = new ListNode();
            middle.next = slow.next;
            slow.next = middle;
            pre = middle;
            nxt = middle.next;
        }

        middle.next = null;
        while (nxt != null) {
            cur = nxt;
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
        }

        while (head != cur) {
            if (head.val != cur.val) return false;
            head = head.next;
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        System.out.println(solution.isPalindrome(ListNode.generateList(new int[]{1, 21, 3, 2, 1})));
    }
}

