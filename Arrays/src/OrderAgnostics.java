public class OrderAgnostics {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7, 10, 12, 14};
        int target = 6;
        int ans = orderAgnosticBinarySearch(arr, target);
        System.out.println(ans); // Output index of target or -1 if not found
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Check if array is ascending or descending
        boolean isAsc = arr[start] < arr[end];

        // Standard binary search with direction based on sort order
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Target found
            if (arr[mid] == target) return mid;

            if (isAsc) {
                // Ascending order: move left or right
                if (target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                // Descending order: move left or right
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }

        return -1; // Target not found
    }
}
