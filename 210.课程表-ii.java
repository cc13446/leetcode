import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] arr = new int[numCourses][numCourses];
        int[] visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            arr[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                int r = dfs(i, arr, visited, res);
                if (r == -1) return new int[0];
                if (r == 1) break;
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

    private int dfs(int i, int[][] arr, int[] visited, List<Integer> res) {
        if (res.size() == arr.length) return 1;
        visited[i] = 1;
        for (int j = 0; j < arr.length; j++) {
            if(arr[i][j] == 1 && visited[j] == 1) {
                return -1;
            } else if(arr[i][j] == 1){
                int r = dfs(j, arr, visited, res);
                if (r == -1 || r == 1)  return r;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j][i] = 0;
        }
        res.add(i);
        return 0;
    }
}
// @lc code=end

