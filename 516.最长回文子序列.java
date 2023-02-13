/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    a[i][j] = a[i + 1][j - 1] + 2;
                } else {
                    a[i][j] = Math.max(a[i + 1][j], a[i][j - 1]);
                }
            }
        }

        return a[0][n - 1];
    }
}
// @lc code=end

