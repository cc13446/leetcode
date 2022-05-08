/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) sum += ((n >> i) & 1);

            if (sum % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
// @lc code=end

