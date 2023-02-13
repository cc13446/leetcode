import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0; i--) {
            if (s[j] >= g[i]) {
                res++;
                j--;
            }
        }

        return res;
    }
}
// @lc code=end

