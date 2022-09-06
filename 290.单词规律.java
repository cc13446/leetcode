import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        char[] p = pattern.toCharArray();
        String[] strs = s.split("\s+");
        System.out.println(Arrays.toString(strs));
        System.out.println(Arrays.toString(p));
        if (p.length != strs.length) return false;
        for (int i = 0; i < p.length; i++) {
            if(map1.containsKey(p[i]) || map2.containsKey(strs[i])) {
                if (!strs[i].equals(map1.getOrDefault(p[i], ""))) return false;
                if (p[i] != map2.getOrDefault(strs[i], (char)0)) return false;
            } else {
                map1.put(p[i], strs[i]);
                map2.put(strs[i], p[i]);
            }
        }
        return true;

    }
}
// @lc code=end

