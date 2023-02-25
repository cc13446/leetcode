/*
 * @lc app=leetcode.cn id=330 lang=java
 *
 * [330] 按要求补齐数组
 */

// @lc code=start
class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        long total = 0;
        int index = 0;
        
        while (total < n) {
            if (index < nums.length && nums[index] <= total + 1) {
                total += nums[index++];
            } else {
                res++;
                total = total * 2 + 1;
            }
        }

        return res;
    }
}
// @lc code=end

