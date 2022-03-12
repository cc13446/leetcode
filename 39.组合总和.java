import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i, 1);
            path.remove(0);
        }

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index, int deep) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i, deep + 1);
            path.remove(deep);
        }
    }
}
// @lc code=end

