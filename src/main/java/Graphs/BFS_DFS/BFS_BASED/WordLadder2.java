package Graphs.BFS_DFS.BFS_BASED;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        List<String> wordList1 = List.of("hot","dot","dog","lot","log");


        System.out.println(findLadders(beginWord, endWord, wordList));

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.add(list);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;

        List<List<String>> res = new ArrayList<>();

        while (!queue.isEmpty()) {

            ArrayList<String> currList = queue.peek();
            queue.remove();

            if (currList.size() > level) {
                level++;
                for (String i : usedOnLevel) {
                    wordSet.remove(i);
                }
            }

            String word = currList.get(currList.size() - 1);

            if (word.equals(endWord)) {
                if (res.isEmpty()) res.add(currList);
                else if (res.get(0).size() == currList.size()) res.add(currList);
            }


            for (int i = 0; i < word.length(); i++) {

                char[] chArr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chArr[i] = ch;
                    String temp = new String(chArr);

                    if (wordSet.contains(temp)) {

                        currList.add(temp);

                        queue.add(new ArrayList<>(currList));

                        usedOnLevel.add(temp);

                        currList.remove(currList.size() - 1);

                    }
                }
            }

        }


        return res;
    }


}

