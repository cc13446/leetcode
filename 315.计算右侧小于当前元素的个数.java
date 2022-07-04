import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] small = new int[nums.length];
        int[] index = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }
        mergeSort(nums, small, index, 0, nums.length - 1);

        return Arrays.stream(small).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int[] nums, int[] small, int[] index, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, small, index, left, mid);
            mergeSort(nums, small, index, mid + 1, right);
            merge(nums, small, index, left, mid, right);
        }
    }

    private void merge(int[] nums, int[] small, int[] index, int left, int mid, int right) {
        int P1 = left;
		int P2 = mid + 1;
		int tmp[] = new int[right - left + 1]; 
        int tmpI[] = new int[right - left + 1]; 
		int cur = 0;
		while (P1 <= mid && P2 <= right) {
			if (nums[P1] <= nums[P2]) {
				tmp[cur] = nums[P1];
                tmpI[cur] = index[P1];
                small[index[P1]] += (P2 - mid - 1);
				P1++;
			} else {
				tmp[cur] = nums[P2];
                tmpI[cur] = index[P2];
				P2++;
			}
			cur++;
		}
		while (P1 <= mid) {
			tmp[cur] = nums[P1];
            tmpI[cur] = index[P1];
            small[index[P1]] += (P2 - mid - 1);
			P1++;
			cur++;
		}
		while (P2 <= right) {
			tmp[cur] = nums[P2];
            tmpI[cur] = index[P2];
			P2++;
			cur++;
		}
		for (int i = 0; i < tmp.length; i++) {
			nums[i + left] = tmp[i];
            index[i + left] = tmpI[i];
		}
    }
}
// @lc code=end

