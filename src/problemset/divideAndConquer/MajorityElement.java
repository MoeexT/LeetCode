package problemset.divideAndConquer;

/*
 * @date_time: 2020-04-30 14:39
 * @author: MoeexT
 * @problem: 面试题39
 * @url: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = 0;
        Integer former = null;

        for (int num : nums) {
            if (ans == 0) {
                former = num;
            }
            ans += (num == former) ? 1 : -1;
        }
        return former;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}

