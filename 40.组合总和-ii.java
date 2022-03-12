import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i + 1, 1);
            while(i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
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
            dfs(res, path, candidates, target - candidates[i], i + 1, deep + 1);
            while(i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
            path.remove(deep);
        }
    }
}
// @lc code=end

