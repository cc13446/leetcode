/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum *= 10;
            sum += num.charAt(i) - '0';
            if (dfs(i + 1, sum, sum, num, 0)) return true;
        }
        return false;
    }

    private boolean dfs(int index, int sum, int expectSum, String num, int deep) {
        if (deep > 2 && index == num.length()) return true;
        int s = 0;
        for (int i = index; i < num.length(); i++) {
            s *= 10;
            s += num.charAt(i) - '0';
            System.out.println(s);
            if (s == expectSum && dfs(i + 1, s, sum + s, num, deep + 1)) return true;
        }
        return false;
    }
}
// @lc code=end

