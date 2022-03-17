/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        int n = s2.length();
        int[] a = new int[n + 1];
        a[0] = 1;
        for(int i = 1; i <= n; i++) {
            a[i] = a[i - 1] == 1 && s2.charAt(i - 1) == s3.charAt(i - 1) ? 1 : 0;
        }

        for(int i = 1; i <= s1.length(); i++) {
            for (int j = 0; j <= n; j++) {
                a[j] = (a[j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    || (j > 0 && a[j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) 
                    ? 1 : 0;
            }
        }
        return a[n] == 1;
    }
}
// @lc code=end

