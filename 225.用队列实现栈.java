import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        List<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()){
            temp.add(q.poll());
        }
        q.add(x);
        q.addAll(temp);
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

