package problemset.stack;

import java.util.Stack;

/**
 * Problem : 232 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */

public class ImplementQueueUsingStacks {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    /**
     * 0ms 100%
     * 37.3MB 5.14%
     */
    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        data.push(x);
        /* if (empty()) {
            data.push(x);
        } else {
            while(!data.isEmpty()) {
                help.push(data.pop());
            }
            help.push(x);
        } */
    }
    
    public int pop() {
        if (!empty()) {
            while (!data.isEmpty()) {
                help.push(data.pop());
            }
            int x = help.pop();
            while(!help.isEmpty()) {
                data.push(help.pop());
            }
            return x;
        }
        return 0;
    }

    public int peek() {
        if (!empty()) {
            while (!data.isEmpty()) {
                help.push(data.pop());
            }
            int x = help.peek();
            while(!help.isEmpty()) {
                data.push(help.pop());
            }
            return x;
        }
        return 0;
    }

    public boolean empty() {
        return data.isEmpty() && help.isEmpty();
    }


    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
