/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val >= p.val && root.val <= q.val || root.val <= p.val && root.val >= q.val) {
                return root;
            } else if (root.val > p.val){
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            }
        }
        return root;
    }
}
// @lc code=end

