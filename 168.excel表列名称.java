/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            builder.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return builder.reverse().toString();
    }
}
// @lc code=end
