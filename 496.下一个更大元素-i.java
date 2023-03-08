import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] map = new int[10001];
        for (int i = 0; i < nums1.length; i++) {
            map[nums1[i]] = i + 1;
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < nums2.length; i++) {
            while(!s.isEmpty() && nums2[i] > s.peek()) {
                int t = s.pop();
                if (map[t] != 0) {
                    res[map[t] - 1] = nums2[i];
                }
            }

            s.push(nums2[i]);
        }
        
        return res;
    }
}
// @lc code=end

