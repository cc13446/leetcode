/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int i = 0; 
        int j = height.length - 1;
        for (; i < height.length && height[i] == 0; i++);
        for (; j > i && height[j] == 0; j--);
        return _trap(height, i, j);
    }

    public int _trap(int[] height, int left, int right) {
        if (left >= right) return 0;
        int max = height[left] > height[right] ? height[right] : height[left];
        int maxIndex = -1;
        for (int i = left + 1; i < right; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            return _trap(height, left, maxIndex) + _trap(height, maxIndex, right);
        } else {
            int res = max * (right - left - 1);
            for (int i = left + 1; i < right; i++) {
                res -= height[i];
            }
            return res;
        }

    }
}
// @lc code=end

