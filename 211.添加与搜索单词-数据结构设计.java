/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    
    static class Node {
        Node[] nodes = new Node[26];
        boolean end = false;
    }

    Node roots = new Node();

    public WordDictionary() {

    }
    
    public void addWord(String word) {
        Node n = roots;
        char[] str = word.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (n.nodes[c - 'a'] == null) {
                n.nodes[c - 'a'] = new Node();
            }
            n = n.nodes[c - 'a'];
        }
        n.end = true;
    }
    
    public boolean search(String word) {
        Node n = roots;
        char[] str = word.toCharArray();
        return search(0, str, n);
    }

    private boolean search(int i, char[] str, WordDictionary.Node n) {
        if (i == str.length) {
            return n.end;
        }

        if (str[i] == '.') {
            for (int j = 0; j < 26; j++) {
                if (n.nodes[j] != null && search(i + 1, str, n.nodes[j])) {
                    return true;
                }
            }
            return false;
        }

        return n.nodes[str[i] - 'a'] == null ? false : search(i + 1, str, n.nodes[str[i] - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

