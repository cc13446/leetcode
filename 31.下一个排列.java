/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 1;
        for (; i > 0  && nums[i] <= nums[i - 1]; i--);
        // 如果全部都是降序排列
        if (i == 0) {
            for(int j = 0, k = nums.length - 1; j < k; j++, k--) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            }
        } else {
            // 交换的较小数，后面都是降序排列
            i--;
            int min = nums[i];
            // 寻找交换的较大数，降序排列中比较小数稍大的数
            int j = nums.length - 1;
            for (; j > i && nums[j] <= min; j--);
            int max = nums[j];
            // 交换大小数
            nums[i] = max;
            nums[j] = min;
            // 将降序排列逆序
            for(int m = i + 1, n = nums.length - 1; m < n; m++, n--) {
                int temp = nums[m];
                nums[m] = nums[n];
                nums[n] = temp;
            }

        }
    }
}
// @lc code=end

