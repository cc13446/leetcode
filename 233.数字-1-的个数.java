/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        long mulk = 1;
        int ans = 0;
        while (n >= mulk) {
            // 从个位到最高位计算
            // 比如 1234567 计算百位上的1出现的次数
            // 对于 1234000 百位上的1出现了 1234 个 100次
            // 对于 567 
            // 如果 567 比 200 大，就出现了完整的100次
            // 如果 167 比 100 大但是比 200 小，就出现了 167 - 100 + 1 次
            // 如果 099 比 100 小，就出现了 0 次
            // 所以对于 c = n % 1000
            // 先计算 r = c - 100 + 1, 但是 r 上限为 100，下限为 0
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}

// @lc code=end

