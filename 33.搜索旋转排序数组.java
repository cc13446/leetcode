/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length - 1);
    }

    public int bSearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[left] < nums[mid] && target < nums[mid] && target >= nums[left]) {
            return bSearch(nums, target, left, mid - 1);
        } else if (nums[left] > nums[mid] && (target < nums[mid] || target >= nums[left])) {
            return bSearch(nums, target, left, mid - 1);
        } else if (nums[mid] < nums[right] && target <= nums[right] && target > nums[mid]) {
            return bSearch(nums, target, mid + 1, right);
        } else if (nums[mid] > nums[right] && (target <= nums[right] || target > nums[mid])) {
            return bSearch(nums, target, mid + 1, right);
        }
        return -1;
    }
}
// @lc code=end

