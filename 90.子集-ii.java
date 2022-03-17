import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, nums, path, res);
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new LinkedList<>(path));
        for(int i = index; i < nums.length; ) {
            int temp = nums[i];
            path.add(temp);
            dfs(i + 1, nums, path, res);
            path.remove(path.size() - 1);
            
            while(i < nums.length && nums[i] == temp) i++;
        }
    }
}
// @lc code=end

