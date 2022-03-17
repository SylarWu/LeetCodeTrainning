package tech.sylardaemon;

public class Solution208 {
    class Trie {
        private static final int NUM_CHAR = 26;
        private static final char BEGIN_CHAR = 'a';
        class TrieNode{
            boolean isEnd;
            TrieNode[] next;
            TrieNode(){
                isEnd = false;
                next = new TrieNode[NUM_CHAR];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); ++i){
                int index = word.charAt(i) - BEGIN_CHAR;
                if (node.next[index] == null){
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); ++i){
                int index = word.charAt(i) - BEGIN_CHAR;
                if (node.next[index] == null){
                    return false;
                }
                node = node.next[index];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (int i = 0; i < prefix.length(); ++i){
                int index = prefix.charAt(i) - BEGIN_CHAR;
                if (node.next[index] == null){
                    return false;
                }
                node = node.next[index];
            }
            return true;
        }
    }
}
