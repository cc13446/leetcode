import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++)
            pq.add(new int[] { primes[i], 0, i });
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n;) {
            int[] tmp = pq.poll();
            // 丑数，下一个该乘的丑数，质因数
            int val = tmp[0], idx = tmp[1] + 1, p = tmp[2];
            if (val != dp[i - 1])
                dp[i++] = val;
            pq.add(new int[] { dp[idx] * primes[p], idx, p });
        }
        return dp[n - 1];
    }
}
// @lc code=end
