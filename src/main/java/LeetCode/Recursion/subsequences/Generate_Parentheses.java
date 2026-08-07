package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {


/* Recursive Opimized Method (generateMoreOptimized())

TC : O(n x Cn) or O(4^n / under root(n))

1. The total number of valid combinations for n pairs is the n-th Catalan number.
2. sb.toString() - This operation copies the 2 x n characters from the StringBuilder into a new String object, taking O(n) time.

SC : Call stack requires O(2n) space, which simplifies to O(n).

*/

    public static void main(String[] args) {
        Generate_Parentheses classObj = new Generate_Parentheses();

        classObj.generateParenthesis(3).forEach(System.out::println);

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generateMoreOptimized(n, 0, 0, new StringBuilder(), res);

        return res;
    }

    public void generate(int n, int openingCount, int closingCount, StringBuilder sb, List<String> res) {
        if (openingCount < closingCount) {
            return;
        }
        if (openingCount == n && closingCount == n) {
            res.add(sb.toString());
            return;
        }

        if (openingCount < n) {
            sb.append("(");
            generate(n, openingCount + 1, closingCount, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closingCount < n) {
            sb.append(")");
            generate(n, openingCount, closingCount + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public void generateMoreOptimized(int n, int openingCount, int closingCount, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        // Only add an open bracket if we haven't reached n
        if (openingCount < n) {
            sb.append("(");
            generateMoreOptimized(n, openingCount + 1, closingCount, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        // Only add a close bracket if it can match an existing open bracket
        if (closingCount < openingCount) {
            sb.append(")");
            generateMoreOptimized(n, openingCount, closingCount + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

                /* n == 3
                ((()))
                (()())
                (())()
                ()(())
                ()()()*/

}
