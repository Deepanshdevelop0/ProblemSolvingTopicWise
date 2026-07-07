package LeetCode.BinarySearch.Answers;

public class Capacity_To_Ship_Packages_Within_D_Days {

    public static void main(String[] args) {

        Capacity_To_Ship_Packages_Within_D_Days classObj = new Capacity_To_Ship_Packages_Within_D_Days();

        int res1 = classObj.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
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

            if (canShipWithinDays(weights, days, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private boolean canShipWithinDays(int[] weights, int days, long mid) {

        long currentCapacity = 0;
        int currentDay = 1;

        for (int weight : weights) {
            if (currentCapacity + weight > mid) {
                currentDay++;
                currentCapacity = weight;
            }
            else {
                currentCapacity += weight;
            }
        }

        return currentDay <= days;
    }

}
