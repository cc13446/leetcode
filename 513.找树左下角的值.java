import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
 */
class Solution {

    // 层序遍历
    // public int findBottomLeftValue(TreeNode root) {
        
    //     int res = root.val;
    //     Deque<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while (!q.isEmpty()) {
    //         Deque<TreeNode> t = new LinkedList<>();
    //         boolean first = true;
    //         while(!q.isEmpty()) {
    //             TreeNode n = q.poll();
    //             if (n.left != null) t.offer(n.left);
    //             if (n.right != null) t.offer(n.right);
    //             if (first) {
    //                 first = false;
    //                 res = n.val;
    //             }
    //         }
    //         q = t;
    //     }

    //     return res;
    // }

    int res;
    int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        help(root, 0);
        return res;
    }

    public void help(TreeNode n, int d) {
        if (n.left == null && n.right == null) {
            if (maxDepth <= d) {
                maxDepth = d;
                res = n.val;
            }
        } else {
            if (n.right != null) {
                help(n.right, d + 1);
            }
            if (n.left != null) {
                help(n.left, d + 1);
            }
        }
    }
}
// @lc code=end

