/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        if (n == 1) return 0;
        for (int i = 0; i < n; ) {
            int maxJump = nums[i];
            int max = 0;
            int nextI = 0;
            if (i + nums[i] >= n - 1) return res + 1;
            for(int k = i + 1; k <= i + maxJump && k < n; k++) {
                int temp = nums[k] + k - i;
                if (temp > max && nums[k] != 0) {
                    max = temp;
                    nextI = k;
                }
                if (i + max >= n - 1) return res + 2;
            }
            i = nextI;
            res ++;
        }
        return -1;
    }
}
// @lc code=end

