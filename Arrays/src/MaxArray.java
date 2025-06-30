// MaxArray.java
import java.util.Arrays;

public class MaxArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int ans = max(arr);
        System.out.println("The maximum value of Array is : " + ans);
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}