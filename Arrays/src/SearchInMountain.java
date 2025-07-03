/* https://leetcode.com/problems/find-in-mountain-array/description/ */

public class SearchInMountain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 5, 1};
        int target = 5;
        int ans = findInMountainArray(arr, target);
        System.out.println(ans); // Output the index of target or -1 if not found
    }

    // Main function to search target in mountain array
    public static int findInMountainArray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr); // Find peak index
        int firstTry = orderAgnosticBinarySearch(arr, target, 0, peak); // Search in ascending part

        if (firstTry != -1) {
            return firstTry; // Found in ascending part
        }

        // Search in descending part
        return orderAgnosticBinarySearch(arr, target, peak + 1, arr.length - 1);
    }

    // Binary search that works for both ascending and descending parts
    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;

            if (isAsc) {
                if (target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }

        return -1; // Target not found
    }

    // Find the peak index using binary search
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1; // Still going up
            } else {
                end = mid; // Going down, peak might be mid
            }
        }

        return start; // Peak index
    }
}
