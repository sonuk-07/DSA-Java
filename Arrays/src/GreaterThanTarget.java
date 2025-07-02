// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

public class GreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'x','x','y','y'};
        char target = 'c';
        char ans = nextGreatestLetter(letters,target);
        System.out.println(ans);
    }
    static char nextGreatestLetter(char[] letters,char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }
}
