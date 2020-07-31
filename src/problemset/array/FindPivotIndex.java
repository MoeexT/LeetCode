package problemset.array;

/**
 * @date: 2020-03-25
 * @time: 20:38:37
 * @author: MoeexT
 * Problem: 724
 * url: https://leetcode-cn.com/problems/find-pivot-index/
 */

public class FindPivotIndex {
    public int pivotIndex (int[] nums) {
        /** 
         * @time: 2ms 69.8%
         * @mem: 42.8MB 33.6%
         */
        int sum = 0;
        int lsum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum- nums[i] == lsum << 1)
                return i;
            lsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();
        System.out.println(obj.pivotIndex(new int[] {1,2,3}));
    }
}
