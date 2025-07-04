// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 0, 1, 2};
        int target = 1;
        System.out.println(search(arr, target));  // Expected: 7
    }

    // Main search function for rotated sorted array (no duplicates)
    static int search(int[] arr, int target) {
        int pivot = findPivot(arr);

        // If no rotation (pivot == -1), array is fully sorted → normal binary search
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        // If target is the largest element (pivot itself)
        if (arr[pivot] == target) {
            return pivot;
        }

        // Decide which side to search:
        // Left side is from index 0 to pivot - 1 (sorted)
        // Right side is from pivot + 1 to end (sorted)
        if (target >= arr[0]) {
            // If target >= first element → target is in left sorted part
            return binarySearch(arr, target, 0, pivot - 1);
        } else {
            // Else target is in right sorted part
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
    }

    // Find the index of the pivot (the largest element before the rotation point)
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is pivot (greater than next element)
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Check if mid-1 is pivot (smaller than previous element)
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Decide where to search:
            // If mid >= start → left part is sorted, pivot must be on right side
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                // Else pivot is on the left side
                end = mid - 1;
            }
        }

        // No pivot found → array is not rotated
        return -1;
    }

    // Standard binary search in a sorted portion of array
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // Target is on the right side
                start = mid + 1;
            } else {
                // Target is on the left side
                end = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
