import java.util.Stack;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = new char[26];
        
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        char[] instack = new char[26];
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            chars[c - 'a']--;

            if (instack[c - 'a'] == 1) continue;

            while(!stack.isEmpty() && c < stack.peek() && chars[stack.peek() - 'a'] != 0) {
                instack[stack.pop() - 'a'] = 0;
            }

            if(instack[c - 'a'] != 1) {
                stack.push(c);
                instack[c - 'a'] = 1;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

