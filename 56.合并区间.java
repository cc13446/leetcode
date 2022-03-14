import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        for(int i = 0; i < intervals.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j < intervals.length; j++) {
                if(intervals[j][0] < min) {
                    minIndex = j;
                    min = intervals[j][0];
                }
            }
            int temp1 = intervals[i][0];
            int temp2 = intervals[i][1];
            intervals[i][0] = intervals[minIndex][0];
            intervals[i][1] = intervals[minIndex][1];
            intervals[minIndex][0] = temp1;
            intervals[minIndex][1] = temp2;
        }

        int length = 0;
        for(int i = 0; i < intervals.length; i++) {
            boolean flag = false;
            for(int j = 0; j < length; j++) {
                if(res[j][0] <= intervals[i][0] && res[j][1] >= intervals[i][0]
                || res[j][0] <= intervals[i][1] && res[j][1] >= intervals[i][1]
                || intervals[i][0] <= res[j][0] && intervals[i][1] >= res[j][0]
                || intervals[i][0] <= res[j][1] && intervals[i][1] >= res[j][1]) {
                    flag = true;
                    res[j][0] = Math.min(res[j][0], intervals[i][0]);
                    res[j][1] = Math.max(res[j][1], intervals[i][1]);
                }
            }
            if (!flag) {
                res[length][0] = intervals[i][0];
                res[length][1] = intervals[i][1];
                length ++;
            }
        }

        int[][] temp = new int[length][2];
        for(int i = 0; i < length; i++) {
            temp[i][0] = res[i][0];
            temp[i][1] = res[i][1];
        }

        return temp;
    }
}
// @lc code=end

