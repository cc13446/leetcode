import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>(s.length);
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    if (stack.size() < 2) return false;
                    stack.pop();
                    stack.pop();   
                }
            } 
            stack.push(s[i]);
        }
        return stack.size() == 1 && stack.peek().equals("#");

    }
}
// @lc code=end

