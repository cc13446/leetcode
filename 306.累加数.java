/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        int first = 0;
        for (int i = 0; i < num.length(); i++) {
            first *= 10;
            first += num.charAt(i) - '0';
            int sum = 0;
            for (int j = i + 1; j < num.length(); j++) {
                sum *= 10;
                sum += num.charAt(j) - '0';
                System.out.println("f"+first);
                System.out.println("s"+sum);
                if (dfs(j + 1, sum, sum + first, num, 2)) return true;
                if (num.charAt(i + 1) == '0') break;
            }
            if (num.charAt(0) == '0') break;
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
            if (num.charAt(index) == '0') break;
        }
        return false;
    }
}
// @lc code=end

