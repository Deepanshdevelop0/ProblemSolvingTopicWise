package LeetCode.BinarySearch.Miscellaneous;

public class Count_of_Unfinished_Tasks_After_Each_Shift {

    public static void main(String[] args) {
        Count_of_Unfinished_Tasks_After_Each_Shift classObj = new Count_of_Unfinished_Tasks_After_Each_Shift();
        int[] res = classObj.countTasks(new int[]{4,2}, new int[]{3,5,1});

        for (int i : res) {
            System.out.println(i);
        }

    }

    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length, m = shifts.length;
        long[] preSum = new long[n+1];
        int[] res = new int[m];

        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + tasks[i];
        }

        long totalTasksTime = preSum[n];
        long currProgress = 0;

        for (int i = 0; i < m; i++) {
            currProgress += shifts[i];

            if (currProgress >= totalTasksTime) {
                res[i] = 0;
                currProgress = 0;
            }
            else {
                int completedTasks = findCompletedTasks(preSum, currProgress);
                res[i] = n - completedTasks;
            }
        }

        return res;
    }

    public int findCompletedTasks(long[] preSum, long target) {
        int left = 0, right = preSum.length - 1;
        int completed = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (preSum[mid] <= target) {
                completed = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return completed;
    }


}
