/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || right == 0) return 0;
        int[] low = new int[32];
        int lowIndex = -1;
        int[] high = new int[32];
        int highIndex = -1;
        for (; lowIndex < 32 && left != 0; left >>= 1) {
            low[++lowIndex] = left % 2;
        }
        for (; highIndex < 32 && right != 0; right >>= 1) {
            high[++highIndex] = right % 2;
        }
        if (lowIndex != highIndex) return 0;
        boolean flag = false;
        int res = 0;
        for (int i = lowIndex; i >= 0; i--) {
            if (low[i] == high[i]) {
                flag = true;
                if (low[i] == 1) {
                    res += Math.pow(2, i);
                }
            } else if (flag) {
                break;
            }
        }
        return res;
    }
}
// @lc code=end

