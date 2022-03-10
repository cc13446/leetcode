import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (0 == words.length) return res;
        int wordLen = words[0].length();
        if (null == s || s.length() < wordLen) return res;
        Map<String, Long> allWords = Arrays.stream(words)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < s.length() - words.length * wordLen + 1; i++) {
            Map<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            while (num < words.length) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == words.length) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

