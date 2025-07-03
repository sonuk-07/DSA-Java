/* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/ */

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target  = 6;
        int[] postions = searchRange(nums,target);
        System.out.println(Arrays.toString(postions));;

    }

    // Main idea: Run binary search twice to find both positions
    public static int[]  searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = searchPosition(nums,target,true);  // Find leftmost position
        int lastPosition = searchPosition(nums,target,false);  // Find rightmost position
        return new int[] {firstPosition,lastPosition};
    }

    // The trick: When we find target, don't stop! Keep searching for better position
    static int searchPosition(int[] nums, int target, boolean isFirst){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }else {
                ans = mid; // Found it! But there might be more...
                if(isFirst){
                    end = mid - 1; // Look left for an even earlier occurrence
                }else {
                    start = mid + 1; // Look right for an even later occurrence
                }
            }
        }
        return ans;
    }
}