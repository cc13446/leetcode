import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// 老实做法
// class NestedIterator implements Iterator<Integer> {

//     private List<NestedInteger> list = null;
//     private int index = 0;
//     private NestedIterator n = null;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         this.list = nestedList;
//     }

//     @Override
//     public Integer next() {
//         NestedInteger ni = list.get(index);
//         if (ni.isInteger()) {
//             index++;
//             return ni.getInteger();
//         } else {
//             int res = n.next();
//             if (!n.hasNext()) {
//                 index++;
//                 n = null;
//             }
//             return res;
//         }
//     }

//     @Override
//     public boolean hasNext() {

//         while (index < list.size()) {
//             NestedInteger ni = list.get(index);
//             if (ni.isInteger()) {
//                 return true;
//             } else {
//                 if (n == null) {
//                     n = new NestedIterator(ni.getList());
//                 }
//                 if (n.hasNext()) {
//                     return true;
//                 } else {
//                     n = null;
//                 }
//             }
//             index++;
//         }
//         return false;
//     }
// }
class NestedIterator implements Iterator<Integer> {

    private int index = 0;
    private List<Integer> list = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(list, nestedList);        
    }

    private void dfs(List<Integer> list, List<NestedInteger> nList) {
        for (NestedInteger ni : nList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                dfs(list, ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

