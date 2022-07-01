import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder str = new StringBuilder();
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str.append(stack.pollLast());
        }
        return str.toString();
    }
}
// @lc code=end

