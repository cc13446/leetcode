/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        for (char c : magazine.toCharArray()) {
            nums[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            nums[c - 'a']--;
            if ( nums[c - 'a'] < 0) return false;
        }

        return true;
    }
}
// @lc code=end

