package Codeforces.Rated_800;

import java.util.Scanner;

public class Cover_in_Water {


// Time Complexity (TC): O(n) = O(100)
// Space Complexity (SC): O(n) = O(100)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter t : ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter n : ");
            int n = sc.nextInt();
            System.out.println("Enter s : ");
            sc.nextLine();

            // 3. Read the string of length n
            String s = sc.nextLine();

            System.out.println(actionNeededToFillEmptyCells(n, s));

        }

        sc.close();
    }

    private static int actionNeededToFillEmptyCells(int n, String s) {

        boolean hasThreeConsecutive = false;
        char[] charr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean curr = charr[i] == '.'; // is empty for water
            boolean one = (i < n - 1 && charr[i + 1] == '.');
            boolean two = (i < n - 2 && charr[i + 2] == '.');
            if (curr && one && two) {
                hasThreeConsecutive = true;
                break;
            } else if (curr) {
                count++;
            }
        }

        return (hasThreeConsecutive) ? 2 : count;
    }

}
