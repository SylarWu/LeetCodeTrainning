package tech.sylardaemon;

public class Solution720 {

    class Trie {
        private static final int NUM_CHAR = 26;
        private static final char BEGIN_CHAR = 'a';

        class TrieNode {
            boolean isEnd;
            TrieNode[] next;

            TrieNode() {
                this.isEnd = false;
                this.next = new TrieNode[NUM_CHAR];
            }
        }

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = this.root;
            for (int i = 0; i < s.length(); ++i) {
                int u = s.charAt(i) - BEGIN_CHAR;
                if (node.next[u] == null) {
                    node.next[u] = new TrieNode();
                }
                node = node.next[u];
            }
            node.isEnd = true;
        }

        public boolean search(String s) {
            TrieNode node = this.root;
            for (int i = 0; i < s.length(); ++i) {
                int u = s.charAt(i) - BEGIN_CHAR;
                if (node.next[u] == null || !node.next[u].isEnd) {
                    return false;
                }
                node = node.next[u];
            }
            return node != null && node.isEnd;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        String result = "";
        for (String s : words) {
            int n = s.length();
            int m = result.length();
            if (n < m) {
                continue;
            }
            if (n == m && s.compareTo(result) > 0) {
                continue;
            }
            if (trie.search(s)) {
                result = s;
            }
        }
        return result;
    }
}
