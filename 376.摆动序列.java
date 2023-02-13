/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return 1;
        int[] d = new int[n - 1];
        int index = 0;

        for (int i = 0; i < d.length; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff != 0) d[index++] = diff;
        }
        if (index < 1) return 1;
        int res = 2;
        boolean f = d[0] > 0;
        for (int i = 1; i < index; i++) {
            boolean t = d[i] > 0;
            if (t == !f) {
                res++;
                f = t;
            }
        }

        return res;
    }
}
// @lc code=end


