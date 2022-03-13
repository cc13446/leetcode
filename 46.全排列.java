import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        int deep = nums.length;
        dfs(nums, flag, path, res, deep);
        return new LinkedList<>(res);
    }

    private void dfs(int[] nums, boolean[] flag, List<Integer> path, Set<List<Integer>> res, int deep) {
        if (deep == 0) res.add(new LinkedList<>(path));
        for(int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            path.add(nums[i]);
            dfs(nums, flag, path, res, deep - 1);
            path.remove(path.size() - 1);
            flag[i] = false;
        }
    }

}
// @lc code=end

