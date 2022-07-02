import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
class Codec {

    String split = ",";
    String nStr = "n";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return split;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        sb.append(root.val).append(split);;

        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left == null) sb.append(nStr).append(split);
            else {
                sb.append(t.left.val).append(split);
                q.offer(t.left);
            }
            if (t.right == null) sb.append(nStr).append(split);
            else {
                sb.append(t.right.val).append(split);
                q.offer(t.right);
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(split);
        if (s.length == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        q.offer(root);
        int i = 1;
        int n = s.length;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (i >= n || s[i].equals(nStr)) {
                t.left = null;
            } else {
                t.left = new TreeNode(Integer.valueOf(s[i]));
                q.offer(t.left);
            }
            i++;

            if (i >= n || s[i].equals(nStr)) {
                t.right = null;
            } else {
                t.right = new TreeNode(Integer.valueOf(s[i]));
                q.offer(t.right);
            }
            i++;
        }


        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

