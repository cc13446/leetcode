import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int right = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < right; ) {
            int temp = map.getOrDefault(nums[i], 0);
            if(temp >= 2) {
                right--;
                for(int j = i; j < right; j++) {
                    nums[j] = nums[j + 1];
                }
            } else {
                map.put(nums[i], temp + 1);
                i++;
            }
        }
        return right;
    }
}
// @lc code=end

