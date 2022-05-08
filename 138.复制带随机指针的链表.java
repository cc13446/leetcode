import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node t = head;
        while (t != null) {
            map.put(t, new Node(t.val));
            t = t.next;
        }
        t = head;
        while (t != null) {
            Node n = map.get(t);
            n.next = map.get(t.next);
            n.random = map.get(t.random);
            t = t.next;
        }
        return map.get(head);
    }
}
// @lc code=end

