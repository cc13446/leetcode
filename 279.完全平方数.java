import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        int max = (int)Math.pow(n, 0.5);

        for (int i = 1; i <= max; i++) {
            int good = i * i;
            for (int j = good; j <= n; j++) {
                arr[j] = Math.min(arr[j], arr[j - good] + 1);
            }
        }

        return arr[n];
    }
}
// @lc code=end

