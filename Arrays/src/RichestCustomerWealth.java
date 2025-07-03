
/* https://leetcode.com/problems/richest-customer-wealth/description/ */

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        int ans = maximumWealth(accounts);
        System.out.println(ans);
    }

    // Find max wealth: sum each row, track the largest sum
    static int maximumWealth(int[][] accounts){
        int max = Integer.MIN_VALUE;
        for(int[] array : accounts){
            int wealth = 0;
            for(int num : array){
                wealth = wealth + num; // Sum current customer's accounts
            }
            if(wealth > max){
                max = wealth; // Update richest customer
            }
        }
        return max;
    }
}