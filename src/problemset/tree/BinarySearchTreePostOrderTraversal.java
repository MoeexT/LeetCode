package problemset.tree;

/*
 * @date_time: 2020-04-27 17:55
 * @author: MoeexT
 * @problem: 面试题33
 * @url: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */

import java.util.Stack;

public class BinarySearchTreePostOrderTraversal {
    /*
     * @time: 1 ms 21.87%
     * @mem: 36.9MB 100.00%
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i > -1; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
//        return recur(postorder, 0, postorder.length - 1);
    }

    /*
     * @time:  0ms 100%
     * @mem: 0MB 100%
     */
    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        BinarySearchTreePostOrderTraversal solution = new BinarySearchTreePostOrderTraversal();
//        System.out.println(solution.verifyPostorder(vars));
    }
}

