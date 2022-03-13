/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ) {
            if (nums[i] == 0) return false;
            int maxJump = nums[i];
            int max = 0;
            int nextI = 0;
            if (maxJump + i >= n - 1) return true;
            for(int k = i + 1; k <= i + maxJump; k++) {
                int temp = nums[k] + k - i;
                if (temp > max) {
                    max = temp;
                    nextI = k;
                }
            }
            i = nextI;
        }
        return true;
    }
}
// @lc code=end

