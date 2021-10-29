import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int temp = res.get(0);
            for (int j = 1; j < i; j++) {
                int t = res.get(j);
                res.set(j, temp + res.get(j));
                temp = t;
            }
            res.add(1);
        }
        return res;
    }
}
// @lc code=end

