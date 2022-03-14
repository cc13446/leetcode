/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(m == 1 || n == 1) {
            if(m == 1){
                for(int i = 0; i < n; i++) {
                    if(obstacleGrid[0][i] == 1) return 0;
                }
            }
            else if(n == 1){
                for(int i = 0; i < m; i++) {
                    if(obstacleGrid[i][0] == 1) return 0;
                }
            }
            return 1;
        }
        int[][] res = new int[m][n];
        int p = 1;
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                p = 0;
            } 
            res[i][0] = p;
        }
        p = 1;
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                p = 0;
            } 
            res[0][i] = p;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res[m - 1][n - 1];
    }
}
// @lc code=end

