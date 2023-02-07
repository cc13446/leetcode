/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] s = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = nums[i] + s[i];
        }
        return merge(s, lower, upper, 0, s.length - 1);
    }

    private int merge(long[] s, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = merge(s, lower, upper, left, mid) 
                + merge(s, lower, upper, mid + 1, right);
        int index = left;
        int l = mid + 1;
        int r = mid + 1;

        for(; index <= mid; index++) {
            for(; l <= right && s[l] - s[index] < lower; l++);
            for(; r <= right && s[r] - s[index] <= upper; r++);
            res += r - l;
        }

        long[] merged = new long[right - left + 1];
        int im = 0;
        int i1 = left, i2 = mid + 1;
        while(i1 <= mid && i2 <= right) {
            if (s[i1] < s[i2]) {
                merged[im++] = s[i1++];
            } else {
                merged[im++] = s[i2++];
            }
        }

        while (i1 <= mid) {
            merged[im++] = s[i1++];
        }
        while (i2 <= right) {
            merged[im++] = s[i2++];
        }
        
        im = 0;

        for (int i = left; i <= right; i++, im++) {
            s[i] = merged[im];
        }

        return res;
    }
}
// @lc code=end

