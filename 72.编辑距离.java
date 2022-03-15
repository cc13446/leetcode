/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word2.length();
        int n = word1.length();
        int[][] array = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++) array[i][0] = i;
        for(int i = 0; i <= n; i ++) array[0][i] = i;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    array[i][j] = array[i - 1][j - 1];
                } else {
                    array[i][j] = 1 + Math.min(array[i - 1][j], Math.min(array[i][j - 1], array[i - 1][j - 1]));
                }
            }
        }
        return array[m][n];
    }
}
// @lc code=end

