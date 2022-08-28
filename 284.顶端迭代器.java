import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> temp;
	Integer peek;
	boolean hasNext;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    temp = iterator;
		if (temp.hasNext()) {
			peek = temp.next();
			hasNext = true;
		} else {
			hasNext = false;
		}
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer i = peek;
		if (temp.hasNext()) {
			peek = temp.next();
			hasNext = true;
		} else {
			hasNext = false;
		}
		return i;
	}
	
	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}
// @lc code=end

