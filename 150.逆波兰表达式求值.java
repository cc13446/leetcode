import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (cur.equals("+")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left + right);
            } else if (cur.equals("-")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left - right);
            } else if (cur.equals("*")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left * right);
            } else if (cur.equals("/")) {
                int right = s.pop();
                int left = s.pop();
                s.push(left / right);
            } else {
                s.push(Integer.parseInt(cur));
            }
        }
        return s.pop();
    }
}
// @lc code=end

