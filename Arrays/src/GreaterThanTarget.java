// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

public class GreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'x','x','y','y'};
        char target = 'c';
        char ans = nextGreatestLetter(letters,target);
        System.out.println(ans);
    }

    // Goal: Find the smallest letter that's bigger than target
    static char nextGreatestLetter(char[] letters,char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1; // Current letter is too small, go right
            } else {
                end = mid - 1; // Found bigger letter, but look for even smaller one on left
            }
        }

        // Smart trick: If no letter is greater, wrap around to first letter
        return letters[start % letters.length];
    }
}