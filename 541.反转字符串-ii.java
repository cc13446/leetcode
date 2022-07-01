/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();

        int k2 = k << 1;
        for (int i = 0; i <= res.length; i += k2) {
            reverse(res, i, Math.min(res.length - 1, i + k - 1));
        }
        return new String(res);
    }

    private void reverse(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        } 
    }
}
// @lc code=end

