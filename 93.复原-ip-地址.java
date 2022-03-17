import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, s, 0, path, res);
        return res;
    }

    private void dfs(int index, String s, int deep, StringBuilder path, List<String> res) {
        if(index >= s.length()) return;
        if(deep == 3) {
            if(s.length() - index > 3) return;
            else {
                int sum = 0;
                for(int i = index; i < s.length(); i++) {
                    sum *= 10;
                    sum += s.charAt(i) - '0';
                }
                if(s.length() - index > 1 && s.charAt(index) == '0') return;
                if (sum >= 0 && sum <= 255) {
                    path.append(s.substring(index));
                    res.add(path.toString());
                    int temp = path.length();
                    path.delete(temp - (s.length() - index), temp);
                    return;
                }
            }
        } else {
            if(s.charAt(index) == '0') {
                path.append(s.charAt(index)).append('.');
                dfs(index + 1, s, deep + 1, path, res);
                int temp = path.length();
                path.delete(temp - 2, temp);
            } else {
                for (int i = 1; i <= 3; i++) {
                    if(index + i >= s.length()) {
                        return;
                    }
                    int sum = 0;
                    for(int j = index; j < index + i; j++) {
                        sum *= 10;
                        sum += (s.charAt(j) - '0');
                    }
                    if (sum >= 0 && sum <= 255) {
                        path.append(s.substring(index, index + i)).append('.');
                        dfs(index + i, s, deep + 1, path, res);
                        int temp = path.length();
                        path.delete(temp - i - 1, temp);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
// @lc code=end

