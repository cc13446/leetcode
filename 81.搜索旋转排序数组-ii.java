/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        return bSearch(0, nums.length - 1, nums, target);
    }

    private boolean bSearch(int l, int r, int[] nums, int target) {
        if(l > r) return false;
        int mid = (l + r) / 2;
        if(nums[mid] == target) return true;
        if(nums[l] == nums[mid] && nums[r] == nums[mid] ) {
            return bSearch(l, mid - 1, nums, target) || bSearch(mid + 1, r, nums, target);
        } else if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) {
                return bSearch(l, mid - 1, nums, target);
            } else {
                return bSearch(mid + 1, r, nums, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[r]) {
                return bSearch(mid + 1, r, nums, target);
            } else {
                return bSearch(l, mid - 1, nums, target);
            }
        }
    }
}
// @lc code=end

