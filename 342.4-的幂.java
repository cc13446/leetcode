/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n != 0) {
            if (n != 1 && n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        
        return true;
    }
}
// @lc code=end

