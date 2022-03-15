/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] place = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, word, board, place)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k, String word, char[][] board, int[][] place) {
        if(board[i][j] != word.charAt(k)) {
            return false;
        } else {
            if(place[i][j] == 1) return false;
            else place[i][j] = 1;
            if(k == word.length() - 1) {
                return true;
            }
            boolean flag = false;
            if(i > 0) {
                flag = dfs(i - 1, j, k + 1, word, board, place);
                if(flag) return true;
            } 
            if (i < board.length - 1) {
                flag = dfs(i + 1, j, k + 1, word, board, place);
                if(flag) return true;
            } 
            if (j > 0) {
                flag = dfs(i, j - 1, k + 1, word, board, place);
                if(flag) return true;
            } 
            if (j < board[0].length - 1) {
                flag = dfs(i, j + 1, k + 1, word, board, place);
                if(flag) return true;
            }
            place[i][j] = 0;
        }
        return false;
    }
}
// @lc code=end

