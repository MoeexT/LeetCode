package problemset.doublePointer;

import java.util.Arrays;
/**
 * @date: 2020-04-01
 * @time: 21:41:02
 * @author: MoeexT
 * @problem: 167
 * @url: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumIiInputArrayIsSorted {
    /** 
     * @help: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/comments/3078
     * @time: 1ms 98.13%
     * @mem: 40.3MB 5.06%
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[] { low + 1, high + 1 };
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] { };
    }

    public static void main(String[] args) {
        TwoSumIiInputArrayIsSorted solution = new TwoSumIiInputArrayIsSorted();
        System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }
}
