package Graphs.BFS_DFS;

import java.util.*;

public class WordLadder1 {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        List<String> wordList1 = List.of("hot","dot","dog","lot","log");

        System.out.println(ladderLength(beginWord, endWord, wordList1));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));

        /* wordset can't have begin word so if it is there remove it */
        wordSet.remove(beginWord);


        while (!queue.isEmpty()) {
            String word = queue.peek().firstWord;
            Integer steps = queue.peek().step;
            queue.remove();

            /* if the targetWord/endWord is reached in queue peek then return the steps,
               as reaching endWord was last step and target */
            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {

                /* copy the word string to char array */
                char[] chArr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    /* modify the i'th index of char from a-z */
                    chArr[i] = ch;
                    String tempWord = new String(chArr);

                    /* If the wordSet contains tempWord :
                        means we reached a new step transforming the word,
                        now we remove from wordSet and add to queue to transform this new step word further until the endWord is found */
                    if (wordSet.contains(tempWord)) {
                        wordSet.remove(tempWord);
                        queue.add(new Pair(tempWord, steps+1));
                    }

                }
            }

        }


        return 0;
    }


    static class Pair {

        String firstWord;
        Integer step;

        Pair(String firstWord, Integer step) {
            this.firstWord = firstWord;
            this.step = step;
        }

    }


}

