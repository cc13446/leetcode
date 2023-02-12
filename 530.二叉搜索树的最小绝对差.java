import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public int getMinimumDifference(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> q = new LinkedList<>();

        int pre = -100000;
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty() || cur != null) {
            if (cur != null) {
                q.push(cur);
                cur = cur.left;
            } else {
                TreeNode n = q.pop();
                int v = n.val;
                min = Math.min(min, v - pre);
                pre = v;
                cur = n.right;
            }
        }
        return min;
    }
}
// @lc code=end

