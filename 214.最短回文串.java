/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        int[] next = new int[n];
        getNext(s, next);

        int best = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (best > 0 && s.charAt(i) != s.charAt(best)) best = next[best - 1];
            if (s.charAt(i) == s.charAt(best)) best++;
        }

        String add = (best == n ? "" : s.substring(best));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();        
    }

    private void getNext(String s, int[] next) {
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while(j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
    }

}
// @lc code=end

