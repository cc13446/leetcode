/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        if(dividend == divisor) {
            return 1;
        }
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if(divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        boolean flag = false;
        int ans = 0;
        if(divisor > 0) {
            divisor = -divisor;
            flag = (flag == true ? false : true);
        }
        if(dividend > 0) {
            dividend = -dividend;
            flag = (flag == true ? false : true);
        }   
        while(dividend <= divisor) {
            int x = 1;
            int d = divisor;
            while(d > -1e9 && dividend <= d + d) {      
                x += x;
                d += d;
            }
            ans += x;
            dividend -= d;  
        }
        return flag == true ? -ans : ans;
    }
}
// @lc code=end

