import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] array = new int[m][n];
        array[m - 1][n - 1] = -Math.min(0, dungeon[m - 1][n - 1]);
        for (int i = m - 2; i > -1; i--) {
            array[i][n - 1] = Math.max(0, array[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        for (int i = n - 2; i > -1; i--) {
            array[m - 1][i] = Math.max(0, array[m - 1][i + 1] - dungeon[m - 1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                array[i][j] = Math.max(0, Math.min(array[i + 1][j], array[i][j + 1]) - dungeon[i][j]);
            }
        }

        return 1 + array[0][0];
    }
}
// @lc code=end

