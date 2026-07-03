package LeetCode.BinarySearch.Answers;

import java.util.Arrays;

public class Koko_Eating_Bananas {

    public static void main(String[] args) {
        Koko_Eating_Bananas solution = new Koko_Eating_Bananas();

//        int[] piles = {8, 11, 18, 20};
//        int h = 10;
//        int result = solution.minEatingSpeed(piles, h);


        int[] arr1 = {3, 6, 7, 11};
        int h1 = 18;
        int result1 = solution.minEatingSpeed(arr1, h1);

        System.out.println("Minimum value of X will be : " + result1);

        int[] piles2 = {312884470};
        int h2 = 968709470;
        int result2 = solution.minEatingSpeed(piles2, h2);

        System.out.println("Minimum value of X will be : " + result2);

    }



    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int low = 0, high = max;

        while (low <= high) {
            if (high <= 1) break;

            int mid = (low + high) / 2;
            int reqTime = 0;

            for (int i : piles) {
                reqTime += (i + mid - 1) / mid; // find the ceil value as 7/2 = 3.0, but we need 7 + 2 - 1 / 2 = 4.0
            }

            if (reqTime <= h) {
                max = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return max;
    }

}
