package problemset.bitOperation;

/*
 * @date_time: 2020-04-28 14:04
 * @author: MoeexT
 * @problem: 面试题56-1
 * @url: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */

import java.util.Arrays;

public class NumberOfOccurrencesOfNumbersI {
    /*
     * @time: 2 ms 95.47%
     * @mem: 41.5MB 100.00%
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) x ^= num;

        int k = 1;
        while ((x & k) != k) k = k << 1;

        int i = 0, j = 0;
        for (int num : nums)
            if ((num & k) == k)
                i ^= num;
            else
                j ^= num;

        return new int[] {i, j};
    }

    public static void main(String[] args) {
        NumberOfOccurrencesOfNumbersI solution = new NumberOfOccurrencesOfNumbersI();
        System.out.println(Arrays.toString(solution.singleNumbers(new int[] {4,1,1,6,3,2,4,6})));
    }
}

