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
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int il = 0; 
        int ir = inorder.length - 1;
        int pl = 0;
        int pr = postorder.length - 1;
        return helper(inorder, il, ir, postorder, pl, pr);
    }

    private TreeNode helper(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if(il > ir) return null;
        TreeNode res = new TreeNode(postorder[pr]);
        int i = il;
        for(; i <= ir && inorder[i] != postorder[pr]; i++);
        res.left = helper(inorder, il, i - 1, postorder, pl, pl + i - il - 1);
        res.right = helper(inorder, i + 1, ir, postorder, pl + i - il,  pr - 1);
        return res;
    }
}
// @lc code=end

