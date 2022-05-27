import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        long base = 1;
        int n = nums.length;
        int[] buf = new int[n];
        int max = Arrays.stream(nums).max().getAsInt();
        while (base <= max) {
            int[] cnf = new int[10];
            for (int i = 0; i < n; i++) {
                cnf[(nums[i] / (int) base ) % 10]++;
            }
            for (int i = 1; i < cnf.length; i++) {
                cnf[i] += cnf[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                buf[ --cnf[(nums[i] / (int) base) % 10]] = nums[i];
            }

            System.arraycopy(buf, 0, nums, 0, n);
            base *= 10;
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
// @lc code=end

