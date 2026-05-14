package LeetCode.Strings.Problems.miscellaneous;

public class Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate {

    public static void main(String[] args) {
        Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate classObj = new Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate();
        System.out.println(classObj.minFlips("011010"));
    }

    public int minFlips(String s) {
        int n = s.length();

        int ones = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int cost = n;

        cost = Math.min(cost, n - ones); // case 1

        cost = Math.min(cost, ones); // case 2

        cost = Math.min(cost, Math.abs(ones - 1)); // case 3

        // case 4
        if (n > 1) {

            int cornerCaseCost = 0;

            if (s.charAt(0) == '0') {
                cornerCaseCost++;
            }

            if (s.charAt(n-1) == '0') {
                cornerCaseCost++;
            }

            int onesInBetweenCorners = ones - (2 - cornerCaseCost);

            cost = Math.min(cost, cornerCaseCost + onesInBetweenCorners);

        }


        return cost;
    }


}
