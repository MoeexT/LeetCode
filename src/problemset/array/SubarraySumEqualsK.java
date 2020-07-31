package problemset.array;

/*
 * @date_time: 2020-05-15 10:59
 * @author: MoeexT
 * @problem: 560
 * @url: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k))
                ret += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ret;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        System.out.println(solution.subarraySum(new int[] {1,1,1}, 2));
    }
}


