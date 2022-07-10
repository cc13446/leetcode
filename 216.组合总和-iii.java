import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        int sum = 0;
        List<Integer> path = new LinkedList<>();
        dfs(1, sum, path, res, k, n);
        return res;
    }

    private void dfs(int index, int sum, List<Integer> path, List<List<Integer>> res, int k, int n) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            path.add(i);
            dfs(i + 1, sum + i, path, res, k, n);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

