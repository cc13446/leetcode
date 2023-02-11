/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
    
        int[] next = new int[s.length()];

        getNext(s, next);

        int t = s.length() - next[s.length() - 1];

        return (s.length() % t) == 0 && t != s.length();
    }

    public void getNext(String s, int[] next) {
        int j = 0;
        next[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
    }
}
// @lc code=end

