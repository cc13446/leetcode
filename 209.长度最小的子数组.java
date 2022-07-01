/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int left = -1, right = 0; right < nums.length; right++){
            sum += nums[right];
            if (sum >= target) {
                while (sum >= target) sum -= nums[++left];
                min = Math.min(min, right - left + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;

    }
}
// @lc code=end

