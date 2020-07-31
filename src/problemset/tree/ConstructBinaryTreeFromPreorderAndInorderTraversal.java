package problemset.tree;

/*
 * @date_time: 2020-04-07 15:30
 * @author: MoeexT
 * @problem: 105
 * @url: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @url: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int pre = 0;
    private int in = 0;
    /*
     * @time: 1 ms 100%
     * @mem: 39.7MB 100%
     */
    /*
     * @help: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/comments/210826
     * @time: 1ms 100.00%
     * @mem: 39.8MB 58.64%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, val);
        root.right = buildTree(preorder, inorder, stop);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}

