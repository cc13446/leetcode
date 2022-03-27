import java.util.LinkedList;
import java.util.List;

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
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        if(root == null) return res;
        dfs(root, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        System.out.println(path);
        path.add(root.val);
        if(root.left != null) dfs(root.left, targetSum - root.val, path, res);
        if(root.right != null) dfs(root.right, targetSum - root.val, path, res);
        if(targetSum == root.val && root.left == null && root.right == null) {
            res.add(new LinkedList<Integer>(path));
        }
        path.remove(path.size() - 1);
    }
}
// @lc code=end

