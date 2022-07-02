/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] arr = new int[n][3];
        arr[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 第i天持有的，以前买的或者拿已有收益买的
            arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][1] - prices[i]);
            // 第i天不持有的收益，以前的收益，或者昨天冷冻解封
            arr[i][1] = Math.max(arr[i - 1][1], arr[i - 1][2]);
            // 第i天被冷冻的收益，今天只要卖出就被冷冻
            arr[i][2] = arr[i][0] + prices[i];
        }

        return Math.max(arr[n - 1][1], arr[n - 1][2]);
    }
}
// @lc code=end

