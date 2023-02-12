import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> (a.get(1).compareTo(b.get(1))));
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> s = tickets.get(i);
            List<Integer> l = map.getOrDefault(s.get(0), new LinkedList<>());
            l.add(i);
            map.put(s.get(0), l);
        }
        List<String> path = new ArrayList<>();
        String start = "JFK";
        path.add(start);
        List<String> res = new ArrayList<>();
        int[] used = new int[tickets.size()];
        dfs(res, path, map, start, tickets, used);
        return res;
    }

    private void dfs(List<String> res, List<String> path, Map<String, List<Integer>> map, String start, List<List<String>> tickets, int[] used) {

        if (!res.isEmpty()) return;

        if (path.size() == tickets.size() + 1) {
            if (res.isEmpty()) {
                res.addAll(path);
            }
            
        }
        
        List<Integer> l = map.get(start);
        if (l == null) return;
        for (int i : l) {
            if (used[i] == 1) continue;
            String end = tickets.get(i).get(1);
            path.add(end);
            used[i] = 1;
            dfs(res, path, map, end, tickets, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
// @lc code=end

