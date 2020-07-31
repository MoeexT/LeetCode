package problemset.backtrack;

/*
 * @date_time: 2020-04-29 22:33
 * @author: MoeexT
 * @problem: 面试题38
 * @url: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsOfString {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(x, i);
        }
    }

    private void swap(int a, int b) {
        c[a] = (char) (c[b] + (c[b] = c[a]) * 0);
    }

    public static void main(String[] args) {
        PermutationsOfString solution = new PermutationsOfString();
        System.out.println(Arrays.toString(solution.permutation("vars")));
    }
}

