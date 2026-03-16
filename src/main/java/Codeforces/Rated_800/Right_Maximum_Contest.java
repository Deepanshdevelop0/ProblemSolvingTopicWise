package Codeforces.Rated_800;

import java.util.Scanner;

public class Right_Maximum_Contest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];
            int[] maxArr = new int[n];

            int i = 0, max = 0;
            while (i < n) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                maxArr[i] = max;
                i++;
            }

            System.out.println(operationsToEmptyArray(n, arr, maxArr));
        }
        sc.close();

    }

    private static Integer operationsToEmptyArray(int n, int[] arr, int[] maxArr) {

        int operations = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == maxArr[i]) {
                operations++;
            }
        }

        return operations;
    }

}
