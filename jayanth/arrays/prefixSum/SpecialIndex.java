package jayanth.arrays.prefixSum;

//question:

/*
Given an array, arr[] of size N, 
the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109

Input Format
First argument contains an array A of integers of size N

Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Example Input
Input 1:
A = [2, 1, 6, 4]

Example Output
Output 1:
1

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 

*/

public class SpecialIndex {

    public static void main(String[] args){
        int A[] = {2, 1, 6, 4};
        
        int res = solve(A);

        System.out.println(res);
    }

    public static int solve(int[] A) {
        int n = A.length;
        int even_pSum[] = new int[n];
        int odd_pSum[] = new int[n];

        even_pSum[0] = A[0];
        odd_pSum[0] = 0;
        int count = 0;
        int oddSum = 0;
        int evenSum = 0;

        for(int i = 1; i < n; i++){
            if(i % 2 == 0){
                even_pSum[i] = even_pSum[i - 1] + A[i];
                odd_pSum[i] = odd_pSum[i - 1];
            }else{
                odd_pSum[i] = odd_pSum[i - 1] + A[i];
                even_pSum[i] = even_pSum[i - 1];
            }
        }

        for(int i = 0; i < n; i++){
            if(i == 0){
                oddSum = even_pSum[n - 1];
                evenSum = odd_pSum[n - 1];
            }else{
                oddSum = odd_pSum[i - 1] + (even_pSum[ n - 1] - even_pSum[i]);
                evenSum = even_pSum[i - 1] + (odd_pSum[n - 1] - odd_pSum[i]);
            }

            if(evenSum == oddSum){
                count++;
            }
        }

        return count;

    }
}
