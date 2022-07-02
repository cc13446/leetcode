/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // m 个 0 n 个 1
        int[][] arr = new int[m + 1][n + 1];

        for(int i = 0; i < strs.length; i++) {

            String s = strs[i];
            int zero = getZero(s);
            int one = s.length() - zero;

            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    arr[j][k] = Math.max(arr[j][k], 1 + arr[j - zero][k - one]);
                }
            }
        }

        return arr[m][n];
    }

    private int getZero(String s) {
        int sum = 0;
        for (char a : s.toCharArray()) {
            if (a == '0') sum++;
        }
        return sum;
    }
}
// @lc code=end

