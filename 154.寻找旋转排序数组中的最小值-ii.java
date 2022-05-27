/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0]; 
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        if (nums[i] < nums[j]) {
            return nums[i];
        }
        int mid = (i + j) / 2;
        return Math.min(helper(nums, i, mid), helper(nums, mid + 1, j));
    }
}
// @lc code=end

