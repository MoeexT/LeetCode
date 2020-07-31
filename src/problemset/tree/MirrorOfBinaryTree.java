package problemset.tree;

/*
 * @date_time: 2020-04-25 21:26
 * @author: MoeexT
 * @problem: 面试题27
 * @url: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */

import util.TreeNode;

public class MirrorOfBinaryTree {
    /*
     * @time: 0 ms 100%
     * @mem: 37.1MB 100%
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.right = mirrorTree(root.left);
        node.left = mirrorTree(root.right);

        return node;
    }

    public static void main(String[] args) {
        MirrorOfBinaryTree solution = new MirrorOfBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(solution.mirrorTree(root));

    }
}

