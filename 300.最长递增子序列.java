import java.util.Stack;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] small = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            small[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int res = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = small[i];
            int max = -1;
            for (int j = temp; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, arr[j]);
                }
            }
            arr[i] = temp == -1 ? 1 : max + 1;
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
// @lc code=end

