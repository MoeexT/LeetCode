package problemset.dp;

/**
* @date: 2020-03-24
* @time: 11:05:52
* @author: MoeexT
* Problem: 17.16
* url: https://leetcode-cn.com/problems/the-masseuse-lcci/
*/

public class TheMasseuseLcci {
    public int massage (int[] nums) {
        /** 
        * @from: https://leetcode-cn.com/problems/the-masseuse-lcci/solution/an-mo-shi-by-leetcode-solution/
        * @time: 0ms 100%
        * @mem: 37MB 100%
        */
        int n = nums.length;
        if (n == 0)
            return 0;
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < n; ++i) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];
            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
        // return rec(nums, 0);
    }

    /**
     * 这个写法必有array[0]，但是判题的时候可以没有array[0]
     * @param array
     * @param idx
     * @return
     */
    public int rec(int[] array, int idx) {
        if (idx > array.length -1)
            return 0;
        else if (idx == array.length - 1)
            return array[array.length-1];
        
        return Math.max(array[idx] + rec(array, idx+2), array[idx] + rec(array, idx+3));
    }

    public static void main(String[] args) {
        TheMasseuseLcci obj = new TheMasseuseLcci();
        System.out.println(obj.massage(new int[]{1,3}));
    }
}
