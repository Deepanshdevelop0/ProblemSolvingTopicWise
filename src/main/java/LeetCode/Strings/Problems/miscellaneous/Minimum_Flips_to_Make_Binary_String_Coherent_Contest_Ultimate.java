package LeetCode.Strings.Problems.miscellaneous;

public class Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate {

    public static void main(String[] args) {
        Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate classObj = new Minimum_Flips_to_Make_Binary_String_Coherent_Contest_Ultimate();
        System.out.println(classObj.minFlips("011010"));
        System.out.println(classObj.minFlips("1010"));
        System.out.println(classObj.minFlips("0110"));
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

        // Case 1: All ones
        // Cost is the number of '0's currently in the string that need to be flipped to '1'.
        cost = Math.min(cost, n - ones);

        // Case 2: All zeros
        // Cost is the number of '1's currently in the string that need to be flipped to '0'.
        cost = Math.min(cost, ones); // case 2

        // Case 3: Exactly one '1', all others '0'
        // We flip all current '1's to '0' (cost = ones), then pick the "cheapest" position
        // to turn into a '1'. If there was already a '1', cost decreases; if not, it increases.
        cost = Math.min(cost, Math.abs(ones - 1)); // case 3

        // Case 4: Both ends are '1', all middle bits are '0'
        if (n > 1) {

            int cornerCaseCost = 0;

            // Count flips needed to make the first and last characters '1'
            if (s.charAt(0) == '0') {
                cornerCaseCost++;
            }
            if (s.charAt(n-1) == '0') {
                cornerCaseCost++;
            }

            // Count existing '1's in the middle that must be flipped to '0'
            int onesInMiddle = ones;
            if (s.charAt(0) == '1') onesInMiddle--;
            if (s.charAt(n - 1) == '1') onesInMiddle--;

            cost = Math.min(cost, cornerCaseCost + onesInMiddle);
        }

        return cost;
    }


}
