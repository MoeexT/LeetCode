package problemset.doublePointer;

import java.util.Stack;

/**
 * @date: 2020-04-04
 * @time: 14:25:46
 * @author: MoeexT
 * @problem: 42
 * @url: https://leetcode-cn.com/problems/trapping-rain-water/
 */

public class TrappingRainWater {

    /*
    DP
     */
    public int trapDP(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }

        for (int i = len - 2; i >= 0; i-- ) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }

        for (int i = 1; i < len - 1; i++) {

            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }

    /* 双指针
     * @help: https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/327718
     * @time: 1ms 99.98%
     * @mem: 39.6MB 11.78%
     */
    public int trapDPointer(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;

        while (left <= right) {
            if (left_max < right_max) {
                sum += Math.max(0, left_max - height[left]);
                left_max = Math.max(left_max, height[left]);
                left++;
            } else {
                sum += Math.max(0, right_max - height[right]);
                right_max = Math.max(right_max, height[right]);
                right--;
            }
        }

        return sum;
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
                stack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
