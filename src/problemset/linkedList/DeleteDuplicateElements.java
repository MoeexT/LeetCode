package problemset.linkedList;

/*
 * @date_time: 2020-06-28 16:20
 * @author: MoeexT
 * @problem: number of problem
 * @url:
 */

import util.Node;

public class DeleteDuplicateElements {

    public Node deduplicate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head, nxt = head.next;

        while (nxt != null) {
            if (nxt.val == cur.val) {
                cur.next = nxt.next;
            } else {
                cur = cur.next;
            }
            nxt = nxt.next;
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicateElements solution = new DeleteDuplicateElements();
        Node head = new Node(new int[]{1});
        Node.printSinglyList(solution.deduplicate(head));
    }
}

