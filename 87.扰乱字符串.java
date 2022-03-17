import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {

    Map<String, Boolean> map= new HashMap<String,Boolean>();
    
    public boolean isScramble(String s1, String s2) {
        if(map.containsKey(s1 + s2)) return map.get(s1 + s2);

        int n = s1.length();
        int m = s2.length();
        if(n != m) {
            map.put(s1 + s2, false);
            return false;
        }
        
        int[] count = new int[26];
        for(Character c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for(Character c : s2.toCharArray()) {
            count[c - 'a']--;
            if(count[c - 'a'] < 0) {
                map.put(s1 + s2, false);
                return false;
            }
        }
        
        if(s1.equals(s2)) return true;
        
        if(s1.equals(new StringBuffer(s2).reverse().toString())) return true;
        for(int i = 1; i < n; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(s1 + s2, true);
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(s1 + s2, true);
                return true;
            }
        }
        map.put(s1 + s2, false);
        return false;
    }
}
// @lc code=end

