import java.util.List;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            ListNode l = pre.next;
            if (pre.val == l.val){
                pre.next = l.next;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }
}
// @lc code=end

