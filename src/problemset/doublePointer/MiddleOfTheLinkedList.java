package problemset.doublePointer;

/**
* date: 2020-03-23
* time: 02:22:53
* author: MoeexT
* problem: 876
* url: https://leetcode-cn.com/problems/middle-of-the-linked-list/
*/

public class MiddleOfTheLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    public ListNode middleNode (ListNode head) {
        /*
        * @time: 0ms 100.00%
        * @mem: 36.4MB 5.05%
        */
        /* if (head == null || head.next == null)
            return head;
        int size = 1;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (head.next != null) {
            head = head.next;
            list.add(head);
            size ++;
        }
        return list.get(size/2); */
        /** 
         * 快慢指针，
        * @from: https://leetcode-cn.com/problems/middle-of-the-linked-list/comments/534
        * @from: https://leetcode-cn.com/problems/middle-of-the-linked-list/comments/302014
        * @time: 0ms 100.00%
        * @mem: 36.6MB 5.05%
        */
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        System.out.println(obj.middleNode(D));
    }
}
