import java.util.ArrayList;
import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */
import java.util.List;

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            int i = a[0] - b[0];
            if (i != 0) return i;
            return b[1] - a[1];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int target = envelopes[i][1];
            if (list.isEmpty() || target > list.get(list.size() - 1)) {
                list.add(target);
            } else {
                int left = 0; int right = list.size() - 1;
                while(left < right) {
                    int mid = (left + right) / 2;
                    int value = list.get(mid);
                    if (value < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(left, target);
            }
        }

        return list.size();
    }
}
// @lc code=end

