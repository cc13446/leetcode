import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode l = head; l != null; l = l.next) {
            if (!set.add(l)) {
                return l;
            } 
        }
        return null;
    }
}
// @lc code=end

