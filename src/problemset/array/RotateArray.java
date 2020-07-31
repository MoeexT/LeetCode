package problemset.array;

/*
 * @date_time: 2020-04-03 23:32
 * @author: MoeexT
 * @problem: 189
 * @url: https://leetcode-cn.com/problems/rotate-array/
 */

import java.util.Arrays;

public class RotateArray {
    /*
     * @time: 50 ms 35.28%
     * @mem: 40.8MB 5.09%
     */
    public void rotateStepByStep(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int tmp = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = tmp;
        }

    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }

        int src = len - 1, tgt = k - 1;
        int tmp1, tmp2 = nums[src];

        while (src >= k) {
            tmp1 = nums[(len + tgt) % len];
            nums[(len + tgt) % len] = tmp2;
            tgt--;
            src--;
            tmp2 = nums[src];
            nums[src] = tmp1;
//            System.out.println(tmp1+", "+tmp2);
        }

    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

