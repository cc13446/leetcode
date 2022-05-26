import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;

        int res = 2;
        for (int i = 0; i < points.length; i++) {
            int max = 2;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx = dx / g;
                dy = dy / g;
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                }
                String key = String.valueOf(dx) + "/" + String.valueOf(dy);
                int t = map.getOrDefault(key, 1);
                t++;
                map.put(key, t);
                max = Math.max(max, t);
            }
            res = Math.max(max, res);
        }
        return res;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
// @lc code=end

