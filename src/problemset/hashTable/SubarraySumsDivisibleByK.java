package problemset.hashTable;

/*
 * @date_time: 2020-05-27 12:02
 * @author: MoeexT
 * @problem: 974
 * @url: https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }

        return ans;
    }

}

