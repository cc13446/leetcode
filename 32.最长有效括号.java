import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int i = -1;
        int count = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') count++;
            else count--;
            if (count < 0) {
                i = j;
                count = 0;
            } else if (count == 0) {
                int temp = j - i;
                res = temp > res ? temp : res;
            }
        }
        if (count > 0) {
            count = 0;
            i = s.length();
            for (int j = s.length() - 1; j > 0; j--) {
                if (s.charAt(j) == '(') count--;
                else count++;
                if (count < 0) {
                    i = j;
                    count = 0;
                } else if (count == 0) {
                    int temp = i - j;
                    res = temp > res ? temp : res;
                }
            }
        }
        return res;
    }
}
// @lc code=end

