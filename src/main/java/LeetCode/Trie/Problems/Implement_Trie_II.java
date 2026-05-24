package LeetCode.Trie.Problems;

import LeetCode.Trie.Utility.TrieNodeWithCount;

public class Implement_Trie_II {

    private TrieNodeWithCount root;

    public Implement_Trie_II() {
        root = new TrieNodeWithCount();
    }

    public void insert(String word) {

        TrieNodeWithCount curr = root;

        for (char ch : word.toCharArray()) {
            if (!curr.containsKey(ch)) {
                curr.put(ch, new TrieNodeWithCount());
            }

            curr = curr.get(ch);
            curr.increasePrefixCount();
        }

        curr.increaseEndsWith();
    }

    public int countWordsEqualTo(String word) {
        TrieNodeWithCount curr = root;

        for (char ch : word.toCharArray()) {
            if (!curr.containsKey(ch)) {
                return 0;
            }

            curr = curr.get(ch);
        }

        return curr.getEndsWith();
    }

    public int countWordsStartingWith(String word) {

        TrieNodeWithCount curr = root;

        for (char ch : word.toCharArray()) {
            if (!curr.containsKey(ch)) {
                return 0;
            }

            curr = curr.get(ch);
        }

        return curr.getPrefixCount();
    }

    public void erase(String word) {
        TrieNodeWithCount curr = root;

        for (char ch : word.toCharArray()) {
            curr = curr.get(ch);
            curr.decreasePrefixCount();
        }

        curr.decreaseEndsWith();
    }
}
