import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, n, k, path, res);
        return res;
    }

    private void dfs(int index, int n, int k, List<Integer> path, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = index; i < n; i++) {
            path.add(i + 1);
            dfs(i + 1, n, k - 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

