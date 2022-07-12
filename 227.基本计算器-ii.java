import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        s.replaceAll("\s+", "");

        int len = sb.length();

        StringBuffer lastE = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = sb.charAt(i);
            if(Character.isDigit(c)) {
                int num = c - '0';
                while (i < len - 1 && Character.isDigit(c = sb.charAt(++i))) {
                    num *= 10;
                    num += c - '0';
                }
                lastE.append(num).append(" ");
            }
            if (c == '+' || c == '-') {
                while(!stack.isEmpty()) {
                    lastE.append(stack.pop()).append(" ");
                }
                stack.push(c);
            } else if (c == '*' || c == '/') {
                while(!stack.isEmpty() && stack.peek() != '+' && stack.peek() != '-') {
                    lastE.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            lastE.append(stack.pop()).append(" ");
        }
                
        Stack<Integer> sIntegers = new Stack<>();
        for (String ss : lastE.toString().split("\s+")) {
            if (ss.equals("+")) {
                int a = sIntegers.pop();
                int b = sIntegers.pop();
                sIntegers.push(b + a);
            } else if (ss.equals("-")){
                int a = sIntegers.pop();
                int b = sIntegers.pop();
                sIntegers.push(b - a);
            } else if (ss.equals("*")){
                int a = sIntegers.pop();
                int b = sIntegers.pop();
                sIntegers.push(b * a);
            } else if (ss.equals("/")){
                int a = sIntegers.pop();
                int b = sIntegers.pop();
                sIntegers.push(b / a);
            } else {
                sIntegers.push(Integer.valueOf(ss));
            }
        }
        return sIntegers.pop();
    }
}
// @lc code=end

