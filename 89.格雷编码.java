import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        res.add(0);
        for(int i = 1, h = 1; i <= n; i++, h *= 2) {
            for(int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + h);
            }
        } 
        return res;
    }
}
// @lc code=end

