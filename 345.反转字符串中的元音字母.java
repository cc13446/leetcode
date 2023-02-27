/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            while (i < str.length && !is(str[i])) {
                i++;
            }
            while (j >= 0 && !is(str[j])) {
                j--;
            }
            if (i < j) {
                swap(str, i, j);
            }            
        }
        return new String(str);
    }
    private boolean is(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] t, int i, int j) {
        char temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
// @lc code=end

