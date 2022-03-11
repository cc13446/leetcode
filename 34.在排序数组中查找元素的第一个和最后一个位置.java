import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = bSearchLeft(nums, target, 0, nums.length - 1);
        if (res[0] == -1) {
            res[1] = -1;
        } else {
            res[1] = bSearchRight(nums, target, 0, nums.length - 1);
        }
        return res;
    }

    public int bSearchLeft(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[left] == target) {
            return left;
        }
        if (nums[mid] >= target && nums[left] < target) {
            return bSearchLeft(nums, target, left + 1, mid);
        } else if (nums[mid] < target && nums[right] >= target) {
            return bSearchLeft(nums, target, mid + 1, right);
        } else {
            return -1;
        }
    }

    public int bSearchRight(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right + 1) / 2;
        if (nums[right] == target) {
            return right;
        }
        if (nums[mid] > target && nums[left] <= target) {
            return bSearchRight(nums, target, left, mid - 1);
        } else if (nums[mid] <= target && nums[right] > target) {
            return bSearchRight(nums, target, mid, right - 1);
        } else {
            return -1;
        }
    }
}
// @lc code=end

