/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int l = 0;
        int r = height.length - 1;
        int maxArea = getArea(height, l, r);
        while (l < r) {
            if (height[l] < height[r]){
                int nextL = l;
                for (; nextL < r && height[nextL] <= height[l]; nextL++); 
                l = nextL;
            } else {
                int nextR = r;
                for (; nextR > l && height[nextR] <= height[r]; nextR--);
                r = nextR;
            }
            maxArea = Math.max(maxArea, getArea(height, l, r));           
        }
        return maxArea;
    }
    public int getArea(int[] height,int l, int r) {
        return (r - l) * (height[l] > height[r] ? height[r] : height[l]);
    }
}
// @lc code=end

