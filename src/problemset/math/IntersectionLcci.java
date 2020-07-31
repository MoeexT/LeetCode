package problemset.math;

/*
 * @date_time: 2020-04-12 13:18
 * @author: MoeexT
 * @problem: 面试题16.03
 * @url: https://leetcode-cn.com/problems/intersection-lcci/
 */

import java.util.Arrays;

public class IntersectionLcci {
    /**
     * 烂
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] ans = {};
        double x1 = start1[0], y1 = start1[1];
        double x2 = end1[0], y2 = end1[1];
        double x3 = start2[0], y3 = start2[1];
        double x4 = end2[0], y4 = end2[1];

        double delta1 = x1 - x2, delta2 = x3 - x4;
        double delta3 = y1 - y2, delta4 = y3 - y4;
        double delta5 = x1 * y2 - x2 * y1;

        double X = (delta1 * (x3 * y4 - x4 * y3) - delta2 * delta5) / (delta2* delta3 - delta1 * delta4);
        System.out.println(X);
        if (X >= x1 && X <= x2) {
            double Y = (X * delta3 + delta5) / delta1;
            ans = new double[2];
            ans[0] = X;
            ans[1] = Y;
        }

        return ans;
    }

    public static void main(String[] args) {
        IntersectionLcci solution = new IntersectionLcci();
        System.out.println(Arrays.toString(solution.intersection(
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{1, 2}
                )));
    }
}

