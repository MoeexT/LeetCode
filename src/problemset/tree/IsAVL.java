package problemset.tree;

/*
 * @date_time: 2020-05-01 11:11
 * @author: MoeexT
 * @problem: 面试题55-2
 * @url: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */

import util.TreeNode;

public class IsAVL {
    /*
     * @help: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/comments/246078
     * @time: 1ms 99.95%
     * @mem: 40.3MB 100.00%
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (1 >= Math.abs(dfs(root.left) - dfs(root.right))) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

}

