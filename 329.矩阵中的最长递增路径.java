/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] flag = new int[m][n];
        int[][] mem = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mem[i][j] == 0) {
                    mem[i][j] = helper(matrix, flag, mem, i, j);
                }
                res = Math.max(res, mem[i][j]);
            }
        }

        return res;
    }

    public int helper(int[][] matrix, int[][] flag, int[][] mem, int i, int j) {

        int m = matrix.length;
        int n = matrix[0].length;

        flag[i][j] = 1;

        int res = 1;

        if (isValid(m, n, i + 1, j) && matrix[i + 1][j] > matrix[i][j] && flag[i + 1][j] != 1) {
            if (mem[i + 1][j] != 0) {
                res = Math.max(res, 1 + mem[i + 1][j]);
            } else {
                res = Math.max(res, 1 + helper(matrix, flag, mem, i + 1, j));
            }
            
        }
        if (isValid(m, n, i - 1, j) && matrix[i - 1][j] > matrix[i][j] && flag[i - 1][j] != 1) {
            if (mem[i - 1][j] != 0) {
                res = Math.max(res, 1 + mem[i - 1][j]);
            } else {
                res = Math.max(res, 1 + helper(matrix, flag, mem, i - 1, j));
            }
        }
        if (isValid(m, n, i, j + 1) && matrix[i][j + 1] > matrix[i][j] && flag[i][j + 1] != 1) {
            if (mem[i][j + 1] != 0) {
                res = Math.max(res, 1 + mem[i][j + 1]);
            } else {
                res = Math.max(res, 1 + helper(matrix, flag, mem, i, j + 1));
            }
        }
        if (isValid(m, n, i, j - 1) && matrix[i][j - 1] > matrix[i][j] && flag[i][j - 1] != 1) {
            if (mem[i][j - 1] != 0) {
                res = Math.max(res, 1 + mem[i][j - 1]);
            } else {
                res = Math.max(res, 1 + helper(matrix, flag, mem, i, j - 1));
            }
        }

        flag[i][j] = 0;
        mem[i][j] = res;
        return res;
    }

    private boolean isValid(int m, int n, int i, int j) {
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }
}
// @lc code=end

