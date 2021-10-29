/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] == val) {
                for (; l - 1 > i && nums[l - 1] == val; l--);
                nums[i] = nums[l - 1];
                l--;
            }
        }
        return l;
    }
}
// @lc code=end
