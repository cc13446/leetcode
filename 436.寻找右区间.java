import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {

    private long indexMask = 1000_000;
    public int[] findRightInterval(int[][] intervals) {
        List<Long> list = new ArrayList<>(intervals.length);

        for (int i = 0 ; i < intervals.length; i++) {
            long temp = intervals[i][0];
            if (temp >= 0) {
                temp = temp * indexMask + i;
            } else {
                temp = temp * indexMask - i;
            }
            list.add(temp);
        }
        list.sort(Long::compare);
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = biSearch(list, intervals[i][1]);
        }

        return res;
    }

    private int biSearch(List<Long> list, long target) {
        int left = 0; int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long value = list.get(mid) / indexMask;
            if (target < value) {
                right = mid - 1;
            } else if (target > value) {
                left = mid + 1;
            } else {
                long res = list.get(mid);
                return (int)(Math.abs(res) % indexMask);
            }
        }
        if (left >= list.size()) {
            return -1;
        } 
        return (int)(Math.abs(list.get(left)) % indexMask);
    
    }
}
// @lc code=end

