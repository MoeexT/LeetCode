package problemset.tree;

/*
 * @date_time: 2020-04-27 15:55
 * @author: MoeexT
 * @problem: 面试题32
 * @url: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */

import util.TreeNode;

import java.util.*;

public class PrintBinaryTreeTopToBottomI {
    /*
     * @time: 4 ms 14.25%
     * @mem: 39.9MB 100%
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[] {};

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            assert node != null;
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PrintBinaryTreeTopToBottomI solution = new PrintBinaryTreeTopToBottomI();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(solution.levelOrder(root)));
    }
}

