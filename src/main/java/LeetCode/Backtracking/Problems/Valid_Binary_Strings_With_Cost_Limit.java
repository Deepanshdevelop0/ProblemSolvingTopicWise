package LeetCode.Backtracking.Problems;

import java.util.ArrayList;
import java.util.List;

public class Valid_Binary_Strings_With_Cost_Limit {

    public static void main(String[] args) {

        Valid_Binary_Strings_With_Cost_Limit classObj = new Valid_Binary_Strings_With_Cost_Limit();

        for (String generateValidString : classObj.generateValidStrings(3, 1)) {
            System.out.println(generateValidString);
        }
    }


    public List<String> generateValidStrings(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(n, k, 0, sb, res);

        return res;
    }

    public void backtrack(int n, int k, int cost, StringBuilder sb, List<String> res) {

        if (sb.length() == n) {
            if (cost <= k) {
                res.add(sb.toString());
            }
            return;
        }

        if (cost > k) {
            return;
        }

        sb.append("0");
        backtrack(n, k, cost, sb, res);

        sb.deleteCharAt(sb.length() - 1);

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '0') {
            sb.append("1");
            cost += sb.length() - 1;
            backtrack(n, k, cost, sb, res);

            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
