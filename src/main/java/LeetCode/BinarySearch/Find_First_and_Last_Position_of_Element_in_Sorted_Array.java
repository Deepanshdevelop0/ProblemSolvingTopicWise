package LeetCode.BinarySearch;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static void main(String[] args) {
        Find_First_and_Last_Position_of_Element_in_Sorted_Array classObj = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
//        int[] res = classObj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] res = classObj.searchRange(new int[]{1, 4}, 4);
        System.out.println("res : " + res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                break;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }

        left = mid;
        right = mid;  // expand the window of target

        while (left - 1 >= 0 && nums[left-1] == target) {
            left--;
        }


        while (right + 1 < n && nums[right+1] == target) {
            right++;
        }


        return (nums[mid] == target) ? new int[]{left, right} : new int[]{-1, -1};
    }

}
