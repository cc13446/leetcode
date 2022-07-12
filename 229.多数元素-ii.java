import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0, element2 = 0, vote1 = 0, vote2 = 0;

        for (int n : nums) {
            if (vote1 > 0 && n == element1) {
                vote1++;
            } else if (vote2 > 0 && n == element2) {
                vote2++;
            } else if (vote1 == 0) {
                element1 = n;
                vote1 ++;
            } else if (vote2 == 0) {
                element2 = n;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        // 检测元素出现的次数是否满足要求
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }
        return ans;
    }
}
// @lc code=end

