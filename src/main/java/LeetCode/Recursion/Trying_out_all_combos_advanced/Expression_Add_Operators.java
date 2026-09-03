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
        int curr = num.charAt(0) - '0';

        StringBuilder expr = new StringBuilder();
        expr.append(curr);

        solve(expr, curr, 1, num.length(), num, target, res);

        return res;
    }

    public void solve(StringBuilder expr, int curr, int indx, int n, String num, int target, List<String> res) {
        if (indx == n && curr == target) {
            res.add(expr.toString());
            return;
        }
        if (indx == n) return;

        int digit = num.charAt(indx) - '0';

        if (curr <= target) {

            // '+' category

            expr.append('+').append(digit);
            curr += digit;

            solve(expr, curr, indx+1, n, num, target, res);

            curr -= digit;
            expr.deleteCharAt(expr.length()-1);
            expr.deleteCharAt(expr.length()-1);

            // '*' category

            expr.append('*').append(digit);
            curr *= digit;

            solve(expr, curr, indx+1, n, num, target, res);

            expr.deleteCharAt(expr.length()-1);
            expr.deleteCharAt(expr.length()-1);
        }
        else {

            // '-' category

            expr.append('-').append(digit);
            curr -= digit;

            solve(expr, curr, indx+1, n, num, target, res);

            expr.deleteCharAt(expr.length()-1);
            expr.deleteCharAt(expr.length()-1);

        }

    }


}
