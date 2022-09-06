/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[] chars = new int[10];
        int[] charg = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int A = 0;
        int B = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) A++;
            chars[s[i] - '0']++;
            charg[g[i] - '0']++;
        } 

        for (int i = 0; i < chars.length; i++) {
            B += Math.min(chars[i], charg[i]);
        }
        B -= A;
        return A + "A" + B + "B";
    }
}
// @lc code=end

