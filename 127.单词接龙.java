import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            map.put(word, new HashSet<>());
        }
        map.put(beginWord, new HashSet<>());
        for (String word : wordList) {
            if (isNeighbor(word, beginWord)) {
                map.get(beginWord).add(word);                
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if (isNeighbor(word1, word2)) {
                    map.get(word1).add(word2);
                    map.get(word2).add(word1);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Set<String> next = new HashSet<>();
        next.add(beginWord);
        int res = 1;
        while(!next.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String word : next) {
                for(String s : map.get(word)) {
                    if (!visited.contains(s)){
                        visited.add(s);
                        temp.add(s);
                    }
                }
            }
            if (temp.contains(endWord)) {
                return res + 1;
            }
            next = temp;
            res++;
        }
        return 0;
    }

    private boolean isNeighbor(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
// @lc code=end

