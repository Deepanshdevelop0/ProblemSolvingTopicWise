package Codeforces.Rated_800;

import java.util.Scanner;

public class Passing_The_Ball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter n : ");
            int n = sc.nextInt();
            System.out.println("Enter s : ");
            sc.nextLine();

            // 3. Read the string of length n
            String s = sc.nextLine();

            System.out.println(studentsRecievingBall(n, s));

        }

        sc.close();
    }

    private static int studentsRecievingBall(int n, String s) {

        int count = 1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

}
