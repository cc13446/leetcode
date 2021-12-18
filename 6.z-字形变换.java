import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> sbs = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            sbs.add(new StringBuilder());
        }
        int[] target = new int[numRows * 2 - 2];
        for (int i = 0; i < target.length; i++) {
            if (i < numRows) {
                target[i] = i;
            } else {
                target[i] = target.length - i;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            sbs.get(target[i % target.length]).append(s.charAt(i));
        }
        String res = "";
        for (StringBuilder sb : sbs) {
            res += sb.toString();
        }
        return res;
    }
}
// @lc code=end

