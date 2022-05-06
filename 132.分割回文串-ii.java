import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                f[j][j + i] = (s.charAt(j) == s.charAt(j + i)) && f[j + 1][j + i - 1];
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++){
            if(f[0][i]){ 
                dp2[i] = 0;
            } else { 
                for(int j = 1; j <= i; j++) {
                    if(f[j][i]) dp2[i] = Math.min(dp2[i], dp2[j - 1] + 1);
                }
            }
        }
        return dp2[n - 1];
    }
}
// @lc code=end

