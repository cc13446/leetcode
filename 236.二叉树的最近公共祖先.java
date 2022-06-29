import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> res = new ArrayList<>(2);
        List<TreeNode> path = new ArrayList<>();
        dfs(root, p, q, path, res);

        List<TreeNode> p1 = res.get(0);
        List<TreeNode> p2 = res.get(1);

        TreeNode t = root;
        int len = Math.min(p1.size(), p2.size());
        for (int i = 0; i < len; i++) {
            TreeNode t1 = p1.get(i);
            TreeNode t2 = p2.get(i);
            if (t1 == t2) {
                t = t1;
            } else {
                break;
            }
        }
        return t;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path, List<List<TreeNode>> res) {
        path.add(root);
        if (res.size() == 2) {
            path.remove(path.size() - 1);
            return;
        }
        if (root == p || root == q) {
            res.add(new ArrayList<>(path));
            if (res.size() == 2){
                path.remove(path.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            dfs(root.left, p, q, path, res);
        }
        if (root.right != null) {
            dfs(root.right, p, q, path, res);
        }
        path.remove(path.size() - 1);
    }
}
// @lc code=end

