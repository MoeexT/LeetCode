package interview;

import util.ListNode;
import util.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

    /*public boolean searchMatrix (int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length - 1, j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;

        LinkedList<Integer> deque = new LinkedList<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            if (i+1 >= k)
                ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }*/

    /**
     * 有限状态自动机
     * ABCCC ->ABC
     * AABBCC -> AABCC
     * @param s 输入
     * @return 输出
     */
    private static String correct(String s) {
        if (s.length() < 3) return s;
        StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
        PriorityQueue<Integer> heap = new PriorityQueue<>(10, (p, q) -> p-q);
        char[] chs = s.toCharArray();
        int state = 0;
        char last = chs[0], cur;
        for (int i = 1; i < chs.length; i++) {
            cur = chs[i];
            switch (state) {
                case 0:
                    if (cur == last)
                        state = 1;
                    else
                        state = 0;
                    break;
                case 1:
                    if (cur == last)
                        continue;
                    else
                        state = 2;
                    break;
                case 2:
                    if (cur == last)
                        continue;
                    else
                        state = 0;
                    break;
                default:
                    break;
            }
            sb.append(cur);
            last = cur;
        }

        return sb.toString();
    }


    // 判断二叉树叶节点是否构成等差数列
    private static Node pre = null;
    private static int d = Integer.MIN_VALUE;
    private static boolean isLeafAP(Node root) {
        if (root.prev == null && root.next == null) {
//            System.out.print(root.val + ", ");
            if (pre == null) {
                pre = root;
                return true;
            }
            if (d == Integer.MIN_VALUE) {
                d = root.val - pre.val;
                pre = root;
                return true;
            }
            boolean tmp = root.val - pre.val == d;
            pre = root;
            return tmp;
        }
        boolean ans = true;
        if (root.prev != null) {
            ans = isLeafAP(root.prev);
            if (!ans) return false;
        }
        if (root.next != null) {
            ans = isLeafAP(root.next);
            return ans;
        }
        return true;
    }

    /**
     * 反转链表
     * @param pre 前一个节点
     * @param head 待翻转链表头
     * @return 反转后的链表
     */
    public static ListNode reverse(ListNode pre, ListNode head) {
        if (head == null) return pre;
        ListNode nxt = head.next;
        head.next = pre;
        return reverse(head, nxt);
    }

    public static void main(String[] args) {
        /* t
        Node root = new Node(4);
        root.left = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right = new Node(7);
        System.out.println(isLeafAP(root));*/
//        ListNode.printList(reverse(null, ListNode.generateList(new int[] {1,2,3,4,5})));
        ArrayList<Integer> list = new ArrayList<>();

    }
}
