/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][] arr = new int[prices.length][2];
        arr[0][0] = 0;
        arr[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            arr[i][0] = Math.max(arr[i - 1][0], prices[i] + arr[i - 1][1]);
            arr[i][1] = Math.max(arr[i - 1][1], -prices[i] + arr[i - 1][0]);
        }

        return arr[prices.length - 1][0];
    }
}
// @lc code=end

