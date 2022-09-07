/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    int[] nums;
    int[] array;
    public NumArray(int[] nums) {
        this.nums = nums.clone();
        this.array = new int[this.nums.length];
        this.array[0] = this.nums[0];
        for (int i = 1; i < this.array.length; i++) {
            this.array[i] = this.array[i - 1] + this.nums[i];
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for(int i = index; i < nums.length; i++) {
            array[i] += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        return array[right] - array[left] + nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

