import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!q.isEmpty() && temperatures[i] > temperatures[q.peek()]) {
                int t = q.pop();
                res[t] = i - t;
            }
            q.push(i);
        }
        return res;
    }
}
// @lc code=end

