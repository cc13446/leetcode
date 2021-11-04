/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode res = head;
        while (res != null && res.val == val)
            res = res.next;
        if (res == null)
            return res;
        ListNode pre = res;
        ListNode h = pre.next;
        while (h != null) {
            ListNode next = h;
            while (next != null && next.val == val) {
                next = next.next;
            }
            pre.next = next;
            if (next == null)
                break;
            pre = pre.next;
            h = pre.next;
        }
        return res;
    }
}
// @lc code=end
