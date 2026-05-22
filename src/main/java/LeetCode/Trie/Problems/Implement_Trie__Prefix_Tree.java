package LeetCode.Trie.Problems;

import LeetCode.Trie.Utility.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class Implement_Trie__Prefix_Tree {

    TrieNode node;

    public Implement_Trie__Prefix_Tree() {
        node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = node;

        for (char ch : word.toCharArray()) {
            if (!curr.containsKey(ch)) {
                curr.put(ch, new TrieNode());
            }

            curr = curr.get(ch);
        }

        curr.setEndOfWord();
    }

    public boolean search(String word) {
        TrieNode curr = node;

        for (char ch : word.toCharArray()) {
            if (curr.containsKey(ch)) {
                curr = curr.get(ch);
            } else {
                return false;
            }
        }

        return curr.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = node;

        for (char ch : prefix.toCharArray()) {
            if (curr.containsKey(ch)) {
                curr = curr.get(ch);
            } else {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Implement_Trie__Prefix_Tree trie = new Implement_Trie__Prefix_Tree();
        String[] operations = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] arguments = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};

        List<String> output = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    output.add("null");
                    break;
                case "insert":
                    trie.insert(arguments[i][0]);
                    output.add("null");
                    break;
                case "search":
                    output.add(trie.search(arguments[i][0]) ? "true" : "false");
                    break;
                case "startsWith":
                    output.add(trie.startsWith(arguments[i][0]) ? "true" : "false");
                    break;
            }
        }

        for (String res : output) {
            System.out.println(res);
        }
    }

}
