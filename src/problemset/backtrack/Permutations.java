package problemset.backtrack;

/*
 * @date_time: 2020-04-25 14:48
 * @author: MoeexT
 * @problem: 46
 * @url: https://leetcode-cn.com/problems/permutations/solution/
 */

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[n];
        backtrack(nums, n, 0, path, used, ans);
        return ans;
    }

    private void backtrack(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (depth == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, len, depth + 1, path, used, ans);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[] {1,2,3}));
    }
}

