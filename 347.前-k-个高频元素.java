import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(map.size(), (a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll().getKey();
        }

        return res;
    }
}
// @lc code=end

