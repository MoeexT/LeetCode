package problemset.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        /** https://leetcode-cn.com/problems/daily-temperatures/comments/11938
         * 23ms 76.51%
         * 45.1MB 7.89%
         */
        int[] res = new int[T.length];
        // res[T.length-1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                res[stack.peek()] = i-stack.pop();
            }
            stack.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures daily = new DailyTemperatures();
        System.out.println(Arrays.toString(daily.dailyTemperatures(
            new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
