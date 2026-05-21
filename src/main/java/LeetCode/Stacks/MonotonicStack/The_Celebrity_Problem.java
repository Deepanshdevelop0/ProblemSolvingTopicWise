package LeetCode.Stacks.MonotonicStack;

import java.util.Stack;

public class The_Celebrity_Problem {

    public static void main(String[] args) {
        The_Celebrity_Problem classObj = new The_Celebrity_Problem();

        int[][] mat = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        int[][] mat1 = {{1, 1}, {1, 1}};

        System.out.println(classObj.celebrityOptimal(mat1));
    }


    public int celebrity(int mat[][]) {

        int persons = mat.length;

        if (persons <= 1) return 0;

        int[] knows = new int[persons];
        int[] knownBy = new int[persons];

        for (int i = 0; i < persons; i++) {
            for (int j = 0; j < persons; j++) {
                if (mat[i][j] == 1) {
                    knows[i]++;
                    knownBy[j]++;
                }
            }
        }


        for (int i = 0; i < persons; i++) {
            if (knows[i] == 1 && knownBy[i] == persons) {
                return i;
            }
        }

        return -1;
    }


    public int celebrityOptimal(int mat[][]) {

        int persons = mat.length;

        if (persons <= 1) return 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < persons; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {

            int p1 = stack.pop();
            int p2 = stack.pop();

            // if person1 knows person2, then person1 cannot be celebrity, but person2 can be celebrity
            if (mat[p1][p2] == 1) {
                stack.push(p2);
            } else {
                stack.push(p1);
            }
        }

        int celebrity = stack.pop();

        for (int i = 0; i < persons; i++) {

            if (i == celebrity) continue;

            // if celebrity knows any person or any person not knows celebrity, ten he's not celebrity
            if (mat[celebrity][i] == 1 || mat[i][celebrity] == 0) {
                return -1;
            }
        }

        return celebrity;
    }


}
