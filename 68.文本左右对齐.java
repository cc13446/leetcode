import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        int w = maxWidth;
        for(int i = 0; i < words.length; i++) {
            String s = words[i];

            if(s.length() <= w) {
                temp.add(s);
                w -= s.length();
                w --;
            } else {
                StringBuilder sb = new StringBuilder();
                w++;
                int size = temp.size();
                int space = w;
                int longer = 0;
                if(temp.size() > 1) {
                    size--;
                    space = w / size + 1;
                    longer = w % size;
                }
                
                for(String str : temp) {
                    sb.append(str);
                    if(size != 0) {
                        for(int j = 0; j < space; j++) sb.append(" ");
                        size--;
                    }
                    if(longer != 0) {
                        sb.append(" ");
                        longer--;
                    }
                }
                res.add(sb.toString());
                temp.clear();
                temp.add(s);
                w = maxWidth - s.length();
                w--;
            } 
        }

        StringBuilder sb = new StringBuilder();
        for(String str : temp) {
            sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        int space = maxWidth - sb.length();
        for(int i = 0; i < space; i++) sb.append(" ");
        res.add(sb.toString());
        return res;
    }
}
// @lc code=end

