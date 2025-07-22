import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {42, 7, 19, 3, 25, 13, 8};
        int[] ans = bubbleSort(arr);
        System.out.println(Arrays.toString(ans));

    }
    static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    static int[] bubbleSort(int[] arr){
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                    isSwapped = true;
                }
            }
            if (! isSwapped){
                break;
            }
        }
        return arr;
    }

}
