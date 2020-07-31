package problemset.stack;

import util.ListNode;
import util.MinStackNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private Deque<MinStackNode> stack = new LinkedList<>();

    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new MinStackNode(x));
        } else {
            if (x < stack.peek().min) {
                stack.push(new MinStackNode(x));
            } else {
                stack.push(new MinStackNode(x, stack.peek().min));
            }
        }
//        System.out.println(stack);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek().val;
        }
        return Integer.MIN_VALUE;
    }

    public int min() {
        if (!stack.isEmpty()) {
            return stack.peek().min;
        }
        return Integer.MIN_VALUE;
    }

    private boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
        stack.pop();
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());
//        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
        System.out.println(stack.empty());
    }
}
