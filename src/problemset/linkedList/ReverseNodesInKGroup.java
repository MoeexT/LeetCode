package problemset.linkedList;

/*
 * @date_time: 2020-04-06 16:48
 * @author: MoeexT
 * @problem: 25
 * @url: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */

import util.ListNode;

import java.util.Stack;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        ListNode rvs = solution.reverseKGroup(n1, 2);
        while (rvs != null) {
            System.out.print(rvs.val + " -> ");
            rvs = rvs.next;
        }
    }
}

