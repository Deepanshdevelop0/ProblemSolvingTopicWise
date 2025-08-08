package Graphs.BFS_DFS.BFS_BASED;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList2 = List.of("hot","dot","dog","lot","log","cog");
        List<String> wordList1 = List.of("hot","dot","dog","lot","log");
        List<String> wordList = List.of("des", "der", "dfr", "dgt", "dfs");

        String startWord = "der", targetWord = "dfs";

        System.out.println(findLadders(startWord, targetWord, wordList));

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visitedSet = new HashSet<>();

        Pair pair = new Pair(beginWord, 1);

        wordSet.remove(beginWord);

        List<List<String>> res = new ArrayList<>();
        List<String> currList = new ArrayList<>();


        dfs(pair, endWord, visitedSet, wordSet, currList, res);

        return res;
    }


    public static void dfs(Pair currPair, String endWord, Set<String> visitedSet, Set<String> wordSet, List<String> currList,
                           List<List<String>> res) {

        String word = currPair.word;
        int steps = currPair.steps;

        currList.add(word);

        if (word.equals(endWord)) {
            wordSet.add(endWord);
            visitedSet.remove(endWord);
            res.add(new ArrayList<>(currList));
            return;
        }

        List<Pair> possibilities = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char[] charr = word.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                charr[i] = ch;
                String temp = new String(charr);

                if (wordSet.contains(temp)) {
                    wordSet.remove(temp);
                    possibilities.add(new Pair(temp, steps+1));
                    if (temp.equals(endWord)) break;
                }

            }

        }

        for (Pair pair : possibilities) {
            if (!visitedSet.contains(pair.word)) {
                visitedSet.add(pair.word);
                dfs(pair, endWord, visitedSet, wordSet, currList, res);
                currList.remove(currList.size() - 1);
            }
        }


    }

    static class Pair {

        String word;

        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }

    }


}

