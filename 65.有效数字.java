/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        // 0 整数部分 1 小数部分 2 e部分
        int state = 0;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if((c < '0' || c > '9') && c != 'e' && c!= 'E' && c != '.') {
                return false;
            }
            if(state == 0) {
                if(c >= '0' && c <= '9') {
                    flag = true;
                    continue;
                }
                else if(c == 'e' || c == 'E') {
                    if(i == 0) return false;
                    if(i == s.length() - 1) return false;
                    if(s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'){
                        i++;
                        if(i == s.length() - 1) return false;
                    }
                    state = 2;
                    continue;
                } else if(c == '.') {
                    if(i == s.length() - 1 && i == 0) return false;
                    state = 1;
                    continue;
                }
            } else if(state == 1) {
                if(c >= '0' && c <= '9') {
                    flag = true;
                    continue;
                }
                else if(c == 'e' || c == 'E') {
                    if(i == s.length() - 1) return false;
                    if(s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'){
                        i++;
                        if(i == s.length() - 1) return false;
                    }
                    state = 2;
                    continue;
                } else if(c == '.') {
                    return false;
                }
            } else if(state == 2) {
                if(!flag) return false;
                if(c >= '0' && c <= '9') continue;
                else if(c == 'e' || c == 'E') {
                    return false;
                } else if(c == '.') {
                    return false;
                }
            }
        }
        return true;

    }
}
// @lc code=end

