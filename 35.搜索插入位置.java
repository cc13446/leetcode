/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public int helper(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (target > nums[left]) return left + 1;
            else if (target < nums[left]) return left;
            else return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return helper(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return helper(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
// @lc code=end
