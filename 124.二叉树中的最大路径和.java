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
}/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int res = -1000;
    public int maxPathSum(TreeNode root) {
        int left = -1000;
        if (root.left != null) left = Math.max(maxPathChild(root.left), left);
        int right = -1000;
        if (root.right != null) right = Math.max(maxPathChild(root.right), right);
        res = Math.max(res, root.val);
        res = Math.max(res, left + root.val);
        res = Math.max(res, right + root.val);
        res = Math.max(res, left + right + root.val);
        return res;
    }
    private int maxPathChild(TreeNode root) {
        int left = -1000;
        if (root.left != null) left = Math.max(maxPathChild(root.left), left);
        int right = -1000;
        if (root.right != null) right = Math.max(maxPathChild(root.right), right);
        res = Math.max(res, root.val);
        res = Math.max(res, left + root.val);
        res = Math.max(res, right + root.val);
        res = Math.max(res, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, Math.max(root.val, 0));
    }
}
// @lc code=end

