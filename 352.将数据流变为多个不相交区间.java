import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=352 lang=java
 *
 * [352] 将数据流变为多个不相交区间
 */

// @lc code=start
class SummaryRanges {

    private List<int[]> list = new ArrayList<>();

    public SummaryRanges() {

    }
    
    public void addNum(int value) {
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int[] i = list.get(mid);
            if (value < i[0] - 1) {
                right = mid - 1;
            } else if (value > i[1] + 1) {
                left = mid + 1;
            } else {
                if (value >= i[0] && value <= i[1]) {
                    return;
                } else if (value == i[0] - 1) {
                    i[0] = value;
                    if (mid > 0 && list.get(mid - 1)[1] == value - 1) {
                        i[0] = list.get(mid - 1)[0];
                        list.remove(mid - 1);
                    }
                    return;
                } else if (value == i[1] + 1) {
                    i[1] = value;
                    if (mid < list.size() - 1  && list.get(mid + 1)[0] == value + 1) {
                        i[1] = list.get(mid + 1)[1];
                        list.remove(mid + 1);
                    }
                    return;
                }
            }
        }
        list.add(right + 1, new int[]{value, value});

    }
    
    public int[][] getIntervals() {
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] i : list) {
            res[index++] = i;
        }

        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

