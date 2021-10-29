/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null && targetSum == root.val) return true;
        else if (root.left == null && root.right != null) return hasPathSum(root.right, targetSum - root.val);
        else if (root.left != null && root.right == null) return hasPathSum(root.left, targetSum - root.val);
        else if (root.left != null && root.right != null) 
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        else return false;
    }
}
// @lc code=end

