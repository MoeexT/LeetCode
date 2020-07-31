package problemset.tree;

/*
 * @date_time: 2020-04-25 21:39
 * @author: MoeexT
 * @problem: 面试题28
 * @url: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */

import util.TreeNode;

public class SymmetricBinaryTree {
    /*
     * @time: 0 ms 100%
     * @mem: 38MB 100%
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return dfs(root.left, root.right);
        } else return root.left == null && root.right == null;
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1.val != root2.val) {
            return false;
        }
        if (root1.left != null && root2.right != null && root1.right == null && root2.left == null) {
            return dfs(root1.left, root2.right);
        } else if (root1.left == null && root2.right == null && root1.right != null && root2.left != null) {
            return dfs(root1.right, root2.left);
        } else if (root1.left != null && root2.left != null && root1.right != null && root2.right != null) {
            return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
        } else return root1.left == null && root2.left == null && root1.right == null && root2.right == null;
    }

    public static void main(String[] args) {
        SymmetricBinaryTree solution = new SymmetricBinaryTree();
//        System.out.println(solution.isSymmetric());
    }
}

