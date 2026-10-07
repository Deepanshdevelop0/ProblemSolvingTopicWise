package LeetCode.Stacks.Problems;

import java.util.Stack;

public class Score_of_Parentheses {

    public static void main(String[] args) {
        Score_of_Parentheses classObj = new Score_of_Parentheses();
//        int res = classObj.scoreOfParenthesesI("()(())");
        int res = classObj.scoreOfParenthesesI("()(())");
        System.out.println(res);

        int res1 = classObj.scoreOfParenthesesI("((()())())");
        System.out.println(res1);
    }

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int currScore = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(currScore);
                currScore = 0;
            } else {
                int recent = stack.pop();

                currScore = recent + Math.max(currScore * 2, 1);
            }
        }

        return currScore;
    }

    public int scoreOfParenthesesI(String s) {

        int openCount = 0, score = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openCount++;
            }
            else {
                if (s.charAt(i-1) == '(') {
                    score += (int) Math.pow(2, openCount - 1);
                }
                openCount--;
            }
        }


        return score;
    }
}
