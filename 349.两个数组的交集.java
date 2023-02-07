import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* @lc app=leetcode.cn id=349 lang=java
*
* [349] 两个数组的交集
*/

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) {
            int left = 0, right = nums1.length - 1;
            int num = nums2[i];
            while(left <= right) {
                int mid = (left + right) / 2;
                if (nums1[mid] < num) {
                    left = mid + 1;
                } else if (nums1[mid] > num) {
                    right = mid - 1;
                } else {
                    res.add(num);
                    break;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
