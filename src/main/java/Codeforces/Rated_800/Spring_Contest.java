package Codeforces.Rated_800;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Spring_Contest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long m = sc.nextLong();

            System.out.println(litresConsumed(a,b,c,m));
        }
        sc.close();

    }

    private static Integer litresConsumed(long a, long b, long c, long m) {

        int operations = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= m; i++) {

        }

        return operations;
    }


}
