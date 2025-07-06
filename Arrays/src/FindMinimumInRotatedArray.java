// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr));  // Output: 1
    }

    static int findMin(int[] nums){
        int pivotIndex = findPivot(nums);
        if(pivotIndex == -1){
            // Array not rotated
            return nums[0];
        }
        // min is right after pivot
        return nums[pivotIndex + 1];
    }

    static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;

            // Check for pivot point
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }

            // Decide direction
            if(nums[start] <= nums[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

