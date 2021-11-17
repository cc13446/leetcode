import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    Deque<String> path = new LinkedList<>();
    List<String> result = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) helper(root);
        return result;
    }
    private void helper(TreeNode root){
        path.addLast(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(printPath());
        }
        if (root.left != null) helper(root.left);
        if (root.right != null) helper(root.right);
        path.removeLast();
    }
    private String printPath(){
        return String.join("->", path.toArray(new String[0]));
    }
}
// @lc code=end

