import java.util.Arrays;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        // 找到最小的节点
        ListNode result = null;
        int min = Integer.MAX_VALUE;
        int minI = -1;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null && lists[i].val < min) {
                minI = i;
                min = lists[i].val;
            }
        }
        if(-1 == minI) return null;
        result = lists[minI];
        lists[minI] = result.next;
        ListNode temp = result;

        while (true) {
            min = Integer.MAX_VALUE;
            minI = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < min) {
                    minI = i;
                    min = lists[i].val;
                }
            }
            if(-1 == minI)  return result;
            temp.next = lists[minI];
            temp = temp.next;
            lists[minI] = lists[minI].next;
        }
    }
}
// @lc code=end

