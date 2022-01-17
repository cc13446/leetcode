/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (; num / 1000 != 0; num -= 1000) res.append("M");
        for (; num / 900 != 0; num -= 900) res.append("CM");
        for (; num / 500 != 0; num -= 500) res.append("D");
        for (; num / 400 != 0; num -= 400) res.append("CD");
        for (; num / 100 != 0; num -= 100) res.append("C");
        for (; num / 90 != 0; num -= 90) res.append("XC");
        for (; num / 50 != 0; num -= 50) res.append("L");
        for (; num / 40 != 0; num -= 40) res.append("XL");
        for (; num / 10 != 0; num -= 10) res.append("X");
        for (; num / 9 != 0; num -= 9) res.append("IX");
        for (; num / 5 != 0; num -= 5) res.append("V");
        for (; num / 4 != 0; num -= 4) res.append("IV");
        for (; num / 1 != 0; num -= 1) res.append("I");
        return res.toString();

    }
}
// @lc code=end

