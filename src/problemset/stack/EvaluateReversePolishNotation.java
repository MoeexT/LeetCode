package problemset.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        /**
         * 6ms: 93.64%
         * 41.6MB: 5.04%
         */
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int a, b;
            switch (s) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                default:
                    stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluate = new EvaluateReversePolishNotation();
        System.out.println(evaluate.evalRPN(new String[] { "3", "11", "+", "5", "-" }));
    }
}
