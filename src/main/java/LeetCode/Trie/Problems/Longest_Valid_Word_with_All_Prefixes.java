package LeetCode.Trie.Problems;

import LeetCode.Trie.Utility.TrieNode;

import java.util.HashSet;

public class Longest_Valid_Word_with_All_Prefixes {

    public static void main(String[] args) {
        Longest_Valid_Word_with_All_Prefixes classObj = new Longest_Valid_Word_with_All_Prefixes();
        String res = classObj.longestValidWordOptimal(new String[]{"p", "pr", "pro", "probl", "problem", "pros", "process", "processor" });
        System.out.println(res);

        String res1 = classObj.longestValidWordOptimal(new String[]{"geeks", "gfg", "geeksforgeeks" });
        System.out.println(res1);
    }

    public String longestValidWordBruteForce(String[] words) {
        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        String longestWord = "";

        for (String word : words) {

            boolean hasAllPrefix = true;

            for (int i = word.length() - 1; i > 0; i--) {
                String prefix = word.substring(0, i);

                if (!set.contains(prefix)) {
                    hasAllPrefix = false;
                    break;
                }
            }

            if (hasAllPrefix) {
                int len = word.length(), maxLen = longestWord.length();
                if (len > maxLen) {
                    longestWord = word;
                } else if (len == maxLen && word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }

        }


        return longestWord;
    }

    public String longestValidWordOptimal(String[] words) {
        TrieNode root = new TrieNode();
        TrieOptimal trieOptimal = new TrieOptimal();

        for (String word : words) {
            trieOptimal.insert(word, root);
        }

        String longestWord = "";

        for (String word : words) {
            if (trieOptimal.checkIfPrefixExists(word, root)) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                } else if (word.length() == longestWord.length() && word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }


}

class TrieOptimal {

    public void insert(String word, TrieNode root) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            if (!curr.containsKey(ch)) {
                curr.put(ch, new TrieNode());
            }

            curr = curr.get(ch);
        }

        curr.setEndOfWord();
    }

    public boolean checkIfPrefixExists(String word, TrieNode root) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.get(ch);

            if (curr == null || !curr.isEndOfWord()) {
                return false;
            }
        }

        return true;
    }

}