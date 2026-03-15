package Codeforces.Rated_800;

import java.util.Scanner;

public class Haloumi_Boxes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            int i = 0;
            while (i < n) {
                arr[i] = sc.nextInt();
                i++;
            }

            System.out.println(canBeSorted(n, k, arr));
        }
        sc.close();

    }

    private static String canBeSorted(int n, int k, int[] arr) {

        if (k >= 2) {
            return "YES";
        }
        else {

            boolean sorted = true;

            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i-1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return "YES";
            }
            else {
                return "NO";
            }

        }
        
    }

}
