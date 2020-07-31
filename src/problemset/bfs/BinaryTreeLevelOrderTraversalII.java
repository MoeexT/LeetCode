package problemset.bfs;

/*
 * @date_time: 2020-04-06 22:31
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    /*
     * @help: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/20200404107easybfsceng-ci-bian-li-by-jasion_han-r/
     * @time: 1ms 99.72%
     * @mem: 40MB 5.06%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                inner.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(0, inner);
        }

        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII solution = new BinaryTreeLevelOrderTraversalII();
       System.out.println(solution.levelOrderBottom(new TreeNode(0)));
    }
}

