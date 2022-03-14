class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 1;
        ListNode l = head;
        for(; l.next != null; l = l.next, len++);
        k = k % len;
        if (k == 0) return head;
        ListNode pre = head;
        ListNode current = head.next;
        for(int i = 1; i < len - k; i++) {
            pre = pre.next;
            current = current.next;
        }
        pre.next = null;
        l.next = head;
        return current;
    }
}
// @lc code=end

