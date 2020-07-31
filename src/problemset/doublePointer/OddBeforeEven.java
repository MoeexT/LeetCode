package problemset.doublePointer;

/*
 * @date_time: 2020-04-14 12:37
 * @author: MoeexT
 * @problem: 面试题21
 * @url: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */

import java.util.Arrays;

public class OddBeforeEven {
    /*
     * 讲真，这道题怎么做出来的我都不知道
     * 现在知道了：(nums[low] & 1) == 1 指的是奇数不停止循环，偶数才停止，相当于找到偶数了
     * @time: 2 ms 99.96%
     * @mem: 48MB 100.00%
     */
    public int[] exchange(int[] nums) {
        int low = -1, high = nums.length;
        while (true) {
            while (++low < high && (nums[low] & 1) == 1);
            while (--high > low && (nums[high] & 1) == 0);
            if (low >= high) {  break; }
            nums[low] = nums[high] + (nums[high] = nums[low]) * 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        OddBeforeEven solution = new OddBeforeEven();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }
}

