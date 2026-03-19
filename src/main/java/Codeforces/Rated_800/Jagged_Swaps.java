package Codeforces.Rated_800;

import java.util.Arrays;
import java.util.Scanner;

public class Jagged_Swaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter t : ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter n : ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(possibleSort(arr));

        }

        sc.close();
    }

    public static String possibleSort(int[] arr) {

        int first = arr[0];
        Arrays.sort(arr);

        if (first == arr[0]) {
            return "YES";
        }

        return "NO";
    }


}
