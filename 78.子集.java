import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        List<Integer> path = new LinkedList<>();
        for(int i = 1; i <= nums.length; i++) {
            dfs(0, nums, i, path, res);
        }
        return res;
    }

    private void dfs(int index, int[] nums, int deep, List<Integer> path, List<List<Integer>> res) {
        if(deep == 0) {
            res.add(new LinkedList<>(path));
            return;
        } 
        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, nums, deep - 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

