package problemset.array;

/**
 * date: 2020-03-25
 * time: 21:05:46
 * author: MoeexT
 * problem: 747
 * url: https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 */

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        /** 
         * time: 1ms 79.78%
         * mem: 38.1MB 5.18%
         */
        int max = nums[0], idx = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (max >= nums[i] << 1)
                count++;
        }

        if (count + 1 == nums.length)
            return idx;
        else
            return -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers obj = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(obj.dominantIndex(new int[] {1,2,3,4}));
    }
}
