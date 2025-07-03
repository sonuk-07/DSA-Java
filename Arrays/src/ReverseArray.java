// ReverseArray.java
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }

    // Two-pointer approach: swap elements from both ends moving inward
    static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];  // Swap and move pointers
            arr[right--] = temp;
        }
    }
}