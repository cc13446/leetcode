/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }

        int lastBitOneIndex = 0;
        for (;lastBitOneIndex < 32; lastBitOneIndex++) {
            if ((res & 1) == 1) break;
            res >>= 1;
        }

        int mask = 1 << lastBitOneIndex;

        int res1 = 0;
        int res2 = 0;
        for (int n : nums) {
            if ((n & mask) == 0) {
                res1 ^= n;
            } else {
                res2 ^= n;
            }
        }
        return new int[]{res1, res2};
    }
}
// @lc code=end

