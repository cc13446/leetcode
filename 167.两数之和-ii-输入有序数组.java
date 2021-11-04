/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0, j = numbers.length - 1; i <= j; ) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
            else {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }
}
// @lc code=end

