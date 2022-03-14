/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 || n == 1) {
            int sum = 0;
            if(m == 1) {
                for(int i = 0; i < n; i++) sum += grid[0][i];
            } else if (n == 1) {
                for(int i = 0; i < m; i++) sum += grid[i][0];
            }
            return sum;
        }
        int[][] res = new int[m][n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += grid[0][i];
            res[0][i] = sum;
        } 
        sum = 0;
        for(int i = 0; i < m; i++) {
            sum += grid[i][0];
            res[i][0] = sum;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];
    }
}
// @lc code=end

