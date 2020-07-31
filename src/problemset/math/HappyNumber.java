package problemset.math;

/*
 * @date_time: 2020-04-30 10:40
 * @author: MoeexT
 * @problem: number of problem
 * @url: https://losadhwselfff2332dasd.xyz/link/wwgRYzqUZqkHfEer?mu=0
 */

import java.util.HashSet;

public class HappyNumber {
    final HashSet<Integer> set = new HashSet<Integer>() {{
        add(4);
        add(16);
        add(37);
        add(58);
        add(89);
        add(145);
        add(42);
        add(20);
    }};

    /*
     * @time: 2ms 52.1%
     * @mem: 36.9MB 8.33%
     */
    public boolean isHappy(int n) {
        set.add(n);
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(2));
    }
}

