class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode unUsed = new ListNode(0, head);
        ListNode pre = unUsed;
        while(pre != null) {
            ListNode last = pre;
            ListNode temp = pre.next;
            for (int i = 0; i < k; i ++) {
                last = last.next;
                if (last == null) return unUsed.next;
            }
            ListNode prec = pre.next;
            ListNode current = prec.next;
            ListNode next = current.next;
            while (prec != last) {
                current.next = prec;
                prec = current;
                current = next;
                if (current == null) break;
                next = next.next;
            }
            temp.next = current;
            pre.next = last;
            pre = temp;
        }
        return unUsed.next;
    }
}
// @lc code=end

