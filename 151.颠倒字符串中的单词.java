/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].length() > 0 && ss[i] != " ") {
                sb.append(ss[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}
// @lc code=end

