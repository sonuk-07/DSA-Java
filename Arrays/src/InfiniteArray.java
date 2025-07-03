public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 7, 9, 13, 18, 25, 30, 33, 39, 44, 47, 50, 52, 55}; // Imagine this continues infinitely
        int target = 52;
        int result = findPosition(arr, target);
        System.out.println("Target found at index: " + result);
    }

    static int findPosition(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // Find the range where target might exist
        while (isValidIndex(arr, end) && target > arr[end]) {
            start = end + 1;
            end = end * 2; // Exponential growth
        }

        // If end is out of bounds, adjust it
        if (!isValidIndex(arr, end)) {
            // Binary search to find the actual end of array
            int left = start;
            int right = end;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isValidIndex(arr, mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            end = left - 1; // Last valid index
        }

        return binarySearch(arr, target, start, end);
    }

    static boolean isValidIndex(int[] arr, int index) {
        try {
            int dummy = arr[index];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}