/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        for (; i < version1.length() && j < version2.length(); i++, j++) {
            int res1 = 0;
            while(i < version1.length() && version1.charAt(i) != '.') {
                res1 *= 10;
                res1 += (version1.charAt(i) - '0');
                i++;
            }

            int res2 = 0;
            while(j < version2.length() && version2.charAt(j) != '.') {
                res2 *= 10;
                res2 += (version2.charAt(j) - '0');
                j++;
            }
            if (res1 > res2) return 1;
            if (res2 > res1) return -1;
        }

        while(i < version1.length() && (version1.charAt(i) == '0' || version1.charAt(i) == '.')) i++;
        while(j < version2.length() && (version2.charAt(j) == '0' || version2.charAt(j) == '.')) j++;
        if (i < version1.length()) return 1;
        if (j < version2.length()) return -1;
        return 0;
    }
}
// @lc code=end

