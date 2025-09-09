package Stacks.Problems;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

/*

Stack Less Optimal

TC : O(N) : size of input string

SC : O(N) + O(3)
i. Size of input string in worst case
ii. Creation of set for checking opening brackets on each iteration

-----------------------------
Stack : Optimal

TC : O(N) : size of input string

SC : O(N) : size of input string in worst case

*/

    public static void main(String[] args) {
        System.out.println(isValidOptimal("()[]{}"));
        System.out.println(isValidOptimal("([(]))"));
        System.out.println(isValidOptimal("()"));
    }

    public static boolean isValidLessOptimal(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Set.of('(', '{', '[').contains(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && (stack.peek() == ch - 1 || stack.peek() == ch - 2)) {
                stack.pop();
            } else {
                return false;
            }
        }


        return stack.isEmpty() ? true : false;
    }

    public static boolean isValidOptimal(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else return false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else return false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else return false;
                    break;
            }

        }

        return stack.isEmpty();
    }


}
