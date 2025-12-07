package BinarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{1,2,4,5,6,7,0};

        SearchInRotatedSortedArray classObj = new SearchInRotatedSortedArray();

        classObj.search(nums, 0);

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

}
