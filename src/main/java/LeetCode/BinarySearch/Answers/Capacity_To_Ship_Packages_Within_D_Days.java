package LeetCode.BinarySearch.Answers;

public class Capacity_To_Ship_Packages_Within_D_Days {

    public static void main(String[] args) {

        Capacity_To_Ship_Packages_Within_D_Days classObj = new Capacity_To_Ship_Packages_Within_D_Days();

        int res1 = classObj.shipWithinDays(new int[]{44,22,33,11,1}, 5);
        System.out.println("result : " + res1);
    }

    public int shipWithinDays(int[] weights, int days) {

        long low = 0, high = 0; // low = max of array, high = sum of all elements

        for (int i : weights) {
            low = Math.max(low, i);
            high += i;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;



        }


    }

}
