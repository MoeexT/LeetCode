package problemset.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem : 094 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
import util.TreeNode;


public class BinaryTreeInorderTraversal {

    List<Integer> bfsList = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
         * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/comments/48749
         * 1ms 62.33
         * 38.1MB 5.21%
         */
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> dfs(TreeNode root) {
        /*
         * 0ms 100%
         * 37.9MB 5.21%
         */
        if (root == null) 
            return bfsList;
        if (root.left != null) {
            dfs(root.left);
        }
        bfsList.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
        return bfsList;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        A.right = B;
        B.left = C;
        System.out.println(traversal.inorderTraversal(A));
    }
}
