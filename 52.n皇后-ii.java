import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        int[][] array = new int[n][n];
        List<List<String>> res = new LinkedList<>();
        dfs(res, array, 0);
        return res.size();
    }

    private void dfs(List<List<String>> res, int[][] array, int line) {
        if (line == array.length) {
            List<String> temp = new LinkedList<>();
            for(int i = 0; i < array.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < array.length; j++) {
                    if (array[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        } else {
            for(int i = 0; i < array.length; i++) {
                array[line][i] = 1;
                if(valid(array, line, i)) {
                    dfs(res, array, line + 1);
                }
                array[line][i] = 0;
            }
        }
    }

    private boolean valid(int[][] array, int i, int j) {
        for (int x = 0; x < array.length; x++) {
            if(x != j && array[i][x] == 1) return false;
            if(x != i && array[x][j] == 1) return false;
        }
        int sum = i + j;
        if (sum >= array.length) {
            for (int x = array.length - 1; x >= 0 && sum - x < array.length && sum - x >= 0 ; x--) {
                if(x != i && array[x][sum - x] == 1) return false;
            }
        } else {
            for (int x = 0; x < array.length && sum - x < array.length && sum - x >= 0 ; x++) {
                if(x != i && array[x][sum - x] == 1) return false;
            }
        }
        if (i > j) {
            int d = i - j;
            for (int x = 0; x < array.length  &&  x + d < array.length ; x++) {
                if(x != j && array[x + d][x] == 1) return false;
            }
        } else {
            int d = j - i;
            for (int x = 0; x < array.length && x + d < array.length; x++) {
                if(x != i && array[x][x + d] == 1) return false;
            }
        }
        return true;

    }
}
// @lc code=end

