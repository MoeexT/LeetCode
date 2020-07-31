package problemset.string;

/*
 * @date_time: 2020-04-10 12:20
 * @author: MoeexT
 * @problem: 151
 * @url: https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

import java.util.Stack;

public class ReverseWordsInAString {
    /*
     * @time: 7 ms 42.68%
     * @mem: 40MB 5.41%
     */
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (sb.length() != 0) {
                    stack.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }
        if (sb.length() != 0) {
            ans.append(sb);
            ans.append(" ");
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            ans.append(" ");
        }

        return ans.length() == 0 ? "" : ans.toString().substring(0, ans.length()-1);
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println(solution.reverseWords(" "));
    }
}

