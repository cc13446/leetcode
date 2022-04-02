import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : nums) {
            if(!map.getOrDefault(i, false)) {
                map.put(i, true);
            } else {
                return true;
            }
        }
        return false;

    }
}
// @lc code=end

