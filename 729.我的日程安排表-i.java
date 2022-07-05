import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {

    private TreeSet<int[]> s;

    public MyCalendar() {
        s = new TreeSet<>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        if (s.isEmpty()) {
            s.add(new int[]{start, end});
            return true;
        }
        int[] temp = new int[]{start, end};

        if (s.contains(temp)) {
            return false;
        }
        int[] pre = s.lower(temp);
        int[] next = s.higher(temp);
        if ((next == null || next[0] >= temp[1]) &&(pre == null || temp[0]>=pre[1]) ) {
            s.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

