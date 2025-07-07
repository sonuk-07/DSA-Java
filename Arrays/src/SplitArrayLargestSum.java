// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));  // Example usage
    }

    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        // Initialize start as the maximum element (minimum possible largest sum)
        // Initialize end as the total sum of array (maximum possible largest sum)
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        // Binary search between start and end
        while (start < end) {
            int mid = start + (end - start) / 2;  // Candidate for largest sum
            int sum = 0;
            int pieces = 1;  // Start with one subarray

            // Try to split the array into pieces such that no piece sum exceeds mid
            for (int num : nums) {
                if (sum + num > mid) {
                    // If adding num exceeds mid, start a new subarray
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                // Too many pieces → mid is too small, increase start
                start = mid + 1;
            } else {
                // Fewer or exact pieces → try smaller largest sum
                end = mid;
            }
        }

        // At the end, start == end, which is the minimal largest sum possible
        return end;
    }
}

