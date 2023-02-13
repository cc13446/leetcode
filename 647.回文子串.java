/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] a = new int[n][n];

        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) {a[i][j] = 1; res++; continue; }
                else if (s.charAt(i) == s.charAt(j) && (a[i + 1][j - 1] == 1 || i == j - 1)) { a[i][j] = 1; res++;}
                else a[i][j] = 0;
            }
        }

        return res;
    }
}
// @lc code=end

