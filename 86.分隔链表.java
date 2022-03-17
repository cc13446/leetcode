class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0, null);
        ListNode r = res;
        ListNode last = new ListNode(0, null);
        ListNode l = last;
        for(ListNode current = head; current != null; current = current.next) {
            if(current.val < x) {
                r.next = current;
                r = r.next;
            } else {
                l.next = current;
                l = l.next;
            }
        }
        l.next = null;
        r.next = last.next;
        return res.next;

    }
}
// @lc code=end

