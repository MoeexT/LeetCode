package problemset.dfs;

import java.util.Collections;
import java.util.Stack;

/**
 * date: 2020-03-22
 * time: 15:22:31
 * author: MoeexT 
 * problem: 394 
 * url:  https://leetcode-cn.com/problems/decode-string/
 */

public class DecodeString {
    /** 
    * @time: 2ms 48.43%
    * @mem: 37.5MB 5.21%
    */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<String> hp_stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            stack.add(s.charAt(i));

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '[') {
                StringBuilder chr_buf = new StringBuilder();
                StringBuilder int_buf = new StringBuilder();
                while (!hp_stack.peek().equals("]"))
                    chr_buf.append(hp_stack.pop());
                hp_stack.pop();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
                    int_buf.insert(0, stack.pop());
                hp_stack.add(String.join("", Collections.nCopies(Integer.parseInt(int_buf.toString()), chr_buf)));
            } else
                hp_stack.add(Character.toString(ch));
        }
        while(!hp_stack.isEmpty())
            sb.append(hp_stack.pop());
        
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString("2[abc3[a]z]3[cd]ef"));
    }
}
