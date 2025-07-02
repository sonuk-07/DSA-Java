/* https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/ */

import static java.lang.Math.log10;

public class EvenNumberOfDigits {
    public static void main(String[] args) {
        int[] arr = {2,45,11,2344,45};
        int ans = TotalEvenDigits(arr);
        System.out.println(ans);
    }
    static int TotalEvenDigits(int[] arr){
        int count = 0;
        for(int num : arr){
            if(even(num)) count++;
        }
        return count;
    }
    static boolean even(int num){
        return NoOfDigits(num) % 2 == 0;
    }

    static int NoOfDigits(int num){
        if(num < 0) {
            num = -1 * num;
        }
        return (int) log10(num) +1;
    }
}
