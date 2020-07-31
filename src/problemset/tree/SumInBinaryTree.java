package problemset.tree;

/*
 * @date_time: 2020-04-27 19:39
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumInBinaryTree {
    List<List<Integer>> ans = new ArrayList<>();

    /*
     * @help: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/comments/244594
     * @time: 1ms 100.00%
     * @mem: 39.9MB 100.00%
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        bt(root, new ArrayList<>(), sum);
        return ans;
    }

    /**
     * 有一个问题: [1,2] 1的输入,输出为[[1]],答案应该是[]
     * 因为 Node(1) -> Node(1).right(null)中, Node(1)是根节点
     * 所以不能在子节点判断父节点是否满足要求,这里就犯了这个错误.
     */
    private void dfs(TreeNode root, List<Integer> path, int sum) {
        if (root == null) {
            System.out.println(path);
            if (sum == 0 && (ans.isEmpty() || !ans.get(ans.size() - 1).equals(path)))
                ans.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        dfs(root.left, path, sum - root.val);
        dfs(root.right, path, sum - root.val);
        path.remove(path.size() - 1);
    }

    private void bt(TreeNode root, List<Integer> path, int sum) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path, sum);
            dfs(root.right, path, sum);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        SumInBinaryTree solution = new SumInBinaryTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);

        System.out.println(solution.pathSum(n1, 1));
    }
}

