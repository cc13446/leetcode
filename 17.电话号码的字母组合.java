import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if (null == digits || 0 == digits.length()) {
            return result;
        }
        for (int i = 0; i < digits.length(); i++) {
            char x = digits.charAt(i);
            List<String> toAdd = this.getStr(x);
            if (0 == result.size()) {
                result = toAdd;
            }else if (toAdd.size() > 0) {
                List<String> temp = new LinkedList<String>();
                for (String s : toAdd) {
                    for (String r : result){
                        temp.add(r+s);
                    }
                }
                result = temp;
            }
        }
        return result;
    }

    private List<String> getStr(char source) {
        switch(source){
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            case '9': return Arrays.asList("w", "x", "y", "z");
            default: return new LinkedList<String>();
        }
    }
}
// @lc code=end

