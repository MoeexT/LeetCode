package problemset.stack;

/*
 * @date_time: 2020-04-26 17:25
 * @author: MoeexT
 * @problem: 946
 * @url: https://leetcode-cn.com/problems/validate-stack-sequences/
 * @url: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */

import java.util.Stack;

public class ValidStackSequences {

    /*
     * @help: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/comments/260175
     * @time: 3ms 84.25%
     * @mem: 39.2MB 100%
     */ 
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int p : pushed) {
            stack.push(p);
            while (popIdx < popped.length && !stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }

        return popIdx == popped.length;
    }

    /**
     * 有问题：
     * pushed = [1,2,3,4,5], popped = [4,5,3,2,1]可以判断
     * pushed = [4,3,5,2,1], popped = [4,3,5,1,2]判断不了
     * 还得改
     */
    public boolean validateSequences(int[] pushed, int[] popped) {
        int pushLen = pushed.length, popLen = popped.length;

        if (pushLen + popLen == 0) {
            return true;
        } else if (pushLen * popLen == 0 || pushLen != popLen) {
            return false;
        }

        int left, peekIdx = 0, free = pushLen, popIdx = 0;
        while (pushed[peekIdx] != popped[popIdx]) peekIdx++;
//        while (pushed[peekIdx++] == popped[popIdx++]);

        if (peekIdx < pushLen - 1) free = peekIdx + 1;

        System.out.println(peekIdx + ", " + free + ", " + popIdx);

        while (popIdx != popLen) {
            if (peekIdx > -1 && pushed[peekIdx] == popped[popIdx]) {
                peekIdx--;
            } else if (free < pushLen && pushed[free] == popped[popIdx]) {
                free++;
            } else return false;
            System.out.println(peekIdx + "," + free + "," + popIdx);
            popIdx++;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidStackSequences solution = new ValidStackSequences();
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4, 3,5,1,2}));
    }
}

