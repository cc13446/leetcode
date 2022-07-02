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
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        int left = 0, right = 0;
        TreeNode lNode = root;
        while(lNode != null) {
            lNode = lNode.left;
            left++;
        }

        TreeNode rNode = root;
        while(rNode != null) {
            rNode = rNode.right;
            right++;
        }

        if (left == right) return (int)Math.pow(2, left) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
// @lc code=end

