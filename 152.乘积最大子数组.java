/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;

        for (int i = 1; i < nums.length; i++) {
            int ax = max;
            int in = min;
            max = Math.max(nums[i], Math.max(in * nums[i], ax * nums[i]));
            min = Math.min(nums[i], Math.min(in * nums[i], ax * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
// @lc code=end

