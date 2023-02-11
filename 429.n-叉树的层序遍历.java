import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// @lc code=start
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return res;

        Deque<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            Deque<Node> t = new LinkedList<>();
            while (!q.isEmpty()) { 
                Node n = q.poll();
                l.add(n.val);
                for (Node child : n.children) {
                    t.add(child);
                }
            }
            q = t; 
            res.add(l);
        }
        return res;
    }
}
// @lc code=end

