package problemset.linkedList;

/*
 * @date_time: 2020-04-14 11:15
 * @author: MoeexT
 * @problem: 445
 * @url: https://leetcode-cn.com/problems/add-two-numbers-ii/
 */

import util.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    /*
     * @time: 4 ms 71.10%
     * @mem: 40.5MB 95.83%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode nxt = null;
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int n = s1.pop() + s2.pop() + carry;
            carry = n / 10;
            ListNode cur = new ListNode(n % 10);
            cur.next = nxt;
            nxt = cur;
        }
        while (!s1.isEmpty()) {
            int n = s1.pop() + carry;
            carry = n / 10;
            ListNode cur = new ListNode(n % 10);
            cur.next = nxt;
            nxt = cur;
        }
        while (!s2.isEmpty()) {
            int n = s2.pop() + carry;
            carry = n / 10;
            ListNode cur = new ListNode(n % 10);
            cur.next = nxt;
            nxt = cur;
        }
        if (carry != 0) {
            ListNode cur = new ListNode(carry);
            cur.next = nxt;
            nxt = cur;
        }
        return nxt;
    }

    public static void main(String[] args) {
        AddTwoNumbersII solution = new AddTwoNumbersII();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode ans = solution.addTwoNumbers(new ListNode(1), l2);
        ListNode.printList(ans);
    }
}

