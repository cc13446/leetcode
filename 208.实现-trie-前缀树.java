/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    static class TreeNode {
        String val = null;
        TreeNode[] children = new TreeNode[26];
    }

    TreeNode root = new TreeNode();

    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode t = root;

        for (char c : word.toCharArray()) {
            if (t.children[c - 'a'] == null) {
                t.children[c - 'a'] = new TreeNode();
            }
            t = t.children[c - 'a'];
        }
        t.val = word;
    }
    
    public boolean search(String word) {
        TreeNode t = root;

        for (char c : word.toCharArray()) {
            t = t.children[c - 'a'];
            if (t == null) {
                return false;
            }
            
        }
        return t.val != null;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode t = root;
        for (char c : prefix.toCharArray()) {
            t = t.children[c - 'a'];
            if (t == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

