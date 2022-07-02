/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n < 1) {
            return 0;
        }

        if (n < 2) {
            return nums[0];
        }

        int[] arr = new int[n];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
        }

        return arr[n - 1];
    }
}
// @lc code=end

