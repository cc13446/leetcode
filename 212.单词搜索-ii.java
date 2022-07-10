import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        //插入数据
        for (String word : words){
            myTrie.addWord(word);
        }

        //构建结果集容器
        Set<String> result = new HashSet<>();
        //矩阵行数
        int m = board.length;
        //矩阵列数
        int n = board[0].length;
        //存储该节点是否访问
        boolean[][] visited = new boolean[m][n];
        //遍历整个二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return new LinkedList<>(result);

    }



    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, Solution.TrieNode cur) {
        //边界判断以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return;
        //获取子节点状态，判断其是否有子节点
        cur = cur.children[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }
        //修改节点状态，防止重复访问
        visited[i][j] = true;
        //找到单词加入
        if (cur.val != null) {
            result.add(cur.val);
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        //最后修改节点状态为未访问状态
        visited[i][j] = false;
    }



    static class WordTrie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode n = root;
            for (char c : word.toCharArray()) {
                if (n.children[c - 'a'] == null) {
                    n.children[c - 'a'] = new TrieNode();
                }
                n = n.children[c - 'a'];
            }
            n.val = word;
        }
    }

    static class TrieNode {
        String val = null;
        TrieNode[] children = new TrieNode[26];
    }
}
// @lc code=end

