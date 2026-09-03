package LeetCode.Recursion.Trying_out_all_combos_advanced;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    public static void main(String[] args) {
        Expression_Add_Operators classObj = new Expression_Add_Operators();
//        classObj.addOperators("123", 6).forEach(System.out::println);
        classObj.addOperators("232", 8).forEach(System.out::println);
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        solve(res, num, target, num.length(), new StringBuilder(), 0, 0, 0);

        return res;
    }

    public void solve(List<String> res, String num, long target, int n, StringBuilder expr, int indx, long eval, long tail) {
        if (indx == n) {
            if (eval == target) res.add(expr.toString());
            return;
        }

        for (int i = indx; i < n; i++) {

            // Rule: No numbers with leading zeros (e.g., "05" is invalid, but "0" is okay)
            if (i != indx && num.charAt(indx) == '0') break;

            String currentStr = num.substring(indx, i + 1);
            Long curr = Long.valueOf(currentStr);

            int lengthBeforeAdding = expr.length();

            if (indx == 0) {
                solve(res, num, target, n, expr.append(curr), i + 1, eval + curr, curr);
                expr.setLength(lengthBeforeAdding);
            } else {
                expr.append("+").append(curr);
                solve(res, num, target, n, expr, i + 1, eval + curr, curr);
                expr.setLength(lengthBeforeAdding);

                expr.append("-").append(curr);
                solve(res, num, target, n, expr, i + 1, eval - curr, -curr);
                expr.setLength(lengthBeforeAdding);

                expr.append("*").append(curr);
                solve(res, num, target, n, expr, i + 1, eval - tail + (tail * curr), tail * curr);
                expr.setLength(lengthBeforeAdding);

            }
        }

    }


}
