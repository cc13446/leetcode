import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] arr = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int u = 0; u < i + 1; u++) {
                arr[u] = triangle.get(i).get(u) + Math.min(arr[u], arr[u + 1]);
            }
        }
        return arr[0];
    }
}
// @lc code=end
