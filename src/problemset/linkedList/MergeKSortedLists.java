package problemset.linkedList;

/*
 * @date_time: 2020-04-26 11:16
 * @author: MoeexT
 * @problem: 23
 * @url: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /*
     * 一边进一边出
     * @help: https://leetcode-cn.com/problems/merge-k-sorted-lists/comments/64343
     * @time: 6ms 56.47%
     * @mem: 41.6MB 55.88%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode ans = new ListNode(-1), cur = ans;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<>(comparator);
        for (ListNode list : lists) if (list != null) heap.add(list);
        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            cur.next = next;
            cur = cur.next;
            if (next.next != null) heap.add(next.next);
        }
        return ans.next;
    }

    /*
     * @time: 6 ms 56.47%
     * @mem: 41.5MB 58.82%
     */
    public ListNode merge(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode ans = new ListNode(-1), cur = ans;

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<>(comparator);

        for (ListNode list : lists) {
            while (list != null) {
                heap.add(list);
                list = list.next;
            }
        }
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return ans.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(3);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(3);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(5);
        ListNode n3 = new ListNode(3);

        ListNode ans = solution.merge(new ListNode[] {n1,null});
        ListNode.printList(ans);
    }
}

