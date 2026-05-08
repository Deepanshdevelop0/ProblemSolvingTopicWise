package LeetCode.Arrays.matrix;

public class Rotating_The_Box {

    public static void main(String[] args) {
        Rotating_The_Box classObj = new Rotating_The_Box();
        char[][] boxGrid = {
                {'#', '#', '.', '*', '#', '.', '*'},
                {'#', '#', '#', '.', '.', '.', '*'},
                {'#', '#', '#', '.', '#', '.', '*'},
        };

        classObj.rotateTheBox(boxGrid);
        for (char[] row : classObj.rotateTheBox(boxGrid)) {
            System.out.println(row);
        }

    }

    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length, n = boxGrid[0].length;

        for (char[] arr : boxGrid) {
            int stones = 0;
            for (int i = 0; i < n; i++) {

                if (arr[i] == '#') {
                    stones++;
                } else if (arr[i] == '*') {
                    dropStones(arr, stones, i);
                    stones = 0;
                }

            }

            dropStones(arr, stones, n);
        }

        return inverse(m, n, boxGrid);
    }

    public void dropStones(char[] arr, int stones, int end) {
        end -= 1;

        while (stones > 0 && arr[end] != '*') {
            arr[end] = '#';
            end--;
            stones--;
        }

        while (end >= 0 && arr[end] != '*') {
            arr[end--] = '.';
        }

    }

    public char[][] inverse(int m, int n, char[][] boxGrid) {

        char[][] rotated = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = boxGrid[m - j - 1][i];
            }
        }

        return rotated;
    }


}
