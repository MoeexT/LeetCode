package problemset.linkedList;

/*
 * @date_time: 2020-06-28 16:20
 * @author: MoeexT
 * @problem: number of problem
 * @url:
 */

import util.Node;

public class DeleteDuplicateElements {
    /**
     * 删除链表中所有重复元素
     * 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> 6 -> 7 -> 7 -> 7
      hed  pre
     * 5 -> 6
     * @param head 链表头
     * @return 去重链表
     */
    public Node delete(Node head) {
        if (head == null || head.next == null)
            return head;

        Node pre = head.next;
        Node ans = new Node(), cur = ans;

        while (pre != null) {
            if (head.val == pre.val) {
                while (pre != null && head.val == pre.val) {
                    head = pre;
                    pre = pre.next;
                }
                if (pre == null) {
                    cur.next = null;
                    return ans.next;
                }
            } else {
                cur.next = head;
                cur = head;
            }
            head = pre;
            pre = pre.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        DeleteDuplicateElements solution = new DeleteDuplicateElements();
        Node head = Node.strToList("1 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> 6 -> 7 7");
        Node.printSinglyList(head);
        Node.printSinglyList(solution.delete(head));
    }
}

