package problemset.greedy;

/*
 * @date_time: 2020-05-04 11:25
 * @author: MoeexT
 * @problem: 45
 * @url: https://leetcode-cn.com/problems/jump-game-ii/
 */

public class JumpGameII {

    /*
     * 从前往后 O(n)
     * @help: https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
     * @time: 3ms 43.15%
     * @mem: 42.1MB 5.00%
     */
    public int jump(int[] nums) {
        int step = 0, end = 0, maxPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (end == i) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }

    /*
     * 从后往前，挨个查找能到达当前位置的最远的位置 O(n^2)
     * @help: 同上
     * @time: 300ms 13.32%
     * @mem: 42MB 5.00%
     */
    public int Jump(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;

        while (pos != 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] >= pos - i) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        System.out.println(solution.jump(new int[] {2,3,1,1,4}));
    }
}

