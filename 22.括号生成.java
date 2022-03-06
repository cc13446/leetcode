import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {


    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        func(res, "(", 1, 0, n);
        return new LinkedList<>(res);
    }

    public void func (Set<String> res, String s, int leftCount, int rightCount, int n) {
        if (leftCount == rightCount) {
            if (leftCount == n) {
                res.add(s);
                return;
            } else {
                func(res, s + "(", leftCount + 1, rightCount, n);
            }
        } else if (leftCount > rightCount) {
            if (leftCount == n) {
                for (; rightCount < n; rightCount++) {
                    s += ")";
                }
                res.add(s);
                return;
            } else {
                func(res, s + "(", leftCount + 1, rightCount, n);
                func(res, s + ")", leftCount, rightCount + 1, n);
            }
        }
    }
}
// @lc code=end

