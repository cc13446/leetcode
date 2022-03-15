/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        for(; i < m && matrix[i][n - 1] < target; i++);
        if (i == m) {
            return false; 
        }
        int j = 0;
        for(; j < n && matrix[i][j] < target; j++);
        if (j == n) {
            return false;
        }
        return matrix[i][j] == target;
    }
}
// @lc code=end

