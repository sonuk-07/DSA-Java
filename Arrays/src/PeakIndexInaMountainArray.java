/* https://leetcode.com/problems/peak-index-in-a-mountain-array/ */

public class PeakIndexInaMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,1,0};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start < end){
            mid  = start + (end - start)/2;
            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }else if(arr[mid] > arr[mid + 1]){
                end = mid;
            }
        }
        return start;
    }
}
