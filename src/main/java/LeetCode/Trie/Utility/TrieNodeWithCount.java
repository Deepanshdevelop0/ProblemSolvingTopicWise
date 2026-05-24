package LeetCode.Trie.Utility;

public class TrieNodeWithCount {

    private TrieNodeWithCount[] children;

    private int endsWith;
    private int prefixCount;

    public TrieNodeWithCount() {
        children = new TrieNodeWithCount[26];
        endsWith = 0;
        prefixCount = 0;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNodeWithCount node) {
        children[ch - 'a'] = new TrieNodeWithCount();
    }

    public TrieNodeWithCount get(char ch) {
        return children[ch - 'a'];
    }

    public void increasePrefixCount() {
        prefixCount++;
    }
    public void decreasePrefixCount() {
        prefixCount--;
    }
    public void increaseEndsWith() {
        endsWith++;
    }

    public void decreaseEndsWith() {
        endsWith--;
    }
    public int getPrefixCount() {
        return prefixCount;
    }

    public int getEndsWith() {
        return endsWith;
    }

}
