import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean flag = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);

        long integer = n / d;
        long f = n - integer * d;
        if (f == 0) return String.valueOf(flag ? -integer : integer);

        StringBuilder sb = new StringBuilder();
        sb.append(flag? "-" : "");
        sb.append(integer + ".");

        Map<Long, Integer> m = new HashMap<>();
        for (int i =sb.length(); f != 0 && !m.containsKey(f); i++) {
            m.put(f, i);
            f *= 10;
            sb.append(f / d);
            f = f % d;
        }
        if (f != 0) {
            int first = m.get(f);
            sb.insert(first, '(');
            sb.append(")");
        }
        return sb.toString();
    }
}
// @lc code=end

