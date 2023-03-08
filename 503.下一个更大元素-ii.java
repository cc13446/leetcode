import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            while(!q.isEmpty() && nums[q.peek()] < nums[index]) {
                int t = q.pop();
                if (res[t] == -1) {
                    res[t] = nums[index];
                }
            }
            q.push(index);
        }



        return res;
    }
}
// @lc code=end

