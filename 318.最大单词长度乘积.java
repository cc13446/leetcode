/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        long[] bits = new long[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (char c : s.toCharArray()) {
                bits[i] |= 1 << c - 'a';
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
// @lc code=end

