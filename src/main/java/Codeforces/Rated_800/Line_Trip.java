package Codeforces.Rated_800;

import java.util.Scanner;

public class Line_Trip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter t : ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter n : ");
            int n = sc.nextInt();
            System.out.println("Enter x : ");
            int x = sc.nextInt();

            int[] arr = new int[n + 1];

            arr[0] = 0;

            int i = 0;
            while (i < n) {
                System.out.println("Enter " + i + " : ");
                arr[i+1] = sc.nextInt();
                i++;
            }

            System.out.println(minPossibleGas(n, x, arr));

        }

        sc.close();
    }

    private static int minPossibleGas(int n, int x, int[] arr) {

        int len = arr.length, max = (x - arr[len - 1]) * 2;

        for (int i = 1; i < len; i++) {
            max = Math.max(max, arr[i] - arr[i-1]);
        }

        return max;
    }

}
