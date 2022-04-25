import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        List<List<String>> res = new LinkedList<>();
        Deque<String> path = new LinkedList<>(Arrays.asList(beginWord));
        HashMap<String, Integer> distance = new HashMap<>();
        dfs(distance, visited, map, endWord, path, res);
        return res;
    }

    private void dfs(HashMap<String, Integer> distance, Map<String, Boolean> visited, Map<String, Set<String>> map, String endWord, Deque<String> path, List<List<String>> res) {
        if (!res.isEmpty() && path.size() > res.get(0).size()) return;
        if (path.getLast().equals(endWord)) {
            if (res.isEmpty()) {
                res.add(new LinkedList<>(path));
            } else {
                if (res.get(0).size() > path.size()) {
                    res.clear();
                }
                res.add(new LinkedList<>(path));
            }
            
            return;
        }
        for (String word : map.get(path.getLast())) {
            if (!visited.containsKey(word) && (!distance.containsKey(word) || distance.get(word) > path.size())) {
                visited.put(word, true);
                path.addLast(word);
                dfs(distance, visited, map, endWord, path, res);
                distance.put(word, path.size());
                path.removeLast();
                visited.remove(word);
            }
        }
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

