package problemset.tree;

/*
 * @date_time: 2020-04-27 16:36
 * @author: MoeexT
 * @problem: 面试题32-3
 * @url: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTreeTopToBottomIII {
    /*
     * @time: 1 ms 99.86%
     * @mem: 39.8MB 100.00  %
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if ((++depth & 1) == 0) {
                int listSize = list.size() - 1;
                int temp;
                for (int i = 0; i <= listSize / 2; i++) {
                    temp = list.get(i);
                    list.set(i, list.get(listSize - i));
                    list.set(listSize - i, temp);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        PrintBinaryTreeTopToBottomIII solution = new PrintBinaryTreeTopToBottomIII();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.levelOrder(root));
    }
}

