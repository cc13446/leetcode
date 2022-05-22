import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head;
        ListNode l = head.next;
        while(l != null) {
            ListNode next = l.next;
            if (p.val <= l.val) {
                p = l;
            } else {
                // 当前节点拿出来
                p.next = l.next;

                // l 从头插进去
                if (head.val >= l.val) {
                    l.next = head;
                    head = l;
                } else {
                    ListNode iP = head;
                    ListNode iL = iP.next;
                    while (iL.val < l.val) {
                        iP = iP.next;
                        iL = iP.next;
                    }
                    iP.next = l;
                    l.next = iL;
                }
            }
            l = next;
        }
        return head;
    }
}
// @lc code=end

