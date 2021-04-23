package util;

public class Calculator {

    /**
     * 不溢出计算组合数 C(n, k)
     * @param n n
     * @param k k
     * @return C(n, k)
     */
    public static int combination(int n, int k) {
//        if (k == 0) return 1;
        int factN = 1, factK = 1;
        int v, l = n - k;
        while (n > l) {
            factN *= n--;
            factK *= k--;
            v = gcd(factN, factK);
            factN /= v;
            factK /= v;
        }
        return factN;
    }

    /**
     * 返回两数的最大公约数
     * @param a a
     * @param b b
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
