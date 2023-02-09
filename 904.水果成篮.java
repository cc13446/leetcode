/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int first = -1, firstN = 0;
        int second = -1, secondN = 0;

        int left = 0;
        int right = left;

        int res = 0;

        while(left < fruits.length && right < fruits.length) {
            for (; right < fruits.length; right++) {
                if (first == fruits[right]) {
                    firstN++;
                } else if (second == fruits[right]) {
                    secondN++;
                } else {
                    if (firstN == 0) {
                        firstN++;
                        first = fruits[right];
                    } else if (secondN == 0) {
                        secondN++;
                        second = fruits[right];
                    } else {
                        break;
                    }
                }
            }
            res = Math.max(res, right - left);

            if (first == fruits[left] && --firstN == 0) {
                first = -1;
            } else if (second == fruits[left] && --secondN == 0) {
                second = -1;
            }
            
            left++;
        }
        return res;
    }
}
// @lc code=end

