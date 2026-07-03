package LeetCode.BinarySearch.Answers;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {

    public static void main(String[] args) {
        Minimum_Number_of_Days_to_Make_m_Bouquets classObj = new Minimum_Number_of_Days_to_Make_m_Bouquets();
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int result = classObj.minDays(arr, m, k);
        System.out.println(result);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;

        int low = 1, high = 0;

        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0, flowers = 0;


        for (int day : bloomDay) {
            if (day <= days) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                flowers = 0;
            }
        }


        return false;
    }

}
