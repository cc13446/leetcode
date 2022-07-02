/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];

        arr[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                arr[j] += arr[j - coins[i]];
            }
        }

        return arr[amount];
    }
}
// @lc code=end

