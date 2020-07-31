package problemset.math;

/**
 * Problem : 365 https://leetcode-cn.com/problems/water-and-jug-problem/
 */

public class WaterAndJugProblem {
    /**
     * 0ms 100%
     * 36MB 13.93%
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == 0 || y == 0)
            return z == 0 || x + y == z;

        return z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        WaterAndJugProblem waterAndJugProblem = new WaterAndJugProblem();
        System.out.println(waterAndJugProblem.canMeasureWater(3, 5, 4));
    }
}
