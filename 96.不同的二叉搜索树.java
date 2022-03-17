/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    // 19/19 cases passed (2531 ms)
    // Your runtime beats 5 % of java submissions
    // Your memory usage beats 45.34 % of java submissions (38 MB)
    // 
    // public int numTrees(int n) {
    //     if(n == 1 || n == 0) return 1;
    //     int res = 0;
    //     for(int i = 1; i <= n; i++) {
    //         res += numTrees(i - 1) * numTrees(n - i);
    //     }
    //     return res;
    // }

    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int[] a = new int[n + 2];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                a[i] += a[j - 1] * a[i - j];
            }
        }
        return a[n];
    }
}
// @lc code=end

