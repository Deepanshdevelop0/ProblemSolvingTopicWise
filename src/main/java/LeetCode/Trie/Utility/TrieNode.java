package LeetCode.Trie.Utility;

public class TrieNode {

    private TrieNode[] children;

    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

}
