import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[]{0, Integer.MAX_VALUE, 0});
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < buildings.length; i++) {
            q.offer(buildings[i][0]);
            q.offer(buildings[i][1]);
        }
        int right = 0;
        int preH = 0;
        for (int i = 0; !q.isEmpty();) {
            right = q.poll();
            while (i < buildings.length && buildings[i][0] == right) {
                queue.offer(buildings[i]);
                i++;
            }
            while(!queue.isEmpty() && queue.peek()[1] <= right) {
                queue.poll();
            }
            if (queue.isEmpty()) queue.offer(new int[]{0, Integer.MAX_VALUE, 0});
            if (queue.peek()[2] != preH) {
                preH = queue.peek()[2];
                res.add(Arrays.asList(right, preH));
            }
        }
        return res;
    }
}
// @lc code=end

