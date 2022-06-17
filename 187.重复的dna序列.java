import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> map = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String t = s.substring(i, i + 10);
            if (map.contains(t)) res.add(t);
            else map.add(t);
        }

        return new LinkedList<>(res);
    }
}
// @lc code=end

