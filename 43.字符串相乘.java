/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        int n = num1.length();
        int m = num2.length();
        String shorter = null;
        String longer = null;
        if (n > m) {
            longer = num1;
            shorter = num2;
        } else {
            longer = num2;
            shorter = num1;
        }
        for(int i = shorter.length() - 1; i >= 0; i--) {
            Character c = shorter.charAt(i);
            res = plus(res, simpleMultify(c, longer));
            longer += "0";
            //System.out.println(res);
        }
        int i = 0;
        for(; i < res.length() && res.charAt(i) == '0'; i++);
        res = res.substring(i);
        if (res == "") res = "0";
        return res;

    }

    public String simpleMultify(Character num1, String num2) {
        String res = "0";
        for(int i = num2.length() - 1; i >= 0; i--) {
            int j = num2.length() - i - 1;
            Character c = num2.charAt(i);
            String temp = String.valueOf((c - '0') * (num1 - '0'));
            for (int k = 0; k < j; k++) temp += 0;
            res = plus(temp, res);
        }
        System.out.println(res);
        return res;
    }

    public String plus(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n = num1.length();
        int m = num2.length();
        String shorter = null;
        String longer = null;
        if (n > m) {
            longer = num1;
            shorter = num2;
        } else {
            longer = num2;
            shorter = num1;
        }
        int p = 0;
        int d = longer.length() - shorter.length();
        for (int i = shorter.length() - 1; i >= 0; i--) {
            int temp = p + (shorter.charAt(i) - '0') + (longer.charAt(i + d) - '0');
            p = temp / 10;
            String s = String.valueOf(temp % 10);
            res.append(s);
            //System.out.println(res);
        }
        for (int i = d - 1; i >= 0; i--) {
            int temp = p + (longer.charAt(i) - '0');
            p = temp / 10;
            String s = String.valueOf(temp % 10);
            res.append(s);
        }
        if (p != 0) res.append(p);
        return res.reverse().toString();
    }
}
// @lc code=end

