import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    //小顶堆存放大数
    PriorityQueue<Integer> min;
    //大顶堆存放小数
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> b - a);
        max = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (max.size() + 1 < min.size()) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }
    }
    
    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        } 
        return (max.peek() + min.peek())  / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

