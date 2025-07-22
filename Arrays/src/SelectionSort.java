import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {42, 7, 19, 3, 25, 13, 8};
        int[] ans = selectionSort(arr); // Sorting using max-based selection sort
        System.out.println(Arrays.toString(ans));
    }

    // Swaps elements at index a and b
    static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    // Returns index of max element between start and end (inclusive)
    // Remember: end is included (use <= not <)
    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end ; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    // Selection Sort using max element approach
    static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;     // Last index of current unsorted part
            int max = getMaxIndex(arr, 0, last);
            swap(arr, max, last);              // Place max at correct position
        }
        return arr;
    }
}
