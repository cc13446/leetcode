/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int left, int right) {
        if (left > right) return null;

        int max = -1;
        int maxIndex = -1;

        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode res = new TreeNode();
        res.val = nums[maxIndex];
        res.left = help(nums, left, maxIndex - 1);
        res.right = help(nums, maxIndex + 1, right);

        return res;
    }
}
// @lc code=end

