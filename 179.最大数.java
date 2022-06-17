import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> {
            String a1 = a.toString() + b.toString();
            String b1 = b.toString() + a.toString();
            for (int i = 0; i < a1.length(); i++) {
                if (a1.charAt(i) > b1.charAt(i)) {
                    return -1;
                } else if (a1.charAt(i) < b1.charAt(i)) {
                    return 1;
                } 
            }
            return 0;
        });
        String res = String.join("", s);
        int i = 0;
        for(; i < res.length() && res.charAt(i) == '0'; i++);
        return res.substring(Math.min(i, res.length() - 1));
    }
}
// @lc code=end

