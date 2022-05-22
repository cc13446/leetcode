import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if(!dp[s.length()]) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        dfs(0, s, set, path, res);
        return res;
    }

    private void dfs(int index, String s, Set<String> set, List<String> path, List<String> res) {
        if(index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }

        for (int i = index; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (set.contains(sub)) {
                path.add(sub);
                dfs(i, s, set, path, res);
                path.remove(path.size() - 1);
            }
        }
    
    }
}
// @lc code=end

