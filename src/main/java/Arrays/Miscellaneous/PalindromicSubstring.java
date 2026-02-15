package Arrays.Miscellaneous;

public class PalindromicSubstring {

    public static void main(String[] args) {

        // Test Cases
        String test1 = "abca";
//        String test2 = "racecar";
//        String test3 = "abcdef";
//        String test4 = "baab";

        PalindromicSubstring classObj = new PalindromicSubstring();
        System.out.println("Input: " + test1 + " | Output: " + classObj.almostPalindromic(test1)); // Expected: 4
//        System.out.println("Input: " + test2 + " | Output: " + almostPalindromic(test2)); // Expected: 7
//        System.out.println("Input: " + test3 + " | Output: " + almostPalindromic(test3)); // Expected: 2
//        System.out.println("Input: " + test4 + " | Output: " + almostPalindromic(test4)); // Expected: 4
    }
    public int almostPalindromic(String s) {
        int n = s.length();
        if (n < 2) return 0;

        int finalMax = 0;
        for (int i = 0; i < n; i++) {
            // Odd length expansion: center is character i
            int odd = grow(s, i, i);
            // Even length expansion: center is the gap between i and i+1
            int even = grow(s, i, i + 1);

            finalMax = Math.max(finalMax, Math.max(odd, even));
        }
        return finalMax;
    }

    private int grow(String s, int left, int right) {
        int n = s.length();
        int bestForCenter = 0;

        while (left >= 0 && right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                // Since we must remove exactly one char,
                // any palindrome of length L is part of an 'almost' palindrome of L+1
                if (left > 0 || right < n - 1) {
                    bestForCenter = Math.max(bestForCenter, len + 1);

                    if (left > 0 || right < n - 1) {
                        bestForCenter = Math.max(bestForCenter, (right - left + 1) + 1);
                    }
                } else {
                    // Special case: the entire string is a palindrome.
                    // Removing 1 char still makes it almost-palindromic.
                    bestForCenter = Math.max(bestForCenter, len);
                }
            } else {
                // First mismatch: check if skipping left or right works
                if (isStrict(s, left + 1, right) || isStrict(s, left, right - 1)) {
                    bestForCenter = Math.max(bestForCenter, right - left + 1);
                }
                break; // One-time error used up
            }
            left--;
            right++;
        }
        return bestForCenter;
    }

    private boolean isStrict(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
