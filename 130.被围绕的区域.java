/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    final char O = 'O';
    final char X = 'X';
    final char T = 'T';

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        } 

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O) board[i][j] = X;
                else if (board[i][j] == T) board[i][j] = O;
            }
        }
    }

    public void dfs(char[][] board, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != O) {
            return;
        }
        board[x][y] = T;
        dfs(board, x + 1, y, m, n);
        dfs(board, x - 1, y, m, n);
        dfs(board, x, y + 1, m, n);
        dfs(board, x, y - 1, m, n);
    }
}
// @lc code=end

