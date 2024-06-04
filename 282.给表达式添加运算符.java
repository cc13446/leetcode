/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        char[] ops = new char[] { '*', '+', '-', ' ' };
        char[] chars = num.toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, 0, 0, 0, target, ' ', ops, chars, path, result);
        return result;
    }

    private int calculate(char c) {
        return c - '0';
    }

    private void dfs(int index, long temp, long lastV, long mul, long target, char op, char[] ops, char[] chars,
            StringBuilder path, List<String> res) {
        path.append(op);
        path.append(chars[index]);
        int v = calculate(chars[index]);
        switch (op) {
            case ' ':
                temp = temp - mul;
                if (mul == 0 && lastV == 0) {
                    mul = 1;
                } else {
                    mul = mul / lastV;
                }
                lastV = lastV * 10 + (lastV >= 0 ? v : -v);
                mul = mul * lastV;
                temp = temp + mul;
                break;
            case '+':
                temp = temp + v;
                mul = v;
                lastV = v;
                break;
            case '-':
                temp = temp - v;
                mul = -v;
                lastV = -v;
                break;
            case '*':
                temp = temp - mul;
                mul = mul * v;
                lastV = v;
                temp = temp + mul;
                break;
            default:
                break;
        }
        if (index == chars.length - 1) {
            if (temp == target) {
                String r = path.toString().replaceAll(" ", "");
                res.add(r);
            }
        } else {
            for (char o : ops) {
                // 去除0开头的数字
                char last = path.charAt(path.length() - 1);
                char lastLast = path.charAt(path.length() - 2);
                if (last == '0' && (lastLast == '+' || lastLast == '-' || lastLast == '*' || path.length() == 2)
                        && o == ' ') {
                    continue;
                }
                dfs(index + 1, temp, lastV, mul, target, o, ops, chars, path, res);
            }
        }
        path.delete(path.length() - 2, path.length());
    }
}
// @lc code=end
