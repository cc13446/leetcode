/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int i, int j){
        if (board[i][j] != '.'){ // 跳过原始数字
            int nextJ = j;
            int nextI = i;
            if (nextJ == 8 && nextI == 8) {
                return true;
            } else if (nextJ == 8) {
                nextI++;
                nextJ = 0;
            } else {
                nextJ++;
            }
            return solveSudokuHelper(board, nextI, nextJ);
        }
        for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
            if (isValidSudoku(i, j, k, board)){
                board[i][j] = k;
                int nextJ = j;
                int nextI = i;
                if (nextJ == 8 && nextI == 8) {
                    return true;
                } else if (nextJ == 8) {
                    nextI++;
                    nextJ = 0;
                } else {
                    nextJ++;
                }
                if (solveSudokuHelper(board, nextI, nextJ)){ 
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }


     /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

