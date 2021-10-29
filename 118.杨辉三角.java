import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;
        List<Integer> pre = new LinkedList<>();
        pre.add(1);
        res.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                temp.add(pre.get(j) + pre.get(j + 1));
            }
            temp.add(1);
            pre = temp;
            res.add(pre);
        }
        return res;
    }
}
// @lc code=end

