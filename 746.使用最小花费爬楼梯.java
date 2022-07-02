/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ans = new int[cost.length + 1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            ans[i] = Math.min(ans[i - 2] + cost[i - 2], ans[i - 1] + cost[i - 1]);
        }
        return ans[cost.length];
    }
}
// @lc code=end

