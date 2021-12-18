/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int[] flag = new int[nums.length + 1];
        for (int i : nums) {
            flag[i] = 1;
        }
        for(int i = 0; i < flag.length; i++) {
            if (flag[i] != 1) return i;
        }
        return 0;
    }
}
// @lc code=end

