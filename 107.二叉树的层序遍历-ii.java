import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            List<TreeNode> nextQ = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null) nextQ.add(t.left);
                if(t.right != null) nextQ.add(t.right);
            }
            q.addAll(nextQ);
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

