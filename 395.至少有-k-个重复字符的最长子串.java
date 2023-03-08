/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;

        for (int t = 1; t < 26; t++) {
            int[] map = new int[26];
            int total = 0;
            int lower = 0;
            int left = -1;
            int right = 0;
            while (right < s.length()) {
                char str = s.charAt(right);
                int diff = str - 'a';
                map[diff]++;
                if (map[diff] == 1) {
                    total++;
                    lower++;
                }
                if (map[diff] == k) {
                    lower--;
                }

                while(total > t && left < right) {
                    char leave = s.charAt(++left);
                    diff = leave - 'a';
                    map[diff]--;
                    if (map[diff] == 0) {
                        total--;
                        lower--;
                    }
                    if (map[diff] == k - 1) {
                        lower++;
                    }
                }

                if (lower == 0) {
                    res = Math.max(res, right - left);
                } 
                right++;
            }
        }

        return res;
    }
}
// @lc code=end

