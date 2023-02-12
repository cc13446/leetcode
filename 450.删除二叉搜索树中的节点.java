/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.left == null && root.right == null) {
            return null;
        } else if (root.right != null) {
            int t = getMin(root.right);
            root.val = t;
            root.right = deleteNode(root.right, t);
        } else {
            int t = getMax(root.left);
            root.val = t;
            root.left = deleteNode(root.left, t);
        }

        return root;
    }

    public int getMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int getMax(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
// @lc code=end

