package LeetCode.SlidingWindow.Medium;

public class Longest_Repeating_Character_Replacement {

    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement classObj = new Longest_Repeating_Character_Replacement();
        System.out.println("Sol 1 (ABBB, k = 2) : " + classObj.characterReplacementBetter("ABBB", 2));
        System.out.println("Sol 1 (AABABBA, k = 1) : " + classObj.characterReplacementBetter("AABABBA", 1));


    }


    public int characterReplacementBruteForce(String s, int k) {

        int n = s.length(), maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] charCount = new int[26];
//            char maxChar = s.charAt(i); // No need to store the maxChar, we only need the count of the most frequent character in the current window
            int maxCount = 0, replace = 0;

            for (int j = i; j < n; j++) {

                int indx = s.charAt(j) - 'A';
                charCount[indx]++;

                if (charCount[indx] > maxCount) {
                    maxCount = charCount[indx];
//                    maxChar = s.charAt(j);
                } else {
                    replace++;
                }

                if (replace > k) break;

                maxLen = Math.max(maxLen, (j - i) + 1);

            }
        }

        return maxLen;
    }

    public int characterReplacementBetterBruteForce(String s, int k) {

        int n = s.length(), maxLen = 0;
        boolean hasReachedN = false;

        for (int i = 0; i < n && !hasReachedN; i++) {
            int[] charCount = new int[26];
            int maxCount = 0, replace = 0;

            for (int j = i; j < n; j++) {

                if (j == n-1) hasReachedN = true;

                int indx = s.charAt(j) - 'A';
                charCount[indx]++;

                if (charCount[indx] > maxCount) {
                    maxCount = charCount[indx];
                } else {
                    replace++;
                }

                if (replace > k) break;

                maxLen = Math.max(maxLen, (j - i) + 1);

            }
        }

        return maxLen;
    }

    public int characterReplacementBetter(String s, int k) {

        int n = s.length(), maxLen = 0;

        int left = 0;

        // Array to count frequency of characters in window
        int[] freq = new int[26];


        int maxFreq = 0;


        // Traverse the string with right pointer
        for (int right = 0; right < s.length(); right++) {

            // Increment count of current character
            freq[s.charAt(right) - 'A']++;

            // Update max frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If number of changes exceeds k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update result with valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
