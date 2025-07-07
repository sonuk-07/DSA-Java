import java.util.Arrays;

public class SortedRowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 37;
        // Print the position of the target element if found
        System.out.println(Arrays.toString(search(matrix, target))); // Expected: [2, 2]
    }

    static int[] search(int[][] matrix, int target) {
        int r = 0;  // Start at the first row
        int c = matrix[0].length - 1;  // Start at the last column (top-right corner)

        // Keep searching while we're inside matrix bounds
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                // Target found, return its position
                return new int[]{r, c};
            }

            if (matrix[r][c] < target) {
                // If current value is smaller than target, move down to a larger value
                r++;
            } else {
                // If current value is larger than target, move left to a smaller value
                c--;
            }
        }

        // Target not found, return {-1, -1}
        return new int[]{-1, -1};
    }
}
