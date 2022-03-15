import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int n = map.keySet().size();
        int d = -s.length();
        String res = "";
        for(int i = 0, j = 0; i < s.length() && j < s.length(); j++) {
            Character c = s.charAt(j);
            int temp = map.getOrDefault(c, d);
            if(temp == d) {
                continue;
            } else {
                temp--;
                map.put(c, temp);
                if(temp == 0) n--;
                if(n == 0) {
                    while(n == 0 && i < s.length()) {
                        Character l = s.charAt(i);
                        int lTemp = map.getOrDefault(l, d);
                        if(lTemp != d) {
                            lTemp++;
                            map.put(l, lTemp);
                            if(lTemp == 1) n++;
                        }
                        i++;
                    }
                    if(res.equals("") || res.length() > j - i + 2) {
                        res = s.substring(i - 1, j + 1);
                    }
                }
            }

        }
        return res;
        
    }
}
// @lc code=end

