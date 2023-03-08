/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int n = (int) Math.pow(num, 0.5);
        return num == n * n || num == (n + 1) * (n + 1);
    }
}
// @lc code=end

