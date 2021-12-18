/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int mid = len / 2 + 1;
        double pre = 0;
        double res = 0;
        for(int i = 0, j = 0, k = 0; i < mid; i++) {
            pre = res;
            if (k == nums2.length || j != nums1.length && nums1[j] < nums2[k]) {
                res = nums1[j++];
            } else if (j == nums1.length || k != nums2.length && nums1[j] >= nums2[k]) {
                res = nums2[k++];
            }
        }
        if (len % 2 == 0) return (pre + res)/2;
        return res;
    }
}
// @lc code=end

