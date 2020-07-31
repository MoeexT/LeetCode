package problemset.doublePointer;

/*
 * @date_time: 2020-04-03 16:03
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://leetcode-cn.com/problems/remove-element/
 */

import java.util.Arrays;

public class RemoveElement {
    /*
     * @time: 0 ms 100.00%
     * @mem: 38.2MB 5.09%
     */
    public int removeElement(int[] nums, int val) {
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        solution.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}


