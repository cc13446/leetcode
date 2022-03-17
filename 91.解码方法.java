/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        s = '3' + s;
        int n = s.length();
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= n; i ++) {
            c = 0;
            // 只要当前字符不是0，上一个字符可以前进一格
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            // 只要前一个字符不是0，而且这两个字符不超过26，就可以用上俩个字符前进两格
            if (s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
// @lc code=end

