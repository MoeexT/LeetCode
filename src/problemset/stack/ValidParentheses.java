package problemset.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        /**
         * 3ms  54.12%
         * 38.4MS   5.02%
         */
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("([{".contains(Character.toString(ch))) {
                stack.add(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else if (map.get(ch) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([])("));
    }
}
