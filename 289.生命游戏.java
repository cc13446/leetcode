/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    final int LIVE_TO_DIE = 2;
    final int DIE_TO_LIVE = 3;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                sum += live(i - 1, j - 1, m, n, board);
                sum += live(i - 1, j, m, n, board);
                sum += live(i - 1, j + 1, m, n, board);
                sum += live(i, j - 1, m, n, board);
                sum += live(i, j + 1, m, n, board);
                sum += live(i + 1, j - 1, m, n, board);
                sum += live(i + 1, j, m, n, board);
                sum += live(i + 1, j + 1, m, n, board);
                if (sum < 2 && board[i][j] == 1) board[i][j] = LIVE_TO_DIE;
                else if (sum > 3 && board[i][j] == 1) board[i][j] = LIVE_TO_DIE;
                else if (sum == 3 && board[i][j] == 0) board[i][j] = DIE_TO_LIVE;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE_TO_DIE) board[i][j] = 0;
                if (board[i][j] == DIE_TO_LIVE) board[i][j] = 1;
            }
        }
    }

    private int live(int i, int j, int m, int n, int[][] board) {
        return valid(i, j, m, n) && (board[i][j] == 1 || board[i][j] == LIVE_TO_DIE) ? 1 : 0;
    }


    private boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
// @lc code=end

