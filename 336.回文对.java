import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], Integer.valueOf(i));
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            if (word.equals("")) {
                continue;
            }
            int r = map.getOrDefault(word, -1);
            if (r > i) {
                res.add(List.of(i, r));
                res.add(List.of(r, i));
            }

            int n = word.length();
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                arr[j][j] = 1;
            }

            for (int j = n - 2; j >= 0; j--) {
                for (int k = j + 1; k < n; k++) {
                    if (word.charAt(j) == word.charAt(k) && (arr[j + 1][k - 1] == 1 || k == j + 1)) {
                        arr[j][k] = 1;
                    }
                }
            }

            for (int j = 0; j < n - 1; j++) {
                
                if (arr[j + 1][n - 1] == 1) {
                    r = map.getOrDefault(word.substring(0, j + 1), -1); 
                    if (r >= 0) {
                        res.add(List.of(r, i));
                    }
                }

                if (arr[0][j] == 1) {
                    r = map.getOrDefault(word.substring(j + 1), -1); 
                    if (r >= 0) {
                        res.add(List.of(i, r));
                    }
                }
            }

            if (arr[0][n - 1] == 1) {
                r = map.getOrDefault("", -1);
                if (r >= 0) {
                    res.add(List.of(i, r));
                    res.add(List.of(r, i));
                }
            }

        }
        return res;
    }
}
// @lc code=end

