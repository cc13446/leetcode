/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int rightSum = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightSum *= nums[i + 1];
            ans[i] *= rightSum;
        }

        return ans;
    }
}
// @lc code=end

