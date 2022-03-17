import java.util.Stack;

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
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {
        TreeNode swap = new TreeNode(0);
        TreeNode pp = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = new TreeNode(Integer.MIN_VALUE);
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while(!s.isEmpty() || t != null) {
            if(t != null) {
                s.push(t);
                t = t.left;
            } else {
                t = s.pop();
                if(pp.val < p.val && t.val < p.val && swap.left == null) swap.left = p;
                if(t.val < p.val) swap.right = t;
                pp = p;
                p = t;
                t = t.right;
            }
        }
        int temp = swap.right.val;
        swap.right.val = swap.left.val;
        swap.left.val = temp;
    }
}
// @lc code=end

