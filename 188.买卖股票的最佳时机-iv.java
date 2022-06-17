import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        // 都初始化为第0天买了没动
        Arrays.fill(buy, -prices[0]);
        // 第i天的交易
        // 原本是三维的 变成二维，两个一维了
        for (int i = 1; i < prices.length; i++) {
            // 第0次买入，要么维持以前的不动，要么改为从今天开始
            buy[0] = Math.max(buy[0], -prices[i]);
            // 第0次卖出，要么维持以前的不动，要么改为今天卖出
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }
}
// @lc code=end
