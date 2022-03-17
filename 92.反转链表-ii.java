class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        head = new ListNode(0, head);
        ListNode pre = head;
        for(int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode l = pre.next;
        ListNode r = head;
        for(int i = 0; i < right; i++) {
            r = r.next;
        }
        ListNode last = r.next;
        for(ListNode px = l, x = px.next; px != r;) {
            ListNode n = x.next;
            x.next = px;
            px = x;
            x = n;
        }
        pre.next = r;
        l.next = last;
        return head.next;
    }
}
// @lc code=end

