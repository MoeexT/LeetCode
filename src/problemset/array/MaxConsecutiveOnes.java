package problemset.array;

/*
 * @date_time: 2020-04-03 17:57
 * @author: MoeexT
 * @problem: 485
 * @url: https://leetcode-cn.com/problems/max-consecutive-ones/
 */


public class MaxConsecutiveOnes {
    /*
     * @time: 2 ms 99.09%
     * @mem: 41.4MB 5.71%
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, res);
                res = 0;
            } else {
                res++;
            }
        }
        return Math.max(max, res);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,1}));
    }
}

