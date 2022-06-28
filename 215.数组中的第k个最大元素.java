import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k - 1);
        
    }

    private int select(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if (k == index) return nums[k];
        else if (k > index) return select(nums, index + 1, right, k);
        else return select(nums, left, index - 1, k);
    }

    private int partition(int[] nums, int left, int right){
        int t = rand.nextInt(right - left + 1) + left;
        swap(nums, t, right);

        int key = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] > key) {
                swap(nums, i++, j);
            }
        }
        swap(nums, right, i);
        return i;
    }

   

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
// @lc code=end

