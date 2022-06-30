import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> s = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!s.isEmpty() && nums[s.peekLast()] < nums[i]) {
                s.pollLast();
            }
            s.offerLast(i);
        }
        System.out.println(s);
        ans[0] = nums[s.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!s.isEmpty() && nums[s.peekLast()] < nums[i]) {
                s.pollLast();
            }
            s.offerLast(i);

            int leave = i - k;
            while (!s.isEmpty() && s.getFirst() <= leave) {
                s.pollFirst();
            }
            ans[leave + 1] =  nums[s.getFirst()];
        }

        return ans;
    }
}
// @lc code=end

