/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int p = 1, r = 2; p <= n; p = r, r = (r << 1)) {
            int min = Math.min(r, n + 1);
            for (int i = p; i < min; i++) {
                res[i] = res[i - p] + 1;
            }
        }

        return res;
    }
}
// @lc code=end

