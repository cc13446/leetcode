import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
// @lc code=end

