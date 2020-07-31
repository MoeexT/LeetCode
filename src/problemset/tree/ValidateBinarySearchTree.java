package problemset.tree;

/*
 * @date_time: 2020-05-05 17:32
 * @author: MoeexT
 * @problem: 98
 * @url: https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    long pre =Long.MIN_VALUE;
    /* 
     * @help: https://leetcode-cn.com/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
     * @time: 0ms 100%
     * @mem: 39.4MB 20.29%
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    private List<Integer> list = new ArrayList<>();
    /*
     * 先中序搜索，在判断list是否严格升序
     * @time: 2ms 38.51%
     * @mem: 38.8MB 63.77%
     */
    public boolean isValidBinarySearchTree(TreeNode root) {
        if (root == null) return true;
        inOrder(root);
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur <= pre) return false;
            pre = cur;
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        System.out.println(solution.isValidBST(new TreeNode(1)));
    }
}

