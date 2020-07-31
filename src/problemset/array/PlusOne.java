package problemset.array;

import java.util.Arrays;

/**
 * date: 2020-03-25 time: 22:42:43 author: MoeexT problem: 66 url:
 * https://leetcode-cn.com/problems/plus-one/
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        /** 
         * time: 0ms 100.00%
         * mem: 37.9MB 5.03%
         */
        int len = digits.length;
        digits[len - 1] += 1;
        for (int i = len - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] bak = new int[len + 1];
            bak[0] = 1;
            return bak;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 9,0,1 })));
    }
}
