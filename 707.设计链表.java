/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    private static class Node {
        int val;
        Node next;
        Node pre;
    }

    private Node head;
    private Node tail;
    private int nums;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
    }

    public int get(int index) {
        if (index < 0 || index >= nums) return -1;
        if (index <= nums / 2) { 
            Node n = this.head.next;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return n.val;
        } else {
            index = nums - index - 1;
            Node n = this.tail.pre;
            for (int i = 0; i < index; i++) {
                n = n.pre;
            }
            return n.val;
        }
    }
    
    public void addAtHead(int val) {

        if (nums == 0) {
            Node h = new Node();
            h.val = val;
            head.next = h;
            tail.pre = h;
        } else {
            Node h = new Node();
            h.val = val;
            h.next = head.next;
            head.next.pre = h;
            head.next = h;
        }

        nums++;
    }
    
    public void addAtTail(int val) {
        
        if (nums == 0) {
            Node h = new Node();
            h.val = val;
            head.next = h;
            tail.pre = h;
        } else {
            Node h = new Node();
            h.val = val;
            h.pre = tail.pre;
            tail.pre.next = h;
            tail.pre = h;
        }

        nums++;
    }
    
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > nums) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == nums) {
            addAtTail(val);
        } else {
            Node pre = head;
            Node n = head.next;
            for (int i = 0; i < index; i++) {
                n = n.next;
                pre = pre.next;
            }
            Node newNode = new Node();
            newNode.val = val;
            pre.next = newNode;
            newNode.pre = pre;
            n.pre = newNode;
            newNode.next = n;
            nums++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= nums) return;
        if (nums == 1) {
            head = new Node();
            tail = new Node();
        } else if (index == 0) {
            head.next = head.next.next;
            head.next.pre = null;
            
        } else if (index == nums - 1) {
            tail.pre = tail.pre.pre;
            tail.pre.next = null;
        } else {
            Node pre = head;
            Node n = head.next;
            for (int i = 0; i < index; i++) {
                n = n.next;
                pre = pre.next;
            }
            n = n.next;
            pre.next = n;
            n.pre = pre;
        }

        nums--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

