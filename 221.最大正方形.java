/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {

        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = matrix[i][0] - '0';
            maxSide = Math.max(maxSide, arr[i][0]);
        }
        for (int j = 0; j < n; j++) {
            arr[0][j] = matrix[0][j] - '0';
            maxSide = Math.max(maxSide, arr[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = Math.min(arr[i - 1][j],Math.min(arr[i][j - 1], arr[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, arr[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
// @lc code=end

