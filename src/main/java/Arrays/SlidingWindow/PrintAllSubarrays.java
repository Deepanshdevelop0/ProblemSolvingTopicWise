package Arrays.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubarrays {

    public static void main(String[] args) {

        PrintAllSubarrays classObj = new PrintAllSubarrays();
        List<List<Integer>> res = classObj.getSubArrays(new int[]{1, 2, 3});

        res.forEach(list -> {
                    list.forEach(i -> {
                        System.out.print(i + ", ");
                    });
                    System.out.println();
                }
        );
    }

    public List<List<Integer>> getSubArrays(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j++) {
                list.add(arr[j]);
                res.add(new ArrayList<>(list));
            }
        }

        return res;
    }

}
