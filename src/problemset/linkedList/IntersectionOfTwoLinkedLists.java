package problemset.linkedList;

/*
 * @date_time: 2021-03-15 22:29
 * @author: MoeexT
 * @problem: 160
 * @url: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */

import util.ListNode;

import java.util.LinkedList;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedList<ListNode> stackA = new LinkedList<>();
        LinkedList<ListNode> stackB = new LinkedList<>();
        ListNode n1 = headA, n2 = headB, ans = null;
        while (n1 != null || n2 != null) {
            if (n1 != null) stackA.push(n1);
            if (n2 != null) stackB.push(n2);
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        while (stackA.peek() == stackB.peek()) {
            ans = stackA.pop();
            stackB.pop();
        }
        return ans;
    }


    public ListNode getInterNode(ListNode headA, ListNode headB) {
        // TODO 不同栈帧中节点对齐 不对齐只会返回最后一个节点
        if (headA.next == null && headB.next == null)
            return headA;
        else if (headA.next == null)
            return getIntersectionNode(headA, headB.next);
        else if (headB.next == null)
            return getIntersectionNode(headA.next, headB);

        if (headA == headB)
            return headA;
        else
            return getIntersectionNode(headA.next, headB.next);
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode intersectionNode = ListNode.generateList(new int[]{8, 4, 5});
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectionNode;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectionNode;
        System.out.println(solution.getIntersectionNode(headA, headB));
    }
}

