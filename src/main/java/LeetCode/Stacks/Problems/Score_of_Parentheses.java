package LeetCode.Stacks.Problems;

import java.util.Stack;

public class Score_of_Parentheses {

    public static void main(String[] args) {
        Score_of_Parentheses classObj = new Score_of_Parentheses();
        int res = classObj.scoreOfParentheses("()(())");
        System.out.println(res);
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
}
