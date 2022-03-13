/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] res = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            if (i == 0) {
                res[i][0] = 1;
            } else if (p.charAt(i - 1) == '*' && res[i - 1][0] == 1) {
                res[i][0] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                if (p.charAt(i - 1) == '*') {
                    if (res[i - 1][k - 1] == 1 || res[i][k - 1] == 1 || res[i - 1][k] == 1) {
                        res[i][k] = 1;
                    }
                } else if (p.charAt(i - 1) == '?') {
                    if (res[i - 1][k - 1] == 1) {
                        res[i][k] = 1;
                    }
                } else {
                    if (res[i - 1][k - 1] == 1 && p.charAt(i - 1) == s.charAt(k - 1)) {
                        res[i][k] = 1;
                    }
                }
            }
        }
        return res[n][m] == 1;
    }
}
// @lc code=end

