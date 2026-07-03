package LeetCode.BinarySearch.OneD_Array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{1,2,4,5,6,7,0};
        int[] nums2 = new int[]{5,1,3};
        int[] nums3 = new int[]{1,3};
        int[] nums4 = new int[]{3,1};

        SearchInRotatedSortedArray classObj = new SearchInRotatedSortedArray();

        int res = classObj.searchI(nums4, 1);

        System.out.println(res);

    }


    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && nums[right] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }

            }
            else if (nums[mid] <= nums[right]) {

                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    // Practice
    public int searchI(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {  // right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

}
