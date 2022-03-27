/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] array = new int[m + 1][n + 1];
        for(int i = 0; i <= n; i++) array[0][i] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    array[i][j] = array[i - 1][j - 1] + array[i][j - 1];
                } else {
                    array[i][j] = array[i][j - 1];
                }
            }
        }
        return array[m][n];
    }
}
// @lc code=end

