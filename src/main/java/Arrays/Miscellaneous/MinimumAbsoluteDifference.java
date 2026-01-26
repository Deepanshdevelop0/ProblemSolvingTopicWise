package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        MinimumAbsoluteDifference classObj = new MinimumAbsoluteDifference();
        classObj.minimumAbsDifference(new int[]{4, 2, 1, 3}).forEach(i -> {
            for (int ele : i) {
                System.out.print(ele + " ");
            }
            System.out.println();
        });

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {

            int currDiff = arr[i + 1] - arr[i];

            if (currDiff < minDiff) {
                minDiff = currDiff;

                list.clear();

                list.add(List.of(arr[i], arr[i + 1]));
            } else if (currDiff == minDiff) {
                list.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return list;
    }

}
