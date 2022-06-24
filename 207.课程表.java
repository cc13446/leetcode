import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>(numCourses);
        
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new HashSet<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> path = new LinkedList<>();
        for (int key : map.keySet()) {
            if (set.contains(key)) continue;
            set.add(key);
            path.add(key);
            if (!dfs(key, set, path, map)) return false;
            path.remove(path.size() - 1);
        };
        return true;
        
    }

    private boolean dfs(int key, Set<Integer> set, List<Integer> path, Map<Integer, Set<Integer>> map) {
        if (!map.containsKey(key)) return true;
        for (int newKey : map.get(key)) {
            if (path.contains(newKey)) return false;
            if (set.contains(newKey)) continue;
            set.add(newKey);
            path.add(newKey);
            if (!dfs(newKey, set, path, map)) return false;
            path.remove(path.size() - 1);
        };
        return true;
    }

}
// @lc code=end

