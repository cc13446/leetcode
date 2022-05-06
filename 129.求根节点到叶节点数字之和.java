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
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int temp) {
        if (root.left == null && root.right == null) {
            sum += temp;
            sum += root.val;
            return;
        }
        temp += root.val;
        temp *= 10;
        if (root.left != null) 
            dfs(root.left, temp);   
        if (root.right != null)
            dfs(root.right, temp);

        temp /= 10;
        temp -= root.val;
        return;
    }
}
// @lc code=end

