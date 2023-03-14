/*
 * @lc app=leetcode.cn id=1605 lang=java
 *
 * [1605] 给定行和列的和求可行矩阵
 */

// @lc code=start
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                int t = Math.min(rowSum[i], colSum[j]);
                res[i][j] = t;
                rowSum[i] -= t;
                colSum[j] -= t;

            }
        }

        return res;
    }
}
// @lc code=end

