/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for(int i = zero + 1; i < two;) {
            if(nums[i] == 0 && i <= zero) {
                i++;
                continue;
            }
            if(nums[i] == 2 && i >= two) {
                i++;
                continue;
            }
            if(nums[i] == 1 && i > zero && i < two) {
                i++;
                continue;
            }
            if(nums[i] == 0) {
                swap(nums, ++zero, i);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

