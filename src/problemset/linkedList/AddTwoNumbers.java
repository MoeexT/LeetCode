package problemset.linkedList;

import util.ListNode;

public class AddTwoNumbers {
    private ListNode Ans = new ListNode(0);
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), cur = ans;
        int carry = 0;
        int n1, n2;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            cur.next = new ListNode((n1 + n2 + carry) % 10);
            cur = cur.next;
            carry = (n1 + n2 + carry) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return ans.next;
    }

    private boolean add(ListNode l1, ListNode l2, ListNode ans) {
        return false;
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode l1 = ListNode.generateList(new int[]{4,3,2,1});
        ListNode l2 = ListNode.generateList(new int[]{9,9,9,9});
        ListNode.printList(obj.addTwoNumbers(l1, l2));
    }
}
