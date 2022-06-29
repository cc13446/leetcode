import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);


        Deque<Integer> stack = new LinkedList<>();
        // 利用单调栈 求出每个元素左边最近的比其小的元素
        for (int i = 0; i < heights.length; i++)  {
            // 栈中单调递减的存着一个下表序列，弹出比当前元素大的所有元素
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            // 找到了当前元素左边最近的比其小的元素
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            // 当前元素也放到单调栈里面
            stack.push(i);
        }

        int max = 0;
        // 计算面积
        for (int i = 0; i < heights.length; i++) {
            int temp = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(temp, max);
        }
        return max;
    }
}
// @lc code=end

