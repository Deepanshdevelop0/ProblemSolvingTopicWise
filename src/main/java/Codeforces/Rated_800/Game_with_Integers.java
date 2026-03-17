package Codeforces.Rated_800;

import java.util.Scanner;

public class Game_with_Integers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter t : ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.println("Enter n : ");
            int n = sc.nextInt();

            System.out.println(findWinner(n));

        }

        sc.close();
    }

    public static String findWinner(int n) {

        if (n % 3 == 0) {
            return "Second";
        }

        return "First";
    }


}
