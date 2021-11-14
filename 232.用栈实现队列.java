import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Stack<Integer> stackFirst;
    private Stack<Integer> stackLast;

    public MyQueue() {
        stackFirst = new Stack<>();
        stackLast = new Stack<>();
    }
    
    public void push(int x) {
        stackLast.push(x);
    }
    
    public int pop() {
        if (!stackFirst.isEmpty()) return stackFirst.pop();
        else {
            while (!stackLast.isEmpty()) {
                stackFirst.push(stackLast.pop());
            }
            return stackFirst.pop();
        }
    }
    
    public int peek() {
        if (!stackFirst.isEmpty()) return stackFirst.peek();
        else {
            while (!stackLast.isEmpty()) {
                stackFirst.push(stackLast.pop());
            }
            return stackFirst.peek();
        }
    }
    
    public boolean empty() {
        return stackFirst.isEmpty() && stackLast.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

