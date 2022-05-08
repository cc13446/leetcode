/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int firstIndex = 0;
        while(firstIndex < n) {
            // 找到起点
            while(firstIndex < n && cost[firstIndex] > gas[firstIndex]) {
                firstIndex++;
            }
            if(firstIndex >= n) return -1;
            // 尝试走一圈
            int rest = 0;
            int i = 0;
            for (; i < n; i++) {
                rest = rest + gas[(firstIndex + i) % n] - cost[(firstIndex + i) % n];
                if (rest < 0) {
                    // 如果绕到了前面
                    if(firstIndex + i > n) return -1;
                    break;
                }
            }
            // 走完了返回
            if (i == n) return firstIndex;
            // 没走完从上一次的下一站开始考虑
            firstIndex += (i + 1);
        }
        return -1;
    }
}
// @lc code=end

