package LeetCode.BinarySearch.OneD_Array;

public class Count_of_Unfinished_Tasks_After_Each_Shift {

    public static void main(String[] args) {
        Count_of_Unfinished_Tasks_After_Each_Shift classObj = new Count_of_Unfinished_Tasks_After_Each_Shift();
        int[] res = classObj.countTasks(new int[]{1, 4, 4},new int[]{9,1,4});
//        int[] res = classObj.countTasks(new int[]{1,1,3,3,8},new int[]{2,9,5,3,9});

        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length, m = shifts.length;

        long[] preSum = new long[n+1];

        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + tasks[i];
        }

        long totalTasksTime = preSum[n];

        int[] res = new int[m];
        long currentProgress = 0;

        for (int i = 0; i < m; i++) {

            currentProgress += shifts[i];

            if (currentProgress >= totalTasksTime) {
                res[i] = 0;
                currentProgress = 0;
            }
            else {
                int completedTasks = binarySearch(preSum, currentProgress);
                res[i] = n - completedTasks;
            }
        }

        return res;
    }

    public int binarySearch(long[] preSum, long target) {
        int left = 0, right = preSum.length - 1;
        int completed = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (preSum[mid] <= target) {
                left = mid + 1;
                completed = mid;
            }
            else {
                right = mid - 1;
            }
        }

        return completed;
    }




}
