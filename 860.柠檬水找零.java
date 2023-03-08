/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] a = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                a[0]++;
            } else if (bills[i] == 10) {
                if (a[0] == 0) return false;
                else a[0]--;
                a[1]++;
            } else {
                if (a[1] > 0 && a[0] > 0) {
                    a[1]--;
                    a[0]--;
                } else if (a[0] > 2) {
                    a[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    
}
// @lc code=end

