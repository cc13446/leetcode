import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> s = new Stack<>();
        for (String str : strings) {
            if(str.equals("")) {
                continue;
            } else if(str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!s.empty()) {
                    s.pop();
                }
                continue;
            } else {
                s.push(str);
            }
        }
        List<String> res = new LinkedList<>(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); i++) {
            sb.append("/").append(res.get(i));
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
// @lc code=end

