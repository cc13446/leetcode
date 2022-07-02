import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;

        // 背包容量
        sum /= 2;

        int[][] arr = new int[nums.length][sum + 1];

        // 初始化
        for (int i = nums[0]; i <= sum; i++) {
            arr[0][i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i]) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return arr[nums.length - 1][sum] == sum;

    }
}
// @lc code=end

