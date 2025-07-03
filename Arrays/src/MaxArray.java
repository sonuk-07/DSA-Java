
// MaxArray.java
import java.util.Arrays;

public class MaxArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int ans = max(arr);
        System.out.println("The maximum value of Array is : " + ans);
    }

    // Simple approach: Compare each element and keep track of biggest so far
    static int max(int[] arr) {
        int maxi = Integer.MIN_VALUE; // Start with smallest possible value
        for (int num : arr) {
            if (num > maxi) {
                maxi = num; // Found a bigger one, update our best
            }
        }
        return maxi;
    }
}