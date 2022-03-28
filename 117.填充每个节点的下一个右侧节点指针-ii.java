class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}
// @lc code=end

