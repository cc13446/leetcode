/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res *= 26;
            res += (int)(columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
// @lc code=end

