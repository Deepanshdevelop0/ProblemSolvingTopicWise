package Graphs.BFS_DFS;

import java.util.*;

public class minimumGeneticMutation {


    /* BFS + Hashing (Visited lookups via hashset)

        TC : O(N) + O(N * (L * 4) * O(L + L)) ~ O(N * 4L²) ~ O(N * L²)
        1. Add bank[] to set
        2.
          i. No of genes in bank which will add into queue (N)
          ii. each gene seq is iterated upto size 'L' and modify each char from 4 chars given (L * 4)
          iii. For each sequence converting to charArray and new String (L + L)

        SC : O(N + N + 4) ~ O(N)

        1. bank Set
        2. Queue size (at max equivalent to bank arr size)
        3. constant space for char Arr

    */

    public static void main(String[] args) {

        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};

        System.out.println(minMutation(startGene, endGene, bank));

    }

    public static int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>(List.of(bank));

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startGene, 0));

        List<Character> charList = List.of('A', 'C', 'G', 'T');

        while (!queue.isEmpty()) {

            String currWord = queue.peek().word;
            Integer steps = queue.peek().steps;

            queue.remove();

            if (currWord.equals(endGene)) return steps;

            for (int i = 0; i < currWord.length(); i++) {

                char[] chArr = currWord.toCharArray();

                for (char ch : charList) {

                    chArr[i] = ch;
                    String temp = new String(chArr);

                    if (bankSet.contains(temp)) {
                        bankSet.remove(temp);
                        queue.add(new Pair(temp, steps + 1));
                    }
                }
            }

        }

        return -1;
    }


    static class Pair {

        private String word;
        private Integer steps;

        Pair(String word, Integer steps) {
            this.word = word;
            this.steps = steps;
        }

    }


}
