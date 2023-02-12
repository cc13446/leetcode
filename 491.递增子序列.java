import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int index, int[] nums) {
        int s = path.size();
        if (s > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(s - 1) > nums[i] || used[nums[i] + 100] == 1) continue;

            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            dfs(res, path, i + 1, nums);
            path.remove(s);
        }
    }
}
// @lc code=end

