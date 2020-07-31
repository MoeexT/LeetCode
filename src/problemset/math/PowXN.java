package problemset.math;

/*
 * @date_time: 2020-04-12 16:37
 * @author: MoeexT
 * @problem: 50
 * @url: https://leetcode-cn.com/problems/powx-n/
 * @url: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/submissions/
 */

public class PowXN {
    /*
     * @time: 1 ms 96.08%
     * @mem: 36.8MB 5.71%
     */
    /*
     * @time: 0 ms 100%
     * @mem: 37MB 100%
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1.0 || n == 0) {
            return 1.0;
        } else if (x == -1.0) {
            if ((n & 1) == 0) {
                return 1.0;
            } else {
                return -1.0;
            }
        }
        if (n < 0) {
            if ((n & 1) == 0) {
                return 1 / myPow(x * x, -(n >> 1));
            } else {
                return 1 / (myPow(x * x, -(n + 1) >> 1) * x);
            }
        } else {
            if ((n & 1) == 0) {
                return myPow(x * x, n >> 1);
            } else {
                return myPow(x * x, (n - 1) >> 1) * x;
            }
        }
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        System.out.println(solution.myPow(2.0, -2147483648));
    }
}

