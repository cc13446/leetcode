/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum < target || (sum - target) % 2 == 1) return 0;

        int bagSize = (sum - target) / 2;
        int[] arr = new int[bagSize + 1];
        arr[0] = 1;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                arr[j] += arr[j - nums[i]];
            }
        }

        return arr[bagSize];
    }
}
// @lc code=end

