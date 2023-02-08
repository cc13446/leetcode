/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int mid = 0;
        for (; mid < nums.length && nums[mid] < 0; mid++);
        int[] merged = new int[nums.length];
        for (int i = 0, j = mid - 1; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int i1 = 0, i2 = mid, im = 0;
        while(i1 < mid && i2 < nums.length) {
            if (nums[i1] < nums[i2]) {
                merged[im++] = nums[i1++];
            } else {
                merged[im++] = nums[i2++];
            }
        }
        while(i1 < mid) {
            merged[im++] = nums[i1++];
        }
        while(i2 < nums.length) {
            merged[im++] = nums[i2++];
        }

        return merged;

    }
}
// @lc code=end

