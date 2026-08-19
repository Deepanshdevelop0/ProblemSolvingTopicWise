package LeetCode.Recursion.Trying_out_all_combos_advanced;

import java.util.ArrayList;
import java.util.List;

public class Word_Search {

/*

Method: exist / dfs (Approach 1: Using visitedArr and indxMap)

Time Complexity: O(M * N * 3^L)
1. Board Traversal: We iterate through the M * N board to find starting characters.
2. DFS Exploration: For a word of length L, the DFS goes up to L levels deep. At each step, we explore at most 3 valid directions (since we don't go back to the cell we just came from). This takes O(3^L) time.
3. Total Time: In the absolute worst case (e.g., all identical characters on the board), we trigger the DFS for every cell, resulting in O(M * N * 3^L).

Space Complexity: O(M * N)
1. Recursion Call Stack: The recursion goes L levels deep, taking O(L) space.
2. indxMap List: Can store up to M * N coordinates in the worst case, taking O(M * N) space.
3. visitedArr Matrix: We allocate a new boolean matrix of size M * N for every valid starting point, taking O(M * N) space.
4. Total Auxiliary Space: O(M * N) + O(M * N) + O(L) simplifies to O(M * N).

---------------------------------------------------------

Method: existOptimal / dfsOptimal (Approach 2: In-place modification)

Time Complexity: O(M * N * 3^L)
1. The time complexity remains mathematically the same as Approach 1. We still scan the M * N board and branch out in 3 directions for L characters.
(Note: While the Big-O is the same, this approach runs much faster in practice because it avoids the overhead of object creation and garbage collection).

Space Complexity: O(L)
1. Recursion Call Stack: The recursion tree goes at most L levels deep, taking O(L) space.
2. In-Place visited tracking: By temporarily mutating the board array (changing characters to '#'), we completely eliminate the need for the M * N boolean matrix and the indxMap.
3. Total Auxiliary Space: O(L). This is the optimal space complexity for this problem.

*/

    public static void main(String[] args) {
        Word_Search classObj = new Word_Search();
//        boolean res = classObj.exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'C'}
//        }, "SEE");
        boolean res = classObj.existOptimal(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS");

        System.out.println("result : " + res);

    }


    public boolean exist(char[][] board, String word) {

        List<int[]> indxMap = new ArrayList<>();
        int m = board.length, n = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    indxMap.add(new int[]{i, j});
                }
            }
        }


        for (int[] indxEntry : indxMap) {
            boolean[][] visitedArr = new boolean[m+1][n+1];
            if (dfs(indxEntry[0], indxEntry[1], 0, word.length(), visitedArr,  board, word)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int indxInWord, int wordLength, boolean[][] visitedArr, char[][] board, String word) {
        if (i == board.length || j == board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (visitedArr[i][j] || board[i][j] != word.charAt(indxInWord)) {
            return false;
        }
        if (board[i][j] == word.charAt(indxInWord) && indxInWord == wordLength-1) {
            return true;
        }

        visitedArr[i][j] = true;

        boolean found = (dfs(i-1, j, indxInWord+1, word.length(), visitedArr, board, word)) ||
                (dfs(i+1, j, indxInWord+1, word.length(), visitedArr, board, word)) ||
                (dfs(i, j-1, indxInWord+1, word.length(), visitedArr, board, word)) ||
                (dfs(i, j+1, indxInWord+1, word.length(), visitedArr, board, word));

        visitedArr[i][j] = false;

        return found;
    }


    public boolean existOptimal(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfsOptimal(i, j, 0, word.length(), board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsOptimal(int i, int j, int indxInWord, int wordLength, char[][] board, String word) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (board[i][j] != word.charAt(indxInWord)) {
            return false;
        }
        if (indxInWord == wordLength-1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfsOptimal(i-1, j, indxInWord+1, wordLength, board, word) ||
                dfsOptimal(i+1, j, indxInWord+1, wordLength, board, word) ||
                dfsOptimal(i, j-1, indxInWord+1, wordLength, board, word) ||
                dfsOptimal(i, j+1, indxInWord+1, wordLength, board, word);

        board[i][j] = temp;

        return found;
    }

//    {'A', 'B', 'C', 'E'},
//    {'S', 'F', 'F', 'S'},
//    {'A', 'D', 'E', 'E'}

}
