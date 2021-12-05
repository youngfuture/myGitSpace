package algorithm.leedcode;

import java.util.*;

//32. 最长有效括号
public class LongestValidParentheses_32 {

    //输入：s = ")())()()())"
    //输出：4
    //解释：最长有效括号子串是 "()()()"

    // ()(()
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }
}
