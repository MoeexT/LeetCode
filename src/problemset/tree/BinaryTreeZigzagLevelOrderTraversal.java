package problemset.tree;

/*
 * @date_time: 2020-05-13 11:46
 * @author: MoeexT
 * @problem: 103
 * @url: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    /* 
     * @time: 1ms 97.71%
     * @mem: 39.9MB 7.41%
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if ((flag & 1) == 0)
                    tmp.add(node.val);
                else
                    tmp.add(0, node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(tmp);
            flag++;
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(solution.zigzagLevelOrder(null));
    }
}

