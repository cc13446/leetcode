
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode current = pre.next;
        ListNode next = current.next;
        pre.next = next;
        current.next = pre;
        head = current;
        while (pre != null && pre.next != null && pre.next.next != null) {
            current = pre.next;
            next = current.next;
            pre.next = next;
            current.next = next.next;
            next.next = current;
            pre = current;
        }
        
        return head;
    }
}
// @lc code=end

